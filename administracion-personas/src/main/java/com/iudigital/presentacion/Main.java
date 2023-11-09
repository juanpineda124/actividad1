/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.iudigital.presentacion;

import controller.EstadoCivilController;
import controller.FuncionarioController;
import controller.SexoController;
import controller.TipoIdentificacionController;
import domain.EstadoCivil;
import domain.Funcionario;
import domain.Sexo;
import domain.TipoIdentificacion;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author User
 */
public class Main extends javax.swing.JFrame {

    private final FuncionarioController funcionarioController;
    private final SexoController sexoController;
    private final TipoIdentificacionController tipoIdentificacionController;
    private final EstadoCivilController estadoCivilController;
    private final String[] COLUMNS = {"ID", "TIPO_IDENTIFICACION_id", "NUMERO_IDENTIFICACION", "NOMBRES",
        "APELLIDOS", "ESTADO_CIVIL_ID", "SEXO_ID", "DIRECCION", "TELEFONO", "FECHA_NACIMIENTO"};
    private final static String SELECCIONE = "--SELECCIONE--";
    private final static String SEXO = "--SEXO--";
    private final static String TIPO = "--TIPO--";
    private final static String ESTADO = "--ESTADO--";

    public Main() {
        initComponents();
        txtFuncId.setEditable(false);
        funcionarioController = new FuncionarioController();
        sexoController = new SexoController();
        tipoIdentificacionController = new TipoIdentificacionController();
        estadoCivilController = new EstadoCivilController();
        listFuncs();
        listEstado();
        listSexo();
        listTipo();
        addListener();
    }

