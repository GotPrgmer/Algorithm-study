#include <iostream>
#include <vector>
#include <unordered_map>

using namespace std;
class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        unordered_map<int, int> mp;

        for (int i = 0; i < nums.size(); i++)
        {
            int r = target - nums[i];
            if (mp.count(r)) return { mp[r], i };
            mp[nums[i]] = i;
        }

        /*
        쉽게 말해 target - 현재 원소의 값이 이전에 존재했는지를 확인하면 된다.
        target = 9이고, 현재 원소 = 7이라면
        9 - 7 = 2가 이전에 있었던 원소인지를 확인하면 된다.

        nums = [2,7,11,15] 라면

         i
        [2,7,11,15]
        현재 인덱스 i가 2를 가리킨다.
        해시맵에 키(원소):값(인덱스)의 형식으로 저장한다

        해시맵 = {2, 0}
           i
        [2,7,11,15]

        현재 i가 7을 가리킨다.
        target이 9이므로 9-7=2에 해당하는 키를 해시맵에서 검사한다.
        결과 {2,0}이 나오므로 값에 해당하는 0과 현재 인덱스 1을 배열화 해서 반환한다.
        */
        return {};
    }
};
int main()
{

	return 0;
}