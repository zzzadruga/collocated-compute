package ru.zzzadruga.model;

import java.io.Serializable;
import java.util.Objects;
import org.apache.ignite.cache.query.annotations.QuerySqlField;

public class City implements Serializable {
    @QuerySqlField
    private Integer id;
    @QuerySqlField
    private String name;
    @QuerySqlField
    private String countryCode;
    @QuerySqlField
    private String district;
    @QuerySqlField
    private Integer population;

    public City(Integer id, String name, String countryCode, String district, Integer population) {
        this.id = id;
        this.name = name;
        this.countryCode = countryCode;
        this.district = district;
        this.population = population;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public Integer getPopulation() {
        return population;
    }

    public void setPopulation(Integer population) {
        this.population = population;
    }

    @Override public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof City))
            return false;
        City city = (City)o;
        return Objects.equals(getId(), city.getId()) &&
            Objects.equals(getName(), city.getName()) &&
            Objects.equals(getCountryCode(), city.getCountryCode()) &&
            Objects.equals(getDistrict(), city.getDistrict()) &&
            Objects.equals(getPopulation(), city.getPopulation());
    }

    @Override public int hashCode() {

        return Objects.hash(getId(), getName(), getCountryCode(), getDistrict(), getPopulation());
    }

    @Override public String toString() {
        return "City{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", countryCode='" + countryCode + '\'' +
            ", district='" + district + '\'' +
            ", population=" + population +
            '}';
    }
}
