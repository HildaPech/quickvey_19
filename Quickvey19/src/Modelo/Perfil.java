package Modelo;

public class Perfil {
    protected int iIdPerfil;
    protected String cNombrePerfil;
    protected int lActivo;
    protected String dtAlta;
    protected String dtModificacion;
    
    public Perfil() {
        this.iIdPerfil = 0;
        this.cNombrePerfil = "";
        this.lActivo = 0;
        this.dtAlta = "";
        this.dtModificacion = "";
    }
     
    public Perfil(int iIdPerfil, String cNombrePerfil, int lActivo, String dtAlta, String dtModificacion) {
        this.iIdPerfil = iIdPerfil;
        this.cNombrePerfil = cNombrePerfil;
        this.lActivo = lActivo;
        this.dtAlta = dtAlta;
        this.dtModificacion = dtModificacion;
    }
   
    public int getIdPerfil() {
        return this.iIdPerfil;
    }
    
    public String getNombrePerfil() {
        return this.cNombrePerfil;
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
    
    public void setIdPerfil(int iIdPerfil) {
        this.iIdPerfil = iIdPerfil;
    }
    
    public void setNombrePerfil(String cNombrePerfil) {
        this.cNombrePerfil = cNombrePerfil;
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
