package br.com.watering.can.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Calendar;

@Entity(name = "REPORT")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Report {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "DATE")
    private Calendar dateRelease;

    @Column(name = "HUMIDITY")
    private Double humidity;

    @Column(name = "TEMPERATURE")
    private Double temperature;

    public Report() {
        dateRelease = Calendar.getInstance();
    }

    public Long getId() {
        return id;
    }

    public Calendar getDateRelease() {
        return dateRelease;
    }

    public void setDateRelease(Calendar dateRelease) {
        this.dateRelease = dateRelease;
    }

    public Double getHumidity() {
        return humidity;
    }

    public void setHumidity(Double humidity) {
        this.humidity = humidity;
    }

    public Double getTemperature() {
        return temperature;
    }

    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }
}
