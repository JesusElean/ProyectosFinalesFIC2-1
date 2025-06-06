/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SQL;

/**
 *
 * @author Jesus
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionDB {
     private String host;
    private int puerto;
    private String baseDatos;
    private String usuario;
    private String contraseña;
    protected Connection conexion;

    public ConexionDB() {
        this.host = "pg-10e770e6-info-6f2f.d.aivencloud.com";
        this.puerto = 22812;
        this.baseDatos = "defaultdb";
        this.usuario = "avnadmin";
        this.contraseña = "AVNS_38nwso6-4xpUrdjfEvA";
        this.conexion=null;
    }

    public ConexionDB(String host, int puerto, String baseDatos, String usuario, String contraseña) {
        this.host = host;
        this.puerto = puerto;
        this.baseDatos = baseDatos;
        this.usuario = usuario;
        this.contraseña = contraseña;
    }

    public boolean conectar() {
        String url = "jdbc:postgresql://" + host + ":" + puerto + "/" + baseDatos;
        try {
            conexion = DriverManager.getConnection(url, usuario, contraseña);
            System.out.println("Conectado a " + baseDatos);
            return true;
        } catch (SQLException e) {
           // System.out.println("Error: " + e.getMessage());
            return false;
        }
    }

    public void desconectar() {
        try {
            if (conexion != null && !conexion.isClosed()) {
                conexion.close();
                System.out.println("Desconectado");
            }
        } catch (SQLException e) {
            System.out.println("Error al desconectar: " + e.getMessage());
        }
    }
}

