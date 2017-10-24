package br.com.watering.can.webservice;

import br.com.watering.can.model.Configuration;
import br.com.watering.can.service.ConfigurationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/configuration")
public class ConfigurationWebService {

    @Autowired
    private ConfigurationService configService;

    @RequestMapping(value = "/findall", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
    public ResponseEntity findAll() {
        List<Configuration> configurations = configService.findAll();
        return new ResponseEntity(configurations, HttpStatus.OK);
    }

    @RequestMapping(value = "/update", consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
    public ResponseEntity update(@RequestBody Configuration configuration) {
        Configuration config = configService.save(configuration);
        return new ResponseEntity(config, HttpStatus.OK);
    }
}
