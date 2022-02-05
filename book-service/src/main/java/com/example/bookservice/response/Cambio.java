package com.example.bookservice.response;

import java.io.Serializable;

public class Cambio implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String from;
    private String to;
    private Double conversionFactor;
    private Double convertedValue;
    private String environment;

    public Cambio() {
    }

    public Cambio(
            Long id,
            String from,
            String to,
            Double conversionFactor,
            Double convertedValue,
            String environment
    ) {
        this.id = id;
        this.from = from;
        this.to = to;
        this.conversionFactor = conversionFactor;
        this.convertedValue = convertedValue;
        this.environment = environment;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public Double getConversionFactor() {
        return conversionFactor;
    }

    public void setConversionFactor(Double conversionFactor) {
        this.conversionFactor = conversionFactor;
    }

    public Double getConvertedValue() {
        return convertedValue;
    }

    public void setConvertedValue(Double convertedValue) {
        this.convertedValue = convertedValue;
    }

    public String getEnvironment() {
        return environment;
    }

    public void setEnvironment(String environment) {
        this.environment = environment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cambio cambio = (Cambio) o;

        if (id != null ? !id.equals(cambio.id) : cambio.id != null) return false;
        if (from != null ? !from.equals(cambio.from) : cambio.from != null) return false;
        if (to != null ? !to.equals(cambio.to) : cambio.to != null) return false;
        if (conversionFactor != null ? !conversionFactor.equals(cambio.conversionFactor) : cambio.conversionFactor != null)
            return false;
        if (convertedValue != null ? !convertedValue.equals(cambio.convertedValue) : cambio.convertedValue != null)
            return false;
        return environment != null ? environment.equals(cambio.environment) : cambio.environment == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (from != null ? from.hashCode() : 0);
        result = 31 * result + (to != null ? to.hashCode() : 0);
        result = 31 * result + (conversionFactor != null ? conversionFactor.hashCode() : 0);
        result = 31 * result + (convertedValue != null ? convertedValue.hashCode() : 0);
        result = 31 * result + (environment != null ? environment.hashCode() : 0);
        return result;
    }
}
