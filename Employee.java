public abstract class Employee
{
    private String firstName;
    private String lastName;

    public Employee()
    {
        firstName = "";
        lastName = "";
    }

    public Employee(String fname, String lname)
    {
        firstName = fname;
        lastName = lname;
    }

    public String getFirstName()
    {
        return firstName;

    }

    public void setFirstName(String fname)
    {
        firstName = fname;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(String lname)
    {
        lastName = lname;
    }

    public String toString()
    {
        return "First Name: " + firstName + ", Last Name: " + lastName;
    }

    public abstract double calculateWeeklyPay();
}