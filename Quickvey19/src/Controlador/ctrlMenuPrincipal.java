package Controlador;

import Modelo.hash;
import Modelo.sqlEncuestaRealizada;
import Modelo.sqlPerfilUsuario;
import Vista.frmEncuesta;
import Vista.frmInicioSesion;
import Vista.frmMenuPrincipal;
import Vista.frmPerfilUsuario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class ctrlMenuPrincipal implements ActionListener {
    private sqlPerfilUsuario sqlPerfilUsuario;
    private sqlEncuestaRealizada sqlEncuestaRealizada;
    private frmMenuPrincipal frmMenuPrincipal;
    private frmPerfilUsuario frmPerfilUsuario;
    private frmEncuesta frmEncuesta;
    private frmInicioSesion frmInicioSesion;
    private ctrlUsuario ctrlPerfilUsuario;
    private ctrlEncuesta ctrlEncuesta;
    
    public ctrlMenuPrincipal(sqlPerfilUsuario sqlPerfilUsuario, sqlEncuestaRealizada sqlEncuestaRealizada, frmMenuPrincipal frmMenuPrincipal, frmPerfilUsuario frmPerfilUsuario, frmEncuesta frmEncuesta, frmInicioSesion frmInicioSesion, ctrlUsuario ctrlPerfilUsuario, ctrlEncuesta ctrlEncuesta) {
        this.sqlPerfilUsuario = sqlPerfilUsuario;
        this.sqlEncuestaRealizada = sqlEncuestaRealizada;
        this.frmMenuPrincipal = frmMenuPrincipal;
        this.frmPerfilUsuario = frmPerfilUsuario;
        this.frmEncuesta = frmEncuesta;
        this.frmInicioSesion = frmInicioSesion;
        this.ctrlPerfilUsuario = ctrlPerfilUsuario;
        this.ctrlEncuesta = ctrlEncuesta;
        this.frmMenuPrincipal.btnUsuarios.addActionListener(this);
        this.frmMenuPrincipal.btnEncuestas.addActionListener(this);
        this.frmMenuPrincipal.btnPerfil.addActionListener(this);
        this.frmMenuPrincipal.btnEncuesta.addActionListener(this);
        this.frmMenuPrincipal.btnCerrar.addActionListener(this);
    }
    
    public void ejecutarFormuluario() {
        frmMenuPrincipal.setTitle("Quickvey-19");
        frmMenuPrincipal.setLocationRelativeTo(null);
        if(sqlPerfilUsuario.obtenerPerfilUsuario(Integer.parseInt(frmMenuPrincipal.txtIdUsuario.getText())) == 1) {
            frmMenuPrincipal.btnEncuestas.setVisible(true);
            frmMenuPrincipal.btnUsuarios.setVisible(true);
            frmMenuPrincipal.btnPerfil.setVisible(false);
            frmMenuPrincipal.btnEncuesta.setVisible(false);
        }
        else if(sqlPerfilUsuario.obtenerPerfilUsuario(Integer.parseInt(frmMenuPrincipal.txtIdUsuario.getText())) == 2) {
            frmMenuPrincipal.btnPerfil.setVisible(true);
            frmMenuPrincipal.btnEncuesta.setVisible(true);
            frmMenuPrincipal.btnEncuestas.setVisible(false);
            frmMenuPrincipal.btnUsuarios.setVisible(false);
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == frmMenuPrincipal.btnUsuarios) {
            frmMenuPrincipal.setVisible(false);
            ctrlPerfilUsuario.ejecutarFormuluario();
            frmPerfilUsuario.setVisible(true);
            frmPerfilUsuario.txtIdUsuario.setText(frmMenuPrincipal.txtIdUsuario.getText());
            frmPerfilUsuario.txtIdPersona.setText(frmMenuPrincipal.txtIdPersona.getText());
        }
        
        if (e.getSource() == frmMenuPrincipal.btnEncuesta) {
            if(sqlEncuestaRealizada.validarEncuestaRealizada(1, Integer.parseInt(frmMenuPrincipal.txtIdUsuario.getText())) == 0) {
                frmMenuPrincipal.setVisible(false);
                ctrlEncuesta.ejecutarFormuluario();
                frmEncuesta.setVisible(true);
            }
            else {
                JOptionPane.showMessageDialog(null, "Por el momento no tiene ninguna encuesta activa.", "Aviso", JOptionPane.WARNING_MESSAGE);
            }
        }
        
        if (e.getSource() == frmMenuPrincipal.btnCerrar) {
            frmMenuPrincipal.setVisible(false);
            frmInicioSesion.setVisible(true);
            frmInicioSesion.txtNombreUsuario.setText(null);
            frmInicioSesion.txtPassword.setText(null);
            frmInicioSesion.txtNombreUsuario.grabFocus();
        }
    }
}