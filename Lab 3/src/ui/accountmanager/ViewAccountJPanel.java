package ui.accountmanager;

import model.Account;
import model.AccountDirectory;

public class ViewAccountJPanel extends javax.swing.JPanel {

    private javax.swing.JPanel userProcessContainer;
    private AccountDirectory accountDirectory;
    private Account account;

    public ViewAccountJPanel(javax.swing.JPanel userProcessContainer, AccountDirectory accountDirectory, Account account) {
        this.userProcessContainer = userProcessContainer;
        this.accountDirectory = accountDirectory;
        this.account = account;
        initComponents();
        refreshTextFields();
        setViewMode();
    }

 
    @SuppressWarnings("unchecked")
                     
    private void initComponents() {

        lblBankName = new javax.swing.JLabel();
        txtRoutingNumber = new javax.swing.JTextField();
        txtAccountNumber = new javax.swing.JTextField();
        txtBankName = new javax.swing.JTextField();
        btnBack = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        lblTitle = new javax.swing.JLabel();
        lblRoutingNumber = new javax.swing.JLabel();
        lblAccountNumber = new javax.swing.JLabel();
        btnUpdate = new javax.swing.JButton();

        lblBankName.setText("Bank Name");

        btnBack.setText("<<<Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        lblTitle.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 14)); // NOI18N
        lblTitle.setText("View Account");

        lblRoutingNumber.setText("Routing Number");

        lblAccountNumber.setText("Account Number");

        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(btnBack)
                        .addGap(59, 59, 59)
                        .addComponent(lblTitle))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblAccountNumber)
                            .addComponent(lblRoutingNumber)
                            .addComponent(lblBankName))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtRoutingNumber, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
                            .addComponent(txtAccountNumber)
                            .addComponent(txtBankName)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(98, 98, 98)
                        .addComponent(btnSave)
                        .addGap(28, 28, 28)
                        .addComponent(btnUpdate)))
                .addContainerGap(100, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnBack)
                    .addComponent(lblTitle))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblRoutingNumber)
                    .addComponent(txtRoutingNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAccountNumber)
                    .addComponent(txtAccountNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblBankName)
                    .addComponent(txtBankName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSave)
                    .addComponent(btnUpdate))
                .addContainerGap(65, Short.MAX_VALUE))
        );
    }                       

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {                                        
        userProcessContainer.remove(this);

        java.awt.Component[] panelStack = userProcessContainer.getComponents();
        javax.swing.JPanel lastPanel = (javax.swing.JPanel) panelStack[panelStack.length - 1];
        ManageAccountJPanel manageAccountJPanel = (ManageAccountJPanel) lastPanel;
        manageAccountJPanel.populateTable();

        java.awt.CardLayout layout = (java.awt.CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }                                       

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {                                        
        String routingNumber = txtRoutingNumber.getText();
        String accountNumber = txtAccountNumber.getText();
        String bankName = txtBankName.getText();

        if (routingNumber.isBlank() || accountNumber.isBlank() || bankName.isBlank()) {
            javax.swing.JOptionPane.showMessageDialog(null, "All fields are mandatory.", "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
            return;
        }

        account.setRoutingNumber(routingNumber);
        account.setAccountNumber(accountNumber);
        account.setBankName(bankName);

        javax.swing.JOptionPane.showMessageDialog(null, "Account updated successfully.", "Information", javax.swing.JOptionPane.INFORMATION_MESSAGE);
        setViewMode();
    }                                       

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {                                          
        setEditMode();
    }                                         

    private void refreshTextFields() {
        txtRoutingNumber.setText(account.getRoutingNumber());
        txtAccountNumber.setText(account.getAccountNumber());
        txtBankName.setText(account.getBankName());
    }

    private void setViewMode() {
        txtRoutingNumber.setEditable(false);
        txtAccountNumber.setEditable(false);
        txtBankName.setEditable(false);
        btnSave.setEnabled(false);
        btnUpdate.setEnabled(true);
    }

    private void setEditMode() {
        txtRoutingNumber.setEditable(true);
        txtAccountNumber.setEditable(true);
        txtBankName.setEditable(true);
        btnSave.setEnabled(true);
        btnUpdate.setEnabled(false);
    }
            
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JLabel lblAccountNumber;
    private javax.swing.JLabel lblBankName;
    private javax.swing.JLabel lblRoutingNumber;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JTextField txtAccountNumber;
    private javax.swing.JTextField txtBankName;
    private javax.swing.JTextField txtRoutingNumber;               
}
