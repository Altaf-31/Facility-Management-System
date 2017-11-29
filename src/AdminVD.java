import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class AdminVD {

    public static JPanel viewStaff = new JPanel();
    private static ArrayList<JButton> deleteButton = new ArrayList<>(20);
    private static ArrayList<JLabel> viewLabel = new ArrayList<>(20);
    private static JLabel StaffList = new JLabel("STAFF",JLabel.CENTER);
    private static JLabel SupervisorList = new JLabel("SUPERVISORS",JLabel.CENTER);
    private static JLabel Empty = new JLabel(" ");
    public static void View()
    {
        viewStaff.removeAll();
        viewStaff.setBackground(Color.WHITE);
        viewStaff.setLayout(new GridLayout(20,2,0,0));
        deleteButton.clear();
        viewLabel.clear();
        viewStaff.add(StaffList);
        for (int i=0;i<Database.DatabaseStaff.size();i++)
        {
            JLabel jLabel = new JLabel(Database.DatabaseStaff.get(i).getName());
            jLabel.setFont(new Font("Monospaced",Font.BOLD,22));
            JButton jButton = new JButton("Delete");
            jButton.setBackground(Color.red);
            jButton.setForeground(Color.white);
            viewLabel.add(jLabel);
            deleteButton.add(jButton);
            viewStaff.add(jLabel);
            viewStaff.add(jButton);
            jButton.addActionListener(new DeleteButtonListener());
        }

        viewStaff.add(Empty);
        viewStaff.add(SupervisorList);
        for (int j=0;j<Database.DatabaseSupervisor.size();j++)
        {
            JLabel jLabel = new JLabel(Database.DatabaseSupervisor.get(j).getName());
            jLabel.setFont(new Font("Monospaced",Font.BOLD,22));
            JButton jButton = new JButton("Delete");
            jButton.setBackground(Color.red);
            jButton.setForeground(Color.white);
            viewLabel.add(jLabel);
            deleteButton.add(jButton);
            viewStaff.add(jLabel);
            viewStaff.add(jButton);
            jButton.addActionListener(new DeleteButtonListener());
        }
        viewStaff.repaint();

    }
    public static class DeleteButtonListener implements ActionListener
    {
        int index;
        public void actionPerformed(ActionEvent e)
        {
            JButton jButton =(JButton) e.getSource();
            index = deleteButton.indexOf(jButton);
            viewStaff.remove(deleteButton.get(index));
            viewStaff.remove(viewLabel.get(index));
            viewStaff.repaint();
            for(int i =0;i<Database.DatabaseStaff.size();i++)
            {
                if(viewLabel.get(index).getText().equals(Database.DatabaseStaff.get(i).getName()))
                {
                    Database.DatabaseStaff.remove(i);
                }
            }
            for(int i =0;i<Database.DatabaseSupervisor.size();i++)
            {
                if(viewLabel.get(index).getText().equals(Database.DatabaseSupervisor.get(i).getName()))
                {
                    Database.DatabaseSupervisor.remove(i);
                }
            }
            try {
                Database.updateDB();
            }catch (Exception e1)
            {
                e1.printStackTrace();
            }

        }
    }
}
