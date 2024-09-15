package ui;

import javax.swing.*;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import model.Product;

public class CreateJPanel extends JPanel {

    Product product;

    public CreateJPanel(Product product) {
        initComponents();
        this.product = product;
    }

    @SuppressWarnings("unchecked")

    private void initComponents() {
        txtName = new JTextField();
        lblName = new JLabel();
        txtDescr = new JTextField();
        lblDescr = new JLabel();
        txtAvail = new JTextField();
        lblAvail = new JLabel();
        txtPrice = new JTextField();
        lblPrice = new JLabel();
        lblTitle = new JLabel();
        btnSave = new JButton();

        lblName.setText("Name");
        lblDescr.setText("Description");
        lblAvail.setText("Availability");
        lblPrice.setText("Price");

        lblTitle.setFont(new Font("Microsoft YaHei UI", 1, 18)); // NOI18N
        lblTitle.setText("Create Product");

        btnSave.setText("Save");
        btnSave.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(80, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(lblName, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblDescr, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblAvail, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblPrice, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(txtName, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 158, GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDescr, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 158, GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtAvail, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 158, GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPrice, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 158, GroupLayout.PREFERRED_SIZE))
                .addGap(58, 58, 58))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(125, 125, 125)
                        .addComponent(lblTitle))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(150, 150, 150)
                        .addComponent(btnSave, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(lblTitle, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(txtName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblName))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(lblDescr)
                    .addComponent(txtDescr, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(lblAvail)
                    .addComponent(txtAvail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPrice, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPrice))
                .addGap(27, 27, 27)
                .addComponent(btnSave)
                .addContainerGap(22, Short.MAX_VALUE))
        );
    }

    private void btnSaveActionPerformed(ActionEvent evt) {
        this.product.name = this.txtName.getText();
        this.product.description = this.txtDescr.getText();
        this.product.availability = this.txtAvail.getText();
        this.product.price = this.txtPrice.getText();

        JOptionPane.showMessageDialog(this, "Product Saved!", "Success", JOptionPane.PLAIN_MESSAGE);

        this.txtName.setText("");
        this.txtDescr.setText("");
        this.txtAvail.setText("");
        this.txtPrice.setText("");
    }

    private JButton btnSave;
    private JLabel lblAvail;
    private JLabel lblDescr;
    private JLabel lblName;
    private JLabel lblPrice;
    private JLabel lblTitle;
    private JTextField txtAvail;
    private JTextField txtDescr;
    private JTextField txtName;
    private JTextField txtPrice;

}
