#include<iostream>
#include<vector>
using namespace std;

struct Sum {
    int n, m, c;
    vector<int> a, b;
};

Sum input() {
    Sum s;
    cin >> s.n >> s.m >> s.c;
    
    for (int i = 0; i < s.n; i++) {
        int num;
        cin >> num;
        s.a.push_back(num);
    }
   
    for (int i = 0; i < s.m; i++) {
        int num;
        cin >> num;
        s.b.push_back(num);
    }
    return s;
}

void show(Sum s) {
    int count = 0;
    for (int i = 0; i < s.n; i++) {
        for (int j = 0; j < s.m; j++) {
            if (s.a[i] + s.b[j] <= s.c) {
                count++;
            }
        }
    }
    cout << count<<endl;
}

int main() {
    int n;
    cin >> n;
    vector<Sum> sm(n);
    for (int i = 0; i < n; i++) {
        sm[i] = input();
    }

    for (int i = 0; i < n; i++) {
        show(sm[i]);
    }
    return 0;
}
