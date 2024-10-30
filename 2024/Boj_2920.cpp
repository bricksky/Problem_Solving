#include <iostream>
using namespace std;

int main(){
    int arr[8];
    int asc = 0;
    int dsc = 0;

    for(int i=0; i<8; i++){
        cin >> arr[i];

        if(arr[i] == i+1){
            asc += 1;
        } else if(arr[i] == 8-i){
            dsc += 1;
        }
    }
    if(asc == 8){
        cout << "ascending" << '\n';
    } else if(dsc == 8){
        cout << "descending" << '\n';
    } else {
        cout << "mixed" << '\n';
    }
    return 0;
}