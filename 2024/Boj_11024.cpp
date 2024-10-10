#include <iostream>
#include <sstream>

using namespace std;

int main(){

    int n;
    cin >> n;
    cin.ignore();

    while(n--){
        string s;

        getline(cin, s);

        stringstream sumstream(s);

        int sum = 0;    
        int result;

       while(sumstream >> result){
        sum += result;
       }
       cout << result << '\n';
    }
    return 0;
}