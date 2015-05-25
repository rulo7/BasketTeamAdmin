/**
 * 
 */
package Integracion.Equipo.Implementacion;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.util.Vector;

import Integracion.Equipo.DAOEquipo;
import Negocio.Equipo.TransferEquipo;
import Negocio.Estadistica.TransferEstadistica;
import Negocio.Jugador.TransferJugador;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author SERCAMA
 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class DAOEquipoImp implements DAOEquipo {
	
	private Connection conn;
	private Statement stmt;
	private Statement stmt2;
	private PreparedStatement pst;
	
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
			if( pst != null) pst.close();
		} catch (SQLException e) {
			System.err.println("Error al cerrar Connection o Statement");
			e.printStackTrace();
		}	
	}



	private int siguienteIdEquipo(){
		int valor = 0;
		try {
			stmt.execute("SELECT MAX(idEquipo) AS MAX_ID FROM EQUIPO" );
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
	public TransferEquipo crearEquipo(TransferEquipo trEquipo) {
		// begin-user-code
		// TODO Ap�ndice de m�todo generado autom�ticamente
		TransferEquipo equipoVuelta = null;
		if (setConnectionAndStatement()){
			try {
				int idEquipo = siguienteIdEquipo();
				//DATOS TABLA EQUIPO
				stmt.executeUpdate("INSERT INTO EQUIPO " +
						"VALUES( '" + idEquipo + "', '" +  trEquipo.getNombre() + "', '" + trEquipo.getCategoria() + "', '" + trEquipo.getColorPrinc() + "', '" + trEquipo.getColorSecun() + "', '" + trEquipo.getPais() + "', '"+ trEquipo.getCiudad() + "' )");		
				//DATOS TABLA ESCUDO
				pst = (PreparedStatement)conn.prepareStatement("INSERT INTO ESCUDO values(?,?,?)");
				pst.setString(1,trEquipo.getNombre());
				pst.setString(2,trEquipo.getCategoria());
				Blob blob;
				if(trEquipo.getEscudo()!=null){
					FileInputStream fis = new FileInputStream(trEquipo.getEscudo());
					byte[] zipped = new byte[ (int) trEquipo.getEscudo().length()];
					fis.read(zipped);
					blob = conn.createBlob();
					blob.setBytes(1, zipped);
					fis.close();
				}
				else
					blob = null;
				pst.setBlob(3,blob);
				pst.executeUpdate();
				
			
				equipoVuelta = trEquipo;
				equipoVuelta.setId(idEquipo);                                  
				
			}
			catch (IOException e){			
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
		return equipoVuelta;
		// end-user-code
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public TransferEquipo quitarJugador(TransferEquipo trEquipo) {
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
	public void asignarJugadorAequipo() {
		// begin-user-code
		// TODO Ap�ndice de m�todo generado autom�ticamente

		// end-user-code
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void asignarEstadisticaAequipo() {
		// begin-user-code
		// TODO Ap�ndice de m�todo generado autom�ticamente

		// end-user-code
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public Vector<TransferJugador> verPlantilla(TransferEquipo trEquipo) {
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
	public TransferEstadistica verEstadisticas(TransferEquipo trEquipo) {
		// begin-user-code
		// TODO Ap�ndice de m�todo generado autom�ticament
		return null;
		// end-user-code
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public TransferEquipo eliminarEquipo(TransferEquipo trEquipo) {
		// begin-user-code
		// TODO Ap�ndice de m�todo generado autom�ticamente
		if(setConnectionAndStatement()){
			try {
				pst = (PreparedStatement)conn.prepareStatement("DELETE ESCUDO WHERE NOMBRE_EQUIPO = ? AND CATEGORIA_EQUIPO = ?");
				pst.setString(1, trEquipo.getNombre());
				pst.setString(2, trEquipo.getCategoria());
				pst.executeUpdate();
				
				stmt.executeUpdate("DELETE FROM EQUIPO " +
						"WHERE IDEQUIPO = '" + trEquipo.getId() + "'");
			} 
			catch (java.sql.SQLSyntaxErrorException e) {
				System.out.println("No existen la tabla en la BBDD.");		
			}
			catch (SQLException e) {
				System.err.println("Error al eliminar la SALA: " + trEquipo.getId() );
				e.printStackTrace();
			}		

		}
		else
			return null;
		closeConnectionAndStatement();
		return trEquipo;
		// end-user-code
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public 	TransferEquipo actualizarEquipo(TransferEquipo trEquipo) {
		// begin-user-code
		// TODO Ap�ndice de m�todo generado autom�ticamente
		if (setConnectionAndStatement()){
			try {
				stmt.executeUpdate("UPDATE EQUIPO " + "SET nombre = '" +  trEquipo.getNombre() + "', categoria = '" + trEquipo.getCategoria() +
						"', color_principal = '" + trEquipo.getColorPrinc() +
						"', color_secundario = '" + trEquipo.getColorSecun() +
						"', pais = '" + trEquipo.getPais() +
						"', ciudad = '" + trEquipo.getCiudad() +
						"'WHERE idEquipo = '" + trEquipo.getId() + "'"); 
				
				if(trEquipo.getEscudo()!=null){
					pst = (PreparedStatement)conn.prepareStatement("UPDATE ESCUDO SET ESCUDO = ? WHERE nombre_equipo = '"+ trEquipo.getNombre()+"'");
					FileInputStream fis = new FileInputStream(trEquipo.getEscudo());
					byte[] zipped = new byte[ (int) trEquipo.getEscudo().length()];
					fis.read(zipped);
				
					Blob blob= conn.createBlob();
					blob.setBytes(1, zipped);
					pst.setBlob(1,blob);
					pst.executeUpdate();
				
					fis.close();
				}
			} 
			catch(IOException e){}
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
		}else return null;
		closeConnectionAndStatement();
		return trEquipo;
		// end-user-code
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public TransferEquipo verEquipo(TransferEquipo trEquipo) {
		// begin-user-code
		// TODO Ap�ndice de m�todo generado autom�ticamente
		TransferEquipo equipoVuelta = null;
		if (setConnectionAndStatement()){
			try {
				stmt.execute("SELECT  * " +
						"FROM EQUIPO E "  +						
						"WHERE E.NOMBRE = '" + trEquipo.getNombre()+ "' AND E.CATEGORIA = '"+trEquipo.getCategoria()+"'");
				
				ResultSet rs= stmt.getResultSet();			
				if (rs.next()){
					equipoVuelta =trEquipo;
					equipoVuelta.setId(rs.getInt("idequipo"));
					equipoVuelta.setNombre(rs.getString("nombre"));
					equipoVuelta.setCategoria(rs.getString("categoria"));
					equipoVuelta.setColorPrinc(rs.getString("color_principal"));
					equipoVuelta.setColorSecund(rs.getString("color_secundario"));
					equipoVuelta.setPais(rs.getString("pais"));
					equipoVuelta.setCiudad(rs.getString("ciudad"));
				}
				rs.close();
				stmt.execute("SELECT  *" +
						"FROM ESCUDO "  +						
						"WHERE nombre_equipo = '" + trEquipo.getNombre()+ "'");
				ResultSet rs2= stmt.getResultSet();			
				if (rs2.next()){
					Blob blob = rs2.getBlob("escudo");
					if(blob!=null){
						int blobLength = (int) blob.length();  
						byte[] bytes = blob.getBytes(1, blobLength);
						blob.free();
					
						File file = new File("IS");
						FileOutputStream fos = new FileOutputStream (file);
						trEquipo.setEscudo(file);
						fos.write(bytes);
						fos.close();
						rs2.close();
					}
				}
				
			} 
			catch (SQLException e) {
				e.printStackTrace();
			}	
			catch (IOException e) {
				e.printStackTrace();
			}	
		}
		else
			return null;
		closeConnectionAndStatement();
		return equipoVuelta;
	}
		// end-user-code

	@Override
	public Object[][] listarEquipos() {
		// TODO Auto-generated method stub
		//TransferEquipo[] aux=null;
		Object aux [][]=null;
		Vector<TransferEquipo> vector=new Vector();
		if(setConnectionAndStatement()){
			try{			
				stmt.executeQuery("SELECT * " +
						"FROM EQUIPO ");
				try{
					ResultSet rs = stmt.getResultSet();
					while(rs.next()){
						vector.add(new TransferEquipo(rs.getInt("idequipo"), rs.getString("nombre"),rs.getString("categoria")));
					}
					aux=new Object[vector.size()][1];
					for(int i=0;i<vector.size();i++){
						aux[i][0]=vector.get(i).getId()+"-"+vector.get(i).getNombre()+"-"+vector.get(i).getCategoria();
					}
				}
				catch(SQLException e){}		
			}
			catch(SQLException e) {
				System.err.println("No se ha podido conectar a la BD");
				e.printStackTrace();
			}
		}else
			return null;
		closeConnectionAndStatement();
		return aux;
	}
	}
	
//	public boolean existe(String nombre, String categoria){
//		File equiposRegistrados = new File(nombre+categoria+".txt");
//		if(!equiposRegistrados.exists()) return false;
//		else return true;
//	}