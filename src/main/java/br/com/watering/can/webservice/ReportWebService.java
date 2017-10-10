package br.com.watering.can.webservice;

import br.com.watering.can.model.Report;
import br.com.watering.can.service.ReportService;
import br.com.watering.can.util.JsonConverterUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping(value = "/report")
public class ReportWebService {

    @Autowired
    private ReportService reportService;

    @RequestMapping(value = "/insert", consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
    public ResponseEntity insert(@RequestParam("report") String jsonReport) {
        try {
            Report report = save(jsonReport);
            return new ResponseEntity(report, HttpStatus.OK);
        } catch (IOException e) {
            return new ResponseEntity(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/update", consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
    public ResponseEntity update(@RequestParam("report") String jsonReport) {
        try {
            Report report = save(jsonReport);
            return new ResponseEntity(report, HttpStatus.OK);
        } catch (IOException e) {
            return new ResponseEntity(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/delete", consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
    public void delete(@RequestParam("id") Long id) {
        reportService.delete(id);
    }

    @RequestMapping(value = "/find", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
    public ResponseEntity findById(@RequestParam("id") Long id) {
        Report report = reportService.findById(id);
        return new ResponseEntity(report, HttpStatus.OK);
    }

    @RequestMapping(value = "/findall", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
    public ResponseEntity findByAll(@RequestParam("id") Long id) {
        List<Report> reports = reportService.findAll();
        return new ResponseEntity(reports, HttpStatus.OK);
    }

    private Report save(String jsonReport) throws IOException {
        Report reportObject = JsonConverterUtil.convertJsonToObject(jsonReport, Report.class);
        return reportService.save(reportObject);
    }
}
