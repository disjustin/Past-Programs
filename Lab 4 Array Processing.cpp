#include <iostream>
#include <string>
#include <fstream>

using namespace std;

int main ()
{
     ifstream file;
     string filename;
     const int SIZE = 20;
    int arr[SIZE], highest, lowest, sum;
    int count = 0;

     cout << "Enter the file name: ";
     cin >> filename;

     file.open (filename);

     while (!file)
     {
        cout << "Error. Please try again.\nEnter the file name: ";
          cin >> file_name;
         file.open (filename);
    }

     while (file >> arr[count])
     {
         cout << arr[count] << endl;
         count++;
    }

     sum = lowest = highest = arr[0];

     for (int i = 1; i < count; i++)
     {
         if (arr[i] > highest)
         {
             highest = arr[i];
         }
         if (arr[i] < lowest)
         {
             lowest = arr[i];
        }
        su m += arr[i];
    }
    co ut << "\nThere are " << count << " values in this file." << endl;
    cou t << "The highest value is: " << highest << endl;
    cout  << "The lowest value is: " << lowest << endl;
    cout  << "The total sum of values is: " << sum << endl;
     cout << "The average value is: " << sum / count << endl;
    file.c  lose ();
return 0;
}