    private void listFuncs() {

        cbxFuncs.removeAllItems();
        Funcionario funcionario1 = new Funcionario();
        funcionario1.setNombres(SELECCIONE);
        funcionario1.setApellidos(" ");
        cbxFuncs.addItem(funcionario1);
        DefaultTableModel defaultTableModel = new DefaultTableModel();
        for (String COLUMN : COLUMNS) {
            defaultTableModel.addColumn(COLUMN);
        }

        tblFuncs.setModel(defaultTableModel);
        try {
            List<Funcionario> funcionarios = funcionarioController.obtenerFuncionarios();
            if (funcionarios.isEmpty()) {
                return;
            }

            defaultTableModel.setRowCount((funcionarios.size()));
            int row = 0;
            for (Funcionario funcionario : funcionarios) {
                defaultTableModel.setValueAt(funcionario.getId(), row, 0);
                defaultTableModel.setValueAt(funcionario.getTipoIdentificacion_id(), row, 1);
                defaultTableModel.setValueAt(funcionario.getNumeroIdentificacion(), row, 2);
                defaultTableModel.setValueAt(funcionario.getNombres(), row, 3);
                defaultTableModel.setValueAt(funcionario.getApellidos(), row, 4);
                defaultTableModel.setValueAt(funcionario.getEstadoCivil_id(), row, 5);
                defaultTableModel.setValueAt(funcionario.getSexo_id(), row, 6);
                defaultTableModel.setValueAt(funcionario.getDireccion(), row, 7);
                defaultTableModel.setValueAt(funcionario.getTelefono(), row, 8);
                defaultTableModel.setValueAt(funcionario.getFechaNacimiento(), row, 9);
                row++;

                cbxFuncs.addItem(funcionario);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    private void listEstado() {

        cbxEstado.removeAllItems();
        EstadoCivil estadoCivil1 = new EstadoCivil();
        estadoCivil1.setNombre(ESTADO);
        cbxEstado.addItem(estadoCivil1);
        try {
            List<EstadoCivil> estadosCiviles = estadoCivilController.obtenerEstadoCivil();
            for (EstadoCivil estadoCivil : estadosCiviles) {
                cbxEstado.addItem(estadoCivil);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    private void listSexo() {

        cbxSex.removeAllItems();
        Sexo sex1 = new Sexo();
        sex1.setNombre(SEXO);
        cbxSex.addItem(sex1);

        try {
            List<Sexo> sexos = sexoController.obtenerSexo();
            for (Sexo sexo : sexos) {
                cbxSex.addItem(sexo);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    private void listTipo() {

        cbxTipe.removeAllItems();
        TipoIdentificacion tipoIdentificacion1 = new TipoIdentificacion();
        tipoIdentificacion1.setNombre(TIPO);
        cbxTipe.addItem(tipoIdentificacion1);

        try {
            List<TipoIdentificacion> tiposIdentificaciones = tipoIdentificacionController.obtenerTipoIdentificacion();
            for (TipoIdentificacion tipoIdentificacion : tiposIdentificaciones) {
                cbxTipe.addItem(tipoIdentificacion);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    private void addListener() {
        cbxFuncs.addItemListener(event -> {
            Funcionario seledtedFun = (Funcionario) event.getItem();
            if (seledtedFun.getNombres().equals(SELECCIONE)) {
                txtFuncId.setText("");
                txtTipeEdit.setText("");
                txtNombreT.setText("");
                txtNumberEdit.setText("");
                txtNombresEdit.setText("");
                txtApellidosEdit.setText("");
                txtEstadoEdit.setText("");
                txtSexEdit.setText("");
                txtDireccionEdit.setText("");
                txtCellEdit.setText("");
                txtFechaEdit.setText("");
            } else {
                txtFuncId.setText(String.valueOf(seledtedFun.getId()));
                txtTipeEdit.setText(String.valueOf(seledtedFun.getTipoIdentificacion_id()));
                txtNumberEdit.setText(String.valueOf(seledtedFun.getNumeroIdentificacion()));
                txtNombresEdit.setText(String.valueOf(seledtedFun.getNombres()));
                txtApellidosEdit.setText(String.valueOf(seledtedFun.getApellidos()));
                txtEstadoEdit.setText(String.valueOf(seledtedFun.getEstadoCivil_id()));
                txtSexEdit.setText(String.valueOf(seledtedFun.getSexo_id()));
                txtDireccionEdit.setText(String.valueOf(seledtedFun.getDireccion()));
                txtCellEdit.setText(String.valueOf(seledtedFun.getTelefono()));
                txtFechaEdit.setText(String.valueOf(seledtedFun.getFechaNacimiento()));
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTPanels = new javax.swing.JTabbedPane();
        jPFunc1 = new javax.swing.JPanel();
        jPFunc = new javax.swing.JPanel();
        lblTipe = new javax.swing.JLabel();
        lblNumer = new javax.swing.JLabel();
        lblnombre = new javax.swing.JLabel();
        lblApellidos = new javax.swing.JLabel();
        lblEstado = new javax.swing.JLabel();
        lblSex = new javax.swing.JLabel();
        lblDireccion = new javax.swing.JLabel();
        lblCell = new javax.swing.JLabel();
        lblFecha = new javax.swing.JLabel();
        txtTipe = new javax.swing.JTextField();
        txtNumber = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        txtApellidos = new javax.swing.JTextField();
        txtEstado = new javax.swing.JTextField();
        txtSex = new javax.swing.JTextField();
        txtDireccion = new javax.swing.JTextField();
        txtCell = new javax.swing.JTextField();
        txtFecha = new javax.swing.JTextField();
        btnCrear = new javax.swing.JButton();
        cbxTipe = new javax.swing.JComboBox<>();
        cbxEstado = new javax.swing.JComboBox<>();
        cbxSex = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblFuncs = new javax.swing.JTable();
        jPaFunc2 = new javax.swing.JPanel();
        jPUpdateFunc = new javax.swing.JPanel();
        lblFuncs = new javax.swing.JLabel();
        cbxFuncs = new javax.swing.JComboBox<>();
        lblFuncId = new javax.swing.JLabel();
        txtFuncId = new javax.swing.JTextField();
        lblTipeEdit = new javax.swing.JLabel();
        lblNumberEdit = new javax.swing.JLabel();
        lblNombresEdit = new javax.swing.JLabel();
        lblApellidosEdit = new javax.swing.JLabel();
        lblEstadoEdit = new javax.swing.JLabel();
        lblSexEdit = new javax.swing.JLabel();
        lblDireccionEdit = new javax.swing.JLabel();
        lblCellEdit = new javax.swing.JLabel();
        lblFechaEdit = new javax.swing.JLabel();
        txtTipeEdit = new javax.swing.JTextField();
        txtNombresEdit = new javax.swing.JTextField();
        txtApellidosEdit = new javax.swing.JTextField();
        txtDireccionEdit = new javax.swing.JTextField();
        txtCellEdit = new javax.swing.JTextField();
        txtFechaEdit = new javax.swing.JTextField();
        btnActualizar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        txtNumberEdit = new javax.swing.JTextField();
        txtEstadoEdit = new javax.swing.JTextField();
        txtSexEdit = new javax.swing.JTextField();
        txtNombreT = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("ADMINISTRACION FUNCIONARIOS");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 20, -1, -1));

        jPFunc.setBorder(javax.swing.BorderFactory.createTitledBorder("Digite los siguientes campos"));

        lblTipe.setText("TIPO IDENTIFICACION");

        lblNumer.setText("NUMERO IDENTIFICACION");

        lblnombre.setText("NOMBRES");

        lblApellidos.setText("APELLIDOS");

        lblEstado.setText("ESTADO CIVIL");

        lblSex.setText("SEXO");

        lblDireccion.setText("DIRECCION");

        lblCell.setText("TELEFONO");

        lblFecha.setText("FECHA NACIMIENTO");

        txtTipe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTipeActionPerformed(evt);
            }
        });

        btnCrear.setText("GUARDAR");
        btnCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPFuncLayout = new javax.swing.GroupLayout(jPFunc);
        jPFunc.setLayout(jPFuncLayout);
        jPFuncLayout.setHorizontalGroup(
            jPFuncLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPFuncLayout.createSequentialGroup()
                .addGroup(jPFuncLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPFuncLayout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(lblTipe))
                    .addGroup(jPFuncLayout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addGroup(jPFuncLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cbxTipe, 0, 94, Short.MAX_VALUE)
                            .addComponent(txtTipe))))
                .addGap(18, 18, 18)
                .addGroup(jPFuncLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPFuncLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(txtNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblNumer))
                .addGroup(jPFuncLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPFuncLayout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(lblnombre))
                    .addGroup(jPFuncLayout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPFuncLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPFuncLayout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(lblApellidos))
                    .addGroup(jPFuncLayout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(txtApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPFuncLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cbxEstado, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblEstado, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                    .addComponent(txtEstado))
                .addGroup(jPFuncLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPFuncLayout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(lblSex)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblDireccion)
                        .addGap(57, 57, 57))
                    .addGroup(jPFuncLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPFuncLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cbxSex, 0, 81, Short.MAX_VALUE)
                            .addComponent(txtSex))
                        .addGap(18, 18, 18)
                        .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)))
                .addGroup(jPFuncLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtCell, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCell))
                .addGap(18, 18, 18)
                .addGroup(jPFuncLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblFecha)
                    .addGroup(jPFuncLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(16, 16, 16))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPFuncLayout.createSequentialGroup()
                .addGap(520, 520, 520)
                .addComponent(btnCrear)
                .addGap(520, 520, 520))
        );
        jPFuncLayout.setVerticalGroup(
            jPFuncLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPFuncLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPFuncLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTipe)
                    .addComponent(lblNumer)
                    .addComponent(lblnombre)
                    .addComponent(lblApellidos)
                    .addComponent(lblEstado)
                    .addComponent(lblSex)
                    .addComponent(lblDireccion)
                    .addComponent(lblCell)
                    .addComponent(lblFecha))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPFuncLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtEstado, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPFuncLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtTipe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtCell, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtSex, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPFuncLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbxTipe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxSex, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                .addComponent(btnCrear)
                .addGap(29, 29, 29))
        );

