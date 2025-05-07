#include <bits/stdc++.h>
using namespace std;

char arr[5][15];

int main(){

    // 각 행에 들어갈 수를 입력받는 반복문
    for(int i=0; i<5; i++){
        cin >> arr[i];
    }

    // 각 열의 문자를 세로로 출력하는 반복문
    for(int j=0; j<15; j++){       // (1) 바깥 for문 (열 반복)
         for(int k=0; k<5; k++){    // (2) 안쪽 for문 (행 반복)
             if(arr[k][j] != NULL)  // (3) 조건 검사 (배열의 값이 NULL이 아니면 출력)
                 cout << arr[k][j]; // (4) 출력
             }
        }   
     return 0;
}
