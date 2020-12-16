package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class sqlPerfilUsuario extends ConexionBD {
    public boolean registrarPerfilUsuario(PerfilUsuario perfil) {
        PreparedStatement ps = null;
        Connection link = getConexion();
        String sql = "INSERT INTO tbl_rel_perfilesusuarios (iIdUsuario, iIdPerfil, lActivo, dtAlta, dtModificacion) VALUES ((SELECT MAX(iIdUsuario) FROM tbl_usuarios), ?, ?, ?, ?)";
        
        try {
            ps = link.prepareStatement(sql);
            
            ps.setInt(1, perfil.getIdPerfil());
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
    
    public boolean modificarPerfilUsuario(PerfilUsuario perfil) {
        PreparedStatement ps = null;
        Connection link = getConexion();
        String sql = "UPDATE tbl_rel_perfilesusuarios SET iIdUsuario = ?, iIdPerfil = ?, dtModificacion = ? WHERE iIdUsuario = ? AND iIdPerfil = ?";
        
        try {
            ps = link.prepareStatement(sql);
            
            ps.setInt(1, perfil.getIdUsuario());
            ps.setInt(2, perfil.getIdPerfil());
            ps.setString(3, perfil.getModificacion());
            ps.setInt(4, perfil.getIdUsuario());
            ps.setInt(5, perfil.getIdPerfil());
            
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
    
    public boolean inactivarPerfilUsuario(PerfilUsuario perfil) {
        PreparedStatement ps = null;
        Connection link = getConexion();
        String sql = "UPDATE tbl_rel_perfilesusuarios SET lActivo = ?, dtModificacion = ? WHERE iIdUsuario = ? AND iIdPerfil = ?";
        
        try {
            ps = link.prepareStatement(sql);
            
            ps.setInt(1, perfil.getActivo());
            ps.setString(2, perfil.getModificacion());
            ps.setInt(3, perfil.getIdUsuario());
            ps.setInt(4, perfil.getIdPerfil());
            
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
    
    public boolean activarPerfilUsuario(PerfilUsuario perfil) {
        PreparedStatement ps = null;
        Connection link = getConexion();
        String sql = "UPDATE tbl_rel_perfilesusuarios SET lActivo = ?, dtModificacion = ? WHERE iIdUsuario = ? AND iIdPerfil = ?";
        
        try {
            ps = link.prepareStatement(sql);
            
            ps.setInt(1, perfil.getActivo());
            ps.setString(2, perfil.getModificacion());
            ps.setInt(3, perfil.getIdUsuario());
            ps.setInt(4, perfil.getIdPerfil());
            
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
    
    public boolean visualizarPerfilUsuario(PerfilUsuario perfil) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection link = getConexion();
        String sql = "SELECT * FROM tbl_rel_perfilesusuarios WHERE iIdUsuario = ? AND iIdPerfil = ?";
        
        try {
            ps = link.prepareStatement(sql);
            
            ps.setInt(1, perfil.getIdUsuario());
            ps.setInt(2, perfil.getIdPerfil());
            
            rs = ps.executeQuery();
            
            if (rs.next()) {
                perfil.setIdUsuario(Integer.parseInt(rs.getString("iIdUsuario")));
                perfil.setIdPerfil(Integer.parseInt(rs.getString("iIdPerfil")));
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
    
    public int obtenerPerfilUsuario(int idUsuario) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection link = getConexion();
        String sql = "SELECT * FROM tbl_rel_perfilesusuarios WHERE iIdUsuario = ?";
        
        try {
            ps = link.prepareStatement(sql);
            
            ps.setInt(1, idUsuario);
            
            rs = ps.executeQuery();
            
            if (rs.next()) {                
                return Integer.parseInt(rs.getString("iIdPerfil"));
            }
            
            return 0;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Se ha producido un error en: " + e, "Error", JOptionPane.ERROR_MESSAGE);
            
            return 0;
        } finally {
            try {
                link.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Se ha producido un error de conexion con la base \n de datos en: " + e, "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}