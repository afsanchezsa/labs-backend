package co.edu.unal.software_engineering.labs.model;

import java.util.List;

public class Interest extends RecargoDecorator {
    private double discountToApply;
    public Interest(PaymentMethod paymentMethod,double discountToApply){
        super(paymentMethod);
        this.discountToApply=discountToApply;

    }


    @Override
    public Integer getId() {
        return null;
    }

    @Override
    public void setId(Integer id) {

    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public void setName(String name) {

    }

    @Override
    public List<Pay> getPays() {
        return null;
    }

    @Override
    public void setPays(List<Pay> pays) {

    }

    @Override
    public Integer MoneyToPay(Integer amount) {
        return 0;
    }
}
