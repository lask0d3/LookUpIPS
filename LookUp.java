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

    private JRadioButton[] radio = null;

    public LookUp() {
        frame.setSize(930, 590);
        frame.setLocationRelativeTo(frame);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());
        panels = addPanels();
        frame.add(panels[0]);
        frame.add(panels[1]);

        // frame.add(panels[0], BorderLayout.WEST);
        // frame.add(panels[1], BorderLayout.NORTH);
        // frame.add(panels[2], BorderLayout.CENTER);
        // frame.add(panels[3], BorderLayout.SOUTH);

        lookUpBtn.addActionListener(this);
        frame.setVisible(true);
    }

    public JPanel[] addPanels() {
        panels = new JPanel[7];

        for (int i = 0; i < panels.length; i++) {
            panels[i] = new JPanel();
            // frame.add(panels[i]);
        }

        labels = addJLabel();
        radio = addRadioButtons();

        // panels[0].
        // panels[0].getHeight();
        // panels[0].setPreferredSize(new Dimension(1000, 1000));

        panels[0].setPreferredSize(new Dimension(500, 550));
        panels[0].setBackground(Color.white);
        panels[0].setLayout(new GridBagLayout());
        labels[9].setIcon(new ImageIcon("world.png"));
        panels[0].add(labels[9]);

        panels[1].setPreferredSize(new Dimension(400, 550));
        panels[1].setBackground(Color.red);
        panels[1].setLayout(new BorderLayout());

        panels[1].add(panels[2], BorderLayout.NORTH);
        panels[1].add(panels[3], BorderLayout.CENTER);
        panels[1].add(panels[4], BorderLayout.SOUTH);

        /***************** Top Panel on the Right */
        panels[2].add(labels[0]);
        panels[2].setPreferredSize(new Dimension(400, 100));
        panels[2].setLayout(new GridBagLayout());
        panels[2].setBackground(Color.red);
        labels[0].setFont(new Font("TimesRoman", Font.BOLD, 17));

        /***************** Center Panel on the Right */
        panels[3].setLayout(new BorderLayout());
        
        panels[3].setBackground(Color.green);
        panels[3].add(panels[5], BorderLayout.NORTH);
        panels[5].add(radio[0]);
        panels[5].add(radio[1]);
        panels[5].setBackground(Color.green);

        panels[3].add(panels[6], BorderLayout.CENTER);

        panels[6].add(textField);
        panels[6].setBackground(Color.yellow);
        textField.setFont(new Font("Times New Roman", Font.BOLD, 25));

        panels[6].add(lookUpBtn);
        lookUpBtn.setPreferredSize(new Dimension(150, 45));

        /***************** South Panel on the Right */
        panels[4].setLayout(new GridBagLayout());
         panels[4].setBackground(Color.blue);
          panels[4].setPreferredSize(new Dimension(400, 275));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets= new Insets(20, 0, 20, 0);
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

        // gbc.gridx = 0;
        // gbc.gridy = 2;
        // panels[4].add(labels[5], gbc);

        // gbc.gridx = 1;
        // gbc.gridy = 2;
        // panels[4].add(labels[6], gbc);

        return panels;
    }

    public JLabel[] addJLabel() {
    String[] labelStr = {"Look Up IP Addresses for infor with a host name: ", "Host Name: ",  " - - - -", "IP Address: ", " - - - -", "Host Address: ", " - - - -", "IP Address: ", " - - - -", null};

        labels = new JLabel[10];

        for (int i = 0; i < labels.length; i++) {
            labels[i] = new JLabel(labelStr[i]);
        }

        return labels;
    }

    public JRadioButton[] addRadioButtons() {
        String[] radStrings = { "Local Host", "External Host" };
        radio = new JRadioButton[radStrings.length];
        ButtonGroup buttonGroup = new ButtonGroup();
        for (int i = 0; i < radio.length; i++) {
            radio[i] = new JRadioButton(radStrings[i]);
            buttonGroup.add(radio[i]);
            radio[i].setPreferredSize(new Dimension(150, 50));
            radio[i].addActionListener(this);
            radio[i].setSelected(true);
            radio[i].setFont(new Font("Arial", Font.BOLD, 15));
            radio[i].setOpaque(true);
        }
        return radio;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String hostname = textField.getText();
        GridBagConstraints gbc = new GridBagConstraints();
        InetAddress address = null;

        if (e.getSource() == lookUpBtn) {

            try {
                address = InetAddress.getByName(hostname);
                labels[2].setText(String.valueOf(address.getHostName()));
                labels[4].setText(String.valueOf(address.getHostAddress()));
                // labels[6].setText(String.valueOf(address));

                System.out.println("Host by IP address: " + address);

            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }

        }
    }

    public static void main(String[] args) throws UnknownHostException {
        new LookUp();
    }

}
