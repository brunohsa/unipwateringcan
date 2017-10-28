package br.com.watering.can.webservice;

import br.com.watering.can.model.Report;
import br.com.watering.can.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping(value = "/report")
public class ReportWebService {

    @Autowired
    private ReportService reportService;

    @RequestMapping(value = "/{humidity}/{temperature}/insert", method = RequestMethod.GET)
    public ResponseEntity insert(@PathVariable("humidity") Double humidity, @PathVariable("temperature") Double temperature) {
        Report report = new Report(humidity, temperature);
        if (report == null) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        reportService.save(report);
        return new ResponseEntity(report, HttpStatus.OK);
    }

    @RequestMapping(value = "/delete/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") Long id) {
        reportService.delete(id);
    }

    @RequestMapping(value = "/find/{id}", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
    public ResponseEntity findById(@PathVariable("id") Long id) {
        Report report = reportService.findById(id);
        return new ResponseEntity(report, HttpStatus.OK);
    }

    @RequestMapping(value = "/findall", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
    public ResponseEntity findAll() {
        List<Report> reports = reportService.findAll();
        return new ResponseEntity(reports, HttpStatus.OK);
    }
}
