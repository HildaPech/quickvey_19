package Modelo;

public class Respuesta {
    protected int iIdRespuesta;
    protected String cRespuesta;
    protected int iPuntaje;
    protected int lActivo;
    protected String dtAlta;
    protected String dtModificacion;
    
    public Respuesta() {
        this.iIdRespuesta = 0;
        this.cRespuesta = "";
        this.iPuntaje = 0;
        this.lActivo = 0;
        this.dtAlta = "";
        this.dtModificacion = "";
    }
     
    public Respuesta(int iIdRespuesta, String cRespuesta, int iPuntaje, int lActivo, String dtAlta, String dtModificacion) {
        this.iIdRespuesta = iIdRespuesta;
        this.cRespuesta = cRespuesta;
        this.iPuntaje = iPuntaje;
        this.lActivo = lActivo;
        this.dtAlta = dtAlta;
        this.dtModificacion = dtModificacion;
    }
   
    public int getIdRespuesta() {
        return this.iIdRespuesta;
    }
    
    public String getRespuesta() {
        return this.cRespuesta;
    }
    
    public int getPuntaje() {
        return this.iPuntaje;
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
    
    public void setIdRespuesta(int iIdRespuesta) {
        this.iIdRespuesta = iIdRespuesta;
    }
    
    public void setRespuesta(String cRespuesta) {
        this.cRespuesta = cRespuesta;
    }
    
    public void setPuntaje(int iPuntaje) {
        this.iPuntaje = iPuntaje;
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
