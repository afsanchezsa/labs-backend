package co.edu.unal.software_engineering.labs.controller;

import co.edu.unal.software_engineering.labs.model.Association;
import co.edu.unal.software_engineering.labs.model.Balance;
import co.edu.unal.software_engineering.labs.model.Objects.Pay.Interfaces.Pay;
import co.edu.unal.software_engineering.labs.model.Objects.Pay.Interfaces.PaymentState;

import co.edu.unal.software_engineering.labs.model.Objects.Pay.Factory.PayFactory;
import co.edu.unal.software_engineering.labs.model.Objects.Pay.Factory.PaymentStateFactory;
import co.edu.unal.software_engineering.labs.model.State;
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
    public ResponseEntity registerPay(@PathVariable Integer associationId, @PathVariable Integer money ){

           Association association=associationService.findById(associationId);
        if(!balanceService.correctMoney(money)){
            return new ResponseEntity( HttpStatus.BAD_REQUEST );
        }
        Pay pay= PayFactory.getPay(association.getPaymentMethod().getName(),money);
        Balance balance=association.getBalance();
        if(!balanceService.isValidDiscount(balance,pay.getAmountToDiscount())){
            return new ResponseEntity(HttpStatus.CONFLICT);
        }
        balance.setBalance_payed(balance.getBalance_payed()+pay.getAmountToDiscount());
        PaymentState state= PaymentStateFactory.getState(balance);
        State newState= this.stateService.findByName(state.getName());
        association.setState(newState);
        associationService.save(association);

        return new ResponseEntity(balance,HttpStatus.OK);



    }
}
