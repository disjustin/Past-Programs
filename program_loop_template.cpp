/*
Template for program reusability.
Once program is complete, prompt user input to restart or exit.
Only takes first character of input.
Type N or n to exit program, else retry.
*/
#include <iostream>
using namespace std;

int main() {
char option;
while(true) {

    /*
        Code goes here
    */

    cout << "\nDo you want to try again(Press any key for yes, N for no)? ";
    cin >> option;
    cin.clear();
    fflush(stdin);
    if(tolower(option) == 'n') {
        break;
    }
}
return 0;
}
