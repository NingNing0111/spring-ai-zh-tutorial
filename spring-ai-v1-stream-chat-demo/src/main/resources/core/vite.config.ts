import { defineConfig } from "vite";
import vue from "@vitejs/plugin-vue";
// 引入自动导入
import AutoImport from "unplugin-auto-import/vite";
// 自动导入UI组件
import Components from "unplugin-vue-components/vite";

import { resolve } from "path";

// https://vitejs.dev/config/
export default defineConfig({
  build: {
    outDir: "../static", // 打包出来的项目名称
  },
  base: "./",
  plugins: [
    vue(),
    AutoImport({
      // 不在需要导入ref，reactive等
      imports: ["vue", "vue-router"],
      // 存放的位置
      dts: "src/auto-import.d.ts",
    }),
    Components({
      // 引入组件的信息存放位置
      dts: "src/components.d.ts",
    }),
  ],
  resolve: {
    alias: {
      "@": resolve(__dirname, "./src"),
    },
  },
  server: {
    port: 3000,
    host: "0.0.0.0",
  },
});
