#include <iostream>
#include <queue>

using namespace std;

int main(){
    // 입력받는 부분
    int N,K;
    cin >> N >> K;
    
    queue<int> q;
    for(int i=1; i<=N; i++){
        q.push(i);
    }

    cout << "<";

    // 문제의 직접적인 부분
    while (q.size() >1){
        for(int i=1; i<K; i++){
            int tmp = q.front();
            q.pop();
            q.push(tmp);
        }
        cout << q.front() << ", ";
        q.pop();
    }
    cout << q.front() << ">" << endl;
}
