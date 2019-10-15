public class HourlyEmployee extends Employee
{
    private int hoursWorked;
    private double rateHourly;

    public HourlyEmployee()
    {
        super();
        hoursWorked = 0;
        rateHourly = 0;
    }

    public HourlyEmployee(String fname, String lname, int hours, double rate)
    {
        super(fname, lname);
        hoursWorked = hours;
        rateHourly = rate;
    }

    public int getHoursWorked()
    {
        return hoursWorked;
    }

    public double getRateHourly()
    {
        return rateHourly;
    }

    public void setHoursWorked(int hours)
    {
        hoursWorked = hours;
    }

    public void setrateHourly(double rate)
    {
        rateHourly = rate;
    }

    public double calculateWeeklyPay()
    {
        if(hoursWorked <= 40)
            return hoursWorked * rateHourly;
        else
            return (40 * rateHourly) + ((hoursWorked - 40) * rateHourly * 2);
    }

    public String toString()
    {
        return super.toString() + ", " + "Hours Worked: " + hoursWorked +
                ", Rate Per Hour: " + rateHourly + ", Weekly Pay: $" +
                calculateWeeklyPay();
    }
}

