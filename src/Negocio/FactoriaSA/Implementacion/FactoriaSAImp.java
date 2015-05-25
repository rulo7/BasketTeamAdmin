/**
 * 
 */
package Negocio.FactoriaSA.Implementacion;

import Negocio.Equipo.SAEquipo;
import Negocio.Equipo.Implementacion.SAEquipoImp;
import Negocio.Estadistica.SAEstadistica;
import Negocio.Estadistica.Implementacion.SAEstadisticaImp;
import Negocio.FactoriaSA.FactoriaSA;
import Negocio.Jugador.SAJugador;
import Negocio.Jugador.Implementacion.SAJugadorImp;
import Negocio.Partido.SAPartido;
import Negocio.Partido.Implementacion.SAPartidoImp;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author SERCAMA
 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class FactoriaSAImp extends FactoriaSA {
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public SAEquipo nuevoSAEquipo() {
		// begin-user-code
		// TODO Apéndice de método generado automáticamente

		// end-user-code
		return new SAEquipoImp();
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public SAPartido nuevoSAPartido() {
		// begin-user-code
		// TODO Apéndice de método generado automáticamente

		// end-user-code
		return new SAPartidoImp();
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public SAEstadistica nuevoSAEstadistica() {
		// begin-user-code
		// TODO Apéndice de método generado automáticamente

		// end-user-code
		return new SAEstadisticaImp();
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public SAJugador nuevoSAJugador() {
		// begin-user-code
		// TODO Apéndice de método generado automáticamente

		// end-user-code
		return new SAJugadorImp();
	}
}