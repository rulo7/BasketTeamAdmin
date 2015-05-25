package Integracion.Conection;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conection {

    private Connection conn;
    private Statement stmt;
    private Statement stmt2;
    private PreparedStatement pst;

    public boolean setConnectionAndStatement() {
        boolean correcto = false;
        // setConnection
        try {
            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Conection.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            conn = DriverManager.getConnection("jdbc:mysql://db4free.net:3306/softwareis", "gis07", "software");
            correcto = true;
            DatabaseMetaData meta = conn.getMetaData();

            System.out.println("La versión del driver es: " + meta.getDriverVersion());
            System.out.println("Conectado ...");

        } catch (SQLException e) {
            System.err.println("No se ha podido conectar a la BD");
            e.printStackTrace();
        }
        if (correcto) {
            try {
                stmt = conn.createStatement();
                stmt2 = conn.createStatement();
            } catch (SQLException e) {
                System.err.println("Error al crear el Statement");
                e.printStackTrace();
            }
        }
        return correcto;
    }

    public void closeConnectionAndStatement() {
        try {
            if (stmt != null) {
                stmt.close();
            }
            if (stmt2 != null) {
                stmt.close();
            }
            if (conn != null) {
                conn.close();
            }
            if (pst != null) {
                pst.close();
            }
        } catch (SQLException e) {
            System.err.println("Error al cerrar Connection o Statement");
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return conn;
    }

    public Statement getStatement1() {
        return stmt;
    }

    public Statement getStatement2() {
        return stmt2;
    }

    public PreparedStatement getPreparedStatement() {
        return pst;
    }

    public void setConnection(Connection c) {
        conn = c;
    }

    public void setStatement1(Statement s) {
        stmt = s;
    }

    public void setStatement2(Statement s) {
        stmt2 = s;
    }

    public void setPreparedStatement(PreparedStatement ps) {
        pst = ps;
    }
}

