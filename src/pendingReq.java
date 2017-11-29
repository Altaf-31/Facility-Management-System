import java.util.ArrayList;

public class pendingReq
{
    public static ArrayList<Person> pendingPersons = new ArrayList<>(100);
    public void pendingRequests(Person p)
    {
        pendingPersons.add(p);
    }
}
