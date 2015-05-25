/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion.Estadistica.Implementacion;

import Negocio.Estadistica.TransferEstadistica;
import Presentacion.Controlador.Controlador;

/**
 *
 */
public class PresentacionEstadistica extends javax.swing.JFrame {

    /**
     * Creates new form PresentacionEstadistica
     */
    private TransferEstadistica[] jugadores;
    private int jugadorEnPanel;

    public PresentacionEstadistica(Object estadistica) {
        initComponents();

        jugadores = new TransferEstadistica[12];

        for (int i = 0; i < 12; i++) {
            jugadores[i] = new TransferEstadistica();
            jugadores[i].setDorsal(i * 3);
        }

        //Se le pasan los verdaderos jugadores[] con sus dorsales

        actualizarComponentes();

        jugadorEnPanel = jugadores[0].getDorsal();
        jLabelDorsal_Panel.setText(jugadores[jugadorEnPanel].getDorsal() + "");

    }

    public void actualizarComponentes() {
        jButtonBase.setText(jugadores[0].getDorsal() + "");
        jButtonEscolta.setText(jugadores[1].getDorsal() + "");
        jButtonAlero.setText(jugadores[2].getDorsal() + "");
        jButtonAlaPivot.setText(jugadores[3].getDorsal() + "");
        jButtonPivot.setText(jugadores[4].getDorsal() + "");
        jButton6hombre.setText(jugadores[5].getDorsal() + "");
        jButton7hombre.setText(jugadores[6].getDorsal() + "");
        jButton8hombre.setText(jugadores[7].getDorsal() + "");
        jButton9hombre.setText(jugadores[8].getDorsal() + "");
        jButton10hombre.setText(jugadores[9].getDorsal() + "");
        jButton11hombre.setText(jugadores[10].getDorsal() + "");
        jButton12hombre.setText(jugadores[11].getDorsal() + "");
    }

    public int buscarDorsal(int dorsal) {

        for (int i = 0; i < 12; i++) {
            if (jugadores[i].getDorsal() == dorsal) {
                return i;
            }
        }



        return -1;
    }

    private void mostrarEstadisticasPanel(int id_jugador) {

        //Antes de mostrar las estadisticas de otros jugadores, guardamos lo que habia anteriormente en el panel

        jLabelDorsal_Panel.setText(jugadores[jugadorEnPanel].getDorsal() + "");

        jSpinnerAsistencias.setValue(jugadores[id_jugador].getAsistencias());
        jSpinnerFaltasCometidas.setValue(jugadores[id_jugador].getFaltasRealizadas());
        jSpinnerFaltasRecibidas.setValue(jugadores[id_jugador].getFaltasRecibidas());
        jSpinnerPerdidas.setValue(jugadores[id_jugador].getPerdidas());
        jSpinnerRdefens.setValue(jugadores[id_jugador].getRebotesDefensivos());
        jSpinnerRecuperaciones.setValue(jugadores[id_jugador].getRecuperaciones());
        jSpinnerRofens.setValue(jugadores[id_jugador].getRebotesOfensivos());
        jSpinnerTaponesCometidos.setValue(jugadores[id_jugador].getTaponesRealizados());
        jSpinnerTaponesRecibidos.setValue(jugadores[id_jugador].getTaponesRecibidos());
        jSpinnerTiros2Correct.setValue(jugadores[id_jugador].getTiros2Acertados());
        jSpinnerTiros2Fallados.setValue(jugadores[id_jugador].getTiros2Fallados());
        jSpinnerTiros3Correct.setValue(jugadores[id_jugador].getTiros3Acertados());
        jSpinnerTiros3Fallados.setValue(jugadores[id_jugador].getTiros3Fallados());
        jSpinnerTirosLibresCorrect.setValue(jugadores[id_jugador].getTirosLibresAcertados());
        jSpinnerTirosLibresFallados.setValue(jugadores[id_jugador].getTirosLibresFallados());

        jTextFieldPuntos.setText(String.valueOf((jugadores[id_jugador].getTiros2Acertados() * 2) + (jugadores[id_jugador].getTiros3Acertados() * 3) + jugadores[id_jugador].getTirosLibresAcertados()));
        jTextFieldRebotes.setText(String.valueOf(jugadores[id_jugador].getRebotesDefensivos() + jugadores[id_jugador].getRebotesOfensivos()));

        if (jugadores[id_jugador].getTiros2Acertados() == 0 && jugadores[id_jugador].getTiros2Fallados() == 0) {
            jTextFieldTiros2.setText("0");
        } else {
            jTextFieldTiros2.setText(String.valueOf((int) ((jugadores[id_jugador].getTiros2Acertados() * 100) / (jugadores[id_jugador].getTiros2Acertados() + jugadores[id_jugador].getTiros2Fallados()))));
        }
        if (jugadores[id_jugador].getTiros3Acertados() == 0 && jugadores[id_jugador].getTiros3Fallados() == 0) {
            jTextFieldTiros3.setText("0");
        } else {
            jTextFieldTiros3.setText(String.valueOf((jugadores[id_jugador].getTiros3Acertados() * 100) / (jugadores[id_jugador].getTiros3Acertados() + jugadores[id_jugador].getTiros3Fallados())));
        }

        if (jugadores[id_jugador].getTirosLibresAcertados() == 0 && jugadores[id_jugador].getTirosLibresFallados() == 0) {
            jTextFieldTirosLibres.setText("0");
        } else {
            jTextFieldTirosLibres.setText(String.valueOf((jugadores[id_jugador].getTirosLibresAcertados() * 100) / (jugadores[id_jugador].getTirosLibresAcertados() + jugadores[id_jugador].getTirosLibresFallados())));
        }

        jTextFieldValoracion.setText(String.valueOf(jugadores[id_jugador].getAsistencias()
                + jugadores[id_jugador].getFaltasRecibidas()
                + jugadores[id_jugador].getRebotesDefensivos()
                + jugadores[id_jugador].getRebotesOfensivos()
                + jugadores[id_jugador].getRecuperaciones()
                + jugadores[id_jugador].getTaponesRealizados()
                + (jugadores[id_jugador].getTiros2Acertados() * 2)
                + (jugadores[id_jugador].getTiros3Acertados() * 3)
                + (jugadores[id_jugador].getTirosLibresAcertados())
                - jugadores[id_jugador].getFaltasRealizadas()
                - jugadores[id_jugador].getPerdidas()
                - jugadores[id_jugador].getTaponesRecibidos()
                - jugadores[id_jugador].getTiros2Fallados()
                - jugadores[id_jugador].getTiros3Fallados()
                - jugadores[id_jugador].getTirosLibresFallados()));
    }

