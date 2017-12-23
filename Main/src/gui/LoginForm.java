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

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onRegister();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    private void onLogin() {
        if (!tfUsername.getText().equals("")) {
            if (!tfUsername.getText().trim().contains(" ")) {

            } else {
                lblError.setText("<html><color=\"red\">Error: Username may not contain any space chars</html>");
            }
        } else {
            lblError.setText("<html><color=\"red\">Error: Please fill in a username!</html>");
        }

        dispose();
    }

    private void onRegister() {
        dispose();
    }

    public static void main(String[] args) {
        LoginForm dialog = new LoginForm();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
