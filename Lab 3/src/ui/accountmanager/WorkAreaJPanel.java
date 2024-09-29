package ui.accountmanager;

import model.AccountDirectory;

public class WorkAreaJPanel extends javax.swing.JPanel {

    private javax.swing.JPanel userProcessContainer;
    private AccountDirectory accountDirectory;

    public WorkAreaJPanel(javax.swing.JPanel userProcessContainer, AccountDirectory accountDirectory) {
        this.userProcessContainer = userProcessContainer;
        this.accountDirectory = accountDirectory;
        initComponents();
    }

    @SuppressWarnings("unchecked")
                           
    private void initComponents() {

        btnCreate = new javax.swing.JButton();
        btnManage = new javax.swing.JButton();

        btnCreate.setText("Create Account");
        btnCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateActionPerformed(evt);
            }
        });

        btnManage.setText("Manage Account");
        btnManage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnManageActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(131, 131, 131)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnCreate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnManage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(140, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(86, 86, 86)
                .addComponent(btnCreate)
                .addGap(71, 71, 71)
                .addComponent(btnManage)
                .addContainerGap(97, Short.MAX_VALUE))
        );
    }                    

    private void btnCreateActionPerformed(java.awt.event.ActionEvent evt) {                                          
        CreateAccountJPanel createAccountJPanel = new CreateAccountJPanel(userProcessContainer, accountDirectory);
        userProcessContainer.add("CreateAccountJPanel", createAccountJPanel);
        java.awt.CardLayout layout = (java.awt.CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }                                         

    private void btnManageActionPerformed(java.awt.event.ActionEvent evt) {                                          
        ManageAccountJPanel manageAccountJPanel = new ManageAccountJPanel(userProcessContainer, accountDirectory);
        userProcessContainer.add("ManageAccountJPanel", manageAccountJPanel);
        java.awt.CardLayout layout = (java.awt.CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }                                         

                 
    private javax.swing.JButton btnCreate;
    private javax.swing.JButton btnManage;                 
}
