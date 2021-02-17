package kz.aitu.oop.practice.practice006.repositories.interfaces;

import kz.aitu.oop.practice.practice006.entities.Locomotive;

import java.util.List;

public interface ILocomotiveRepo {
    boolean createLocomotive(Locomotive locomotive);
    Locomotive getLocomotive(int id);
    List<Locomotive> getAllLocomotives();
}