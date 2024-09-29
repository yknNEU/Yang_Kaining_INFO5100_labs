package ui.accountmanager;

import model.Account;
import model.AccountDirectory;

public class ManageAccountJPanel extends javax.swing.JPanel {

    private javax.swing.JPanel userProcessContainer;
    private AccountDirectory accountDirectory;

    public ManageAccountJPanel(javax.swing.JPanel userProcessContainer, AccountDirectory accountDirectory) {
        this.userProcessContainer = userProcessContainer;
        this.accountDirectory = accountDirectory;
        initComponents();
        populateTable();
    }


    @SuppressWarnings("unchecked")
                           
    private void initComponents() {

        btnBack = new javax.swing.JButton();
        lblTitle = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblAccounts = new javax.swing.JTable();
        txtSearch = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        btnView = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();

        btnBack.setText("<<<Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        lblTitle.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 14)); // NOI18N
        lblTitle.setText("Manage Account");

        tblAccounts.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Bank Name", "Routing Number", "Account Number", "Balance"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblAccounts.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tblAccounts);

        btnSearch.setText("Search");
        btnSearch.setToolTipText("");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        btnView.setText("View Details");
        btnView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewActionPerformed(evt);
            }
        });

        btnDelete.setText("Delete Account");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 415, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSearch))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnBack)
                                .addGap(51, 51, 51)
                                .addComponent(lblTitle))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(btnView, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnDelete, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBack)
                    .addComponent(lblTitle))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearch))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnView)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDelete)
                .addContainerGap(36, Short.MAX_VALUE))
        );
    }                       

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {                                        
        userProcessContainer.remove(this);
        java.awt.CardLayout layout = (java.awt.CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }                                                                       

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {                                          
        if (txtSearch.getText().isBlank()) {
            javax.swing.JOptionPane.showMessageDialog(null, "Please type the account number to view.", "Warning", javax.swing.JOptionPane.WARNING_MESSAGE);
            return;
        }

        String accountNumber = txtSearch.getText();
        Account account = accountDirectory.searchAccount(accountNumber);

        if (account == null) {
            javax.swing.JOptionPane.showMessageDialog(null, "Account not found. Please check the account number and try again.", "Warning", javax.swing.JOptionPane.WARNING_MESSAGE);
        } else {
            ViewAccountJPanel viewAccountJPanel = new ViewAccountJPanel(userProcessContainer, accountDirectory, account);
            userProcessContainer.add("ViewAccountJPanel", viewAccountJPanel);
            java.awt.CardLayout layout = (java.awt.CardLayout) userProcessContainer.getLayout();
            layout.next(userProcessContainer);
        }
    }                                         

    private void btnViewActionPerformed(java.awt.event.ActionEvent evt) {                                        
        int selectedRow = tblAccounts.getSelectedRow();

        if (selectedRow >= 0) {
            Account account = (Account) tblAccounts.getValueAt(selectedRow, 0);
            ViewAccountJPanel viewAccountJPanel = new ViewAccountJPanel(userProcessContainer, accountDirectory, account);
            userProcessContainer.add("ViewAccountJPanel", viewAccountJPanel);
            java.awt.CardLayout layout = (java.awt.CardLayout) userProcessContainer.getLayout();
            layout.next(userProcessContainer);
        } else {
            javax.swing.JOptionPane.showMessageDialog(null, "Please select an account from the list.", "Warning", javax.swing.JOptionPane.WARNING_MESSAGE);
        }
    }                                       

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {                                          
        int selectedRow = tblAccounts.getSelectedRow();

        if (selectedRow >= 0) {
            int dialogButton = javax.swing.JOptionPane.YES_NO_OPTION;
            int dialogResult = javax.swing.JOptionPane.showConfirmDialog(null, "Are you sure you want to delete the selected account?", "Warning", dialogButton);
            if (dialogResult == javax.swing.JOptionPane.YES_OPTION) {
                Account account = (Account) tblAccounts.getValueAt(selectedRow, 0);
                accountDirectory.removeAccount(account);
                populateTable();
            }
        } else {
            javax.swing.JOptionPane.showMessageDialog(null, "Please select an account from the list.", "Warning", javax.swing.JOptionPane.WARNING_MESSAGE);
        }
    }                                         

    public void populateTable() {
        javax.swing.table.DefaultTableModel model = (javax.swing.table.DefaultTableModel) tblAccounts.getModel();
        model.setRowCount(0);

        for (model.Account account : accountDirectory.getAccounts()) {
            Object[] row = new Object[4];
            row[0] = account;
            row[1] = account.getRoutingNumber();
            row[2] = account.getAccountNumber();
            row[3] = account.getBalance();
            model.addRow(row);
        }
    }
                   
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnView;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JTable tblAccounts;
    private javax.swing.JTextField txtSearch;         
}