package com.dawidzjava.SpringHellpDesk.dao;

import com.dawidzjava.SpringHellpDesk.entity.Ticket;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class TicketDaoImpl implements TicketDao{
    private EntityManager entityManager;
    @Autowired
    TicketDaoImpl(EntityManager entityManager){
        this.entityManager=entityManager;
    }
    @Override
    @Transactional
    public void save(Ticket ticket) {
        entityManager.persist(ticket);
    }

    @Override
    @Transactional
    public void update(Ticket ticket) {
        entityManager.merge(ticket);
    }

    @Override
    @Transactional
    public void deleteByID(int id) {
        Ticket ticket = entityManager.find(Ticket.class, id);
        entityManager.remove(ticket);
    }

    @Override
    public Ticket findById(int id) {
        return entityManager.find(Ticket.class, id);
    }


}
