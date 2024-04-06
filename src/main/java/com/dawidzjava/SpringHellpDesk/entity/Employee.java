package com.dawidzjava.SpringHellpDesk.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
public class Employee extends User{

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {CascadeType.PERSIST, CascadeType.MERGE,
                    CascadeType.DETACH, CascadeType.REFRESH})
    @JoinTable(
            name = "ticket_employee",
            joinColumns = @JoinColumn(name = "employee_id"),
            inverseJoinColumns = @JoinColumn(name = "ticket_id")
    )
    private List<Ticket> tickets;

    public Employee() {
    }

    public Employee(String userName, String name, String surname, String password, boolean enabled) {
        super(userName, name, surname, password, enabled);
    }

    public Employee(String userName, String name, String surname, String password, boolean enabled, Collection<Role> roles) {
        super(userName, name, surname, password, enabled, roles);
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    public void addTicket(Ticket ticket){
        if (tickets==null) tickets=new ArrayList<>();
        tickets.add(ticket);
    }

    @Override
    public String toString() {
        return "Employee{} " + super.toString();
    }
}
