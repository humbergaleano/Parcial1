
package main.parcial1.Infraestructura.Models;
import java.util.Date;
/**
 *
 * @author Humberto Galeano
 */
public class ClienteModels {
    public int IdCliente;
    public int IdPersona;
    public Date FechaIngreso;
    public String Calificacion;
    public String Estado;

    public int getIdPersona() {
        return IdPersona;
    }

    public void setIdPersona(int IdPersona) {
        this.IdPersona = IdPersona;
    }

    public Date getFechaIngreso() {
        return FechaIngreso;
    }

    public void setFechaIngreso(Date FechaIngreso) {
        this.FechaIngreso = FechaIngreso;
    }

    public String getCalificacion() {
        return Calificacion;
    }

    public void setCalificacion(String Calificacion) {
        this.Calificacion = Calificacion;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }
    
}