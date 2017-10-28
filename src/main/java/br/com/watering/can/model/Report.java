package br.com.watering.can.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Date;

@Entity(name = "REPORT")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Report {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "DATE")
    private Date dateRelease;

    @Column(name = "HUMIDITY")
    private Double humidity;

    @Column(name = "TEMPERATURE")
    private Double temperature;

    public Report() {
    }

    public Report(Double humidity, Double temperature) {
        this.dateRelease = Calendar.getInstance().getTime();
        this.humidity = humidity;
        this.temperature = temperature;
    }

    public Long getId() {
        return id;
    }

    public Date getDateRelease() {
        return dateRelease;
    }

    public void setDateRelease(Date dateRelease) {
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
