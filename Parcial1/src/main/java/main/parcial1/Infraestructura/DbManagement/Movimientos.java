
package main.parcial1.Infraestructura.DbManagement;

/**
 *
 * @author Humberto Galeano
 */
import com.mycompany.Infraestructura.Conexiones;
import com.mycompany.Infrastructura.Models.MovimientosModels;
import java.sql.SQLException;

public class Movimientos {
    private Conexiones conexion;

    public Movimientos (String userBD, String passDB, String hostDB, String portDB, String dataBase){
        conexion = new Conexiones(userBD, passDB, hostDB, portDB, dataBase);
    }

    public String registrarMovimiento(MovimientosModels movimiento){

        try {
            conexion.setQuerySQL(conexion.conexionDB().createStatement());
            boolean execute = conexion.getQuerySQL().execute("INSERT INTO movimientos (idcuenta, fechamovimiento, tipomovimiento, saldoanterior, saldoactual, montomovimiento, cuentaorigen, cuentadestino, canal)" +
                    "values('" +
                    movimiento.IdCuenta+ "', '" +
                    movimiento.FechaMovimiento + "', '" +
                    movimiento.TipoMovimiento + "', '" +
                    movimiento.SaldoAnterior + "', '" +
                    movimiento.SaldoActual+ "', '" +
                    movimiento.MontoMovimiento + "', '" +
                    movimiento.CuentaOrigen+ "', '" +
                    movimiento.CuentaDestino + "', '" +
                    movimiento.Canal + "')");
            conexion.conexionDB().close();
            return "El registro de movimiento fue insertado correctamente!!!";
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public String modificarMovimiento(MovimientosModels movimiento, int id){

        try {
            conexion.setQuerySQL(conexion.conexionDB().createStatement());
            boolean execute = conexion.getQuerySQL().execute("UPDATE movimientos SET " +
                    "idcuenta= '" + movimiento.IdCuenta + "'," +
                    "fechamovimiento = '" + movimiento.FechaMovimiento + "'," +
                    "tipomovimiento= '" + movimiento.TipoMovimiento + "'," +
                    "saldoanterior= '" + movimiento.SaldoAnterior + "'," +
                    "saldoactual = '" + movimiento.SaldoActual + "'," +
                    "montomovimiento = '" + movimiento.MontoMovimiento + "'," +
                    "cuentaorigen = '" + movimiento.CuentaOrigen + "'," +
                    "cuentadestino= '" + movimiento.CuentaDestino + "'," +
                    "canal = '" + movimiento.Canal + "' " + " Where id = " + id);
            conexion.conexionDB().close();
            return "Los datos del movimiento fueron modificados correctamente!!!";
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public MovimientosModels consultarMovimiento(int id){
        MovimientosModels movimiento = new MovimientosModels();
        try {
            conexion.setQuerySQL(conexion.conexionDB().createStatement());
            conexion.setResultadoQuery(conexion.getQuerySQL().executeQuery("Select * from movimiento where id = " + id));
            if(conexion.getResultadoQuery().next()){
                movimiento.IdCuenta = conexion.getResultadoQuery().getInt("idcuenta");
                movimiento.MontoMovimiento = conexion.getResultadoQuery().getInt("montomovimiento");


                return movimiento;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}

