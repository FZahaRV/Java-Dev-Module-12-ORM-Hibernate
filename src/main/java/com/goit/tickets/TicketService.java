package com.goit.tickets;

import com.goit.generic_dao.Dao;

public class TicketService {
    private Dao<Ticket> ticketDao = new Dao<>(Ticket.class);
    public void savePlanet(Ticket ticket) {
        ticketDao.save(ticket);
    }
    public Ticket findClientById(Long id) {
        return ticketDao.findById(id);
    }
    public void updateClient(Ticket ticket) {
        ticketDao.update(ticket);
    }
    public void deleteClient(Ticket ticket) {
        ticketDao.delete(ticket);
    }
}
