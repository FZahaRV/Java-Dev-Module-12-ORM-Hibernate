package com.goit;

import com.goit.table_entities.clients.Client;
import com.goit.entity_service.EntityService;
import com.goit.hibernate_util.DatabaseUtil;
import com.goit.table_entities.planets.Planet;


public class Main {
    public static void main(String[] args) {
        EntityService<Client> clientService = new EntityService<>(Client.class);
        Client newClient = new Client();
        newClient.setName("John Doe");
        clientService.save(newClient);
        System.out.println(clientService.findById(11L));
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
        DatabaseUtil.getInstance().close();
    }
}
