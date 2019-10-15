import java.util.Scanner;

public class SumofDigits
{
	public static void main(String[] args)
	{
	//program repeatability
	while (true)
	{
		Scanner in = new Scanner(System.in);
		System.out.print("Enter an integer between 1-999: ");
		int number = in.nextInt();
		//in case one inputs an invalid number more than once, a while loop is used instead of an if statement
        while (number>999 || number<1)
		{
			System.out.println("Your input is invalid. Please try again.");
			System.out.print("Enter an integer between 1-999: ");
			number = in.nextInt();
		}
		int hundreds = (number / 100);
		int tens = (number / 10) % 10;
		int ones = (number) % 10;
		System.out.println("The integer you have inputted is " + number);
		System.out.println("The sum of the digits of the integer is " + (hundreds + tens + ones));

		//program repeatability
		Scanner sc = new Scanner(System.in);
		System.out.print("Would you like to try again (y/n)?");
		String name = sc.next();
		String firstname = name.substring(0,1);
		//input lowercase or uppercase n will break outer while loop and terminate program
		if (firstname.equals("n") || firstname.equals("N"))
		{
			System.out.println("Thank you for using my program! Created by Justin Wong");
			return;
		}
	}
	}
}