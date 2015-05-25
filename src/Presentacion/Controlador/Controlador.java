/**
 * 
 */
package Presentacion.Controlador;

import Presentacion.Controlador.Implementacion.ControladorImpl;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author SERCAMA
 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public abstract class Controlador {
	
	public static Controlador instancia;
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public static Controlador getInstancia() {
		// begin-user-code
		// TODO Apéndice de método generado automáticamente

		// end-user-code
		return new ControladorImpl();
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void accion(int i, Object datos) {
		// begin-user-code
		// TODO Apéndice de método generado automáticamente

		// end-user-code
	}
}