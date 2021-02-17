package kz.aitu.oop.practice.practice006;

import kz.aitu.oop.practice.practice006.controllers.TrainController;
import kz.aitu.oop.practice.practice006.controllers.LocomotiveController;
import kz.aitu.oop.practice.practice006.repositories.LocomotiveRepo;
import kz.aitu.oop.practice.practice006.repositories.interfaces.ILocomotiveRepo;
import kz.aitu.oop.practice.practice006.repositories.interfaces.ITrainRepo;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MyApplication {
    private final TrainController controller1;
    private final LocomotiveController controller2;
    private final Scanner scanner;

    public MyApplication(ITrainRepo trainRepo, ILocomotiveRepo locomotiveRepo) {
        controller1 = new TrainController(trainRepo);
        controller2 = new LocomotiveController(locomotiveRepo);
        scanner = new Scanner(System.in);
    }

    public void start() {
        while (true) {
            System.out.println();
            System.out.println("Welcome to My Application");
            System.out.println("Select option:");
            System.out.println("1. Get all trains");
            System.out.println("2. Get train by id");
            System.out.println("3. Create train");
            System.out.println("4. Get all locomotives");
            System.out.println("5. Get locomotive by id");
            System.out.println("6. Create locomotive");
            System.out.println("0. Exit");
            System.out.println();
            try {
                System.out.print("Enter option (1-6): ");
                int option = scanner.nextInt();
                if (option == 1) {
                    getAllTrainsMenu();
                } else if (option == 2) {
                    getTrainByIdMenu();
                } else if (option == 3) {
                    createTrainMenu();
                } else if (option == 4) {
                    getAllLocomotivesMenu();
                } else if (option == 5) {
                    getLocomotiveByIdMenu();
                } else if (option == 6) {
                    createLocomotiveMenu();
                } else {
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Input must be integer");
                scanner.nextLine();
            }
            catch (Exception e) {
                System.out.println(e.getMessage());
            }

            System.out.println("*************************");

        }
    }

    public void getAllTrainsMenu() {
        String response = controller1.getAllTrains();
        System.out.println(response);
    }

    public void getTrainByIdMenu() {
        System.out.println("Please enter id");
        int id = scanner.nextInt();
        String response = controller1.getTrain(id);
        System.out.println(response);
    }

    public void createTrainMenu() {
        System.out.println("Please enter name");
        String name = scanner.next();
        System.out.println("Please enter id");
        int id = scanner.nextInt();
        System.out.println("Please enter capacity");
        int capacity = scanner.nextInt();
        System.out.println("Please enter locomotiveID");
        int locomotiveID = scanner.nextInt();
        String response = controller1.createTrain(name, id, capacity, locomotiveID);
        System.out.println(response);
    }

    public void getAllLocomotivesMenu() {
        String response = controller2.getAllLocomotives();
        System.out.println(response);
    }

    public void getLocomotiveByIdMenu() {
        System.out.println("Please enter id");
        int id = scanner.nextInt();
        String response = controller2.getLocomotive(id);
        System.out.println(response);
    }

    public void createLocomotiveMenu() {
        System.out.println("Please enter name");
        String name = scanner.next();
        System.out.println("Please enter id");
        int id = scanner.nextInt();
        String response = controller2.createLocomotive(name, id);
        System.out.println(response);
    }
}