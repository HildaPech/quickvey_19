package Modelo;

public class PerfilUsuario {
    protected int iIdUsuario;
    protected int iIdPerfil;
    protected int lActivo;
    protected String dtAlta;
    protected String dtModificacion;
    
    public PerfilUsuario() {
        this.iIdUsuario = 0;
        this.iIdPerfil = 0;
        this.lActivo = 0;
        this.dtAlta = "";
        this.dtModificacion = "";
    }
     
    public PerfilUsuario(int iIdUsuario, int iIdPerfil, int lActivo, String dtAlta, String dtModificacion) {
        this.iIdUsuario = iIdUsuario;
        this.iIdPerfil = iIdPerfil;
        this.lActivo = lActivo;
        this.dtAlta = dtAlta;
        this.dtModificacion = dtModificacion;
    }
   
    public int getIdUsuario() {
        return this.iIdUsuario;
    }
    
    public int getIdPerfil() {
        return this.iIdPerfil;
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
    
    public void setIdUsuario(int iIdUsuario) {
        this.iIdUsuario = iIdUsuario;
    }
    
    public void setIdPerfil(int iIdPerfil) {
        this.iIdPerfil = iIdPerfil;
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
