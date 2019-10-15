#include <iostream>
#include <string>
#include <fstream>
#include <iomanip>
using namespace std;

int main ()
{
    int rate_zone1 = 40;
    int rate_zone2 = 25;
    int rate_zone3 = 15;
    double total_cost = 0;

    string day_of_week;
    int hh; //hour
    int mm; //minute
    char delim; //for the semi-colon
    int start_time_mod; //mod = minute of day
    int time_calc_mod; //mod = minute of day
    int duration;
    int duration_calc;
    int dow;
    double cost;
    int rate_zone;

    ifstream inputFile;
    //ofstream outputFile;

    inputFile.open ("call_history.txt");

    cout << "Day of Week\tTime\tDuration\tCost"  << endl;
    cout << "-----------------------------------------------" << endl;


    while (inputFile >> day_of_week >> hh >> delim >> mm >> duration)
    {
        //convert hh:mm to minute of day
        start_time_mod = hh * 60 + mm;
        duration_calc = duration;
        time_calc_mod = start_time_mod;
        cost = 0;
        //convert day_of_week into number
        if (day_of_week == "Mo")
        {
            dow = 0;
        }
        else if (day_of_week == "Tu")
        {
            dow = 1;
        }
        else if (day_of_week == "We")
        {
            dow = 2;
        }
        else if (day_of_week == "Th")
        {
            dow = 3;
        }
        else if (day_of_week == "Fr")
        {
            dow = 4;
        }
        else if (day_of_week == "Sa")
        {
            dow = 5;
        }
        else if (day_of_week == "Su")
        {
            dow = 6;
        }

    //open <output_file_name>
	//cout >> day_of_week, " ", time, " ", duration, " "

        while (duration_calc > 0)
        {
            duration_calc--;

            //determine the rate zone
            if (dow >= 5)
            {
                rate_zone = rate_zone3;
                //cout << "Test3" << endl;
            }
            else if (time_calc_mod >= 480 && time_calc_mod < 1080)
            {
                rate_zone = rate_zone1;
                //cout << "Test1"<< endl;
            }
            else
            {
                rate_zone = rate_zone2;
                //cout << "Test2"<< endl;
            }

            //calculate cost
            cost += rate_zone;
            time_calc_mod += 1;
            while (time_calc_mod == 1440)
            {
                time_calc_mod = 0;
                if (dow == 6)
                {
                    dow = 0;
                }
                else
                {
                    dow += 1;
                }
            }
        }
        total_cost += cost;
        cout << day_of_week << "\t\t" << hh << ":";
        cout << setfill('0') << setw(2) << mm; //I googled for setfill
        cout << "\t" << duration << "\t\t" << "$";
        cout << fixed << setprecision (2) << cost/100 << endl;
//        cout << dow << "\t\t" << time_calc_mod << "\t" << duration_calc << "\t" << rate_zone << endl << endl;
    }
    cout << "\t\t\t-----------------------" << endl;
    cout << "\t\t\tTotal Cost:\t$";
    cout << fixed << setprecision (2) << total_cost/100 << endl;
    return 0;
}
