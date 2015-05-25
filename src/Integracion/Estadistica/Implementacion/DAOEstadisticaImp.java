/**
 *
 */
package Integracion.Estadistica.Implementacion;

import Integracion.Estadistica.DAOEstadistica;
import static Integracion.java.io.Scanner.*;
import static Integracion.java.io.PrintWritter.*;
import Negocio.Equipo.TransferEquipo;
import Negocio.Estadistica.TransferEstadistica;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;

public class DAOEstadisticaImp implements DAOEstadistica {
    
    private Connection conn;
	private Statement stmt;
	private Statement stmt2;
	private PreparedStatement pst;
	
	private boolean setConnectionAndStatement() {
		boolean correcto=false;
		// setConnection
		try {
			conn = DriverManager.getConnection  ("jdbc:oracle:thin:localhost:1521/IS_Proyecto","GIS07","GIS07");	
			correcto = true;
		} catch (SQLException e) {
			System.err.println("No se ha podido conectar a la BD");
			e.printStackTrace();
		}
		if (correcto){
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

	private void closeConnectionAndStatement() {
		try {
			if ( stmt != null ) stmt.close();
			if ( stmt2 != null ) stmt.close();
			if ( conn != null) conn.close(); 
			if( pst != null) pst.close();
		} catch (SQLException e) {
			System.err.println("Error al cerrar Connection o Statement");
			e.printStackTrace();
		}	
	}



	private int siguienteIdEstadisticaEquipo(){
		int valor = 0;
		try {
			stmt.execute("SELECT MAX(idEstadistica) AS MAX_ID FROM ESTADISTICA_EQUIPO" );
			try { 
				ResultSet rs = stmt.getResultSet();
				if (rs.next()){ 
					valor = rs.getInt("MAX_ID");
					valor++;
				}	
			} catch (SQLException e) {
				System.err.println("No se ha podido gneerar una id nueva");
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return valor;
	}
        
        private int siguienteIdEstadisticaPartido(){
		int valor = 0;
		try {
			stmt.execute("SELECT MAX(idEstadistica) AS MAX_ID FROM ESTADISTICA_PARTIDO" );
			try { 
				ResultSet rs = stmt.getResultSet();
				if (rs.next()){ 
					valor = rs.getInt("MAX_ID");
					valor++;
				}	
			} catch (SQLException e) {
				System.err.println("No se ha podido gneerar una id nueva");
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return valor;
	}
        
        private int siguienteIdEstadisticaJugador(){
		int valor = 0;
		try {
			stmt.execute("SELECT MAX(idEstadistica) AS MAX_ID FROM ESTADISTICA_JUGADOR" );
			try { 
				ResultSet rs = stmt.getResultSet();
				if (rs.next()){ 
					valor = rs.getInt("MAX_ID");
					valor++;
				}	
			} catch (SQLException e) {
				System.err.println("No se ha podido gneerar una id nueva");
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return valor;
	}

    public TransferEstadistica crearEstadistica(TransferEstadistica trEstadistica) {

        TransferEstadistica estadisticaVuelta = null;
		if (setConnectionAndStatement()){
			try {
				int idEstadisticaPartido = siguienteIdEstadisticaPartido();
				int idEstadisticaEquipo = siguienteIdEstadisticaEquipo();
                                int idEstadisticaJugador = siguienteIdEstadisticaJugador();
                                //DATOS TABLA EQUIPO
				stmt.executeUpdate("INSERT INTO ESTADISTICA_EQUIPO " +
						"VALUES( " + idEstadisticaEquipo + 
                                        ", " +  trEstadistica.getTaponesRecibidos()+ 
                                        ", " + trEstadistica.getTaponesRealizados() + 
                                        ", " + trEstadistica.getTirosLibresAcertados() + 
                                        ", " + trEstadistica.getTirosLibresFallados() + 
                                        ", " + trEstadistica.getTiros2Acertados() + 
                                        ", " + trEstadistica.getTiros2Fallados() +
                                        ", " + trEstadistica.getTiros3Acertados() +
                                        ", " + trEstadistica.getTiros3Fallados() +
                                        ", " + trEstadistica.getPerdidas() +
                                        ", " + trEstadistica.getRecuperaciones() +
                                        ", " + trEstadistica.getAsistencias() +
                                        ", " + trEstadistica.getRebotesOfensivos() +
                                        ", " + trEstadistica.getRebotesDefensivos() +
                                        ", " + trEstadistica.getFaltasRealizadas() +
                                        ", " + trEstadistica.getFaltasRecibidas() +  
                                        ", 'Madrid' "+
                                        ", 'Primera' )");
                                
                                
                                
                                stmt.executeUpdate("INSERT INTO ESTADISTICA_JUGADOR " +
						"VALUES( " + idEstadisticaEquipo + 
                                        ", " +  trEstadistica.getTaponesRecibidos()+ 
                                        ", " + trEstadistica.getTaponesRealizados() + 
                                        ", " + trEstadistica.getTirosLibresAcertados() + 
                                        ", " + trEstadistica.getTirosLibresFallados() + 
                                        ", " + trEstadistica.getTiros2Acertados() + 
                                        ", " + trEstadistica.getTiros2Fallados() +
                                        ", " + trEstadistica.getTiros3Acertados() +
                                        ", " + trEstadistica.getTiros3Fallados() +
                                        ", " + trEstadistica.getPerdidas() +
                                        ", " + trEstadistica.getRecuperaciones() +
                                        ", " + trEstadistica.getAsistencias() +
                                        ", " + trEstadistica.getRebotesOfensivos() +
                                        ", " + trEstadistica.getRebotesDefensivos() +
                                        ", " + trEstadistica.getFaltasRealizadas() +
                                        ", " + trEstadistica.getFaltasRecibidas() +  
                                        ", 'Cristiano' "+
                                        ", 'Ronaldo' )");
                                
                                stmt.executeUpdate("INSERT INTO ESTADISTICA_PARTIDO " +
						"VALUES( " + idEstadisticaEquipo + 
                                        ", " +  trEstadistica.getTaponesRecibidos()+ 
                                        ", " + trEstadistica.getTaponesRealizados() + 
                                        ", " + trEstadistica.getTirosLibresAcertados() + 
                                        ", " + trEstadistica.getTirosLibresFallados() + 
                                        ", " + trEstadistica.getTiros2Acertados() + 
                                        ", " + trEstadistica.getTiros2Fallados() +
                                        ", " + trEstadistica.getTiros3Acertados() +
                                        ", " + trEstadistica.getTiros3Fallados() +
                                        ", " + trEstadistica.getPerdidas() +
                                        ", " + trEstadistica.getRecuperaciones() +
                                        ", " + trEstadistica.getAsistencias() +
                                        ", " + trEstadistica.getRebotesOfensivos() +
                                        ", " + trEstadistica.getRebotesDefensivos() +
                                        ", " + trEstadistica.getFaltasRealizadas() +
                                        ", " + trEstadistica.getFaltasRecibidas() +  
                                        ", to_date('23/04/2011')"+
                                        ",  'ff')");
				
			
				estadisticaVuelta = trEstadistica;
				estadisticaVuelta.setId(idEstadisticaEquipo);                                  
				
			}
			catch (SQLIntegrityConstraintViolationException e){
				System.out.println("La BBDD contiene algun dato con la misma identidad");	
			}
			catch (java.sql.SQLSyntaxErrorException e) {
				System.out.println("La tabla que intenta modificar no existe en la BBDD.");	
                                System.out.println(e);
			}
			catch (SQLException e) {
				System.err.println("Error: Failed to create a connection object.");
				e.printStackTrace();
			}
		}
		else
			return null;
		closeConnectionAndStatement();
		return estadisticaVuelta;
		// end-user-code
	}

    public TransferEstadistica eliminarEstadistica(TransferEstadistica trEstadistica) {

        trEstadistica = null;

        return trEstadistica;
    }

    public TransferEstadistica verEstadistica(TransferEstadistica trEstadistica) {
        return null;
    }

    public TransferEstadistica actualizarEstadistica(TransferEstadistica trEstadistica) {

        return trEstadistica;
    }

    public TransferEstadistica acumular(TransferEstadistica trEstadistica) {
        return trEstadistica;
    }
}