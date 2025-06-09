/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SQL;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;



/**
 *
 * @author Jesus
 */
public class Movimiento {
        private int idMovimiento;
    private int idCuenta;
    private String tipo; // 'D' para depósito, 'R' para retiro
    private double cantidad;
    private String fecha; // Se almacena como String, pero la BD usa TIMESTAMP

    // Constructor vacío
    public Movimiento() {}

    // Constructor con parámetros
    public Movimiento(int idCuenta, String tipo, double cantidad) {
        this.idCuenta = idCuenta;
        this.tipo = tipo;
        this.cantidad = cantidad;
    }

    // Getters y Setters
    public int getIdMovimiento() {
        return idMovimiento;
    }

    public void setIdMovimiento(int idMovimiento) {
        this.idMovimiento = idMovimiento;
    }

    public int getIdCuenta() {
        return idCuenta;
    }

    public void setIdCuenta(int idCuenta) {
        this.idCuenta = idCuenta;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    // Método para insertar un nuevo movimiento
    public boolean insertar() {
        String sql = "INSERT INTO movimientos (id_cuenta, tipo, cantidad) VALUES (?, ?, ?)";

        try (Connection conn = ConexionDB.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idCuenta);
            stmt.setString(2, tipo);
            stmt.setDouble(3, cantidad);

            return stmt.executeUpdate() > 0;
        } catch (SQLException ex) {
            System.out.println("Error al insertar movimiento: " + ex.getMessage());
            return false;
        }
    }

    // Método para actualizar un movimiento
    public boolean actualizar() {
        String sql = "UPDATE movimientos SET tipo = ?, cantidad = ? WHERE id_movimientos = ?";

        try (Connection conn = ConexionDB.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, tipo);
            stmt.setDouble(2, cantidad);
            stmt.setInt(3, idMovimiento);

            return stmt.executeUpdate() > 0;
        } catch (SQLException ex) {
            System.out.println("Error al actualizar movimiento: " + ex.getMessage());
            return false;
        }
    }

    // Método para eliminar un movimiento por ID
    public boolean eliminar() {
        String sql = "DELETE FROM movimientos WHERE id_movimientos = ?";

        try (Connection conn = ConexionDB.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idMovimiento);

            return stmt.executeUpdate() > 0;
        } catch (SQLException ex) {
            System.out.println("Error al eliminar movimiento: " + ex.getMessage());
            return false;
        }
    }

    // Método para buscar un movimiento por ID
    public boolean buscar() {
        String sql = "SELECT * FROM movimientos WHERE id_movimientos = ?";

        try (Connection conn = ConexionDB.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idMovimiento);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                this.idCuenta = rs.getInt("id_cuenta");
                this.tipo = rs.getString("tipo");
                this.cantidad = rs.getDouble("cantidad");
                this.fecha = rs.getString("fecha");
                return true;
            }
        } catch (SQLException ex) {
            System.out.println("Error al buscar movimiento: " + ex.getMessage());
        }
        return false;
    }

    // Método para obtener todos los movimientos de una cuenta específica
    public DefaultTableModel listadoPorCuenta(int idCuenta) {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("ID Movimiento");
        modelo.addColumn("ID Cuenta");
        modelo.addColumn("Tipo");
        modelo.addColumn("Cantidad");
        modelo.addColumn("Fecha");

        String sql = "SELECT * FROM movimientos WHERE id_cuenta = ? ORDER BY fecha DESC";

        try (Connection conn = ConexionDB.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idCuenta);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Object[] fila = new Object[5];
                fila[0] = rs.getInt("id_movimientos");
                fila[1] = rs.getInt("id_cuenta");
                fila[2] = rs.getString("tipo");
                fila[3] = rs.getDouble("cantidad");
                fila[4] = rs.getString("fecha");
                modelo.addRow(fila);
            }
        } catch (SQLException ex) {
            System.out.println("Error al obtener listado de movimientos: " + ex.getMessage());
        }

        return modelo;
    }
}

