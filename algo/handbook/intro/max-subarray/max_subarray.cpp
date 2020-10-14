#include <bits/stdc++.h>
using namespace std;

class Solution {
 public:
  int maxSubArray(vector<int>& nums) {
    if (nums.size() == 0) {
      return 0;
    }
    vector<int> DP(nums.size());
    DP[0] = nums[0];
    for (int i = 1; i < nums.size(); i++) {
      DP[i] = max(nums[i], DP[i-1] + nums[i]);
    }
    int gMax = DP[0];
    for (int i = 1; i < DP.size(); i++) {
      if (gMax < DP[i]) {
        gMax = DP[i];
      }
    }
    return gMax;
  }
};
  
int main() {
  vector<int> arr{ 10, 20, -50, 2, 12};
  Solution s;
  int output = s.maxSubArray(arr);
  cout << output << "\n";
}