        tblFuncs.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tblFuncs);

        javax.swing.GroupLayout jPFunc1Layout = new javax.swing.GroupLayout(jPFunc1);
        jPFunc1.setLayout(jPFunc1Layout);
        jPFunc1Layout.setHorizontalGroup(
            jPFunc1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPFunc1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPFunc1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPFunc1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jPFunc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(112, 112, 112))
        );
        jPFunc1Layout.setVerticalGroup(
            jPFunc1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPFunc1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPFunc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jTPanels.addTab("CREAR", jPFunc1);

        jPUpdateFunc.setBorder(javax.swing.BorderFactory.createTitledBorder("Modifique los siguientes campos"));

        lblFuncs.setText("FUNCIONARIOS");

        lblFuncId.setText("ID");

        lblTipeEdit.setText("TIPO IDENTIFICACION");

        lblNumberEdit.setText("NUMERO IDENTIFICACION");

        lblNombresEdit.setText("NOMBRES");

        lblApellidosEdit.setText("APELLIDOS");

        lblEstadoEdit.setText("ESTADO CIVIL");

        lblSexEdit.setText("SEXO");

        lblDireccionEdit.setText("DIRECCION");

        lblCellEdit.setText("TELEFONO");

        lblFechaEdit.setText("FECHA NACIMIENTO");

        btnActualizar.setText("ACTUALIZAR");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        btnEliminar.setText("ELIMINAR");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPUpdateFuncLayout = new javax.swing.GroupLayout(jPUpdateFunc);
        jPUpdateFunc.setLayout(jPUpdateFuncLayout);
        jPUpdateFuncLayout.setHorizontalGroup(
            jPUpdateFuncLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPUpdateFuncLayout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(jPUpdateFuncLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblFuncs)
                    .addComponent(cbxFuncs, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPUpdateFuncLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(lblFuncId)
                        .addGap(84, 84, 84)
                        .addGroup(jPUpdateFuncLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPUpdateFuncLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPUpdateFuncLayout.createSequentialGroup()
                                    .addGroup(jPUpdateFuncLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtNumberEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtNombresEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtFuncId, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(185, 185, 185)
                                    .addGroup(jPUpdateFuncLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lblEstadoEdit)
                                        .addGroup(jPUpdateFuncLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(lblCellEdit)
                                            .addComponent(lblDireccionEdit)))
                                    .addGap(37, 37, 37))
                                .addGroup(jPUpdateFuncLayout.createSequentialGroup()
                                    .addComponent(txtTipeEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtNombreT, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblSexEdit)
                                    .addGap(62, 62, 62)))
                            .addGroup(jPUpdateFuncLayout.createSequentialGroup()
                                .addComponent(txtApellidosEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(168, 168, 168)
                                .addComponent(lblFechaEdit)
                                .addGap(18, 18, 18)))
                        .addGroup(jPUpdateFuncLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtFechaEdit)
                            .addComponent(txtCellEdit, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE)
                            .addComponent(txtDireccionEdit, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtEstadoEdit, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtSexEdit, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(109, 109, 109)
                        .addGroup(jPUpdateFuncLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnEliminar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnActualizar, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(140, 140, 140))))
            .addGroup(jPUpdateFuncLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTipeEdit)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPUpdateFuncLayout.createSequentialGroup()
                .addGroup(jPUpdateFuncLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblNumberEdit)
                    .addGroup(jPUpdateFuncLayout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(jPUpdateFuncLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblApellidosEdit)
                            .addComponent(lblNombresEdit))))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPUpdateFuncLayout.setVerticalGroup(
            jPUpdateFuncLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPUpdateFuncLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(lblFuncs)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cbxFuncs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPUpdateFuncLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPUpdateFuncLayout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addGroup(jPUpdateFuncLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtFuncId, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPUpdateFuncLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtEstadoEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblEstadoEdit))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPUpdateFuncLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblFuncId)))
                .addGap(18, 18, 18)
                .addGroup(jPUpdateFuncLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPUpdateFuncLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblTipeEdit)
                        .addComponent(txtTipeEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblSexEdit)
                        .addComponent(txtSexEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtNombreT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnActualizar))
                .addGap(18, 18, 18)
                .addGroup(jPUpdateFuncLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNumberEdit)
                    .addComponent(txtNumberEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDireccionEdit)
                    .addComponent(txtDireccionEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPUpdateFuncLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombresEdit)
                    .addComponent(txtNombresEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCellEdit)
                    .addComponent(txtCellEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminar))
                .addGap(18, 18, 18)
                .addGroup(jPUpdateFuncLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblApellidosEdit)
                    .addComponent(txtApellidosEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblFechaEdit)
                    .addComponent(txtFechaEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(63, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPaFunc2Layout = new javax.swing.GroupLayout(jPaFunc2);
        jPaFunc2.setLayout(jPaFunc2Layout);
        jPaFunc2Layout.setHorizontalGroup(
            jPaFunc2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPaFunc2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPUpdateFunc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(126, Short.MAX_VALUE))
        );
        jPaFunc2Layout.setVerticalGroup(
            jPaFunc2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPaFunc2Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jPUpdateFunc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(72, Short.MAX_VALUE))
        );

        jTPanels.addTab("EDITAR", jPaFunc2);

        getContentPane().add(jTPanels, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 1230, 530));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtTipeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTipeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTipeActionPerformed

    private void btnCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearActionPerformed

        if (txtTipe.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "Digite el id del tipo de identificacion presente en la lista");
            txtTipe.requestFocus();
            return;
        }

        if (txtNumber.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "Digite el numero de identificacion");
            txtNumber.requestFocus();
            return;
        }

        if (txtNombre.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "Digite el nombre");
            txtNombre.requestFocus();
            return;
        }

        if (txtApellidos.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "Digite los apellidos");
            txtApellidos.requestFocus();
            return;
        }

        if (txtEstado.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "Digite el id del estado civil presente en la lista");
            txtEstado.requestFocus();
            return;
        }

        if (txtSex.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "Digite el id del sexo presente en la lista");
            txtSex.requestFocus();
            return;
        }

        if (txtDireccion.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "Digite la direccion");
            txtDireccion.requestFocus();
            return;
        }

        if (txtCell.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "Digite el telefono");
            txtCell.requestFocus();
            return;
        }

        if (txtFecha.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "Digite la fecha de nacimiento");
            txtFecha.requestFocus();
            return;
        }

        Funcionario funcionario = new Funcionario();
        funcionario.setTipoIdentificacion_id(Short.valueOf(txtTipe.getText().trim()));
        funcionario.setNumeroIdentificacion(txtNumber.getText().trim());
        funcionario.setNombres(txtNombre.getText().trim());
        funcionario.setApellidos(txtApellidos.getText().trim());
        funcionario.setEstadoCivil_id(Short.valueOf(txtEstado.getText().trim()));
        funcionario.setSexo_id(Short.valueOf(txtSex.getText().trim()));
        funcionario.setDireccion(txtDireccion.getText().trim());
        funcionario.setTelefono(txtCell.getText().trim());
        funcionario.setFechaNacimiento(txtFecha.getText().trim());

        try {
            funcionarioController.crearFuncionario(funcionario);
            txtTipe.setText("");
            txtNumber.setText("");
            txtNombre.setText("");
            txtApellidos.setText("");
            txtEstado.setText("");
            txtSex.setText("");
            txtDireccion.setText("");
            txtCell.setText("");
            txtFecha.setText("");
            listFuncs();
            JOptionPane.showMessageDialog(null, "Funcionario creado con exito");

        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "No fue posible crear el funcionario");
        }
    }//GEN-LAST:event_btnCrearActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
       
        if (txtFuncId.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "Seleccione a un funcionario de la lista");
            txtFuncId.requestFocus();
            return;
        } 

        int opt = JOptionPane.showConfirmDialog(null, "Esta seguro que desea eliminar la informacion del funcionario",
                "Confirmar salida", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

        if (opt == 0) {

            try {
                funcionarioController.eliminarFuncionario(Integer.parseInt(txtFuncId.getText()));
                txtTipeEdit.setText("");
                txtNumberEdit.setText("");
                txtNombresEdit.setText("");
                txtApellidosEdit.setText("");
                txtEstadoEdit.setText("");
                txtSexEdit.setText("");
                txtDireccionEdit.setText("");
                txtCellEdit.setText("");
                txtFechaEdit.setText("");
                listFuncs();
                JOptionPane.showMessageDialog(null, "Funcionario eliminado del sistema exito");

            } catch (SQLException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "No fue posible eliminar el funcionario");
            }
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed

        if (txtFuncId.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "Seleccione a un funcionario de la lista");
            txtFuncId.requestFocus();
            return;
        }

        if (txtTipeEdit.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "Digite el tipo de identificacion");
            txtTipeEdit.requestFocus();
            return;
        }

        if (txtNumberEdit.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "Digite el numero de identificacion");
            txtNumberEdit.requestFocus();
            return;
        }

        if (txtNombresEdit.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "Digite el nombre");
            txtNombresEdit.requestFocus();
            return;
        }

        if (txtApellidosEdit.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "Digite los apellidos");
            txtApellidosEdit.requestFocus();
            return;
        }

        if (txtEstadoEdit.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "Digite el estado");
            txtEstadoEdit.requestFocus();
            return;
        }

        if (txtSexEdit.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "Digite el sexo");
            txtSexEdit.requestFocus();
            return;
        }

        if (txtDireccionEdit.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "Digite la direccion");
            txtDireccionEdit.requestFocus();
            return;
        }

        if (txtCellEdit.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "Digite el telefono");
            txtCellEdit.requestFocus();
            return;
        }

        if (txtFechaEdit.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "Digite la fecha de nacimiento");
            txtFechaEdit.requestFocus();
            return;
        }

        Funcionario funcionario = new Funcionario();
        funcionario.setTipoIdentificacion_id(Short.parseShort(txtTipeEdit.getText().trim()));
        funcionario.setNumeroIdentificacion(txtNumberEdit.getText().trim());
        funcionario.setNombres(txtNombresEdit.getText().trim());
        funcionario.setApellidos(txtApellidosEdit.getText().trim());
        funcionario.setEstadoCivil_id(Short.valueOf(txtEstadoEdit.getText().trim()));
        funcionario.setSexo_id(Short.valueOf(txtSexEdit.getText().trim()));
        funcionario.setDireccion(txtDireccionEdit.getText().trim());
        funcionario.setTelefono(txtCellEdit.getText().trim());
        funcionario.setFechaNacimiento(txtFechaEdit.getText().trim());

        int opt = JOptionPane.showConfirmDialog(null, "Desea actualizar la informacion del funcionario",
                "Confirmar salida", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

        if (opt == 0) {

            try {
                funcionarioController.actualizarFuncionario(Integer.parseInt(txtFuncId.getText()), funcionario);
                txtTipeEdit.setText("");
                txtNumberEdit.setText("");
                txtNombresEdit.setText("");
                txtApellidosEdit.setText("");
                txtEstadoEdit.setText("");
                txtSexEdit.setText("");
                txtDireccionEdit.setText("");
                txtCellEdit.setText("");
                txtFechaEdit.setText("");
                listFuncs();
                JOptionPane.showMessageDialog(null, "Funcionario actualizado con exito");

            } catch (SQLException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "No fue posible actualizar el funcionario");
            }
        }
    }//GEN-LAST:event_btnActualizarActionPerformed

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
                if ("window".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnCrear;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JComboBox<domain.EstadoCivil> cbxEstado;
    private javax.swing.JComboBox<Funcionario> cbxFuncs;
    private javax.swing.JComboBox<domain.Sexo> cbxSex;
    private javax.swing.JComboBox<domain.TipoIdentificacion> cbxTipe;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPFunc;
    private javax.swing.JPanel jPFunc1;
    private javax.swing.JPanel jPUpdateFunc;
    private javax.swing.JPanel jPaFunc2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTPanels;
    private javax.swing.JLabel lblApellidos;
    private javax.swing.JLabel lblApellidosEdit;
    private javax.swing.JLabel lblCell;
    private javax.swing.JLabel lblCellEdit;
    private javax.swing.JLabel lblDireccion;
    private javax.swing.JLabel lblDireccionEdit;
    private javax.swing.JLabel lblEstado;
    private javax.swing.JLabel lblEstadoEdit;
    private javax.swing.JLabel lblFecha;
    private javax.swing.JLabel lblFechaEdit;
    private javax.swing.JLabel lblFuncId;
    private javax.swing.JLabel lblFuncs;
    private javax.swing.JLabel lblNombresEdit;
    private javax.swing.JLabel lblNumberEdit;
    private javax.swing.JLabel lblNumer;
    private javax.swing.JLabel lblSex;
    private javax.swing.JLabel lblSexEdit;
    private javax.swing.JLabel lblTipe;
    private javax.swing.JLabel lblTipeEdit;
    private javax.swing.JLabel lblnombre;
    private javax.swing.JTable tblFuncs;
    private javax.swing.JTextField txtApellidos;
    private javax.swing.JTextField txtApellidosEdit;
    private javax.swing.JTextField txtCell;
    private javax.swing.JTextField txtCellEdit;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtDireccionEdit;
    private javax.swing.JTextField txtEstado;
    private javax.swing.JTextField txtEstadoEdit;
    private javax.swing.JTextField txtFecha;
    private javax.swing.JTextField txtFechaEdit;
    private javax.swing.JTextField txtFuncId;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtNombreT;
    private javax.swing.JTextField txtNombresEdit;
    private javax.swing.JTextField txtNumber;
    private javax.swing.JTextField txtNumberEdit;
    private javax.swing.JTextField txtSex;
    private javax.swing.JTextField txtSexEdit;
    private javax.swing.JTextField txtTipe;
    private javax.swing.JTextField txtTipeEdit;
    // End of variables declaration//GEN-END:variables
}
