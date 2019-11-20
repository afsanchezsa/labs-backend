package co.edu.unal.software_engineering.labs.model.Objects.Pay.PayDecorators;

import co.edu.unal.software_engineering.labs.model.Interfaces.Pay;
import co.edu.unal.software_engineering.labs.model.Objects.Pay.Abstract.PayDecorator;

public class Interest extends PayDecorator {
    private double value;
    protected Interest(Pay pay,double value) {
        super(pay);
        this.value=value;
    }

    @Override
    public int getAmountToDiscount() {
        return (int)(this.pay.getAmountToDiscount()*(1-value));
    }
}
