package kz.aitu.oop.practice.practice006;

import kz.aitu.oop.practice.practice006.data.PostgresDB;
import kz.aitu.oop.practice.practice006.data.interfaces.IDB;
import kz.aitu.oop.practice.practice006.controllers.TrainController;
import kz.aitu.oop.practice.practice006.controllers.LocomotiveController;
import kz.aitu.oop.practice.practice006.repositories.TrainRepo;
import kz.aitu.oop.practice.practice006.repositories.LocomotiveRepo;
import kz.aitu.oop.practice.practice006.repositories.interfaces.ITrainRepo;
import kz.aitu.oop.practice.practice006.repositories.interfaces.ILocomotiveRepo;

public class Main {

    public static void main(String[] args) {
//        String connectionUrl = "jdbc:postgresql://localhost:5432/practice6";
//        Connection con = null;
//        ResultSet rs = null;
//        Statement stmt = null;
//        try {
//            Class.forName("org.postgresql.Driver");
//
//            con = DriverManager.getConnection(connectionUrl, "postgres", "dwrlwine20022E");
//
//            stmt = con.createStatement();
//
//            rs = stmt.executeQuery("select mistake * from users");
//
//            while (rs.next())
//                System.out.println(rs.getInt("id") + "  "
//                        + rs.getString("name") + "  " + rs.getInt("capacity"));
//        }
//        catch (Exception e) {
//            System.out.println("Exception occurred!");
//        } finally {
//
//            try {
//                con.close();
//            } catch (Exception e) {
//                System.out.println("Exception occurred!");
//            }
//        }
//
//        System.out.println("Finished!");

        IDB db = new PostgresDB();
        ITrainRepo repo1 = new TrainRepo(db);
        TrainController controller1 = new TrainController(repo1);
        ILocomotiveRepo repo2 = new LocomotiveRepo(db);
        LocomotiveController controller2 = new LocomotiveController(repo2);
        MyApplication app = new MyApplication(repo1, repo2);
        app.start();
    }
}
