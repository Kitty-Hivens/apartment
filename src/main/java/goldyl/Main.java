package goldyl;

import goldyl.dao.ApartmentDAO;
import goldyl.model.Apartment;

import java.sql.*;
import java.util.List;

public class Main {
    static void main() {
        String url = "jdbc:mariadb://localhost:3306/apartments_db";
        String user = "takumi-haru";
        String password = "password";

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            ApartmentDAO dao = new ApartmentDAO(conn);

            System.out.println("Все квартиры:");
            print(dao.findAll());

            System.out.println("\nЦена от 30000 до 70000:");
            print(dao.findByPriceRange(30000, 70000));

            System.out.println("\nПлощадь более 50 м²:");
            print(dao.findByAreaMoreThan(50));

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void print(List<Apartment> list) {
        if (list.isEmpty()) {
            System.out.println("(ничего не найдено)");
        } else {
            list.forEach(System.out::println);
        }
    }
}
