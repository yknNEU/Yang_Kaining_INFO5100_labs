package ui;

import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import model.Supplier;
import model.SupplierDirectory;
import ui.admin.AdminWorkAreaJPanel;
import ui.supplier.SupplierWorkAreaJPanel;

public class LoginScreen extends javax.swing.JPanel {

    JPanel mainWorkArea;
    SupplierDirectory supplierDirectory;
    Supplier selectedSupplier;
    
    public LoginScreen(JPanel mainWorkArea, SupplierDirectory supplierDirectory) {
        initComponents();
        
        this.mainWorkArea = mainWorkArea;
        this.supplierDirectory = supplierDirectory;
        this.selectedSupplier = null;
        
        populateRoleCombo();
        populateSupplierCombo();
    }

    @SuppressWarnings("unchecked")
    
    private void initComponents() {
        lblTitle = new javax.swing.JLabel();
        cmbRoles = new javax.swing.JComboBox<>();
        lblRole = new javax.swing.JLabel();
        btnLogin = new javax.swing.JButton();
        cmbSuppliers = new javax.swing.JComboBox<>();
        lblSupplier = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        lblTitle.setFont(new java.awt.Font("Tahoma", 0, 18)); 
        lblTitle.setText("Welcome to Lab 4 Demo");

        cmbRoles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbRolesActionPerformed(evt);
            }
        });

        lblRole.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblRole.setText("Choose Role:");

        btnLogin.setText("Login");
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });

        cmbSuppliers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbSuppliersActionPerformed(evt);
            }
        });

        lblSupplier.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblSupplier.setText("Select Supplier:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(538, Short.MAX_VALUE)
                .addComponent(lblTitle)
                .addGap(64, 64, 64))
            .addGroup(layout.createSequentialGroup()
                .addGap(78, 78, 78)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblSupplier, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblRole, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cmbSuppliers, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLogin)
                    .addComponent(cmbRoles, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {lblRole, lblSupplier});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(lblTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 145, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbRoles, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblRole))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbSuppliers, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSupplier))
                .addGap(23, 23, 23)
                .addComponent(btnLogin)
                .addGap(281, 281, 281))
        );
    }

    private void cmbSuppliersActionPerformed(java.awt.event.ActionEvent evt) {
        if (cmbSuppliers.getSelectedItem() == null) {
            return;
        }
        selectedSupplier = (Supplier) cmbSuppliers.getSelectedItem();
    }

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {
        JPanel selectedPanel = (JPanel) cmbRoles.getSelectedItem();

        if (selectedPanel instanceof SupplierWorkAreaJPanel) {
            if (selectedSupplier == null) {
                JOptionPane.showMessageDialog(this, "Please select a supplier to login under the supplier role.");
                return;
            }
            selectedPanel = new SupplierWorkAreaJPanel(mainWorkArea, selectedSupplier);
        }

        mainWorkArea.add("WorkAreaJPanel" + selectedPanel.toString(), selectedPanel);
        CardLayout layout = (CardLayout) mainWorkArea.getLayout();
        layout.next(mainWorkArea);
    }

    private void cmbRolesActionPerformed(java.awt.event.ActionEvent evt) {
        updateSupplierVisibility();
    }

    private javax.swing.JButton btnLogin;
    private javax.swing.JComboBox<Object> cmbRoles;
    private javax.swing.JComboBox<Supplier> cmbSuppliers;
    private javax.swing.JLabel lblRole;
    private javax.swing.JLabel lblSupplier;
    private javax.swing.JLabel lblTitle;

    private void populateRoleCombo() {
        cmbRoles.removeAllItems();
      
        AdminWorkAreaJPanel adminWorkAreaJPanel = new AdminWorkAreaJPanel(mainWorkArea, supplierDirectory);
        SupplierWorkAreaJPanel supplierWorkAreaJPanel = new SupplierWorkAreaJPanel(mainWorkArea, selectedSupplier);

        cmbRoles.addItem(adminWorkAreaJPanel);
        cmbRoles.addItem(supplierWorkAreaJPanel);
    }

    public void populateSupplierCombo() {
        cmbSuppliers.removeAllItems();

        for (Supplier supplier : supplierDirectory.getSupplierList()) {
            cmbSuppliers.addItem(supplier);
        }
    }

    private void updateSupplierVisibility() {
        if (cmbRoles.getSelectedItem() == null || cmbRoles.getSelectedItem() instanceof AdminWorkAreaJPanel) {
            selectedSupplier = null;
            lblSupplier.setVisible(false);
            cmbSuppliers.setVisible(false);
            return;
        }
        
        if (cmbRoles.getSelectedItem() instanceof SupplierWorkAreaJPanel) {
            lblSupplier.setVisible(true);
            cmbSuppliers.setVisible(true);
        }
    }
}
