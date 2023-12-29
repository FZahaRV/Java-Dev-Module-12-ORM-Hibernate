package com.goit.planets;

import com.goit.generic_dao.Dao;

public class PlanetService {
    private Dao<Planet> planetDao = new Dao<>(Planet.class);
    public void savePlanet(Planet planet) {
        planetDao.save(planet);
    }
    public Planet findClientById(String id) {
        return planetDao.findById(id);
    }
    public void updatePlanet(Planet planet) {
        planetDao.update(planet);
    }
    public void deletePlanet(Planet planet) {
        planetDao.delete(planet);
    }
}
