package Controlador;

import Modelo.Persona;
import Modelo.Usuario;
import Modelo.sqlPersona;
import Modelo.sqlUsuario;
import Vista.frmInicioSesion;
import Vista.frmMenuUsuario;
import Vista.frmPassword;
import Vista.frmPerfilUsuario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.System.Logger;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

public class ctrlUsuario implements ActionListener {
    private Persona persona;
    private sqlPersona sqlPersona;
    private Usuario usuario;
    private sqlUsuario sqlUsuario;
    private frmMenuUsuario frmMenuUsuario;
    private frmPassword frmPassword;
    private frmPerfilUsuario frmPerfilUsuario;
    private ctrlPassword ctrlPassword;
    
    public ctrlUsuario(Persona persona, sqlPersona sqlPersona, Usuario usuario, sqlUsuario sqlUsuario, frmMenuUsuario frmMenuUsuario, frmPerfilUsuario frmPerfilUsuario, frmPassword frmPassword, ctrlPassword ctrlPassword) {
        this.persona = persona;
        this.sqlPersona = sqlPersona;
        this.usuario = usuario;
        this.sqlUsuario = sqlUsuario;
        this.frmMenuUsuario = frmMenuUsuario;
        this.frmPassword = frmPassword;
        this.frmPerfilUsuario = frmPerfilUsuario;
        this.ctrlPassword = ctrlPassword;
        this.frmPerfilUsuario.btnCerrar.addActionListener(this);
        this.frmPerfilUsuario.btnEditarPerfil.addActionListener(this);
        this.frmPerfilUsuario.btnModificarPassword.addActionListener(this);
        this.frmPerfilUsuario.btnEliminarCuenta.addActionListener(this);
        this.frmPerfilUsuario.btnGuardar.addActionListener(this);
        this.frmPerfilUsuario.btnCancelar.addActionListener(this);
    }
    
    public void ejecutarFormuluario() {
        frmPerfilUsuario.setTitle("Información del Perfil");
        frmPerfilUsuario.setLocationRelativeTo(null);
        llenarCampos();
        inactivarObjetos();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == frmPerfilUsuario.btnCerrar) {
            frmPerfilUsuario.setVisible(false);
            frmMenuUsuario.setVisible(true);
        }
        
        if (e.getSource() == frmPerfilUsuario.btnEditarPerfil) {
            activarObjetos();
            frmPerfilUsuario.txtPrimerApellido.grabFocus();
            frmPerfilUsuario.btnEditarPerfil.setEnabled(false);
            frmPerfilUsuario.btnModificarPassword.setEnabled(false);
            frmPerfilUsuario.btnEliminarCuenta.setEnabled(false);
        }
        
        if (e.getSource() == frmPerfilUsuario.btnModificarPassword) {
            frmPerfilUsuario.setVisible(false);
            ctrlPassword.ejecutarFormuluario();
            frmPassword.setVisible(true);
        }
        
