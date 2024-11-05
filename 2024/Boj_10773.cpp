#include <iostream>
#include <stack>

using namespace std;

int main(){
    int k;
   
    stack<int> stack;
    
    cin >> k;

   for(int i; i<k; i++){
        int num;
        cin >> num;

        if(num==0){
            stack.pop();
        } else {
            stack.push(num);
        }
   }
   int sum = 0;

   while(!stack.empty()){
    sum += stack.top();
    stack.pop();
   }

   cout << sum;
}