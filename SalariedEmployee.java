public class SalariedEmployee extends Employee
{
    private double weeklySalary;
    private boolean hasBonus;

    public SalariedEmployee()
    {
        super();
        weeklySalary = 0;
        hasBonus = false;
    }

    public SalariedEmployee(String fname, String lname,
                            double salary, boolean bonus)
    {
        super(fname, lname);
        weeklySalary = salary;
        hasBonus = bonus;
    }

    public double getWeeklySalary()
    {
        return weeklySalary;
    }

    public void setWeeklySalary(double salary)
    {
        weeklySalary = salary;
    }

    public boolean isBonus()
    {
        return hasBonus;
    }

    public void setBonus(boolean bonus)
    {
        hasBonus = bonus;
    }

    public double calculateWeeklyPay()
    {
        if(hasBonus)
            return weeklySalary + weeklySalary * 0.10;
        else
            return weeklySalary;
    }

    public String toString()
    {
        if(hasBonus)
            return super.toString() + ", " + "Weekly Salary: " +
                    weeklySalary + ", Bonus: " + (weeklySalary * 0.10) +
                    ", Weekly Pay: $" + calculateWeeklyPay();
        else
            return super.toString() + ", " + "Weekly Salary: " +
                    weeklySalary + ", Bonus: 0" + ", Weekly Pay: $" +
                    calculateWeeklyPay();
    }
}