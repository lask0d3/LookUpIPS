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
        panels = new JPanel[5];

        for (int i = 0; i < panels.length; i++) {
            panels[i] = new JPanel();
            // frame.add(panels[i]);
        }

        labels = addJLabel();
        // panels[0].
        // panels[0].getHeight();
        // panels[0].setPreferredSize(new Dimension(1000, 1000));

        panels[0].setPreferredSize(new Dimension(500, 550));
        panels[0].setBackground(Color.white);
        panels[0].setLayout(new GridBagLayout());
        labels[7].setIcon(new ImageIcon("world.png"));
        panels[0].add(labels[7]);

        panels[1].setPreferredSize(new Dimension(400, 550));
        panels[1].setBackground(Color.red);
        panels[1].setLayout(new BorderLayout());

        panels[1].add(panels[2], BorderLayout.NORTH);
        panels[1].add(panels[3], BorderLayout.CENTER);
        panels[1].add(panels[4], BorderLayout.SOUTH);


        panels[2].add(labels[0]);
        panels[2].setPreferredSize(new Dimension(400, 50));
        panels[2].setLayout(new GridBagLayout());
        panels[2].setBackground(Color.red);
        labels[0].setFont(new Font("TimesRoman", Font.BOLD, 17));
        

        // GridBagConstraints gbc = new GridBagConstraints();

        // panels[2].setPreferredSize(new Dimension(500, 200));
        // panels[2].setBackground(Color.green);
        // panels[2].setLayout(new GridBagLayout());
        // gbc.insets = new Insets(25, 0, 35, 0);
        // gbc.gridx = 0;
        // gbc.gridy = 0;

        // panels[2].add(labels[7], gbc);

        // gbc.gridx = 0;
        // gbc.gridy = 1;
        // panels[2].add(lookUpBtn, gbc);

        // panels[3].setPreferredSize(new Dimension(500, 250));
        // panels[3].setBackground(Color.orange);
        // panels[3].setLayout(new GridBagLayout());

        // gbc.gridx = 0;
        // gbc.gridy = 0;
        // panels[3].add(labels[1], gbc);

        // gbc.gridx = 1;
        // gbc.gridy = 0;
        // panels[3].add(labels[2], gbc);

        // gbc.gridx = 0;
        // gbc.gridy = 1;
        // panels[3].add(labels[3], gbc);

        // gbc.gridx = 1;
        // gbc.gridy = 1;
        // panels[3].add(labels[4], gbc);

        // gbc.gridx = 0;
        // gbc.gridy = 2;
        // panels[3].add(labels[5], gbc);

        // gbc.gridx = 1;
        // gbc.gridy = 2;
        // panels[3].add(labels[6], gbc);

        // panels[4].setPreferredSize(new Dimension(200, 250));
        // panels[4].setBackground(Color.orange);
        // panels[4].add(labels[7]);

        return panels;
    }

    public JLabel[] addJLabel() {
        // String[] labelStr = { "Look Up IP Addresses for infor with a host name" };
        labels = new JLabel[8];

        for (int i = 0; i < labels.length; i++) {
            labels[i] = new JLabel();
        }
        labels[0] = new JLabel("Look Up IP Addresses for info with a host name");
        labels[1] = new JLabel("Host Name");
        labels[3] = new JLabel("IP Address");
        labels[5] = new JLabel("Host Address");
        return labels;
    }

    public static void main(String[] args) throws UnknownHostException {
        new LookUp();
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
                labels[6].setText(String.valueOf(address));

                System.out.println("Host by IP address: " + address);

            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }

        }
    }

}
