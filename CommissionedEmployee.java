public class CommissionedEmployee extends Employee
{
    private double weeklySales;

    public CommissionedEmployee()
    {
        super();
        weeklySales = 0;
    }

    public CommissionedEmployee(String fname, String lname, double sales)
    {
        super(fname, lname);
        weeklySales = sales;
    }

    public double getWeeklySales()
    {
        return weeklySales;
    }

    public void setWeeklySales(double sales)
    {
        weeklySales = sales;
    }

    public double calculateWeeklyPay()
    {
        return weeklySales * 0.20;
    }

    public String toString()
    {
        return super.toString() + ", " + "Weekly Sales: " + weeklySales +
                ", Weekly Pay: $" + calculateWeeklyPay();
    }
}