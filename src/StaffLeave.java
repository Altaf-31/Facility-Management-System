
public class StaffLeave
{
    public static void sendLeave(Person c)
    {
        for (int i=0;i<Database.DatabaseSupervisor.size();i++)
        {
            if (c.getDepartment().equals(Database.DatabaseSupervisor.get(i).getDepartment()))
            {
                //System.out.println(Database.DatabaseSupervisor.get(i).name);
                Person sendTo = Database.DatabaseSupervisor.get(i);
                Leave leave = new Leave();
                leave.setName(c.getName());
                leave.setReason(Staff.ReasonField.getText());
                leave.setStartDate(Staff.startDateField.getText());
                leave.setEndDate(Staff.endDateField.getText());
                //System.out.println("Hell1");
                int u;
                if(sendTo.leaves==null)
                {
                    u=0;
                }
                else
                {
                    u=sendTo.leaves.size();
                }
                System.out.println(u);
                sendTo.leaves.add(leave);
                //System.out.println("Hell2");
                Database.DatabaseSupervisor.remove(i);
                Database.DatabaseSupervisor.add(sendTo);
                Staff.ReasonField.setText("");
                Staff.startDateField.setText("");
                Staff.endDateField.setText("");
                //System.out.println("Hell");
                //System.out.println("outout"+sendTo.name);
            }
        }

        try {
            Database.updateDB();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
