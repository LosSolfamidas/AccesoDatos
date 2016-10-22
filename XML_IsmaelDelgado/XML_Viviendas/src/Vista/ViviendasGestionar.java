package Vista;

import Controlador.MetodosHabitantes;
import Controlador.MetodosViviendas;
import Objetos.Persona;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JOptionPane;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import Objetos.Vivienda;
import java.awt.Color;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.xmldb.api.base.XMLDBException;

public final class ViviendasGestionar extends javax.swing.JDialog implements TableModelListener {

    Persona habitanteSeleccionado;
    static Vivienda viviendaSeleccionada;
    static ArrayList<Vivienda> listaViviendas;
    static ArrayList<Persona> listaHabitantes;
    public static boolean actualizar = false;
    boolean inicio = true;
    boolean buscar = false;
    static boolean modoViv = false;
    static boolean modoHab = false;

    public ViviendasGestionar(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        cargarTablaViviendas();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelGeneral = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaPrincipal = new javax.swing.JTable();
        labelTitulo = new javax.swing.JLabel();
        btnRecargar = new javax.swing.JButton();
        btnEliminarVivienda = new javax.swing.JButton();
        labelTitulo1 = new javax.swing.JLabel();
        labelTitulo2 = new javax.swing.JLabel();
        btnInsertar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        txtCalleInsert = new javax.swing.JTextField();
        txtNumeroInsert = new javax.swing.JTextField();
        txtTipoInsert = new javax.swing.JTextField();
        txtCalleUpdate = new javax.swing.JTextField();
        txtNumeroUpdate = new javax.swing.JTextField();
        txtTipoUpdate = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btnVerHabitantes = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        btnAddHabitante = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        txtBuscarVivienda = new javax.swing.JTextField();
        btnVolver = new javax.swing.JButton();
        btnEliminarHabitante = new javax.swing.JButton();
        btnIrGestionPersonas = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle(" -- GESTIÓN DE VIVIENDAS --");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        TablaPrincipal.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        TablaPrincipal.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        TablaPrincipal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablaPrincipalMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TablaPrincipal);

        labelTitulo.setBackground(new java.awt.Color(255, 237, 190));
        labelTitulo.setFont(new java.awt.Font("DialogInput", 3, 24)); // NOI18N
        labelTitulo.setText("-- GESTIÓN DE VIVIENDAS --");

