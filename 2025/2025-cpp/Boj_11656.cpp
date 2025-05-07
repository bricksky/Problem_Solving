#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

int main(){
    string word;
    vector<string> v;
    
    cin >> word;

    // 접미사 찾아서 벡터에 저장하는 부분
    for(int i=0; i<word.length(); i++){
        v.push_back(word.substr(i));
    }

    // 벡터를 사전 순으로 정렬하는 부분.
    sort(v.begin(), v.end());

    // 최종 결과 출력하는 부분
    for(int i=0; i<v.size(); i++){
        cout << v[i] << '\n';
    }
    return 0;
}