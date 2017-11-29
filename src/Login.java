import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login {
    private JFrame logFrame= new JFrame("Login");
    private JPanel logPanel = new JPanel();
    private JPanel un = new JPanel();
    private JPanel ps = new JPanel();
    private JLabel fms = new JLabel("FACILITY MANAGEMENT SYSTEM",JLabel.CENTER);
    private JLabel userName = new JLabel("User Name: ",JLabel.CENTER);
    private JLabel passWord = new JLabel("Password: ",JLabel.CENTER);
    private JLabel Empty = new JLabel("");
    private JLabel Empty1 = new JLabel("");
    private JLabel Empty2 = new JLabel("");
    private JTextField usernameField = new JFormattedTextField();
    private JPasswordField passwordField = new JPasswordField();
    private JButton login = new JButton("LOGIN");
    public void GUI()
    {
        logPanel.setLayout(new GridLayout(7,1,0,0));
        logPanel.setBackground(Color.WHITE);
        un.setLayout(new GridLayout(1,2,0,0));
        un.setBackground(Color.WHITE);
        ps.setLayout(new GridLayout(1,2,0,0));
        ps.setBackground(Color.WHITE);
        fms.setFont(new Font("Monospaced",Font.BOLD,35));
        fms.setForeground(Color.RED);
        userName.setFont(new Font("Monospaced",Font.BOLD,32));
        passWord.setFont(new Font("Monospaced",Font.BOLD,32));
        logPanel.add(fms);
        logPanel.add(Empty);
        un.add(userName);
        un.add(usernameField);
        logPanel.add(un);
        logPanel.add(Empty1);
        ps.add(passWord);
        ps.add(passwordField);
        logPanel.add(ps);
        logPanel.add(Empty2);
        login.setBackground(Color.WHITE);
        login.setForeground(Color.GREEN);
        login.setBorder(new LineBorder(Color.WHITE));
        login.setFont(new Font("Monospaced",Font.BOLD,30));
        logPanel.add(login);
        logFrame.add(logPanel);
        logFrame.setSize(700,450);
        logFrame.setVisible(true);
        login.setActionCommand("Login");
        login.addActionListener(new LogButtonListener());

    }
    private class LogButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            String command = e.getActionCommand();
            int foundStaff=0,pending=0,adminLoggedIn=0,foundSupervisor=0;
            if(command.equals("Login"))
            {
                String user = usernameField.getText();
                String pw = passwordField.getText();


                if (user.equals("admin") && pw.equals("admin"))
                {
                    adminLoggedIn=1;
                    logFrame.setVisible(false);
                    Admin admin = new Admin();
                    admin.GUI();
                }
                for (int i=0;i<pendingReq.pendingPersons.size();i++)
                {
                    if (user.equals(pendingReq.pendingPersons.get(i).getUsername()))
                    {
                        pending=1;
                        logFrame.setVisible(false);
                        JOptionPane.showMessageDialog(null,"Wait for Admin's Approval");
                        LoginRegisterGUI.loginRegister.setVisible(true);
                        Admin admin = new Admin();
                        admin.GUI();
                    }
                }

                System.out.println(user);
                for (int i=0;i<Database.DatabaseStaff.size();i++)
                {
                    System.out.println(Database.DatabaseStaff.get(i).getUsername());
                    if (user.equals(Database.DatabaseStaff.get(i).getUsername()))
                    {
                        foundStaff=1;
                        if (!pw.equals(Database.DatabaseStaff.get(i).getPassword()))
                        {
                            JOptionPane.showMessageDialog(null,"Wrong Password !!!");
                            logFrame.setVisible(false);
                            LoginRegisterGUI.loginRegister.setVisible(true);
                        }
                        else
                        {
                            Staff S = new Staff();
                            S.GUI(Database.DatabaseStaff.get(i));
                            logFrame.setVisible(false);

                        }
                    }
                }


                for (int i=0;i<Database.DatabaseSupervisor.size();i++)
                {
                    if (user.equals(Database.DatabaseSupervisor.get(i).getUsername()))
                    {
                        foundSupervisor=1;
                        if (!pw.equals(Database.DatabaseSupervisor.get(i).getPassword()))
                        {
                            JOptionPane.showMessageDialog(null,"Wrong Password !!!");
                            logFrame.setVisible(false);
                            LoginRegisterGUI.loginRegister.setVisible(true);
                        }
                        else
                        {
                            Supervisor Su = new Supervisor();
                            Su.GUI(Database.DatabaseSupervisor.get(i));
                            logFrame.setVisible(false);

                        }
                    }
                }


                if (foundStaff==0 && pending==0 && adminLoggedIn==0 && foundSupervisor==0)
                {
                    JOptionPane.showMessageDialog(null,"User doesn't exist !!!");
                    logFrame.setVisible(false);
                    LoginRegisterGUI.loginRegister.setVisible(true);
                }

            }
        }
    }

}
