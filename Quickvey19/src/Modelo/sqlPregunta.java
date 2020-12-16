package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class sqlPregunta extends ConexionBD {
    public boolean registrarPregunta(Pregunta pregunta) {
        PreparedStatement ps = null;
        Connection link = getConexion();
        String sql = "INSERT INTO tbl_preguntas (cPregunta, lActivo, dtAlta, dtModificacion) VALUES (?, ?, ?, ?)";
        
        try {
            ps = link.prepareStatement(sql);
            
            ps.setString(1, pregunta.getPregunta());
            ps.setInt(2, pregunta.getActivo());
            ps.setString(3, pregunta.getAlta());
            ps.setString(4, pregunta.getModificacion());
            
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
    
    public boolean modificarPregunta(Pregunta pregunta) {
        PreparedStatement ps = null;
        Connection link = getConexion();
        String sql = "UPDATE tbl_preguntas SET cPregunta = ?, dtModificacion = ? WHERE iIdPregunta = ?";
        
        try {
            ps = link.prepareStatement(sql);
            
            ps.setString(1, pregunta.getPregunta());
            ps.setString(2, pregunta.getModificacion());
            ps.setInt(3, pregunta.getIdPregunta());
            
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
    
    public boolean inactivarPregunta(Pregunta pregunta) {
        PreparedStatement ps = null;
        Connection link = getConexion();
        String sql = "UPDATE tbl_preguntas SET lActivo = ?, dtModificacion = ? WHERE iIdPregunta = ?";
        
        try {
            ps = link.prepareStatement(sql);
            
            ps.setInt(1, pregunta.getActivo());
            ps.setString(2, pregunta.getModificacion());
            ps.setInt(3, pregunta.getIdPregunta());
            
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
    
    public boolean activarPregunta(Pregunta pregunta) {
        PreparedStatement ps = null;
        Connection link = getConexion();
        String sql = "UPDATE tbl_preguntas SET lActivo = ?, dtModificacion = ? WHERE iIdPregunta = ?";
        
        try {
            ps = link.prepareStatement(sql);
            
            ps.setInt(1, pregunta.getActivo());
            ps.setString(2, pregunta.getModificacion());
            ps.setInt(3, pregunta.getIdPregunta());
            
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
    
    public boolean visualizarPregunta(Pregunta pregunta) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection link = getConexion();
        String sql = "SELECT * FROM tbl_preguntas WHERE iIdPregunta = ?";
        
        try {
            ps = link.prepareStatement(sql);
            
            ps.setInt(1, pregunta.getIdPregunta());
            
            rs = ps.executeQuery();
            
            if (rs.next()) {
                pregunta.setIdPregunta(Integer.parseInt(rs.getString("iIdPregunta")));
                pregunta.setPregunta(rs.getString("cPregunta"));
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
