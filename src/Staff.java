import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Staff {

    private JFrame staffFrame = new JFrame("Home Staff");
    private JPanel staffHome = new JPanel();
    private JPanel leaveTab = new JPanel();
    private JPanel logisticTab = new JPanel();
    private JPanel buttonsPanel = new JPanel();
    //Leave Form
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
    //Logistic Form
    private JLabel Heading2 = new JLabel("LOGISTIC APPROVAL REQUEST",JLabel.CENTER);
    private JLabel ID = new JLabel("ID: ",JLabel.LEFT);
    private JLabel itemName = new JLabel("Item Name: ",JLabel.LEFT);
    private JLabel Quantity = new JLabel("Quantity: ",JLabel.LEFT);
    private JLabel Empty5= new JLabel("");
    private JLabel Empty6= new JLabel("");
    private JLabel Empty7= new JLabel("");
    private JTextField IDField = new JFormattedTextField();
    private JTextField itemNameField = new JFormattedTextField();
    private JTextField quantityField = new JFormattedTextField();

    public void GUI(Person currentLoggedInPerson)
    {
        staffFrame.setSize(750,450);
        buttonsPanel.setLayout(new FlowLayout());
        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.setPreferredSize(new Dimension(700,450));
        buttonsPanel.add(tabbedPane);
        tabbedPane.addTab("Home",staffHome);
        tabbedPane.addTab("Leave Application",leaveTab);
        tabbedPane.addTab("Logistic Field",logisticTab);
        staffFrame.add(buttonsPanel);
        staffFrame.setVisible(true);
        loggedIn = currentLoggedInPerson;
        setHomePanel();
        setLeaveTab();
        setLogisticTab();
    }

    public void setHomePanel()
    {
        //home.setBackground(Color.WHITE);
        staffHome.setLayout(new GridLayout(7,1,0,0));
        welcomeNote.setFont(new Font("Monospaced",Font.BOLD,60));
        staffHome.add(welcomeNote);
        JLabel namee = new JLabel(loggedIn.getName(),JLabel.CENTER);
        namee.setFont(new Font("Monospaced",Font.BOLD,60));
        staffHome.add(namee);
        staffHome.add(Empty8);
        staffHome.add(Empty9);
        logoutPanel.setLayout(new GridLayout(1,3,0,0));
        logoutPanel.add(Empty10);
        logoutPanel.add(Logout);
        logoutPanel.add(Empty11);
        staffHome.add(logoutPanel);
        Logout.setBackground(Color.red);
        Logout.setFont(new Font("Monospaced",Font.BOLD,22));
        staffHome.add(Empty12);
        Logout.addActionListener(new StaffLogoutButtonListener());
    }

    private void setLeaveTab()
    {
        leaveTab.setLayout(new GridLayout(10,1,0,0));
        leaveTab.add(Heading1);
        Heading1.setFont(new Font("Monospaced",Font.BOLD,35));
        Heading1.setForeground(Color.RED);
        leaveTab.add(Empty1);
        leaveTab.add(To);
        leaveTab.add(Reason);
        leaveTab.add(ReasonField);
        Dates.setLayout(new GridLayout(2,1,0,0));
        Dates.add(startDate);
        Dates.add(startDateField);
        Dates.add(endDate);
        Dates.add(endDateField);
        leaveTab.add(Dates);
        leaveTab.add(Empty2);
        Sendpan.setLayout(new GridLayout(1,3,0,0));
        Sendpan.add(Empty3);
        Send.setBackground(Color.green);
        Send.setForeground(Color.BLACK);
        Send.addActionListener(new StaffButtonListener());
        Send.setFont(new Font("Monospaced",Font.BOLD,30));
        Sendpan.add(Send);
        Sendpan.add(Empty4);
        leaveTab.add(Sendpan);
    }

    private void setLogisticTab()
    {
        logisticTab.setLayout(new GridLayout(10,1,0,0));
        logisticTab.add(Heading2);
        Heading2.setFont(new Font("Monospaced",Font.BOLD,35));
        Heading2.setForeground(Color.RED);
        logisticTab.add(Empty5);
        logisticTab.add(ID);
        logisticTab.add(IDField);
        logisticTab.add(Empty6);
        logisticTab.add(itemName);
        logisticTab.add(itemNameField);
        logisticTab.add(Empty7);
        logisticTab.add(Quantity);
        logisticTab.add(quantityField);
    }

    private class StaffLogoutButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            String command = e.getActionCommand();
            if(command.equals("LOGOUT"))
            {
                staffFrame.setVisible(false);
                LoginRegisterGUI.loginRegister.setVisible(true);
            }
        }
    }

    private class StaffButtonListener implements ActionListener
    {
        public void actionPerformed (ActionEvent e)
        {
            JButton jButton = (JButton) e.getSource();
            if (jButton.getText().equals("SEND"))
            {
                StaffLeave.sendLeave(loggedIn);
            }
        }
    }
}
