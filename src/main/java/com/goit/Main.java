package com.goit;

import com.goit.table_entities.clients.Client;
import com.goit.entity_service.EntityService;
import com.goit.hibernate_util.DatabaseUtil;
import com.goit.table_entities.planets.Planet;
import com.goit.table_entities.tickets.Ticket;

public class Main {
    public static void main(String[] args) {
        EntityService<Client> clientService = new EntityService<>(Client.class);
        Client newClient = new Client();
        newClient.setName("John Doe");
        clientService.save(newClient);
        System.out.println(clientService.findById(11L).getName());
        Client client = clientService.findById(1L);
        System.out.println("Found Person: " + client.getName());
        client.setName("Jane Doe");
        clientService.update(client);

        EntityService<Planet> planetService = new EntityService<>(Planet.class);
        Planet newPlanet = new Planet();
        newPlanet.setName("Hypatia");
        newPlanet.setId("HYP");
        planetService.delete(newPlanet);
        planetService.save(newPlanet);
        System.out.println(planetService.findById("HYP"));
        Planet planet = planetService.findById("VEN");
        System.out.println("Found planet: " + planet.getName());
        planet.setName("Ven Us");
        planetService.update(planet);

        EntityService<Ticket> ticketService = new EntityService<>(Ticket.class);
        Ticket newTicket = new Ticket();
        newTicket.setClients(clientService.findById(1L));
        newTicket.setFromPlanet(planetService.findById("MARS"));
        newTicket.setToPlanet(planetService.findById("VEN"));
        ticketService.delete(newTicket);
        ticketService.save(newTicket);
        System.out.println(ticketService.findById(11L));
        Ticket ticket = ticketService.findById(1L);
        System.out.println("Found ticket: " + ticket);
        ticket.setToPlanet(planetService.findById("SATURN"));
        ticketService.update(ticket);
        System.out.println(ticketService.findById(1L));

        DatabaseUtil.getInstance().close();
    }
}
