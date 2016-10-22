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
        MenuConcesionarios = new javax.swing.JMenu();
        GestionarConcesionarios = new javax.swing.JMenuItem();
        MenuCoches = new javax.swing.JMenu();
        GestionarCoches = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle(" -- COCHES HIBERNATE --");
        setBackground(new java.awt.Color(38, 166, 154));
        setLocationByPlatform(true);
        setResizable(false);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/concesionario.jpg"))); // NOI18N
        jLabel1.setLabelFor(this);

        MenuConcesionarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/concesionarios.jpg"))); // NOI18N
        MenuConcesionarios.setText("Concesionarios");
        MenuConcesionarios.setFont(new java.awt.Font("DialogInput", 3, 18)); // NOI18N

        GestionarConcesionarios.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_V, java.awt.event.InputEvent.SHIFT_MASK));
        GestionarConcesionarios.setFont(new java.awt.Font("Dialog", 3, 14)); // NOI18N
        GestionarConcesionarios.setText("Gestionar");
        GestionarConcesionarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GestionarConcesionariosActionPerformed(evt);
            }
        });
        MenuConcesionarios.add(GestionarConcesionarios);

        menuBar.add(MenuConcesionarios);

        MenuCoches.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/coche.gif"))); // NOI18N
        MenuCoches.setText("Coches");
        MenuCoches.setFont(new java.awt.Font("DialogInput", 3, 18)); // NOI18N

        GestionarCoches.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_V, java.awt.event.InputEvent.SHIFT_MASK));
        GestionarCoches.setFont(new java.awt.Font("Dialog", 3, 14)); // NOI18N
        GestionarCoches.setText("Gestionar");
        GestionarCoches.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GestionarCochesActionPerformed(evt);
            }
        });
        MenuCoches.add(GestionarCoches);

        menuBar.add(MenuCoches);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void GestionarConcesionariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GestionarConcesionariosActionPerformed
        new StocksGestionar(new javax.swing.JFrame(), true).setVisible(true);
    }//GEN-LAST:event_GestionarConcesionariosActionPerformed

    private void GestionarCochesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GestionarCochesActionPerformed
        new CochesGestionar(new javax.swing.JFrame(), true).setVisible(true);
    }//GEN-LAST:event_GestionarCochesActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem GestionarCoches;
    private javax.swing.JMenuItem GestionarConcesionarios;
    private javax.swing.JMenu MenuCoches;
    private javax.swing.JMenu MenuConcesionarios;
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
