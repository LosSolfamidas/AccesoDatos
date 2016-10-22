package Vista;

import Controlador.MetodosCoches;
import Modelo.Coches;
import java.util.Iterator;
import javax.swing.JOptionPane;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;
import java.util.logging.Level;
import java.util.logging.Logger;
import static Controlador.MetodosCoches.generarId;
import static Controlador.MetodosCoches.LinkedCoches;

public final class CochesGestionar extends javax.swing.JDialog implements TableModelListener {

    static Coches cocheSeleccionado;//Para el objeto Coches seleccionado en la JTable
    int index;
    boolean inicio = true;
    boolean buscar = false;

    public CochesGestionar(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        cargarTablaCoches();
    }

    public void cargarTablaCoches() {
        
        
        txtModeloInsert.setText("");
        txtNombreCocheInsert.setText("");
        txtBuscar.setText("");
        txtIdCocheUpdate.setText("");
        txtModeloUpdate.setText("");
        txtNombreUpdate.setText("");

        if (!buscar) {
            MetodosCoches.cochesSELECT();
        }

        MiModelodeTablaCoches miTabla = new MiModelodeTablaCoches();

        String fila[] = new String[3];
        Iterator<Coches> iterador = LinkedCoches.iterator();
        while (iterador.hasNext()) {
            Coches coche = iterador.next();
            fila[0] = coche.getCodcoche();
            fila[1] = coche.getNombre();
            fila[2] = coche.getModelo();

            miTabla.addRow(fila);
        }

        tablaCoches.setModel(miTabla);
        //Añade un listener para eventos sobre la tabla
        tablaCoches.getModel().addTableModelListener(this);
        buscar = false;
    }

    public class MiModelodeTablaCoches extends DefaultTableModel {

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
        String nombresColumnas[] = {"ID", "Nombre", "Modelo"};

        @Override
        public String getColumnName(int index) {
            return nombresColumnas[index];
        }

        @Override
        public int getColumnCount() {
            return nombresColumnas.length;
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelGeneral = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaCoches = new javax.swing.JTable();
        labelTitulo = new javax.swing.JLabel();
        btnEliminar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        labelTitulo1 = new javax.swing.JLabel();
        labelTitulo2 = new javax.swing.JLabel();
        btnRefrescar = new javax.swing.JButton();
        txtBuscar = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        txtIdCocheUpdate = new javax.swing.JTextField();
        txtNombreUpdate = new javax.swing.JTextField();
        txtModeloUpdate = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtNombreCocheInsert = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtModeloInsert = new javax.swing.JTextField();
        btnActualizar = new javax.swing.JButton();
        btnInsertar = new javax.swing.JButton();
        btnIrGestionStocks = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle(" -- GESTIÓN DE COCHES --");
        setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        tablaCoches.setModel(new javax.swing.table.DefaultTableModel(
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
        tablaCoches.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tablaCoches.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaCochesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaCoches);

        labelTitulo.setFont(new java.awt.Font("DialogInput", 3, 18)); // NOI18N
        labelTitulo.setText("-- EDITAR --");

        btnEliminar.setFont(new java.awt.Font("DialogInput", 3, 14)); // NOI18N
        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Delete.png"))); // NOI18N
        btnEliminar.setText("Eliminar Coche");
        btnEliminar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnEliminar.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnEliminar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnSalir.setFont(new java.awt.Font("DialogInput", 3, 14)); // NOI18N
        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Salir.png"))); // NOI18N
        btnSalir.setText("Salir");
        btnSalir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSalir.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        labelTitulo1.setFont(new java.awt.Font("DialogInput", 3, 24)); // NOI18N
        labelTitulo1.setText("-- GESTIÓN DE COCHES --");

        labelTitulo2.setFont(new java.awt.Font("DialogInput", 3, 18)); // NOI18N
        labelTitulo2.setText("-- INSERTAR --");

        btnRefrescar.setFont(new java.awt.Font("DialogInput", 3, 14)); // NOI18N
        btnRefrescar.setIcon(new javax.swing.ImageIcon("C:\\Users\\crone\\Desktop\\AccesoDatos\\CatastroNeodatis\\src\\Images\\refresh.gif")); // NOI18N
        btnRefrescar.setText("Recargar Tabla");
        btnRefrescar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefrescarActionPerformed(evt);
            }
        });