    private void actualizarEstadisticas() {

        jugadores[jugadorEnPanel].setAsistencias((int) jSpinnerAsistencias.getValue());
        jugadores[jugadorEnPanel].setFaltasRealizadas((int) jSpinnerFaltasCometidas.getValue());
        jugadores[jugadorEnPanel].setFaltasRecibidas((int) jSpinnerFaltasRecibidas.getValue());
        jugadores[jugadorEnPanel].setPerdidas((int) jSpinnerPerdidas.getValue());
        jugadores[jugadorEnPanel].setRebotesDefensivos((int) jSpinnerRdefens.getValue());
        jugadores[jugadorEnPanel].setRebotesOfensivos((int) jSpinnerRofens.getValue());
        jugadores[jugadorEnPanel].setRecuperaciones((int) jSpinnerRecuperaciones.getValue());
        jugadores[jugadorEnPanel].setTaponesRealizados((int) jSpinnerTaponesCometidos.getValue());
        jugadores[jugadorEnPanel].setTaponesRecibidos((int) jSpinnerTaponesRecibidos.getValue());
        jugadores[jugadorEnPanel].setTiros2Acertados((int) jSpinnerTiros2Correct.getValue());
        jugadores[jugadorEnPanel].setTiros3Acertados((int) jSpinnerTiros3Correct.getValue());
        jugadores[jugadorEnPanel].setTirosLibresAcertados((int) jSpinnerTirosLibresCorrect.getValue());
        jugadores[jugadorEnPanel].setTiros2Fallados((int) jSpinnerTiros2Fallados.getValue());
        jugadores[jugadorEnPanel].setTiros3Fallados((int) jSpinnerTiros3Fallados.getValue());
        jugadores[jugadorEnPanel].setTirosLibresFallados((int) jSpinnerTirosLibresFallados.getValue());

    }

    private void actualizarCampos() {

        jTextFieldPuntos.setText(String.valueOf(((int) jSpinnerTiros2Correct.getValue() * 2) + ((int) jSpinnerTiros3Correct.getValue() * 3) + ((int) jSpinnerTirosLibresCorrect.getValue())));

        jTextFieldRebotes.setText(String.valueOf((int) jSpinnerRdefens.getValue() + (int) jSpinnerRofens.getValue()));

        if ((int) jSpinnerTiros2Correct.getValue() == 0 && (int) jSpinnerTiros2Fallados.getValue() == 0) {
            jTextFieldTiros2.setText("0");
        } else {
            jTextFieldTiros2.setText(String.valueOf(((int) jSpinnerTiros2Correct.getValue() * 100) / ((int) jSpinnerTiros2Correct.getValue() + (int) jSpinnerTiros2Fallados.getValue())));
        }
        if ((int)jSpinnerTiros3Correct.getValue() == 0 && (int)jSpinnerTiros3Fallados.getValue() == 0) {
            jTextFieldTiros3.setText("0");
        } else {
            jTextFieldTiros3.setText(String.valueOf(((int) jSpinnerTiros3Correct.getValue() * 100) / ((int) jSpinnerTiros3Correct.getValue() + (int) jSpinnerTiros3Fallados.getValue())));
        }

        if ((int)jSpinnerTirosLibresCorrect.getValue() == 0 && (int)jSpinnerTirosLibresFallados.getValue() == 0) {
            jTextFieldTirosLibres.setText("0");
        } else {
            jTextFieldTirosLibres.setText(String.valueOf(((int) jSpinnerTirosLibresCorrect.getValue() * 100) / ((int) jSpinnerTirosLibresCorrect.getValue() + (int) jSpinnerTirosLibresFallados.getValue())));
        }

        jTextFieldValoracion.setText(String.valueOf(
                Integer.valueOf(jTextFieldPuntos.getText())
                + Integer.valueOf(jTextFieldRebotes.getText())
                + (int) jSpinnerAsistencias.getValue()
                + (int) jSpinnerFaltasRecibidas.getValue()
                + (int) jSpinnerRecuperaciones.getValue()
                + (int) jSpinnerTaponesCometidos.getValue()
                - (int) jSpinnerTiros2Fallados.getValue()
                - (int) jSpinnerTiros3Fallados.getValue()
                - (int) jSpinnerTirosLibresFallados.getValue()
                - (int) jSpinnerFaltasCometidas.getValue()
                - (int) jSpinnerPerdidas.getValue()
                - (int) jSpinnerTaponesRecibidos.getValue()));
    }

