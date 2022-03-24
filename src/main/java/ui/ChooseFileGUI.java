package ui;

import bundles.IBundle;
import com.formdev.flatlaf.FlatDarculaLaf;
import com.formdev.flatlaf.FlatLightLaf;
import logic.Game;
import logic.LogLoader;
import preferences.LanguagePreferences;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.util.Locale;
import java.util.Objects;
import java.util.ResourceBundle;

public class ChooseFileGUI extends JFrame {
    private String currentPath;
    private Game game;
    private IBundle bundle;
    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JButton chooseFileButton;
    private JButton startGameButton;
    private JLabel questionLabel;
    private JSlider numberSlider;
    private JLabel numberLabel;
    private JComboBox<String> languageBox;
    // JFormDesigner - End of variables declaration  //GEN-END:variables

    public ChooseFileGUI() {
        initComponents();
        languageBox.addItem("EN");
        languageBox.addItem("PL");
        languageBox.setSelectedItem(LanguagePreferences.getPreferences());
        setupLanguage();

        chooseFileButton.addActionListener(e -> {
            currentPath = chooseDirectory();
            if (currentPath != null) {
                LogLoader.loadNamesFromFile(currentPath);
                startGameButton.setEnabled(true);
                numberSlider.setEnabled(true);
                numberSlider.setMaximum(LogLoader.getQueueSize());
                numberSlider.setValue(LogLoader.getQueueSize());
                numberSlider.setMinimum(1);
                game = new Game();
            }

        });

        startGameButton.addActionListener(e -> {
            game.setNumberOfQuestions(numberSlider.getValue());
            new GameGUI(game, bundle, languageBox.getSelectedIndex());
            dispose();
        });

        numberSlider.addChangeListener(e -> numberLabel.setText(String.valueOf(numberSlider.getValue())));
        languageBox.addItemListener(e -> setupLanguage());

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }


    public static void main(String[] args) {
        FlatLightLaf.setup();
        try {
            UIManager.setLookAndFeel(new FlatDarculaLaf());
        } catch (Exception ex) {
            System.err.println("Failed to initialize LaF");
        }
        new ChooseFileGUI();
    }

    private String chooseDirectory() {
        try {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.removeChoosableFileFilter(fileChooser.getFileFilter());
            fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("*.txt", "txt"));
            fileChooser.showSaveDialog(null);
            return fileChooser.getSelectedFile().toString();
        } catch (NullPointerException exp) {
            JOptionPane.showMessageDialog(new JFrame(), bundle.getString("ChooseDirError"));
        }
        return null;
    }

    private void setupLanguage() {
        String selected = Objects.requireNonNull(languageBox.getSelectedItem()).toString();
        Locale locale = new Locale(selected.toLowerCase(), selected);
        bundle = (IBundle) ResourceBundle.getBundle("bundles.Bundle", locale);
        chooseFileButton.setText(bundle.getString("FileButton"));
        startGameButton.setText(bundle.getString("StartButton"));
        questionLabel.setText(bundle.getString("QuestionLabel"));
        LanguagePreferences.setPreferences(selected);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        chooseFileButton = new JButton();
        startGameButton = new JButton();
        JLabel label1 = new JLabel();
        questionLabel = new JLabel();
        numberSlider = new JSlider();
        numberLabel = new JLabel();
        languageBox = new JComboBox<>();

        //======== this ========
        setResizable(false);
        setIconImage(new ImageIcon(Objects.requireNonNull(getClass().getResource("/appIcon2.png"))).getImage());
        var contentPane = getContentPane();

        //---- chooseFileButton ----
        chooseFileButton.setText("Choose file");

        //---- startGameButton ----
        startGameButton.setText("Start");
        startGameButton.setEnabled(false);
        startGameButton.addActionListener(this::startGame);

        //---- label1 ----
        label1.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("/appIcon2.png"))));
        label1.setHorizontalAlignment(SwingConstants.CENTER);

        //---- questionLabel ----
        questionLabel.setText("text");

        //---- numberSlider ----
        numberSlider.setEnabled(false);
        numberSlider.setValue(0);

        //---- numberLabel ----
        numberLabel.setText("0");

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
                contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                                .addGap(69, 69, 69)
                                .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addComponent(numberSlider, GroupLayout.PREFERRED_SIZE, 258, GroupLayout.PREFERRED_SIZE)
                                        .addGroup(contentPaneLayout.createSequentialGroup()
                                                .addComponent(chooseFileButton, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(startGameButton, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE))
                                        .addComponent(questionLabel, GroupLayout.PREFERRED_SIZE, 252, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(numberLabel)
                                .addContainerGap(54, Short.MAX_VALUE))
                        .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(languageBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                                .addComponent(label1, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE)
                                .addGap(137, 137, 137))
        );
        contentPaneLayout.setVerticalGroup(
                contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(contentPaneLayout.createParallelGroup()
                                        .addComponent(label1, GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(languageBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(contentPaneLayout.createParallelGroup()
                                        .addComponent(startGameButton, GroupLayout.Alignment.TRAILING)
                                        .addComponent(chooseFileButton, GroupLayout.Alignment.TRAILING))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(questionLabel)
                                .addGap(2, 2, 2)
                                .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(numberSlider, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(numberLabel))
                                .addContainerGap(2, Short.MAX_VALUE))
        );
        setSize(395, 265);
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    private void startGame(ActionEvent e) {
    }
}
