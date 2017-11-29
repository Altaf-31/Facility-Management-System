import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Supervisor {
    private JFrame supervisorFrame = new JFrame("Home Supervisor");
    private JPanel supervisorHome = new JPanel();
    private JPanel acceptLeavetab = new JPanel();
    private JPanel buttonsPanel = new JPanel();
    private JPanel sendLeavePanel = new JPanel();
    private ArrayList<JButton> acceptLeaveButtons = new ArrayList<>(10);
    private ArrayList<JButton> rejectLeaveButtons = new ArrayList<>(10);
    private ArrayList<JLabel> leaveDetails = new ArrayList<>(10);
    private ArrayList<JPanel> ARbuttons = new ArrayList<>(10);
    Person loggedIn;
    //Home form
    private JLabel welcomeNote = new JLabel("WELCOME",JLabel.CENTER);
    private JLabel Empty8 = new JLabel("");
    private JLabel Empty9 = new JLabel("");
    private JLabel Empty10 = new JLabel("");
    private JLabel Empty11 = new JLabel("");
    private JLabel Empty12 = new JLabel("");
    private JButton Logout = new JButton("LOGOUT");
    private JPanel logoutPanel = new JPanel();
    //Leave form
    private JPanel Dates = new JPanel();
    private JPanel Sendpan = new JPanel();
    private JLabel Heading1 = new JLabel("LEAVE FORM",JLabel.CENTER);
    private JLabel Empty1= new JLabel("");
    private JLabel Empty2= new JLabel("");
    private JLabel Empty3 = new JLabel("");
    private JLabel Empty4 = new JLabel("");
    private JLabel To = new JLabel("To Department Supervisor,",JLabel.LEFT);
    private JLabel Reason = new JLabel("Reason: ",JLabel.LEFT);
    public static JTextField ReasonField = new JTextField();
    private JLabel startDate = new JLabel("Start Date: ",JLabel.CENTER);
    private JLabel endDate = new JLabel("End Date: ",JLabel.CENTER);
    public static JTextField startDateField = new JFormattedTextField();
    public static JTextField endDateField = new JFormattedTextField();
    private JButton Send = new JButton("SEND");

    public void GUI(Person currentLoggedInPerson)
    {
        supervisorFrame.setSize(750,450);
        buttonsPanel.setLayout(new FlowLayout());
        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.setPreferredSize(new Dimension(700,450));
        buttonsPanel.add(tabbedPane);
        tabbedPane.addTab("Home",supervisorHome);
        tabbedPane.addTab("Send Leave",sendLeavePanel);
        tabbedPane.addTab("Staff Leave Applications",acceptLeavetab);
        supervisorFrame.add(buttonsPanel);
        supervisorFrame.setVisible(true);
        loggedIn = currentLoggedInPerson;
        setHomePanel();
        setSendLeavePanel();
        setacceptLeavetab();
    }

    public void setHomePanel()
    {
        //home.setBackground(Color.WHITE);
        supervisorHome.setLayout(new GridLayout(7,1,0,0));
        welcomeNote.setFont(new Font("Monospaced",Font.BOLD,60));
        supervisorHome.add(welcomeNote);
        JLabel namee = new JLabel(loggedIn.getName(),JLabel.CENTER);
        namee.setFont(new Font("Monospaced",Font.BOLD,60));
        supervisorHome.add(namee);
        supervisorHome.add(Empty8);
        supervisorHome.add(Empty9);
        logoutPanel.setLayout(new GridLayout(1,3,0,0));
        logoutPanel.add(Empty10);
        logoutPanel.add(Logout);
        logoutPanel.add(Empty11);
        supervisorHome.add(logoutPanel);
        Logout.setBackground(Color.red);
        Logout.setFont(new Font("Monospaced",Font.BOLD,22));
        supervisorHome.add(Empty12);
        Logout.addActionListener(new SupervisorLogoutButtonListener());
    }

    public void setSendLeavePanel()
    {

            sendLeavePanel.setLayout(new GridLayout(10,1,0,0));
            sendLeavePanel.add(Heading1);
            Heading1.setFont(new Font("Monospaced",Font.BOLD,35));
            Heading1.setForeground(Color.RED);
            sendLeavePanel.add(Empty1);
            sendLeavePanel.add(To);
            sendLeavePanel.add(Reason);
            sendLeavePanel.add(ReasonField);
            Dates.setLayout(new GridLayout(2,1,0,0));
            Dates.add(startDate);
            Dates.add(startDateField);
            Dates.add(endDate);
            Dates.add(endDateField);
            sendLeavePanel.add(Dates);
            sendLeavePanel.add(Empty2);
            Sendpan.setLayout(new GridLayout(1,3,0,0));
            Sendpan.add(Empty3);
            Send.setBackground(Color.green);
            Send.setForeground(Color.BLACK);
            Send.setFont(new Font("Monospaced",Font.BOLD,30));
            Sendpan.add(Send);
            Sendpan.add(Empty4);
            sendLeavePanel.add(Sendpan);

    }
    public void setacceptLeavetab()
    {
        acceptLeavetab.setLayout(new GridLayout(13,1,0,0));
        acceptLeavetab.setBackground(Color.WHITE);
        JLabel Heading = new JLabel("Pending Staff Leaves",JLabel.CENTER);
        Heading.setFont(new Font("Monospaced",Font.BOLD,30));
        Heading.setForeground(Color.BLUE);
        acceptLeavetab.add(Heading);
        for (int i=0;i<loggedIn.leaves.size();i++)
        {
            JLabel jLabel1 = new JLabel(loggedIn.leaves.get(i).getName());
            JLabel jLabel2 = new JLabel(loggedIn.leaves.get(i).getReason());
            JLabel jLabel3 = new JLabel(loggedIn.leaves.get(i).getStartDate());
            JLabel jLabel4 = new JLabel(loggedIn.leaves.get(i).getEndDate());
            JButton jButton1 = new JButton("Accept");
            JButton jButton2 = new JButton("Reject");
            JPanel jPanel = new JPanel();
            jPanel.setLayout(new GridLayout(1,2));
            acceptLeaveButtons.add(jButton1);
            rejectLeaveButtons.add(jButton2);
            leaveDetails.add(jLabel1);
            leaveDetails.add(jLabel2);
            leaveDetails.add(jLabel3);
            leaveDetails.add(jLabel4);
            ARbuttons.add(jPanel);
            jButton1.setBackground(Color.GREEN);
            jButton2.setBackground(Color.RED);
            jPanel.add(jButton1);
            jPanel.add(jButton2);
            acceptLeavetab.add(jLabel1);
            acceptLeavetab.add(jLabel2);
            acceptLeavetab.add(jLabel3);
            acceptLeavetab.add(jLabel4);
            acceptLeavetab.add(jPanel);
            jButton1.addActionListener(new SupervisorLogoutButtonListener());
            jButton2.addActionListener(new SupervisorLogoutButtonListener());
        }
    }
    private class SupervisorLogoutButtonListener implements ActionListener
    {
        int index=0;
        public void actionPerformed(ActionEvent e)
        {
            String command = e.getActionCommand();
            JButton clicked = (JButton) e.getSource();
            if(command=="LOGOUT")
            {
                supervisorFrame.setVisible(false);
                LoginRegisterGUI.loginRegister.setVisible(true);
            }

            if (clicked.getText().equals("Accept"))
            {
                index = acceptLeaveButtons.indexOf(clicked);
                System.out.println(index);
                clearPane(index,"0");
                update();
                index=0;
            }

            if (clicked.getText().equals("Reject"))
            {
                index = rejectLeaveButtons.indexOf(clicked);
                System.out.println(index);
                clearPane(index,"1");
                update();
                index=0;
            }

        }

        private void update()
        {
            try{
                Database.updateDB();
            }catch (Exception e)
            {
                e.printStackTrace();
            }
        }

        private void clearPane(int index,String x)
        {
            acceptLeavetab.repaint();
            acceptLeavetab.remove(ARbuttons.get(index));
            acceptLeavetab.remove(leaveDetails.get(4*index));
            acceptLeavetab.remove(leaveDetails.get(4*index+1));
            acceptLeavetab.remove(leaveDetails.get(4*index+2));
            acceptLeavetab.remove(leaveDetails.get(4*index+3));
            acceptLeaveButtons.remove(index);
            rejectLeaveButtons.remove(index);
            ARbuttons.remove(index);
            System.out.println("Fine");
            String senderName = leaveDetails.get(4*index).getText();
            System.out.println(Database.DatabaseStaff.size());
            for (int i=0;i<Database.DatabaseStaff.size();i++)
            {
                if (senderName.equals(Database.DatabaseStaff.get(i).getName()))
                    Database.DatabaseStaff.get(i).setAttendance(x);
            }
            System.out.println("Still Fine");
            System.out.println(leaveDetails.size());
            leaveDetails.remove(4*index+3);
            leaveDetails.remove(4*index+2);
            leaveDetails.remove(4*index+1);
            leaveDetails.remove(4*index);

            loggedIn.leaves.remove(index);
            acceptLeavetab.repaint();
        }

    }


}
