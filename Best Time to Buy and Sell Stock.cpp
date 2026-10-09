#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
	int maxProfit(vector<int>& prices) {
		// buy는 구매 가격의 최소, sell은 수익의 최대

		// buy를 첫번째 원소, sell을 0(수익 0)으로 초기화
		int buy = prices[0], sell = 0;

		// 모든 원소 순회
		for (int& i : prices)
		{
			buy = min(i, buy); // 현재 가격 중 최소 가격으로 갱신
			sell = max(sell, i - buy); // 수익은 현재 원소 - 최소 가격 중 최대로 갱신
		}

		// 최대 수익 반환
		return sell;
	}
};

int main()
{
	return 0;
}