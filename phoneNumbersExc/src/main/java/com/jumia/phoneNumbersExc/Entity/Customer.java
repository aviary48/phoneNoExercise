package com.jumia.phoneNumbersExc.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Customer {


    @Id
    @Column(name = "id", length = 50, unique = true , columnDefinition = "int")
    public int id;
    @Column(name = "name", length = 50 )
    public String name;
    @Column(name = "phone", length = 50 )
    public String phone;




    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }







}
