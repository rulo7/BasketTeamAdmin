/**
 * 
 */
package Integracion.FactoriaDAO.Implementacion;

import Integracion.Equipo.DAOEquipo;
import Integracion.Equipo.Implementacion.DAOEquipoImp;
import Integracion.Estadistica.DAOEstadistica;
import Integracion.Estadistica.Implementacion.DAOEstadisticaImp;
import Integracion.FactoriaDAO.FactoriaDAO;
import Integracion.Jugador.DAOJugador;
import Integracion.Jugador.Implementacion.DAOJugadorImp;
import Integracion.Partido.DAOPartido;
import Integracion.Partido.Implementacion.DAOPartidoImp;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author SERCAMA
 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class FactoriaDAOImp extends FactoriaDAO {
	
	public DAOEquipo nuevoDAOEquipo() {
		// begin-user-code
		// TODO Apéndice de método generado automáticamente

		// end-user-code
		return new DAOEquipoImp();
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public DAOEstadistica nuevoDAOEstadistica() {
		// begin-user-code
		// TODO Apéndice de método generado automáticamente

		// end-user-code
		return new DAOEstadisticaImp();
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public DAOJugador nuevoDAOJugador() {
		// begin-user-code
		// TODO Apéndice de método generado automáticamente

		// end-user-code
		return new DAOJugadorImp();
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public DAOPartido nuevoDAOPartido() {
		// begin-user-code
		// TODO Apéndice de método generado automáticamente

		// end-user-code
		return new DAOPartidoImp();
	}
}