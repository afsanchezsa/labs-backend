package co.edu.unal.software_engineering.labs.controller;

import co.edu.unal.software_engineering.labs.model.Association;
import co.edu.unal.software_engineering.labs.model.Balance;
import co.edu.unal.software_engineering.labs.model.Interfaces.Pay;
import co.edu.unal.software_engineering.labs.model.Objects.Pay.Factory.PayFactory;
import co.edu.unal.software_engineering.labs.model.PaymentMethod;
import co.edu.unal.software_engineering.labs.service.AssociationService;
import co.edu.unal.software_engineering.labs.service.BalanceService;
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

    public BalanceController(AssociationService associationService, BalanceService balanceService) {
        this.associationService = associationService;
        this.balanceService = balanceService;

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
        associationService.save(association);
        return new ResponseEntity(HttpStatus.CREATED);


        //return new ResponseEntity(HttpStatus.CREATED);
    }
}
