package co.edu.unal.software_engineering.labs.model.Objects.Pay.Abstract;

import co.edu.unal.software_engineering.labs.model.Objects.Pay.Interfaces.Pay;

public abstract class PayDecorator implements Pay {
    protected  Pay pay;
    protected PayDecorator(Pay pay){
        this.pay=pay;
    }

}
