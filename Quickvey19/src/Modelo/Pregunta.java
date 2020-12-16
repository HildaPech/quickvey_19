package Modelo;

public class Pregunta {
    protected int iIdPregunta;
    protected String cPregunta;
    protected int lActivo;
    protected String dtAlta;
    protected String dtModificacion;
    
    public Pregunta() {
        this.iIdPregunta = 0;
        this.cPregunta = "";
        this.lActivo = 0;
        this.dtAlta = "";
        this.dtModificacion = "";
    }
     
    public Pregunta(int iIdPregunta, String cPregunta, int lActivo, String dtAlta, String dtModificacion) {
        this.iIdPregunta = iIdPregunta;
        this.cPregunta = cPregunta;
        this.lActivo = lActivo;
        this.dtAlta = dtAlta;
        this.dtModificacion = dtModificacion;
    }
   
    public int getIdPregunta() {
        return this.iIdPregunta;
    }
    
    public String getPregunta() {
        return this.cPregunta;
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
    
    public void setPregunta(String cPregunta) {
        this.cPregunta = cPregunta;
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
