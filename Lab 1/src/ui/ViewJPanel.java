package ui;

import javax.swing.*;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import model.Product;

public class ViewJPanel extends JPanel {

    Product product;

    public ViewJPanel(Product product) {
        initComponents();
        this.product = product;
        displayProduct();
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

        lblName.setText("Name");
        lblDescr.setText("Description");
        lblAvail.setText("Availability");
        lblPrice.setText("Price");

        lblTitle.setFont(new Font("Microsoft YaHei UI", 1, 18)); // NOI18N
        lblTitle.setText("View Product");

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
                    .addComponent(txtName, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 158, Short.MAX_VALUE)
                    .addComponent(txtDescr, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 158, Short.MAX_VALUE)
                    .addComponent(txtAvail, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 158, Short.MAX_VALUE)
                    .addComponent(txtPrice, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 158, Short.MAX_VALUE))
                .addGap(80, 80, 80))
            .addGroup(layout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addComponent(lblTitle)
                .addContainerGap(80, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(lblTitle, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(lblName)
                    .addComponent(txtName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDescr)
                    .addComponent(txtDescr, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAvail)
                    .addComponent(txtAvail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPrice)
                    .addComponent(txtPrice, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );
    }

    private JLabel lblAvail;
    private JLabel lblDescr;
    private JLabel lblName;
    private JLabel lblPrice;
    private JLabel lblTitle;
    private JTextField txtAvail;
    private JTextField txtDescr;
    private JTextField txtName;
    private JTextField txtPrice;

    private void displayProduct() {
        this.txtName.setText(this.product.name);
        this.txtDescr.setText(this.product.description);
        this.txtAvail.setText(this.product.availability);
        this.txtPrice.setText(this.product.price);
    }
}
