import { createApp } from "vue";
import "./style.css";
import App from "./App.vue";
// 导入Element Plus
import ElementPlus from "element-plus";
import "element-plus/dist/index.css";

const app = createApp(App);

// 使用Element Plus
app.use(ElementPlus);

app.mount("#app");
