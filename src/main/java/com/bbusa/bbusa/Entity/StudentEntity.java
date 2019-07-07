package com.bbusa.bbusa.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "students")
@IdClass(StudentEntity.class)
public class StudentEntity implements Serializable {
    @Id
    private String instructor_id;

    @Id
    private String belt_color;

    private String contract_type;

    @Id
    private String first_name;

    @Id
    private String last_name;

    private int belt_order;

    public StudentEntity(){}

    public StudentEntity(String instructor_id, BeltColor belt_color, ContractType contract_type, String first_name, String last_name){
        this.instructor_id = instructor_id;
        this.belt_color = belt_color.toString();
        this.contract_type = contract_type.toString();
        this.first_name = first_name;
        this.last_name = last_name;
        this.belt_order= belt_color.getValue();
    }
    public int getBelt_color_index() {
        return belt_order;
    }

    public void setBelt_color_index(int belt_color_index) {
        this.belt_order = belt_color_index;
    }

    public void setBelt_color(String belt_color) {
        this.belt_color = belt_color;
    }

    public void setContract_type(String contract_type) {
        this.contract_type = contract_type;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getInstructor_id() {
        return instructor_id;
    }

    public void setInstructor_id(String user_id) {
        this.instructor_id= user_id;
    }

    public String getBelt_color() {
        return belt_color.toString();
    }

    public void setBelt_color(BeltColor belt_color) {
        this.belt_color = belt_color.toString();
    }

    public String getContract_type() {
        return contract_type;
    }

    public void setContract_type(ContractType contract_type) {
        this.contract_type = contract_type.toString();
    }
}
