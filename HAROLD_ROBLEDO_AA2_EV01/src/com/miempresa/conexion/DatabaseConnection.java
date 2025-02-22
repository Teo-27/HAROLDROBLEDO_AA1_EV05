package com.miempresa.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/hafenisanbd";
    private static final String USER = "root";  // Cambia por tu usuario de MySQL
    private static final String PASSWORD = "";  // Cambia por tu contraseña

    public static Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("✅ Conexión exitosa a la base de datos.");
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("❌ Error en la conexión: " + e.getMessage());
        }
        return conn;
    }
}