

package main.parcial1;
import main.parcial1.Infraestructura.DbManagement.Ciudad;
import main.parcial1.Infraestructura.DbManagement.Cliente;
import main.parcial1.Infraestructura.DbManagement.Cuentas;
import main.parcial1.Infraestructura.DbManagement.Movimientos;
import main.parcial1.Infraestructura.DbManagement.Persona;
import main.parcial1.Infraestructura.Models.CiudadModels;
import main.parcial1.Infraestructura.Models.ClienteModels;
import main.parcial1.Infraestructura.Models.CuentasModels;
import main.parcial1.Infraestructura.Models.CiudadModels;
import main.parcial1.Infraestructura.Models.PersonaModels;
import java.time.LocalDate;
import java.time.ZoneId;
import static java.time.temporal.TemporalQueries.localDate;
import java.util.Date;


public class Parcial1 {

    public static void main(String[] args) {
        
        Ciudad ciudadConn = new Ciudad("postgres","3312651","localhost","5432","exapar");
        Cliente clienteConn = new Cliente("postgres","3312651","localhost","5432","exapar");
        Cuentas cuentaConn = new Cuentas("postgres","3312651","localhost","5432","exapar");
        Movimientos movimientoConn = new Movimientos("postgres","3312651","localhost","5432","exapar");
        Persona personaConn = new Persona("postgres","3312651","localhost","5432","exapar");
        
        LocalDate fechaActual = LocalDate.now();
        Date fecha = Date.from(fechaActual.atStartOfDay(ZoneId.systemDefault()).toInstant());
        
        
        CiudadModels nuevaCiudad = new CiudadModels();
        nuevaCiudad.Ciudad = "Itaugua";
        nuevaCiudad.Departamento = "CENTRAL";
        nuevaCiudad.Postal = 2740;
        
        ciudadConn.registrarCiudad(nuevaCiudad);
        
        
        ClienteModels  nuevoCliente = new ClienteModels();
        nuevoCliente.IdPersona = 1;
        nuevoCliente.FechaIngreso = fecha;
        nuevoCliente.Calificacion = "23";
        nuevoCliente.Estado = "Activo";
        clienteConn.registrarCliente(nuevoCliente);
        
        
        CuentasModels nuevaCuenta = new CuentasModels();
        nuevaCuenta.IdCliente = 24;
        nuevaCuenta.NroCuenta = "3312651567";
        nuevaCuenta.FechaAlta = fecha;
        nuevaCuenta.TipoCuenta = "Contado";
        nuevaCuenta.Estado = "Inactivo";
        
        cuentaConn.registrarCuenta(nuevaCuenta);    
    }
}
