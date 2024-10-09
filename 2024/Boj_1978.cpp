#include <iostream>

using namespace std;

int main(){
    int n=0;        // 입력받을 수의 개수
    int number= 0;  // 입력받을 n개이 수
    int count=0;    // 소수인 입력받은 수..?
    int result = 0;    // 최종 소수의 수

    cin >> n;

    for(int i=0; i<n; i++){
        cin >> number ;
        for(int div=1; div<=number; div++){
            if(number % div == 0){
                count++;
            }
        }
        if(count == 2){
            result++;
        }
        count = 0;
    }
    cout << result << endl;
}