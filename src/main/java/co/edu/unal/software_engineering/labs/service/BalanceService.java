package co.edu.unal.software_engineering.labs.service;

import co.edu.unal.software_engineering.labs.model.Balance;
import co.edu.unal.software_engineering.labs.repository.BalanceRepository;
import org.springframework.stereotype.Service;

import javax.swing.plaf.basic.BasicViewportUI;

@Service
public class BalanceService {
    private BalanceRepository balanceRepository;
    public BalanceService( BalanceRepository balanceRepository){
        this.balanceRepository=balanceRepository;
    }
    public void save(Balance balance){
       this.balanceRepository.save(balance);
    }
}
