package kz.aitu.oop.practice.practice006.controllers;


import kz.aitu.oop.practice.practice006.entities.Locomotive;
import kz.aitu.oop.practice.practice006.repositories.interfaces.ILocomotiveRepo;
import kz.aitu.oop.practice.practice006.repositories.interfaces.ITrainRepo;

import java.util.List;

public class LocomotiveController {
    private final ILocomotiveRepo repo;

    public LocomotiveController(ILocomotiveRepo repo) {
        this.repo = repo;
    }

    public String createLocomotive(String name, int id) {
        Locomotive locomotive = new Locomotive(name, id);

        boolean created = repo.createLocomotive(locomotive);

        return (created ? "Locomotive was created!" : "Locomotive creation was failed!");
    }

    public String getLocomotive(int id) {
        Locomotive locomotive = repo.getLocomotive(id);

        return (locomotive == null ? "Locomotive was not found!" : locomotive.toString());
    }

    public String getAllLocomotives() {
        List<Locomotive> locomotives = repo.getAllLocomotives();

        return locomotives.toString();
    }
}

