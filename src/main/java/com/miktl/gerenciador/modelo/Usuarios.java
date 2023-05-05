package com.miktl.gerenciador.modelo;

public class Usuarios {
	private String nombre;
    private String contrasena;

    public Usuarios(String nombre, String contrasena) {
        this.nombre = nombre;
        this.contrasena = contrasena;
    }

    // Getters
    public String getNombre() {
        return nombre;
    }

    public String getContrasena() {
        return contrasena;
    }

    // Setters
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    // Método que compara si el nombre y contraseña son iguales a los de la clase
    public boolean validarUsuario(String nombre, String contrasena) {
        return this.nombre.equals(nombre) && this.contrasena.equals(contrasena);
    }
}
