import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Admin {

    private JFrame adminFrame = new JFrame("Admin Login");
    private JPanel home = new JPanel();
    private JPanel assignTask = new JPanel();
    private JPanel logisticRequests = new JPanel();
    private JPanel registerRequests = new JPanel();
    private JPanel buttonsPanel = new JPanel();
    private ArrayList<JLabel> pendingRequests = new ArrayList<>(100);
    private ArrayList<JButton> acceptRequests = new ArrayList<>(100);
    private ArrayList<JButton> rejectRequests = new ArrayList<>(100);
    private int Alreadyexists1=0,Alreadyexists2=0,Alreadyexists3=0,Alreadyexists4=0,Alreadyexists5=0;
    //For Home
    private JLabel welcomeNote = new JLabel("WELCOME ADMIN",JLabel.CENTER);
    private JLabel Empty1 = new JLabel("");
    private JLabel Empty2 = new JLabel("");
    private JLabel Empty3 = new JLabel("");
    private JLabel Empty4 = new JLabel("");
    private JLabel Empty5 = new JLabel("");
    private JButton Logout = new JButton("LOGOUT");
    private JPanel logoutPanel = new JPanel();

    public void GUI()
    {
        adminFrame.setSize(750,450);
        buttonsPanel.setLayout(new FlowLayout());
        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.setPreferredSize(new Dimension(700,450));
        buttonsPanel.add(tabbedPane);
        tabbedPane.addTab("Home",home);
        setHomePanel();
        tabbedPane.addTab("View",AdminVD.viewStaff);
        tabbedPane.addTab("Assign Task",assignTask);
        tabbedPane.addTab("Logistic Requests",logisticRequests);
        tabbedPane.addTab("Register Requests",registerRequests);
        setRegisterRequestsPanel();
        adminFrame.add(buttonsPanel);
        adminFrame.setVisible(true);
        AdminVD.View();
    }
    public void setHomePanel()
    {
        //home.setBackground(Color.WHITE);
        home.setLayout(new GridLayout(6,1,0,0));
        welcomeNote.setFont(new Font("Monospaced",Font.BOLD,60));
        home.add(welcomeNote);
        home.add(Empty1);
        home.add(Empty2);
        logoutPanel.setLayout(new GridLayout(1,3,0,0));
        logoutPanel.add(Empty3);
        logoutPanel.add(Logout);
        logoutPanel.add(Empty4);
        home.add(logoutPanel);
        Logout.setBackground(Color.red);
        Logout.setFont(new Font("Monospaced",Font.BOLD,22));
        home.add(Empty5);
        Logout.addActionListener(new AdminLogoutButtonListener());
    }

    public void setRegisterRequestsPanel()
    {
        registerRequests.setBackground(Color.WHITE);
        registerRequests.setLayout(new GridLayout(20,3));
        //System.out.println(pendingReq.pendingPersons.size());
        for (int i=0;i<pendingReq.pendingPersons.size();i++)
        {
            JButton jb1 = new JButton("Accept");
            jb1.setBackground(Color.green);
            jb1.setForeground(Color.white);
            JButton jb2 = new JButton("Reject");
            jb2.setBackground(Color.red);
            jb2.setForeground(Color.white);
            JLabel name = new JLabel(pendingReq.pendingPersons.get(i).getName());
            name.setFont(new Font("Monospaced",Font.BOLD,22));
            pendingRequests.add(name);
            acceptRequests.add(jb1);
            rejectRequests.add(jb2);
        }

        for (int i=0;i<pendingRequests.size();i++)
        {
            acceptRequests.get(i).addActionListener(new ButtonListener());
            rejectRequests.get(i).addActionListener(new ButtonListener());
            registerRequests.add(pendingRequests.get(i));
            registerRequests.add(acceptRequests.get(i));
            registerRequests.add(rejectRequests.get(i));
        }
    }

    private class AdminLogoutButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            String command = e.getActionCommand();
            if(command=="LOGOUT")
            {
                adminFrame.setVisible(false);
                LoginRegisterGUI.loginRegister.setVisible(true);
            }
        }
    }
    private class ButtonListener implements ActionListener
    {
        int index;
        String names;
        Person p;
        public void actionPerformed(ActionEvent event)
        {
            JButton jButton =(JButton) event.getSource();
            if (jButton.getText().equals("Accept"))
            {
                index = acceptRequests.indexOf(jButton);
                names=pendingRequests.get(index).getText();
                for (int i=0;i<pendingReq.pendingPersons.size();i++) {
                    if (names.equals(pendingReq.pendingPersons.get(i).getName())) {
                        p = pendingReq.pendingPersons.get(i);
                        p.leaves=null;
                        //System.out.println(p.type);
                        //System.out.println(p.department);
                        if(p.getType().equals("Supervisor") && p.getDepartment().equals("Electricity")) {
                            if(Alreadyexists1==0) {
                                Acceptance(p,index,i);
                                Alreadyexists1 = 1;
                                Write(p);
                            }
                            else{
                                JOptionPane.showMessageDialog(null,"This Department Already has a Supervisor!!!");                            }
                        }
                        else if(p.getType().equals("Supervisor") && p.getDepartment().equals("HVAC")) {
                            if(Alreadyexists2==0) {
                                Acceptance(p,index,i);
                                Alreadyexists2 = 1;
                                Write(p);
                            }
                            else{
                                JOptionPane.showMessageDialog(null,"This Department Already has a Supervisor!!!");                            }
                        }
                        else if(p.getType().equals("Supervisor") && p.getDepartment().equals("House Keeping")) {
                            if(Alreadyexists3==0) {
                                Acceptance(p,index,i);
                                Alreadyexists3 = 1;
                                Write(p);
                            }
                            else{
                                JOptionPane.showMessageDialog(null,"This Department Already has a Supervisor!!!");                            }
                        }
                        else if(p.getType().equals("Supervisor") && p.getDepartment().equals("Audio/Video")) {
                            if(Alreadyexists4==0) {
                                Acceptance(p,index,i);
                                Alreadyexists4 = 1;
                                Write(p);
                            }
                            else{
                                JOptionPane.showMessageDialog(null,"This Department Already has a Supervisor!!!");                            }
                        }
                        else if(p.getType().equals("Supervisor") && p.getDepartment().equals("Security")) {
                            if(Alreadyexists5==0) {
                                Acceptance(p,index,i);
                                Alreadyexists5 = 1;
                                Write(p);
                            }
                            else{
                                JOptionPane.showMessageDialog(null,"This Department Already has a Supervisor!!!");
                            }
                        }
                        else
                        {
                            Acceptance(p,index,i);
                            Write(p);
                        }
                    }
                }

            }
            else
            {
                index = rejectRequests.indexOf(jButton);
                names=pendingRequests.get(index).getText();
                for (int i=0;i<pendingReq.pendingPersons.size();i++)
                {
                    if (names.equals(pendingReq.pendingPersons.get(i).getName()))
                    {
                        pendingReq.pendingPersons.remove(i);
                        registerRequests.remove(pendingRequests.get(index));
                        registerRequests.remove(acceptRequests.get(index));
                        registerRequests.remove(rejectRequests.get(index));
                        registerRequests.repaint();
                    }
                }
            }

        }
    }

    public void Write(Person p)
    {
        try {
            Database.writeFile(p);
        }catch (Exception e)
        {
            e.printStackTrace();
        }

        AdminVD.viewStaff.removeAll();
        AdminVD.View();
        AdminVD.viewStaff.repaint();
    }

    public void Acceptance(Person p,int index,int i)
    {

        pendingReq.pendingPersons.remove(i);

        registerRequests.remove(pendingRequests.get(index));
        registerRequests.remove(acceptRequests.get(index));
        registerRequests.remove(rejectRequests.get(index));
        registerRequests.repaint();

    }
}
