package br.com.watering.can.webservice;

import br.com.watering.can.model.Configuration;
import br.com.watering.can.service.ConfigurationService;
import br.com.watering.can.util.JsonConverterUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
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
    public ResponseEntity update(@RequestParam("config") String json) {
        Configuration configuration = null;
        try {
            configuration = JsonConverterUtil.convertJsonToObject(json, Configuration.class);
        } catch (IOException e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        configService.save(configuration);
        return new ResponseEntity(configuration, HttpStatus.OK);
    }
}
