package kz.aitu.oop.practice.practice006.controllers;

import kz.aitu.oop.practice.practice006.entities.Train;
import kz.aitu.oop.practice.practice006.repositories.interfaces.ILocomotiveRepo;
import kz.aitu.oop.practice.practice006.repositories.interfaces.ITrainRepo;

import java.util.List;

public class TrainController {
    private final ITrainRepo repo;

    public TrainController(ITrainRepo repo) {
        this.repo = repo;
    }

    public String createTrain(String name, int id, int capacity, int locomotiveID) {
        Train train = new Train(name, id, capacity, locomotiveID);

        boolean created = repo.createTrain(train);

        return (created ? "Train was created!" : "Train creation was failed!");
    }

    public String getTrain(int id) {
        Train train = repo.getTrain(id);

        return (train == null ? "Train was not found!" : train.toString());
    }

    public String getAllTrains() {
        List<Train> trains = repo.getAllTrains();

        return trains.toString();
    }
}