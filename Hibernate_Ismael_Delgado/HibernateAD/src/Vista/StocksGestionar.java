package Vista;

import Controlador.MetodosCoches;
import static Controlador.MetodosCoches.LinkedCoches;
import Controlador.MetodosStocks;
import static Controlador.MetodosStocks.LinkedConcesionarios;
import static Controlador.MetodosStocks.LinkedStocks;
import Modelo.Concesionarios;
import java.util.Iterator;
import javax.swing.JOptionPane;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;
import java.util.ArrayList;
import Modelo.Stocks;
import Modelo.StocksId;
import java.util.logging.Level;
import java.util.logging.Logger;
import static Controlador.MetodosStocks.LinkedStocksId;
import Modelo.Coches;
import static Controlador.MetodosStocks.buscar;

public final class StocksGestionar extends javax.swing.JDialog implements TableModelListener {

    String CIFC, CODCOCHE;//Para los spinners
    static StocksId stockSelecEnTabla;
    boolean inicio = true;
    

    public StocksGestionar(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        cargarTablaStocks();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelGeneral = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaPrincipal = new javax.swing.JTable();
        labelTitulo = new javax.swing.JLabel();
        btnRecargar = new javax.swing.JButton();
        btnEliminarStock = new javax.swing.JButton();
        labelTitulo1 = new javax.swing.JLabel();
        labelTitulo2 = new javax.swing.JLabel();
        btnInsertar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        txtNomConInsert = new javax.swing.JTextField();
        txtNomConUpdate = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btnSalir = new javax.swing.JButton();
        btnBuscarConcesionario = new javax.swing.JButton();
        txtBuscarConcesionario = new javax.swing.JTextField();
        btnIrGestionConcesionarios = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        txtNomCocheInsert = new javax.swing.JTextField();
        JLabelS = new javax.swing.JLabel();
        txtStockInsert = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtNomCocheUpdate = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtStockUpdate = new javax.swing.JTextField();
        spnCIFC_Insert = new javax.swing.JComboBox<>();
        spnID_CocheInsert = new javax.swing.JComboBox<>();
        txtCifcUpdate = new javax.swing.JTextField();
        txtIdCocheUpdate = new javax.swing.JTextField();
        txtBuscarCoche = new javax.swing.JTextField();
        btnBuscarCoche = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle(" -- GESTIÓN DE CONCESIONARIOS --");
        setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
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
        labelTitulo.setText("- STOCKS -");

        btnRecargar.setFont(new java.awt.Font("DialogInput", 3, 12)); // NOI18N
        btnRecargar.setIcon(new javax.swing.ImageIcon("C:\\Users\\crone\\Desktop\\AccesoDatos\\CatastroNeodatis\\src\\Images\\refresh.gif")); // NOI18N
        btnRecargar.setText("Recargar Tabla");
        btnRecargar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRecargarActionPerformed(evt);
            }
        });

        btnEliminarStock.setFont(new java.awt.Font("DialogInput", 3, 12)); // NOI18N
        btnEliminarStock.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Delete.png"))); // NOI18N
        btnEliminarStock.setText("Eliminar");
        btnEliminarStock.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnEliminarStock.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnEliminarStock.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnEliminarStock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarStockActionPerformed(evt);
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

        txtNomConInsert.setEditable(false);
        txtNomConInsert.setBackground(new java.awt.Color(204, 255, 255));

        txtNomConUpdate.setEditable(false);

        jLabel1.setFont(new java.awt.Font("Dialog", 3, 14)); // NOI18N
        jLabel1.setText("CIFC:");

        jLabel2.setFont(new java.awt.Font("Dialog", 3, 14)); // NOI18N
        jLabel2.setText("Nom Con:");

        jLabel3.setFont(new java.awt.Font("Dialog", 3, 14)); // NOI18N
        jLabel3.setText("ID Coche:");

        jLabel4.setFont(new java.awt.Font("Dialog", 3, 14)); // NOI18N
        jLabel4.setText("CIFC:");

        jLabel5.setFont(new java.awt.Font("Dialog", 3, 14)); // NOI18N
        jLabel5.setText("Nom Con:");

        jLabel6.setFont(new java.awt.Font("Dialog", 3, 14)); // NOI18N
        jLabel6.setText("ID Coche:");

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

        btnBuscarConcesionario.setFont(new java.awt.Font("DialogInput", 3, 12)); // NOI18N
        btnBuscarConcesionario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/lupa_buscar.png"))); // NOI18N
        btnBuscarConcesionario.setText("Buscar Nombre de Concesionario");
        btnBuscarConcesionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarConcesionarioActionPerformed(evt);
            }
        });

        txtBuscarConcesionario.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtBuscarConcesionarioFocusLost(evt);
            }
        });
        txtBuscarConcesionario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBuscarConcesionarioKeyTyped(evt);
            }
        });

        btnIrGestionConcesionarios.setFont(new java.awt.Font("Dialog", 3, 14)); // NOI18N
        btnIrGestionConcesionarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/coche.gif"))); // NOI18N
        btnIrGestionConcesionarios.setText("Ir a Gestión de Coches");
        btnIrGestionConcesionarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIrGestionConcesionariosActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Dialog", 3, 14)); // NOI18N
        jLabel7.setText("Nom Coche:");

        txtNomCocheInsert.setEditable(false);
        txtNomCocheInsert.setBackground(new java.awt.Color(204, 255, 255));

        JLabelS.setFont(new java.awt.Font("Dialog", 3, 14)); // NOI18N
        JLabelS.setText("Stock:");

        txtStockInsert.setBackground(new java.awt.Color(204, 255, 255));
        txtStockInsert.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtStockInsertFocusLost(evt);
            }
        });
        txtStockInsert.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtStockInsertKeyTyped(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Dialog", 3, 14)); // NOI18N
        jLabel9.setText("Nom Coche:");

        txtNomCocheUpdate.setEditable(false);

        jLabel10.setFont(new java.awt.Font("Dialog", 3, 14)); // NOI18N
        jLabel10.setText("Stock:");

        txtStockUpdate.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtStockUpdateFocusLost(evt);
            }
        });
        txtStockUpdate.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtStockUpdateKeyTyped(evt);
            }
        });

        spnCIFC_Insert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                spnCIFC_InsertActionPerformed(evt);
            }
        });

        spnID_CocheInsert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                spnID_CocheInsertActionPerformed(evt);
            }
        });

        txtCifcUpdate.setEditable(false);

        txtIdCocheUpdate.setEditable(false);

        btnBuscarCoche.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/lupa_buscar.png"))); // NOI18N
        btnBuscarCoche.setText("Buscar Nombre de Coche");
        btnBuscarCoche.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarCocheActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelGeneralLayout = new javax.swing.GroupLayout(panelGeneral);
        panelGeneral.setLayout(panelGeneralLayout);
        panelGeneralLayout.setHorizontalGroup(
            panelGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelGeneralLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnIrGestionConcesionarios, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(129, 129, 129)
                .addComponent(labelTitulo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(panelGeneralLayout.createSequentialGroup()
                .addGroup(panelGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelGeneralLayout.createSequentialGroup()
                        .addGroup(panelGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelGeneralLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(JLabelS))
                            .addGroup(panelGeneralLayout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(labelTitulo2)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(panelGeneralLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panelGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelGeneralLayout.createSequentialGroup()
                                .addGroup(panelGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel4))
                                .addGap(10, 10, 10)
                                .addGroup(panelGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtNomCocheInsert)
                                    .addComponent(txtNomConInsert)
                                    .addGroup(panelGeneralLayout.createSequentialGroup()
                                        .addGroup(panelGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtStockInsert, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(spnCIFC_Insert, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(spnID_CocheInsert, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(0, 44, Short.MAX_VALUE))))
                            .addGroup(panelGeneralLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btnInsertar, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(btnEliminarStock)
                        .addGroup(panelGeneralLayout.createSequentialGroup()
                            .addGroup(panelGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(txtBuscarConcesionario, javax.swing.GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE)
                                .addComponent(txtBuscarCoche))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(panelGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(btnBuscarConcesionario, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnBuscarCoche, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(61, 61, 61)
                            .addComponent(btnSalir))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 537, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnRecargar))
                .addGroup(panelGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelGeneralLayout.createSequentialGroup()
                        .addGap(111, 111, 111)
                        .addComponent(btnEditar)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(panelGeneralLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(panelGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelGeneralLayout.createSequentialGroup()
                                .addGroup(panelGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel10))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panelGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panelGeneralLayout.createSequentialGroup()
                                        .addComponent(txtNomCocheUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addContainerGap(20, Short.MAX_VALUE))
                                    .addGroup(panelGeneralLayout.createSequentialGroup()
                                        .addComponent(txtStockUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))))
                            .addGroup(panelGeneralLayout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(txtIdCocheUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(panelGeneralLayout.createSequentialGroup()
                                .addGroup(panelGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2))
                                .addGap(18, 18, 18)
                                .addGroup(panelGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtNomConUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtCifcUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap())))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelGeneralLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(labelTitulo1)
                        .addGap(39, 39, 39))))
        );
        panelGeneralLayout.setVerticalGroup(
            panelGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelGeneralLayout.createSequentialGroup()
                .addGroup(panelGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelGeneralLayout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(btnIrGestionConcesionarios))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelGeneralLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(labelTitulo)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelGeneralLayout.createSequentialGroup()
                        .addComponent(labelTitulo2)
                        .addGap(27, 27, 27)
                        .addGroup(panelGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(spnCIFC_Insert, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtNomConInsert, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txtNomCocheInsert, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(JLabelS)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(panelGeneralLayout.createSequentialGroup()
                        .addGroup(panelGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelGeneralLayout.createSequentialGroup()
                                .addComponent(labelTitulo1)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelGeneralLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(panelGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnRecargar, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(btnEliminarStock, javax.swing.GroupLayout.Alignment.TRAILING))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelGeneralLayout.createSequentialGroup()
                                .addGroup(panelGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel1)
                                    .addComponent(txtCifcUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(panelGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel2)
                                    .addComponent(txtNomConUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(panelGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3)
                                    .addComponent(txtIdCocheUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(panelGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel9)
                                    .addComponent(txtNomCocheUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(panelGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel10)
                                    .addComponent(txtStockUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(20, 20, 20)
                                .addComponent(btnEditar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panelGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtBuscarConcesionario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnBuscarConcesionario, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panelGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtBuscarCoche, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnBuscarCoche, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(panelGeneralLayout.createSequentialGroup()
                                .addGroup(panelGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelGeneralLayout.createSequentialGroup()
                                        .addGap(64, 64, 64)
                                        .addComponent(spnID_CocheInsert, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(44, 44, 44)
                                        .addComponent(txtStockInsert, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnInsertar))
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnSalir)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelGeneral, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(panelGeneral, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public void cargarTablaStocks() {

        txtNomCocheInsert.setText("");
        txtNomConInsert.setText("");
        txtStockInsert.setText("");
        txtBuscarConcesionario.setText("");
        txtCifcUpdate.setText("");
        txtNomConUpdate.setText("");
        txtIdCocheUpdate.setText("");
        txtNomCocheUpdate.setText("");
        txtStockUpdate.setText("");

        MetodosStocks.concesionariosSELECT();
        cargarSpinnerConcesionarios();

        MetodosCoches.cochesSELECT();
        cargarSpinnerCoches();

        CIFC = spnCIFC_Insert.getSelectedItem().toString();
        CODCOCHE = spnID_CocheInsert.getSelectedItem().toString();

        cargarNombreConcesionario();
        cargarNombreCoche();
        if (!buscar) {
            MetodosStocks.stockSELECT();

        }

        MiModelodeTablaStocks miTablaStocks = new MiModelodeTablaStocks();

        String fila[] = new String[5];
        Iterator<StocksId> i = LinkedStocksId.iterator();
        while (i.hasNext()) {
            StocksId s = i.next();
            fila[0] = String.valueOf(s.getIdCocesionario());
            fila[1] = s.getNombreConcesionario();
            fila[2] = String.valueOf(s.getCodcoche());
            fila[3] = s.getNombreCoche();
            fila[4] = String.valueOf(s.getStock());
            miTablaStocks.addRow(fila);
            
            

        }

        // Asigno los valores a la tabla y así la inicializa sólo con los datos leídos
        TablaPrincipal.setModel(miTablaStocks);
        //Añade un listener para eventos sobre la tabla
        TablaPrincipal.getModel().addTableModelListener(this);
        System.out.println("\n\n\n\n\n buscar = "+buscar+"\n\n\n\n\n");
        buscar = false;
    }

    public void cargarSpinnerConcesionarios() {
        //MetodosStocks.concesionariosSELECT();
        spnCIFC_Insert.removeAllItems();
        ArrayList<String> CIFCes = new ArrayList<>();
        //Añadimos los CIFCes de los Concesionarios al spinner

        Iterator<Concesionarios> iterador = LinkedConcesionarios.iterator();
        while (iterador.hasNext()) {
            Concesionarios aux = (Concesionarios) iterador.next();
            if (!CIFCes.contains(aux.getCifc())) {
                CIFCes.add(aux.getCifc());
                spnCIFC_Insert.addItem(aux.getCifc());
            }
        }
    }

    public void cargarSpinnerCoches() {
        //MetodosCoches.cochesSELECT();
        spnID_CocheInsert.removeAllItems();

        //Añadimos los Ides de los Coches al spinner
        ArrayList<String> ides = new ArrayList<>();
        Iterator<Coches> iterador = LinkedCoches.iterator();
        while (iterador.hasNext()) {
            Coches aux = (Coches) iterador.next();
            if (!ides.contains(aux.getCodcoche())) {
                ides.add(aux.getCodcoche());
                spnID_CocheInsert.addItem(aux.getCodcoche());
            }

        }

        //cargarNombreCoche();
    }

    public void cargarNombreConcesionario() {
        String nombreConce;
        txtNomConInsert.setText("");
        Iterator<Concesionarios> iterador = LinkedConcesionarios.iterator();
        while (iterador.hasNext()) {
            Concesionarios aux = (Concesionarios) iterador.next();
            if (aux.getCifc().equals(CIFC)) {
                nombreConce = aux.getNombre();
                txtNomConInsert.setText(nombreConce);
            }
        }

    }

    public void cargarNombreCoche() {
        String nomCoche;
        txtNomCocheInsert.setText("");
        Iterator<Coches> iterador = LinkedCoches.iterator();
        while (iterador.hasNext()) {
            Coches aux = (Coches) iterador.next();
            if (aux.getCodcoche().equals(CODCOCHE)) {
                nomCoche = aux.getNombre();
                txtNomCocheInsert.setText(nomCoche);
            }
        }

    }

    public class MiModelodeTablaStocks extends DefaultTableModel {

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
        String[] nombresColumnas = {"CIFC", "Concesionario", "ID Coche", "Coche", "Stock"};

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

    private void btnEliminarStockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarStockActionPerformed
        int index = TablaPrincipal.getSelectedRow();

        if (index != -1) {

            int respuesta = JOptionPane.showConfirmDialog(null, "Desea Borrar", "Borrar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (respuesta == JOptionPane.YES_OPTION) {
                try {
                    Stocks vistaDELETE = (Stocks) LinkedStocks.get(index);
                    if (MetodosStocks.stockDELETE(vistaDELETE)) {
                        JOptionPane.showMessageDialog(this, "Se ha eliminado Correctamente.");
                    }
                } catch (Exception ex) {
                    Logger.getLogger(StocksGestionar.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione un Concesionario.");
        }
        dispose();
        new StocksGestionar(new javax.swing.JFrame(), true).setVisible(true);
    }//GEN-LAST:event_btnEliminarStockActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        if (TablaPrincipal.getSelectedRow() != -1) {
            if (validarDatosUpdate()) {

                String Cifc = txtCifcUpdate.getText();
                String nombreCon = txtNomConUpdate.getText();
                String IDcoche = txtIdCocheUpdate.getText();
                String NombreCoche = txtNomCocheUpdate.getText();
                Short stock = Short.parseShort(txtStockUpdate.getText());

                int respuesta = JOptionPane.showConfirmDialog(null, "Modificar Stock", "Modificar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (respuesta == JOptionPane.YES_OPTION) {
                    try {
                        BaseDatosUpdate(Cifc, nombreCon, IDcoche, NombreCoche, stock);
                    } catch (Exception ex) {
                        Logger.getLogger(StocksGestionar.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione Concesionario.");
        }
        dispose();
        new StocksGestionar(new javax.swing.JFrame(), true).setVisible(true);

    }//GEN-LAST:event_btnEditarActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated

        if (inicio) {
            inicio = false;
            if (LinkedStocksId.isEmpty()) {
                JOptionPane.showMessageDialog(this, "No existen Stocks", "Información", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }//GEN-LAST:event_formWindowActivated

    private void btnBuscarConcesionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarConcesionarioActionPerformed
        String nombreCon = txtBuscarConcesionario.getText().toUpperCase();

        if (nombreCon.isEmpty() || nombreCon.equalsIgnoreCase("")) {
            JOptionPane.showMessageDialog(this, "Introduzca Nombre de Concesionario", "Error al Buscar", JOptionPane.INFORMATION_MESSAGE);
        } else {
            try {
                MetodosStocks.stockBUSCAR_NomCon(nombreCon);
                buscar = true;
                dispose();
                new StocksGestionar(new javax.swing.JFrame(), true).setVisible(true);
                //MetodosStocks.stockSELECT();

            } catch (Exception ex) {
                Logger.getLogger(StocksGestionar.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnBuscarConcesionarioActionPerformed

    private void btnRecargarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRecargarActionPerformed
        dispose();
        new StocksGestionar(new javax.swing.JFrame(), true).setVisible(true);
    }//GEN-LAST:event_btnRecargarActionPerformed

    private void btnInsertarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertarActionPerformed

        if (validarDatosInsert()) {

            String Cifc = (String) spnCIFC_Insert.getSelectedItem();
            String nombreCon = txtNomConInsert.getText().toUpperCase();
            String IDcoche = (String) spnID_CocheInsert.getSelectedItem();
            String NombreCoche = txtNomCocheInsert.getText().toUpperCase();
            Short stock = Short.parseShort(txtStockInsert.getText());

            int respuesta = JOptionPane.showConfirmDialog(null, "¿Insertar Stock?", "Nueva alta", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (respuesta == JOptionPane.YES_OPTION) {
                try {
                    BaseDatosINSERT(Cifc, nombreCon, IDcoche, NombreCoche, stock);
                } catch (Exception ex) {
                    Logger.getLogger(StocksGestionar.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        dispose();
        new StocksGestionar(new javax.swing.JFrame(), true).setVisible(true);


    }//GEN-LAST:event_btnInsertarActionPerformed

    private void TablaPrincipalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaPrincipalMouseClicked
        seleccionCampoTabla();//Al clickar sobre una fila de la tabla(objeto) muestro sus datos en los TextFields de edición.
    }//GEN-LAST:event_TablaPrincipalMouseClicked

    private void txtBuscarConcesionarioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarConcesionarioKeyTyped
        int limitador = 15;
        if ((txtBuscarConcesionario.getText().length() >= limitador)) {
            evt.consume();
        }
    }//GEN-LAST:event_txtBuscarConcesionarioKeyTyped

    private void txtBuscarConcesionarioFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtBuscarConcesionarioFocusLost
        if ((txtBuscarConcesionario.getText().length() == 0)) {
            txtBuscarConcesionario.setBackground(Color.LIGHT_GRAY);
        } else {
            txtBuscarConcesionario.setBackground(Color.WHITE);
        }
    }//GEN-LAST:event_txtBuscarConcesionarioFocusLost

    private void btnIrGestionConcesionariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIrGestionConcesionariosActionPerformed
        dispose();
        new CochesGestionar(new javax.swing.JFrame(), true).setVisible(true);
    }//GEN-LAST:event_btnIrGestionConcesionariosActionPerformed

    private void txtStockInsertKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtStockInsertKeyTyped
        int limitador = 3;
        char ch = evt.getKeyChar();
        if ((!Character.isDigit(ch)) || (txtStockInsert.getText().length() >= limitador)) {
            evt.consume();
        }
    }//GEN-LAST:event_txtStockInsertKeyTyped

    private void txtStockUpdateKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtStockUpdateKeyTyped
        int limitador = 3;
        char ch = evt.getKeyChar();
        if ((!Character.isDigit(ch)) || (txtStockUpdate.getText().length() >= limitador)) {
            evt.consume();
        }
    }//GEN-LAST:event_txtStockUpdateKeyTyped

    private void spnCIFC_InsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_spnCIFC_InsertActionPerformed
        CIFC = spnCIFC_Insert.getSelectedItem().toString();
        cargarNombreConcesionario();


    }//GEN-LAST:event_spnCIFC_InsertActionPerformed

    private void spnID_CocheInsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_spnID_CocheInsertActionPerformed
        CODCOCHE = spnID_CocheInsert.getSelectedItem().toString();
        cargarNombreCoche();
    }//GEN-LAST:event_spnID_CocheInsertActionPerformed

    private void txtStockInsertFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtStockInsertFocusLost
        if ((txtStockInsert.getText().length() == 0)) {
            txtStockInsert.setBackground(Color.LIGHT_GRAY);
        } else {
            txtStockInsert.setBackground(Color.WHITE);
        }
    }//GEN-LAST:event_txtStockInsertFocusLost

    private void txtStockUpdateFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtStockUpdateFocusLost
        if ((txtStockUpdate.getText().length() == 0)) {
            txtStockUpdate.setBackground(Color.LIGHT_GRAY);
        } else {
            txtStockUpdate.setBackground(Color.WHITE);
        }
    }//GEN-LAST:event_txtStockUpdateFocusLost

    private void btnBuscarCocheActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarCocheActionPerformed
        String nombreCoche = txtBuscarCoche.getText().toUpperCase();

        if (nombreCoche.isEmpty() || nombreCoche.equalsIgnoreCase("")) {
            JOptionPane.showMessageDialog(this, "Introduzca Nombre de Concesionario", "Error al Buscar", JOptionPane.INFORMATION_MESSAGE);
        } else {
            try {
                MetodosStocks.stockBUSCAR_NomCoche(nombreCoche);
                buscar = true;
                dispose();
                new StocksGestionar(new javax.swing.JFrame(), true).setVisible(true);
                //MetodosStocks.stockSELECT();

            } catch (Exception ex) {
                Logger.getLogger(StocksGestionar.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnBuscarCocheActionPerformed

    public boolean validarDatosInsert() {
        boolean correcto = false;

        if (txtStockInsert.getBackground() == Color.WHITE) {
            correcto = true;
        }
        if (!correcto) {
            JOptionPane.showMessageDialog(this, "Hay campos incorrectos", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return correcto;
    }

    public boolean validarDatosUpdate() {
        boolean correcto = false;

        if (txtStockUpdate.getBackground() == Color.WHITE) {
            correcto = true;
        }
        if (!correcto) {
            JOptionPane.showMessageDialog(this, "Hay campos incorrectos", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return correcto;
    }

    //Metodo para insertar el nuevo almacen en la base de datos
    public void BaseDatosINSERT(String CIFC, String nomCon, String IdCoche, String nomoche, Short stock) throws Exception {

        Stocks stocksInsert = new Stocks();
        StocksId stocksId = new StocksId(CIFC, nomCon, IdCoche, nomoche, stock);
        stocksInsert.setId(stocksId);

        if (MetodosStocks.stockINSERT(stocksInsert)) {
            JOptionPane.showMessageDialog(this, "Se ha insertado correctamente.");
        } else {
            JOptionPane.showMessageDialog(this, "Error al guardar.");
        }
        cargarTablaStocks();
    }

    public void BaseDatosUpdate(String CIFC, String nomCon, String ID_Coche, String nomCoche, Short stock) throws Exception {

        Stocks stocksInsert = new Stocks();
        StocksId stocksId = new StocksId(CIFC, nomCon, ID_Coche, nomCoche, stock);
        stocksInsert.setId(stocksId);

        if (Controlador.MetodosStocks.stockUPDATE(stocksInsert)) {
            //Mensaje de confirmación
            JOptionPane.showMessageDialog(this, "Actualizado Correctamente.");

        } else {
            JOptionPane.showMessageDialog(this, "Error al editar", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        cargarTablaStocks();
    }

    public void seleccionCampoTabla() {

        stockSelecEnTabla = (StocksId) LinkedStocksId.get(TablaPrincipal.getSelectedRow());

        txtCifcUpdate.setText(stockSelecEnTabla.getIdCocesionario());
        txtNomConUpdate.setText(stockSelecEnTabla.getNombreConcesionario());
        txtIdCocheUpdate.setText(stockSelecEnTabla.getCodcoche());
        txtNomCocheUpdate.setText(stockSelecEnTabla.getNombreCoche());
        txtStockUpdate.setText(stockSelecEnTabla.getStock().toString());

    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel JLabelS;
    private javax.swing.JTable TablaPrincipal;
    private javax.swing.JButton btnBuscarCoche;
    private javax.swing.JButton btnBuscarConcesionario;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminarStock;
    private javax.swing.JButton btnInsertar;
    private javax.swing.JButton btnIrGestionConcesionarios;
    private javax.swing.JButton btnRecargar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelTitulo;
    private javax.swing.JLabel labelTitulo1;
    private javax.swing.JLabel labelTitulo2;
    private javax.swing.JPanel panelGeneral;
    private javax.swing.JComboBox<String> spnCIFC_Insert;
    private javax.swing.JComboBox<String> spnID_CocheInsert;
    private javax.swing.JTextField txtBuscarCoche;
    private javax.swing.JTextField txtBuscarConcesionario;
    private javax.swing.JTextField txtCifcUpdate;
    private javax.swing.JTextField txtIdCocheUpdate;
    private javax.swing.JTextField txtNomCocheInsert;
    private javax.swing.JTextField txtNomCocheUpdate;
    private javax.swing.JTextField txtNomConInsert;
    private javax.swing.JTextField txtNomConUpdate;
    private javax.swing.JTextField txtStockInsert;
    private javax.swing.JTextField txtStockUpdate;
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
            java.util.logging.Logger.getLogger(StocksGestionar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(() -> {
            StocksGestionar dialog = new StocksGestionar(new javax.swing.JFrame(), true);
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
