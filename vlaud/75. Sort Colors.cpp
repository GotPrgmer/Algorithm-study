#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

class Solution {
public:
    // 네덜란드 국기 알고리즘
    void sortColors(vector<int>& nums) {
        // l: 중간값(1)보다 작은 수가 있어야 할 자리를 가리키는 인덱스
        // m: 중간값 인덱스
        // r: 중간값보다 큰 수가 있어야 할 자리를 가리키는 인덱스

        // l과 r을 양 끝에 놓고, m으로 순회
        int l = 0, m = 0, r = nums.size() - 1;

        // m이 r을 넘어가기 전까지 반복
        while (m <= r)
        {
            if (nums[m] == 0) swap(nums[m++], nums[l++]); // 만약 현재 m의 위치가 중간값보다 작다면(0) l과 m의 원소 자리를 교체하고 두 인덱스를 옮김
            else if (nums[m] == 1) m++; // 현재 m의 위치가 중간값(1)과 같다면 교체가 필요없으니 그대로 다음으로 옮김
            else swap(nums[m], nums[r--]); // m의 위치가 중간값보다 크면(2) m과 r의 원소 자리를 교체, r의 위치는 왼쪽으로, m은 교체된 원소를 다시 체크
        }
    }
};
