package co.edu.unal.software_engineering.labs.service;

import co.edu.unal.software_engineering.labs.model.State;
import co.edu.unal.software_engineering.labs.repository.StateRepository;
import org.springframework.stereotype.Service;

@Service
public class StateService {
    private final StateRepository stateRepository;

    public StateService(StateRepository roleRepository) {
        this.stateRepository = roleRepository;
    }
    public State findByName(String name){
       return this.stateRepository.findByName(name);
    }
}
