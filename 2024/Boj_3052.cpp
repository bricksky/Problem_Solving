#include <iostream>

using namespace std;

int main() {
    int arr[42] = {0,  };
    int num;
    int count = 0;

    // 10개의 숫자를 입력받는 반복문
    for(int i=0; i<10; i++){
        cin >> num;
        
        // 입력받은 숫자를 42로 나누었을 떄의 나머지를 각 인덱스에 할당
        arr[num % 42] ++;
    }

    for(int i=0; i<42; i++){

        // 42로 나누어지지 않은 인덱스를 발견하면 count+1       
        if(arr[i] != 0){
            count++;
        }
    }
    cout << count << endl;
}