package ui;

import java.awt.CardLayout;

import model.Business;
import model.MasterOrderList;
import model.SupplierDirectory;
import ui.AdminRole.AdminWorkAreaJPanel;
import ui.CustomerRole.CustomerWorkAreaJPanel;
import ui.SupplierRole.LoginSupplierJPanel;


public class MainJFrame extends javax.swing.JFrame {

    Business business;
    SupplierDirectory supplierDirectory;
    MasterOrderList masterOrderList;
    
    public MainJFrame() {
        initComponents();
        business = new Business();
        supplierDirectory = business.getSupplierDirectory();
        masterOrderList = business.getMasterOrderList();
        setSize(830,600);
    }

    private void initComponents() {

        splitPane = new javax.swing.JSplitPane();
        controlPanel = new javax.swing.JPanel();
        btnAdmin = new javax.swing.JButton();
        btnSupplier = new javax.swing.JButton();
        btnCustomer = new javax.swing.JButton();
        userProcessContainer = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Lab 5 Skeleton");
        setBackground(new java.awt.Color(240, 240, 240));

        splitPane.setDividerLocation(150);
        splitPane.setOpaque(false);

        controlPanel.setBackground(new java.awt.Color(240, 240, 240));

        btnAdmin.setText("Administrator");
        btnAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdminActionPerformed(evt);
            }
        });

        btnSupplier.setText("Supplier");
        btnSupplier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSupplierActionPerformed(evt);
            }
        });

        btnCustomer.setText("Customer");
        btnCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCustomerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout controlPanelLayout = new javax.swing.GroupLayout(controlPanel);
        controlPanel.setLayout(controlPanelLayout);
        controlPanelLayout.setHorizontalGroup(
            controlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(controlPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(controlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCustomer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAdmin, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSupplier, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        controlPanelLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnAdmin, btnCustomer, btnSupplier});

        controlPanelLayout.setVerticalGroup(
            controlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(controlPanelLayout.createSequentialGroup()
                .addGap(114, 114, 114)
                .addComponent(btnAdmin)
                .addGap(18, 18, 18)
                .addComponent(btnSupplier)
                .addGap(18, 18, 18)
                .addComponent(btnCustomer)
                .addContainerGap(374, Short.MAX_VALUE))
        );

        splitPane.setLeftComponent(controlPanel);

        userProcessContainer.setBackground(new java.awt.Color(240, 240, 240));
        userProcessContainer.setLayout(new java.awt.CardLayout());
        splitPane.setRightComponent(userProcessContainer);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(splitPane, javax.swing.GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(splitPane)
        );

        pack();
    }

    private void btnAdminActionPerformed(java.awt.event.ActionEvent evt) {
        AdminWorkAreaJPanel awajp = new AdminWorkAreaJPanel(userProcessContainer, supplierDirectory);
        userProcessContainer.add("AdminWorkAreaJPanel",awajp);
        CardLayout layout = (CardLayout)userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }

    private void btnSupplierActionPerformed(java.awt.event.ActionEvent evt) {

        LoginSupplierJPanel ls = new LoginSupplierJPanel(userProcessContainer, supplierDirectory);
        userProcessContainer.add("LoginSupplierJPanel", ls);
        CardLayout layout = (CardLayout)userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }

    private void btnCustomerActionPerformed(java.awt.event.ActionEvent evt) {
        CustomerWorkAreaJPanel cwap = new CustomerWorkAreaJPanel(userProcessContainer, supplierDirectory, masterOrderList);
        userProcessContainer.add("CustomerWorkAreaJPanel", cwap);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }

    /**
     * @param args the command line arguments
     */
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

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainJFrame().setVisible(true);
            }
        });
    }

    private javax.swing.JButton btnAdmin;
    private javax.swing.JButton btnCustomer;
    private javax.swing.JButton btnSupplier;
    private javax.swing.JPanel controlPanel;
    private javax.swing.JSplitPane splitPane;
    private javax.swing.JPanel userProcessContainer;
}
