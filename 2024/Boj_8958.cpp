#include <iostream>
#include <cstring>

using namespace std;

int main(){
    int n;
    cin >> n;

    for(int i=0; i<n; i++){
        char arr[80] = {0, };
        int result = 0;
        int finaleResult = 0;

        cin >> arr; 

        for(int j=0; j<strlen(arr); j++){
            if(arr[j] == 'O'){
                result += 1;
                finaleResult += result;
            } else {
                result = 0;
            }
        }
        cout << finaleResult << '\n';
    }
    return 0;
}