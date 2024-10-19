#include <iostream>
#include <cstring>
#include <vector>
#include <sstream>
#include <cctype>

using namespace std;

// java인지 판단하는 함수. 대문자가 있으면 true
bool isJava(const string& str){
    for(auto& x : str)
        if(isupper(x)){
          return true;  
         } 
        return false;
}

// cpp인지 판단하는 함수. _언더바가 있으면 true
bool isCpp(const string& str){
    for(auto& x : str){
        if( x == '_' ){
            return true;
        }
    }
    return false;
}

// 두 함수에 해당되지 않는 경우는 모두 예외처리
bool isError(const string& str){
    bool underbar = false;
    bool upper = false;

    for(const auto& x : str){
        if(x == '_'){
            underbar = true;        
        } else if(isupper(x)) 
            upper = true; 
    }

    if(underbar && upper){
        return true;
    }

    // 첫 문자가 대문자이거나 '_'인지 확인
    else if(isupper(str[0]) || str[0] == '_')
        return true;

    // 마지막 문자가 '_'인지 확인
    else if(*(str.end()-1) == '_') 
        return true;

    // '_'이 연속해서 나오는지 확인
    for(int i=0; i<str.length()-1; ++i)
        if(str[i] == '_' && str[i+1] == '_')
        return true;
    
    // 모든 경우를 통과한 경우에는 error가 아님.
    return false;
}

// Java 형식의 변수를 C++로 바꾼다.
string JtoC(const string& var){
    string str = " ";
    for(const auto& x : var){
        if(isupper(x)){
            str += '_';
            str += tolower(x);
        } else (str += x);
    }
    return str;
}

// C++ 형식의 변수를 Java로 바꾼다.
string CtoJ(const string& var){
    string str = " ";
    bool changeFlag = false;

    for(const auto& x : var){
        if(x == '_'){
            changeFlag = true;
        } else {
            if(changeFlag){
                str += toupper(x);
                changeFlag = false;
            } else {
                str += x;
            }
        }
    }
    return str;
}

int main(){
    string varName;
    cin >> varName;

    if(isError(varName)){
        cout << "Error!";
    }
    else if(isCpp(varName)){
        cout << CtoJ(varName);
    }
    else if(isJava(varName)){
        cout << JtoC(varName);
    }
    else {
        cout << varName;
    }    
}