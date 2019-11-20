package co.edu.unal.software_engineering.labs.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="state",schema = "public")
public class State {
    @Id
    @SequenceGenerator( name = "STATE_ID_GENERATOR",
            sequenceName = "public.state_state_id_seq", allocationSize = 1 )
    @GeneratedValue( strategy = GenerationType.SEQUENCE, generator = "STATE_ID_GENERATOR" )
    @Column( name = "state_id" )
private Integer id;
@Column(name="name")
private String name;
@JsonIgnore//json ignore y mappedby en la entidad que no tiene la llave foranea
@OneToMany(mappedBy = "state")
private List<Association> associations;

    public State(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Association> getAssociations() {
        return associations;
    }

    public void setAssociations(List<Association> associations) {
        this.associations = associations;
    }
}
