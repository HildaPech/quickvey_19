package Modelo;

public class Encuesta {
    protected int iIdEncuesta;
    protected String cNombreEncuesta;
    protected int lActivo;
    protected String dtAlta;
    protected String dtModificacion;
    
    public Encuesta() {
        this.iIdEncuesta = 0;
        this.cNombreEncuesta = "";
        this.lActivo = 0;
        this.dtAlta = "";
        this.dtModificacion = "";
    }
     
    public Encuesta(int iIdEncuesta, String cNombreEncuesta, int lActivo, String dtAlta, String dtModificacion) {
        this.iIdEncuesta = iIdEncuesta;
        this.cNombreEncuesta = cNombreEncuesta;
        this.lActivo = lActivo;
        this.dtAlta = dtAlta;
        this.dtModificacion = dtModificacion;
    }
   
    public int getIdEncuesta() {
        return this.iIdEncuesta;
    }
    
    public String getNombreEncuesta() {
        return this.cNombreEncuesta;
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
    
    public void setNombreEncuesta(String cNombreEncuesta) {
        this.cNombreEncuesta = cNombreEncuesta;
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
