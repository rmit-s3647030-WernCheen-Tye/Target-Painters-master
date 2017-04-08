package sef.supermarketsupport;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
 
public class LoginDialog extends JDialog {
 
    private JTextField tfAccount;
    private JPasswordField pfPassword;
    private JLabel lbAccount;
    private JLabel lbPassword;
    private JButton btnLogin;
    private JButton btnCancel;
    private boolean succeeded;
 
    public LoginDialog(Frame parent) {
        super(parent, "Login", true);
        //
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints cs = new GridBagConstraints();
 
        cs.fill = GridBagConstraints.HORIZONTAL;
 
        lbAccount = new JLabel("Account: ");
        cs.gridx = 0;
        cs.gridy = 0;
        cs.gridwidth = 1;
        panel.add(lbAccount, cs);
 
        tfAccount = new JTextField(20);
        cs.gridx = 1;
        cs.gridy = 0;
        cs.gridwidth = 2;
        panel.add(tfAccount, cs);
 
        lbPassword = new JLabel("Password: ");
        cs.gridx = 0;
        cs.gridy = 1;
        cs.gridwidth = 1;
        panel.add(lbPassword, cs);
 
        pfPassword = new JPasswordField(20);
        cs.gridx = 1;
        cs.gridy = 1;
        cs.gridwidth = 2;
        panel.add(pfPassword, cs);
        panel.setBorder(new LineBorder(Color.GRAY));
 
        btnLogin = new JButton("Login");
 
        btnLogin.addActionListener(e -> {
        	Account acc = Login.authenticate(getAccount(), getPassword());
            if (acc != null) {
                JOptionPane.showMessageDialog(LoginDialog.this,
                        "Hi " + getAccount() + "! You have successfully logged in.",
                        "Login",
                        JOptionPane.INFORMATION_MESSAGE);
                succeeded = true;
                dispose();
            } else {
                JOptionPane.showMessageDialog(LoginDialog.this,
                        "Invalid Account or password",
                        "Login",
                        JOptionPane.ERROR_MESSAGE);
                // reset Account and password
                tfAccount.setText("");
                pfPassword.setText("");
                    succeeded = false;
 
                }
        });
        btnCancel = new JButton("Cancel");
        btnCancel.addActionListener(new ActionListener() {
 
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        JPanel bp = new JPanel();
        bp.add(btnLogin);
        bp.add(btnCancel);
 
        getContentPane().add(panel, BorderLayout.CENTER);
        getContentPane().add(bp, BorderLayout.PAGE_END);
 
        pack();
        setResizable(false);
        setLocationRelativeTo(parent);
    }
 
    public String getAccount() {
        return tfAccount.getText().trim();
    }
 
    public String getPassword() {
        return new String(pfPassword.getPassword());
    }
 
    public boolean isSucceeded() {
        return succeeded;
    }
}