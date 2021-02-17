package kz.aitu.oop.practice.practice006.repositories;

import kz.aitu.oop.practice.practice006.data.interfaces.IDB;
import kz.aitu.oop.practice.practice006.entities.Train;
import kz.aitu.oop.practice.practice006.repositories.interfaces.ITrainRepo;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class TrainRepo implements ITrainRepo {
    private final IDB db;

    public TrainRepo(IDB db) { this.db = db; }

    @Override
    public boolean createTrain(Train train) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "INSERT INTO Train(name, id, capacity, locomotiveID) VALUES (?, ?, ?, ?)";
            PreparedStatement st = con.prepareStatement(sql);

            st.setString(1, train.getName());
            st.setInt(2, train.getId());
            st.setInt(3, train.getCapacity());
            st.setInt(4, train.getLocomotiveID());

            boolean executed = st.execute();
            return executed;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                assert con != null;
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public Train getTrain(int id) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT id,name,capacity,locomotiveID FROM Train WHERE id=?";
            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1, id);

            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Train train = new Train(rs.getString("name"),
                        rs.getInt("id"),
                        rs.getInt("capacity"),
                        rs.getInt("locomotiveID"));

                return train;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                assert con != null;
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public List<Train> getAllTrains() {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT id,name,capacity,locomotiveID FROM Train";
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(sql);
            List<Train> trains = new LinkedList<>();
            while (rs.next()) {
                Train train = new Train(rs.getString("name"),
                        rs.getInt("id"),
                        rs.getInt("capacity"),
                        rs.getInt("locomotiveID"));

                trains.add(train);
            }

            return trains;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                assert con != null;
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }
}