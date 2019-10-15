#include <iostream>
using namespace std;

int main ()
{
int inventory [] = {2, 2, 2};
char option;
while (true)
{
//declare payment values
    int val_paym_qu = 25;
    int val_paym_di = 10;
    int val_paym_ni = 5;
    int val_paym_pe = 1;
//declare item values
    int price_potchip   = 125;
    int price_cookie    = 85;
    int price_candy     = 95;
//Reset payment values
    int tot_payment     = 0;
    int new_tot_payment = 0;
    int numb_qu         = 0;
    int numb_di         = 0;
    int numb_ni         = 0;
//reset change values
    int amount_change       = 0;
    int new_amount_change   = 0;
    int numb_qu_change      = 0;
    int new_numb_qu_change  = 0;
    int numb_di_change      = 0;
    int new_numb_di_change  = 0;
    int numb_ni_change      = 0;
    int new_numb_ni_change  = 0;
    int numb_pe_change      = 0;
    int new_numb_pe_change  = 0;
//reset inventory values
    int new_inv_potchip     = 0;
    int new_inv_cookie      = 0;
    int new_inv_candy       = 0;
//conditions
    bool dispense_ok = false;
    bool enough_payment = false;
    bool need_change = false;
//selection values
    int selection, cost;

    cout << "----------------------------"<< endl;
    cout << "Inventory:" << endl << "Potato Chips: " << inventory [0] << endl << "Cookies:      " << inventory [1] << endl << "Candies:      " << inventory [2] << endl;
    cout << "----------------------------"<< endl;
//Ask how many quarters -> numb_qu
    cout << "Enter number of quarters: "; cin >> numb_qu;
    new_tot_payment = tot_payment + numb_qu * val_paym_qu;
    tot_payment = new_tot_payment;

//Ask how many dimes -> numb_di
    cout << "Enter number of dimes: "; cin >> numb_di;
    new_tot_payment = tot_payment + numb_di * val_paym_di;
    tot_payment = new_tot_payment;

//Ask how many nickles -> numb_ni
    cout << "Enter number of nickels: "; cin >> numb_ni;
    new_tot_payment = tot_payment + numb_ni * val_paym_ni;
    tot_payment = new_tot_payment;

//Ask for selection:
    cout << "----------------------------"<< endl;
    cout << "Your total payment is $" << tot_payment / 100 << "." << tot_payment % 100 << endl;
    cout << "----------------------------"<< endl;
    cout << "1) Potato chips $1.25" << endl;
    cout << "2) Cookies $0.85" << endl;
    cout << "3) Candies $0.95" << endl;
    cout << "Enter your selection (integer): "; cin >> selection;

//determine selection
    while (selection < 1 || selection > 3)
    {
        cout << "Invalid selection" << endl;
        cout << "Enter your selection again: "; cin >> selection;
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
                cout << "Out of stock" << endl;
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
        if (dispense_ok == false)
        {
            break;
        }
            if (enough_payment == false)
            {
                cout << "Not enough funds" << endl;
                break;
            }
                else if (enough_payment == true && need_change == false)
                {

//DISPENSE ITEM NO CHANGE
                    if (selection == 1)
                    {
                        cout << "Please take your Potato Chips" << endl;
                    }
                        else if (selection == 2)
                        {
                            cout << "Please take your Cookies" << endl;
                        }
                            else if (selection == 3)
                            {
                                cout << "Please take your Candies" << endl;
                            }
                    cout << "Your change is given as :" << endl;
                    cout <<"    quarter (s)   : " << numb_qu_change <<endl;
                    cout <<"    dime (s)      : " << numb_di_change <<endl;
                    cout <<"    nickel (s)    : " << numb_ni_change <<endl;
                    cout <<"    penny (ies)   : " << numb_pe_change <<endl;
                    break;
                }
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

//DISPENSE ITEM & CHANGE
                    if (selection == 1)
                    {
                        cout << "Please take your Potato Chips" << endl;
                    }
                        else if (selection == 2)
                        {
                            cout << "Please take your Cookies" << endl;
                        }
                            else if (selection == 3)
                            {
                                cout << "Please take your Candies" << endl;
                            }
                                else
                                {
                                    break;
                                }
                    cout << "Your change is given as :" << endl;
                        cout <<"    quarter (s)   : " << numb_qu_change <<endl;
                        cout <<"    dime (s)      : " << numb_di_change <<endl;
                        cout <<"    nickel (s)    : " << numb_ni_change <<endl;
                        cout <<"    penny (ies)   : " << numb_pe_change <<endl;
                        break;
                }
    }

//Return to START
    cout << "Do you want to try again(Press any key for yes, N for no)? ";
    cin >> option;
    if(option == 'N' || option == 'n')
        {
           break;
        }
}
return 0;
}
