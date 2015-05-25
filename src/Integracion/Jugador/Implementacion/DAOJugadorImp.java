/**
 * 
 */
package Integracion.Jugador.Implementacion;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;

import Integracion.Jugador.DAOJugador;
import Negocio.Jugador.TransferJugador;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author SERCAMA
 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class DAOJugadorImp implements DAOJugador {
	private Connection conn;
	private Statement stmt;
	private Statement stmt2;
	private PreparedStatement pst;
	
	private boolean setConnectionAndStatement() {
		boolean correcto=false;
		try {
			conn = DriverManager.getConnection  ("jdbc:oracle:thin:@192.168.56.102:1521/orcl","GIS07","GIS07");	
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



	private int siguienteIdJugador(){
		int valor = 0;
		try {
			stmt.execute("SELECT MAX(idjugador) AS MAX_ID FROM JUGADOR" );
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
	
	
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public TransferJugador crearJugador(TransferJugador trJugador) {
		// begin-user-code
		// TODO Ap�ndice de m�todo generado autom�ticamente
		TransferJugador jugadorVuelta = null;
		if (setConnectionAndStatement()){
			try {
				int idJugador = siguienteIdJugador();
				//DATOS TABLA JUGADOR
				stmt.executeUpdate("INSERT INTO JUGADOR VALUES( "
						+ idJugador+ ", '"
						+ trJugador.getNombre()  + "', '" 
						+ trJugador.getApellidos() + "', '" 
						+ trJugador.getDNI() + "', " 
						+ trJugador.getDorsal() + ", " 
						+ trJugador.getEstatura() + ", "
						+ trJugador.getPeso() + ", '"
						+ trJugador.getPosicionPrincipal() + "', '"
						+ trJugador.getPosicionSecundaria() + "', "
						+ trJugador.getTelefono() + ", '"
						+ trJugador.getNacionalidad() + "', '"
						+ trJugador.getResidencia() + "', '"
						+ "VALENCIA" + "', '"
						+ "Item 1" + "', "
						+"to_date('"+ trJugador.getFechaNacimineto().getDay() + "/" + trJugador.getFechaNacimineto().getMonth() + "/" +
								trJugador.getFechaNacimineto().getYear() + "', 'DD/MM/YY'), '"
						+ trJugador.getCorreo() + "'"+" )");		
				
				jugadorVuelta = trJugador;
				jugadorVuelta.setId(idJugador);                                  
				
			}
			catch (SQLIntegrityConstraintViolationException e){
				System.out.println("La BBDD contiene algun dato con la misma identidad");	
			}
			catch (java.sql.SQLSyntaxErrorException e) {
				System.out.println("La tabla que intenta modificar no existe en la BBDD.");				
			}
			catch (SQLException e) {
				System.err.println("Error: Failed to create a connection object.");
				e.printStackTrace();
			}
		}
		else
			return null;
		closeConnectionAndStatement();
		return jugadorVuelta;
		// end-user-code
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void quitarEstadistica() {
		// begin-user-code
		// TODO Ap�ndice de m�todo generado autom�ticamente

		// end-user-code
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void verEstadisticasJornada() {
		// begin-user-code
		// TODO Ap�ndice de m�todo generado autom�ticamente

		// end-user-code
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void verEstadisticasTotal() {
		// begin-user-code
		// TODO Ap�ndice de m�todo generado autom�ticamente

		// end-user-code
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void asignarEstadistica() {
		// begin-user-code
		// TODO Ap�ndice de m�todo generado autom�ticamente

		// end-user-code
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public TransferJugador verJugador(TransferJugador trJugador) {
		// begin-user-code
		// TODO Ap�ndice de m�todo generado autom�ticamente
		return null;
		// end-user-code
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void actualizarJugador() {
		// begin-user-code
		// TODO Ap�ndice de m�todo generado autom�ticamente

		// end-user-code
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void eliminarJugador() {
		// begin-user-code
		// TODO Ap�ndice de m�todo generado autom�ticamente

		// end-user-code
	}
}