        if (e.getSource() == frmPerfilUsuario.btnEliminarCuenta) {
            int respuesta;
            Object[] options = {"Si", "No"};
            
            respuesta = JOptionPane.showOptionDialog(null,
                        "¿Desea eliminar su cuenta?",
                        "Confirmación",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        options,
                        options[0]);
            
            if(respuesta == 0) {
                if(sqlUsuario.eliminarUsuario(usuario) && sqlPersona.eliminarPersona(persona)) {
                    JOptionPane.showMessageDialog(null, "La cuenta se eliminó correctamente.", "Información", JOptionPane.INFORMATION_MESSAGE);
                    inactivarObjetos();
                    frmPerfilUsuario.btnEditarPerfil.setEnabled(true);
                    frmPerfilUsuario.btnModificarPassword.setEnabled(true);
                    frmPerfilUsuario.btnEliminarCuenta.setEnabled(true);
                    System.exit(0);
                }
                else {
                    JOptionPane.showMessageDialog(null, "La cuenta no pudo ser eliminada.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
        
        if (e.getSource() == frmPerfilUsuario.btnGuardar) {
            Date today = new Date();
                        
            DateFormat formatofecha = new SimpleDateFormat("yyyy-MM-dd");
            DateFormat formatofechaHora = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            
            if(frmPerfilUsuario.txtPrimerApellido.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Debe capturar un valor para el campo \n\"Primer Apellido\".", "Error", JOptionPane.ERROR_MESSAGE);
                frmPerfilUsuario.txtPrimerApellido.grabFocus();
            } 
            else if(frmPerfilUsuario.txtNombre.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Debe capturar un valor para el campo \n\"Nombre\".", "Error", JOptionPane.ERROR_MESSAGE);
                frmPerfilUsuario.txtNombre.grabFocus();
            }
            else if (frmPerfilUsuario.dtFechaNacimiento.getDate() == null) {
                JOptionPane.showMessageDialog(null, "Debe seleccionar un valor para el campo \n\"Fecha de Nacimiento\".", "Error", JOptionPane.ERROR_MESSAGE);
                frmPerfilUsuario.dtFechaNacimiento.grabFocus();
            }   
            else if(frmPerfilUsuario.optHombre.isSelected() == false && frmPerfilUsuario.optMujer.isSelected() == false){
                JOptionPane.showMessageDialog(null, "Debe seleccionar un valor para el campo \n\"Sexo\".", "Error", JOptionPane.ERROR_MESSAGE);
                frmPerfilUsuario.optHombre.grabFocus();
            }
            else if(frmPerfilUsuario.txtCorreoElectronico.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Debe capturar un valor para el campo \n\"Correo Electrónico\".", "Error", JOptionPane.ERROR_MESSAGE);
                frmPerfilUsuario.txtCorreoElectronico.grabFocus();
            }
            else {
                persona.setPrimerApellido(frmPerfilUsuario.txtPrimerApellido.getText());
                persona.setSegundoApellido(frmPerfilUsuario.txtSegundoApellido.getText());
                persona.setNombre(frmPerfilUsuario.txtNombre.getText());
                    
                Date date = frmPerfilUsuario.dtFechaNacimiento.getDate();
                long dateLong = date.getTime();
                java.sql.Date fechaNacimiento = new java.sql.Date(dateLong);
                    
                persona.setFechaNacimiento(formatofecha.format(fechaNacimiento));
                    
                if(frmPerfilUsuario.optHombre.isSelected() == true) {
                    persona.setSexo("H");
                }
                else if (frmPerfilUsuario.optMujer.isSelected() == true) {
                    persona.setSexo("M");
                }
                
                persona.setCorreoElectronico(frmPerfilUsuario.txtCorreoElectronico.getText());
                persona.setModificacion(formatofechaHora.format(today));
                
                usuario.setNombreUsuario(frmPerfilUsuario.txtCorreoElectronico.getText());
                usuario.setModificacion(formatofechaHora.format(today));
                                                
                if(sqlPersona.modificarPersona(persona) && sqlUsuario.modificarNombreUsuario(usuario)) {
                    JOptionPane.showMessageDialog(null, "La actualización del perfil se realizó correctamente.", "Información", JOptionPane.INFORMATION_MESSAGE);
                    inactivarObjetos();
                    frmPerfilUsuario.btnEditarPerfil.setEnabled(true);
                    frmPerfilUsuario.btnModificarPassword.setEnabled(true);
                    frmPerfilUsuario.btnEliminarCuenta.setEnabled(true);
                }
                else {
                    JOptionPane.showMessageDialog(null, "El perfil del usuario no fue actualizado.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
        
        if (e.getSource() == frmPerfilUsuario.btnCancelar) {
            inactivarObjetos();
            frmPerfilUsuario.btnEditarPerfil.setEnabled(true);
            frmPerfilUsuario.btnModificarPassword.setEnabled(true);
            frmPerfilUsuario.btnEliminarCuenta.setEnabled(true);
        }
    }
    
    public void limpiarCampos() {
        frmPerfilUsuario.txtPrimerApellido.setText(null);
        frmPerfilUsuario.txtSegundoApellido.setText(null);
        frmPerfilUsuario.txtNombre.setText(null);
        frmPerfilUsuario.dtFechaNacimiento.setDate(null);
        frmPerfilUsuario.optHombre.setSelected(false);
        frmPerfilUsuario.optMujer.setSelected(false);
        frmPerfilUsuario.txtCorreoElectronico.setText(null);
    }
    
    public void llenarCampos() {
        persona.setIdPersona(Integer.parseInt(frmMenuUsuario.txtIdPersona.getText()));
        usuario.setIdUsuario(Integer.parseInt(frmMenuUsuario.txtIdUsuario.getText()));
        
        sqlPersona.visualizarPersona(persona);
        
        frmPerfilUsuario.txtPrimerApellido.setText(persona.getPrimerApellido());
        frmPerfilUsuario.txtSegundoApellido.setText(persona.getSegundoApellido());
        frmPerfilUsuario.txtNombre.setText(persona.getNombre());
        
        
        SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
        Date fechaTexto;
            
        try {
            fechaTexto = formatoFecha.parse(persona.getFechaNacimiento());
            frmPerfilUsuario.dtFechaNacimiento.setDate(fechaTexto);
        } catch (ParseException ex) {
            //Logger.getLogger(ctrlUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
                
        if(persona.getSexo().equals("H")) {
            frmPerfilUsuario.optHombre.setSelected(true);
        }
        else if (persona.getSexo().equals("M")) {
            frmPerfilUsuario.optMujer.setSelected(false);
        }    
        
        frmPerfilUsuario.txtCorreoElectronico.setText(persona.getCorreoElectronico());
    }
    
    public void inactivarObjetos() {
        frmPerfilUsuario.txtPrimerApellido.setEditable(false);
        frmPerfilUsuario.txtSegundoApellido.setEditable(false);
        frmPerfilUsuario.txtNombre.setEditable(false);
        frmPerfilUsuario.dtFechaNacimiento.setEnabled(false);
        frmPerfilUsuario.optHombre.setEnabled(false);
        frmPerfilUsuario.optMujer.setEnabled(false);
        frmPerfilUsuario.txtCorreoElectronico.setEditable(false);
        frmPerfilUsuario.btnGuardar.setEnabled(false);
        frmPerfilUsuario.btnCancelar.setEnabled(false);
    }
    
    public void activarObjetos() {
        frmPerfilUsuario.txtPrimerApellido.setEditable(true);
        frmPerfilUsuario.txtSegundoApellido.setEditable(true);
        frmPerfilUsuario.txtNombre.setEditable(true);
        frmPerfilUsuario.dtFechaNacimiento.setEnabled(true);
        frmPerfilUsuario.optHombre.setEnabled(true);
        frmPerfilUsuario.optMujer.setEnabled(true);
        frmPerfilUsuario.txtCorreoElectronico.setEditable(true);
        frmPerfilUsuario.btnGuardar.setEnabled(true);
        frmPerfilUsuario.btnCancelar.setEnabled(true);
    }
}