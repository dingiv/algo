import { test } from "vitest";

import findAnagrams from "@/dbptr/438.找到字符串中所有字母异位词";

test("test 438", () => {
   console.log(findAnagrams("cbaebabacd", "abc"));
   console.log(findAnagrams("abab", "ab"));
   console.log(findAnagrams("baa", "aa"));
});

test("test sdf", () => {
   const arr = new Array(10).fill(0).map((x) => 1);
   console.log(arr);

   arr.reduce((a, b) => console.log(a, b), ["12"]);
});


const user = { name: 'zs' }
const fn = new Proxy(() => { }, {
   apply(target, thisArg, argumentsList) {
      console.log("apply");
   },
   get(target, prop, receiver) {
      console.log("get");
      return Reflect.get(user, prop, receiver);
   }
})

test('test 746', () => {
   fn()
   console.log(fn.name)
})