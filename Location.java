/*
This program returns the largest value in a 2 dimensional array.
Row, column, and element entries are [space] separated.
The elements displayed are limited to two decimal places but still holds it's true value.
The element holds it's original value up to 16 decimal places. ie. 3.339 is displayed 3.34 but is still calculated 3.339 < 3.34
This program does not account for duplicate highest values.
It only returns the first highest value it reads starting from the top left value in the array unless it reads a higher value.
*/
import java.util.Scanner;

public class Location
{
	public static void main(String[] args)
	{
		while(true)
		{
			Scanner in = new Scanner(System.in);
			System.out.println("---------------------------------------------------");
			System.out.print("Enter the number of rows and columns in the array (integer value space separated): ");
			int r = in.nextInt();
			int c = in.nextInt();
			int e = r * c ;

			System.out.printf("You have a(n) %dx%d array with %d empty elements!%n", r , c , e );
			double[][] arr = new double[r][c];
			System.out.println("Enter the elements in the array (space separated): ");
			for(int i = 0; i < arr.length; i++)
			{
				for(int j = 0; j < arr[i].length; j++)
				{
					arr[i][j] = in.nextDouble();
				}
			}

			//print 2d array with double values limited to two decimals
			System.out.println("Here is the array you have entered: ");
			for(int i = 0; i < arr.length; i++)
			{
				for(int j = 0; j < arr[i].length; j++)
				{
					System.out.printf("%.2f    ", arr[i][j]);
				}
				System.out.println();
			}

			int[] largestLoc = locateLargest(arr);
			double largestValue = valueLargest(arr);
			System.out.printf("The location of the largest element, " + largestValue + " , is (%d,%d).%n", largestLoc[0], largestLoc[1]);

			//Return to START
			System.out.print("Would you like to try again (Enter any key for yes, N/n for no)?");
			Scanner sc = new Scanner(System.in);
			String option = sc.next();
			String firstoption = option.substring(0,1);
			//input lowercase or uppercase n will break outer while loop and terminate program
			if (firstoption.equals("n") || firstoption .equals("N"))
			{
				System.out.println("Thank you for using my array program! Created by Justin Wong");
				return;
			}
		} //while

	} //main


	public static int[] locateLargest(double[][] arr)
	{
        int[] Location = new int[]{0,0};
		double largestnum = arr[0][0];

		for(int i = 0; i < arr.length; i++)
		{
			for(int j = 0; j < arr[i].length; j++)
			{
				if(arr[i][j] > largestnum)
				{
					largestnum = arr[i][j];
					Location[0] = i;
					Location[1] = j;
				};

			};
		}
		return Location;
	}

	public static double valueLargest(double[][] arr)
    {
        double largest = arr[0][0];
        for(int i = 0; i < arr.length; i++)
        {
            for(int j = 0; j < arr[i].length; j++)
            {
                if(largest < arr[i][j])
                {
                    largest = arr[i][j];
                }
            }
        }
        return largest;
    }

} //class