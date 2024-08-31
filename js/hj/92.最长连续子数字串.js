
const readline = require('readline')

const rl = readline.createInterface({
   input: process.stdin
})

rl.on('line', (line) => {
   console.log(findLongestNumber(line))
})

function findLongestNumber(line) {
   const matches = line.matchAll(/\d+/g)
   const arr = Array.from(matches)
      .map((m) => ({ value: m[0], length: m[0].length }))
      .sort((a, b) => b.length - a.length)
   const maxLength = arr[0].length
   const result = arr.filter((x) => x.length === maxLength)
   const str = result.reduce((r, x) => r + x.value, '')
   return `${str},${maxLength}`
}