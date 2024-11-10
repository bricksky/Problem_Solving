#include <iostream>
#include <string>
#include <algorithm>

using namespace std;

int main(){
   string n;

   while(n!="0"){
    cin >> n;
    string result = n;

    reverse(n.begin(), n.end());

    if(n=="0"){
        break;
    } else if(n==result){
        cout << "yes" << '\n';
    } else{
        cout << "no" << '\n';
    }
   }
   return 0;
}