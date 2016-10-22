package Vista;

import Controlador.Metodos;
import static Controlador.Metodos.listadoPersonasNoReg;
import Objetos.Persona;
import static Vista.ViviendasGestionar.actualizar;
import java.util.Iterator;
import javax.swing.JOptionPane;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import static Vista.ViviendasGestionar.viviendaSeleccionada;

public final class RegistrarPersonas extends javax.swing.JDialog implements TableModelListener {

    boolean inicio = true;
    Persona personaSeleccionada;

    public RegistrarPersonas(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        cargarTablaNoReg();
    }

    public void cargarTablaNoReg() {

        Metodos.personasNoRegSELECT();

        MiModelodeTabla miTabla = new MiModelodeTabla();

        String fila[] = new String[5];
        Iterator<Persona> ObjPersona = listadoPersonasNoReg.iterator();
        while (ObjPersona.hasNext()) {
            Persona per = ObjPersona.next();
            fila[0] = String.valueOf(per.getID_Persona());
            fila[1] = per.getNombre();
            fila[2] = per.getApellidos();
            fila[3] = String.valueOf(per.getAnyoNacimiento());
            fila[4] = per.getNumTelefono();

            miTabla.addRow(fila);
            System.out.println("ID" + per.getID_Persona() + "    Reg: " + per.isRegistrada());
        }

        // Asigno los valores a la tabla y así la inicializa sólo con los datos leídos
        TablaNoRegistradas.setModel(miTabla);

        //Añade un listener para eventos sobre la tabla
        TablaNoRegistradas.getModel().addTableModelListener(this);
    }

    public class MiModelodeTabla extends DefaultTableModel {

        @Override
        public boolean isCellEditable(int fila, int columna) {
            return false;
        }

        @Override
        public Class getColumnClass(int columna) {
            return String.class;
        }

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

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelGeneral = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaNoRegistradas = new javax.swing.JTable();
        labelTitulo = new javax.swing.JLabel();
        btnAnyadir = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle(" -- REGISTRO EN VIVIENDA --");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        TablaNoRegistradas.setModel(new javax.swing.table.DefaultTableModel(
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
        TablaNoRegistradas.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        TablaNoRegistradas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablaNoRegistradasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TablaNoRegistradas);

        labelTitulo.setFont(new java.awt.Font("DialogInput", 3, 24)); // NOI18N
        labelTitulo.setText(" -- Añadir Persona --");

        btnAnyadir.setFont(new java.awt.Font("DialogInput", 3, 12)); // NOI18N
        btnAnyadir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/add.png"))); // NOI18N
        btnAnyadir.setText("Añadir Persona");
        btnAnyadir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAnyadir.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnAnyadir.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnAnyadir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnyadirActionPerformed(evt);
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

        javax.swing.GroupLayout panelGeneralLayout = new javax.swing.GroupLayout(panelGeneral);
        panelGeneral.setLayout(panelGeneralLayout);
        panelGeneralLayout.setHorizontalGroup(
            panelGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelGeneralLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 614, Short.MAX_VALUE)
                    .addGroup(panelGeneralLayout.createSequentialGroup()
                        .addComponent(btnAnyadir, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSalir)))
                .addContainerGap())
            .addGroup(panelGeneralLayout.createSequentialGroup()
                .addGap(169, 169, 169)
                .addComponent(labelTitulo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelGeneralLayout.setVerticalGroup(
            panelGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelGeneralLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(labelTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panelGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAnyadir)
                    .addComponent(btnSalir))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelGeneral, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelGeneral, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        
        dispose();
        
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnAnyadirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnyadirActionPerformed

        if (TablaNoRegistradas.getSelectedRow() != -1) {
            int preguntaRegistrar = JOptionPane.showConfirmDialog(null, "Registrar Persona", "Registrar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            int preguntaRegOtra = JOptionPane.showConfirmDialog(null, "¿Quieres registrar otra Persona en esta Vivienda?", "Registrar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            boolean registrar = true;
            if (preguntaRegistrar == JOptionPane.YES_OPTION) {

                if (Controlador.Metodos.registrarPersonaUPDATE(personaSeleccionada, registrar)) {
                    if (Controlador.Metodos.personaEnViviendaUPDATE(personaSeleccionada, viviendaSeleccionada)) {
                        ViviendasGestionar.actualizar = true;
                    } else {
                        JOptionPane.showMessageDialog(this, "Error al añadir habitante en vivienda", "ERROR", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Error al registrar persona", "ERROR", JOptionPane.ERROR_MESSAGE);
                }

                if (preguntaRegOtra == JOptionPane.YES_OPTION) {
                    ViviendasGestionar.actualizar = true;
                } else {
                    JOptionPane.showMessageDialog(this, "Volviendo a Gestión de Viviendas");
                    ViviendasGestionar.actualizar = true;
                    dispose();

                }
            } else {
                JOptionPane.showMessageDialog(this, "Operación Anulada.");
            }
            ViviendasGestionar.actualizar = true;
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione la Persona a añadir.");
        }
        ViviendasGestionar.actualizar = true;


    }//GEN-LAST:event_btnAnyadirActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        if (actualizar == true) {
            cargarTablaNoReg();
            TablaNoRegistradas.repaint();
            actualizar = false;
        }

        if (inicio == true) {
            inicio = false;
            if (listadoPersonasNoReg.isEmpty()) {
                JOptionPane.showMessageDialog(this, "No Hay personas sin registrar", "Información", JOptionPane.INFORMATION_MESSAGE);
                dispose();
            }
        }
    }//GEN-LAST:event_formWindowActivated

    private void TablaNoRegistradasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaNoRegistradasMouseClicked
        personaSeleccionada = listadoPersonasNoReg.get(TablaNoRegistradas.getSelectedRow());
    }//GEN-LAST:event_TablaNoRegistradasMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TablaNoRegistradas;
    private javax.swing.JButton btnAnyadir;
    private javax.swing.JButton btnSalir;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelTitulo;
    private javax.swing.JPanel panelGeneral;
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
            java.util.logging.Logger.getLogger(RegistrarPersonas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }


        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(() -> {
            RegistrarPersonas dialog = new RegistrarPersonas(new javax.swing.JFrame(), true);
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
