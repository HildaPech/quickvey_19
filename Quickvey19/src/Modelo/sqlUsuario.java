package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class sqlUsuario extends ConexionBD {
    public int validarUsuario(String nombreUsuario) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection link = getConexion();
        String sql = "SELECT COUNT(iIdUsuario) FROM tbl_usuarios WHERE cNombreUsuario = ?";
        
        try {
            ps = link.prepareStatement(sql);
            
            ps.setString(1, nombreUsuario);
            
            rs = ps.executeQuery();
            
            if (rs.next()) {
                return rs.getInt(1);
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
    
    public boolean registrarUsuario(Usuario usuario) {
        PreparedStatement ps = null;
        Connection link = getConexion();
        String sql = "INSERT INTO tbl_usuarios (iIdPersona, cNombreUsuario, cPassword, lActivo, dtAlta, dtModificacion) VALUES ((SELECT MAX(iIdPersona) FROM tbl_personas), ?, ?, ?, ?, ?)";
        
        try {
            ps = link.prepareStatement(sql);
            
            //ps.setInt(1, usuario.getIdPersona());
            ps.setString(1, usuario.getNombreUsuario());
            ps.setString(2, usuario.getPassword());
            ps.setInt(3, usuario.getActivo());
            ps.setString(4, usuario.getAlta());
            ps.setString(5, usuario.getModificacion());
            
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
    
    public boolean modificarUsuario(Usuario usuario) {
        PreparedStatement ps = null;
        Connection link = getConexion();
        String sql = "UPDATE tbl_usuarios SET cNombreUsuario = ?, cPassword = ?, dtModificacion = ? WHERE iIdUsuario = ?";
        
        try {
            ps = link.prepareStatement(sql);
            
            ps.setString(1, usuario.getNombreUsuario());
            ps.setString(2, usuario.getPassword());
            ps.setString(3, usuario.getModificacion());
            ps.setInt(4, usuario.getIdUsuario());
            
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
    
    public boolean modificarNombreUsuario(Usuario usuario) {
        PreparedStatement ps = null;
        Connection link = getConexion();
        String sql = "UPDATE tbl_usuarios SET cNombreUsuario = ?, dtModificacion = ? WHERE iIdUsuario = ?";
        
        try {
            ps = link.prepareStatement(sql);
            
            ps.setString(1, usuario.getNombreUsuario());
            ps.setString(2, usuario.getModificacion());
            ps.setInt(3, usuario.getIdUsuario());
            
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

    public int validarPassword(Usuario usuario) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection link = getConexion();
        String sql = "SELECT COUNT(iIdUsuario) FROM tbl_usuarios WHERE iIdUsuario = ? AND cPassword = ?";
        
        try {
            ps = link.prepareStatement(sql);
            
            ps.setInt(1, usuario.getIdUsuario());
            ps.setString(2, usuario.getPassword());
            
            rs = ps.executeQuery();
            
            if (rs.next()) {
                return rs.getInt(1);
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
    
    public boolean modificarPassword(Usuario usuario) {
        PreparedStatement ps = null;
        Connection link = getConexion();
        String sql = "UPDATE tbl_usuarios SET cPassword = ?, dtModificacion = ? WHERE iIdUsuario = ?";
        
        try {
            ps = link.prepareStatement(sql);
            
            ps.setString(1, usuario.getPassword());
            ps.setString(2, usuario.getModificacion());
            ps.setInt(3, usuario.getIdUsuario());
            
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
    
    public boolean inactivarUsuario(Usuario usuario) {
        PreparedStatement ps = null;
        Connection link = getConexion();
        String sql = "UPDATE tbl_usuarios SET lActivo = ?, dtModificacion = ? WHERE iIdUsuario = ?";
        
        try {
            ps = link.prepareStatement(sql);
            
            ps.setInt(1, usuario.getActivo());
            ps.setString(2, usuario.getModificacion());
            ps.setInt(3, usuario.getIdUsuario());
            
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
    
    public boolean activarUsuario(Usuario usuario) {
        PreparedStatement ps = null;
        Connection link = getConexion();
        String sql = "UPDATE tbl_usuarios SET lActivo = ?, dtModificacion = ? WHERE iIdUsuario = ?";
        
        try {
            ps = link.prepareStatement(sql);
            
            ps.setInt(1, usuario.getActivo());
            ps.setString(2, usuario.getModificacion());
            ps.setInt(3, usuario.getIdUsuario());
            
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
    
    public boolean eliminarUsuario(Usuario usuario) {
        PreparedStatement ps = null;
        Connection link = getConexion();
        String sql = "DELETE FROM tbl_usuarios WHERE iIdUsuario = ?";
        
        try {
            ps = link.prepareStatement(sql);
            
            ps.setInt(1, usuario.getIdUsuario());
            
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
    
    public boolean visualizarUsuario(Usuario usuario) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection link = getConexion();
        String sql = "SELECT * FROM tbl_usuarios WHERE iIdUsuario = ?";
        
        try {
            ps = link.prepareStatement(sql);
            
            ps.setInt(1, usuario.getIdUsuario());
            
            rs = ps.executeQuery();
            
            if (rs.next()) {
                usuario.setIdUsuario(Integer.parseInt(rs.getString("iIdUsuario")));
                usuario.setNombreUsuario(rs.getString("cNombreUsuario"));
                usuario.setPassword(rs.getString("cPassword"));
                usuario.setActivo(Integer.parseInt(rs.getString("lActivo")));
                usuario.setAlta(rs.getString("dtAlta"));
                usuario.setModificacion(rs.getString("dtModificacion"));
                
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
    
    public boolean iniciarSesion(Usuario usuario) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection link = getConexion();
        String sql = "SELECT iIdUsuario, iIdPersona, cNombreUsuario, cPassword FROM tbl_usuarios WHERE cNombreUsuario = ? AND lActivo = 1";
        
        try {
            ps = link.prepareStatement(sql);
            
            ps.setString(1, usuario.getNombreUsuario());
            
            rs = ps.executeQuery();
            
            if (rs.next()) {
                if (hash.md5(usuario.getPassword()).equals(rs.getString(4))) {
                    usuario.setIdUsuario(rs.getInt(1));
                    usuario.setIdPersona(rs.getInt(2));
                    usuario.setNombreUsuario(rs.getString(3));
                    usuario.setPassword(rs.getString(4));
                                        
                    return true;
                }
                else {
                    return false;
                }
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