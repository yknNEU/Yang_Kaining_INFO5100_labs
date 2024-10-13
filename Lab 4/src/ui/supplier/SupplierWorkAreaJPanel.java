package ui.supplier;

import model.Supplier;
import java.awt.CardLayout;
import java.awt.Component;
import javax.swing.JPanel;
import ui.LoginScreen;

public class SupplierWorkAreaJPanel extends javax.swing.JPanel {

    JPanel mainWorkArea;
    Supplier supplier;

    public SupplierWorkAreaJPanel(JPanel mainWorkArea, Supplier supplier) {
        initComponents();
        this.mainWorkArea = mainWorkArea;
        
        this.supplier = supplier;
        if (supplier != null) lblWelcome.setText("Welcome to Lab 4, "+supplier.getSupplyName());
        
        // masterOrderCatalog = moc;
    }

    private void initComponents() {
        splitPane = new javax.swing.JSplitPane();
        menuBar = new javax.swing.JPanel();
        btnLogOut = new javax.swing.JButton();
        lblWelcome = new javax.swing.JLabel();
        btnManageProductCatalog = new javax.swing.JButton();
        btnSupplierProfile = new javax.swing.JButton();
        btnManageStaff = new javax.swing.JButton();
        Performance = new javax.swing.JButton();
        workArea = new javax.swing.JPanel();

        splitPane.setDividerLocation(50);
        splitPane.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);

        menuBar.setBackground(new java.awt.Color(255, 255, 255));

        btnLogOut.setText("Log Out");
        btnLogOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogOutActionPerformed(evt);
            }
        });

        lblWelcome.setText("<WelcomeMsg>");

        btnManageProductCatalog.setText("Product Catalog");
        btnManageProductCatalog.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnManageProductCatalogActionPerformed(evt);
            }
        });

        btnSupplierProfile.setText("Update Profile");
        btnSupplierProfile.setEnabled(false);
        btnSupplierProfile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSupplierProfileActionPerformed(evt);
            }
        });

        btnManageStaff.setText("Manage Staff");
        btnManageStaff.setEnabled(false);

        Performance.setText("Performance");
        Performance.setEnabled(false);
        Performance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PerformanceActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout menuBarLayout = new javax.swing.GroupLayout(menuBar);
        menuBar.setLayout(menuBarLayout);
        menuBarLayout.setHorizontalGroup(
            menuBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, menuBarLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(lblWelcome, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnManageProductCatalog)
                .addGap(18, 18, 18)
                .addComponent(btnSupplierProfile)
                .addGap(18, 18, 18)
                .addComponent(btnManageStaff)
                .addGap(18, 18, 18)
                .addComponent(Performance)
                .addGap(18, 18, 18)
                .addComponent(btnLogOut)
                .addGap(46, 46, 46))
        );
        menuBarLayout.setVerticalGroup(
            menuBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, menuBarLayout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addGroup(menuBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLogOut)
                    .addComponent(lblWelcome)
                    .addComponent(btnManageProductCatalog)
                    .addComponent(btnSupplierProfile)
                    .addComponent(Performance)
                    .addComponent(btnManageStaff))
                .addContainerGap())
        );

        splitPane.setTopComponent(menuBar);

        workArea.setBackground(new java.awt.Color(255, 255, 255));
        workArea.setLayout(new java.awt.CardLayout());
        splitPane.setRightComponent(workArea);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 800, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(splitPane, javax.swing.GroupLayout.PREFERRED_SIZE, 800, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 600, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(splitPane, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
    }

    private void btnManageProductCatalogActionPerformed(java.awt.event.ActionEvent evt) {
        ManageProductCatalogJPanel mpcjp = new ManageProductCatalogJPanel(workArea, supplier);
        workArea.add("ManageProductCatalogJPanel", mpcjp);
        CardLayout layout = (CardLayout) workArea.getLayout();
        layout.next(workArea);
    }

    private void PerformanceActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        // ProductReportJPanel prjp = new workArea(userProcessContainer, supplier);
        // workArea.add("ProductReportJPanelSupplier", prjp);
        // CardLayout layout = (CardLayout)workArea.getLayout();
        // layout.next(userProcessContainer);
    }

    private void btnSupplierProfileActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:

    }

    private void btnLogOutActionPerformed(java.awt.event.ActionEvent evt) {
        mainWorkArea.remove(this);

        Component[] componentArray = mainWorkArea.getComponents();
        Component component = componentArray[componentArray.length - 1];
        LoginScreen loginPanel = (LoginScreen) component;
        loginPanel.populateSupplierCombo();

        CardLayout layout = (CardLayout) mainWorkArea.getLayout();
        layout.previous(mainWorkArea);
    }

    @Override
    public String toString() {
        return "Supplier";
    }

    private javax.swing.JButton Performance;
    private javax.swing.JButton btnLogOut;
    private javax.swing.JButton btnManageProductCatalog;
    private javax.swing.JButton btnManageStaff;
    private javax.swing.JButton btnSupplierProfile;
    private javax.swing.JLabel lblWelcome;
    private javax.swing.JPanel menuBar;
    private javax.swing.JSplitPane splitPane;
    private javax.swing.JPanel workArea;
}
