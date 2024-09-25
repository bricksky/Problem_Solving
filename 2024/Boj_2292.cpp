#include <iostream>

using namespace std;

int main(){
    int number;
    int count = 1;
    int layer = 1;

    cin >> number;
    
    while(number > count){
        count += 6*layer; 
        layer++;
    }

    cout << layer;
    return 0;
}