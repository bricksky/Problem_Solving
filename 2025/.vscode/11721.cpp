#include <iostream>

using namespace std;

int main(){
    string N = "";
    cin >> N;

    for(int i=0; i<N.size(); i++){
        cout << N[i];

        if(i%10 == 9){
            cout << endl;
        }
    }
}