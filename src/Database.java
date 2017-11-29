import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Database {

    public static ArrayList<Person> DatabaseStaff = new ArrayList<>(100);
    public static ArrayList<Person> DatabaseSupervisor = new ArrayList<>(100);

    public static void writeFile(Person person)
    {
        if (person.getType().equals("Staff"))
        {
            DatabaseStaff.add(person);
        }
        else if (person.getType().equals("Supervisor"))
        {
            DatabaseSupervisor.add(person);
        }
        try {
            updateDB();
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public static void updateDB() throws FileNotFoundException
    {
        PrintWriter pw = new PrintWriter(new FileOutputStream(new File("databaseStaff.csv"),false));
        for (int i=0;i<DatabaseStaff.size();i++)
        {
            StringBuilder sb = new StringBuilder();
            sb.append(DatabaseStaff.get(i).getAttendance());
            sb.append(',');
            sb.append(DatabaseStaff.get(i).getName());
            sb.append(',');
            sb.append(DatabaseStaff.get(i).getUsername());
            sb.append(',');
            sb.append(DatabaseStaff.get(i).getPassword());
            sb.append(',');
            sb.append(DatabaseStaff.get(i).getType());
            sb.append(',');
            sb.append(DatabaseStaff.get(i).getAddress());
            sb.append(',');
            sb.append(DatabaseStaff.get(i).getDepartment());
            sb.append(',');
            int v;
            if(DatabaseStaff.get(i).leaves==null)
            {
                v=0;
            }
            else
            {
                v=DatabaseStaff.get(i).leaves.size();
            }

            sb.append(v);
            sb.append(',');
            for (int j=0;j<v;j++)
            {
                sb.append(DatabaseStaff.get(i).leaves.get(j).getName());
                sb.append(',');
                sb.append(DatabaseStaff.get(i).leaves.get(j).getReason());
                sb.append(',');
                sb.append(DatabaseStaff.get(i).leaves.get(j).getStartDate());
                sb.append(',');
                sb.append(DatabaseStaff.get(i).leaves.get(j).getEndDate());
                sb.append(',');
            }
            sb.append('\n');
            pw.write(sb.toString());
        }
        pw.close();

        PrintWriter pw1 = new PrintWriter(new FileOutputStream(new File("databaseSupervisor.csv"),false));
        for (int i=0;i<DatabaseSupervisor.size();i++)
        {
            StringBuilder sb = new StringBuilder();
            sb.append(DatabaseSupervisor.get(i).getAttendance());
            sb.append(',');
            sb.append(DatabaseSupervisor.get(i).getName());
            sb.append(',');
            sb.append(DatabaseSupervisor.get(i).getUsername());
            sb.append(',');
            sb.append(DatabaseSupervisor.get(i).getPassword());
            sb.append(',');
            sb.append(DatabaseSupervisor.get(i).getType());
            sb.append(',');
            sb.append(DatabaseSupervisor.get(i).getAddress());
            sb.append(',');
            sb.append(DatabaseSupervisor.get(i).getDepartment());
            sb.append(',');
            int w;
            if(DatabaseSupervisor.get(i).leaves==null)
            {
                w=0;
            }
            else
            {
                w=DatabaseSupervisor.get(i).leaves.size();
            }
            sb.append(w);
            sb.append(',');
            for (int j=0;j<w;j++)
            {
                sb.append(DatabaseSupervisor.get(i).leaves.get(j).getName());
                sb.append(',');
                sb.append(DatabaseSupervisor.get(i).leaves.get(j).getReason());
                sb.append(',');
                sb.append(DatabaseSupervisor.get(i).leaves.get(j).getStartDate());
                sb.append(',');
                sb.append(DatabaseSupervisor.get(i).leaves.get(j).getEndDate());
                sb.append(',');
            }
            sb.append('\n');
            pw1.write(sb.toString());
        }
        pw1.close();

        PrintWriter pw2 = new PrintWriter(new FileOutputStream(new File("databaseAdmin.csv"),false));
        StringBuilder sb = new StringBuilder();
        sb.append(AdminData.leaveList.size());
        sb.append(',');
        for (int i=0;i<AdminData.leaveList.size();i++) {
            sb.append(AdminData.leaveList.get(i).getName());
            sb.append(',');
            sb.append(AdminData.leaveList.get(i).getReason());
            sb.append(',');
            sb.append(AdminData.leaveList.get(i).getStartDate());
            sb.append(',');
            sb.append(AdminData.leaveList.get(i).getEndDate());
            sb.append(',');
        }
        sb.append(AdminData.logisticRequestsList.size());
        sb.append(',');
        for (int i=0;i<AdminData.logisticRequestsList.size();i++){
            sb.append(AdminData.logisticRequestsList.get(i).getId());
            sb.append(',');
            sb.append(AdminData.logisticRequestsList.get(i).getItemName());
            sb.append(',');
            sb.append(AdminData.logisticRequestsList.get(i).getQuantity());
            sb.append(',');
        }
        sb.append('\n');
        pw2.write(sb.toString());
        pw2.close();

        System.out.println("Changes written to database !!!");
    }
    public static void Split1() throws IOException
    {
        Scanner sc = new Scanner(new File("databaseStaff.csv"));
        FileInputStream in = null;
        try
        {
            String[] array;
            String flag;
            while(sc.hasNextLine()) {
                flag = sc.nextLine();
                array = flag.split(",");
                Person p1 = new Person(array[1],array[2],array[3],array[4],array[5],array[6],array[0]);
                DatabaseStaff.add(p1);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            if(in!=null)
                in.close();
        }
    }

    public static void Split2() throws IOException
    {
        Scanner sc = new Scanner(new File("databaseSupervisor.csv"));
        FileInputStream in = null;
        try
        {
            String[] array;
            String flag;
            while(sc.hasNextLine()) {
                flag = sc.nextLine();
                array = flag.split(",");
                Person p1 = new Person(array[1],array[2],array[3],array[4],array[5],array[6],array[0]);
                String TL = array[7];
                //System.out.println(array[6]);
                int totalLeaves = Integer.parseInt(TL);
                int x=8;
                for(int i=0;i<totalLeaves;i++)
                {
                    Leave l = new Leave();
                    l.setName(array[x+i]);
                    l.setReason(array [x+i+1]);
                    l.setStartDate(array [x+i+2]);
                    l.setEndDate(array[x+i+3]);
                    p1.leaves.add(l);
                    x+=3;
                }
                DatabaseSupervisor.add(p1);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            if(in!=null)
                in.close();
        }
    }
    
}
