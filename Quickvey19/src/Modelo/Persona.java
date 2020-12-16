package Modelo;

public class Persona {
    protected int iIdPersona;
    protected String cPrimerApellido;
    protected String cSegundoApellido;
    protected String cNombre;
    protected String dtFechaNacimiento;
    protected String cSexo;
    protected String cCorreoElectronico;
    protected int lActivo;
    protected String dtAlta;
    protected String dtModificacion;
    
    public Persona() {
        this.iIdPersona = 0;
        this.cPrimerApellido = "";
        this.cSegundoApellido = "";
        this.cNombre = "";
        this.dtFechaNacimiento = "";
        this.cSexo = "";
        this.cCorreoElectronico = "";
        this.lActivo = 0;
        this.dtAlta = "";
        this.dtModificacion = "";
    }
     
    public Persona(int iIdPersona, String cPrimerApellido, String cSegundoApellido, String cNombre, String dtFechaNacimiento, String cSexo, String cCorreoElectronico, int lActivo, String dtAlta, String dtModificacion) {
        this.iIdPersona = iIdPersona;
        this.cPrimerApellido = cPrimerApellido;
        this.cSegundoApellido = cSegundoApellido;
        this.cNombre = cNombre;
        this.dtFechaNacimiento = dtFechaNacimiento;
        this.cSexo = cSexo;
        this.cCorreoElectronico = cCorreoElectronico;
        this.lActivo = lActivo;
        this.dtAlta = dtAlta;
        this.dtModificacion = dtModificacion;
    }
   
    public int getIdPersona() {
        return this.iIdPersona;
    }
    
    public String getPrimerApellido() {
        return this.cPrimerApellido;
    }
    
    public String getSegundoApellido() {
        return this.cSegundoApellido;
    }
    
    public String getNombre() {
        return this.cNombre;
    }
    
    public String getFechaNacimiento() {
        return this.dtFechaNacimiento;
    }
    
    public String getSexo() {
        return this.cSexo;
    }
    
    public String getCorreoElectronico() {
        return this.cCorreoElectronico;
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
    
    public void setIdPersona(int iIdPersona) {
        this.iIdPersona = iIdPersona;
    }
    
    public void setPrimerApellido(String cPrimerApellido) {
        this.cPrimerApellido = cPrimerApellido;
    }
    
    public void setSegundoApellido(String cSegundoApellido) {
        this.cSegundoApellido = cSegundoApellido;
    }
    
    public void setNombre(String cNombre) {
        this.cNombre = cNombre;
    }
    
    public void setFechaNacimiento(String dtFechaNacimiento) {
        this.dtFechaNacimiento = dtFechaNacimiento;
    }
    
    public void setSexo(String cSexo) {
        this.cSexo = cSexo;
    }
    
    public void setCorreoElectronico(String cCorreoElectronico) {
        this.cCorreoElectronico = cCorreoElectronico;
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
