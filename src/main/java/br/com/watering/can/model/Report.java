package br.com.watering.can.model;

import javax.persistence.*;
import java.util.Calendar;

@Entity(name = "REPORT")
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
