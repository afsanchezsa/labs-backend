package co.edu.unal.software_engineering.labs.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table( name = "state", schema = "public" )
public interface State {

    Integer getId();
    String getName();
}
