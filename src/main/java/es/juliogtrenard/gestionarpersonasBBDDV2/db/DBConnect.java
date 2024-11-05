package es.juliogtrenard.gestionarpersonasBBDDV2.db;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Conexión a la BBDD
 */
public class DBConnect {
    private final Connection connection;

    /**
     * Contructor que lanza la conexión
     *
     * @throws java.sql.SQLException Controlar errores
     */
    public DBConnect() throws SQLException {
        Properties connConfig = new Properties();
        connConfig.setProperty("user", "root");
        connConfig.setProperty("password", "mypass");

        connection = DriverManager.getConnection("jdbc:mariadb://127.0.0.1:33066/personas?serverTimezone=Europe/Madrid", connConfig);
        connection.setAutoCommit(true);
        DatabaseMetaData databaseMetaData = connection.getMetaData();

        /*System.out.println();
        System.out.println("--- Datos de conexión ------------------------------------------");
        System.out.printf("Base de datos: %s%n", databaseMetaData.getDatabaseProductName());
        System.out.printf("  Versión: %s%n", databaseMetaData.getDatabaseProductVersion());
        System.out.printf("Driver: %s%n", databaseMetaData.getDriverName());
        System.out.printf("  Versión: %s%n", databaseMetaData.getDriverVersion());
        System.out.println("----------------------------------------------------------------");
        System.out.println();
        connection.setAutoCommit(true);*/
    }

    /**
     * Devuelve la conexión creada
     *
     * @return una conexión a la BBDD
     */
    public Connection getConnection() {
        return connection;
    }

    /**
     * Cerrar la conexion con la base de datos
     *
     * @return La conexión cerrada.
     * @throws java.sql.SQLException Se lanza en caso de errores
     */
    public Connection closeConexion() throws SQLException {
        connection.close();
        return connection;
    }
}