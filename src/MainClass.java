import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainClass {

    private JFrame Welcome = new JFrame("FMS");
    private JPanel WcPanel = new JPanel();
    private JPanel ProceedPanel = new JPanel();
    private JButton Proceed = new JButton("PROCEED");
    private JLabel F = new JLabel("FACILITY",JLabel.CENTER);
    private JLabel M = new JLabel("MANAGEMENT",JLabel.CENTER);
    private JLabel S = new JLabel("SYSTEM",JLabel.CENTER);
    private JButton Quit = new JButton("QUIT");
    private JLabel Empty2 = new JLabel("");

    public MainClass() {
        GUI();
    }

    private void GUI() {
        WcPanel.setLayout(new GridLayout(4,1));
        WcPanel.setBackground(Color.WHITE);
        F.setForeground(Color.DARK_GRAY);
        S.setForeground(Color.DARK_GRAY);
        M.setForeground(Color.DARK_GRAY);
        ProceedPanel.setLayout(new GridLayout(1,3));
        ProceedPanel.setBackground(Color.WHITE);
        Quit.setFont(new Font("Monospaced",Font.BOLD,45));
        Quit.setBackground(Color.WHITE);
        Quit.setForeground(Color.RED);
        Quit.setBorder(new LineBorder(Color.WHITE));
        ProceedPanel.add(Quit);
        ProceedPanel.add(Empty2);
        ProceedPanel.add(Proceed);
        F.setFont(new Font("Monospaced",Font.BOLD,50));
        M.setFont(new Font("Monospaced",Font.BOLD,50));
        S.setFont(new Font("Monospaced",Font.BOLD,50));
        Proceed.setFont(new Font("Monospaced",Font.BOLD,45));
        Proceed.setBackground(Color.WHITE);
        Proceed.setForeground(Color.GREEN);
        Proceed.setBorder(new LineBorder(Color.WHITE));
        WcPanel.add(F);
        WcPanel.add(M);
        WcPanel.add(S);
        WcPanel.add(ProceedPanel);
        Welcome.add(WcPanel);
        Welcome.setSize(700,450);
        Welcome.setVisible(true);
        Proceed.setActionCommand("Proceed");
        Quit.setActionCommand("Quit");
        Proceed.addActionListener(new FirstScreen());
        Quit.addActionListener(new FirstScreen());
    }

    private class FirstScreen implements ActionListener
    {
        public void actionPerformed (ActionEvent e)
        {
            String command = e.getActionCommand();
            if(command.equals("Proceed"))
            {
                Welcome.setVisible(false);
                try {
                    Database.Split2();
                    Database.Split1();
                }
                catch(Exception e1)
                {
                    e1.printStackTrace();
                }
                LoginRegisterGUI LRG = new LoginRegisterGUI();
                LRG.GUI();
            }
            else
            {
                System.exit(0);
            }
        }
    }



    public static void main(String [] args)
    {
        MainClass MC = new MainClass();
    }
}
