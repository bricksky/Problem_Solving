#include <iostream>

using namespace std;

int main(){
    int arr[100][100] = {0};
    int num, a, b;
    int area = 0;

    cin >> num;
    for(int k=0; k<num; k++){
        cin >> a >> b;

        for(int i=a; i<a+10; i++){
            for(int j=b; j<b+10; j++){
                if(arr[i][j]==0){
                    arr[i][j] = 1;
                    area ++;
                }
            }
        }
    }
    cout << area;
    return 0;
}