/**
 * 
 */
package Negocio.FactoriaSA;

import Negocio.Equipo.SAEquipo;
import Negocio.Estadistica.SAEstadistica;
import Negocio.FactoriaSA.Implementacion.FactoriaSAImp;
import Negocio.Jugador.SAJugador;
import Negocio.Partido.SAPartido;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author SERCAMA
 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public abstract class FactoriaSA {
	
	public static FactoriaSA instancia;
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public abstract SAEquipo nuevoSAEquipo();

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public abstract SAJugador nuevoSAJugador();

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public abstract SAEstadistica nuevoSAEstadistica();

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public abstract SAPartido nuevoSAPartido();

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public static FactoriaSA getInstancia(){
		if (instancia==null)
			instancia = new FactoriaSAImp();
		return instancia;
	};
}