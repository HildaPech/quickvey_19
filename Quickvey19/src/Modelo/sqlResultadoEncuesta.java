package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class sqlResultadoEncuesta extends ConexionBD {
    public boolean registrarRespuestaEncuesta(ResultadoEncuesta respuesta) {
        PreparedStatement ps = null;
        Connection link = getConexion();
        String sql = "INSERT INTO tbl_resultadosencuestas (iIdEncuestaRealizada, iIdPregunta, iIdRespuesta, dtAlta, dtModificacion) VALUES ((SELECT MAX(iIdEncuestaRealizada) FROM tbl_encuestasrealizadas), ?, ?, ?, ?)";
        
        try {
            ps = link.prepareStatement(sql);
            
            ps.setInt(1, respuesta.getIdPregunta());
            ps.setInt(2, respuesta.getIdRespuesta());
            ps.setString(3, respuesta.getAlta());
            ps.setString(4, respuesta.getModificacion());
            
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
    
    public boolean modificarRespuestaEncuesta(ResultadoEncuesta respuesta) {
        PreparedStatement ps = null;
        Connection link = getConexion();
        String sql = "UPDATE tbl_resultadosencuestas SET iIdRespuesta = ?, dtModificacion = ? WHERE iIdEncuestaRealizada = ?";
        
        try {
            ps = link.prepareStatement(sql);
            
            ps.setInt(1, respuesta.getIdRespuesta());
            ps.setString(2, respuesta.getModificacion());
            ps.setInt(3, respuesta.getIdEncuestaRealizada());
            
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
        
    public boolean visualizarRespuestaEncuesta(ResultadoEncuesta respuesta) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection link = getConexion();
        String sql = "SELECT * FROM tbl_resultadosencuestas WHERE iIdEncuestaRealizada = ? AND iIdPregunta = ?";
        
        try {
            ps = link.prepareStatement(sql);
            
            ps.setInt(1, respuesta.getIdEncuestaRealizada());
            ps.setInt(2, respuesta.getIdPregunta());
            
            rs = ps.executeQuery();
            
            if (rs.next()) {
                respuesta.setIdEncuestaRealizada(Integer.parseInt(rs.getString("iIdEncuestaRealizada")));
                respuesta.setIdPregunta(Integer.parseInt(rs.getString("iIdPregunta")));
                respuesta.setIdRespuesta(Integer.parseInt(rs.getString("iIdRespuesta")));
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
    
    public boolean obtenerPreguntaEncuesta(ResultadoEncuesta respuesta, Pregunta pregunta) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection link = getConexion();
        String sql = "SELECT P.iIdPregunta, P.cPregunta FROM tbl_resultadosencuestas AS RE, tbl_preguntas AS P "
                    + "WHERE RE.iIdEncuestaRealizada = ? AND RE.iIdPregunta = ? AND RE.iIdPregunta = P.iIdPregunta";
        
        try {
            ps = link.prepareStatement(sql);
            
            ps.setInt(1, respuesta.getIdEncuestaRealizada());
            ps.setInt(2, respuesta.getIdPregunta());
            
            rs = ps.executeQuery();
            
            if (rs.next()) {
                pregunta.setIdPregunta(Integer.parseInt(rs.getString("iIdPregunta")));
                pregunta.setPregunta(rs.getString("cPregunta"));
                
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
    
    public boolean obtenerRepuestaEncuesta(ResultadoEncuesta respuestaEncuesta, Respuesta respuesta) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection link = getConexion();
        String sql = "SELECT R.iIdRespuesta, R.cRespuesta FROM tbl_resultadosencuestas AS RE, tbl_respuestas AS R "
                    + "WHERE RE.iIdEncuestaRealizada = ? AND RE.iIdPregunta = ? AND RE.iIdRespuesta = ? AND RE.iIdRespuesta = R.iIdRespuesta";
        
        try {
            ps = link.prepareStatement(sql);
            
            ps.setInt(1, respuestaEncuesta.getIdEncuestaRealizada());
            ps.setInt(2, respuestaEncuesta.getIdPregunta());
            ps.setInt(2, respuestaEncuesta.getIdRespuesta());
            
            rs = ps.executeQuery();
            
            if (rs.next()) {
                respuesta.setIdRespuesta(Integer.parseInt(rs.getString("iIdRespuesta")));
                respuesta.setRespuesta(rs.getString("cRespuesta"));
                
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