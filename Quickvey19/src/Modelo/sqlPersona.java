package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

public class sqlPersona extends ConexionBD {
    public boolean validarCorreo(String correo) {
        Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        
        Matcher mather = pattern.matcher(correo);
        
        return mather.find();
    }
    
    public boolean registrarPersona(Persona persona) {
        PreparedStatement ps = null;
        Connection link = getConexion();
        String sql = "INSERT INTO tbl_personas (cPrimerApellido, cSegundoApellido, cNombre, dtFechaNacimiento, cSexo, cCorreoElectronico, lActivo, dtAlta, dtModificacion) " + 
        "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?) ON DUPLICATE KEY UPDATE lActivo = 1, dtModificacion = ?";
        
        try {
            ps = link.prepareStatement(sql);
            
            ps.setString(1, persona.getPrimerApellido());
            ps.setString(2, persona.getSegundoApellido());
            ps.setString(3, persona.getNombre());
            ps.setString(4, persona.getFechaNacimiento());
            ps.setString(5, persona.getSexo());
            ps.setString(6, persona.getCorreoElectronico());
            ps.setInt(7, persona.getActivo());
            ps.setString(8, persona.getAlta());
            ps.setString(9, persona.getModificacion());
            ps.setString(10, persona.getModificacion());
            
            ps.execute();
            
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Se ha producido un error en: " + e);
            
            return false;
        } finally {
            try {
                link.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Se ha producido un error de conexion con la base \n de datos en: " + e, "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    public boolean modificarPersona(Persona persona) {
        PreparedStatement ps = null;
        Connection link = getConexion();
        String sql = "UPDATE tbl_personas SET cPrimerApellido = ?, cSegundoApellido = ?, cNombre = ?, dtFechaNacimiento = ?, cSexo = ?, cCorreoElectronico = ?, dtModificacion = ? WHERE iIdPersona = ?";
        
        try {
            ps = link.prepareStatement(sql);
            
            ps.setString(1, persona.getPrimerApellido());
            ps.setString(2, persona.getSegundoApellido());
            ps.setString(3, persona.getNombre());
            ps.setString(4, persona.getFechaNacimiento());
            ps.setString(5, persona.getSexo());
            ps.setString(6, persona.getCorreoElectronico());
            ps.setString(7, persona.getModificacion());
            ps.setInt(8, persona.getIdPersona());
            
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
    
    public boolean inactivarPersona(Persona persona) {
        PreparedStatement ps = null;
        Connection link = getConexion();
        String sql = "UPDATE tbl_personas SET lActivo = 0, dtModificacion = ? WHERE iIdPersona = ?";
        
        try {
            ps = link.prepareStatement(sql);
            
            ps.setString(1, persona.getModificacion());
            ps.setInt(2, persona.getIdPersona());
            
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
    
    public boolean activarPersona(Persona persona) {
        PreparedStatement ps = null;
        Connection link = getConexion();
        String sql = "UPDATE tbl_personas SET lActivo = 1, dtModificacion = ? WHERE iIdPersona = ?";
        
        try {
            ps = link.prepareStatement(sql);
            
            ps.setString(1, persona.getModificacion());
            ps.setInt(2, persona.getIdPersona());
            
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
    
    public boolean eliminarPersona(Persona persona) {
        PreparedStatement ps = null;
        Connection link = getConexion();
        String sql = "DELETE FROM tbl_personas WHERE iIdPersona = ?";
        
        try {
            ps = link.prepareStatement(sql);
            
            ps.setInt(1, persona.getIdPersona());
            
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
    
    public boolean visualizarPersona(Persona persona) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection link = getConexion();
        String sql = "SELECT * FROM tbl_personas WHERE iIdPersona = ?";
        
        try {
            ps = link.prepareStatement(sql);
            
            ps.setInt(1, persona.getIdPersona());
            
            rs = ps.executeQuery();
            
            if (rs.next()) {
                persona.setIdPersona(Integer.parseInt(rs.getString("iIdPersona")));
                persona.setPrimerApellido(rs.getString("cPrimerApellido"));
                persona.setSegundoApellido(rs.getString("cSegundoApellido"));
                persona.setNombre(rs.getString("cNombre"));
                persona.setFechaNacimiento(rs.getString("dtFechaNacimiento"));
                persona.setSexo(rs.getString("cSexo"));
                persona.setCorreoElectronico(rs.getString("cCorreoElectronico"));
                persona.setActivo(Integer.parseInt(rs.getString("lActivo")));
                persona.setAlta(rs.getString("dtAlta"));
                persona.setModificacion(rs.getString("dtModificacion"));
                
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