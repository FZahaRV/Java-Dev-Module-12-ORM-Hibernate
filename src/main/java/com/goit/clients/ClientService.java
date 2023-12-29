package com.goit.clients;

import com.goit.generic_dao.Dao;

public class ClientService {
    private Dao<Client> clientDao = new Dao<>(Client.class);
    public void saveClient(Client client) {
        clientDao.save(client);
    }
    public Client findClientById(long id) {
        return clientDao.findById(id);
    }
    public void updateClient(Client client) {
        clientDao.update(client);
    }
    public void deleteClient(Client client) {
        clientDao.delete(client);
    }
}
