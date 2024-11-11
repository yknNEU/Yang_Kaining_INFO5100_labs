package ui.CustomerRole;

import java.awt.CardLayout;

import javax.swing.JPanel;

import model.MasterOrderList;
import model.SupplierDirectory;

public class CustomerWorkAreaJPanel extends javax.swing.JPanel {

    JPanel userProcessContainer;
    SupplierDirectory supplierDirectory;
    MasterOrderList masterOrderList;

    public CustomerWorkAreaJPanel(JPanel userProcessContainer, SupplierDirectory supplierDirectory, MasterOrderList masterOrderList) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.supplierDirectory = supplierDirectory;
        this.masterOrderList = masterOrderList;
    }

    private void initComponents() {

        lblTitle = new javax.swing.JLabel();
        btnBrowseCatalog = new javax.swing.JButton();

        setBackground(new java.awt.Color(240, 240, 240));

        lblTitle.setBackground(new java.awt.Color(0, 0, 0));
        lblTitle.setFont(new java.awt.Font("Lucida Grande", 1, 24)); 
        lblTitle.setForeground(new java.awt.Color(204, 0, 0));
        lblTitle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/logoPleaseBuySmall.png")));
        lblTitle.setText("Welcome Dear Customer!");
        lblTitle.setIconTextGap(20);

        btnBrowseCatalog.setText("Browse Product Catalog >>");
        btnBrowseCatalog.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBrowseCatalogActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(lblTitle)
                .addContainerGap(195, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnBrowseCatalog)
                .addGap(56, 56, 56))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(lblTitle)
                .addGap(81, 81, 81)
                .addComponent(btnBrowseCatalog)
                .addContainerGap(399, Short.MAX_VALUE))
        );
    }

    private void btnBrowseCatalogActionPerformed(java.awt.event.ActionEvent evt) {
        BrowseProductsJPanel bpcj = new BrowseProductsJPanel(userProcessContainer, supplierDirectory, masterOrderList);
        userProcessContainer.add("BrowseProductCatalogJPanel", bpcj);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }

    private javax.swing.JButton btnBrowseCatalog;
    private javax.swing.JLabel lblTitle;
}
