package kz.aitu.oop.practice.practice006.entities;

public class Locomotive {
    private static int id;
    private static String name;

    public Locomotive() {
    }

    public Locomotive(String name) {
        setName(name);
    }

    public Locomotive(String name, int id) {
        setId(id);
        setName(name);
    }

    public static int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Locomotive {" + "id=" + getId() + ", name=" + getName() + "}";
    }
}