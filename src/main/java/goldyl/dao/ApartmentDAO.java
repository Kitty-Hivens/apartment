package goldyl.dao;

import goldyl.model.Apartment;

import java.sql.*;
import java.util.*;

public class ApartmentDAO extends AbstractDAO<Apartment> {

    public ApartmentDAO(Connection connection) {
        super(connection);
    }

    @Override
    public List<Apartment> findAll() throws SQLException {
        String sql = "SELECT * FROM apartments";
        try (Statement st = connection.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            return mapResultSet(rs);
        }
    }

    public List<Apartment> findByPriceRange(double min, double max) throws SQLException {
        String sql = "SELECT * FROM apartments WHERE price BETWEEN ? AND ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setDouble(1, min);
            ps.setDouble(2, max);
            try (ResultSet rs = ps.executeQuery()) {
                return mapResultSet(rs);
            }
        }
    }

    public List<Apartment> findByAreaMoreThan(double minArea) throws SQLException {
        String sql = "SELECT * FROM apartments WHERE area > ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setDouble(1, minArea);
            try (ResultSet rs = ps.executeQuery()) {
                return mapResultSet(rs);
            }
        }
    }

    private List<Apartment> mapResultSet(ResultSet rs) throws SQLException {
        List<Apartment> list = new ArrayList<>();
        while (rs.next()) {
            list.add(new Apartment(
                    rs.getInt("id"),
                    rs.getString("district"),
                    rs.getString("address"),
                    rs.getDouble("area"),
                    rs.getInt("rooms"),
                    rs.getDouble("price")
            ));
        }
        return list;
    }
}
