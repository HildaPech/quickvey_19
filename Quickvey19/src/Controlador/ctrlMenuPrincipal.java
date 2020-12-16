package Controlador;

import Modelo.hash;
import Modelo.sqlEncuestaRealizada;
import Vista.frmEncuesta;
import Vista.frmEncuestasRealizadas;
import Vista.frmInicioSesion;
import Vista.frmMenuAdministrador;
import Vista.frmMenuUsuario;
import Vista.frmPerfilUsuario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class ctrlMenuPrincipal implements ActionListener {
    private sqlEncuestaRealizada sqlEncuestaRealizada;
    private frmMenuAdministrador frmMenuAdministrador;
    private frmMenuUsuario frmMenuUsuario;
    private frmEncuestasRealizadas frmEncuestasRealizadas;
    private frmPerfilUsuario frmPerfilUsuario;
    private frmEncuesta frmEncuesta;
    private frmInicioSesion frmInicioSesion;
    private ctrlEncuestasRealizadas ctrlEncuestasRealizadas;
    private ctrlUsuario ctrlPerfilUsuario;
    private ctrlEncuesta ctrlEncuesta;
    
    public ctrlMenuPrincipal(sqlEncuestaRealizada sqlEncuestaRealizada, frmMenuAdministrador frmMenuAdministrador, frmMenuUsuario frmMenuUsuario, frmEncuestasRealizadas frmEncuestasRealizadas, frmPerfilUsuario frmPerfilUsuario, frmEncuesta frmEncuesta, frmInicioSesion frmInicioSesion, ctrlEncuestasRealizadas ctrlEncuestasRealizadas, ctrlUsuario ctrlPerfilUsuario, ctrlEncuesta ctrlEncuesta) {
        this.sqlEncuestaRealizada = sqlEncuestaRealizada;
        this.frmMenuAdministrador = frmMenuAdministrador;
        this.frmMenuUsuario = frmMenuUsuario;
        this.frmEncuestasRealizadas = frmEncuestasRealizadas;
        this.frmPerfilUsuario = frmPerfilUsuario;
        this.frmEncuesta = frmEncuesta;
        this.frmInicioSesion = frmInicioSesion;
        this.ctrlEncuestasRealizadas = ctrlEncuestasRealizadas;
        this.ctrlPerfilUsuario = ctrlPerfilUsuario;
        this.ctrlEncuesta = ctrlEncuesta;
        this.frmMenuAdministrador.btnEncuestas.addActionListener(this);
        this.frmMenuAdministrador.btnCerrarSesion.addActionListener(this);
        this.frmMenuUsuario.btnPerfil.addActionListener(this);
        this.frmMenuUsuario.btnEncuesta.addActionListener(this);
        this.frmMenuUsuario.btnCerrarSesion.addActionListener(this);
    }
    
    public void ejecutarFormuluarioAdministrador() {
        frmMenuAdministrador.setTitle("Quickvey-19");
        frmMenuAdministrador.setLocationRelativeTo(null);
    }
    
    public void ejecutarFormuluarioUsuario() {
        frmMenuUsuario.setTitle("Quickvey-19");
        frmMenuUsuario.setLocationRelativeTo(null);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == frmMenuAdministrador.btnEncuestas) {
            frmMenuAdministrador.setVisible(false);
            ctrlEncuestasRealizadas.ejecutarFormuluario();
            frmEncuestasRealizadas.setVisible(true);
        }
        
        if (e.getSource() == frmMenuUsuario.btnPerfil) {
            frmMenuUsuario.setVisible(false);
            ctrlPerfilUsuario.ejecutarFormuluario();
            frmPerfilUsuario.setVisible(true);
            frmPerfilUsuario.txtIdUsuario.setText(frmMenuUsuario.txtIdUsuario.getText());
            frmPerfilUsuario.txtIdPersona.setText(frmMenuUsuario.txtIdPersona.getText());
        }
        
        if (e.getSource() == frmMenuUsuario.btnEncuesta) {
            if(sqlEncuestaRealizada.validarEncuestaRealizada(1, Integer.parseInt(frmMenuUsuario.txtIdUsuario.getText())) == 0) {
                frmMenuUsuario.setVisible(false);
                ctrlEncuesta.ejecutarFormuluario();
                frmEncuesta.setVisible(true);
            }
            else {
                JOptionPane.showMessageDialog(null, "Por el momento no tiene ninguna encuesta activa.", "Aviso", JOptionPane.WARNING_MESSAGE);
            }
        }
        
        if (e.getSource() == frmMenuAdministrador.btnCerrarSesion) {
            frmMenuAdministrador.setVisible(false);
            frmInicioSesion.setVisible(true);
            frmInicioSesion.txtNombreUsuario.setText(null);
            frmInicioSesion.txtPassword.setText(null);
            frmInicioSesion.txtNombreUsuario.grabFocus();
        }
        
        if (e.getSource() == frmMenuUsuario.btnCerrarSesion) {
            frmMenuUsuario.setVisible(false);
            frmInicioSesion.setVisible(true);
            frmInicioSesion.txtNombreUsuario.setText(null);
            frmInicioSesion.txtPassword.setText(null);
            frmInicioSesion.txtNombreUsuario.grabFocus();
        }
    }
}