package Modelo;

public class PreguntaEncuesta {
    protected int iIdEncuesta;
    protected int iIdPregunta;
    protected int lActivo;
    protected String dtAlta;
    protected String dtModificacion;
    
    public PreguntaEncuesta() {
        this.iIdEncuesta = 0;
        this.iIdPregunta = 0;
        this.lActivo = 0;
        this.dtAlta = "";
        this.dtModificacion = "";
    }
     
    public PreguntaEncuesta(int iIdEncuesta, int iIdPregunta, int lActivo, String dtAlta, String dtModificacion) {
        this.iIdEncuesta = iIdEncuesta;
        this.iIdPregunta = iIdPregunta;
        this.lActivo = lActivo;
        this.dtAlta = dtAlta;
        this.dtModificacion = dtModificacion;
    }
   
    public int getIdEncuesta() {
        return this.iIdEncuesta;
    }
    
    public int getIdPregunta() {
        return this.iIdPregunta;
    }
    
    public int getActivo() {
        return this.lActivo;
    }
    
    public String getAlta() {
        return this.dtAlta;
    }
    
    public String getModificacion() {
        return this.dtModificacion;
    }
    
    public void setIdEncuesta(int iIdEncuesta) {
        this.iIdEncuesta = iIdEncuesta;
    }
    
    public void setIdPregunta(int iIdPregunta) {
        this.iIdPregunta = iIdPregunta;
    }
        
    public void setActivo(int lActivo) {
        this.lActivo = lActivo;
    }
    
    public void setAlta(String dtAlta) {
        this.dtAlta = dtAlta;
    }
    
    public void setModificacion(String dtModificacion) {
        this.dtModificacion = dtModificacion;
    }
}
