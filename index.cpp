#include <iostream>
#include <fstream>

using namespace std;

class User {
private:
    string userId;
    string password;

public:
    void login();
    void registration();
    void forgot();
};

void User::login() {
    int count = 0;
    string inputUserId, inputPassword;
    //system("cls");

    cout << "\t\t\t Please enter the username and password: " << endl;
    cout << "\n\n\t\t\t\t\t Username: ";
    cin >> inputUserId;
    cout << "\t\t\t Password: ";
    cin >> inputPassword;

    ifstream inputFile("records.txt");
    while (inputFile >> userId >> password) {
        if (userId == inputUserId && password == inputPassword) {
            count = 1;
        }
    }
    inputFile.close();

    if (count == 1) {
        cout << "\n\n\t\t\t\t\t Welcome, you are logged in  " << userId << " ." << endl;
    } else {
        cout << "\n\n\t\t\t\t\t Login Error, Please try again or check your username and password! \n"
             << endl;
    }
}

void User::registration() {
    system("cls");
    cout << "\t\t Please enter the username: ";
    cin >> userId;
    cout << "\n\t\t\t Enter your password: ";
    cin >> password;

    ofstream outputFile("records.txt", ios::app);
    outputFile << userId << ' ' << password << endl;
    system("cls");
    cout << "\n\t\t\tRegistration is Successful\n";
}

void User::forgot() {
    int option;
    system("cls");

    cout << "\t\t\t You forgot your password? No problem! \n";
    cout << "Press 1. Search your id by username " << endl;
    cout << "Press 2. Go back to the main menu " << endl;
    cout << "\t\t\t Enter your choice: ";
    cin >> option;

    switch (option) {
        case 1: {
            int count = 0;
            string searchUserId, foundPassword, searchId;
            system("cls");
            cout << "\n\t\t\t Enter your username you remember: ";
            cin >> searchUserId;

            ifstream inputFile("records.txt");
            while (inputFile >> searchId >> foundPassword) {
                if (searchId == searchUserId) {
                    count = 1;
                }
            }
            inputFile.close();

            if (count == 1) {
                cout << "\n\n\t\t\t\t\t User found! \n"
                     << endl;
                cout << "\n\n Your password is: " << foundPassword << endl;
            } else {
                cout << "\n\n\t\t\t\t\t User not found! \n"
                     << endl;
            }
            break;
        }
        case 2: {
            break;
        }
        default:
            cout << "\t\t\t Wrong choice please try again! \n"
                 << endl;
    }
}

int main() {
    User user;

    while (true) {
        int choice;
        cout << "\t\t\t________________________________________\n\n\n";
        cout << "\t\t              Welcome to the Login page\n\n";
        cout << "\t\t\t________        MENU        ____________\n\n";
        cout << "\n\n";
        cout << "\t\t\t|  Press 1 to LOGIN                    |" << endl;
        cout << "\t\t\t|  Press 2 to REGISTER                 |" << endl;
        cout << "\t\t\t|  Press 3 if you forgot your PASSWORD |" << endl;
        cout << "\t\t\t|  Press 4 to Exit                     |" << endl;
        cout << "\n\t\t\tPlease Enter your choice :";
        cin >> choice;
        cout << endl;

        switch (choice) {
            case 1:
                user.login();
                break;
            case 2:
                user.registration();
                break;
            case 3:
                user.forgot();
                break;
            case 4:
                cout << "\n\n\t\t\tThank you for using this program :)" << endl;
                exit(0);
                break;
            default:
                cout << "\n\n\t\t\t Invalid Input, Please select from the options given above \n"
                     << endl;
        }
    }
}