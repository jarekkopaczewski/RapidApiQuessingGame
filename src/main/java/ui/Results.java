package ui;

import javax.swing.*;

public class Results extends JFrame {
    private JLabel correctLabel;
    private JLabel wrongLabel;

    public Results(int correct, int wrong) {
        initComponents();
        correctLabel.setText(String.valueOf(correct));
        wrongLabel.setText(String.valueOf(wrong));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
        JLabel crct = new JLabel();
        JLabel wrng = new JLabel();
        correctLabel = new JLabel();
        wrongLabel = new JLabel();

        //======== this ========
        setResizable(false);
        var contentPane = getContentPane();

        //---- crct ----
        crct.setIcon(new ImageIcon(getClass().getResource("/correct.png")));
        crct.setHorizontalAlignment(SwingConstants.CENTER);

        //---- wrng ----
        wrng.setIcon(new ImageIcon(getClass().getResource("/incorrect.png")));
        wrng.setHorizontalAlignment(SwingConstants.CENTER);

        //---- correctLabel ----
        correctLabel.setText("0");
        correctLabel.setFont(correctLabel.getFont().deriveFont(correctLabel.getFont().getSize() + 12f));
        correctLabel.setHorizontalAlignment(SwingConstants.CENTER);

        //---- wrongLabel ----
        wrongLabel.setText("0");
        wrongLabel.setFont(wrongLabel.getFont().deriveFont(wrongLabel.getFont().getSize() + 12f));
        wrongLabel.setHorizontalAlignment(SwingConstants.CENTER);

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
                contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(contentPaneLayout.createParallelGroup()
                                        .addComponent(crct, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(correctLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(8, 8, 8)
                                .addGroup(contentPaneLayout.createParallelGroup()
                                        .addComponent(wrongLabel, GroupLayout.DEFAULT_SIZE, 64, Short.MAX_VALUE)
                                        .addComponent(wrng, GroupLayout.DEFAULT_SIZE, 64, Short.MAX_VALUE))
                                .addContainerGap())
        );
        contentPaneLayout.setVerticalGroup(
                contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addComponent(crct, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(wrng, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addComponent(wrongLabel, GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
                                        .addComponent(correctLabel, GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE))
                                .addContainerGap(14, Short.MAX_VALUE))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }
}
