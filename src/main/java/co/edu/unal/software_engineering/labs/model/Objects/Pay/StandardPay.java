package co.edu.unal.software_engineering.labs.model.Objects.Pay;

import co.edu.unal.software_engineering.labs.model.Interfaces.Pay;

public class StandardPay implements Pay {
    private int amount;
    public StandardPay(int  amount){
        this.amount=amount;
    }

    @Override
    public int getAmountToDiscount() {
        return this.amount;
    }

}
