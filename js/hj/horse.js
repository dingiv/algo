


function goto(k, x, y, dp, step) {
   const node = dp[x]?.[y]
   if (node === undefined) return
   if (step < node) {
      dp[x][y] = step
      for (let i = 2; i < k + 1; ++i) {
         goto(k, x + 1, y + i, dp, step + 1)
         goto(k, x - 1, y + i, dp, step + 1)
         goto(k, x + 1, y - i, dp, step + 1)
         goto(k, x - 1, y - i, dp, step + 1)
         goto(k, x + i, y + 1, dp, step + 1)
         goto(k, x - i, y + 1, dp, step + 1)
         goto(k, x + i, y - 1, dp, step + 1)
         goto(k, x - i, y - 1, dp, step + 1)
      }
   }
}

function createMatrix(m, n, f) {
   const result = []
   for (let i = 0; i < m; i++) {
      result[i] = []
      for (let j = 0; j < n; j++) {
         result[i][j] = f(i, j)
      }
   }
   return result
}


const dp = createMatrix(3, 5, () => Number.MAX_SAFE_INTEGER)
goto(4, 0, 0, dp, 0)
console.log(dp)


