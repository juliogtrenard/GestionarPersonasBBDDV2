package es.juliogtrenard.gestionarpersonasBBDDV2.dao;

import es.juliogtrenard.gestionarpersonasBBDDV2.db.DBConnect;
import es.juliogtrenard.gestionarpersonasBBDDV2.modelos.Persona;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Clase para las consultas con la BBDD
 */
public class DaoPersona {
    /**
     * Carga los datos de la tabla Persona y los devuelve para usarlos en un listado de personas
     *
     * @return listado de personas para cargar en un tableview
     */
    public static ArrayList<Persona> cargarListado() {
        DBConnect conexion;
        ArrayList<Persona> listadoDePersonas = new ArrayList<>();

        try{
            conexion = new DBConnect();

            String consulta = "SELECT id,nombre,apellidos,edad FROM Persona";
            PreparedStatement pstmt = conexion.getConnection().prepareStatement(consulta);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                String apellidos = rs.getString("apellidos");
                int edad = rs.getInt("edad");
                Persona p = new Persona(id,nombre,apellidos,edad);
                listadoDePersonas.add(p);

            }
            rs.close();
            conexion.closeConexion();
        }catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return listadoDePersonas;
    }

    /**
     * Crea una persona en la BD
     *
     * @param persona La persona con sus datos
     * @return id/-1
     */
    public  static int insertar(Persona persona) {
        DBConnect conexion;
        PreparedStatement pstmt;

        try {
            conexion = new DBConnect();
            String consulta = "INSERT INTO Persona (nombre,apellidos,edad) VALUES (?,?,?) ";
            pstmt = conexion.getConnection().prepareStatement(consulta, PreparedStatement.RETURN_GENERATED_KEYS);

            pstmt.setString(1, persona.getNombre());
            pstmt.setString(2, persona.getApellidos());
            pstmt.setInt(3, persona.getEdad());

            int filasAfectadas = pstmt.executeUpdate();

            if (filasAfectadas > 0) {
                ResultSet rs = pstmt.getGeneratedKeys();
                if (rs.next()) {
                    int id = rs.getInt(1);
                    pstmt.close();
                    conexion.closeConexion();
                    return id;
                }
            }
            pstmt.close();
            conexion.closeConexion();
            return -1;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return -1;
        }
    }

    /**
     * Modifica los datos de una persona en la base de datos
     *
     * @param p Persona con datos nuevos
     * @return True -> Modificada, False -> No modificada
     */
    public static boolean modificar(Persona p) {
        DBConnect conexion;
        PreparedStatement pstmt;

        try {
            conexion = new DBConnect();
            String consulta = "UPDATE Persona SET nombre = ?,apellidos = ?,edad = ? WHERE id = ?";
            pstmt = conexion.getConnection().prepareStatement(consulta);

            pstmt.setString(1, p.getNombre());
            pstmt.setString(2, p.getApellidos());
            pstmt.setInt(3, p.getEdad());
            pstmt.setInt(4, p.getId());

            int filasAfectadas = pstmt.executeUpdate();

            pstmt.close();
            conexion.closeConexion();
            return filasAfectadas > 0;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    /**
     * Elimina una persona de la base de datos
     *
     * @param p Persona a eliminar
     * @return True -> Elimina, False -> No eliminada
     */
    public  static boolean eliminar(Persona p){
        DBConnect conexion;
        PreparedStatement pstmt;

        try {
            conexion = new DBConnect();
            String consulta = "DELETE FROM Persona WHERE (id = ?)";
            pstmt = conexion.getConnection().prepareStatement(consulta);
            pstmt.setInt(1, p.getId());
            int filasAfectadas = pstmt.executeUpdate();
            pstmt.close();
            conexion.closeConexion();

            return filasAfectadas > 0;
        } catch (SQLException e) {
            System.out.println(e.getMessage());

            return false;
        }
    }
}
