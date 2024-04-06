package com.dawidzjava.SpringHellpDesk.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
public class Client extends User {

    @OneToMany(mappedBy ="client",
            fetch = FetchType.LAZY,
            cascade = {CascadeType.PERSIST, CascadeType.MERGE,
                    CascadeType.DETACH, CascadeType.REFRESH})
    private List<Ticket> tickets;


    public Client() {

    }

    public Client(String userName, String name, String surname, String password, boolean enabled) {
        super(userName, name, surname, password, enabled);
    }

    public Client(String userName, String name, String surname, String password, boolean enabled, Collection<Role> roles) {
        super(userName, name, surname, password, enabled, roles);
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    public void addTicket(Ticket ticket){
        if (tickets==null)tickets=new ArrayList<>();
        tickets.add(ticket);
    }

    @Override
    public String toString() {
        return "Client: " + super.toString();
    }
}
