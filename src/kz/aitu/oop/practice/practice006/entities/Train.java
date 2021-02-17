package kz.aitu.oop.practice.practice006.entities;

public class Train {
    private int id;
    private String name;
    private int capacity;
    private int LocomotiveID;

    public Train(String name, int capacity, int locomotiveID){
        setName(name);
        setCapacity(capacity);
        setLocomotiveID(locomotiveID);
    }

    public Train(String name, int id, int capacity, int locomotiveID){
        setId(id);
        setName(name);
        setCapacity(capacity);
        setLocomotiveID(locomotiveID);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getLocomotiveID() {
        return LocomotiveID;
    }

    public void setLocomotiveID(int LocomotiveID) {
        this.LocomotiveID = LocomotiveID;
    }

    @Override
    public String toString() {
        return "Train {" + "id=" + getId() + ", name=" + getName() + ", capacity=" + getCapacity() +
                ", locomotiveID=" + getLocomotiveID() + "}";
    }
}
