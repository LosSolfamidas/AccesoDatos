package Vista;

public class VentanaPrincipal extends javax.swing.JFrame {

    public VentanaPrincipal() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        menuBar = new javax.swing.JMenuBar();
        MenuViviendas = new javax.swing.JMenu();
        GestionarViviendas = new javax.swing.JMenuItem();
        MenuPersonas = new javax.swing.JMenu();
        GestionarPersonas = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle(" -- CATASTRO NEODATIS --");
        setBackground(new java.awt.Color(38, 166, 154));
        setLocationByPlatform(true);
        setResizable(false);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\crone\\Desktop\\AccesoDatos\\CatastroNeodatis\\src\\Images\\Catastro.PNG")); // NOI18N
        jLabel1.setLabelFor(this);

        MenuViviendas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/home.png"))); // NOI18N
        MenuViviendas.setText("Viviendas");
        MenuViviendas.setFont(new java.awt.Font("DialogInput", 3, 18)); // NOI18N

        GestionarViviendas.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_V, java.awt.event.InputEvent.SHIFT_MASK));
        GestionarViviendas.setFont(new java.awt.Font("Dialog", 3, 14)); // NOI18N
        GestionarViviendas.setText("Gestionar");
        GestionarViviendas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GestionarViviendasActionPerformed(evt);
            }
        });
        MenuViviendas.add(GestionarViviendas);

        menuBar.add(MenuViviendas);

        MenuPersonas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/people.png"))); // NOI18N
        MenuPersonas.setText("Personas");
        MenuPersonas.setFont(new java.awt.Font("DialogInput", 3, 18)); // NOI18N

        GestionarPersonas.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_V, java.awt.event.InputEvent.SHIFT_MASK));
        GestionarPersonas.setFont(new java.awt.Font("Dialog", 3, 14)); // NOI18N
        GestionarPersonas.setText("Gestionar");
        GestionarPersonas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GestionarPersonasActionPerformed(evt);
            }
        });
        MenuPersonas.add(GestionarPersonas);

        menuBar.add(MenuPersonas);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 616, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void GestionarViviendasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GestionarViviendasActionPerformed
        new ViviendasGestionar(new javax.swing.JFrame(), true).setVisible(true);
    }//GEN-LAST:event_GestionarViviendasActionPerformed

    private void GestionarPersonasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GestionarPersonasActionPerformed
        new PersonaGestionar(new javax.swing.JFrame(), true).setVisible(true);
    }//GEN-LAST:event_GestionarPersonasActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem GestionarPersonas;
    private javax.swing.JMenuItem GestionarViviendas;
    private javax.swing.JMenu MenuPersonas;
    private javax.swing.JMenu MenuViviendas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuBar menuBar;
    // End of variables declaration//GEN-END:variables

     public static void main(String args[]) {
       
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new VentanaPrincipal().setVisible(true);
        });
    }
}
