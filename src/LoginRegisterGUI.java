import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginRegisterGUI {

    public static JFrame loginRegister = new JFrame("Login/Register");
    private JPanel LRPanel = new JPanel();
    private JPanel LRButtonPanel = new JPanel();
    private JButton Login = new JButton("LOGIN");
    private JButton Register = new JButton("REGISTER");
    private JLabel image = new JLabel();
    private JLabel Empty1 = new JLabel("");
    private JLabel Empty2 = new JLabel("");
    private JLabel Empty3 = new JLabel("");

    public void GUI()
    {
        LRPanel.setLayout(new GridLayout(1,2,15,0));
        LRPanel.setBackground(Color.WHITE);
        LRButtonPanel.setLayout(new GridLayout(5,1,0,0));
        LRButtonPanel.setBackground(Color.WHITE);
        Login.setFont(new Font("Monospaced",Font.BOLD,45));
        Register.setFont(new Font("Monospaced",Font.BOLD,45));
        Login.setBackground(Color.WHITE);
        Register.setBackground(Color.WHITE);
        Login.setForeground(Color.BLACK);
        Register.setForeground(Color.BLACK);
        Login.setBorder(new LineBorder(Color.WHITE));
        Register.setBorder(new LineBorder(Color.WHITE));
        LRButtonPanel.add(Empty1);
        LRButtonPanel.add(Login);
        LRButtonPanel.add(Empty2);
        LRButtonPanel.add(Register);
        LRButtonPanel.add(Empty3);
        image.setIcon(new ImageIcon("images/Logo.png"));
        LRPanel.add(image);
        LRPanel.add(LRButtonPanel);
        loginRegister.add(LRPanel);
        loginRegister.setSize(700,450);
        loginRegister.setVisible(true);
        Login.setActionCommand("Login");
        Register.setActionCommand("Register");
        Login.addActionListener(new SecondScreen());
        Register.addActionListener(new SecondScreen());

    }

    private class SecondScreen implements ActionListener
    {
        public void actionPerformed (ActionEvent e)
        {
            String command = e.getActionCommand();
            if (command.equals("Login"))
            {
                loginRegister.setVisible(false);
                Login L = new Login();
                L.GUI();
            }
            else
            {
                loginRegister.setVisible(false);
                Register R = new Register();
                R.GUI();

            }
        }
    }
}
