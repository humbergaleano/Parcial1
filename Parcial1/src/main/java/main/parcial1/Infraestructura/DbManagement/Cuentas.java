
package main.parcial1.Infraestructura.DbManagement;

/**
 *
 * @author Humberto Galeano
 */
import com.mycompany.Infraestructura.Conexiones;
import com.mycompany.Infrastructura.Models.CuentasModels;
import java.sql.SQLException;

public class Cuentas {
    private Conexiones conexion;

    public Cuentas(String userBD, String passDB, String hostDB, String portDB, String dataBase){
        conexion = new Conexiones(userBD, passDB, hostDB, portDB, dataBase);
    }

    public String registrarCuenta(CuentasModels cuentas){

        try {
            conexion.setQuerySQL(conexion.conexionDB().createStatement());
            boolean execute = conexion.getQuerySQL().execute("INSERT INTO cuentas (idcliente, nrocuenta, fechaalta, tipocuenta, estado)" +
                    "values('" +
                    cuentas.IdCliente+ "', '" +
                    cuentas.NroCuenta + "', '" +
                    cuentas.FechaAlta + "', '" +
                    cuentas.TipoCuenta + "', '" +
                    cuentas.Estado + "')");
            conexion.conexionDB().close();
            return "La cuenta Nro: " + cuentas.NroCuenta + " fue registrada correctamente!!!";
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public String modificarCuenta(CuentasModels cuentas, int id){

        try {
            conexion.setQuerySQL(conexion.conexionDB().createStatement());
            boolean execute = conexion.getQuerySQL().execute("UPDATE cuentas SET " +
                    "idcliente = '" + cuentas.IdCliente + "'," +
                    "nrocuenta = '" + cuentas.NroCuenta + "'," +
                    "fechaalta = '" + cuentas.FechaAlta + "'," +
                    "tipocuenta = '" + cuentas.TipoCuenta + "'," +
                    "estado = '" + cuentas.Estado + "'" +
                    " Where id = " + id);
            conexion.conexionDB().close();
            return "Los datos de la cuenta Nro.: " + cuentas.NroCuenta + " fue modificado correctamente!!!";
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public CuentasModels consultarCuenta(int id){
        CuentasModels cuentas = new CuentasModels();
        try {
            conexion.setQuerySQL(conexion.conexionDB().createStatement());
            conexion.setResultadoQuery(conexion.getQuerySQL().executeQuery("Select * from cuentas where id = " + id));
            if(conexion.getResultadoQuery().next()){
                cuentas.setIdCliente(conexion.getResultadoQuery().getInt("idcliente"));
                cuentas.setNroCuenta(conexion.getResultadoQuery().getString("nrocuenta"));
                cuentas.setFechaAlta(conexion.getResultadoQuery().getDate("fechaalta"));


                return cuentas;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

}