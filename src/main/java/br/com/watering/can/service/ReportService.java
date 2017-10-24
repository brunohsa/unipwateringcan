package br.com.watering.can.service;

import br.com.watering.can.model.Report;
import br.com.watering.can.repository.ReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReportService {

    @Autowired
    private ReportRepository reportRepository;

    public Report findById(Long id) {
        return reportRepository.findOne(id);
    }

    public void delete(Long id) {
        reportRepository.delete(id);
    }

    public List<Report> findAll(){
        return (List<Report>) reportRepository.findAll();
    }

    public Report save(Report report) {
        return reportRepository.save(report);
    }
}
