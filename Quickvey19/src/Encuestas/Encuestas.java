package Encuestas;

import Controlador.ctrlEncuesta;
import Controlador.ctrlEncuestasRealizadas;
import Controlador.ctrlInicioSesion;
import Controlador.ctrlMenuPrincipal;
import Controlador.ctrlPassword;
import Controlador.ctrlUsuario;
import Controlador.ctrlRegistroUsuario;
import Modelo.Encuesta;
import Modelo.EncuestaActiva;
import Modelo.EncuestaRealizada;
import Modelo.Perfil;
import Modelo.PerfilUsuario;
import Modelo.Persona;
import Modelo.Pregunta;
import Modelo.PreguntaEncuesta;
import Modelo.Respuesta;
import Modelo.RespuestaPregunta;
import Modelo.ResultadoEncuesta;
import Modelo.Usuario;
import Modelo.sqlEncuesta;
import Modelo.sqlEncuestaActiva;
import Modelo.sqlEncuestaRealizada;
import Modelo.sqlPerfil;
import Modelo.sqlPerfilUsuario;
import Modelo.sqlPersona;
import Modelo.sqlPregunta;
import Modelo.sqlPreguntaEncuesta;
import Modelo.sqlRespuesta;
import Modelo.sqlRespuestaPregunta;
import Modelo.sqlResultadoEncuesta;
import Modelo.sqlUsuario;
import Vista.frmEncuesta;
import Vista.frmEncuestasRealizadas;
import Vista.frmInicioSesion;
import Vista.frmMenuAdministrador;
import Vista.frmMenuUsuario;
import Vista.frmPassword;
import Vista.frmPerfilUsuario;
import Vista.frmRegistroUsuario;

public class Encuestas {
    public static void main ( String args[] ) {
        Encuesta encuesta = new Encuesta();
        sqlEncuesta sqlEncuesta = new sqlEncuesta();
        
        EncuestaActiva encuestaActiva = new EncuestaActiva();
        sqlEncuestaActiva sqlEncuestaActiva = new sqlEncuestaActiva();
        
        EncuestaRealizada encuestaRealizada = new EncuestaRealizada();
        sqlEncuestaRealizada sqlEncuestaRealizada = new sqlEncuestaRealizada();
        
        Persona persona = new Persona();
        sqlPersona sqlPersona = new sqlPersona();
        
        Pregunta pregunta = new Pregunta();
        sqlPregunta sqlPregunta = new sqlPregunta();
        
        PreguntaEncuesta preguntaEncuesta = new PreguntaEncuesta();
        sqlPreguntaEncuesta sqlPreguntaEncuesta = new sqlPreguntaEncuesta();
        
        Respuesta respuesta = new Respuesta();
        sqlRespuesta sqlRespuesta = new sqlRespuesta();
        
        RespuestaPregunta respuestaPregunta = new RespuestaPregunta();
        sqlRespuestaPregunta sqlRespuestaPregunta = new sqlRespuestaPregunta();
        
        ResultadoEncuesta resultadoEncuesta = new ResultadoEncuesta();
        sqlResultadoEncuesta sqlResultadoEncuesta = new sqlResultadoEncuesta();
        
        Perfil perfil = new Perfil();
        sqlPerfil sqlPerfil = new sqlPerfil();
        
        PerfilUsuario perfilUsuario = new PerfilUsuario();
        sqlPerfilUsuario sqlPerfilUsuario = new sqlPerfilUsuario();
        
        Usuario usuario = new Usuario();
        sqlUsuario sqlUsuario = new sqlUsuario();
                
        frmEncuesta frmEncuesta = new frmEncuesta();
        frmEncuestasRealizadas frmEncuestasRealizadas = new frmEncuestasRealizadas();
        frmInicioSesion frmInicioSesion = new frmInicioSesion();
        frmMenuUsuario frmMenuUsuario = new frmMenuUsuario();
        frmMenuAdministrador frmMenuAdministrador = new frmMenuAdministrador();
        frmPassword frmPassword = new frmPassword();
        frmPerfilUsuario frmPerfilUsuario = new frmPerfilUsuario();
        frmRegistroUsuario frmRegistroUsuario = new frmRegistroUsuario();
        
        ctrlPassword ctrlPassword = new ctrlPassword (usuario, sqlUsuario, frmPerfilUsuario, frmPassword);
        ctrlUsuario ctrlUsuario = new ctrlUsuario(persona, sqlPersona, usuario, sqlUsuario, frmMenuUsuario, frmPerfilUsuario, frmPassword, ctrlPassword);
        ctrlEncuesta ctrlEncuesta = new ctrlEncuesta(encuestaRealizada, sqlEncuestaRealizada, resultadoEncuesta, sqlResultadoEncuesta, frmMenuUsuario, frmEncuesta);
        ctrlEncuestasRealizadas ctrlEncuestasRealizadas = new ctrlEncuestasRealizadas(encuestaRealizada, sqlEncuestaRealizada, frmMenuAdministrador, frmEncuestasRealizadas);
        ctrlMenuPrincipal ctrlMenuPrincipal = new ctrlMenuPrincipal(sqlEncuestaRealizada, frmMenuAdministrador, frmMenuUsuario, frmEncuestasRealizadas, frmPerfilUsuario, frmEncuesta, frmInicioSesion, ctrlEncuestasRealizadas, ctrlUsuario, ctrlEncuesta);
        ctrlRegistroUsuario ctrlRegistroUsuario = new ctrlRegistroUsuario(persona, sqlPersona, perfilUsuario, sqlPerfilUsuario, usuario, sqlUsuario, frmRegistroUsuario, frmInicioSesion);
        ctrlInicioSesion ctrlInicioSesion = new ctrlInicioSesion(usuario, sqlUsuario, sqlPerfilUsuario, frmInicioSesion, frmMenuAdministrador, frmMenuUsuario, frmRegistroUsuario, ctrlMenuPrincipal, ctrlRegistroUsuario);
        
        ctrlInicioSesion.ejecutarFormuluario();
        frmInicioSesion.setVisible(true);
    }
}
