import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Register {

    private JFrame regFrame = new JFrame("Register");
    private JPanel regPanel = new JPanel();
    private JPanel typeoptions = new JPanel();
    private JPanel dept1 = new JPanel();
    private JPanel dept2 = new JPanel();
    private JPanel u = new JPanel();
    private JPanel p = new JPanel();
    private JPanel n = new JPanel();
    private JPanel a = new JPanel();
    private JRadioButton Staff = new JRadioButton("Staff");
    private JRadioButton Supervisor = new JRadioButton("Supervisor");
    private JRadioButton electricity = new JRadioButton("Electricity");
    private JRadioButton hvac = new JRadioButton("HVAC");
    private JRadioButton audio = new JRadioButton("Audio/Video");
    private JRadioButton security = new JRadioButton("Security");
    private JRadioButton houseKeeping = new JRadioButton("House Keeping");
    private JLabel sysID = new JLabel ("   ID: ");
    private JLabel type = new JLabel  ("   TYPE: ");
    private JLabel dept = new JLabel  ("   DEPARTMENT: ");
    private JLabel usernameText = new JLabel("Username: ",JLabel.CENTER);
    private JLabel nameText = new JLabel("Name: ",JLabel.CENTER);
    private JLabel addressText = new JLabel("Address: ",JLabel.CENTER);
    private JLabel passwordText = new JLabel("Password: ",JLabel.CENTER);
    private JTextField name = new JFormattedTextField();
    private JTextField username = new JFormattedTextField();
    private JPasswordField password = new JPasswordField();
    private JTextField address = new JFormattedTextField();
    private JButton register = new JButton("REGISTER");
    private String Type;
    private String Department;
    private boolean stat=true;

    public void GUI()
    {
        layout();
        coloring();
        settingFont();
        ButtonGroup bg=new ButtonGroup();
        regPanel.add(sysID);
        n.add(nameText);
        n.add(name);
        regPanel.add(n);
        u.add(usernameText);
        u.add(username);
        regPanel.add(u);
        p.add(passwordText);
        p.add(password);
        regPanel.add(p);
        bg.add(Staff);
        bg.add(Supervisor);
        typeoptions.add(type);
        typeoptions.add(Staff);
        typeoptions.add(Supervisor);
        regPanel.add(typeoptions);
        a.add(addressText);
        a.add(address);
        regPanel.add(a);
        ButtonGroup bg1=new ButtonGroup();
        bg1.add(electricity);
        bg1.add(hvac);
        bg1.add(houseKeeping);
        bg1.add(audio);
        bg1.add(security);
        dept1.add(dept);
        dept1.add(electricity);
        dept1.add(hvac);
        dept2.add(houseKeeping);
        dept2.add(audio);
        dept2.add(security);
        regPanel.add(dept1);
        regPanel.add(dept2);
        regPanel.add(register);
        regFrame.add(regPanel);
        regFrame.setVisible(true);
        regFrame.setSize(750,450);
        register.setActionCommand("Register");
        register.addActionListener(new RegButtonListener());
    }

    private void layout()
    {
        regPanel.setLayout(new GridLayout(9,1,0,0));
        typeoptions.setLayout(new GridLayout(1,3,0,0));
        dept1.setLayout(new GridLayout(1,3,0,0));
        dept2.setLayout(new GridLayout(1,3,0,0));
        u.setLayout(new GridLayout(1,2,0,0));
        p.setLayout(new GridLayout(1,2,0,0));
        n.setLayout(new GridLayout(1,2,0,0));
        a.setLayout(new GridLayout(1,2,0,0));
    }

    private void coloring()
    {
        regPanel.setBackground(Color.WHITE);
        typeoptions.setBackground(Color.WHITE);
        dept2.setBackground(Color.WHITE);
        dept1.setBackground(Color.WHITE);
        u.setBackground(Color.WHITE);
        a.setBackground(Color.WHITE);
        p.setBackground(Color.WHITE);
        n.setBackground(Color.WHITE);
        Staff.setBackground(Color.WHITE);
        Supervisor.setBackground(Color.WHITE);
        electricity.setBackground(Color.WHITE);
        houseKeeping.setBackground(Color.WHITE);
        hvac.setBackground(Color.WHITE);
        security.setBackground(Color.WHITE);
        audio.setBackground(Color.WHITE);
        sysID.setForeground(Color.RED);
        dept.setForeground(Color.red);
        type.setForeground(Color.red);
        register.setBackground(Color.WHITE);
        register.setForeground(Color.GREEN);
        register.setBorder(new LineBorder(Color.WHITE));
    }

    private void settingFont ()
    {
        sysID.setFont(new Font("Monospaced",Font.BOLD,20));
        dept.setFont(new Font("Monospaced",Font.BOLD,20));
        type.setFont(new Font("Monospaced",Font.BOLD,20));
        nameText.setFont(new Font("Monospaced",Font.BOLD,16));
        usernameText.setFont(new Font("Monospaced",Font.BOLD,16));
        passwordText.setFont(new Font("Monospaced",Font.BOLD,16));
        addressText.setFont(new Font("Monospaced",Font.BOLD,16));
        electricity.setFont(new Font("Monospaced",Font.BOLD,16));
        hvac.setFont(new Font("Monospaced",Font.BOLD,16));
        security.setFont(new Font("Monospaced",Font.BOLD,16));
        audio.setFont(new Font("Monospaced",Font.BOLD,16));
        houseKeeping.setFont(new Font("Monospaced",Font.BOLD,16));
        Staff.setFont(new Font("Monospaced",Font.BOLD,16));
        Supervisor.setFont(new Font("Monospaced",Font.BOLD,16));
        register.setFont(new Font("Monospaced",Font.BOLD,24));
    }

    private class RegButtonListener implements ActionListener
    {
        public void actionPerformed (ActionEvent e)
        {
            if (e.getActionCommand().equals("Register"))
            {
                regFrame.setVisible(false);
                if(Staff.isSelected())
                    Type="Staff";
                if(Supervisor.isSelected())
                    Type="Supervisor";
                if(electricity.isSelected())
                    Department="Electricity";
                if(hvac.isSelected())
                    Department="HVAC";
                if(houseKeeping.isSelected())
                    Department="House Keeping";
                if(audio.isSelected())
                    Department="Audio/Video";
                if(security.isSelected())
                    Department="Security";

                for (int i=0;i<pendingReq.pendingPersons.size();i++)
                {
                    if (username.getText().equals(pendingReq.pendingPersons.get(i).getUsername()))
                    {
                        JOptionPane.showMessageDialog(null,"You have already Registered !");
                        stat = false;
                    }
                }
                if (stat==true)
                {
                    Person P = new Person(name.getText(),username.getText(),password.getText(),Type,address.getText(),Department,"1");
                    pendingReq pr = new pendingReq();
                    pr.pendingRequests(P);
                    JOptionPane.showMessageDialog(null,"Added to Pending List");
                }

                regFrame.setVisible(false);
                LoginRegisterGUI.loginRegister.setVisible(true);
            }
        }
    }
}
