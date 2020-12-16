package Modelo;

public class ResultadoEncuesta {
    protected int iIdEncuestaRealizada;
    protected int iIdPregunta;
    protected int iIdRespuesta;
    protected int lActivo;
    protected String dtAlta;
    protected String dtModificacion;
    
    public ResultadoEncuesta() {
        this.iIdEncuestaRealizada = 0;
        this.iIdPregunta = 0;
        this.iIdRespuesta = 0;
        this.lActivo = 0;
        this.dtAlta = "";
        this.dtModificacion = "";
    }
     
    public ResultadoEncuesta(int iIdEncuestaRealizada, int iIdPregunta, int iIdRespuesta, int lActivo, String dtAlta, String dtModificacion) {
        this.iIdEncuestaRealizada = iIdEncuestaRealizada;
        this.iIdPregunta = iIdPregunta;
        this.iIdRespuesta = iIdRespuesta;
        this.lActivo = lActivo;
        this.dtAlta = dtAlta;
        this.dtModificacion = dtModificacion;
    }
   
    public int getIdEncuestaRealizada() {
        return this.iIdEncuestaRealizada;
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
    
    public void setIdEncuestaRealizada(int iIdEncuestaRealizada) {
        this.iIdPregunta = iIdEncuestaRealizada;
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
