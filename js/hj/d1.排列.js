function permute(nums) {
   const result = [];
   const used = Array(nums.length).fill(false);

   const dfs = (path) => {
      if (path.length === nums.length) {
         result.push(Array.from(path));
         return;
      }

      for (let i = 0; i < nums.length; i++) {
         if (used[i]) continue;
         path.push(nums[i]);
         used[i] = true;
         dfs(path);
         path.pop();
         used[i] = false;
      }
   }

   dfs([]);
   return result;
}

// 测试
const nums = [1, 2, 3, 4];
const permutations = permute(nums);
console.log(permutations);
// 输出: [
//   [1, 2, 3],
//   [1, 3, 2],
//   [2, 1, 3],
//   [2, 3, 1],
//   [3, 1, 2],
//   [3, 2, 1]
// ]


function permute2(nums) {
   const result = [];

   function dfs(start) {
      if (start === nums.length - 1) {
         result.push([...nums]);
         return;
      }

      for (let i = start; i < nums.length; i++) {
         [nums[start], nums[i]] = [nums[i], nums[start]]; // 交换
         dfs(start + 1); // 递归生成下一个位置的排列
         [nums[start], nums[i]] = [nums[i], nums[start]]; // 回溯
      }
   }

   dfs(0);
   return result;
}

const permutations2 = permute2(nums);
console.log(permutations2);
// 输出: [
//   [1, 2, 3],
//   [1, 3, 2],
//   [2, 1, 3],
//   [2, 3, 1],
//   [3, 1, 2],
//   [3, 2, 1]
// ]