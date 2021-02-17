package kz.aitu.oop.practice.practice006.repositories;

import kz.aitu.oop.practice.practice006.data.interfaces.IDB;
import kz.aitu.oop.practice.practice006.entities.Locomotive;
import kz.aitu.oop.practice.practice006.repositories.interfaces.ILocomotiveRepo;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class LocomotiveRepo implements ILocomotiveRepo {
    private final IDB db;

    public LocomotiveRepo(IDB db) { this.db = db; }

    @Override
    public boolean createLocomotive(Locomotive locomotive) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "INSERT INTO Locomotive(name, id) VALUES (?, ?)";
            PreparedStatement st = con.prepareStatement(sql);

            st.setString(1, locomotive.getName());
            st.setInt(2, locomotive.getId());

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
    public Locomotive getLocomotive(int id) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT id,name FROM Locomotive WHERE id=?";
            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1, id);

            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Locomotive locomotive = new Locomotive(rs.getString("name"),
                        rs.getInt("id"));


                return locomotive;
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
    public List<Locomotive> getAllLocomotives() {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT id, name FROM Locomotive";
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(sql);
            List<Locomotive> locomotives = new LinkedList<>();
            while (rs.next()) {
                Locomotive locomotive = new Locomotive(rs.getString("name"),
                        rs.getInt("id"));

                locomotives.add(locomotive);
            }

            return locomotives;
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
