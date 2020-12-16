package Controlador;

import Modelo.EncuestaRealizada;
import Modelo.ResultadoEncuesta;
import Modelo.sqlEncuestaRealizada;
import Modelo.sqlResultadoEncuesta;
import Vista.frmEncuesta;
import Vista.frmMenuUsuario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

public class ctrlEncuesta implements ActionListener {
    private EncuestaRealizada encuestaRealizada;
    private sqlEncuestaRealizada sqlEncuestaRealizada;
    private ResultadoEncuesta resultadoEncuesta;
    private sqlResultadoEncuesta sqlResultadoEncuesta;
    private frmMenuUsuario frmMenuUsuario;
    private frmEncuesta frmEncuesta;
    
    public ctrlEncuesta(EncuestaRealizada encuestaRealizada, sqlEncuestaRealizada sqlEncuestaRealizada, ResultadoEncuesta resultadoEncuesta, sqlResultadoEncuesta sqlResultadoEncuesta, frmMenuUsuario frmMenuUsuario, frmEncuesta frmEncuesta) {
        this.encuestaRealizada = encuestaRealizada;
        this.sqlEncuestaRealizada = sqlEncuestaRealizada;
        this.resultadoEncuesta = resultadoEncuesta;
        this.sqlResultadoEncuesta = sqlResultadoEncuesta;
        this.frmMenuUsuario = frmMenuUsuario;
        this.frmEncuesta = frmEncuesta;
        this.frmEncuesta.btnCerrar.addActionListener(this);
        this.frmEncuesta.btnGuardar.addActionListener(this);
        this.frmEncuesta.btnCancelar.addActionListener(this);
    }
    
    public void ejecutarFormuluario() {
        frmEncuesta.setTitle("Información del Perfil");
        frmEncuesta.setLocationRelativeTo(null);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == frmEncuesta.btnCerrar) {
            frmEncuesta.setVisible(false);
            frmMenuUsuario.setVisible(true);
        }
           
