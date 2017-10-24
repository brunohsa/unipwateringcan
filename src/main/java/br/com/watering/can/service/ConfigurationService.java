package br.com.watering.can.service;

import br.com.watering.can.model.Configuration;
import br.com.watering.can.repository.ConfigurationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConfigurationService {

    @Autowired
    private ConfigurationRepository configRepository;

    public List<Configuration> findAll(){
        return (List<Configuration>) configRepository.findAll();
    }

    public Configuration save(Configuration configuration){
        return configRepository.save(configuration);
    }
}
