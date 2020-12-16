package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ConexionBD {
    private final String BaseDatos = "quickvey19";
    private final String Usuario = "root";
    private final String Password = "";
    private final String URL = "jdbc:mysql://localhost:3306/" + BaseDatos + "?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";
    private Connection link = null;
    
    public Connection getConexion() {
        try {
            this.link = (Connection) DriverManager.getConnection(this.URL, this.Usuario, this.Password);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Se ha producido un error de conexion con la base \n de datos en: " + e, "Error", JOptionPane.ERROR_MESSAGE);
        }
        return this.link;
    }
}