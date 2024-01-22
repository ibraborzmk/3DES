package Crypto.src;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InterfaceAcceuil {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Interface Cryptage");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        frame.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        JPanel topPanel = new JPanel();
        topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.Y_AXIS));
        JLabel topLabel = new JLabel("Veuillez choisire entre DES et 3DES", SwingConstants.CENTER);
        topLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        topPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        topPanel.add(topLabel);
        topPanel.add(Box.createRigidArea(new Dimension(0, 10)));

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weighty = 0.2;
        gbc.fill = GridBagConstraints.BOTH;
        frame.add(topPanel, gbc);

        JPanel panelContainer = new JPanel(new GridLayout(1, 2));

        ImageIcon image1 = new ImageIcon("Crypto/src/desim.gif");
        JLabel label1 = new JLabel("", image1, JLabel.CENTER);
        JPanel panel1 = new JPanel(new BorderLayout());
        panel1.add(label1, BorderLayout.CENTER);
        JButton button1 = new JButton("Cryptage en DES");
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        new Interface();
                    }
                });
            }
        });

        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel1.add(button1, BorderLayout.SOUTH);

        JPanel topPanel1 = new JPanel(new BorderLayout());
        JLabel topLabel1 = new JLabel("DES", SwingConstants.CENTER);
        topPanel1.add(topLabel1, BorderLayout.CENTER);
        panel1.add(topPanel1, BorderLayout.NORTH);
        panelContainer.add(panel1);

        ImageIcon image2 = new ImageIcon("Crypto/src/3desim.png");
        JLabel label2 = new JLabel("", image2, JLabel.CENTER);
        JPanel panel2 = new JPanel(new BorderLayout());
        panel2.add(label2, BorderLayout.CENTER);
        JButton button2 = new JButton("Cryptage en 3DES");
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        new Interface3();
                    }
                });
            }
        });

        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.weightx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel2.add(button2, BorderLayout.SOUTH);

        JPanel topPanel2 = new JPanel(new BorderLayout());
        JLabel topLabel2 = new JLabel("3DES", SwingConstants.CENTER);
        topPanel2.add(topLabel2, BorderLayout.CENTER);
        panel2.add(topPanel2, BorderLayout.NORTH);
        panelContainer.add(panel2);

        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weighty = 0.8;
        gbc.fill = GridBagConstraints.BOTH;
        frame.add(panelContainer, gbc);

        frame.setVisible(true);
    }
}
