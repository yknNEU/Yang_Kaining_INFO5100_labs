package ui;

import javax.swing.*;
import java.awt.EventQueue;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import model.Product;

public class MainJFrame extends JFrame {

    Product product;

    public MainJFrame() {
        initComponents();
        this.product = new Product();
    }

    @SuppressWarnings("unchecked")

    private void initComponents() {
        splitPanel = new JSplitPane();
        controlPanel = new JPanel();
        btnCreate = new JButton();
        btnView = new JButton();
        workArea = new JPanel();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        btnCreate.setText("Create");
        btnCreate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnCreateActionPerformed(evt);
            }
        });

        btnView.setText("View");
        btnView.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnViewActionPerformed(evt);
            }
        });

        GroupLayout controlPanelLayout = new GroupLayout(controlPanel);
        controlPanel.setLayout(controlPanelLayout);
        controlPanelLayout.setHorizontalGroup(
            controlPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(controlPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(controlPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(btnCreate, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnView, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        controlPanelLayout.setVerticalGroup(
            controlPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(controlPanelLayout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(btnCreate)
                .addGap(44, 44, 44)
                .addComponent(btnView)
                .addContainerGap(148, Short.MAX_VALUE))
        );

        splitPanel.setLeftComponent(controlPanel);

        GroupLayout workAreaLayout = new GroupLayout(workArea);
        workArea.setLayout(workAreaLayout);
        workAreaLayout.setHorizontalGroup(
            workAreaLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 295, Short.MAX_VALUE)
        );
        workAreaLayout.setVerticalGroup(
            workAreaLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        splitPanel.setRightComponent(workArea);

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(splitPanel)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(splitPanel)
        );

        pack();
    }

    private void btnCreateActionPerformed(ActionEvent evt) {
        CreateJPanel createJPanel = new CreateJPanel(this.product);
        splitPanel.setRightComponent(createJPanel);
    }

    private void btnViewActionPerformed(ActionEvent evt) {
        ViewJPanel viewJPanel = new ViewJPanel(this.product);
        splitPanel.setRightComponent(viewJPanel);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainJFrame().setVisible(true);
            }
        });
    }

    private JButton btnCreate;
    private JButton btnView;
    private JPanel controlPanel;
    private JSplitPane splitPanel;
    private JPanel workArea;
}
