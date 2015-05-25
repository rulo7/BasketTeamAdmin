/**
 * 
 */
package Negocio.Equipo.Implementacion;

import Integracion.Equipo.DAOEquipo;
import Integracion.FactoriaDAO.FactoriaDAO;
import Negocio.Equipo.SAEquipo;
import Negocio.Equipo.TransferEquipo;
import Negocio.Estadistica.TransferEstadistica;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author SERCAMA
 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class SAEquipoImp implements SAEquipo {
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
	private DAOEquipo daoEquipo=fatDao.nuevoDAOEquipo();

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public TransferEquipo crearEquipo(TransferEquipo trEquipo) {
		// begin-user-code
		// TODO Ap�ndice de m�todo generado autom�ticamente
		if(daoEquipo.verEquipo(trEquipo)==null)
			return daoEquipo.crearEquipo(trEquipo);
		// end-user-code
		else return null;
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public TransferEquipo verEquipo(TransferEquipo trEquipo) {
		// begin-user-code
		// TODO Ap�ndice de m�todo generado autom�ticamente
			return daoEquipo.verEquipo(trEquipo);
		// end-user-code
		
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public TransferEquipo actualizarEquipo(TransferEquipo trEquipo) {
		// begin-user-code
		// TODO Ap�ndice de m�todo generado autom�ticamente
		TransferEquipo copia = new TransferEquipo(trEquipo.getNombre(),trEquipo.getCategoria());
		copia=daoEquipo.verEquipo(copia);
		if(copia!=null){             
			trEquipo.setId(copia.getId());
			return daoEquipo.actualizarEquipo(trEquipo);
		}
		// end-user-code
		else
			return null;
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public TransferEquipo eliminarEquipo(TransferEquipo trEquipo) {
		// begin-user-code
		// TODO Ap�ndice de m�todo generado autom�ticamente
		TransferEquipo equipo=daoEquipo.verEquipo(trEquipo);
		if(equipo!=null){
			 return daoEquipo.eliminarEquipo(equipo);
		}else
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
		// TODO Ap�ndice de m�todo generado autom�ticamente

		// end-user-code
		return null;
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public TransferEquipo verPlantilla(TransferEquipo trEquipo) {
		// begin-user-code
		// TODO Ap�ndice de m�todo generado autom�ticamente

		// end-user-code
		return null;
	}
}