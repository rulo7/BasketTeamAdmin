/**
 * 
 */
package Integracion.Partido.Implementacion;

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

import Integracion.Partido.DAOPartido;
import Negocio.Partido.TransferPartido;
import Negocio.Partido.TransferPartido;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author SERCAMA
 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class DAOPartidoImp implements DAOPartido {
	private Connection conn;
	private Statement stmt;
	private Statement stmt2;
	
	private boolean setConnectionAndStatement() {
		boolean correcto=false;
		// setConnection
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
		} catch (SQLException e) {
			System.err.println("Error al cerrar Connection o Statement");
			e.printStackTrace();
		}	
	}



	private int siguienteIdPartido(){
		int valor = 0;
		try {
			stmt.execute("SELECT MAX(idPartido) AS MAX_ID FROM PARTIDO" );
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
	public TransferPartido crearPartido(TransferPartido trPartido) {
		// begin-user-code
		// TODO Ap�ndice de m�todo generado autom�ticamente
		TransferPartido partidoVuelta = null;
		if (setConnectionAndStatement()){
			try {
				int idPartido = siguienteIdPartido();
				//DATOS TABLA Partido
				stmt.executeUpdate("INSERT INTO PARTIDO " +
						"VALUES( " + idPartido + ", '" +  trPartido.getRival() + "', " + trPartido.getNumJornada() + ", '" + trPartido.getFechaYhora() + "', '" + trPartido.getLugar() + "', '" + trPartido.getLocalVisitante() + "', "+ 1 + " )");		
				
			
				partidoVuelta = trPartido;
				partidoVuelta.setId(idPartido);                                  
				
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
		return partidoVuelta;
		// end-user-code
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public TransferPartido verPartido(TransferPartido trPartido) {
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
	public void actualizarPartido() {
		// begin-user-code
		// TODO Ap�ndice de m�todo generado autom�ticamente

		// end-user-code
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void eliminarPartido() {
		// begin-user-code
		// TODO Ap�ndice de m�todo generado autom�ticamente

		// end-user-code
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void verEstadisticas() {
		// begin-user-code
		// TODO Ap�ndice de m�todo generado autom�ticamente

		// end-user-code
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void sustituir() {
		// begin-user-code
		// TODO Ap�ndice de m�todo generado autom�ticamente

		// end-user-code
	}
}