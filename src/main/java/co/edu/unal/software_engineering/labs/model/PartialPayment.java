package co.edu.unal.software_engineering.labs.model;

import java.util.List;

public class PartialPayment extends State {
    public PartialPayment(){
        id=2;
        name="partialpayment";
    }

    @Override
    public Integer getId() {
        return this.id;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    List<Association> getAssociations() {
        return this.associations;
    }

    @Override
    public void setId(Integer id) {
    this.id=id;
    }

    @Override
    public void setName(String name) {
    this.name=name;
    }

    @Override
    public void setAssociations(List<Association> associations) {
    this.associations=associations;
    }
}
