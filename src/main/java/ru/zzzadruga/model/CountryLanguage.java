package ru.zzzadruga.model;

import java.io.Serializable;
import java.util.Objects;
import org.apache.ignite.cache.query.annotations.QuerySqlField;

public class CountryLanguage implements Serializable {
    @QuerySqlField
    private int id;
    @QuerySqlField
    private String countryCode;
    @QuerySqlField
    private String language;
    @QuerySqlField
    private Boolean isOfficial;
    @QuerySqlField
    private Float percentage;

    public CountryLanguage(int id, String countryCode, String language, Boolean isOfficial, Float percentage) {
        this.id = id;
        this.countryCode = countryCode;
        this.language = language;
        this.isOfficial = isOfficial;
        this.percentage = percentage;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Boolean getOfficial() {
        return isOfficial;
    }

    public void setOfficial(Boolean official) {
        isOfficial = official;
    }

    public Float getPercentage() {
        return percentage;
    }

    public void setPercentage(Float percentage) {
        this.percentage = percentage;
    }

    @Override public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof CountryLanguage))
            return false;
        CountryLanguage language1 = (CountryLanguage)o;
        return getId() == language1.getId() &&
            Objects.equals(getCountryCode(), language1.getCountryCode()) &&
            Objects.equals(getLanguage(), language1.getLanguage()) &&
            Objects.equals(isOfficial, language1.isOfficial) &&
            Objects.equals(getPercentage(), language1.getPercentage());
    }

    @Override public int hashCode() {

        return Objects.hash(getId(), getCountryCode(), getLanguage(), isOfficial, getPercentage());
    }

    @Override public String toString() {
        return "CountryLanguage{" +
            "id=" + id +
            ", countryCode='" + countryCode + '\'' +
            ", language='" + language + '\'' +
            ", isOfficial=" + isOfficial +
            ", percentage=" + percentage +
            '}';
    }
}