    private void bloquearSpinners() {
        jSpinnerAsistencias.setEnabled(false);
        jSpinnerFaltasCometidas.setEnabled(false);
        jSpinnerFaltasRecibidas.setEnabled(false);
        jSpinnerPerdidas.setEnabled(false);
        jSpinnerRdefens.setEnabled(false);
        jSpinnerRecuperaciones.setEnabled(false);
        jSpinnerRofens.setEnabled(false);
        jSpinnerTaponesCometidos.setEnabled(false);
        jSpinnerTaponesRecibidos.setEnabled(false);
        jSpinnerTiros2Correct.setEnabled(false);
        jSpinnerTiros2Fallados.setEnabled(false);
        jSpinnerTiros3Correct.setEnabled(false);
        jSpinnerTiros3Fallados.setEnabled(false);
        jSpinnerTirosLibresCorrect.setEnabled(false);
        jSpinnerTirosLibresFallados.setEnabled(false);
    }

    public void desbloquearSppiners() {

        jSpinnerAsistencias.setEnabled(true);
        jSpinnerFaltasCometidas.setEnabled(true);
        jSpinnerFaltasRecibidas.setEnabled(true);
        jSpinnerPerdidas.setEnabled(true);
        jSpinnerRdefens.setEnabled(true);
        jSpinnerRecuperaciones.setEnabled(true);
        jSpinnerRofens.setEnabled(true);
        jSpinnerTaponesCometidos.setEnabled(true);
        jSpinnerTaponesRecibidos.setEnabled(true);
        jSpinnerTiros2Correct.setEnabled(true);
        jSpinnerTiros2Fallados.setEnabled(true);
        jSpinnerTiros3Correct.setEnabled(true);
        jSpinnerTiros3Fallados.setEnabled(true);
        jSpinnerTirosLibresCorrect.setEnabled(true);
        jSpinnerTirosLibresFallados.setEnabled(true);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton2 = new javax.swing.JButton();
        jButtonAlero = new javax.swing.JButton();
        jButtonAlaPivot = new javax.swing.JButton();
        jButtonEscolta = new javax.swing.JButton();
        jButtonBase = new javax.swing.JButton();
        jButtonPivot = new javax.swing.JButton();
        jPanelEstadisticas = new javax.swing.JPanel();
        jLabelPuntos = new javax.swing.JLabel();
        jLabelTicTiros2 = new javax.swing.JLabel();
        jSpinnerTiros2Correct = new javax.swing.JSpinner();
        jLabelCrossTiros2 = new javax.swing.JLabel();
        jSpinnerTiros2Fallados = new javax.swing.JSpinner();
        jLabelCrossTiros3 = new javax.swing.JLabel();
        jLabelTicTiros3 = new javax.swing.JLabel();
        jSpinnerTiros3Correct = new javax.swing.JSpinner();
        jSpinnerTiros3Fallados = new javax.swing.JSpinner();
        jLabelCrossTirosLibres = new javax.swing.JLabel();
        jLabelTicTirosLibres = new javax.swing.JLabel();
        jSpinnerTirosLibresCorrect = new javax.swing.JSpinner();
        jSpinnerTirosLibresFallados = new javax.swing.JSpinner();
        jLabelRebotes = new javax.swing.JLabel();
        jLabelRofens = new javax.swing.JLabel();
        jSpinnerRecuperaciones = new javax.swing.JSpinner();
        jLabelAsistencias = new javax.swing.JLabel();
        jSpinnerPerdidas = new javax.swing.JSpinner();
        jLabelrecuperaciones = new javax.swing.JLabel();
        jSpinnerRofens = new javax.swing.JSpinner();
        jLabelPerdidas = new javax.swing.JLabel();
        jSpinnerAsistencias = new javax.swing.JSpinner();
        jLabelTirosDe2 = new javax.swing.JLabel();
        jLabelTirosDe3 = new javax.swing.JLabel();
        jLabelTirosLibres = new javax.swing.JLabel();
        jLabelTapones = new javax.swing.JLabel();
        jLabelCrossFaltas = new javax.swing.JLabel();
        jSpinnerTaponesRecibidos = new javax.swing.JSpinner();
        jSpinnerFaltasRecibidas = new javax.swing.JSpinner();
        jLabelFaltas = new javax.swing.JLabel();
        jLabelTicFaltas = new javax.swing.JLabel();
        jSpinnerFaltasCometidas = new javax.swing.JSpinner();
        jSpinnerTaponesCometidos = new javax.swing.JSpinner();
        jTextFieldPuntos = new javax.swing.JTextField();
        jLabelValoracion = new javax.swing.JLabel();
        jTextFieldValoracion = new javax.swing.JTextField();
        jTextFieldTiros2 = new javax.swing.JTextField();
        jTextFieldTirosLibres = new javax.swing.JTextField();
        jTextFieldTiros3 = new javax.swing.JTextField();
        jLabeporc2 = new javax.swing.JLabel();
        jLabelporc3 = new javax.swing.JLabel();
        jLabelporcLibres = new javax.swing.JLabel();
        jTextFieldRebotes = new javax.swing.JTextField();
        jLabelRdefens = new javax.swing.JLabel();
        jSpinnerRdefens = new javax.swing.JSpinner();
        jLabelCrossTapones1 = new javax.swing.JLabel();
        jLabelTicTapones1 = new javax.swing.JLabel();
        jLabelTicTapones2 = new javax.swing.JLabel();
        jLabelDorsal_Panel = new javax.swing.JLabel();
        jButtonSustituir = new javax.swing.JButton();
        jButtonGuardar = new javax.swing.JButton();
        jButtonSalir = new javax.swing.JButton();
        jLabelBanquillo = new javax.swing.JLabel();
        jButton7hombre = new javax.swing.JButton();
        jButton9hombre = new javax.swing.JButton();
        jButton11hombre = new javax.swing.JButton();
        jButton8hombre = new javax.swing.JButton();
        jButton6hombre = new javax.swing.JButton();
        jButton12hombre = new javax.swing.JButton();
        jButton10hombre = new javax.swing.JButton();
        jLabelBg = new javax.swing.JLabel();

        jButton2.setText("6");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jButtonAlero.setText("3");
        jButtonAlero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAleroActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonAlero);
        jButtonAlero.setBounds(170, 260, 70, 70);

