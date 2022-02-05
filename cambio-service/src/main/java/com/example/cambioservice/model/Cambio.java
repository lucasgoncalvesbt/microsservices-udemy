package com.example.cambioservice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity(name = "cambio")
public class Cambio implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "from_currency", nullable = false, length = 3)
    private String from;

    @Column(name = "to_currency", nullable = false, length = 3)
    private String to;

    @Column(nullable = false)
    private BigDecimal conversionFactor;

    @Transient
    private BigDecimal convertedValue;

    @Transient
    private String environment;

    public Cambio() {
    }

    public Cambio(
            Long id,
            String from,
            String to,
            BigDecimal conversionFactor,
            BigDecimal convertedValue,
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

    public BigDecimal getConversionFactor() {
        return conversionFactor;
    }

    public void setConversionFactor(BigDecimal conversionFactor) {
        this.conversionFactor = conversionFactor;
    }

    public BigDecimal getConvertedValue() {
        return convertedValue;
    }

    public void setConvertedValue(BigDecimal convertedValue) {
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
