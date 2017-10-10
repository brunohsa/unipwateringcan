package br.com.watering.can.service;

import br.com.watering.can.model.Configuration;
import br.com.watering.can.repository.ConfigurationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class ConfigurationService extends GenericService<Configuration> {

    @Autowired
    private ConfigurationRepository configRepository;

    @Override
    public CrudRepository getRepository() {
        return configRepository;
    }
}
