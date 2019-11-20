package co.edu.unal.software_engineering.labs.controller;

import co.edu.unal.software_engineering.labs.model.Association;
import co.edu.unal.software_engineering.labs.model.Balance;
import co.edu.unal.software_engineering.labs.model.Interfaces.Pay;
import co.edu.unal.software_engineering.labs.model.Interfaces.PaymentState;
import co.edu.unal.software_engineering.labs.model.Objects.Pay.Factory.FactoryPaymentAbstractFactory;
import co.edu.unal.software_engineering.labs.model.Objects.Pay.Factory.PayFactory;
import co.edu.unal.software_engineering.labs.model.PaymentMethod;
import co.edu.unal.software_engineering.labs.model.State;
import co.edu.unal.software_engineering.labs.repository.StateRepository;
import co.edu.unal.software_engineering.labs.service.AssociationService;
import co.edu.unal.software_engineering.labs.service.BalanceService;
import co.edu.unal.software_engineering.labs.service.StateService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class BalanceController {
    private AssociationService associationService;
    private BalanceService balanceService;
    private StateService stateService;

    public BalanceController(AssociationService associationService, BalanceService balanceService, StateService stateService) {
        this.associationService = associationService;
        this.balanceService = balanceService;
        this.stateService = stateService;
    }

    @PostMapping( value = { "/pago/{associationId}/{money}" } )
    public ResponseEntity registerNewUser(@PathVariable Integer associationId, @PathVariable Integer money ){
 //Association as=associationService.findById(associationId);


        //System.out.println(as.getId());
           Association association=associationService.findById(associationId);
        if(money<0){
            return new ResponseEntity( HttpStatus.BAD_REQUEST );
        }

        Pay pay= PayFactory.getPay(association.getPaymentMethod().getName(),money);
        Balance balance=association.getBalance();
        System.out.println(balance.toString());
        balance.setBalance_payed(balance.getBalance_payed()+pay.getAmountToDiscount());

        PaymentState state=FactoryPaymentAbstractFactory.getState(balance);
        State newState= this.stateService.findByName(state.getName());
        System.out.println("the state is :"+newState.getName());
        System.out.println(balance.getBalance_payed());
        System.out.println(balance.getPercentage());
        System.out.println(state.getName());
        association.setState(newState);
        associationService.save(association);
        return new ResponseEntity(HttpStatus.CREATED);


        //return new ResponseEntity(HttpStatus.CREATED);
    }
}
