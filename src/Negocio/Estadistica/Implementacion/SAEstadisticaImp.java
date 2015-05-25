/**
 *
 */
package Negocio.Estadistica.Implementacion;

import Integracion.Estadistica.DAOEstadistica;
import Integracion.FactoriaDAO.FactoriaDAO;
import Negocio.Estadistica.SAEstadistica;
import Negocio.Estadistica.TransferEstadistica;

public class SAEstadisticaImp implements SAEstadistica {

    private FactoriaDAO fatDao=FactoriaDAO.getInstancia();
    private DAOEstadistica daoEstadistica=fatDao.nuevoDAOEstadistica();

    public TransferEstadistica crearEstadistica(TransferEstadistica trEstadistica) {
        if(daoEstadistica.verEstadistica(trEstadistica) == null)
            return daoEstadistica.crearEstadistica(trEstadistica);
		// end-user-code
        else 
            return daoEstadistica.actualizarEstadistica(trEstadistica);
        
    }

    public TransferEstadistica verEstadistica(TransferEstadistica trEstadistica) {

        return null;
    }

    public TransferEstadistica actualizarEstadistica(TransferEstadistica trEstadistica) {

        return null;
    }

    public void _new() {
    }
}