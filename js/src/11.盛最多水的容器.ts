/*
 * @lc app=leetcode.cn id=11 lang=typescript
 *
 * [11] 盛最多水的容器
 */

// @lc code=start
function maxArea(height: number[]): number {
	let left = 0;
	let right = height.length - 1;
	let maxArea = 0;
 
	while (left < right) {
	  const area = Math.min(height[left], height[right]) * (right - left);
	  maxArea = Math.max(maxArea, area);
 
	  if (height[left] < height[right]) {
		 left++;
	  } else {
		 right--;
	  }
	}
 
	return maxArea;
 }
// @lc code=end

