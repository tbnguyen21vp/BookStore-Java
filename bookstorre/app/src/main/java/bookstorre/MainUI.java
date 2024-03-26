package bookstorre;

import javax.swing.*;
import java.awt.FlowLayout;

public class MainUI extends JFrame {
    public MainUI() {
        setTitle("Component Tổng");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Tạo một JPanel để làm component tổng
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new FlowLayout()); // Đặt layout manager cho panel tổng

        // Tạo các component con và thêm vào panel tổng
        JButton button1 = new JButton("Button 1");
        mainPanel.add(button1);

        JButton button2 = new JButton("Button 2");
        mainPanel.add(button2);

        JTextField textField = new JTextField(20);
        mainPanel.add(textField);

        // Thêm panel tổng vào frame
        getContentPane().add(mainPanel);

        pack();
        setLocationRelativeTo(null); // Hiển thị frame ở giữa màn hình
    }

  
    
}
