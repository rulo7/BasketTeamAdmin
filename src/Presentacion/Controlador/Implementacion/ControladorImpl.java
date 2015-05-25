/**
 * 
 */
package Presentacion.Controlador.Implementacion;

import Negocio.Equipo.SAEquipo;
import Negocio.Equipo.TransferEquipo;
import Negocio.Estadistica.SAEstadistica;
import Negocio.Estadistica.TransferEstadistica;
import Negocio.FactoriaSA.FactoriaSA;
import Negocio.Jugador.SAJugador;
import Negocio.Jugador.TransferJugador;
import Negocio.Partido.SAPartido;
import Negocio.Partido.TransferPartido;
import Presentacion.menu;
import Presentacion.Controlador.Controlador;
import Presentacion.Equipo.Implementacion.PresentacionEquipo;
import Presentacion.Partido.Implementacion.PresentacionPartido;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author SERCAMA
 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class ControladorImpl extends Controlador {
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void accion(int id, Object datos) {
		// begin-user-code
		// TODO Ap�ndice de m�todo generado autom�ticamente

		// end-user-code
		Object transfer = null;
		FactoriaSA factSA = FactoriaSA.getInstancia();
		PresentacionEquipo pe;
		if (1<=id && id<10 ){//estamos en el modulo Sala
                    SAEquipo equipo = factSA.nuevoSAEquipo();
                    switch (id){
                        case 1 : transfer = equipo.crearEquipo(TransferEquipo.class.cast(datos));
                            pe = new PresentacionEquipo(transfer);
                            pe.setSize(565,430);
                            pe.setVisible(true);          
                            new menu((TransferEquipo)transfer).setVisible(true);
                        	break;
                        case 2 : transfer = equipo.actualizarEquipo(TransferEquipo.class.cast(datos));
                        	pe = new PresentacionEquipo(transfer);
                        	pe.setSize(565,430);
                        	pe.setVisible(true);            
                        	break;
                        case 3 : transfer = equipo.verEquipo(TransferEquipo.class.cast(datos));
                        	pe = new PresentacionEquipo(transfer);
                        	pe.setSize(565,430);
                        	pe.setVisible(true);	           
                        	break;
                        case 4 : transfer = equipo.eliminarEquipo(TransferEquipo.class.cast(datos));
                        	pe = new PresentacionEquipo(transfer);
                        	pe.setSize(565,430);
                        	pe.setVisible(true);
                        	break;
                        case 5 : transfer = equipo.verEstadisticas(TransferEquipo.class.cast(datos));
                        break;
                        case 6 : transfer = equipo.verPlantilla(TransferEquipo.class.cast(datos));
                        break;
                    }
		}
		else if (10<=id && id<20 ){//estamos en el modulo Sala
            SAJugador jugador = factSA.nuevoSAJugador();
            switch (id){
                case 10 : transfer = jugador.crearJugador(TransferJugador.class.cast(datos));
                                break;
                case 11 : transfer = jugador.actualizarJugador(TransferJugador.class.cast(datos));
                                break;
                case 12 : transfer = jugador.verJugador(TransferJugador.class.cast(datos));
                                break;
                case 13 : transfer = jugador.eliminarJugador(TransferJugador.class.cast(datos));
                                break;
                case 14 : transfer = jugador.verEstadisticasJornada(TransferJugador.class.cast(datos));
                break;
                case 15 : transfer = jugador.verEstadisticasTotal(TransferJugador.class.cast(datos));
                break;
            }
		}
            else if (20<=id && id<30 ){//estamos en el modulo Sala
                SAPartido partido = factSA.nuevoSAPartido();
                switch (id){
                    case 20 : transfer = partido.crearPartido(TransferPartido.class.cast(datos));
                    				PresentacionPartido pp=new PresentacionPartido(transfer);
                    				pp.setVisible(true);
                                    break;
                    case 21 : transfer = partido.actualizarPartido(TransferPartido.class.cast(datos));
                                    break;
                    case 22 : transfer = partido.verPartido(TransferPartido.class.cast(datos));
                                    break;
                    case 23 : transfer = partido.eliminarPartido(TransferPartido.class.cast(datos));
                                    break;
                   // case 14 : transfer = partido.sustituir();
                    //break;
                }
            }
            else if (30<=id && id<40 ){//estamos en el modulo Sala
                SAEstadistica estadistica = factSA.nuevoSAEstadistica();
                switch (id){
                    case 30 : transfer = estadistica.crearEstadistica(TransferEstadistica.class.cast(datos));
                                    break;
                   // case 31 : transfer = estadistica.verEstadistica(TransferEstadistica.class.cast(datos));
                     //               break;
                }
            }
	}
}




/**
 * 
 */
