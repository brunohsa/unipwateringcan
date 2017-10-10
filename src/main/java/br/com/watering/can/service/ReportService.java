package br.com.watering.can.service;

import br.com.watering.can.model.Report;
import br.com.watering.can.repository.ReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class ReportService  extends GenericService<Report> {

    @Autowired
    private ReportRepository reportRepository;

    @Override
    public CrudRepository getRepository() {
        return reportRepository;
    }
}
