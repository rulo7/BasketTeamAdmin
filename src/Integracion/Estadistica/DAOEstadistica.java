/**
 * 
 */
package Integracion.Estadistica;

import Negocio.Estadistica.TransferEstadistica;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author SERCAMA
 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public interface DAOEstadistica {
	
	public TransferEstadistica crearEstadistica(TransferEstadistica trEstadistica);
	
	public TransferEstadistica verEstadistica(TransferEstadistica trEstadistica);

	public TransferEstadistica actualizarEstadistica(TransferEstadistica trEstadistica);

	public TransferEstadistica acumular(TransferEstadistica trEstadistica);

	public TransferEstadistica eliminarEstadistica(TransferEstadistica trEstadistica);
}