package com.dawidzjava.SpringHellpDesk.entity;

import jakarta.persistence.Entity;

import java.util.Collection;

@Entity
public class Client extends User {


    public Client() {

    }

    public Client(String userName, String name, String surname, String password, boolean enabled) {
        super(userName, name, surname, password, enabled);
    }

    public Client(String userName, String name, String surname, String password, boolean enabled, Collection<Role> roles) {
        super(userName, name, surname, password, enabled, roles);
    }

    @Override
    public String toString() {
        return "Client: " + super.toString();
    }
}
