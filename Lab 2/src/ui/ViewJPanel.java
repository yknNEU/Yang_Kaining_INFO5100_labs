package ui;

import javax.swing.table.DefaultTableModel;

import model.VitalSigns;
import model.VitalSignsHistory;

public class ViewJPanel extends javax.swing.JPanel {

    private VitalSignsHistory vitalSignsHistory;

    public ViewJPanel(VitalSignsHistory vitalSignsHistory) {
        initComponents();
        this.vitalSignsHistory = vitalSignsHistory;
        populateTable();
    }

    @SuppressWarnings("unchecked")
                            
    private void initComponents() {

        lblTitle = new javax.swing.JLabel();
        lblTemp = new javax.swing.JLabel();
        lblPressure = new javax.swing.JLabel();
        lblPulse = new javax.swing.JLabel();
        lblDate = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblHistory = new javax.swing.JTable();
        btnDelete = new javax.swing.JButton();
        btnView = new javax.swing.JButton();
        txtTemp = new javax.swing.JLabel();
        txtPressure = new javax.swing.JLabel();
        txtPulse = new javax.swing.JLabel();
        txtDate = new javax.swing.JLabel();

        lblTitle.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 18));
        lblTitle.setText("View Vital Signs");

        lblTemp.setText("Temperature");

        lblPressure.setText("Blood Pressure");

        lblPulse.setText("Pulse");

        lblDate.setText("Date");

        tblHistory.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Date", "Temperature", "Blood Pressure", "Pulse"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblHistory);

        btnDelete.setText("Delete");
        btnDelete.setToolTipText("");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnView.setText("View");
        btnView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblTemp)
                    .addComponent(lblPressure)
                    .addComponent(lblPulse)
                    .addComponent(lblDate))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtPressure)
                    .addComponent(txtTemp, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtPulse, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtDate, javax.swing.GroupLayout.Alignment.LEADING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnView)
                .addGap(18, 18, 18)
                .addComponent(btnDelete)
                .addGap(57, 57, 57))
            .addComponent(jScrollPane2)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(306, Short.MAX_VALUE)
                .addComponent(lblTitle)
                .addGap(302, 302, 302))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtPressure)
                        .addGap(70, 70, 70))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblTitle)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblTemp)
                            .addComponent(btnDelete)
                            .addComponent(btnView)
                            .addComponent(txtTemp))
                        .addGap(18, 18, 18)
                        .addComponent(lblPressure)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblPulse)
                            .addComponent(txtPulse))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblDate)
                            .addComponent(txtDate))))
                .addContainerGap(47, Short.MAX_VALUE))
        );
    }                   

    private void btnViewActionPerformed(java.awt.event.ActionEvent evt) {                                        
        int selectedIndex = this.tblHistory.getSelectedRow();
        if (selectedIndex < 0) {
            javax.swing.JOptionPane.showMessageDialog(this, "Please select a row to view.", "Warning", javax.swing.JOptionPane.WARNING_MESSAGE);
            return;
        }

        DefaultTableModel model = (DefaultTableModel) this.tblHistory.getModel();
        VitalSigns selectedVitals = (VitalSigns) model.getValueAt(selectedIndex, 0);
        if (selectedVitals != null) {
            this.txtTemp.setText(String.valueOf(selectedVitals.temperature));
            this.txtPressure.setText(String.valueOf(selectedVitals.bloodPressure));
            this.txtPulse.setText(String.valueOf(selectedVitals.pulse));
            this.txtDate.setText(selectedVitals.date);
        }
    }                                       

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {                                          
        int selectedIndex = this.tblHistory.getSelectedRow();
        if (selectedIndex < 0) {
            javax.swing.JOptionPane.showMessageDialog(this, "Please select a row to delete.", "Warning", javax.swing.JOptionPane.WARNING_MESSAGE);
            return;
        }

        DefaultTableModel model = (DefaultTableModel) this.tblHistory.getModel();
        VitalSigns selectedVitals = (VitalSigns) model.getValueAt(selectedIndex, 0);
        if (selectedVitals != null) {
            this.vitalSignsHistory.removeVitalSigns(selectedVitals);
            // model.removeRow(selectedIndex);
            javax.swing.JOptionPane.showMessageDialog(this, "Vital signs deleted successfully", "Success", javax.swing.JOptionPane.INFORMATION_MESSAGE);
        }
        populateTable();
    }           
    
    private void populateTable() {
        DefaultTableModel model = (DefaultTableModel) this.tblHistory.getModel();
        model.setRowCount(0);

        for (VitalSigns vitalSigns : this.vitalSignsHistory.getHistory()) {
            Object[] row = new Object[4];
            row[0] = vitalSigns;
            row[1] = vitalSigns.temperature;
            row[2] = vitalSigns.bloodPressure;
            row[3] = vitalSigns.pulse;
            model.addRow(row);
        }
    }
               
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnView;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblDate;
    private javax.swing.JLabel lblPressure;
    private javax.swing.JLabel lblPulse;
    private javax.swing.JLabel lblTemp;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JTable tblHistory;
    private javax.swing.JLabel txtDate;
    private javax.swing.JLabel txtPressure;
    private javax.swing.JLabel txtPulse;
    private javax.swing.JLabel txtTemp;                
}
