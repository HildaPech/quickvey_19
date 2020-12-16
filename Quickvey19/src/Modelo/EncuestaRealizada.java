package Modelo;

public class EncuestaRealizada {
    protected int iIdEncuestaRealizada;
    protected int iIdEncuesta;
    protected int iIdUsuario;
    protected int lActivo;
    protected String dtAlta;
    protected String dtModificacion;
    
    public EncuestaRealizada() {
        this.iIdEncuestaRealizada = 0;
        this.iIdEncuesta = 0;
        this.iIdUsuario = 0;
        this.lActivo = 0;
        this.dtAlta = "";
        this.dtModificacion = "";
    }
     
    public EncuestaRealizada(int iIdEncuestaRealizada, int iIdEncuesta, int iIdUsuario, int lActivo, String dtAlta, String dtModificacion) {
        this.iIdEncuestaRealizada = iIdEncuestaRealizada;
        this.iIdEncuesta = iIdEncuesta;
        this.iIdUsuario = iIdUsuario;
        this.lActivo = lActivo;
        this.dtAlta = dtAlta;
        this.dtModificacion = dtModificacion;
    }
   
    public int getIdEncuestaRealizada() {
        return this.iIdEncuestaRealizada;
    }
    
    public int getIdEncuesta() {
        return this.iIdEncuesta;
    }
    
    public int getIdUsuario() {
        return this.iIdUsuario;
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
        this.iIdEncuestaRealizada = iIdEncuestaRealizada;
    }
    
    public void setIdEncuesta(int iIdEncuesta) {
        this.iIdEncuesta = iIdEncuesta;
    }
    
    public void setIdUsuario(int iIdUsuario) {
        this.iIdUsuario = iIdUsuario;
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
