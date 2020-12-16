package Modelo;

public class RespuestaPregunta {
    protected int iIdPregunta;
    protected int iIdRespuesta;
    protected int lActivo;
    protected String dtAlta;
    protected String dtModificacion;
    
    public RespuestaPregunta() {
        this.iIdPregunta = 0;
        this.iIdRespuesta = 0;
        this.lActivo = 0;
        this.dtAlta = "";
        this.dtModificacion = "";
    }
     
    public RespuestaPregunta(int iIdPregunta, int iIdRespuesta, int lActivo, String dtAlta, String dtModificacion) {
        this.iIdPregunta = iIdPregunta;
        this.iIdRespuesta = iIdRespuesta;
        this.lActivo = lActivo;
        this.dtAlta = dtAlta;
        this.dtModificacion = dtModificacion;
    }
   
    public int getIdPregunta() {
        return this.iIdPregunta;
    }
    
    public int getIdRespuesta() {
        return this.iIdRespuesta;
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
    
    public void setIdPregunta(int iIdPregunta) {
        this.iIdPregunta = iIdPregunta;
    }
    
    public void setIdRespuesta(int iIdRespuesta) {
        this.iIdRespuesta = iIdRespuesta;
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
