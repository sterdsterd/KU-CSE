#include <iostream>
using namespace std;

int sum(int x, int y);

int sum(int x, int y) {
    int result = 0;

    for (int i = x; i <= y; i++) {
        result += i;
    }

    return result;
}

int main() {
    int n = 0;
    cout << "마지막 수를 입력하세요>>";
    cin >> n;

    cout << "1부터 " << n << "까지의 합은 " << sum(1, n) << endl;

    return 0;
}