        txtBuscar.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtBuscarFocusLost(evt);
            }
        });
        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBuscarKeyTyped(evt);
            }
        });

        btnBuscar.setFont(new java.awt.Font("DialogInput", 3, 14)); // NOI18N
        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/lupa_buscar.png"))); // NOI18N
        btnBuscar.setText("Buscar por Nombre");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        txtIdCocheUpdate.setEditable(false);
        txtIdCocheUpdate.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtIdCocheUpdateKeyTyped(evt);
            }
        });

        txtNombreUpdate.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtNombreUpdateFocusLost(evt);
            }
        });
        txtNombreUpdate.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreUpdateKeyTyped(evt);
            }
        });

        txtModeloUpdate.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtModeloUpdateFocusLost(evt);
            }
        });
        txtModeloUpdate.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtModeloUpdateKeyTyped(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Dialog", 3, 14)); // NOI18N
        jLabel1.setText("ID:");

        jLabel2.setFont(new java.awt.Font("Dialog", 3, 14)); // NOI18N
        jLabel2.setText("Nombre:");

        jLabel4.setFont(new java.awt.Font("Dialog", 3, 14)); // NOI18N
        jLabel4.setText("Modelo:");

        jLabel5.setFont(new java.awt.Font("Dialog", 3, 14)); // NOI18N
        jLabel5.setText("Modelo:");

        txtNombreCocheInsert.setBackground(new java.awt.Color(204, 255, 255));
        txtNombreCocheInsert.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtNombreCocheInsertFocusLost(evt);
            }
        });
        txtNombreCocheInsert.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreCocheInsertKeyTyped(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Dialog", 3, 14)); // NOI18N
        jLabel7.setText("Nombre:");

        txtModeloInsert.setBackground(new java.awt.Color(204, 255, 255));
        txtModeloInsert.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtModeloInsertFocusLost(evt);
            }
        });
        txtModeloInsert.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtModeloInsertKeyTyped(evt);
            }
        });

        btnActualizar.setFont(new java.awt.Font("DialogInput", 3, 14)); // NOI18N
        btnActualizar.setText("Aceptar");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        btnInsertar.setFont(new java.awt.Font("DialogInput", 3, 14)); // NOI18N
        btnInsertar.setText("Aceptar");
        btnInsertar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertarActionPerformed(evt);
            }
        });

        btnIrGestionStocks.setFont(new java.awt.Font("Dialog", 3, 14)); // NOI18N
        btnIrGestionStocks.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/concesionarios.jpg"))); // NOI18N
        btnIrGestionStocks.setText("Ir a Gestión de Stocks");
        btnIrGestionStocks.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIrGestionStocksActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelGeneralLayout = new javax.swing.GroupLayout(panelGeneral);
        panelGeneral.setLayout(panelGeneralLayout);
        panelGeneralLayout.setHorizontalGroup(
            panelGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelGeneralLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnIrGestionStocks)
                .addGap(94, 94, 94)
                .addComponent(labelTitulo1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(panelGeneralLayout.createSequentialGroup()
                .addGroup(panelGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panelGeneralLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panelGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnInsertar, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(panelGeneralLayout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtNombreCocheInsert, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(panelGeneralLayout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(labelTitulo2))
                    .addGroup(panelGeneralLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtModeloInsert)))
                .addGap(18, 18, 18)
                .addGroup(panelGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelGeneralLayout.createSequentialGroup()
                        .addComponent(txtBuscar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBuscar)
                        .addGap(134, 134, 134)
                        .addComponent(btnSalir))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelGeneralLayout.createSequentialGroup()
                        .addComponent(btnRefrescar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnEliminar))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 534, Short.MAX_VALUE))
                .addGroup(panelGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelGeneralLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(panelGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelGeneralLayout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtModeloUpdate))
                            .addGroup(panelGeneralLayout.createSequentialGroup()
                                .addGroup(panelGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(panelGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtNombreUpdate)
                                    .addComponent(txtIdCocheUpdate)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelGeneralLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btnActualizar)))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelGeneralLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                        .addComponent(labelTitulo)
                        .addGap(44, 44, 44))))
        );
        panelGeneralLayout.setVerticalGroup(
            panelGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelGeneralLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelTitulo1)
                    .addComponent(btnIrGestionStocks))
                .addGroup(panelGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelGeneralLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelTitulo)
                        .addGap(8, 8, 8))
                    .addGroup(panelGeneralLayout.createSequentialGroup()
                        .addGroup(panelGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelGeneralLayout.createSequentialGroup()
                                .addGap(44, 44, 44)
                                .addGroup(panelGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btnRefrescar)
                                    .addComponent(labelTitulo2)))
                            .addGroup(panelGeneralLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(btnEliminar)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(panelGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelGeneralLayout.createSequentialGroup()
                        .addGroup(panelGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtIdCocheUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNombreUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtModeloUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(22, 22, 22)
                        .addComponent(btnActualizar))
                    .addGroup(panelGeneralLayout.createSequentialGroup()
                        .addGroup(panelGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelGeneralLayout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addGroup(panelGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtNombreCocheInsert, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(panelGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtModeloInsert, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5))
                                .addGap(18, 18, 18)
                                .addComponent(btnInsertar))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelGeneral, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 2, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelGeneral, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 10, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents


    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        index = tablaCoches.getSelectedRow();

        if (index != -1) {
            
            int respuesta = JOptionPane.showConfirmDialog(null, "¿Desea Eliminar este Coche?", "Borrar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (respuesta == JOptionPane.YES_OPTION) {
                try {
                    if (MetodosCoches.cocheDELETE(cocheSeleccionado)) {
                        JOptionPane.showMessageDialog(this, "Se ha eliminado Correctamente.");
                    } else {
                        JOptionPane.showMessageDialog(this, "Error al Borrar.\n Este modelo de Coche tiene existencias en algún concesionario.");
                    }
                } catch (Exception ex) {
                    Logger.getLogger(CochesGestionar.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione el Coche a eliminar.");
        }
        cargarTablaCoches();
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        
        if (inicio) {
            inicio = false;
            if (LinkedCoches.isEmpty()) {
                JOptionPane.showMessageDialog(this, "No existen Coches", "Información", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }//GEN-LAST:event_formWindowActivated

    private void btnRefrescarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefrescarActionPerformed
        cargarTablaCoches();
    }//GEN-LAST:event_btnRefrescarActionPerformed

    private void txtNombreCocheInsertFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNombreCocheInsertFocusLost
        if ((txtNombreCocheInsert.getText().length() > 15) || (txtNombreCocheInsert.getText().length() == 0)) {
            txtNombreCocheInsert.setBackground(Color.LIGHT_GRAY);
        } else {
            txtNombreCocheInsert.setBackground(Color.WHITE);
        }
    }//GEN-LAST:event_txtNombreCocheInsertFocusLost

    private void txtModeloInsertFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtModeloInsertFocusLost
        if (((txtModeloInsert.getText().length() > 10) || (txtModeloInsert.getText().length() == 0))) {
            txtModeloInsert.setBackground(Color.LIGHT_GRAY);

        } else {
            txtModeloInsert.setBackground(Color.WHITE);
        }
    }//GEN-LAST:event_txtModeloInsertFocusLost

    private void txtNombreUpdateFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNombreUpdateFocusLost
        if ((txtNombreUpdate.getText().length() > 15) || (txtNombreUpdate.getText().length() == 0)) {
            txtNombreUpdate.setBackground(Color.LIGHT_GRAY);
        } else {
            txtNombreUpdate.setBackground(Color.WHITE);
        }
    }//GEN-LAST:event_txtNombreUpdateFocusLost

    private void txtModeloUpdateFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtModeloUpdateFocusLost
        if ((txtModeloUpdate.getText().length() > 10) || (txtModeloUpdate.getText().length() == 0)) {
            txtModeloUpdate.setBackground(Color.LIGHT_GRAY);
        } else {
            txtModeloUpdate.setBackground(Color.WHITE);
        }
    }//GEN-LAST:event_txtModeloUpdateFocusLost

    private void btnInsertarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertarActionPerformed
        if (validarDatosInsert() == true) {
            String ID = generarId();
            String nombre = txtNombreCocheInsert.getText().toUpperCase();
            String modelo = txtModeloInsert.getText().toUpperCase();

            int respuesta = JOptionPane.showConfirmDialog(null, "¿Almacenar Coche?", "Nueva alta", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (respuesta == JOptionPane.YES_OPTION) {
                try {
                    BaseDatosINSERT(ID, nombre, modelo);
                } catch (Exception ex) {
                    Logger.getLogger(CochesGestionar.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }//GEN-LAST:event_btnInsertarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        String nombreCoche = txtBuscar.getText().toUpperCase();

        if (nombreCoche.isEmpty() || nombreCoche.equalsIgnoreCase("")) {
            JOptionPane.showMessageDialog(this, "Introduzca Nombre de Coche", "Error al Buscar", JOptionPane.INFORMATION_MESSAGE);
        } else {
            try {
                MetodosCoches.cocheBUSCAR(nombreCoche);

                buscar = true;
                cargarTablaCoches();
                MetodosCoches.cochesSELECT();

            } catch (Exception ex) {
                Logger.getLogger(CochesGestionar.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void tablaCochesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaCochesMouseClicked
        SeleccionCampoTabla();
    }//GEN-LAST:event_tablaCochesMouseClicked

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        if (tablaCoches.getSelectedRow() != -1) {
            if (validarDatosUpdate() == true) {

                String ID = txtIdCocheUpdate.getText();
                String nombre = txtNombreUpdate.getText().toUpperCase();
                String modelo = txtModeloUpdate.getText().toUpperCase();

                int respuesta = JOptionPane.showConfirmDialog(null, "Modificar Coche", "Modificar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (respuesta == JOptionPane.YES_OPTION) {
                    try {
                        BaseDatosUpdate(ID, nombre, modelo);
                    } catch (Exception ex) {
                        Logger.getLogger(CochesGestionar.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione Coche.");
        }
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void txtNombreCocheInsertKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreCocheInsertKeyTyped
        int limitador = 15;
        char ch = evt.getKeyChar();
        if ((Character.isDigit(ch)) || (txtNombreCocheInsert.getText().length() >= limitador)) {
            evt.consume();
        }
    }//GEN-LAST:event_txtNombreCocheInsertKeyTyped

    private void txtModeloInsertKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtModeloInsertKeyTyped
        int limitador = 10;

        if ((txtModeloInsert.getText().length() >= limitador)) {
            evt.consume();
        }
    }//GEN-LAST:event_txtModeloInsertKeyTyped

    private void txtIdCocheUpdateKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIdCocheUpdateKeyTyped
        int limitador = 3;
        char ch = evt.getKeyChar();
        if ((Character.isDigit(ch)) || (txtIdCocheUpdate.getText().length() >= limitador)) {
            evt.consume();
        }
    }//GEN-LAST:event_txtIdCocheUpdateKeyTyped

    private void txtNombreUpdateKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreUpdateKeyTyped
        int limitador = 15;
        char ch = evt.getKeyChar();
        if ((Character.isDigit(ch)) || (txtNombreUpdate.getText().length() >= limitador)) {
            evt.consume();
        }
    }//GEN-LAST:event_txtNombreUpdateKeyTyped

    private void txtModeloUpdateKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtModeloUpdateKeyTyped
        int limitador = 10;

        if ((txtModeloUpdate.getText().length() >= limitador)) {
            evt.consume();
        }
    }//GEN-LAST:event_txtModeloUpdateKeyTyped

    private void txtBuscarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyTyped
        int limitador = 15;
        char ch = evt.getKeyChar();
        if ((Character.isDigit(ch)) || (txtBuscar.getText().length() >= limitador)) {
            evt.consume();
        }
    }//GEN-LAST:event_txtBuscarKeyTyped

    private void txtBuscarFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtBuscarFocusLost
        if ((txtBuscar.getText().length() > 15) || (txtBuscar.getText().length() == 0)) {
            txtBuscar.setBackground(Color.LIGHT_GRAY);
        } else {
            txtBuscar.setBackground(Color.WHITE);
        }
    }//GEN-LAST:event_txtBuscarFocusLost

    private void btnIrGestionStocksActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIrGestionStocksActionPerformed
        dispose();
        new StocksGestionar(new javax.swing.JFrame(), true).setVisible(true);
    }//GEN-LAST:event_btnIrGestionStocksActionPerformed

    public boolean validarDatosInsert() {
        boolean correcto = false;

        if (txtNombreCocheInsert.getBackground() == Color.WHITE && txtModeloInsert.getBackground() == Color.WHITE) {
            correcto = true;
        }
        if (correcto == false) {
            JOptionPane.showMessageDialog(this, "Hay campos incorrectos", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return correcto;
    }

    public boolean validarDatosUpdate() {
        boolean correcto = false;

        if (txtNombreUpdate.getBackground() != (Color.LIGHT_GRAY) && txtModeloUpdate.getBackground() != (Color.LIGHT_GRAY)) {
            correcto = true;
        }
        if (correcto == false) {
            JOptionPane.showMessageDialog(this, "Hay campos incorrectos!!!!!", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return correcto;
    }

    //Metodo para insertar el nuevo almacen en la base de datos
    public void BaseDatosINSERT(String ID, String nombre, String modelo) throws Exception {

        //Creamos el Objeto
        Coches cocheINSERT = new Coches(ID, nombre, modelo);

        if (Controlador.MetodosCoches.cocheINSERT(cocheINSERT)) {

            //Mensaje de confirmación
            JOptionPane.showMessageDialog(this, "Se ha insertado correctamente.");
        } else {
            JOptionPane.showMessageDialog(this, "Error al guardar.");
        }
        cargarTablaCoches();
    }

    public void BaseDatosUpdate(String ID, String nombre, String modelo) throws Exception {

        Coches cocheUpdate = new Coches(ID, nombre, modelo);

        if (Controlador.MetodosCoches.cocheUPDATE(cocheUpdate)) {
            //Mensaje de confirmación
            JOptionPane.showMessageDialog(this, "Actualizado Correctamente.");
            // update = true;

        } else {
            JOptionPane.showMessageDialog(this, "Error al editar", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        cargarTablaCoches();

    }

    public void SeleccionCampoTabla() {

        cocheSeleccionado = (Coches) LinkedCoches.get(tablaCoches.getSelectedRow());

        txtIdCocheUpdate.setText(cocheSeleccionado.getCodcoche());

        txtNombreUpdate.setText(cocheSeleccionado.getNombre());
        txtModeloUpdate.setText(cocheSeleccionado.getModelo());

    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnInsertar;
    private javax.swing.JButton btnIrGestionStocks;
    private javax.swing.JButton btnRefrescar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelTitulo;
    private javax.swing.JLabel labelTitulo1;
    private javax.swing.JLabel labelTitulo2;
    private javax.swing.JPanel panelGeneral;
    private javax.swing.JTable tablaCoches;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtIdCocheUpdate;
    private javax.swing.JTextField txtModeloInsert;
    private javax.swing.JTextField txtModeloUpdate;
    private javax.swing.JTextField txtNombreCocheInsert;
    private javax.swing.JTextField txtNombreUpdate;
    // End of variables declaration//GEN-END:variables

    @Override
    public void tableChanged(TableModelEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(CochesGestionar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(() -> {
            CochesGestionar dialog = new CochesGestionar(new javax.swing.JFrame(), true);
            dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                @Override
                public void windowClosing(java.awt.event.WindowEvent e) {
                    System.exit(0);
                }
            });
            dialog.setVisible(true);
        });
    }
}
