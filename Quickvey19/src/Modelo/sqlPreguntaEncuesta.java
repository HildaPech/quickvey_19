package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class sqlPreguntaEncuesta extends ConexionBD {
    public boolean registrarPreguntaEncuesta(PreguntaEncuesta pregunta) {
        PreparedStatement ps = null;
        Connection link = getConexion();
        String sql = "INSERT INTO tbl_rel_encuestaspreguntas (iIdEncuesta, iIdPregunta, lActivo, dtAlta, dtModificacion) VALUES (?, ?, ?, ?, ?)";
        
        try {
            ps = link.prepareStatement(sql);
            
            ps.setInt(1, pregunta.getIdEncuesta());
            ps.setInt(2, pregunta.getIdPregunta());
            ps.setInt(3, pregunta.getActivo());
            ps.setString(4, pregunta.getAlta());
            ps.setString(5, pregunta.getModificacion());
            
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
    
    public boolean modificarPreguntaEncuesta(PreguntaEncuesta pregunta) {
        PreparedStatement ps = null;
        Connection link = getConexion();
        String sql = "UPDATE tbl_rel_encuestaspreguntas SET iIdEncuesta = ?, iIdPregunta = ?, dtModificacion = ? WHERE iIdEncuesta = ? AND iIdPregunta = ?";
        
        try {
            ps = link.prepareStatement(sql);
            
            ps.setInt(1, pregunta.getIdEncuesta());
            ps.setInt(2, pregunta.getIdPregunta());
            ps.setString(3, pregunta.getModificacion());
            ps.setInt(4, pregunta.getIdEncuesta());
            ps.setInt(5, pregunta.getIdPregunta());
            
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
    
    public boolean inactivarPreguntaEncuesta(PreguntaEncuesta pregunta) {
        PreparedStatement ps = null;
        Connection link = getConexion();
        String sql = "UPDATE tbl_rel_encuestaspreguntas SET lActivo = ?, dtModificacion = ? WHERE iIdEncuesta = ? AND iIdPregunta = ?";
        
        try {
            ps = link.prepareStatement(sql);
            
            ps.setInt(1, pregunta.getActivo());
            ps.setString(2, pregunta.getModificacion());
            ps.setInt(3, pregunta.getIdEncuesta());
            ps.setInt(4, pregunta.getIdPregunta());
            
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
    
    public boolean activarPreguntaEncuesta(PreguntaEncuesta pregunta) {
        PreparedStatement ps = null;
        Connection link = getConexion();
        String sql = "UPDATE tbl_rel_encuestaspreguntas SET lActivo = ?, dtModificacion = ? WHERE iIdEncuesta = ? AND iIdPregunta = ?";
        
        try {
            ps = link.prepareStatement(sql);
            
            ps.setInt(1, pregunta.getActivo());
            ps.setString(2, pregunta.getModificacion());
            ps.setInt(3, pregunta.getIdEncuesta());
            ps.setInt(4, pregunta.getIdPregunta());
            
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
    
    public boolean visualizarPreguntaEncuesta(PreguntaEncuesta pregunta) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection link = getConexion();
        String sql = "SELECT * FROM tbl_rel_encuestaspreguntas WHERE iIdEncuesta = ? AND iIdPregunta = ?";
        
        try {
            ps = link.prepareStatement(sql);
            
            ps.setInt(1, pregunta.getIdEncuesta());
            ps.setInt(2, pregunta.getIdPregunta());
            
            rs = ps.executeQuery();
            
            if (rs.next()) {
                pregunta.setIdEncuesta(Integer.parseInt(rs.getString("iIdEncuesta")));
                pregunta.setIdPregunta(Integer.parseInt(rs.getString("iIdPregunta")));
                pregunta.setActivo(Integer.parseInt(rs.getString("lActivo")));
                pregunta.setAlta(rs.getString("dtAlta"));
                pregunta.setModificacion(rs.getString("dtModificacion"));
                
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