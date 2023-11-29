package db;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
public class DB {
    private static Connection conn = null;

    private static  Properties loadProperties(){
        try (FileInputStream fs = new FileInputStream("db.properties")){
            Properties props = new Properties();
            props.load(fs);
            return props;
        } catch (IOException e) {
            throw new DbException(e.getMessage());
        }
    }

    public static Connection getConnection()  { //método para fazer a conexão com o banco, usando as info em db.properties
        if (conn == null){
            try {
                Properties props = loadProperties();
                String url = props.getProperty("dburl");
                conn = DriverManager.getConnection(url, props);
            } catch (SQLException e) {
                throw new DbException(e.getMessage());
            }
        }
        return conn;
    }

    public static void closeConnection(){// fechar conexão com o banco
        if (conn != null){
            try{
                conn.close();
            } catch (SQLException e){
                throw new DbException(e.getMessage());
            }
        }
    }
}
