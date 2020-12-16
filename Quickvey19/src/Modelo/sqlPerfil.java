package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class sqlPerfil extends ConexionBD {
    public boolean registrarPerfil(Perfil perfil) {
        PreparedStatement ps = null;
        Connection link = getConexion();
        String sql = "INSERT INTO tbl_perfiles (cNombrePerfil, lActivo, dtAlta, dtModificacion) VALUES (?, ?, ?, ?)";
        
        try {
            ps = link.prepareStatement(sql);
            
            ps.setString(1, perfil.getNombrePerfil());
            ps.setInt(2, perfil.getActivo());
            ps.setString(3, perfil.getAlta());
            ps.setString(4, perfil.getModificacion());
            
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
    
    public boolean modificarPerfil(Perfil perfil) {
        PreparedStatement ps = null;
        Connection link = getConexion();
        String sql = "UPDATE tbl_perfiles SET cNombrePerfil = ?, dtModificacion = ? WHERE iIdPerfil = ?";
        
        try {
            ps = link.prepareStatement(sql);
            
            ps.setString(1, perfil.getNombrePerfil());
            ps.setString(2, perfil.getModificacion());
            ps.setInt(3, perfil.getIdPerfil());
            
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
    
    public boolean inactivarPerfil(Perfil perfil) {
        PreparedStatement ps = null;
        Connection link = getConexion();
        String sql = "UPDATE tbl_perfiles SET lActivo = ?, dtModificacion = ? WHERE iIdPerfil = ?";
        
        try {
            ps = link.prepareStatement(sql);
            
            ps.setInt(1, perfil.getActivo());
            ps.setString(2, perfil.getModificacion());
            ps.setInt(3, perfil.getIdPerfil());
            
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
    
    public boolean activarPerfil(Perfil perfil) {
        PreparedStatement ps = null;
        Connection link = getConexion();
        String sql = "UPDATE tbl_perfiles SET lActivo = ?, dtModificacion = ? WHERE iIdPerfil = ?";
        
        try {
            ps = link.prepareStatement(sql);
            
            ps.setInt(1, perfil.getActivo());
            ps.setString(2, perfil.getModificacion());
            ps.setInt(3, perfil.getIdPerfil());
            
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
    
    public boolean visualizarPerfil(Perfil perfil) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection link = getConexion();
        String sql = "SELECT * FROM tbl_perfiles WHERE iIdPerfil = ?";
        
        try {
            ps = link.prepareStatement(sql);
            
            ps.setInt(1, perfil.getIdPerfil());
            
            rs = ps.executeQuery();
            
            if (rs.next()) {
                perfil.setIdPerfil(Integer.parseInt(rs.getString("iIdPerfil")));
                perfil.setNombrePerfil(rs.getString("cNombrePerfil"));
                perfil.setActivo(Integer.parseInt(rs.getString("lActivo")));
                perfil.setAlta(rs.getString("dtAlta"));
                perfil.setModificacion(rs.getString("dtModificacion"));
                
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