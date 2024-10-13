package ui.supplier;

import model.Product;
import model.Supplier;
import java.awt.CardLayout;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class SearchForProductJPanel extends javax.swing.JPanel {

   JPanel workArea;
   Supplier supplier;
    
    /** Creates new form CreateProductJPanel */
    public SearchForProductJPanel(JPanel workArea, Supplier supplier) {
        initComponents();
        this.workArea = workArea;
        this.supplier = supplier;
    }

    private void initComponents() {
        lblTitle = new javax.swing.JLabel();
        lblProductId = new javax.swing.JLabel();
        idField = new javax.swing.JTextField();
        searchButton = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        lblTitle.setText("Search for Product");

        lblProductId.setText("Product Id:");

        searchButton.setText("Search Now >>");
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });

        jButton1.setText("<< Back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblProductId)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(37, 37, 37)
                        .addComponent(lblTitle))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(idField, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(55, 55, 55)
                        .addComponent(searchButton)))
                .addContainerGap(343, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(lblTitle))
                .addGap(61, 61, 61)
                .addComponent(lblProductId)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(idField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchButton))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {idField, searchButton});
    }

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {
        String strId = idField.getText();
        if (strId.isBlank()) {
            JOptionPane.showMessageDialog(this, "Please enter the product Id", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int id = 0;
        try {
            id = Integer.parseInt(strId);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Please enter a number", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Product product = supplier.getProductCatalog().searchProduct(id);
        if (product == null) {
            JOptionPane.showMessageDialog(this, "Product not found", "Information", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        workArea.remove(this);
        CardLayout layout = (CardLayout)workArea.getLayout();
        layout.previous(workArea);
        ViewProductDetailJPanel vpdjp = new ViewProductDetailJPanel(workArea, product);
        workArea.add("ViewProductDetailJPanelSupplier" + vpdjp.toString(), vpdjp);
        layout = (CardLayout) workArea.getLayout();
        layout.next(workArea);
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        workArea.remove(this);
        CardLayout layout = (CardLayout)workArea.getLayout();
        layout.previous(workArea);
    }

    private javax.swing.JTextField idField;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel lblProductId;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JButton searchButton;
}
