/**
 * 
 */
package Negocio.Jugador.Implementacion;

import Integracion.FactoriaDAO.FactoriaDAO;
import Integracion.Jugador.DAOJugador;
import Negocio.Estadistica.TransferEstadistica;
import Negocio.Jugador.SAJugador;
import Negocio.Jugador.TransferJugador;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author SERCAMA
 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class SAJugadorImp implements SAJugador {
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private FactoriaDAO fatDao=FactoriaDAO.getInstancia();
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private DAOJugador daoJugador=fatDao.nuevoDAOJugador();

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public TransferJugador crearJugador(TransferJugador trJugador) {
		// begin-user-code
		if(daoJugador.verJugador(trJugador)==null)
			return daoJugador.crearJugador(trJugador);
		// end-user-code
		else return null;
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

		// end-user-code
		return null;
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public TransferJugador actualizarJugador(TransferJugador trJugador) {
		// begin-user-code
		// TODO Ap�ndice de m�todo generado autom�ticamente

		// end-user-code
		return null;
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public TransferJugador eliminarJugador(TransferJugador trJugador) {
		// begin-user-code
		// TODO Ap�ndice de m�todo generado autom�ticamente

		// end-user-code
		return null;
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public TransferEstadistica verEstadisticasTotal(TransferJugador trJugador) {
		// begin-user-code
		// TODO Ap�ndice de m�todo generado autom�ticamente

		// end-user-code
		return null;
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public TransferEstadistica verEstadisticasJornada(TransferJugador trJugador) {
		// begin-user-code
		// TODO Ap�ndice de m�todo generado autom�ticamente

		// end-user-code
		return null;
	}

	/** 
	 * (sin Javadoc)
	 * @see SAJugador#_new()
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void _new() {
		// begin-user-code
		// TODO Ap�ndice de m�todo generado autom�ticamente

		// end-user-code
	}
}