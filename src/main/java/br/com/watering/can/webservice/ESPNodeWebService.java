package br.com.watering.can.webservice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
@RequestMapping(value = "esp/node")
public class ESPNodeWebService {

    @RequestMapping(value = "test", method = RequestMethod.GET)
    public ResponseEntity getTest(@RequestParam(value = "code") Integer codigoTeste) {
        if (Objects.nonNull(codigoTeste) && Objects.equals(codigoTeste, 0)) {
            return new ResponseEntity("Success",HttpStatus.OK);
        }
        return new ResponseEntity("Code not find",HttpStatus.BAD_REQUEST);
    }
}
