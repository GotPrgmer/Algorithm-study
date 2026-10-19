#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;
/*
왼 -> 오 방향으로 누적곱 계산
오 -> 왼 방향으로 누적곱 계산

두 값들을 곱한다
*/
class Solution {
public:
    vector<int> productExceptSelf(vector<int>& nums) {
        const int n = nums.size();
        vector<int> res(n);
        res[0] = 1;

        for (int i = 1; i < n; i++)
        {
            res[i] = res[i - 1] * nums[i - 1];
        }

        int t = 1;

        for (int i = n - 1; i >= 0; i--)
        {
            res[i] *= t;
            t *= nums[i];
        }

        return res;
    }
};