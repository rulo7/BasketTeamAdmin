/**
 * 
 */
package Integracion.FactoriaDAO;

import Integracion.Equipo.DAOEquipo;
import Integracion.Estadistica.DAOEstadistica;
import Integracion.FactoriaDAO.Implementacion.FactoriaDAOImp;
import Integracion.Jugador.DAOJugador;
import Integracion.Partido.DAOPartido;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author SERCAMA
 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public abstract class FactoriaDAO {
	
	public static FactoriaDAO instancia;
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public abstract DAOEquipo nuevoDAOEquipo();

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public abstract DAOEstadistica nuevoDAOEstadistica();

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public abstract DAOJugador nuevoDAOJugador();

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public abstract DAOPartido nuevoDAOPartido();

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public static FactoriaDAO getInstancia(){
		if (instancia==null)
			instancia = new FactoriaDAOImp();
		return instancia;
	}
}