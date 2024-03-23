package bookstorre;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Login extends JFrame {

    private JPanel contentPane;
    private final JButton btnNewButton;
    private final JLabel lblNewLabel_2;
    private final JTextField textField_1;
    private final JLabel lblNewLabel_3;
    private final JTextField textField_2;
    private final JLabel lblTitle;

    public Login() {
        setTitle("ĐĂNG NHẬP TÀI KHOẢN");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        GridBagLayout gbl_contentPane = new GridBagLayout();
        contentPane.setLayout(gbl_contentPane);

        lblTitle = new JLabel("Đăng Nhập");
        GridBagConstraints gbc_lblTitle = new GridBagConstraints();
        gbc_lblTitle.gridwidth = 2;
        gbc_lblTitle.insets = new Insets(0, 0, 10, 0);
        gbc_lblTitle.gridx = 0;
        gbc_lblTitle.gridy = 0;
        gbc_lblTitle.anchor = GridBagConstraints.CENTER;
        contentPane.add(lblTitle, gbc_lblTitle);

        lblNewLabel_2 = new JLabel("Email:");
        GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
        gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
        gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel_2.gridx = 0;
        gbc_lblNewLabel_2.gridy = 1;
        contentPane.add(lblNewLabel_2, gbc_lblNewLabel_2);

        textField_1 = new JTextField();
        GridBagConstraints gbc_textField_1 = new GridBagConstraints();
        gbc_textField_1.insets = new Insets(0, 0, 5, 0);
        gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
        gbc_textField_1.gridx = 1;
        gbc_textField_1.gridy = 1;
        contentPane.add(textField_1, gbc_textField_1);
        textField_1.setColumns(10);

        
        lblNewLabel_3 = new JLabel("Mật khẩu:");
        GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
        gbc_lblNewLabel_3.anchor = GridBagConstraints.EAST;
        gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel_3.gridx = 0;
        gbc_lblNewLabel_3.gridy = 2;
        contentPane.add(lblNewLabel_3, gbc_lblNewLabel_3);

        textField_2 = new JTextField();
        GridBagConstraints gbc_textField_2 = new GridBagConstraints();
        gbc_textField_2.insets = new Insets(0, 0, 5, 0);
        gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
        gbc_textField_2.gridx = 1;
        gbc_textField_2.gridy = 2;
        contentPane.add(textField_2, gbc_textField_2);
        textField_2.setColumns(10);

        btnNewButton = new JButton("ĐĂNG NHẬP");
        GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
        gbc_btnNewButton.gridwidth = 2;
        gbc_btnNewButton.insets = new Insets(10, 0, 0, 0);
        gbc_btnNewButton.gridx = 0;
        gbc_btnNewButton.gridy = 3;
        gbc_btnNewButton.anchor = GridBagConstraints.CENTER;
        contentPane.add(btnNewButton, gbc_btnNewButton);
    }

    // public static void main(String[] args) {
    //     java.awt.EventQueue.invokeLater(new Runnable() {
    //         public void run() {
    //             new Login().setVisible(true);
    //         }
    //     });
    // }
}
