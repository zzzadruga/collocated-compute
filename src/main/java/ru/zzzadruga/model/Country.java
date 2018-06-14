package ru.zzzadruga.model;

import java.io.Serializable;
import java.util.Objects;
import org.apache.ignite.cache.query.annotations.QuerySqlField;

public class Country implements Serializable {
    @QuerySqlField
    private String code;
    @QuerySqlField
    private String name;
    @QuerySqlField
    private String continent;
    @QuerySqlField
    private String region;
    @QuerySqlField
    private Float surfaceArea;
    @QuerySqlField
    private Integer indepYear;
    @QuerySqlField
    private Integer population;
    @QuerySqlField
    private Float lifeExpectancy;
    @QuerySqlField
    private Float GNP;
    @QuerySqlField
    private Float GNPOld;
    @QuerySqlField
    private String localName;
    @QuerySqlField
    private String governmentForm;
    @QuerySqlField
    private String headOfState;
    @QuerySqlField
    private String capital;
    @QuerySqlField
    private String code2;

    public Country(String code, String name, String continent, String region, Float surfaceArea,
        Integer indepYear, Integer population, Float lifeExpectancy, Float GNP, Float GNPOld, String localName,
        String governmentForm, String headOfState, String capital, String code2) {
        this.code = code;
        this.name = name;
        this.continent = continent;
        this.region = region;
        this.surfaceArea = surfaceArea;
        this.indepYear = indepYear;
        this.population = population;
        this.lifeExpectancy = lifeExpectancy;
        this.GNP = GNP;
        this.GNPOld = GNPOld;
        this.localName = localName;
        this.governmentForm = governmentForm;
        this.headOfState = headOfState;
        this.capital = capital;
        this.code2 = code2;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public Float getSurfaceArea() {
        return surfaceArea;
    }

    public void setSurfaceArea(Float surfaceArea) {
        this.surfaceArea = surfaceArea;
    }

    public Integer getIndepYear() {
        return indepYear;
    }

    public void setIndepYear(Integer indepYear) {
        this.indepYear = indepYear;
    }

    public Integer getPopulation() {
        return population;
    }

    public void setPopulation(Integer population) {
        this.population = population;
    }

    public Float getLifeExpectancy() {
        return lifeExpectancy;
    }

    public void setLifeExpectancy(Float lifeExpectancy) {
        this.lifeExpectancy = lifeExpectancy;
    }

    public Float getGNP() {
        return GNP;
    }

    public void setGNP(Float GNP) {
        this.GNP = GNP;
    }

    public Float getGNPOld() {
        return GNPOld;
    }

    public void setGNPOld(Float GNPOld) {
        this.GNPOld = GNPOld;
    }

    public String getLocalName() {
        return localName;
    }

    public void setLocalName(String localName) {
        this.localName = localName;
    }

    public String getGovernmentForm() {
        return governmentForm;
    }

    public void setGovernmentForm(String governmentForm) {
        this.governmentForm = governmentForm;
    }

    public String getHeadOfState() {
        return headOfState;
    }

    public void setHeadOfState(String headOfState) {
        this.headOfState = headOfState;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public String getCode2() {
        return code2;
    }

    public void setCode2(String code2) {
        this.code2 = code2;
    }

    @Override public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Country))
            return false;
        Country country = (Country)o;
        return Objects.equals(getCode(), country.getCode()) &&
            Objects.equals(getName(), country.getName()) &&
            Objects.equals(getContinent(), country.getContinent()) &&
            Objects.equals(getRegion(), country.getRegion()) &&
            Objects.equals(getSurfaceArea(), country.getSurfaceArea()) &&
            Objects.equals(getIndepYear(), country.getIndepYear()) &&
            Objects.equals(getPopulation(), country.getPopulation()) &&
            Objects.equals(getLifeExpectancy(), country.getLifeExpectancy()) &&
            Objects.equals(getGNP(), country.getGNP()) &&
            Objects.equals(getGNPOld(), country.getGNPOld()) &&
            Objects.equals(getLocalName(), country.getLocalName()) &&
            Objects.equals(getGovernmentForm(), country.getGovernmentForm()) &&
            Objects.equals(getHeadOfState(), country.getHeadOfState()) &&
            Objects.equals(getCapital(), country.getCapital()) &&
            Objects.equals(getCode2(), country.getCode2());
    }

    @Override public int hashCode() {

        return Objects.hash(getCode(), getName(), getContinent(), getRegion(), getSurfaceArea(), getIndepYear(), getPopulation(), getLifeExpectancy(), getGNP(), getGNPOld(), getLocalName(), getGovernmentForm(), getHeadOfState(), getCapital(), getCode2());
    }

    @Override public String toString() {
        return "Country{" +
            "code='" + code + '\'' +
            ", name='" + name + '\'' +
            ", continent='" + continent + '\'' +
            ", region='" + region + '\'' +
            ", surfaceArea=" + surfaceArea +
            ", indepYear=" + indepYear +
            ", population=" + population +
            ", lifeExpectancy=" + lifeExpectancy +
            ", GNP=" + GNP +
            ", GNPOld=" + GNPOld +
            ", localName='" + localName + '\'' +
            ", governmentForm='" + governmentForm + '\'' +
            ", headOfState='" + headOfState + '\'' +
            ", capital='" + capital + '\'' +
            ", code2='" + code2 + '\'' +
            '}';
    }
}
