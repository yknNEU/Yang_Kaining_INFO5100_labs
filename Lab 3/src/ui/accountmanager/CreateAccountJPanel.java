package ui.accountmanager;

import model.AccountDirectory;

public class CreateAccountJPanel extends javax.swing.JPanel {

    private javax.swing.JPanel userProcessContainer;
    private AccountDirectory accountDirectory;

    public CreateAccountJPanel(javax.swing.JPanel userProcessContainer, AccountDirectory accountDirectory) {
        this.userProcessContainer = userProcessContainer;
        this.accountDirectory = accountDirectory;
        initComponents();
    }

    @SuppressWarnings("unchecked")
                            
    private void initComponents() {

        btnBack = new javax.swing.JButton();
        lblTitle = new javax.swing.JLabel();
        lblRoutingNumber = new javax.swing.JLabel();
        lblAccountNumber = new javax.swing.JLabel();
        lblBankName = new javax.swing.JLabel();
        lblBalance = new javax.swing.JLabel();
        txtRoutingNumber = new javax.swing.JTextField();
        txtAccountNumber = new javax.swing.JTextField();
        txtBankName = new javax.swing.JTextField();
        txtBalance = new javax.swing.JTextField();
        btnCreate = new javax.swing.JButton();

        btnBack.setText("<<<Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        lblTitle.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 14)); // NOI18N
        lblTitle.setText("Create Account");

        lblRoutingNumber.setText("Routing Number");

        lblAccountNumber.setText("Account Number");

        lblBankName.setText("Bank Name");

        lblBalance.setText("Balance");

        btnCreate.setText("Create");
        btnCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateActionPerformed(evt);
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
                        .addGap(42, 42, 42)
                        .addComponent(lblTitle))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblAccountNumber)
                            .addComponent(lblRoutingNumber)
                            .addComponent(lblBankName)
                            .addComponent(lblBalance))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtRoutingNumber)
                            .addComponent(txtAccountNumber)
                            .addComponent(txtBankName)
                            .addComponent(txtBalance, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addComponent(btnCreate)))))
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
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblBalance)
                    .addComponent(txtBalance, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addComponent(btnCreate)
                .addContainerGap(39, Short.MAX_VALUE))
        );
    }                      

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {                                        
        userProcessContainer.remove(this);
        java.awt.CardLayout layout = (java.awt.CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }                                       

    private void btnCreateActionPerformed(java.awt.event.ActionEvent evt) {                                  
        int balance;
        String accountNumber = txtAccountNumber.getText();
        String bankName = txtBankName.getText();
        String routingNumber = txtRoutingNumber.getText();
        if (routingNumber.isBlank() || accountNumber.isBlank() || bankName.isBlank()) {
            javax.swing.JOptionPane.showMessageDialog(this, "All fields are mandatory.", "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            balance = Integer.parseInt(txtBalance.getText());
        } catch (NumberFormatException e) {
            javax.swing.JOptionPane.showMessageDialog(this, "Please check the balance input.", "Warning", javax.swing.JOptionPane.WARNING_MESSAGE);
            return;
        }

        accountDirectory.addAccount(routingNumber, accountNumber, bankName, balance);
        javax.swing.JOptionPane.showMessageDialog(this, "Account created successfully.", "Information", javax.swing.JOptionPane.INFORMATION_MESSAGE);

        txtRoutingNumber.setText("");
        txtAccountNumber.setText("");
        txtBankName.setText("");
        txtBalance.setText("");
    }                                         
 
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnCreate;
    private javax.swing.JLabel lblAccountNumber;
    private javax.swing.JLabel lblBalance;
    private javax.swing.JLabel lblBankName;
    private javax.swing.JLabel lblRoutingNumber;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JTextField txtAccountNumber;
    private javax.swing.JTextField txtBalance;
    private javax.swing.JTextField txtBankName;
    private javax.swing.JTextField txtRoutingNumber;              
}
