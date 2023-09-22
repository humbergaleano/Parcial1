
package main.parcial1.Infraestructura.DbManagement;

import main.parcial1.Infraestructura.Conections.Conexiones;
import main.parcial1.Infrastructura.Models.CiudadModels;
import java.sql.SQLException;
/**
 * @author Humberto Galeano
 */
public class Ciudad {
    private Conexiones conexion; 
    public Ciudad(String userBD, String passDB, String hostDB, String portDB, String dataBase){
         conexion = new Conexiones(userBD, passDB, hostDB, portDB, dataBase);
    }

    public String registrarCiudad(CiudadModels ciudad){

        try {
            conexion.setQuerySQL(conexion.conexionDB().createStatement());
            boolean execute = conexion.getQuerySQL().execute("INSERT INTO ciudad (ciudad,departamento,postal)" +
                    "values('" +
                    ciudad.Ciudad+ "', '" +
                    ciudad.Departamento + "', '" +
                    ciudad.Postal + "')");
            conexion.conexionDB().close();
            return "La ciudad " + ciudad.Ciudad + " fue registrada correctamente!!!";
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public String modificarCiudad(CiudadModels ciudad, int id){

        try {
            conexion.setQuerySQL(conexion.conexionDB().createStatement());
            boolean execute = conexion.getQuerySQL().execute("UPDATE ciudad SET " +
                    "Ciudad = '" + ciudad.Ciudad + "'," +
                    "Departamento = '" + ciudad.Departamento + "'," +
                    "Postal = '" + ciudad.Postal + "' " + " Where id = " + id);
            conexion.conexionDB().close();
            return "Los datos de la ciudad " + ciudad.Ciudad + " fue modificado correctamente!!!";
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public CiudadModels consultarCiudad(int id){
        CiudadModels ciudad = new CiudadModels();
        try {
            conexion.setQuerySQL(conexion.conexionDB().createStatement());
            conexion.setResultadoQuery(conexion.getQuerySQL().executeQuery("Select * from ciudad where id = " + id));
            if(conexion.getResultadoQuery().next()){
                ciudad.setCiudad( conexion.getResultadoQuery().getString("Ciudad"));
                ciudad.setDepartamento(conexion.getResultadoQuery().getString("Departamento"));
                ciudad.setPostal(conexion.getResultadoQuery().getInt("Postal"));
                
                return ciudad;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
    
}