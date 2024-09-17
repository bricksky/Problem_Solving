#include <iostream>
using namespace std;

int main(){
    string input;
    cin >> input;
    int maxCount=0;
    int index = 0;
    int count = 0;

    int alphabet[26] = {0, };

    for(int i=0; i<input.length(); i++){
        if(input[i]<97){
            // 대문자로 입력받은 경우
            alphabet[input[i]-65]++;
        } else {
            // 소문자로 입력받은 경우
           alphabet[input[i]-97]++;
        }
    }

    for(int i=0; i<26; i++){
        if(alphabet[i] > maxCount){
            maxCount = alphabet[i];
            index = i;
        }
    }

    for(int i=0; i<26; i++){
        if(alphabet[i] == maxCount){
            count++;
            if(count >= 2){
                cout << "?" << endl;
                return 0;
            }
        }
    }
    cout << (char)(index+65) << endl;
    return 0;
}