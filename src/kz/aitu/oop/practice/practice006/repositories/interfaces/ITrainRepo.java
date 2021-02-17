package kz.aitu.oop.practice.practice006.repositories.interfaces;

import kz.aitu.oop.practice.practice006.entities.Train;

import java.util.List;

public interface ITrainRepo {
    boolean createTrain(Train train);
    Train getTrain(int id);
    List<Train> getAllTrains();
}

