package co.edu.unal.software_engineering.labs.model.Objects.Pay.Factory;

import co.edu.unal.software_engineering.labs.model.Objects.Pay.Interfaces.Pay;
import co.edu.unal.software_engineering.labs.model.Objects.Pay.PayDecorators.Interest;
import co.edu.unal.software_engineering.labs.model.Objects.Pay.StandardPay;

public class PayFactory {
    public static Pay getPay(String type, int amount){

        switch (type.toLowerCase().trim()){
            case "cashpayment":
                return new StandardPay(amount);
            case "installmentpayment":
                Pay pay=new StandardPay(amount);
                return new Interest(pay,0.05);
            default:return null;
                    }
    }
}
