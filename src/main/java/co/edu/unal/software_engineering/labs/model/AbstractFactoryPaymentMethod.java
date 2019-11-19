package co.edu.unal.software_engineering.labs.model;

public class AbstractFactoryPaymentMethod {

public PaymentMethod getPaymentMethod(String paymentMethod,double amount){
    switch (paymentMethod.toLowerCase().trim()){
        case "cashpayment":return new CashPayment();
        case "installmentpayment":return new InstallmentPayment();
        default: return null;
    }
}

}
