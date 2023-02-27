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
        frame.setSize(500, 500);
        frame.setLocationRelativeTo(frame);
        frame.setLayout(new BorderLayout());
        panels = addPanels();
        frame.add(panels[0]);
        lookUpBtn.addActionListener(this);
        frame.setVisible(true);
    }

    public JPanel[] addPanels() {
        panels = new JPanel[4];

        for (int i = 0; i < panels.length; i++) {
            panels[i] = new JPanel();
        }

        labels = addJLabel();

        panels[0].setPreferredSize(new Dimension(500, 460));
        panels[0].setBackground(Color.black);
        panels[0].add(panels[1], BorderLayout.NORTH);
        panels[0].add(panels[2], BorderLayout.CENTER);
        panels[0].add(panels[3], BorderLayout.SOUTH);

        panels[1].setPreferredSize(new Dimension(500, 50));
        panels[1].add(labels[0]);

        GridBagConstraints gbc = new GridBagConstraints();

        panels[2].setPreferredSize(new Dimension(500, 200));
        panels[2].setLayout(new GridBagLayout());
        gbc.insets = new Insets(25, 0, 35, 0);
        gbc.gridx = 0;
        gbc.gridy = 0;
        panels[2].add(textField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        panels[2].add(lookUpBtn, gbc);

        panels[3].setPreferredSize(new Dimension(500, 250));
        panels[3].setBackground(Color.red);
        panels[3].setLayout(new GridBagLayout());

        // gbc.insets = new Insets(0, 0, 0, 0);

        return panels;
    }

    public JLabel[] addJLabel() {
        // String[] labelStr = { "Look Up IP Addresses for infor with a host name" };
        labels = new JLabel[3];

        for (int i = 0; i < labels.length; i++) {
            labels[i] = new JLabel();
        }
        labels[0] = new JLabel("Look Up IP Addresses for infor with a host name");
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
              
         
        labels = addJLabel();
        if (e.getSource() == lookUpBtn) {
            try {
                address = InetAddress.getByName(hostname);
               
                System.out.println("Host by IP address: " + address);
                panels = addPanels();
                
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
             gbc.gridx = 0;
                gbc.gridy = 0;
                labels[1].setText("IP Address" + address);
                panels[3].add(labels[1], gbc);

        }
    }

}
