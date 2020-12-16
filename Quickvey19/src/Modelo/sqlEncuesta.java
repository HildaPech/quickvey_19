package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class sqlEncuesta extends ConexionBD {
    public boolean registrarEncuesta(Encuesta encuesta) {
        PreparedStatement ps = null;
        Connection link = getConexion();
        String sql = "INSERT INTO tbl_encuestas (cNombreEncuesta, lActivo, dtAlta, dtModificacion) VALUES (?, ?, ?, ?)";
        
        try {
            ps = link.prepareStatement(sql);
            
            ps.setString(1, encuesta.getNombreEncuesta());
            ps.setInt(2, encuesta.getActivo());
            ps.setString(3, encuesta.getAlta());
            ps.setString(4, encuesta.getModificacion());
            
            ps.execute();
            
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Se ha producido un error en: " + e, "Error", JOptionPane.ERROR_MESSAGE);;
            
            return false;
        } finally {
            try {
                link.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Se ha producido un error de conexion con la base \n de datos en: " + e, "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    public boolean modificarEncuesta(Encuesta encuesta) {
        PreparedStatement ps = null;
        Connection link = getConexion();
        String sql = "UPDATE tbl_encuestas SET cNombreEncuesta = ?, dtModificacion = ? WHERE iIdEncuesta = ?";
        
        try {
            ps = link.prepareStatement(sql);
            
            ps.setString(1, encuesta.getNombreEncuesta());
            ps.setString(2, encuesta.getModificacion());
            ps.setInt(3, encuesta.getIdEncuesta());
            
            ps.execute();
            
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Se ha producido un error en: " + e, "Error", JOptionPane.ERROR_MESSAGE);
            
            return false;
        } finally {
            try {
                link.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Se ha producido un error de conexion con la base \n de datos en: " + e, "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    public boolean inactivarEncuesta(Encuesta encuesta) {
        PreparedStatement ps = null;
        Connection link = getConexion();
        String sql = "UPDATE tbl_encuestas SET lActivo = ?, dtModificacion = ? WHERE iIdEncuesta = ?";
        
        try {
            ps = link.prepareStatement(sql);
            
            ps.setInt(1, encuesta.getActivo());
            ps.setString(2, encuesta.getModificacion());
            ps.setInt(3, encuesta.getIdEncuesta());
            
            ps.execute();
            
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Se ha producido un error en: " + e, "Error", JOptionPane.ERROR_MESSAGE);
            
            return false;
        } finally {
            try {
                link.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Se ha producido un error de conexion con la base \n de datos en: " + e, "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    public boolean activarEncuesta(Encuesta encuesta) {
        PreparedStatement ps = null;
        Connection link = getConexion();
        String sql = "UPDATE tbl_encuestas SET lActivo = ?, dtModificacion = ? WHERE iIdEncuesta = ?";
        
        try {
            ps = link.prepareStatement(sql);
            
            ps.setInt(1, encuesta.getActivo());
            ps.setString(2, encuesta.getModificacion());
            ps.setInt(3, encuesta.getIdEncuesta());
            
            ps.execute();
            
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Se ha producido un error en: " + e, "Error", JOptionPane.ERROR_MESSAGE);
            
            return false;
        } finally {
            try {
                link.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Se ha producido un error de conexion con la base \n de datos en: " + e, "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    public boolean visualizarEncuesta(Encuesta encuesta) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection link = getConexion();
        String sql = "SELECT * FROM tbl_encuestas WHERE iIdEncuesta = ?";
        
        try {
            ps = link.prepareStatement(sql);
            
            ps.setInt(1, encuesta.getIdEncuesta());
            
            rs = ps.executeQuery();
            
            if (rs.next()) {
                encuesta.setIdEncuesta(Integer.parseInt(rs.getString("iIdEncuesta")));
                encuesta.setNombreEncuesta(rs.getString("cNombreEncuesta"));
                encuesta.setActivo(Integer.parseInt(rs.getString("lActivo")));
                encuesta.setAlta(rs.getString("dtAlta"));
                encuesta.setModificacion(rs.getString("dtModificacion"));
                
                return true;
            }
            
            return false;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Se ha producido un error en: " + e, "Error", JOptionPane.ERROR_MESSAGE);
            
            return false;
        } finally {
            try {
                link.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Se ha producido un error de conexion con la base \n de datos en: " + e, "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}