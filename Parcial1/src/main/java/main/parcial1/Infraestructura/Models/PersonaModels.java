
package main.parcial1.Infraestructura.Models;

/**
 *
 * @author Humberto Galeano
 */
public class PersonaModels {
    public int Id;
    public int IdCiudad;
    public String Nombre;
    public String Apellido;
    public String TipoDocumento;
    public String NroDocumento;
    public String Direccion;
    public String Email;
    public String Celular;
    public String Estado;

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public int getIdCiudad() {
        return IdCiudad;
    }

    public void setIdCiudad(int IdCiudad) {
        this.IdCiudad = IdCiudad;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }

    public String getTipoDocumento() {
        return TipoDocumento;
    }

    public void setTipoDocumento(String TipoDocumento) {
        this.TipoDocumento = TipoDocumento;
    }

    public String getNroDocumento() {
        return NroDocumento;
    }

    public void setNroDocumento(String NroDocumento) {
        this.NroDocumento = NroDocumento;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getCelular() {
        return Celular;
    }

    public void setCelular(String Celular) {
        this.Celular = Celular;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

   
    public static void main(String args[]) {
        // TODO code application logic here
    }
}
