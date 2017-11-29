import java.util.ArrayList;

public class Person {

    private String name,username,password,type,address,department,attendance;
    public ArrayList<Leave> leaves = new ArrayList<Leave>(20);

    public Person(String Na,String Us,String Pa,String Ty,String Ad,String De, String a)
    {
        name=Na;
        username=Us;
        password=Pa;
        type=Ty;
        address=Ad;
        department=De;
        attendance=a;
    }

    public String getAddress() {
        return address;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getType() {
        return type;
    }

    public String getUsername() {
        return username;
    }

    public String getAttendance() {
        return attendance;
    }

    public String getDepartment() {
        return department;
    }

    public void setAttendance(String attendance) {
        this.attendance = attendance;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
