package br.com.watering.can.model;


import javax.persistence.*;

@Entity(name = "CONFIG")
public class Configuration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "TIME_TO_GENERATE_REPORT")
    private Integer timeToGenerateReport;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getTimeToGenerateReport() {
        return timeToGenerateReport;
    }

    public void setTimeToGenerateReport(Integer timeToGenerateReport) {
        this.timeToGenerateReport = timeToGenerateReport;
    }
}
