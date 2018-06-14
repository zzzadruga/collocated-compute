package ru.zzzadruga;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import ru.zzzadruga.model.City;
import ru.zzzadruga.model.Country;
import ru.zzzadruga.model.CountryLanguage;

public class DataGenerator {
    private static final String CITIES = "data/cities.txt";
    private static final String COUNTRIES = "data/countries.txt";
    private static final String COUNTRY_LANGUAGES = "data/countryLanguages.txt";

    public static List<City> getCityList() {
        List<City> cities = new ArrayList<>();
        List<String[]> lines = fileReader(CITIES);
        for (String[] line : lines) {
            cities.add(new City(Integer.parseInt(line[0]), line[1], line[2], line[3],
                Integer.parseInt(line[4])));
        }
        return cities;
    }

    public static List<Country> getCountryList() {
        List<Country> countries = new ArrayList<>();
        List<String[]> lines = fileReader(COUNTRIES);
        for (String[] line : lines) {
            countries.add(new Country(line[0], line[1], line[2], line[3],
                line[4].isEmpty() ? null : Float.parseFloat(line[4]),
                line[5].isEmpty() ? null : Integer.parseInt(line[5]),
                line[6].isEmpty() ? null : Integer.parseInt(line[6]),
                line[7].isEmpty() ? null : Float.parseFloat(line[7]),
                line[8].isEmpty() ? null : Float.parseFloat(line[8]),
                line[9].isEmpty() ? null : Float.parseFloat(line[9]),
                line[10], line[11], line[12], line[13], line[14]));
        }
        return countries;
    }

    public static List<CountryLanguage> getCountryLanguagesList() {
        List<CountryLanguage> countryLanguages = new ArrayList<>();
        List<String[]> lines = fileReader(COUNTRY_LANGUAGES);
        int num = 1;
        for (String[] line : lines) {
            countryLanguages.add(new CountryLanguage(num++, line[0], line[1], Boolean.parseBoolean(line[2]),
                Float.parseFloat(line[3])));
        }
        return countryLanguages;
    }

    private static List<String[]> fileReader(String fileName) {
        List<String[]> lines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)))) {
            String line = "";
            while ((line = reader.readLine()) != null) {
                lines.add(line.replace("NULL", "").split(","));
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }
}
