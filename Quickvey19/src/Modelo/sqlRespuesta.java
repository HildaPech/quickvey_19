package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class sqlRespuesta extends ConexionBD {
    public boolean registrarRespuesta(Respuesta respuesta) {
        PreparedStatement ps = null;
        Connection link = getConexion();
        String sql = "INSERT INTO tbl_respuestas (cRespuesta, iPuntaje, lActivo, dtAlta, dtModificacion) VALUES (?, ?, ?, ?, ?)";
        
        try {
            ps = link.prepareStatement(sql);
            
            ps.setString(1, respuesta.getRespuesta());
            ps.setInt(2, respuesta.getPuntaje());
            ps.setInt(3, respuesta.getActivo());
            ps.setString(4, respuesta.getAlta());
            ps.setString(5, respuesta.getModificacion());
            
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
    
    public boolean modificarRespuesta(Respuesta respuesta) {
        PreparedStatement ps = null;
        Connection link = getConexion();
        String sql = "UPDATE tbl_respuestas SET cRespuesta = ?, iPuntaje = ?, dtModificacion = ? WHERE iIdRespuesta = ?";
        
        try {
            ps = link.prepareStatement(sql);
            
            ps.setString(1, respuesta.getRespuesta());
            ps.setInt(2, respuesta.getPuntaje());
            ps.setString(3, respuesta.getModificacion());
            ps.setInt(4, respuesta.getIdRespuesta());
            
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
    
    public boolean inactivarRespuesta(Respuesta respuesta) {
        PreparedStatement ps = null;
        Connection link = getConexion();
        String sql = "UPDATE tbl_respuestas SET lActivo = ?, dtModificacion = ? WHERE iIdRespuesta = ?";
        
        try {
            ps = link.prepareStatement(sql);
            
            ps.setInt(1, respuesta.getActivo());
            ps.setString(2, respuesta.getModificacion());
            ps.setInt(3, respuesta.getIdRespuesta());
            
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
    
    public boolean activarRespuesta(Respuesta respuesta) {
        PreparedStatement ps = null;
        Connection link = getConexion();
        String sql = "UPDATE tbl_respuestas SET lActivo = ?, dtModificacion = ? WHERE iIdRespuesta = ?";
        
        try {
            ps = link.prepareStatement(sql);
            
            ps.setInt(1, respuesta.getActivo());
            ps.setString(2, respuesta.getModificacion());
            ps.setInt(3, respuesta.getIdRespuesta());
            
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
    
    public boolean visualizarRespuesta(Respuesta respuesta) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection link = getConexion();
        String sql = "SELECT * FROM tbl_respuestas WHERE iIdRespuesta = ?";
        
        try {
            ps = link.prepareStatement(sql);
            
            ps.setInt(1, respuesta.getIdRespuesta());
            
            rs = ps.executeQuery();
            
            if (rs.next()) {
                respuesta.setIdRespuesta(Integer.parseInt(rs.getString("iIdRespuesta")));
                respuesta.setRespuesta(rs.getString("cRespuesta"));
                respuesta.setPuntaje(Integer.parseInt(rs.getString("iPuntaje")));
                respuesta.setActivo(Integer.parseInt(rs.getString("lActivo")));
                respuesta.setAlta(rs.getString("dtAlta"));
                respuesta.setModificacion(rs.getString("dtModificacion"));
                
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