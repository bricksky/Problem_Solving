#include <iostream>

using namespace std;

int main(){
    int n;
    
    while (true)
    {
        cin >> n;

        // 종료되는 조건
        if(n == -1)
            break;
        
        int sum = 0;
        int t = 0;
        int arr[50'000];

        // 약수 구하는 부분
        for(int i=1; i<n; i++){
            if(n % i == 0){
                arr[t++] = i;
                sum += i;
            }
        }

        // 완전수 여부 판단하는 부분
        if(sum == n){
            cout << n << " = ";
            for(int i=0; i<t; i++){
                if(i == t-1){
                    cout << arr[i];
                } else {
                    cout << arr[i] << " + ";
                }
            }
            cout << endl;
        } else {
            cout << n << " is Not Perfect." << endl;
        }
    }
    return 0;
}