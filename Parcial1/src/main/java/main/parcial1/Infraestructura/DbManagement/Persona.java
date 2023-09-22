
package main.parcial1.Infraestructura.DbManagement;

/**
 *
 * @author Humberto Galeano
 */

import com.mycompany.Infraestructura.Conexiones;
import com.mycompany.Infrastructura.Models.PersonaModels;
import java.sql.SQLException;

public class Persona {
    private Conexiones conexion;

    public Persona (String userBD, String passDB, String hostDB, String portDB, String dataBase){
        conexion = new Conexiones(userBD, passDB, hostDB, portDB, dataBase);
    }

    public String registrarPersona(PersonaModels persona){

        try {
            conexion.setQuerySQL(conexion.conexionDB().createStatement());
            boolean execute = conexion.getQuerySQL().execute("INSERT INTO persona (idpersona, nombre, apellido, tipodocumento, nrodocumento, direccion, email, celular, estado)" +
                    "values('" +
                    persona.IdCiudad + "', '" +
                    persona.Nombre + "', '" +
                    persona.Apellido + "', '" +
                    persona.TipoDocumento + "', '" +
                    persona.NroDocumento + "', '" +
                    persona.Direccion + "', '" +
                    persona.Email + "', '" +
                    persona.Celular + "', '" +
                    persona.Estado + "')");
            conexion.conexionDB().close();
            return "La persona con nombre: " + persona.Nombre+", y apellido: "+persona.Apellido + " fue registrada correctamente!!!";
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public String modificarPersona(PersonaModels persona, int id){

        try {
            conexion.setQuerySQL(conexion.conexionDB().createStatement());
            boolean execute = conexion.getQuerySQL().execute("UPDATE persona SET " +
                    "nombre = '" + persona.Nombre + "'," +
                    "apellido = '" + persona.Apellido + "'," +
                    "tipodocumento = '" + persona.TipoDocumento + "'," +
                    "nrodocumento= '" + persona.NroDocumento + "'," +
                    "direccion = '" + persona.Direccion + "'," +
                    "email = '" + persona.Email + "'," +
                    "celular = '" + persona.Celular + "'," +
                    "estado = '" + persona.Estado + "' " + " Where id = " + id);
            conexion.conexionDB().close();
            return "Los datos de la persona " + persona.Nombre +" "+ persona.Apellido + " fueron modificados correctamente!!!";
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public PersonaModels consultarPersona(int id){
        PersonaModels persona = new PersonaModels();
        try {
            conexion.setQuerySQL(conexion.conexionDB().createStatement());
            conexion.setResultadoQuery(conexion.getQuerySQL().executeQuery("Select * from persona where id = " + id));
            if(conexion.getResultadoQuery().next()){
                persona.Nombre = conexion.getResultadoQuery().getString("nombre");
                persona.Apellido = conexion.getResultadoQuery().getString("apellido");


                return persona;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}