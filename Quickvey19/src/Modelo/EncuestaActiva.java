package Modelo;

public class EncuestaActiva {
    protected int iIdEncuestaActiva;
    protected int iIdEncuesta;
    protected String dtInicioVigencia;
    protected String dtFinVigencia;
    protected int lActivo;
    protected String dtAlta;
    protected String dtModificacion;
    
    public EncuestaActiva() {
        this.iIdEncuestaActiva = 0;
        this.iIdEncuesta = 0;
        this.dtInicioVigencia = "";
        this.dtFinVigencia = "";
        this.lActivo = 0;
        this.dtAlta = "";
        this.dtModificacion = "";
    }
     
    public EncuestaActiva(int iIdEncuestaActiva, int iIdEncuesta, String dtInicioVigencia, String dtFinVigencia, int lActivo, String dtAlta, String dtModificacion) {
        this.iIdEncuestaActiva = iIdEncuestaActiva;
        this.iIdEncuesta = iIdEncuesta;
        this.dtInicioVigencia = dtInicioVigencia;
        this.dtFinVigencia = dtFinVigencia;
        this.lActivo = lActivo;
        this.dtAlta = dtAlta;
        this.dtModificacion = dtModificacion;
    }
   
    public int getIdEncuestaActiva() {
        return this.iIdEncuestaActiva;
    }
    
    public int getIdEncuesta() {
        return this.iIdEncuesta;
    }
    
    public String getInicioVigencia() {
        return this.dtInicioVigencia;
    }
    
    public String getFinVigencia() {
        return this.dtFinVigencia;
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
    
    public void setIdEncuestaActiva(int iIdEncuestaActiva) {
        this.iIdEncuesta = iIdEncuestaActiva;
    }
    
    public void setIdEncuesta(int iIdEncuesta) {
        this.iIdEncuesta = iIdEncuesta;
    }
    
    public void setInicioVigencia(String dtInicioVigencia) {
        this.dtInicioVigencia = dtInicioVigencia;
    }
    
    public void setFinVigencia(String dtFinVigencia) {
        this.dtFinVigencia = dtFinVigencia;
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
