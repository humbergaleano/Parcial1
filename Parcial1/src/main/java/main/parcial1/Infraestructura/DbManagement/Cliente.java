
package main.parcial1.Infraestructura.DbManagement;

/**
 *
 * @author Humberto Galeano
 */
import main.parcial1.Infraestructura.Conections.Conexiones;
import main.parcial1.Infrastructura.Models.ClienteModels;
import java.sql.SQLException;

public class Cliente {
    private Conexiones conexion;

    public Cliente(String userBD, String passDB, String hostDB, String portDB, String dataBase){
        conexion = new Conexiones(userBD, passDB, hostDB, portDB, dataBase);
    }

    public String registrarCliente(ClienteModels cliente){

        try {
            conexion.setQuerySQL(conexion.conexionDB().createStatement());
            boolean execute = conexion.getQuerySQL().execute("INSERT INTO cliente (idpersona, fechaingreso, calificacion, estado)" +
                    "values('" +
                    cliente.IdPersona+ "', '" +
                    cliente.FechaIngreso + "', '" +
                    cliente.Calificacion + "', '" +
                    cliente.Estado + "')");
            conexion.conexionDB().close();
            return "El cliente fue registrado correctamente!!!";
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public String modificarCliente(ClienteModels cliente, int id){

        try {
            conexion.setQuerySQL(conexion.conexionDB().createStatement());
            boolean execute = conexion.getQuerySQL().execute("UPDATE cliente SET " +
                    "idpersona = '" + cliente.IdPersona + "'," +
                    "fechaingreso= '" + cliente.FechaIngreso + "'," +
                    "calificacion = '" + cliente.Calificacion + "'," +
                    "estado= '" + cliente.Estado + "' " + " Where id = " + id);
            conexion.conexionDB().close();
            return "Los datos del cliente fueron modificados correctamente!!!";
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public ClienteModels consultarCliente(int id){
        ClienteModels cliente = new ClienteModels();
        try {
            conexion.setQuerySQL(conexion.conexionDB().createStatement());
            conexion.setResultadoQuery(conexion.getQuerySQL().executeQuery("Select * from cliente where id = " + id));
            if(conexion.getResultadoQuery().next()){
                cliente.setIdPersona(conexion.getResultadoQuery().getInt("idpersona"));
                cliente.setFechaIngreso(conexion.getResultadoQuery().getDate("fechaingreso"));  
                cliente.setCalificacion(conexion.getResultadoQuery().getString("calificacion"));
                

                return cliente;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}