package com.miempresa.conexion;

import java.sql.Connection;

public class TestConexion {
    public static void main(String[] args) {
        Connection conn = DatabaseConnection.getConnection();
        if (conn != null) {
            System.out.println("🎉 Conexión establecida correctamente.");
        } else {
            System.out.println("⚠️ No se pudo conectar.");
        }
    }
}