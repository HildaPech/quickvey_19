package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class sqlEncuestaActiva extends ConexionBD {
    public boolean registrarEncuestaActiva(EncuestaActiva encuesta) {
        PreparedStatement ps = null;
        Connection link = getConexion();
        String sql = "INSERT INTO tbl_encuestasactivas (iIdEncuesta, dtInicioVigencia, dtFinVigencia, lActivo, dtAlta, dtModificacion) VALUES (?, ?, ?, ?, ?, ?)";
        
        try {
            ps = link.prepareStatement(sql);
            
            ps.setInt(1, encuesta.getIdEncuesta());
            ps.setString(2, encuesta.getInicioVigencia());
            ps.setString(3, encuesta.getFinVigencia());
            ps.setInt(4, encuesta.getActivo());
            ps.setString(5, encuesta.getAlta());
            ps.setString(6, encuesta.getModificacion());
            
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
    
    public boolean modificarEncuestaActiva(EncuestaActiva encuesta) {
        PreparedStatement ps = null;
        Connection link = getConexion();
        String sql = "UPDATE tbl_encuestasactivas SET iIdEncuesta = ?, dtInicioVigencia = ?, dtFinVigencia = ?, dtModificacion = ? WHERE iIdEncuestaActiva = ?";
        
        try {
            ps = link.prepareStatement(sql);
            
            ps.setInt(1, encuesta.getIdEncuesta());
            ps.setString(2, encuesta.getInicioVigencia());
            ps.setString(3, encuesta.getFinVigencia());
            ps.setString(4, encuesta.getModificacion());
            ps.setInt(5, encuesta.getIdEncuestaActiva());
            
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
    
    public boolean inactivarEncuestaActiva(EncuestaActiva encuesta) {
        PreparedStatement ps = null;
        Connection link = getConexion();
        String sql = "UPDATE tbl_encuestasactivas SET lActivo = ?, dtModificacion = ? WHERE iIdEncuestaActiva = ?";
        
        try {
            ps = link.prepareStatement(sql);
            
            ps.setInt(1, encuesta.getActivo());
            ps.setString(2, encuesta.getModificacion());
            ps.setInt(3, encuesta.getIdEncuestaActiva());
            
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
    
    public boolean activarEncuestaActiva(EncuestaActiva encuesta) {
        PreparedStatement ps = null;
        Connection link = getConexion();
        String sql = "UPDATE tbl_encuestasactivas SET lActivo = ?, dtModificacion = ? WHERE iIdEncuestaActiva = ?";
        
        try {
            ps = link.prepareStatement(sql);
            
            ps.setInt(1, encuesta.getActivo());
            ps.setString(2, encuesta.getModificacion());
            ps.setInt(3, encuesta.getIdEncuestaActiva());
            
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
    
    public boolean visualizarEncuestaActiva(EncuestaActiva encuesta) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection link = getConexion();
        String sql = "SELECT * FROM tbl_encuestasactivas WHERE iIdEncuestaActiva = ?";
        
        try {
            ps = link.prepareStatement(sql);
            
            ps.setInt(1, encuesta.getIdEncuestaActiva());
            
            rs = ps.executeQuery();
            
            if (rs.next()) {
                encuesta.setIdEncuestaActiva(Integer.parseInt(rs.getString("iIdEncuestaActiva")));
                encuesta.setIdEncuesta(Integer.parseInt(rs.getString("iIdEncuesta")));
                encuesta.setInicioVigencia(rs.getString("dtInicioVigencia"));
                encuesta.setFinVigencia(rs.getString("dtFinVigencia"));
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