package co.edu.unal.software_engineering.labs.model;

public class AbstractFactoryState  {
    private static State Paidout;
    private static State partialPayment;
    private static State OutStanding;

    public State getState(String name){
        switch(name.toLowerCase().trim()){
            case "paidout":
                if(Paidout==null)
                    Paidout=new PaidOut();
                return Paidout;
            case "partialpaymenth":
                if(partialPayment==null)
                    partialPayment=new PartialPayment();
                return partialPayment;
            case "outstanding":
                if(OutStanding==null)
                    OutStanding=new OutStanding();
                return OutStanding;
            default:
                return null;

        }
    }
}
