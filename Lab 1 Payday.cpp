#include <iostream>
int main()
{
	//constants and variables are listed below
	const double federalTax = 0.14;
	const double socialSecurity = 0.06;
	const double stateTax = 0.05;
	const double unionFees = 10.00;
	const double salary = 16.78;
    //floating point data: double
	double hours;
	double dependents;
	double grossPay;
	double weeksPay;
	//Permits infinite loop of the below code based on Boolean variable (true/false)
	while(true){

        std::cout << "Enter hours worked here--" << std::endl;
        std::cin  >> hours;

        std::cout << "Enter number of dependents here--" << std::endl;
        std::cin  >> dependents;

        if (hours > 40)
            grossPay = (40 * salary) + ((hours - 40) * (1.5 * salary));
        else
            grossPay = (hours * salary);

        if (dependents > 2)
            weeksPay = grossPay - (grossPay * federalTax) - (grossPay * socialSecurity) - (grossPay * stateTax) - unionFees - 35;
        else
            weeksPay = grossPay - (grossPay * federalTax) - (grossPay * socialSecurity) - (grossPay * stateTax) - unionFees;
        std::cout << "Your total payment for this week is--" << weeksPay << std::endl;
    }
	return 0;
}
