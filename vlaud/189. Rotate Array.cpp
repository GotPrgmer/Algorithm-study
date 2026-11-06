#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

class Solution {
public:
    void rotate(vector<int>& nums, int k) {
        // 전체를 뒤집고
        reverse(begin(nums), end(nums));

		// 0~k-1, k~n-1 구간을 뒤집는다 
        reverse(begin(nums), begin(nums) + k);
        reverse(begin(nums) + k, end(nums));
    }
};