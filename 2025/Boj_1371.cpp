#include <iostream>
using namespace std;

int main(){
    int alphabet[26] = {0, };
    int biggest = 0;

    while(true){
        char input = 0;
        cin >> input;

        if(input == 0)
            break;
        if('a' <= input && input <= 'z')
            alphabet[input - 'a']++;
    }

    for(int i=0; i<26; i++){
        if(biggest < alphabet[i])
            biggest = alphabet[i];
    }

    for(int i = 0; i<26; i++){
        if(alphabet[i] == biggest)
            cout << char('a' + i);
    }
    return 0;
}