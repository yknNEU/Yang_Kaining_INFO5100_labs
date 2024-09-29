package ui;

import model.AccountDirectory;
import ui.accountmanager.WorkAreaJPanel;

public class MainJFrame extends javax.swing.JFrame {

    private AccountDirectory accountDirectory;

    public MainJFrame() {
        accountDirectory = new AccountDirectory();
        initComponents();
        // ***********************************
        generateDemoData();
        // ***********************************
        WorkAreaJPanel workAreaJPanel = new WorkAreaJPanel(userProcessContainer, accountDirectory);
        userProcessContainer.add(workAreaJPanel);
        java.awt.CardLayout layout = (java.awt.CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }

    @SuppressWarnings("unchecked")
                          
    private void initComponents() {

        mainJPanel = new javax.swing.JPanel();
        userProcessContainer = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        userProcessContainer.setLayout(new java.awt.CardLayout());

        javax.swing.GroupLayout mainJPanelLayout = new javax.swing.GroupLayout(mainJPanel);
        mainJPanel.setLayout(mainJPanelLayout);
        mainJPanelLayout.setHorizontalGroup(
            mainJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
            .addComponent(userProcessContainer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        mainJPanelLayout.setVerticalGroup(
            mainJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
            .addComponent(userProcessContainer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainJPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainJPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }  


    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainJFrame().setVisible(true);
            }
        });
    }

    private void generateDemoData() {
        accountDirectory.addAccount("Bank of America", "0011223344", "4444444444", 200);
        accountDirectory.addAccount("Santander Bank", "0077112234", "5555555555", 1200);
    }
                  
    private javax.swing.JPanel mainJPanel;
    private javax.swing.JPanel userProcessContainer;              
}
