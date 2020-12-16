package Controlador;

import Modelo.Usuario;
import Modelo.sqlPerfilUsuario;
import Modelo.sqlUsuario;
import Vista.frmInicioSesion;
import Vista.frmMenuAdministrador;
import Vista.frmMenuUsuario;
import Vista.frmRegistroUsuario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ctrlInicioSesion implements ActionListener {
    private Usuario usuario;
    private sqlUsuario sqlUsuario;
    private sqlPerfilUsuario sqlPerfilUsuario;
    private frmInicioSesion frmInicioSesion;
    private frmMenuAdministrador frmMenuAdministrador;
    private frmMenuUsuario frmMenuUsuario;
    private frmRegistroUsuario frmRegistroUsuario;
    private ctrlMenuPrincipal ctrlMenuPrincipal;
    private ctrlRegistroUsuario ctrlRegistroUsuario;
    
    public ctrlInicioSesion(Usuario usuario, sqlUsuario sqlUsuario, sqlPerfilUsuario sqlPerfilUsuario, frmInicioSesion frmInicioSesion, frmMenuAdministrador frmMenuAdministrador, frmMenuUsuario frmMenuUsuario, frmRegistroUsuario frmRegistroUsuario, ctrlMenuPrincipal ctrlMenuPrincipal, ctrlRegistroUsuario ctrlRegistroUsuario) {
        this.usuario = usuario;
        this.sqlUsuario = sqlUsuario;
        this.sqlPerfilUsuario = sqlPerfilUsuario;
        this.frmInicioSesion = frmInicioSesion;
        this.frmMenuAdministrador = frmMenuAdministrador;
        this.frmMenuUsuario = frmMenuUsuario;
        this.frmRegistroUsuario = frmRegistroUsuario;
        this.ctrlMenuPrincipal = ctrlMenuPrincipal;
        this.ctrlRegistroUsuario = ctrlRegistroUsuario;
        this.frmInicioSesion.btnIniciarSesion.addActionListener(this);
        this.frmInicioSesion.btnCrearCuenta.addActionListener(this);
    }
    
    public void ejecutarFormuluario() {
        frmInicioSesion.setTitle("Iniciar Sesión");
        frmInicioSesion.setLocationRelativeTo(null);
        frmInicioSesion.txtNombreUsuario.grabFocus();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == frmInicioSesion.btnIniciarSesion) {
            Usuario usuario = new Usuario();
            sqlUsuario sqlUsuario = new sqlUsuario();
            
            String password = new String(frmInicioSesion.txtPassword.getPassword());
            
            if(frmInicioSesion.txtNombreUsuario.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Debe capturar un valor para el campo \n\"Usuario\".", "Error", JOptionPane.ERROR_MESSAGE);
                frmInicioSesion.txtNombreUsuario.grabFocus();
            } 
            else if(password.equals("")) {
                JOptionPane.showMessageDialog(null, "Debe capturar un valor para el campo \n\"Contraseña\".", "Error", JOptionPane.ERROR_MESSAGE);
                frmInicioSesion.txtPassword.grabFocus();
            }
            else {
                usuario.setNombreUsuario(frmInicioSesion.txtNombreUsuario.getText());
                usuario.setPassword(password);
                
                if (sqlUsuario.iniciarSesion(usuario)) {
                    frmInicioSesion.setVisible(false);
                    if(sqlPerfilUsuario.obtenerPerfilUsuario(usuario.getIdUsuario()) == 1) {
                        ctrlMenuPrincipal.ejecutarFormuluarioAdministrador();
                        frmMenuAdministrador.setVisible(true);
                    }
                    else if(sqlPerfilUsuario.obtenerPerfilUsuario(usuario.getIdUsuario()) == 2) {
                        ctrlMenuPrincipal.ejecutarFormuluarioUsuario();
                        frmMenuUsuario.setVisible(true);
                        frmMenuUsuario.txtIdUsuario.setText(Integer.toString(usuario.getIdUsuario()));
                        frmMenuUsuario.txtIdPersona.setText(Integer.toString(usuario.getIdPersona()));
                    }
                }
                else {
                    JOptionPane.showMessageDialog(null, "El nombre de usuario y/o la contraseña son incorrectos.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
        
        if (e.getSource() == frmInicioSesion.btnCrearCuenta) {
            frmInicioSesion.setVisible(false);
            ctrlRegistroUsuario.ejecutarFormuluario();
            frmRegistroUsuario.setVisible(true);
        }
    }
}