package gui;

import javax.swing.*;
import java.awt.event.*;

public class LoginForm extends JDialog {
    private JPanel contentPane;
    private JButton buttonLogin;
    private JButton buttonRegister;
    private JPasswordField pfPassword;
    private JTextField tfUsername;
    private JLabel lblError;

    public LoginForm() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonLogin);

        buttonLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onLogin();
            }
        });

        buttonRegister.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onRegister();
            }
        });

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    private void onLogin() {
        if (!tfUsername.getText().trim().equals("")) {
            if (!tfUsername.getText().trim().contains(" ")) {
                // TODO: open game
                dispose();
            } else {
                lblError.setText("<html><color=\"red\">Error: Username may not contain any space chars</html>");
            }
        } else {
            lblError.setText("<html><color=\"red\">Error: Please fill in a username!</html>");
        }
    }

    private void onRegister() {
        if (!tfUsername.getText().trim().equals("")) {
            if (!tfUsername.getText().trim().contains(" ")) {
                if (!pfPassword.getPassword().toString().trim().equals("")) {
                    if (!pfPassword.getPassword().toString().trim().contains(" ")) {
                        // TODO: if player does not exist yet, add to database, open game
                        dispose();
                    }
                }
            } else {
                lblError.setText("<html><color=\"red\">Error: Username may not contain any space chars</html>");
            }
        } else {
            lblError.setText("<html><color=\"red\">Error: Please fill in a username!</html>");
        }
    }

    public static void main(String[] args) {
        LoginForm dialog = new LoginForm();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
