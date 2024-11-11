package ui.SupplierRole;

import model.Supplier;
import model.SupplierDirectory;
import java.awt.CardLayout;
import javax.swing.JPanel;

public class LoginSupplierJPanel extends javax.swing.JPanel {
    
    private JPanel userProcessContainer;
    private SupplierDirectory supplierDirectory;
    public LoginSupplierJPanel(JPanel upc, SupplierDirectory sd) {
        initComponents();
        userProcessContainer = upc;
        supplierDirectory = sd;
        
        cmbSupplier.removeAllItems();;
        for (Supplier supplier : supplierDirectory.getSupplierList()) {
            cmbSupplier.addItem(supplier);
        }
    }
    
    private void initComponents() {

        lblTitle = new javax.swing.JLabel();
        lblSupplierChooser = new javax.swing.JLabel();
        cmbSupplier = new javax.swing.JComboBox();
        btnFind = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(650, 600));

        lblTitle.setFont(new java.awt.Font("Lucida Grande", 0, 18)); 
        lblTitle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/logoPleaseBuySmall.png")));
        lblTitle.setText("Supplier Portal");
        lblTitle.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        lblTitle.setIconTextGap(50);

        lblSupplierChooser.setFont(new java.awt.Font("Tahoma", 0, 14));
        lblSupplierChooser.setText("Choose your supplier account:");

        cmbSupplier.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbSupplier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbSupplierActionPerformed(evt);
            }
        });

        btnFind.setText("Login >>");
        btnFind.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFindActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(230, 230, 230)
                        .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(137, 137, 137)
                        .addComponent(lblSupplierChooser)
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnFind)
                            .addComponent(cmbSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(42, 42, 42))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(lblTitle)
                .addGap(92, 92, 92)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSupplierChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnFind, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }

    private void btnFindActionPerformed(java.awt.event.ActionEvent evt) {
        Supplier supplier = (Supplier) cmbSupplier.getSelectedItem();
        SupplierWorkAreaJPanel swajp = new SupplierWorkAreaJPanel(userProcessContainer, supplier);
        userProcessContainer.add("SupplierWorkAreaJPanel", swajp);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }

    private void cmbSupplierActionPerformed(java.awt.event.ActionEvent evt) {

    }
    
    private javax.swing.JButton btnFind;
    private javax.swing.JComboBox cmbSupplier;
    private javax.swing.JLabel lblSupplierChooser;
    private javax.swing.JLabel lblTitle;
}
