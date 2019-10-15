import java.util.Scanner;

public class VendingMachine
{
	public static void main(String[] args)
	{

	int inventory [] = {2, 2, 2};

	while (true)
	{
		//declare payment values
		int val_paym_qu 		= 25;
		int val_paym_di 		= 10;
		int val_paym_ni 		= 5;
		int val_paym_pe 		= 1;
		//declare item values
		int price_potchip		= 125;
		int price_cookie		= 85;
		int price_candy		= 95;
		//Reset payment values
		int tot_payment		= 0;
		int new_tot_payment 	= 0;
		int numb_qu		 	= 0;
		int numb_di			= 0;
		int numb_ni			= 0;
		int numb_pe			= 0;
		//reset change values
		int amount_change	   	= 0;
		int new_amount_change	= 0;
		int numb_qu_change	= 0;
		int new_numb_qu_change	= 0;
		int numb_di_change	= 0;
		int new_numb_di_change	= 0;
		int numb_ni_change	= 0;
		int new_numb_ni_change	= 0;
		int numb_pe_change	= 0;
		int new_numb_pe_change	= 0;
		//reset inventory values
		int new_inv_potchip	= 0;
		int new_inv_cookie	= 0;
		int new_inv_candy		= 0;
		//conditions
		boolean dispense_ok = false;
		boolean enough_payment = false;
		boolean need_change = false;
		//initialize selection values
		int selection 	= 0;
		int cost		= 0;

		System.out.println("----------------------------");
		System.out.println("Inventory: ");
		System.out.println("1) Potato Chips ($1.25)	:		" + inventory[0]);
		System.out.println("2) Cookies ($0.85)	:		" + inventory[1]);
		System.out.println("3) Candy ($0.95)	: 		" + inventory[2]);
		System.out.println("----------------------------");

		Scanner in = new Scanner(System.in);

		//Ask how many quarters -> numb_qu
		System.out.print("Enter number of quarters: ");
		numb_qu = in.nextInt();
		new_tot_payment = tot_payment + numb_qu * val_paym_qu;
		tot_payment = new_tot_payment;

		//Ask how many dimes -> numb_di
		System.out.print( "Enter number of dimes: ");
		numb_di = in.nextInt();
		new_tot_payment = tot_payment + numb_di * val_paym_di;
		tot_payment = new_tot_payment;

		//Ask how many nickles -> numb_ni
		System.out.print( "Enter number of nickels: ");
		numb_ni = in.nextInt();
		new_tot_payment = tot_payment + numb_ni * val_paym_ni;
		tot_payment = new_tot_payment;

		//Ask how many pennies -> numb_pe
		System.out.print( "Enter number of pennies: ");
		numb_pe = in.nextInt();
		new_tot_payment = tot_payment + numb_pe * val_paym_pe;
		tot_payment = new_tot_payment;

		//Ask for selection:
		System.out.println("----------------------------");
		System.out.println("Your total payment is $" + (tot_payment / 100) + "." + ((tot_payment/10) % 10) + (tot_payment % 10));

		System.out.println("----------------------------");
		System.out.print("Enter your selection (integer 1,2,3): ");
		selection = in.nextInt();

		//determine selection and check stock
		while (selection < 1 || selection > 3)
		{
			System.out.println("Invalid selection");
			System.out.print("Enter your selection again: ");
			selection = in.nextInt();
		}
		if (selection == 1 && inventory [0] > 0)
		{
			cost = price_potchip;
			dispense_ok = true;
		}
		else if (selection == 2 && inventory [1] > 0)
		{
			cost = price_cookie;
			dispense_ok = true;
		}
		else if (selection == 3 && inventory [2] > 0)
		{
			cost = price_candy;
			dispense_ok = true;
		}
		else
		{
			System.out.println("Out of Stock. Transaction voided.");
		}

		//payment vs. cost
		if (tot_payment == cost)
		{
			enough_payment = true;
			need_change = false;
		}
		else if (tot_payment < cost)
		{
			enough_payment = false;
			need_change = false;
		}
		else if (tot_payment > cost)
		{
			enough_payment = true;
			need_change = true;
		}

		//Adjust Inventory
		if (selection == 1 && inventory [0] > 0 && enough_payment == true)
		{
			new_inv_potchip = inventory [0] - 1;
			inventory [0] = new_inv_potchip;
		}
		else if (selection == 2 && inventory [1] > 0 && enough_payment == true)
		{
			new_inv_cookie = inventory [1] - 1;
			inventory [1] = new_inv_cookie;
		}
		else if (selection == 3 && inventory [2] > 0 && enough_payment == true)
		{
			new_inv_candy = inventory [2] - 1;
			inventory [2] = new_inv_candy;
		}

		//Payment and Change
		while (true)
		{
			//NO STOCK
			if (dispense_ok == false)
			{
				break;
			}

			//NO MONEY
			if (enough_payment == false)
			{
				System.out.println("Not enough funds. Transaction voided.");
				break;
			}

			//DISPENSE ITEM NO CHANGE
			else if (enough_payment == true && need_change == false)
			{
				if (selection == 1)
				{
					System.out.println( "Please take your Potato Chips" );
				}
				else if (selection == 2)
				{
					System.out.println( "Please take your Cookies" );
				}
				else if (selection == 3)
				{
					System.out.println( "Please take your Candies" );
				}

				//numb_change values should be 0
				System.out.println( "Your change is given as :" );
				System.out.println("quarter(s)	: " + numb_qu_change);
				System.out.println("dime(s)		: " + numb_di_change);
				System.out.println("nickel(s)	: " + numb_ni_change);
				System.out.println("penny(ies)	: " + numb_pe_change);
				break;
			}

			//DISPENSE ITEM & CHANGE
			else if (enough_payment == true && need_change == true)
			{
				amount_change = tot_payment - cost;

				while (amount_change >= val_paym_qu)
				{
					new_numb_qu_change = numb_qu_change + 1;
					numb_qu_change = new_numb_qu_change;
					new_amount_change = amount_change - val_paym_qu;
					amount_change = new_amount_change;
				}

				while (amount_change >= val_paym_di)
				{
					new_numb_di_change = numb_di_change + 1;
					numb_di_change = new_numb_di_change;
					new_amount_change = amount_change - val_paym_di;
					amount_change = new_amount_change;
				}
				while (amount_change >= val_paym_ni)
				{
					new_numb_ni_change = numb_ni_change + 1;
					numb_ni_change = new_numb_ni_change;
					new_amount_change = amount_change - val_paym_ni;
					amount_change = new_amount_change;
				}
				while (amount_change >= val_paym_pe)
				{
					new_numb_pe_change = numb_pe_change + 1;
					numb_pe_change = new_numb_pe_change;
					new_amount_change = amount_change - val_paym_pe;
					amount_change = new_amount_change;
				}

				if (selection == 1)
				{
					System.out.println( "Please take your Potato Chips" );
				}
				else if (selection == 2)
				{
					System.out.println( "Please take your Cookies" );
				}
				else if (selection == 3)
				{
					System.out.println( "Please take your Candies" );
				}
				else
				{
					break;
				}

				System.out.println( "Your change is given as :" );
				System.out.println("quarter(s)	: " + numb_qu_change);
				System.out.println("dime(s)		: " + numb_di_change);
				System.out.println("nickel(s)	: " + numb_ni_change);
				System.out.println("penny(ies)	: " + numb_pe_change);
				break;
			}
		}//while(true)

		//Return to START
		Scanner sc = new Scanner(System.in);
		System.out.print("Would you like to try again (y/n)?");
		String name = sc.next();
		String firstname = name.substring(0,1);

		//input lowercase or uppercase n will break outer while loop and terminate program
		if (firstname.equals("n") || firstname.equals("N"))
		{
			System.out.println("Thank you for using my vending machine program! Created by Justin Wong");
			return;
		}
	} //while
	} //main
} //class