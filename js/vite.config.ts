import { defineConfig } from 'vite'
import { } from 'vitest'
import { resolve } from 'node:path'

export default defineConfig({
   resolve: {
      alias: {
         '@': resolve(__dirname),
      }
   },
   test: {
      dir: resolve("./tests")
   }
})