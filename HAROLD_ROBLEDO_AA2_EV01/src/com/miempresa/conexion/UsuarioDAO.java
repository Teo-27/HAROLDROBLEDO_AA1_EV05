package com.miempresa.conexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDAO {
    private Connection conn;

    public UsuarioDAO() {
        this.conn = DatabaseConnection.getConnection();
    }

    // 🔹 Insertar Usuario
    public void insertarUsuario(String nombre, String email) {
        String query = "INSERT INTO users (nombre, correo) VALUES (?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, nombre);
            stmt.setString(2, email);
            stmt.executeUpdate();
            System.out.println("✅ Usuario insertado correctamente.");
        } catch (SQLException e) {
            System.out.println("❌ Error al insertar usuario: " + e.getMessage());
        }
    }

    // 🔹 Leer Usuarios
    public void listarUsuarios() {
        String query = "SELECT * FROM users";
        try (PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id") + 
                                   " | nombre: " + rs.getString("nombre") + 
                                   " | correo: " + rs.getString("correo"));
            }
        } catch (SQLException e) {
            System.out.println("❌ Error al listar usuarios: " + e.getMessage());
        }
    }

    // 🔹 Actualizar Usuario
    public void actualizarUsuario(int id, String nuevoNombre, String nuevoEmail) {
        String query = "UPDATE users SET nombre = ?, correo = ? WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, nuevoNombre);
            stmt.setString(2, nuevoEmail);
            stmt.setInt(3, id);
            stmt.executeUpdate();
            System.out.println("✅ Usuario actualizado correctamente.");
        } catch (SQLException e) {
            System.out.println("❌ Error al actualizar usuario: " + e.getMessage());
        }
    }

    // 🔹 Eliminar Usuario
    public void eliminarUsuario(int id) {
        String query = "DELETE FROM users WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("✅ Usuario eliminado correctamente.");
        } catch (SQLException e) {
            System.out.println("❌ Error al eliminar usuario: " + e.getMessage());
        }
    }
    
}