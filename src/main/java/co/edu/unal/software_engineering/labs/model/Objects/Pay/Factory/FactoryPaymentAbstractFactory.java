package co.edu.unal.software_engineering.labs.model.Objects.Pay.Factory;

import co.edu.unal.software_engineering.labs.model.Balance;
import co.edu.unal.software_engineering.labs.model.Interfaces.PaymentState;
import co.edu.unal.software_engineering.labs.model.Objects.Pay.State.OutStanding;
import co.edu.unal.software_engineering.labs.model.Objects.Pay.State.PaidOut;
import co.edu.unal.software_engineering.labs.model.Objects.Pay.State.PartialPayment;

public  class FactoryPaymentAbstractFactory {
    private  static PaymentState paidOut;
    private static PaymentState partialPayment;
    private static PaymentState outStanding;
    public static PaymentState getState(Balance saldo){

        switch ((int)(saldo.getPercentage()*100)){
            case 100:
                if(paidOut==null)
                    paidOut=new PaidOut();
                return paidOut;
            case 0:
                if(outStanding==null)
                    outStanding=new OutStanding();
                return outStanding;

            default:
                if(partialPayment==null)
                    partialPayment=new PartialPayment();
                return partialPayment;
        }
    }
}
