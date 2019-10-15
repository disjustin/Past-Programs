import java.util.Scanner;

public class BoxString
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("Tell me your name: ");
		String name = sc.next();
		boxString("Hello " + name);
	}

	public static String boxString(String str)
	{
		int n = str.length();
		for (int i = 0; i < n + 2; i++)
		{
			System.out.print("-");
		}
		System.out.println();
		System.out.println("!" + str + "!");
		for (int i = 0; i < n + 2; i++)
		{
			System.out.print("-");
		}
		System.out.println();
		return str;

	}
}