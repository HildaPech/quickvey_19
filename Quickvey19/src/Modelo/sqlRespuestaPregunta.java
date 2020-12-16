package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class sqlRespuestaPregunta extends ConexionBD {
    public boolean registrarRespuestaPregunta(RespuestaPregunta respuesta) {
        PreparedStatement ps = null;
        Connection link = getConexion();
        String sql = "INSERT INTO tbl_rel_preguntasrespuestas (iIdPregunta, iIdRespuesta, lActivo, dtAlta, dtModificacion) VALUES (?, ?, ?, ?, ?)";
        
        try {
            ps = link.prepareStatement(sql);
            
            ps.setInt(1, respuesta.getIdPregunta());
            ps.setInt(2, respuesta.getIdRespuesta());
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
    
    public boolean modificarRespuestaPregunta(RespuestaPregunta respuesta) {
        PreparedStatement ps = null;
        Connection link = getConexion();
        String sql = "UPDATE tbl_rel_preguntasrespuestas SET iIdPregunta = ?, iIdRespuesta = ?, dtModificacion = ? WHERE iIdPregunta = ? AND iIdRespuesta = ?";
        
        try {
            ps = link.prepareStatement(sql);
            
            ps.setInt(1, respuesta.getIdPregunta());
            ps.setInt(2, respuesta.getIdRespuesta());
            ps.setString(3, respuesta.getModificacion());
            ps.setInt(4, respuesta.getIdPregunta());
            ps.setInt(5, respuesta.getIdRespuesta());
            
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
    
    public boolean inactivarRespuestaPregunta(RespuestaPregunta respuesta) {
        PreparedStatement ps = null;
        Connection link = getConexion();
        String sql = "UPDATE tbl_rel_preguntasrespuestas SET lActivo = ?, dtModificacion = ? WHERE iIdPregunta = ? AND iIdRespuesta = ?";
        
        try {
            ps = link.prepareStatement(sql);
            
            ps.setInt(1, respuesta.getActivo());
            ps.setString(2, respuesta.getModificacion());
            ps.setInt(3, respuesta.getIdPregunta());
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
    
    public boolean activarRespuestaPregunta(RespuestaPregunta respuesta) {
        PreparedStatement ps = null;
        Connection link = getConexion();
        String sql = "UPDATE tbl_rel_preguntasrespuestas SET lActivo = ?, dtModificacion = ? WHERE iIdPregunta = ? AND iIdRespuesta = ?";
        
        try {
            ps = link.prepareStatement(sql);
            
            ps.setInt(1, respuesta.getActivo());
            ps.setString(2, respuesta.getModificacion());
            ps.setInt(3, respuesta.getIdPregunta());
            ps.setInt(4, respuesta.getIdRespuesta());
            
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
    
    public boolean visualizarRespuestaPregunta(RespuestaPregunta respuesta) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection link = getConexion();
        String sql = "SELECT * FROM tbl_rel_preguntasrespuestas WHERE iIdPregunta = ? AND iIdRespuesta = ?";
        
        try {
            ps = link.prepareStatement(sql);
            
            ps.setInt(1, respuesta.getIdPregunta());
            ps.setInt(2, respuesta.getIdRespuesta());
            
            rs = ps.executeQuery();
            
            if (rs.next()) {
                respuesta.setIdPregunta(Integer.parseInt(rs.getString("iIdPregunta")));
                respuesta.setIdRespuesta(Integer.parseInt(rs.getString("iIdRespuesta")));
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