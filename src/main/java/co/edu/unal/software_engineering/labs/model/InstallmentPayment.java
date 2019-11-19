package co.edu.unal.software_engineering.labs.model;

import java.util.List;

public class InstallmentPayment extends PaymentMethod {
    private static double interest=0.05;
    public InstallmentPayment(){
     }


    @Override
    public Integer getId() {
        return this.id;
    }

    @Override
    public void setId(Integer id) {
    this.id=id;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
    this.name=name;
    }

    @Override
    public List<Pay> getPays() {
        return this.Pays;
    }

    @Override
    public void setPays(List<Pay> pays) {
    this.Pays=pays;
    }


    @Override
    public Integer MoneyToPay(Integer amount) {
        return(int)( amount*(1-interest));
    }
}
