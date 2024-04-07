package com.dawidzjava.SpringHellpDesk.dao;

import com.dawidzjava.SpringHellpDesk.entity.Role;
import com.dawidzjava.SpringHellpDesk.entity.Ticket;
import jakarta.persistence.EntityManager;

public interface TicketDao {
    public void save(Ticket ticket);

    void update(Ticket ticket);

    void deleteByID(int id);

    Ticket findById(int id);
}
