package com.goit;

import com.goit.clients.Client;
import com.goit.clients.ClientService;
import com.goit.hibernate_util.DatabaseUtil;
import com.goit.planets.Planet;
import com.goit.planets.PlanetService;


public class Main {
    public static void main(String[] args) {
        ClientService clientService = new ClientService();
        Client newClient = new Client();
        newClient.setName("John Doe");
        clientService.saveClient(newClient);
        System.out.println(clientService.findClientById(11L));
        Client client = clientService.findClientById(1L);
        System.out.println("Found Person: " + client.getName());
        client.setName("Jane Doe");
        clientService.updateClient(client);

        PlanetService planetService = new PlanetService();
        Planet newPlanet = new Planet();
        newPlanet.setName("Hypatia");
        newPlanet.setId("HYP");
        planetService.deletePlanet(newPlanet);
        planetService.savePlanet(newPlanet);
        System.out.println(planetService.findClientById("HYP"));
        Planet planet = planetService.findClientById("VEN");
        System.out.println("Found planet: " + planet.getName());
        planet.setName("Ven Us");
        planetService.updatePlanet(planet);
        DatabaseUtil.getInstance().close();
    }
}