        btnRecargar.setFont(new java.awt.Font("DialogInput", 3, 12)); // NOI18N
        btnRecargar.setIcon(new javax.swing.ImageIcon("C:\\Users\\crone\\Desktop\\AccesoDatos\\CatastroNeodatis\\src\\Images\\refresh.gif")); // NOI18N
        btnRecargar.setText("Recargar Tabla");
        btnRecargar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRecargarActionPerformed(evt);
            }
        });

        btnEliminarVivienda.setFont(new java.awt.Font("DialogInput", 3, 12)); // NOI18N
        btnEliminarVivienda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Delete.png"))); // NOI18N
        btnEliminarVivienda.setText("Eliminar Vivienda");
        btnEliminarVivienda.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnEliminarVivienda.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnEliminarVivienda.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnEliminarVivienda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarViviendaActionPerformed(evt);
            }
        });

        labelTitulo1.setFont(new java.awt.Font("DialogInput", 3, 18)); // NOI18N
        labelTitulo1.setText("-- EDITAR --");

        labelTitulo2.setFont(new java.awt.Font("DialogInput", 3, 18)); // NOI18N
        labelTitulo2.setText("-- INSERTAR --");

        btnInsertar.setFont(new java.awt.Font("DialogInput", 3, 14)); // NOI18N
        btnInsertar.setText("Aceptar");
        btnInsertar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertarActionPerformed(evt);
            }
        });

        btnEditar.setFont(new java.awt.Font("DialogInput", 3, 14)); // NOI18N
        btnEditar.setText("Aceptar");
        btnEditar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnEditar.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnEditar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        txtCalleInsert.setBackground(new java.awt.Color(204, 255, 255));
        txtCalleInsert.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCalleInsertFocusLost(evt);
            }
        });
        txtCalleInsert.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCalleInsertKeyTyped(evt);
            }
        });

        txtNumeroInsert.setBackground(new java.awt.Color(204, 255, 255));
        txtNumeroInsert.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtNumeroInsertFocusLost(evt);
            }
        });
        txtNumeroInsert.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNumeroInsertKeyTyped(evt);
            }
        });

        txtTipoInsert.setBackground(new java.awt.Color(204, 255, 255));
        txtTipoInsert.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtTipoInsertFocusLost(evt);
            }
        });
        txtTipoInsert.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTipoInsertKeyTyped(evt);
            }
        });

        txtCalleUpdate.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCalleUpdateFocusLost(evt);
            }
        });
        txtCalleUpdate.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCalleUpdateKeyTyped(evt);
            }
        });

        txtNumeroUpdate.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtNumeroUpdateFocusLost(evt);
            }
        });
        txtNumeroUpdate.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNumeroUpdateKeyTyped(evt);
            }
        });

        txtTipoUpdate.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtTipoUpdateFocusLost(evt);
            }
        });
        txtTipoUpdate.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTipoUpdateKeyTyped(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Dialog", 3, 14)); // NOI18N
        jLabel1.setText("Calle:");

        jLabel2.setFont(new java.awt.Font("Dialog", 3, 14)); // NOI18N
        jLabel2.setText("Número:");

        jLabel3.setFont(new java.awt.Font("Dialog", 3, 14)); // NOI18N
        jLabel3.setText("Tipo:");

        jLabel4.setFont(new java.awt.Font("Dialog", 3, 14)); // NOI18N
        jLabel4.setText("Calle:");

        jLabel5.setFont(new java.awt.Font("Dialog", 3, 14)); // NOI18N
        jLabel5.setText("Número:");

        jLabel6.setFont(new java.awt.Font("Dialog", 3, 14)); // NOI18N
        jLabel6.setText("Tipo:");

        btnVerHabitantes.setFont(new java.awt.Font("DialogInput", 3, 12)); // NOI18N
        btnVerHabitantes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/eye.png"))); // NOI18N
        btnVerHabitantes.setText("Ver Habitantes");
        btnVerHabitantes.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnVerHabitantes.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnVerHabitantes.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnVerHabitantes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerHabitantesActionPerformed(evt);
            }
        });

        btnSalir.setFont(new java.awt.Font("DialogInput", 3, 12)); // NOI18N
        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Salir.png"))); // NOI18N
        btnSalir.setText("Salir");
        btnSalir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSalir.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        btnAddHabitante.setFont(new java.awt.Font("DialogInput", 3, 12)); // NOI18N
        btnAddHabitante.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/add.png"))); // NOI18N
        btnAddHabitante.setText("Añadir Habitante");
        btnAddHabitante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddHabitanteActionPerformed(evt);
            }
        });

        btnBuscar.setFont(new java.awt.Font("DialogInput", 3, 12)); // NOI18N
        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/lupa_buscar.png"))); // NOI18N
        btnBuscar.setText("Buscar Calle");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        txtBuscarVivienda.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtBuscarViviendaFocusLost(evt);
            }
        });
        txtBuscarVivienda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBuscarViviendaKeyTyped(evt);
            }
        });

        btnVolver.setFont(new java.awt.Font("DialogInput", 3, 14)); // NOI18N
        btnVolver.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/back.png"))); // NOI18N
        btnVolver.setText("Volver a Viviendas");
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });

        btnEliminarHabitante.setFont(new java.awt.Font("DialogInput", 3, 14)); // NOI18N
        btnEliminarHabitante.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Delete.png"))); // NOI18N
        btnEliminarHabitante.setText("Eliminar");
        btnEliminarHabitante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarHabitanteActionPerformed(evt);
            }
        });

        btnIrGestionPersonas.setFont(new java.awt.Font("Dialog", 3, 14)); // NOI18N
        btnIrGestionPersonas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/people.png"))); // NOI18N
        btnIrGestionPersonas.setText("Ir a Gestión de Personas");
        btnIrGestionPersonas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIrGestionPersonasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelGeneralLayout = new javax.swing.GroupLayout(panelGeneral);
        panelGeneral.setLayout(panelGeneralLayout);
        panelGeneralLayout.setHorizontalGroup(
            panelGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelGeneralLayout.createSequentialGroup()
                .addGroup(panelGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelGeneralLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(labelTitulo2))
                    .addGroup(panelGeneralLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panelGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnInsertar, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelGeneralLayout.createSequentialGroup()
                                    .addComponent(jLabel6)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtTipoInsert))
                                .addGroup(panelGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panelGeneralLayout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtCalleInsert, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(panelGeneralLayout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtNumeroInsert, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelGeneralLayout.createSequentialGroup()
                        .addGroup(panelGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnAddHabitante, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnVerHabitantes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(panelGeneralLayout.createSequentialGroup()
                                .addComponent(btnVolver)
                                .addGap(18, 18, 18)
                                .addComponent(btnSalir))
                            .addGroup(panelGeneralLayout.createSequentialGroup()
                                .addComponent(txtBuscarVivienda, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelGeneralLayout.createSequentialGroup()
                        .addComponent(btnRecargar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnEliminarHabitante)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEliminarVivienda))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 477, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(panelGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelGeneralLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(labelTitulo1))
                    .addGroup(panelGeneralLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelGeneralLayout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtCalleUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelGeneralLayout.createSequentialGroup()
                                    .addComponent(jLabel3)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(txtTipoUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(panelGeneralLayout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(txtNumeroUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(btnEditar, javax.swing.GroupLayout.Alignment.TRAILING)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelGeneralLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnIrGestionPersonas)
                .addGap(18, 18, 18)
                .addComponent(labelTitulo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelGeneralLayout.setVerticalGroup(
            panelGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelGeneralLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(panelGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelTitulo)
                    .addComponent(btnIrGestionPersonas))
                .addGap(12, 12, 12)
                .addGroup(panelGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelGeneralLayout.createSequentialGroup()
                        .addComponent(labelTitulo1)
                        .addGap(19, 19, 19)
                        .addGroup(panelGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCalleUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(panelGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtNumeroUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(panelGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTipoUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addComponent(btnEditar))
                    .addGroup(panelGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelGeneralLayout.createSequentialGroup()
                            .addComponent(labelTitulo2)
                            .addGap(18, 18, 18)
                            .addGroup(panelGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel4)
                                .addComponent(txtCalleInsert, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addGroup(panelGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel5)
                                .addComponent(txtNumeroInsert, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(20, 20, 20)
                            .addGroup(panelGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtTipoInsert, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel6))
                            .addGap(18, 18, 18)
                            .addComponent(btnInsertar))
                        .addGroup(panelGeneralLayout.createSequentialGroup()
                            .addGroup(panelGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(btnEliminarVivienda)
                                .addGroup(panelGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btnRecargar)
                                    .addComponent(btnEliminarHabitante)))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(panelGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btnAddHabitante)
                                .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtBuscarVivienda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(panelGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(btnVerHabitantes)
                                .addComponent(btnSalir)
                                .addComponent(btnVolver)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelGeneral, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(13, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(panelGeneral, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public void cargarTablaViviendas() {
        txtCalleUpdate.setText("");
        txtNumeroUpdate.setText("");
        txtTipoUpdate.setText("");
        txtCalleInsert.setText("");
        txtNumeroInsert.setText("");
        txtTipoInsert.setText("");
        txtBuscarVivienda.setText("");

        labelTitulo1.setVisible(true);
        labelTitulo2.setVisible(true);
        jLabel1.setVisible(true);
        jLabel2.setVisible(true);
        jLabel3.setVisible(true);
        jLabel4.setVisible(true);
        jLabel5.setVisible(true);
        jLabel6.setVisible(true);
        btnAddHabitante.setVisible(true);
        btnEditar.setVisible(true);
        btnEliminarVivienda.setVisible(true);
        btnInsertar.setVisible(true);
        btnVerHabitantes.setVisible(true);
        btnBuscar.setVisible(true);
        txtBuscarVivienda.setVisible(true);
        txtCalleInsert.setVisible(true);
        txtCalleUpdate.setVisible(true);
        txtNumeroInsert.setVisible(true);
        txtNumeroUpdate.setVisible(true);
        txtTipoInsert.setVisible(true);
        txtTipoUpdate.setVisible(true);
        btnRecargar.setVisible(true);

        btnVolver.setVisible(false);
        btnEliminarHabitante.setVisible(false);

        if (!buscar) {
            listaViviendas = MetodosViviendas.viviendasSELECT();
        }
        MiModelodeTablaViviendas miTablaViviendas = new MiModelodeTablaViviendas();

        String fila[] = new String[4];
        Iterator<Vivienda> i = listaViviendas.iterator();
        while (i.hasNext()) {
            Vivienda s = i.next();
            fila[0] = String.valueOf(s.getID_Vivienda());
            fila[1] = s.getCalle();
            fila[2] = String.valueOf(s.getNumero());
            fila[3] = s.getTipo();
            miTablaViviendas.addRow(fila);
        }

        // Asigno los valores a la tabla y así la inicializa sólo con los datos leídos
        TablaPrincipal.setModel(miTablaViviendas);

        //Añade un listener para eventos sobre la tabla
        TablaPrincipal.getModel().addTableModelListener(this);

        modoHab = false;
        buscar = false;
        modoViv = true;
    }

    public void cargarTablaHabitantes() {

        labelTitulo1.setVisible(false);
        labelTitulo2.setVisible(false);
        jLabel1.setVisible(false);
        jLabel2.setVisible(false);
        jLabel3.setVisible(false);
        jLabel4.setVisible(false);
        jLabel5.setVisible(false);
        jLabel6.setVisible(false);
        btnAddHabitante.setVisible(false);
        btnEditar.setVisible(false);
        btnEliminarVivienda.setVisible(false);
        btnInsertar.setVisible(false);
        btnVerHabitantes.setVisible(false);
        btnBuscar.setVisible(false);
        txtBuscarVivienda.setVisible(false);
        txtCalleInsert.setVisible(false);
        txtCalleUpdate.setVisible(false);
        txtNumeroInsert.setVisible(false);
        txtNumeroUpdate.setVisible(false);
        txtTipoInsert.setVisible(false);
        txtTipoUpdate.setVisible(false);
        btnRecargar.setVisible(false);

        btnVolver.setVisible(true);
        btnEliminarHabitante.setVisible(true);

        MiModelodeTablaHabitantes miTablaHabitantes = new MiModelodeTablaHabitantes();
        listaHabitantes = viviendaSeleccionada.getHabitantes();

        String fila[] = new String[5];
        Iterator<Persona> habitantes = listaHabitantes.iterator();
        while (habitantes.hasNext()) {
            Persona habitante = habitantes.next();
            fila[0] = String.valueOf(habitante.getID_Persona());
            fila[1] = habitante.getNombre();
            fila[2] = habitante.getApellidos();
            fila[3] = String.valueOf(habitante.getAnyoNacimiento());
            fila[4] = habitante.getNumTelefono();
            miTablaHabitantes.addRow(fila);
        }

        // Asigno los valores a la tabla y así la inicializa sólo con los datos leídos
        TablaPrincipal.setModel(miTablaHabitantes);
        //Añade un listener para eventos sobre la tabla
        TablaPrincipal.getModel().addTableModelListener(this);
        modoViv = false;
        buscar = false;
        modoHab = true;
    }

    public class MiModelodeTablaViviendas extends DefaultTableModel {

        @Override
        public boolean isCellEditable(int fila, int columna) {
            return false;
        }

        //Extiendo la funcionalidad del DefaultTableModel para indicar los tipos de cada celda
        @Override
        public Class getColumnClass(int columna) {
            return String.class;
        }

        //Sobre-escribo los nombres de las columnas
        String[] nombresColumnasV = {"ID", "Calle", "Número", "Tipo"};
        String nombresColumnas[] = {"ID", "Nombre", "Apellidos", "Año Nacimiento", "Teléfono"};

        @Override
        public String getColumnName(int index) {
            return nombresColumnasV[index];
        }

        @Override
        public int getColumnCount() {
            return nombresColumnasV.length;
        }

    }

    public class MiModelodeTablaHabitantes extends DefaultTableModel {

        @Override
        public boolean isCellEditable(int fila, int columna) {
            return false;
        }

        //Extiendo la funcionalidad del DefaultTableModel para indicar los tipos de cada celda
        @Override
        public Class getColumnClass(int columna) {
            return String.class;
        }

        //Sobre-escribo los nombres de las columnas
        String nombresColumnas[] = {"ID", "Nombre", "Apellidos", "Año Nacimiento", "Teléfono"};

        @Override
        public String getColumnName(int index) {
            return nombresColumnas[index];
        }

        @Override
        public int getColumnCount() {
            return nombresColumnas.length;
        }

    }


    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnEliminarViviendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarViviendaActionPerformed
        int index = TablaPrincipal.getSelectedRow();
        boolean registrar = false;

        if (index != -1) {
            int respuesta = JOptionPane.showConfirmDialog(null, "Desea Borrar", "Borrar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (respuesta == JOptionPane.YES_OPTION) {
                
                try {
                    if (MetodosHabitantes.registrarTodasPersonasUPDATE(viviendaSeleccionada.getHabitantes(), registrar)) {
                        if (MetodosViviendas.viviendaDELETE(viviendaSeleccionada)) {
                            ViviendasGestionar.actualizar = true;
                            JOptionPane.showMessageDialog(this, "Se ha eliminado Correctamente.");
                        } else {
                            JOptionPane.showMessageDialog(this, "Error al Borrar.");
                        }
                    }
                } catch (XMLDBException ex) {
                    Logger.getLogger(ViviendasGestionar.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione una Vivienda.");
        }
    }//GEN-LAST:event_btnEliminarViviendaActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        if (TablaPrincipal.getSelectedRow() != -1) {
            if (validarDatosUpdate() == true) {

                String Calle = txtCalleUpdate.getText().toUpperCase();
                String Numero = txtNumeroUpdate.getText().toUpperCase();
                String Tipo = txtTipoUpdate.getText().toUpperCase();

                int respuesta = JOptionPane.showConfirmDialog(null, "Modificar Vivienda", "Modificar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (respuesta == JOptionPane.YES_OPTION) {
                    try {
                        BaseDatosUpdate(Calle, Numero, Tipo);
                    } catch (XMLDBException ex) {
                        Logger.getLogger(ViviendasGestionar.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione Vivienda.");
        }


    }//GEN-LAST:event_btnEditarActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        if (actualizar == true) {
            cargarTablaViviendas();
            TablaPrincipal.repaint();
            actualizar = false;
        }

        if (inicio == true) {
            inicio = false;
            if (listaViviendas.isEmpty()) {
                JOptionPane.showMessageDialog(this, "No existen Viviendas", "Información", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }//GEN-LAST:event_formWindowActivated

    private void btnVerHabitantesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerHabitantesActionPerformed
        if (TablaPrincipal.getSelectedRow() != -1) {

            cargarTablaHabitantes();

        } else {
            JOptionPane.showMessageDialog(this, "Seleccione Vivienda.");
        }
    }//GEN-LAST:event_btnVerHabitantesActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        String Calle = txtBuscarVivienda.getText().toUpperCase();

        if (Calle.isEmpty() || Calle.equalsIgnoreCase("")) {
            JOptionPane.showMessageDialog(this, "Introduzca Calle", "Error al Buscar", JOptionPane.INFORMATION_MESSAGE);
        } else {
            listaViviendas = MetodosViviendas.viviendaBUSCAR(Calle);
            buscar = true;
            cargarTablaViviendas();
            listaViviendas = MetodosViviendas.viviendasSELECT();
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnRecargarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRecargarActionPerformed

        cargarTablaViviendas();
    }//GEN-LAST:event_btnRecargarActionPerformed

    private void btnInsertarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertarActionPerformed

        if (validarDatosInsert() == true) {
            String Calle = txtCalleInsert.getText().toUpperCase();
            String Numero = txtNumeroInsert.getText().toUpperCase();
            String Tipo = txtTipoInsert.getText().toUpperCase();
            ArrayList<Persona> habitantes = new ArrayList<>();

            int respuesta = JOptionPane.showConfirmDialog(null, "¿Crear Vivienda?", "Nueva alta", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (respuesta == JOptionPane.YES_OPTION) {
                BaseDatosINSERT(Calle, Numero, Tipo, habitantes);
            }
        }
        dispose();
        new ViviendasGestionar(new javax.swing.JFrame(), true).setVisible(true);


    }//GEN-LAST:event_btnInsertarActionPerformed

    private void TablaPrincipalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaPrincipalMouseClicked
        mostrarCamposUpdate();//Al clickar sobre una fila de la tabla(objeto) muestro sus datos en los TextFields de edición.
    }//GEN-LAST:event_TablaPrincipalMouseClicked

    private void txtCalleInsertKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCalleInsertKeyTyped
        int limitador = 25;
        char ch = evt.getKeyChar();
        if ((Character.isDigit(ch)) || (txtCalleInsert.getText().length() >= limitador)) {
            evt.consume();
        }
    }//GEN-LAST:event_txtCalleInsertKeyTyped

    private void txtNumeroInsertKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNumeroInsertKeyTyped
        int limitador = 5;
        char ch = evt.getKeyChar();
        if ((!Character.isDigit(ch) || (txtNumeroInsert.getText().length() >= limitador))) {
            evt.consume();
        }
    }//GEN-LAST:event_txtNumeroInsertKeyTyped

    private void txtTipoInsertKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTipoInsertKeyTyped
        int limitador = 15;
        char ch = evt.getKeyChar();
        if ((Character.isDigit(ch)) || (txtTipoInsert.getText().length() >= limitador)) {
            evt.consume();
        }
    }//GEN-LAST:event_txtTipoInsertKeyTyped

    private void txtCalleUpdateKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCalleUpdateKeyTyped
        int limitador = 25;
        char ch = evt.getKeyChar();
        if ((Character.isDigit(ch)) || (txtCalleUpdate.getText().length() >= limitador)) {
            evt.consume();
        }
    }//GEN-LAST:event_txtCalleUpdateKeyTyped

    private void txtNumeroUpdateKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNumeroUpdateKeyTyped
        int limitador = 5;
        char ch = evt.getKeyChar();
        if ((!Character.isDigit(ch) || (txtNumeroUpdate.getText().length() >= limitador))) {
            evt.consume();
        }
    }//GEN-LAST:event_txtNumeroUpdateKeyTyped

    private void txtTipoUpdateKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTipoUpdateKeyTyped
        int limitador = 15;
        char ch = evt.getKeyChar();
        if ((Character.isDigit(ch)) || (txtTipoUpdate.getText().length() >= limitador)) {
            evt.consume();
        }
    }//GEN-LAST:event_txtTipoUpdateKeyTyped

    private void txtBuscarViviendaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarViviendaKeyTyped
        int limitador = 25;
        char ch = evt.getKeyChar();
        if ((Character.isDigit(ch)) || (txtBuscarVivienda.getText().length() >= limitador)) {
            evt.consume();
        }
    }//GEN-LAST:event_txtBuscarViviendaKeyTyped

    private void txtCalleInsertFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCalleInsertFocusLost
        if ((txtCalleInsert.getText().length() > 25) || (txtCalleInsert.getText().length() == 0)) {
            txtCalleInsert.setBackground(Color.LIGHT_GRAY);
        } else {
            txtCalleInsert.setBackground(Color.WHITE);
        }
    }//GEN-LAST:event_txtCalleInsertFocusLost

    private void txtNumeroInsertFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNumeroInsertFocusLost
        if ((txtNumeroInsert.getText().length() > 5) || (txtNumeroInsert.getText().length() == 0)) {
            txtNumeroInsert.setBackground(Color.LIGHT_GRAY);
        } else {
            txtNumeroInsert.setBackground(Color.WHITE);
        }
    }//GEN-LAST:event_txtNumeroInsertFocusLost

    private void txtTipoInsertFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTipoInsertFocusLost
        if ((txtTipoInsert.getText().length() > 15) || (txtTipoInsert.getText().length() == 0)) {
            txtTipoInsert.setBackground(Color.LIGHT_GRAY);
        } else {
            txtTipoInsert.setBackground(Color.WHITE);
        }
    }//GEN-LAST:event_txtTipoInsertFocusLost

    private void txtCalleUpdateFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCalleUpdateFocusLost
        if ((txtCalleUpdate.getText().length() > 25) || (txtCalleUpdate.getText().length() == 0)) {
            txtCalleUpdate.setBackground(Color.LIGHT_GRAY);
        } else {
            txtCalleUpdate.setBackground(Color.WHITE);
        }
    }//GEN-LAST:event_txtCalleUpdateFocusLost

    private void txtNumeroUpdateFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNumeroUpdateFocusLost
        if ((txtNumeroUpdate.getText().length() > 5) || (txtNumeroUpdate.getText().length() == 0)) {
            txtNumeroUpdate.setBackground(Color.LIGHT_GRAY);
        } else {
            txtNumeroUpdate.setBackground(Color.WHITE);
        }
    }//GEN-LAST:event_txtNumeroUpdateFocusLost

    private void txtTipoUpdateFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTipoUpdateFocusLost
        if ((txtTipoUpdate.getText().length() > 15) || (txtTipoUpdate.getText().length() == 0)) {
            txtTipoUpdate.setBackground(Color.LIGHT_GRAY);
        } else {
            txtTipoUpdate.setBackground(Color.WHITE);
        }
    }//GEN-LAST:event_txtTipoUpdateFocusLost

    private void txtBuscarViviendaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtBuscarViviendaFocusLost
        if ((txtBuscarVivienda.getText().length() > 25) || (txtBuscarVivienda.getText().length() == 0)) {
            txtBuscarVivienda.setBackground(Color.LIGHT_GRAY);
        } else {
            txtBuscarVivienda.setBackground(Color.WHITE);
        }
    }//GEN-LAST:event_txtBuscarViviendaFocusLost

    private void btnAddHabitanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddHabitanteActionPerformed

        if (TablaPrincipal.getSelectedRow() != -1) {
            new RegistrarPersonas(new javax.swing.JFrame(), true).setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione Vivienda.");
        }
        cargarTablaViviendas();
    }//GEN-LAST:event_btnAddHabitanteActionPerformed

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        cargarTablaViviendas();
        TablaPrincipal.repaint();
    }//GEN-LAST:event_btnVolverActionPerformed

    private void btnEliminarHabitanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarHabitanteActionPerformed

        int index = TablaPrincipal.getSelectedRow();
        boolean registrar = false;
        modoViv = false;
        modoHab = true;

        if (index != -1) {
            habitanteSeleccionado = listaHabitantes.get(TablaPrincipal.getSelectedRow());
            int respuesta = JOptionPane.showConfirmDialog(null, "¿Desea eliminar esta persona de la Vivienda?", "Borrar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (respuesta == JOptionPane.YES_OPTION) {

                try {
                    if (MetodosHabitantes.registrarPersonaUPDATE(habitanteSeleccionado, registrar)) {

                        if (MetodosHabitantes.personaEnViviendaDELETE(habitanteSeleccionado, viviendaSeleccionada)) {
                            JOptionPane.showMessageDialog(this, "Se ha eliminado Correctamente.");
                            cargarTablaViviendas();
                        } else {
                            JOptionPane.showMessageDialog(this, "Error al Borrar la persona de la vivienda.");
                        }
                    } else {
                        JOptionPane.showMessageDialog(this, "Error al cambiar el estado de la persona.");
                    }
                } catch (XMLDBException ex) {
                    Logger.getLogger(ViviendasGestionar.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Debes elegir una Persona.");
        }

    }//GEN-LAST:event_btnEliminarHabitanteActionPerformed

    private void btnIrGestionPersonasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIrGestionPersonasActionPerformed
        dispose();
        new PersonaGestionar(new javax.swing.JFrame(), true).setVisible(true);
    }//GEN-LAST:event_btnIrGestionPersonasActionPerformed

    public boolean validarDatosInsert() {
        boolean correcto = false;

        if (txtCalleInsert.getBackground() == Color.WHITE && txtNumeroInsert.getBackground() == Color.WHITE && txtTipoInsert.getBackground() == Color.WHITE) {
            correcto = true;
        }
        if (correcto == false) {
            JOptionPane.showMessageDialog(this, "Hay campos incorrectos", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return correcto;
    }

    public boolean validarDatosUpdate() {
        boolean correcto = false;

        if (txtCalleUpdate.getBackground() != (Color.LIGHT_GRAY) && txtNumeroUpdate.getBackground() != (Color.LIGHT_GRAY) && txtTipoUpdate.getBackground() != (Color.LIGHT_GRAY)) {
            correcto = true;
        }
        if (correcto == false) {
            JOptionPane.showMessageDialog(this, "Hay campos incorrectos!!!!!", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return correcto;
    }

    //Metodo para insertar el nuevo almacen en la base de datos
    public void BaseDatosINSERT(String Calle, String Numero, String Tipo, ArrayList<Persona> habitantes) {

        //Autoincremetamos la ID para que no se repitan
        int IDVivienda = Controlador.MetodosViviendas.nuevaID_Vivienda();

        Vivienda viviendaINSERT = new Vivienda(IDVivienda, Calle, Numero, Tipo, habitantes);

        if (Controlador.MetodosViviendas.viviendaINSERT(viviendaINSERT)) {
            JOptionPane.showMessageDialog(this, "Se ha insertado correctamente.");
        } else {
            JOptionPane.showMessageDialog(this, "Error al guardar.");
        }
        cargarTablaViviendas();
    }

    public void BaseDatosUpdate(String calle, String numero, String Tipo) throws XMLDBException {

        Vivienda viviendaUpdate = new Vivienda(viviendaSeleccionada.getID_Vivienda(), calle, numero, Tipo, viviendaSeleccionada.getHabitantes());

        if (Controlador.MetodosViviendas.viviendaUPDATE(viviendaUpdate)) {
            //Mensaje de confirmación
            JOptionPane.showMessageDialog(this, "Actualizado Correctamente.");
            ViviendasGestionar.actualizar = true;
            cargarTablaViviendas();
        } else {
            JOptionPane.showMessageDialog(this, "Error al editar", "ERROR", JOptionPane.ERROR_MESSAGE);
        }

    }

    public void mostrarCamposUpdate() {

        if (modoViv) {
            viviendaSeleccionada = listaViviendas.get(TablaPrincipal.getSelectedRow());
            System.out.println("viviendaSeleccionada: " + viviendaSeleccionada.getCalle());

            txtCalleUpdate.setText(viviendaSeleccionada.getCalle());
            txtNumeroUpdate.setText(viviendaSeleccionada.getNumero());
            txtTipoUpdate.setText(viviendaSeleccionada.getTipo());
        } else if (modoHab) {
            habitanteSeleccionado = listaHabitantes.get(TablaPrincipal.getSelectedRow());
            System.out.println("habitanteSeleccionado: " + habitanteSeleccionado.getNombre());
        }

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TablaPrincipal;
    private javax.swing.JButton btnAddHabitante;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminarHabitante;
    private javax.swing.JButton btnEliminarVivienda;
    private javax.swing.JButton btnInsertar;
    private javax.swing.JButton btnIrGestionPersonas;
    private javax.swing.JButton btnRecargar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JButton btnVerHabitantes;
    private javax.swing.JButton btnVolver;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelTitulo;
    private javax.swing.JLabel labelTitulo1;
    private javax.swing.JLabel labelTitulo2;
    private javax.swing.JPanel panelGeneral;
    private javax.swing.JTextField txtBuscarVivienda;
    private javax.swing.JTextField txtCalleInsert;
    private javax.swing.JTextField txtCalleUpdate;
    private javax.swing.JTextField txtNumeroInsert;
    private javax.swing.JTextField txtNumeroUpdate;
    private javax.swing.JTextField txtTipoInsert;
    private javax.swing.JTextField txtTipoUpdate;
    // End of variables declaration//GEN-END:variables

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if (!"Windows".equals(info.getName())) {
                } else {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViviendasGestionar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>


        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(() -> {
            ViviendasGestionar dialog = new ViviendasGestionar(new javax.swing.JFrame(), true);
            dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                @Override
                public void windowClosing(java.awt.event.WindowEvent e) {
                    System.exit(0);
                }
            });
            dialog.setVisible(true);
        });
    }

    @Override
    public void tableChanged(TableModelEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
