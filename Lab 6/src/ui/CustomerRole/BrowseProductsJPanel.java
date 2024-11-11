package ui.CustomerRole;

import model.MasterOrderList;
import model.Order;
import model.OrderItem;
import model.Product;
import model.Supplier;
import model.SupplierDirectory;

import java.awt.CardLayout;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

public class BrowseProductsJPanel extends javax.swing.JPanel {

    JPanel userProcessContainer;
    SupplierDirectory supplierDirectory;
    MasterOrderList masterOrderList;
    Order currentOrder; 

    /** Creates new form BrowseProducts */
    public BrowseProductsJPanel(JPanel userProcessContainer, SupplierDirectory supplierDirectory, MasterOrderList masterOrderList) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.supplierDirectory = supplierDirectory;
        this.masterOrderList = masterOrderList;
        this.currentOrder = new Order();
        populateCombo();
        populateProductTable();
        populateCartTable();
    }

    private void initComponents() {
        lblTitle = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();
        lblSupplier = new javax.swing.JLabel();
        cmbSupplier = new javax.swing.JComboBox();
        txtSearch = new javax.swing.JTextField();
        btnSearchProduct = new javax.swing.JButton();
        lblProductCatalogue = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProductCatalog = new javax.swing.JTable();
        lblSalesPrice = new javax.swing.JLabel();
        txtSalesPrice = new javax.swing.JTextField();
        lblQuantity = new javax.swing.JLabel();
        spnQuantity = new javax.swing.JSpinner();
        btnAddToCart = new javax.swing.JButton();
        btnProductDetails = new javax.swing.JButton();
        lblItemsInCart = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblCart = new javax.swing.JTable();
        txtNewQuantity = new javax.swing.JTextField();
        btnModifyQuantity = new javax.swing.JButton();
        btnViewOrderItem = new javax.swing.JButton();
        btnRemoveOrderItem = new javax.swing.JButton();
        btnCheckOut = new javax.swing.JButton();

        setBackground(new java.awt.Color(240, 240, 240));
        setPreferredSize(new java.awt.Dimension(650, 600));

        lblTitle.setBackground(new java.awt.Color(0, 0, 0));
        lblTitle.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(204, 0, 0));
        lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTitle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/logoPleaseBuySmall.png"))); // NOI18N
        lblTitle.setText("Have a wonderful shopping experience!");
        lblTitle.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        lblTitle.setIconTextGap(20);

        btnBack.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnBack.setText("<< Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        lblSupplier.setText("Supplier:");

        cmbSupplier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbSupplierActionPerformed(evt);
            }
        });

        btnSearchProduct.setText("Search Product");
        btnSearchProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchProductActionPerformed(evt);
            }
        });

        lblProductCatalogue.setText("Product Catalog:");

        tblProductCatalog.setFont(new java.awt.Font("Lucida Grande", 0, 13)); // NOI18N
        tblProductCatalog.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Name", "Product Id", "Price", "Avail"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblProductCatalog);

        lblSalesPrice.setText("Sales Price:");

        lblQuantity.setText("Quantity:");

        spnQuantity.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));

        btnAddToCart.setText("Add to Cart");
        btnAddToCart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddToCartActionPerformed(evt);
            }
        });

        btnProductDetails.setText("View Product Details");
        btnProductDetails.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProductDetailsActionPerformed(evt);
            }
        });

        lblItemsInCart.setText("Items in cart:");

        tblCart.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Item Name", "Price", "Quantity", "Total Amount"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblCart);

        btnModifyQuantity.setText("Modify Quantity");
        btnModifyQuantity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModifyQuantityActionPerformed(evt);
            }
        });

        btnViewOrderItem.setText("View Item");
        btnViewOrderItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewOrderItemActionPerformed(evt);
            }
        });

        btnRemoveOrderItem.setText("Remove");
        btnRemoveOrderItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveOrderItemActionPerformed(evt);
            }
        });

        btnCheckOut.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        btnCheckOut.setText("Check out");
        btnCheckOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCheckOutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(lblProductCatalogue)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(lblSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(cmbSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(btnSearchProduct))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(lblSalesPrice)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtSalesPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(lblQuantity)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(spnQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(btnAddToCart, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btnProductDetails, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 590, Short.MAX_VALUE)
                        .addComponent(lblItemsInCart)
                        .addComponent(jScrollPane2)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(btnModifyQuantity)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(txtNewQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnViewOrderItem)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(btnRemoveOrderItem)))
                    .addComponent(btnCheckOut, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(lblTitle)))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {spnQuantity, txtSalesPrice});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTitle)
                    .addComponent(btnBack))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearchProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblProductCatalogue)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnProductDetails)
                    .addComponent(lblSalesPrice)
                    .addComponent(txtSalesPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblQuantity)
                    .addComponent(spnQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAddToCart))
                .addGap(18, 18, 18)
                .addComponent(lblItemsInCart)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnViewOrderItem)
                    .addComponent(btnRemoveOrderItem)
                    .addComponent(btnModifyQuantity)
                    .addComponent(txtNewQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnCheckOut, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jScrollPane1, jScrollPane2});

    }

    private void cmbSupplierActionPerformed(java.awt.event.ActionEvent evt) {
        populateProductTable();
    }

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }

    private void btnAddToCartActionPerformed(java.awt.event.ActionEvent evt) {
        int selectedRowIndex = tblProductCatalog.getSelectedRow();
        if (selectedRowIndex < 0) {
            JOptionPane.showMessageDialog(this, "Please select a product first.", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        Product product = (Product) tblProductCatalog.getValueAt(selectedRowIndex, 0);
        double salesPrice = 0;
        int quantity = 0;
        try {
            salesPrice = Double.parseDouble(txtSalesPrice.getText());
            quantity = (Integer) spnQuantity.getValue();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Please check the price and quantity fields.", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (salesPrice < product.getPrice()) {
            JOptionPane.showMessageDialog(this, "Price should be more than it is set in the price.", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        OrderItem item = currentOrder.findProduct(product);

        if (item == null) {
            if (product.getAvail() >= quantity) {
                currentOrder.addNewOrderItem(product, quantity, salesPrice);
                product.setAvail(product.getAvail() - quantity);
            } else {
                JOptionPane.showMessageDialog(this, "Please check the product availability.", "Warning", JOptionPane.WARNING_MESSAGE);
                return;
            }
        } else {
            int oldQuantity = item.getQuantity();
            if (item.getProduct().getAvail() < quantity) {
                JOptionPane.showMessageDialog(this, "Please check the product availability.", "Warning", JOptionPane.WARNING_MESSAGE);
                return;
            } else {
                item.getProduct().setAvail(item.getProduct().getAvail() - quantity);
                item.setQuantity(oldQuantity + quantity);
            }
        }

        populateProductTable();
        populateCartTable();
    }

    private void btnProductDetailsActionPerformed(java.awt.event.ActionEvent evt) {
        int selectedRowIndex = tblProductCatalog.getSelectedRow();
        if (selectedRowIndex < 0) {
            JOptionPane.showMessageDialog(this, "Please select a product first.", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        Product product = (Product) tblProductCatalog.getValueAt(selectedRowIndex, 0);
        ViewProductDetailJPanel viewProductDetailJPanel = new ViewProductDetailJPanel(userProcessContainer, product);
        userProcessContainer.add("ViewProductDetailJPanel", viewProductDetailJPanel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }

    private void btnCheckOutActionPerformed(java.awt.event.ActionEvent evt) {
        masterOrderList.addOrder(currentOrder);
        currentOrder = new Order();

        populateCombo();
        populateProductTable();
        populateCartTable();

        txtNewQuantity.setText("");
        txtSalesPrice.setText("");
        txtSearch.setText("");
        spnQuantity.setValue(0);

        JOptionPane.showMessageDialog(this, "Thank you for your purchase. Looking forward to see you again!", "Information", JOptionPane.INFORMATION_MESSAGE);
    }

    private void btnModifyQuantityActionPerformed(java.awt.event.ActionEvent evt) {
        int selectedRowIndex = tblCart.getSelectedRow();
        if (selectedRowIndex < 0) {
            JOptionPane.showMessageDialog(this, "Please select the order item first.", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        OrderItem orderItem = (OrderItem) tblCart.getValueAt(selectedRowIndex, 0);
        int quantity = 0;
        try {
            quantity = Integer.parseInt(txtNewQuantity.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Please check the modified quantity field.", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }

        int oldQuantity = orderItem.getQuantity();
        if (orderItem.getProduct().getAvail() + oldQuantity < quantity) {
            JOptionPane.showMessageDialog(this, "Please check the product availability.", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        } 
        orderItem.getProduct().setAvail(orderItem.getProduct().getAvail() + oldQuantity - quantity);
        orderItem.setQuantity(quantity);
        populateProductTable();
        populateCartTable();
    }

    private void btnSearchProductActionPerformed(java.awt.event.ActionEvent evt) {
        String productName = txtSearch.getText();
        populateProductTable(productName);
    }

    private void btnRemoveOrderItemActionPerformed(java.awt.event.ActionEvent evt) {
        int selectedRowIndex = tblCart.getSelectedRow();
        if (selectedRowIndex < 0) {
            JOptionPane.showMessageDialog(this, "Please select the order item first.", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }

        OrderItem orderItem = (OrderItem) tblCart.getValueAt(selectedRowIndex, 0);
        orderItem.getProduct().setAvail(orderItem.getProduct().getAvail() + orderItem.getQuantity());
        currentOrder.deleteItem(orderItem);

        populateProductTable();
        populateCartTable();
    }

    private void btnViewOrderItemActionPerformed(java.awt.event.ActionEvent evt) {
        int selectedRowIndex = tblCart.getSelectedRow();
        if (selectedRowIndex < 0) {
            JOptionPane.showMessageDialog(this, "Please select the order item first.", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }

        OrderItem orderItem = (OrderItem) tblCart.getValueAt(selectedRowIndex, 0);
        ViewOrderItemDetailJPanel voidp = new ViewOrderItemDetailJPanel(userProcessContainer, orderItem);
        userProcessContainer.add("ViewOrderItemDetailJPanel", voidp);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }

    private void populateCombo() {
        cmbSupplier.removeAllItems();
        for (Supplier supplier : supplierDirectory.getSupplierList()) {
            cmbSupplier.addItem(supplier);
        }
    }

    private void populateProductTable() {
        Supplier supplier = (Supplier) cmbSupplier.getSelectedItem();
        if (supplier == null) {
            return;
        }
        DefaultTableModel dtm = (DefaultTableModel) tblProductCatalog.getModel();
        dtm.setRowCount(0);
        for (Product product : supplier.getProductCatalog().getProductcatalog()) {
            Object row[] = new Object[4];
            row[0] = product;
            row[1] = product.getModelNumber();
            row[2] = product.getPrice();
            row[3] = product.getAvail();
            dtm.addRow(row);
        }
    }

    public void populateCartTable() {
        DefaultTableModel dtm = (DefaultTableModel) tblCart.getModel();
        dtm.setRowCount(0);
        for (OrderItem orderItem : currentOrder.getOrderItemList()) {
            Object row[] = new Object[4];
            row[0] = orderItem;
            row[1] = orderItem.getSalesPrice();
            row[2] = orderItem.getQuantity();
            row[3] = orderItem.getQuantity() * orderItem.getSalesPrice();
            dtm.addRow(row);
        }
    }

    private void populateProductTable(String keyWord) {
        DefaultTableModel dtm = (DefaultTableModel) tblProductCatalog.getModel();
        dtm.setRowCount(0);
        for (Supplier supplier : supplierDirectory.getSupplierList()) {
            for (Product product : supplier.getProductCatalog().getProductcatalog()) {
                if (product.getProdName().equalsIgnoreCase(keyWord)) {
                    Object row[] = new Object[4];
                    row[0] = product;
                    row[1] = product.getModelNumber();
                    row[2] = product.getPrice();
                    row[3] = product.getAvail();
                    dtm.addRow(row);
                }
            }
        }
    }

    private javax.swing.JButton btnAddToCart;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnCheckOut;
    private javax.swing.JButton btnModifyQuantity;
    private javax.swing.JButton btnProductDetails;
    private javax.swing.JButton btnRemoveOrderItem;
    private javax.swing.JButton btnSearchProduct;
    private javax.swing.JButton btnViewOrderItem;
    private javax.swing.JComboBox cmbSupplier;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblItemsInCart;
    private javax.swing.JLabel lblProductCatalogue;
    private javax.swing.JLabel lblQuantity;
    private javax.swing.JLabel lblSalesPrice;
    private javax.swing.JLabel lblSupplier;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JSpinner spnQuantity;
    private javax.swing.JTable tblCart;
    private javax.swing.JTable tblProductCatalog;
    private javax.swing.JTextField txtNewQuantity;
    private javax.swing.JTextField txtSalesPrice;
    private javax.swing.JTextField txtSearch;
}
