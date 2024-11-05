package es.juliogtrenard.gestionarpersonasBBDDV2.db;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
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
     * Constructor que lanza la conexión
     *
     * @throws java.sql.SQLException Controlar errores
     */
    public DBConnect() throws SQLException {
        Properties configuracion = getConfiguracion();
        Properties connConfig = new Properties();
        connConfig.setProperty("user", "root");
        connConfig.setProperty("password", "mypass");

        connection = DriverManager.getConnection("jdbc:mariadb://" + configuracion.getProperty("address") + ":" + configuracion.getProperty("port") + "/" + configuracion.getProperty("database") + "?serverTimezone=Europe/Madrid", connConfig);
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
     * Da la configuración para la conexión a la base de datos
     *
     * @return Properties con los datos de conexión a la base de datos
     */
    public static Properties getConfiguracion() {
        File f = new File("configuracion.properties");
        Properties properties;
        try {
            FileInputStream configFileReader=new FileInputStream(f);
            properties = new Properties();
            try {
                properties.load(configFileReader);
                configFileReader.close();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException("configuracion.properties not found at config file path " + f.getPath());
        }
        return properties;
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