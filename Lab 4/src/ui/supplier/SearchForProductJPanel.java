package ui.supplier;

import model.Product;
import model.Supplier;
import java.awt.CardLayout;
import java.util.ArrayList;

import model.Feature;

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

        populateFeatureNameCombo();
    }

    private void initComponents() {
        lblTitle = new javax.swing.JLabel();
        lblProductId = new javax.swing.JLabel();
        idField = new javax.swing.JTextField();
        searchButton = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        lblProductName = new javax.swing.JLabel();
        nameField = new javax.swing.JTextField();
        searchButton2 = new javax.swing.JButton();
        lblFeature = new javax.swing.JLabel();
        cmbFeature = new javax.swing.JComboBox<Object>();
        lblValue = new javax.swing.JLabel();
        cmbValue = new javax.swing.JComboBox<Object>();
        searchButton3 = new javax.swing.JButton();

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

        lblProductName.setText("Product Name:");

        searchButton2.setText("Search Now >>");
        searchButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButton2ActionPerformed(evt);
            }
        });

        lblFeature.setText("Feature Name:");

        cmbFeature.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbFeatureActionPerformed(evt);
            }
        });

        lblValue.setText("Feature Value:");

        searchButton3.setText("Search Now >>");
        searchButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblProductName)
                    .addComponent(lblProductId)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(37, 37, 37)
                        .addComponent(lblTitle))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(idField, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cmbFeature, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblFeature))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cmbValue, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblValue))))
                        .addGap(47, 47, 47)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(searchButton3)
                            .addComponent(searchButton)
                            .addComponent(searchButton2))))
                .addContainerGap(315, Short.MAX_VALUE))
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
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblProductName)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(searchButton2))
                        .addGap(18, 18, 18)
                        .addComponent(lblFeature)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbFeature, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblValue)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmbValue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(searchButton3))))
                .addContainerGap(62, Short.MAX_VALUE))
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
        CardLayout layout = (CardLayout) workArea.getLayout();
        layout.previous(workArea);
        ViewProductDetailJPanel vpdjp = new ViewProductDetailJPanel(workArea, product);
        workArea.add("ViewProductDetailJPanelSupplier" + vpdjp.toString(), vpdjp);
        layout = (CardLayout) workArea.getLayout();
        layout.next(workArea);
    }

    private void searchButton2ActionPerformed(java.awt.event.ActionEvent evt) {
        String name = nameField.getText();
        if (name.isBlank()) {
            JOptionPane.showMessageDialog(this, "Please enter the product name", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Product product = supplier.getProductCatalog().searchByName(name);
        if (product == null) {
            JOptionPane.showMessageDialog(this, "Product not found", "Information", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        workArea.remove(this);
        CardLayout layout = (CardLayout) workArea.getLayout();
        layout.previous(workArea);
        ViewProductDetailJPanel vpdjp = new ViewProductDetailJPanel(workArea, product);
        workArea.add("ViewProductDetailJPanelSupplier" + vpdjp.toString(), vpdjp);
        layout = (CardLayout) workArea.getLayout();
        layout.next(workArea);
    }

    private void searchButton3ActionPerformed(java.awt.event.ActionEvent evt) {
        if (cmbFeature.getSelectedItem() == null || cmbValue.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(this, "Please select a feature and value", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String feature = (String) cmbFeature.getSelectedItem();
        Object value = cmbValue.getSelectedItem();
        Product product = supplier.getProductCatalog().searchByFeature(feature, value);
        if (product == null) {
            JOptionPane.showMessageDialog(this, "Product not found", "Information", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        workArea.remove(this);
        CardLayout layout = (CardLayout) workArea.getLayout();
        layout.previous(workArea);
        ViewProductDetailJPanel vpdjp = new ViewProductDetailJPanel(workArea, product);
        workArea.add("ViewProductDetailJPanelSupplier" + vpdjp.toString(), vpdjp);
        layout = (CardLayout) workArea.getLayout();
        layout.next(workArea);
    }

    private void cmbFeatureActionPerformed(java.awt.event.ActionEvent evt) {
        populateFeatureValueCombo((String) cmbFeature.getSelectedItem());
    }

    private void populateFeatureNameCombo() {
        cmbFeature.removeAllItems();
        ArrayList<String> featureList = new ArrayList<String>();

        for (Product product : supplier.getProductCatalog().getProductCatalog()) {
            for (Feature feature : product.getFeatures()) {
                if (!featureList.contains(feature.getName())) {
                    featureList.add(feature.getName());
                }
            }
        }

        for (String feature : featureList) {
            cmbFeature.addItem(feature);
        }
    }

    private void populateFeatureValueCombo(String feature) {
        cmbValue.removeAllItems();
        if (feature == null) {
            return;
        }

        ArrayList<Object> valueList = new ArrayList<Object>();

        for (Product product : supplier.getProductCatalog().getProductCatalog()) {
            for (Feature f : product.getFeatures()) {
                if (f.getName().equals(feature) && !valueList.contains(f.getValue())) {
                    valueList.add(f.getValue());
                }
            }
        }

        for (Object value : valueList) {
            cmbValue.addItem(value);
        }
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        workArea.remove(this);
        CardLayout layout = (CardLayout)workArea.getLayout();
        layout.previous(workArea);
    }

    private javax.swing.JComboBox<Object> cmbFeature;
    private javax.swing.JComboBox<Object> cmbValue;
    private javax.swing.JTextField idField;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel lblFeature;
    private javax.swing.JLabel lblProductId;
    private javax.swing.JLabel lblProductName;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblValue;
    private javax.swing.JTextField nameField;
    private javax.swing.JButton searchButton;
    private javax.swing.JButton searchButton2;
    private javax.swing.JButton searchButton3;
}
