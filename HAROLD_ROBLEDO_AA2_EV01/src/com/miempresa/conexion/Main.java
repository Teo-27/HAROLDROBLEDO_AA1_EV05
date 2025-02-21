package com.miempresa.conexion;

public class Main {
    public static void main(String[] args) {
        UsuarioDAO usuarioDAO = new UsuarioDAO();

        // Insertar un usuario
        usuarioDAO.insertarUsuario("Felipe Benavides", "fb1234@hotmail.com");

        // Listar usuarios
        usuarioDAO.listarUsuarios();

        // Actualizar usuario
        usuarioDAO.actualizarUsuario(1, "Felipe Actualizado", "felipe.actualizado@gmail.com");

        // Eliminar usuario
        usuarioDAO.eliminarUsuario(1);
    }
}
