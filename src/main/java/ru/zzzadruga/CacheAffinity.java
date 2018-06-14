package ru.zzzadruga;

import java.util.Arrays;
import org.apache.ignite.Ignite;
import org.apache.ignite.IgniteCache;
import org.apache.ignite.Ignition;
import org.apache.ignite.binary.BinaryObject;
import org.apache.ignite.cache.query.SqlFieldsQuery;
import org.apache.ignite.lang.IgniteRunnable;
import org.apache.ignite.resources.IgniteInstanceResource;
import ru.zzzadruga.model.City;
import ru.zzzadruga.model.Country;
import ru.zzzadruga.model.CountryLanguage;

public class CacheAffinity {
    public static void main(String[] args) {
        try (Ignite ignite = Ignition.start("config/simple-client-config.xml")) {
            CacheGenerator.createCountryCache(ignite);
            CacheGenerator.createCountryLanguageCache(ignite);
            CacheGenerator.createCityCache(ignite);

            String affinityKey = "USA";
            long start = System.currentTimeMillis();
            runNonCollocatedComputation(ignite, affinityKey);
            System.out.println("Non-Collocated computation: " + (System.currentTimeMillis() - start) + " ms");

            start = System.currentTimeMillis();
            runCollocatedComputation(ignite, affinityKey);
            System.out.println("Collocated computation: " + (System.currentTimeMillis() - start) + " ms");

        }
    }

    private static void runCollocatedComputation(Ignite ignite, String affinityKey) {
        ignite.compute().affinityRun(Arrays.asList("Country", "City", "CountryLanguage"),
            affinityKey, new IgniteJob(affinityKey, true));
    }

    private static void runNonCollocatedComputation(Ignite ignite, String affinityKey) {
        ignite.compute().run(new IgniteJob(affinityKey, false));

    }

    private static class IgniteJob implements IgniteRunnable {
        private String affinityKey;
        private boolean local;

        public IgniteJob(String affinityKey, boolean local) {
            this.affinityKey = affinityKey;
            this.local = local;
        }

        @IgniteInstanceResource
        Ignite ignite;

        @Override
        public void run() {
            IgniteCache<String, BinaryObject> countries = ignite.cache(Country.class.getSimpleName()).withKeepBinary();

            BinaryObject country = countries.get(affinityKey);

            System.out.println("Country: " + ((Country)country.deserialize()));

            IgniteCache<BinaryObject, BinaryObject> cities = ignite.cache(City.class.getSimpleName()).withKeepBinary();

            SqlFieldsQuery query =
                new SqlFieldsQuery("SELECT count(*) FROM City WHERE countryCode=?").setArgs(affinityKey);

            query.setLocal(local);

            System.out.println("Number of cities: " + cities.query(query).getAll().get(0));

            IgniteCache<BinaryObject, BinaryObject> countryLanguages =
                ignite.cache(CountryLanguage.class.getSimpleName()).withKeepBinary();

            query = new SqlFieldsQuery("SELECT count(*) FROM CountryLanguage WHERE countryCode=?").setArgs(affinityKey);

            query.setLocal(local);

            System.out.println("Number of languages: " + countryLanguages.query(query).getAll().get(0));

        }
    }
}
