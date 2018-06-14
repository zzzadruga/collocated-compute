package ru.zzzadruga.model;

import java.io.Serializable;
import java.util.Objects;
import org.apache.ignite.cache.affinity.AffinityKeyMapped;

public class CountryLanguageKey implements Serializable {
    private Integer id;
    @AffinityKeyMapped
    private String COUNTRYCODE;

    public CountryLanguageKey(Integer id, String COUNTRYCODE) {
        this.id = id;
        this.COUNTRYCODE = COUNTRYCODE;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCOUNTRYCODE() {
        return COUNTRYCODE;
    }

    public void setCOUNTRYCODE(String COUNTRYCODE) {
        this.COUNTRYCODE = COUNTRYCODE;
    }

    @Override public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof CountryLanguageKey))
            return false;
        CountryLanguageKey key = (CountryLanguageKey)o;
        return Objects.equals(getId(), key.getId()) &&
            Objects.equals(getCOUNTRYCODE(), key.getCOUNTRYCODE());
    }

    @Override public int hashCode() {

        return Objects.hash(getId(), getCOUNTRYCODE());
    }

    @Override public String toString() {
        return "CountryLanguageKey{" +
            "id=" + id +
            ", COUNTRYCODE='" + COUNTRYCODE + '\'' +
            '}';
    }
}
