import java.net.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LookUp extends JFrame implements ActionListener {
    JFrame frame = new JFrame();
    private JPanel[] panels = null;
    private JTextField textField = new JTextField(15);
    private JLabel labels[] = null;
    private JButton lookUpBtn = new JButton("Look Up");
    private ButtonGroup buttonGroup = null;
    private JRadioButton[] radio = null;

    public LookUp() {
        frame.setSize(930, 590);
        frame.setResizable(false);
        frame.setLocationRelativeTo(frame);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());
        panels = addPanels();
        frame.add(panels[0]);
        frame.add(panels[1]);

        lookUpBtn.addActionListener(this);
        frame.setVisible(true);
    }

    public JPanel[] addPanels() {
        panels = new JPanel[7];

        for (int i = 0; i < panels.length; i++) {
            panels[i] = new JPanel();
        }

        labels = addJLabel();
        radio = addRadioButtons();

        panels[0].setPreferredSize(new Dimension(500, 550));
        panels[0].setBackground(new Color(148, 148, 156));
        panels[0].setLayout(new GridBagLayout());
        labels[5].setIcon(new ImageIcon("world.png"));
        panels[0].add(labels[5]);

        panels[1].setPreferredSize(new Dimension(400, 550));
        panels[1].setLayout(new BorderLayout());

        panels[1].add(panels[2], BorderLayout.NORTH);
        panels[1].add(panels[3], BorderLayout.CENTER);
        panels[1].add(panels[4], BorderLayout.SOUTH);

        /***************** Top Panel on the Right */
        panels[2].add(labels[0]);

        panels[2].setPreferredSize(new Dimension(400, 100));
        panels[2].setLayout(new GridBagLayout());
        panels[2].setBackground(new Color(62, 62, 90));
        labels[0].setFont(new Font("TimesRoman", Font.BOLD, 17));

        /***************** Center Panel on the Right */
        panels[3].setLayout(new BorderLayout());

        panels[3].setBackground(Color.green);
        panels[3].add(panels[5], BorderLayout.NORTH);
        panels[5].add(radio[0]);
        panels[5].add(radio[1]);
        panels[5].setBackground(new Color(62, 62, 90));

        panels[3].add(panels[6], BorderLayout.CENTER);

        // panels[6].add(labels)
        labels[6].setVisible(false);
        panels[6].add(labels[6]);

        textField.setVisible(false);
        panels[6].add(textField);
        panels[6].setBackground(new Color(62, 62, 90));
        textField.setFont(new Font("Times New Roman", Font.BOLD, 25));

        lookUpBtn.setVisible(false);
        panels[6].add(lookUpBtn);
        lookUpBtn.setPreferredSize(new Dimension(150, 45));

        /***************** South Panel on the Right */
        panels[4].setLayout(new GridBagLayout());
        panels[4].setBackground(new Color(62, 62, 90));
        panels[4].setBorder(BorderFactory.createLineBorder(Color.white));
        panels[4].setPreferredSize(new Dimension(400, 250));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(20, 0, 20, 0);
        gbc.gridx = 0;
        gbc.gridy = 0;
        panels[4].add(labels[1], gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        panels[4].add(labels[2], gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        panels[4].add(labels[3], gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        panels[4].add(labels[4], gbc);

        return panels;
    }

    public JLabel[] addJLabel() {
        String[] labelStr = { "Look Up IP Addresses with a host name: ", "Host Name: ", " - - - -",
                "IP Address: ", " - - - -", "", "Enter Host Name: E.g. Google.com" };

        labels = new JLabel[labelStr.length];

        for (int i = 0; i < labels.length; i++) {
            labels[i] = new JLabel(labelStr[i]);
            labels[i].setForeground(Color.WHITE);
        }

        return labels;
    }

    public JRadioButton[] addRadioButtons() {
        String[] radios = { "Local Host", "Remote Host" };
        radio = new JRadioButton[radios.length];
        buttonGroup = new ButtonGroup();

        for (int i = 0; i < radio.length; i++) {
            radio[i] = new JRadioButton(radios[i]);
            radio[i].setPreferredSize(new Dimension(150, 50));
            radio[i].setFont(new Font("TimesRoman", Font.BOLD, 15));
            radio[i].setOpaque(true);
            radio[i].setBackground(new Color(148, 148, 156));
            radio[i].addActionListener(this);
            radio[i].setForeground(new Color(243, 243, 243));
            radio[i].setEnabled(true);

            buttonGroup.add(radio[i]);
        }
        return radio;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String hostname = textField.getText();
        GridBagConstraints gbc = new GridBagConstraints();
        InetAddress address = null;

        try {

            address = InetAddress.getByName(hostname);
            if (radio[0].isSelected()) {
                labels[3].setVisible(false);
                labels[2].setText(String.valueOf(address.getLocalHost()));
                labels[4].setVisible(false);
                textField.setVisible(false);
                textField.setText(null);
                lookUpBtn.setVisible(false);
            } else {
                textField.setVisible(true);
                labels[2].setText(String.valueOf(address.getHostName()));
                labels[4].setText(String.valueOf(address.getHostAddress()));
                lookUpBtn.setVisible(true);
                labels[3].setVisible(true);
                labels[4].setVisible(true);
                labels[6].setVisible(true);
            }

            if (e.getSource() == lookUpBtn) {
                if (radio[1].isSelected()) {
                    labels[2].setText(String.valueOf(address.getHostName()));
                    labels[4].setText(String.valueOf(address.getHostAddress()));
                }

            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Invalid Host");
            System.out.println(ex.getMessage());

        }
    }

    public static void main(String[] args) throws UnknownHostException {
        new LookUp();
    }

}
