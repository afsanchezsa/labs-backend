package co.edu.unal.software_engineering.labs.model;

import java.util.List;

public class PaidOut extends State {
    public PaidOut(){
        this.id=1;
        this.name="paidout";
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    List<Association> getAssociations() {
        return associations;
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
