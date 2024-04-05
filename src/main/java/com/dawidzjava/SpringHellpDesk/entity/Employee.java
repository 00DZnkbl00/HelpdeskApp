package com.dawidzjava.SpringHellpDesk.entity;

import jakarta.persistence.Entity;

import java.util.Collection;

@Entity
public class Employee extends User{

    public Employee() {
    }

    public Employee(String userName, String name, String surname, String password, boolean enabled) {
        super(userName, name, surname, password, enabled);
    }

    public Employee(String userName, String name, String surname, String password, boolean enabled, Collection<Role> roles) {
        super(userName, name, surname, password, enabled, roles);
    }

    @Override
    public String toString() {
        return "Employee{} " + super.toString();
    }
}
