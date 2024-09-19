#include <iostream>
#include <cstring>

using namespace std;

int main(){
    int inputCount;
    string words;
    int resultCount = 0;

    cin >> inputCount;

    for(int i=0; i<inputCount; i++){
        cin >> words;

        if(words.length() <= 2) {
            continue;
        } else {
            for(int j=0; j<words.length()-1; j++){
                if(words[j] != words[j+1]){
                    if(words.find(words[j],j+2) != string::npos){
                        resultCount++;
                        break;
                    }
                }
            }
        }
    }
    cout << inputCount - resultCount; 
}