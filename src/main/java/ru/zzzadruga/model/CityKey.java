package ru.zzzadruga.model;

import java.io.Serializable;
import java.util.Objects;
import org.apache.ignite.cache.affinity.AffinityKeyMapped;

public class CityKey implements Serializable {
    private Integer ID;
    @AffinityKeyMapped
    private String COUNTRYCODE;

    public CityKey(Integer ID, String COUNTRYCODE) {
        this.ID = ID;
        this.COUNTRYCODE = COUNTRYCODE;
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
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
        if (!(o instanceof CityKey))
            return false;
        CityKey key = (CityKey)o;
        return Objects.equals(getID(), key.getID()) &&
            Objects.equals(getCOUNTRYCODE(), key.getCOUNTRYCODE());
    }

    @Override public int hashCode() {

        return Objects.hash(getID(), getCOUNTRYCODE());
    }

    @Override public String toString() {
        return "CityKey{" +
            "ID=" + ID +
            ", COUNTRYCODE='" + COUNTRYCODE + '\'' +
            '}';
    }
}
