import java.util.Scanner;
import java.util.Locale;
import java.text.NumberFormat;

public class WeeklyPay
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);

        Employee[] employees = new Employee[100];
        int count = 0;

        System.out.print("Enter the Employee's Full Name (To exit, enter '0 0'): ");
        String fname = input.next();
        String lname = input.next();


        while(!fname.equalsIgnoreCase("0") && count < 100) {
            System.out.printf("Enter the Employee's Contract Type\n"
                    + "(S)alaried, (H)ourly, or (C)ommissioned: ");
            char type = input.next().charAt(0);

            if(type == 'S' || type == 's')
            {
                System.out.print("\nEnter the Weekly Salary of Employee $");
                double salary = input.nextDouble();

                System.out.print("Enter 1 for bonus or 0 for non-bonus employee: ");
                int review = input.nextInt();

                if(review == 1)
                {
                    SalariedEmployee se = new SalariedEmployee(fname, lname, salary, true);
                    employees[count] = se;
                    count++;
                }
                else if(review == 0)
                {
                    SalariedEmployee se = new SalariedEmployee(fname, lname, salary, false);
                    employees[count] = se;
                    count++;
                }
                else
                {
                    System.out.println("Invalid reviewed number.");
                }
            }
            else if(type == 'H' || type == 'h')
            {
                System.out.print("Enter the amount of hours worked: ");
                int hours = input.nextInt();

                System.out.print("Enter the rate per hour: $");
                double rate = input.nextDouble();

                HourlyEmployee he = new HourlyEmployee(fname, lname, hours, rate);
                employees[count] = he;
                count++;
            }
            else if(type == 'C' || type == 'c')
            {
                System.out.print("Enter weekly sales: $");
                double sales = input.nextDouble();

                CommissionedEmployee ce = new CommissionedEmployee(fname, lname, sales);
                employees[count] = ce;
                count++;
            }
            else
            {
                System.out.println("Invalid type of the employee.");
            }

            System.out.print("\nEnter the Employee's Full Name (To exit, enter '0 0'): ");
            fname = input.next();
            lname = input.next();
        }

        NumberFormat formatter = NumberFormat.getCurrencyInstance(Locale.US);
        double total = 0;
        //print paysheet (15 spaces per column)

        System.out.printf("\n\n%-15s%-12s%12s%12s%10s%15s\n", "Name", "Class",
                "Hours", "Sales", "Rate", "Weekly Pay");
        System.out.println("================================================================================");
        for(int i = 0; i < count; i++)
        {
            Employee empArray = employees[i];
            System.out.printf("%-15s", (empArray.getFirstName() + " " + empArray.getLastName()));
            if(empArray instanceof SalariedEmployee)
            {
                System.out.printf("%-15s%12s%12s%10s%15s", "Salaried", "", "",
                        "", formatter.format(empArray.calculateWeeklyPay()));
                if(((SalariedEmployee) empArray).isBonus())
                    System.out.print("*");
                System.out.println();
                total += empArray.calculateWeeklyPay();
            }
            else if(empArray instanceof HourlyEmployee)
            {
                System.out.printf("%-15s%12d%12s%10s%15s\n", "Hourly",
                        ((HourlyEmployee) empArray).getHoursWorked(), "",
                        formatter.format(((HourlyEmployee) empArray).getRateHourly()),
                        formatter.format(empArray.calculateWeeklyPay()));
                total += empArray.calculateWeeklyPay();
            }
            else if(empArray instanceof CommissionedEmployee)
            {
                System.out.printf("%-15s%12s%12s%10s%15s\n", "Commissioned", "",
                        formatter.format(((CommissionedEmployee) empArray).getWeeklySales()),
                        "", formatter.format(empArray.calculateWeeklyPay()));
                total += empArray.calculateWeeklyPay();
            }
        }//paysheet employee list
        System.out.println("================================================================================");
        System.out.printf("TOTAL ", formatter.format(total));
        System.out.println("*10% bonus");
        System.out.println("Thank you for using my program!");
    }//main
}//class