        jButtonAlaPivot.setText("4");
        jButtonAlaPivot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAlaPivotActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonAlaPivot);
        jButtonAlaPivot.setBounds(20, 220, 70, 60);

        jButtonEscolta.setText("2");
        jButtonEscolta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEscoltaActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonEscolta);
        jButtonEscolta.setBounds(150, 40, 70, 70);

        jButtonBase.setText("1");
        jButtonBase.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBaseActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonBase);
        jButtonBase.setBounds(220, 150, 70, 70);

        jButtonPivot.setText("5");
        jButtonPivot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPivotActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonPivot);
        jButtonPivot.setBounds(30, 100, 70, 60);

        jLabelPuntos.setText("PUNTOS:");

        jLabelTicTiros2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Presentacion/TICK.png"))); // NOI18N

        jSpinnerTiros2Correct.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));
        jSpinnerTiros2Correct.setRequestFocusEnabled(false);
        jSpinnerTiros2Correct.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSpinnerTiros2CorrectStateChanged(evt);
            }
        });

        jLabelCrossTiros2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Presentacion/cross.png"))); // NOI18N

        jSpinnerTiros2Fallados.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));
        jSpinnerTiros2Fallados.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSpinnerTiros2FalladosStateChanged(evt);
            }
        });

        jLabelCrossTiros3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Presentacion/cross.png"))); // NOI18N

        jLabelTicTiros3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Presentacion/TICK.png"))); // NOI18N

        jSpinnerTiros3Correct.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));
        jSpinnerTiros3Correct.setRequestFocusEnabled(false);
        jSpinnerTiros3Correct.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSpinnerTiros3CorrectStateChanged(evt);
            }
        });

        jSpinnerTiros3Fallados.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));
        jSpinnerTiros3Fallados.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSpinnerTiros3FalladosStateChanged(evt);
            }
        });

        jLabelCrossTirosLibres.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Presentacion/cross.png"))); // NOI18N

        jLabelTicTirosLibres.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Presentacion/TICK.png"))); // NOI18N

        jSpinnerTirosLibresCorrect.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));
        jSpinnerTirosLibresCorrect.setRequestFocusEnabled(false);
        jSpinnerTirosLibresCorrect.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSpinnerTirosLibresCorrectStateChanged(evt);
            }
        });

        jSpinnerTirosLibresFallados.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));
        jSpinnerTirosLibresFallados.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSpinnerTirosLibresFalladosStateChanged(evt);
            }
        });

        jLabelRebotes.setText("REBOTES:");

        jLabelRofens.setText("OFENSIVOS:");

        jSpinnerRecuperaciones.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));
        jSpinnerRecuperaciones.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSpinnerRecuperacionesStateChanged(evt);
            }
        });

        jLabelAsistencias.setText("ASISTENCIAS:");

        jSpinnerPerdidas.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));
        jSpinnerPerdidas.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSpinnerPerdidasStateChanged(evt);
            }
        });

        jLabelrecuperaciones.setText("RECUPERACIONES:");

        jSpinnerRofens.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));
        jSpinnerRofens.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSpinnerRofensStateChanged(evt);
            }
        });

        jLabelPerdidas.setText("PÉRDIDAS:");

        jSpinnerAsistencias.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));
        jSpinnerAsistencias.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSpinnerAsistenciasStateChanged(evt);
            }
        });

        jLabelTirosDe2.setText("TIROS 2:");

        jLabelTirosDe3.setText("TIROS 3:");

        jLabelTirosLibres.setText("TIROS LIBRES:");

        jLabelTapones.setText("TAPONES:");

        jLabelCrossFaltas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Presentacion/cross.png"))); // NOI18N

        jSpinnerTaponesRecibidos.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));
        jSpinnerTaponesRecibidos.setRequestFocusEnabled(false);
        jSpinnerTaponesRecibidos.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSpinnerTaponesRecibidosStateChanged(evt);
            }
        });

        jSpinnerFaltasRecibidas.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));
        jSpinnerFaltasRecibidas.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSpinnerFaltasRecibidasStateChanged(evt);
            }
        });

        jLabelFaltas.setText("FALTAS:");

        jLabelTicFaltas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Presentacion/TICK.png"))); // NOI18N

        jSpinnerFaltasCometidas.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));
        jSpinnerFaltasCometidas.setRequestFocusEnabled(false);
        jSpinnerFaltasCometidas.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSpinnerFaltasCometidasStateChanged(evt);
            }
        });

        jSpinnerTaponesCometidos.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));
        jSpinnerTaponesCometidos.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSpinnerTaponesCometidosStateChanged(evt);
            }
        });

        jTextFieldPuntos.setEditable(false);

        jLabelValoracion.setText("VALORACIÓN:");

        jTextFieldValoracion.setEditable(false);

        jTextFieldTiros2.setEditable(false);

        jTextFieldTirosLibres.setEditable(false);

        jTextFieldTiros3.setEditable(false);

        jLabeporc2.setText("%");

        jLabelporc3.setText("%");

        jLabelporcLibres.setText("%");

        jTextFieldRebotes.setEditable(false);

        jLabelRdefens.setText("DEFENSIVOS");

        jSpinnerRdefens.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));
        jSpinnerRdefens.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSpinnerRdefensStateChanged(evt);
            }
        });

        jLabelCrossTapones1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Presentacion/cross.png"))); // NOI18N

        jLabelTicTapones1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Presentacion/TICK.png"))); // NOI18N

        jLabelTicTapones2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Presentacion/TICK.png"))); // NOI18N

        jLabelDorsal_Panel.setText("1");

        javax.swing.GroupLayout jPanelEstadisticasLayout = new javax.swing.GroupLayout(jPanelEstadisticas);
        jPanelEstadisticas.setLayout(jPanelEstadisticasLayout);
        jPanelEstadisticasLayout.setHorizontalGroup(
            jPanelEstadisticasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelEstadisticasLayout.createSequentialGroup()
                .addGroup(jPanelEstadisticasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelEstadisticasLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabelPuntos)
                        .addGap(10, 10, 10)
                        .addComponent(jTextFieldPuntos, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42)
                        .addComponent(jLabelValoracion)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldValoracion, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelEstadisticasLayout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(jLabelCrossTiros2)
                        .addGap(0, 0, 0)
                        .addComponent(jSpinnerTiros2Fallados, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(60, 60, 60)
                        .addComponent(jLabelCrossTiros3)
                        .addGap(0, 0, 0)
                        .addComponent(jSpinnerTiros3Fallados, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(70, 70, 70)
                        .addComponent(jLabelCrossTirosLibres)
                        .addGap(0, 0, 0)
                        .addComponent(jSpinnerTirosLibresFallados, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(60, 60, 60)
                        .addComponent(jLabelCrossTapones1)
                        .addGap(0, 0, 0)
                        .addComponent(jSpinnerTaponesRecibidos, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelEstadisticasLayout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jLabelRdefens, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jSpinnerRdefens, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(51, 51, 51)
                        .addComponent(jLabelAsistencias)
                        .addGap(9, 9, 9)
                        .addComponent(jSpinnerAsistencias, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(72, 72, 72)
                        .addComponent(jLabelCrossFaltas)
                        .addGap(0, 0, 0)
                        .addComponent(jSpinnerFaltasCometidas, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelEstadisticasLayout.createSequentialGroup()
                        .addGroup(jPanelEstadisticasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelEstadisticasLayout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addComponent(jLabelRofens)
                                .addGap(10, 10, 10)
                                .addComponent(jSpinnerRofens, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(21, 21, 21)
                                .addComponent(jLabelrecuperaciones)
                                .addGap(9, 9, 9)
                                .addComponent(jSpinnerRecuperaciones, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanelEstadisticasLayout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabelRebotes)
                                .addGap(4, 4, 4)
                                .addComponent(jTextFieldRebotes, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(103, 103, 103)
                                .addComponent(jLabelPerdidas)
                                .addGap(11, 11, 11)
                                .addComponent(jSpinnerPerdidas, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(70, 70, 70)
                        .addGroup(jPanelEstadisticasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelFaltas)
                            .addGroup(jPanelEstadisticasLayout.createSequentialGroup()
                                .addComponent(jLabelTicFaltas, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(2, 2, 2)
                                .addComponent(jSpinnerFaltasRecibidas, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanelEstadisticasLayout.createSequentialGroup()
                        .addGroup(jPanelEstadisticasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelEstadisticasLayout.createSequentialGroup()
                                .addGap(50, 50, 50)
                                .addComponent(jLabelTicTiros2)
                                .addGap(1, 1, 1)
                                .addComponent(jSpinnerTiros2Correct, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(60, 60, 60)
                                .addComponent(jLabelTicTiros3)
                                .addGap(1, 1, 1)
                                .addComponent(jSpinnerTiros3Correct, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(70, 70, 70)
                                .addComponent(jLabelTicTirosLibres)
                                .addGap(1, 1, 1)
                                .addComponent(jSpinnerTirosLibresCorrect, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanelEstadisticasLayout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabelTirosDe2)
                                .addGap(4, 4, 4)
                                .addComponent(jTextFieldTiros2, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(5, 5, 5)
                                .addComponent(jLabeporc2)
                                .addGap(10, 10, 10)
                                .addComponent(jLabelTirosDe3)
                                .addGap(6, 6, 6)
                                .addComponent(jTextFieldTiros3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(4, 4, 4)
                                .addComponent(jLabelporc3)
                                .addGap(6, 6, 6)
                                .addComponent(jLabelTirosLibres)
                                .addGap(4, 4, 4)
                                .addComponent(jTextFieldTirosLibres, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(jLabelporcLibres)))
                        .addGap(46, 46, 46)
                        .addGroup(jPanelEstadisticasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelEstadisticasLayout.createSequentialGroup()
                                .addGroup(jPanelEstadisticasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelTicTapones1, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabelTicTapones2, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(2, 2, 2)
                                .addComponent(jSpinnerTaponesCometidos, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabelTapones)
                            .addComponent(jLabelDorsal_Panel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(10, 10, 10))
        );
        jPanelEstadisticasLayout.setVerticalGroup(
            jPanelEstadisticasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelEstadisticasLayout.createSequentialGroup()
                .addGroup(jPanelEstadisticasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelEstadisticasLayout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jLabelPuntos))
                    .addGroup(jPanelEstadisticasLayout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(jTextFieldPuntos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelEstadisticasLayout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(jPanelEstadisticasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelValoracion)
                            .addComponent(jTextFieldValoracion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanelEstadisticasLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabelDorsal_Panel)))
                .addGap(16, 16, 16)
                .addGroup(jPanelEstadisticasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelEstadisticasLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabelTirosDe2))
                    .addComponent(jTextFieldTiros2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanelEstadisticasLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabeporc2))
                    .addGroup(jPanelEstadisticasLayout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jLabelTirosDe3))
                    .addComponent(jTextFieldTiros3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanelEstadisticasLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabelporc3))
                    .addGroup(jPanelEstadisticasLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabelTirosLibres))
                    .addComponent(jTextFieldTirosLibres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanelEstadisticasLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(jPanelEstadisticasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelporcLibres)
                            .addComponent(jLabelTapones))))
                .addGap(3, 3, 3)
                .addGroup(jPanelEstadisticasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelTicTiros2)
                    .addComponent(jSpinnerTiros2Correct, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelTicTiros3)
                    .addComponent(jSpinnerTiros3Correct, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelTicTirosLibres)
                    .addComponent(jSpinnerTirosLibresCorrect, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelTicTapones1)
                    .addComponent(jLabelTicTapones2)
                    .addComponent(jSpinnerTaponesCometidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanelEstadisticasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelCrossTiros2)
                    .addComponent(jSpinnerTiros2Fallados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelCrossTiros3)
                    .addComponent(jSpinnerTiros3Fallados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelCrossTirosLibres)
                    .addComponent(jSpinnerTirosLibresFallados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelCrossTapones1)
                    .addComponent(jSpinnerTaponesRecibidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanelEstadisticasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelEstadisticasLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabelRebotes))
                    .addComponent(jTextFieldRebotes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanelEstadisticasLayout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabelPerdidas))
                    .addGroup(jPanelEstadisticasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jSpinnerPerdidas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabelFaltas)))
                .addGap(2, 2, 2)
                .addGroup(jPanelEstadisticasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelEstadisticasLayout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jLabelRofens))
                    .addGroup(jPanelEstadisticasLayout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jSpinnerRofens, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelEstadisticasLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabelrecuperaciones))
                    .addComponent(jSpinnerRecuperaciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelTicFaltas)
                    .addComponent(jSpinnerFaltasRecibidas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanelEstadisticasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelEstadisticasLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabelRdefens))
                    .addComponent(jSpinnerRdefens, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanelEstadisticasLayout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(jLabelAsistencias))
                    .addComponent(jSpinnerAsistencias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanelEstadisticasLayout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(jLabelCrossFaltas))
                    .addGroup(jPanelEstadisticasLayout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(jSpinnerFaltasCometidas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        getContentPane().add(jPanelEstadisticas);
        jPanelEstadisticas.setBounds(330, 0, 570, 310);

        jButtonSustituir.setFont(new java.awt.Font("Comic Sans MS", 1, 12)); // NOI18N
        jButtonSustituir.setText("SUSTITUIR");
        jButtonSustituir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSustituirActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonSustituir);
        jButtonSustituir.setBounds(820, 350, 120, 27);

        jButtonGuardar.setFont(new java.awt.Font("Comic Sans MS", 1, 12)); // NOI18N
        jButtonGuardar.setText("GUARDAR");
        jButtonGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGuardarActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonGuardar);
        jButtonGuardar.setBounds(690, 350, 120, 27);

        jButtonSalir.setFont(new java.awt.Font("Comic Sans MS", 1, 12)); // NOI18N
        jButtonSalir.setText("SALIR");
        jButtonSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalirActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonSalir);
        jButtonSalir.setBounds(560, 350, 120, 27);

        jLabelBanquillo.setFont(new java.awt.Font("DejaVu Sans Condensed", 0, 15)); // NOI18N
        jLabelBanquillo.setForeground(new java.awt.Color(1, 1, 1));
        jLabelBanquillo.setText("Banquillo:");
        getContentPane().add(jLabelBanquillo);
        jLabelBanquillo.setBounds(10, 350, 80, 30);

        jButton7hombre.setText("7");
        jButton7hombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7hombreActionPerformed(evt);
            }
        });
        getContentPane().add(jButton7hombre);
        jButton7hombre.setBounds(150, 350, 50, 30);

        jButton9hombre.setText("9");
        jButton9hombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9hombreActionPerformed(evt);
            }
        });
        getContentPane().add(jButton9hombre);
        jButton9hombre.setBounds(270, 350, 50, 30);

        jButton11hombre.setText("11");
        jButton11hombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11hombreActionPerformed(evt);
            }
        });
        getContentPane().add(jButton11hombre);
        jButton11hombre.setBounds(390, 350, 50, 30);

        jButton8hombre.setText("8");
        jButton8hombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8hombreActionPerformed(evt);
            }
        });
        getContentPane().add(jButton8hombre);
        jButton8hombre.setBounds(210, 350, 50, 30);

        jButton6hombre.setText("6");
        jButton6hombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6hombreActionPerformed(evt);
            }
        });
        getContentPane().add(jButton6hombre);
        jButton6hombre.setBounds(90, 350, 50, 30);

        jButton12hombre.setText("12");
        jButton12hombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12hombreActionPerformed(evt);
            }
        });
        getContentPane().add(jButton12hombre);
        jButton12hombre.setBounds(450, 350, 50, 30);

        jButton10hombre.setText("10");
        jButton10hombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10hombreActionPerformed(evt);
            }
        });
        getContentPane().add(jButton10hombre);
        jButton10hombre.setBounds(330, 350, 50, 30);

        jLabelBg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Presentacion/basket.png"))); // NOI18N
        getContentPane().add(jLabelBg);
        jLabelBg.setBounds(0, 0, 945, 390);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public TransferEstadistica[] getJugadores() {
        return jugadores;
    }

 private void jButtonEscoltaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEscoltaActionPerformed
     actualizarEstadisticas();
     jugadorEnPanel = buscarDorsal(Integer.parseInt(jButtonEscolta.getText()));
     this.mostrarEstadisticasPanel(jugadorEnPanel);
     desbloquearSppiners();
    }//GEN-LAST:event_jButtonEscoltaActionPerformed

    private void jButtonPivotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPivotActionPerformed
        actualizarEstadisticas();
        jugadorEnPanel = buscarDorsal(Integer.parseInt(jButtonPivot.getText()));
        this.mostrarEstadisticasPanel(jugadorEnPanel);
        desbloquearSppiners();
    }//GEN-LAST:event_jButtonPivotActionPerformed

    private void jButtonBaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBaseActionPerformed
        actualizarEstadisticas();
        jugadorEnPanel = buscarDorsal(Integer.parseInt(jButtonBase.getText()));
        this.mostrarEstadisticasPanel(jugadorEnPanel);
        desbloquearSppiners();
    }//GEN-LAST:event_jButtonBaseActionPerformed

    private void jButtonAlaPivotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAlaPivotActionPerformed
        actualizarEstadisticas();
        jugadorEnPanel = jugadorEnPanel = buscarDorsal(Integer.parseInt(jButtonAlaPivot.getText()));
        this.mostrarEstadisticasPanel(jugadorEnPanel);
        desbloquearSppiners();
    }//GEN-LAST:event_jButtonAlaPivotActionPerformed

    private void jButtonAleroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAleroActionPerformed
        actualizarEstadisticas();
        jugadorEnPanel = buscarDorsal(Integer.parseInt(jButtonAlero.getText()));
        this.mostrarEstadisticasPanel(jugadorEnPanel);
        desbloquearSppiners();
    }//GEN-LAST:event_jButtonAleroActionPerformed

    private void jButton7hombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7hombreActionPerformed
        actualizarEstadisticas();
        jugadorEnPanel = buscarDorsal(Integer.parseInt(jButton7hombre.getText()));
        this.mostrarEstadisticasPanel(jugadorEnPanel);
        bloquearSpinners();
    }//GEN-LAST:event_jButton7hombreActionPerformed

    private void jButton6hombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6hombreActionPerformed
        actualizarEstadisticas();
        jugadorEnPanel = buscarDorsal(Integer.parseInt(jButton6hombre.getText()));
        this.mostrarEstadisticasPanel(jugadorEnPanel);
        bloquearSpinners();
    }//GEN-LAST:event_jButton6hombreActionPerformed

    private void jButton8hombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8hombreActionPerformed
        actualizarEstadisticas();
        jugadorEnPanel = buscarDorsal(Integer.parseInt(jButton8hombre.getText()));
        this.mostrarEstadisticasPanel(jugadorEnPanel);
        bloquearSpinners();
    }//GEN-LAST:event_jButton8hombreActionPerformed

    private void jButton9hombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9hombreActionPerformed
        actualizarEstadisticas();
        jugadorEnPanel = buscarDorsal(Integer.parseInt(jButton9hombre.getText()));
        this.mostrarEstadisticasPanel(jugadorEnPanel);
        bloquearSpinners();
    }//GEN-LAST:event_jButton9hombreActionPerformed

    private void jButton10hombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10hombreActionPerformed
        actualizarEstadisticas();
        jugadorEnPanel = buscarDorsal(Integer.parseInt(jButton10hombre.getText()));
        this.mostrarEstadisticasPanel(jugadorEnPanel);
        bloquearSpinners();
    }//GEN-LAST:event_jButton10hombreActionPerformed

    private void jButton12hombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12hombreActionPerformed
        actualizarEstadisticas();
        jugadorEnPanel = buscarDorsal(Integer.parseInt(jButton12hombre.getText()));
        this.mostrarEstadisticasPanel(jugadorEnPanel);
        bloquearSpinners();
    }//GEN-LAST:event_jButton12hombreActionPerformed

    private void jButton11hombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11hombreActionPerformed
        actualizarEstadisticas();
        jugadorEnPanel = buscarDorsal(Integer.parseInt(jButton11hombre.getText()));
        this.mostrarEstadisticasPanel(jugadorEnPanel);
        bloquearSpinners();
    }//GEN-LAST:event_jButton11hombreActionPerformed

    private void jSpinnerTiros2CorrectStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSpinnerTiros2CorrectStateChanged
        actualizarCampos();
    }//GEN-LAST:event_jSpinnerTiros2CorrectStateChanged

    private void jSpinnerTiros2FalladosStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSpinnerTiros2FalladosStateChanged
        actualizarCampos();
    }//GEN-LAST:event_jSpinnerTiros2FalladosStateChanged

    private void jSpinnerTiros3CorrectStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSpinnerTiros3CorrectStateChanged
        actualizarCampos();
    }//GEN-LAST:event_jSpinnerTiros3CorrectStateChanged

    private void jSpinnerTiros3FalladosStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSpinnerTiros3FalladosStateChanged
        actualizarCampos();
    }//GEN-LAST:event_jSpinnerTiros3FalladosStateChanged

    private void jSpinnerTirosLibresCorrectStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSpinnerTirosLibresCorrectStateChanged
        actualizarCampos();
    }//GEN-LAST:event_jSpinnerTirosLibresCorrectStateChanged

    private void jSpinnerTirosLibresFalladosStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSpinnerTirosLibresFalladosStateChanged
        actualizarCampos();
    }//GEN-LAST:event_jSpinnerTirosLibresFalladosStateChanged

    private void jSpinnerTaponesRecibidosStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSpinnerTaponesRecibidosStateChanged
        actualizarCampos();
    }//GEN-LAST:event_jSpinnerTaponesRecibidosStateChanged

    private void jSpinnerRofensStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSpinnerRofensStateChanged
        actualizarCampos();
    }//GEN-LAST:event_jSpinnerRofensStateChanged

    private void jSpinnerRdefensStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSpinnerRdefensStateChanged
        actualizarCampos();
    }//GEN-LAST:event_jSpinnerRdefensStateChanged

    private void jSpinnerPerdidasStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSpinnerPerdidasStateChanged
        actualizarCampos();
    }//GEN-LAST:event_jSpinnerPerdidasStateChanged

    private void jSpinnerRecuperacionesStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSpinnerRecuperacionesStateChanged
        actualizarCampos();
    }//GEN-LAST:event_jSpinnerRecuperacionesStateChanged

    private void jSpinnerAsistenciasStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSpinnerAsistenciasStateChanged
        actualizarCampos();
    }//GEN-LAST:event_jSpinnerAsistenciasStateChanged

    private void jSpinnerFaltasRecibidasStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSpinnerFaltasRecibidasStateChanged
        actualizarCampos();
    }//GEN-LAST:event_jSpinnerFaltasRecibidasStateChanged

    private void jSpinnerFaltasCometidasStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSpinnerFaltasCometidasStateChanged
        actualizarCampos();
    }//GEN-LAST:event_jSpinnerFaltasCometidasStateChanged

    private void jSpinnerTaponesCometidosStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSpinnerTaponesCometidosStateChanged
        actualizarCampos();
    }//GEN-LAST:event_jSpinnerTaponesCometidosStateChanged

    private void jButtonSustituirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSustituirActionPerformed

        actualizarEstadisticas();

        Sustitucion change = new Sustitucion(PresentacionEstadistica.this);
        change.setVisible(true);


    }//GEN-LAST:event_jButtonSustituirActionPerformed

    public void actualizarCambios(int cambio) {
        TransferEstadistica aux;
        aux = jugadores[jugadorEnPanel];
        jugadores[jugadorEnPanel] = jugadores[cambio];
        jugadores[cambio] = aux;

        this.actualizarComponentes();
        this.mostrarEstadisticasPanel(jugadorEnPanel);
    }

    private void jButtonGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGuardarActionPerformed

        actualizarEstadisticas();

        for (int i = 0; i < 12; i++) {
            Controlador.getInstancia().accion(30, jugadores[i]);
        }

    }//GEN-LAST:event_jButtonGuardarActionPerformed

    private void jButtonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalirActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_jButtonSalirActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PresentacionEstadistica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PresentacionEstadistica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PresentacionEstadistica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PresentacionEstadistica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                PresentacionEstadistica pe = new PresentacionEstadistica(null);
                pe.setSize(955, 420);
                pe.setVisible(true);

            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton10hombre;
    private javax.swing.JButton jButton11hombre;
    private javax.swing.JButton jButton12hombre;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton6hombre;
    private javax.swing.JButton jButton7hombre;
    private javax.swing.JButton jButton8hombre;
    private javax.swing.JButton jButton9hombre;
    private javax.swing.JButton jButtonAlaPivot;
    private javax.swing.JButton jButtonAlero;
    private javax.swing.JButton jButtonBase;
    private javax.swing.JButton jButtonEscolta;
    private javax.swing.JButton jButtonGuardar;
    private javax.swing.JButton jButtonPivot;
    private javax.swing.JButton jButtonSalir;
    private javax.swing.JButton jButtonSustituir;
    private javax.swing.JLabel jLabelAsistencias;
    private javax.swing.JLabel jLabelBanquillo;
    private javax.swing.JLabel jLabelBg;
    private javax.swing.JLabel jLabelCrossFaltas;
    private javax.swing.JLabel jLabelCrossTapones1;
    private javax.swing.JLabel jLabelCrossTiros2;
    private javax.swing.JLabel jLabelCrossTiros3;
    private javax.swing.JLabel jLabelCrossTirosLibres;
    private javax.swing.JLabel jLabelDorsal_Panel;
    private javax.swing.JLabel jLabelFaltas;
    private javax.swing.JLabel jLabelPerdidas;
    private javax.swing.JLabel jLabelPuntos;
    private javax.swing.JLabel jLabelRdefens;
    private javax.swing.JLabel jLabelRebotes;
    private javax.swing.JLabel jLabelRofens;
    private javax.swing.JLabel jLabelTapones;
    private javax.swing.JLabel jLabelTicFaltas;
    private javax.swing.JLabel jLabelTicTapones1;
    private javax.swing.JLabel jLabelTicTapones2;
    private javax.swing.JLabel jLabelTicTiros2;
    private javax.swing.JLabel jLabelTicTiros3;
    private javax.swing.JLabel jLabelTicTirosLibres;
    private javax.swing.JLabel jLabelTirosDe2;
    private javax.swing.JLabel jLabelTirosDe3;
    private javax.swing.JLabel jLabelTirosLibres;
    private javax.swing.JLabel jLabelValoracion;
    private javax.swing.JLabel jLabelporc3;
    private javax.swing.JLabel jLabelporcLibres;
    private javax.swing.JLabel jLabelrecuperaciones;
    private javax.swing.JLabel jLabeporc2;
    private javax.swing.JPanel jPanelEstadisticas;
    private javax.swing.JSpinner jSpinnerAsistencias;
    private javax.swing.JSpinner jSpinnerFaltasCometidas;
    private javax.swing.JSpinner jSpinnerFaltasRecibidas;
    private javax.swing.JSpinner jSpinnerPerdidas;
    private javax.swing.JSpinner jSpinnerRdefens;
    private javax.swing.JSpinner jSpinnerRecuperaciones;
    private javax.swing.JSpinner jSpinnerRofens;
    private javax.swing.JSpinner jSpinnerTaponesCometidos;
    private javax.swing.JSpinner jSpinnerTaponesRecibidos;
    private javax.swing.JSpinner jSpinnerTiros2Correct;
    private javax.swing.JSpinner jSpinnerTiros2Fallados;
    private javax.swing.JSpinner jSpinnerTiros3Correct;
    private javax.swing.JSpinner jSpinnerTiros3Fallados;
    private javax.swing.JSpinner jSpinnerTirosLibresCorrect;
    private javax.swing.JSpinner jSpinnerTirosLibresFallados;
    private javax.swing.JTextField jTextFieldPuntos;
    private javax.swing.JTextField jTextFieldRebotes;
    private javax.swing.JTextField jTextFieldTiros2;
    private javax.swing.JTextField jTextFieldTiros3;
    private javax.swing.JTextField jTextFieldTirosLibres;
    private javax.swing.JTextField jTextFieldValoracion;
    // End of variables declaration//GEN-END:variables
}