        if (e.getSource() == frmEncuesta.btnGuardar) {
            Date today = new Date();
                       
            DateFormat formatofechaHora = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                        
            if(frmEncuesta.cboRespuesta1.getSelectedItem().toString().equals("")) {
                JOptionPane.showMessageDialog(null, "Debe seleccionar una respuesta para la preguntaa No. 1.", "Error", JOptionPane.ERROR_MESSAGE);
                frmEncuesta.cboRespuesta1.grabFocus();
            } 
            else if(frmEncuesta.cboRespuesta2.getSelectedItem().toString().equals("")) {
                JOptionPane.showMessageDialog(null, "Debe seleccionar una respuesta para la preguntaa No. 2.", "Error", JOptionPane.ERROR_MESSAGE);
                frmEncuesta.cboRespuesta2.grabFocus();
            }
            else if(frmEncuesta.cboRespuesta3.getSelectedItem().toString().equals("")) {
                JOptionPane.showMessageDialog(null, "Debe seleccionar una respuesta para la preguntaa No. 3.", "Error", JOptionPane.ERROR_MESSAGE);
                frmEncuesta.cboRespuesta3.grabFocus();
            }   
            else if(frmEncuesta.cboRespuesta4.getSelectedItem().toString().equals("")) {
                JOptionPane.showMessageDialog(null, "Debe seleccionar una respuesta para la preguntaa No. 4.", "Error", JOptionPane.ERROR_MESSAGE);
                frmEncuesta.cboRespuesta4.grabFocus();
            }
            else if(frmEncuesta.cboRespuesta5.getSelectedItem().toString().equals("")) {
                JOptionPane.showMessageDialog(null, "Debe seleccionar una respuesta para la preguntaa No. 5.", "Error", JOptionPane.ERROR_MESSAGE);
                frmEncuesta.cboRespuesta5.grabFocus();
            }
            else if(frmEncuesta.cboRespuesta6.getSelectedItem().toString().equals("")) {
                JOptionPane.showMessageDialog(null, "Debe seleccionar una respuesta para la preguntaa No. 6.", "Error", JOptionPane.ERROR_MESSAGE);
                frmEncuesta.cboRespuesta6.grabFocus();
            }
            else if(frmEncuesta.cboRespuesta7.getSelectedItem().toString().equals("")) {
                JOptionPane.showMessageDialog(null, "Debe seleccionar una respuesta para la preguntaa No. 7.", "Error", JOptionPane.ERROR_MESSAGE);
                frmEncuesta.cboRespuesta7.grabFocus();
            }
            else if(frmEncuesta.cboRespuesta8.getSelectedItem().toString().equals("")) {
                JOptionPane.showMessageDialog(null, "Debe seleccionar una respuesta para la preguntaa No. 8.", "Error", JOptionPane.ERROR_MESSAGE);
                frmEncuesta.cboRespuesta8.grabFocus();
            }
            else if(frmEncuesta.cboRespuesta9.getSelectedItem().toString().equals("")) {
                JOptionPane.showMessageDialog(null, "Debe seleccionar una respuesta para la preguntaa No. 9.", "Error", JOptionPane.ERROR_MESSAGE);
                frmEncuesta.cboRespuesta9.grabFocus();
            }
            else if(frmEncuesta.cboRespuesta10.getSelectedItem().toString().equals("")) {
                JOptionPane.showMessageDialog(null, "Debe seleccionar una respuesta para la preguntaa No. 10.", "Error", JOptionPane.ERROR_MESSAGE);
                frmEncuesta.cboRespuesta10.grabFocus();
            }
            else {
                encuestaRealizada.setIdEncuesta(1);
                encuestaRealizada.setIdUsuario(Integer.parseInt(frmMenuUsuario.txtIdUsuario.getText()));
                encuestaRealizada.setActivo(1);
                encuestaRealizada.setAlta(formatofechaHora.format(today));
                encuestaRealizada.setModificacion(formatofechaHora.format(today));
                
                int[] respuestas = {frmEncuesta.cboRespuesta1.getSelectedIndex(), frmEncuesta.cboRespuesta2.getSelectedIndex(), frmEncuesta.cboRespuesta3.getSelectedIndex(), frmEncuesta.cboRespuesta4.getSelectedIndex(), frmEncuesta.cboRespuesta5.getSelectedIndex(), frmEncuesta.cboRespuesta6.getSelectedIndex(), frmEncuesta.cboRespuesta7.getSelectedIndex(), frmEncuesta.cboRespuesta8.getSelectedIndex(), frmEncuesta.cboRespuesta9.getSelectedIndex(), frmEncuesta.cboRespuesta10.getSelectedIndex()};
                String textoMensaje = "";
                
                if(sqlEncuestaRealizada.registrarEncuestaRealizada(encuestaRealizada)) {
                    for (int p = 0; p < 10; p++) {
                        resultadoEncuesta.setIdPregunta(p + 1);
                        resultadoEncuesta.setIdRespuesta(respuestas[p] + 1);
                        resultadoEncuesta.setAlta(formatofechaHora.format(today));
                        resultadoEncuesta.setModificacion(formatofechaHora.format(today));

                        if(sqlResultadoEncuesta.registrarRespuestaEncuesta(resultadoEncuesta)) {
                            textoMensaje = "Las respuestas de la encuesta se registraron correctamente.";
                        }
                        else {
                            textoMensaje = "La respuesta de la Pregunta No. " + (p + 1) + " no pudo ser registrada.";
                            break;
                        }
                    }
                    JOptionPane.showMessageDialog(null, textoMensaje, "Información", JOptionPane.INFORMATION_MESSAGE);                    
                    frmEncuesta.setVisible(false);
                    frmMenuUsuario.setVisible(true);
                }
                else {
                    JOptionPane.showMessageDialog(null, "Las respuestas de la encuesta no pudieron ser registradas.", "Error", JOptionPane.ERROR_MESSAGE);
                }

            }
        }
        
        if (e.getSource() == frmEncuesta.btnCancelar) {
            frmEncuesta.setVisible(false);
            frmMenuUsuario.setVisible(true);
        }
    }
}
