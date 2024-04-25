package dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class SingletonConnection {

    private static Connection connection;

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/DB_CATAL", "root", "");
        } catch (Exception e) {
            // Gestion de l'erreur de manière plus appropriée
            System.err.println("Erreur lors de la connexion à la base de données : " + e.getMessage());
            e.printStackTrace();
            // Arrêt de l'exécution du programme dans le cas d'une erreur de connexion
            System.exit(1);
        }
    }

    public static Connection getConnection() {
        return connection;
    }
}
