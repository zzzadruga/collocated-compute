package ru.zzzadruga;

import java.util.List;
import org.apache.ignite.Ignite;
import org.apache.ignite.IgniteCache;
import org.apache.ignite.cache.CacheMode;
import org.apache.ignite.configuration.CacheConfiguration;
import ru.zzzadruga.model.City;
import ru.zzzadruga.model.CityKey;
import ru.zzzadruga.model.Country;
import ru.zzzadruga.model.CountryLanguage;
import ru.zzzadruga.model.CountryLanguageKey;

public class CacheGenerator {
    public static IgniteCache<String, Country> createCountryCache(Ignite ignite) {
        CacheConfiguration<String, Country> cfg = new CacheConfiguration()
            .setName(Country.class.getSimpleName())
            .setCacheMode(CacheMode.PARTITIONED)
            .setIndexedTypes(String.class, Country.class);
        IgniteCache<String, Country> cache = ignite.getOrCreateCache(cfg);
        return initCountryCache(cache);
    }

    private static IgniteCache<String, Country> initCountryCache(IgniteCache<String, Country> cache) {
        List<Country> countries = DataGenerator.getCountryList();
        for (Country country : countries) {
            cache.put(country.getCode(), country);
        }
        return cache;
    }

    public static IgniteCache<CityKey, City> createCityCache(Ignite ignite) {
        CacheConfiguration<CityKey, City> cfg = new CacheConfiguration()
            .setName(City.class.getSimpleName())
            .setCacheMode(CacheMode.PARTITIONED)
            .setIndexedTypes(CityKey.class, City.class);
        IgniteCache<CityKey, City> cache = ignite.getOrCreateCache(cfg);
        return initCityCache(cache);
    }

    private static IgniteCache<CityKey, City> initCityCache(IgniteCache<CityKey, City> cache) {
        List<City> cities = DataGenerator.getCityList();
        for (City city : cities) {
            cache.put(new CityKey(city.getId(), city.getCountryCode()), city);
        }
        return cache;
    }

    public static IgniteCache<CountryLanguageKey, CountryLanguage> createCountryLanguageCache(Ignite ignite) {
        CacheConfiguration<CountryLanguageKey, CountryLanguage> cfg = new CacheConfiguration()
            .setName(CountryLanguage.class.getSimpleName())
            .setCacheMode(CacheMode.PARTITIONED)
            .setIndexedTypes(CountryLanguageKey.class, CountryLanguage.class);
        IgniteCache<CountryLanguageKey, CountryLanguage> cache = ignite.getOrCreateCache(cfg);
        return initCountryLanguageCache(cache);
    }

    private static IgniteCache<CountryLanguageKey, CountryLanguage> initCountryLanguageCache(
        IgniteCache<CountryLanguageKey, CountryLanguage> cache) {
        List<CountryLanguage> countryLanguages = DataGenerator.getCountryLanguagesList();
        for (CountryLanguage countryLanguage : countryLanguages) {
            cache.put(new CountryLanguageKey(countryLanguage.getId(),
                countryLanguage.getCountryCode()), countryLanguage);
        }
        return cache;
    }

}
