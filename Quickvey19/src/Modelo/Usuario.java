package Modelo;

public class Usuario {
    protected int iIdUsuario;
    protected int iIdPersona;
    protected String cNombreUsuario;
    protected String cPassword;
    protected int lActivo;
    protected String dtAlta;
    protected String dtModificacion;
    
    public Usuario() {
        this.iIdUsuario = 0;
        this.iIdPersona = 0;
        this.cNombreUsuario = "";
        this.cPassword = "";
        this.lActivo = 0;
        this.dtAlta = "";
        this.dtModificacion = "";
    }
     
    public Usuario(int iIdUsuario, int iIdPersona, String cNombreUsuario, String cPassword, int lActivo, String dtAlta, String dtModificacion) {
        this.iIdUsuario = iIdUsuario;
        this.iIdPersona = iIdPersona;
        this.cNombreUsuario = cNombreUsuario;
        this.cPassword = cPassword;
        this.lActivo = lActivo;
        this.dtAlta = dtAlta;
        this.dtModificacion = dtModificacion;
    }
   
    public int getIdUsuario() {
        return this.iIdUsuario;
    }
    
    public int getIdPersona() {
        return this.iIdPersona;
    }
        
    public String getNombreUsuario() {
        return this.cNombreUsuario;
    }
    
    public String getPassword() {
        return this.cPassword;
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
    
    public void setIdPersona(int iIdPersona) {
        this.iIdPersona = iIdPersona;
    }
    
    public void setNombreUsuario(String cNombreUsuario) {
        this.cNombreUsuario = cNombreUsuario;
    }
    
    public void setPassword(String cPassword) {
        this.cPassword = cPassword;
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
