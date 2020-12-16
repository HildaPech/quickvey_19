package Controlador;

import Modelo.Usuario;
import Modelo.hash;
import Modelo.sqlPersona;
import Modelo.sqlUsuario;
import Vista.frmPassword;
import Vista.frmPerfilUsuario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

public class ctrlPassword implements ActionListener {
    private Usuario usuario;
    private sqlUsuario sqlUsuario;
    private frmPassword frmPassword;
    private frmPerfilUsuario frmPerfilUsuario;
    
    public ctrlPassword(Usuario usuario, sqlUsuario sqlUsuario, frmPerfilUsuario frmPerfilUsuario, frmPassword frmPassword) {
        this.usuario = usuario;
        this.sqlUsuario = sqlUsuario;
        this.frmPassword = frmPassword;
        this.frmPerfilUsuario = frmPerfilUsuario;
        this.frmPassword.btnCerrar.addActionListener(this);
        this.frmPassword.btnGuardar.addActionListener(this);
        this.frmPassword.btnCancelar.addActionListener(this);
    }
    
    public void ejecutarFormuluario() {
        frmPassword.setTitle("Información del Perfil");
        frmPassword.setLocationRelativeTo(null);
        frmPassword.txtPasswordActual.grabFocus();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == frmPassword.btnCerrar) {
            frmPassword.setVisible(false);
            frmPerfilUsuario.setVisible(true);
        }
        
        if (e.getSource() == frmPassword.btnGuardar) {
            Date today = new Date();
            String passwordCifrado;
            
            DateFormat formatofechaHora = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            
            String passwordActual = new String(frmPassword.txtPasswordActual.getPassword());
            String passwordNuevo1 = new String(frmPassword.txtPasswordNuevo1.getPassword());
            String passwordNuevo2 = new String(frmPassword.txtPasswordNuevo2.getPassword());
            
            if(passwordActual.equals("")) {
                JOptionPane.showMessageDialog(null, "Debe capturar un valor para el campo \n\"Contraseña Actual\".", "Error", JOptionPane.ERROR_MESSAGE);
                frmPassword.txtPasswordActual.grabFocus();
            }
            else if(passwordNuevo1.equals("")) {
                JOptionPane.showMessageDialog(null, "Debe capturar un valor para el campo \n\"Contraseña Nueva\".", "Error", JOptionPane.ERROR_MESSAGE);
                frmPassword.txtPasswordNuevo1.grabFocus();
            }
            else if(passwordNuevo2.equals("")) {
                JOptionPane.showMessageDialog(null, "Debe capturar un valor para el campo \n\"Confirmar Contraseña Nueva\".", "Error", JOptionPane.ERROR_MESSAGE);
                frmPassword.txtPasswordNuevo2.grabFocus();
            }
            else if(passwordNuevo1.equals(passwordNuevo2) == false) {
                JOptionPane.showMessageDialog(null, "Las nuevas contraseñas introducidas no coinciden.", "Error", JOptionPane.ERROR_MESSAGE);
                frmPassword.txtPasswordNuevo1.grabFocus();
            }
            else {
                passwordCifrado = hash.md5(passwordActual);
                
                usuario.setIdUsuario(Integer.parseInt(frmPerfilUsuario.txtIdUsuario.getText()));
                usuario.setPassword(passwordCifrado);
                
                if(sqlUsuario.validarPassword(usuario) == 0) {
                    JOptionPane.showMessageDialog(null, "La contraseña actual es incorrecta.", "Error", JOptionPane.ERROR_MESSAGE);
                    frmPassword.txtPasswordNuevo1.grabFocus();
                }
                else {
                    passwordCifrado = hash.md5(passwordNuevo1);
                    
                    usuario.setPassword(passwordCifrado);
                    usuario.setModificacion(formatofechaHora.format(today));
                    
                    if(sqlUsuario.modificarPassword(usuario)) {
                        JOptionPane.showMessageDialog(null, "La contraseña se cambió correctamente.", "Información", JOptionPane.INFORMATION_MESSAGE);
                        frmPassword.setVisible(false);
                        frmPerfilUsuario.setVisible(true);
                    }
                    else {
                        JOptionPane.showMessageDialog(null, "La contraseña no pudo ser modificada.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        }
        
        if (e.getSource() == frmPassword.btnCancelar) {
            frmPassword.setVisible(false);
            frmPerfilUsuario.setVisible(true);
        }
    }
}
