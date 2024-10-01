import { createApp } from 'vue'
import App from './App.vue'
import Vant from 'vant';
import * as VueRouter from 'vue-router';
import routes from "./config/router.ts";
import { Lazyload } from 'vant';
//  引入组件样式
import 'vant/lib/index.css';
const app = createApp(App);
//将vant组件进行全局的引入
app.use(Vant);


const router = VueRouter.createRouter({
    // 4. 内部提供了 history 模式的实现。为了简单起见，我们在这里使用 hash 模式。
    history: VueRouter.createWebHistory(),
    routes, // `routes: routes` 的缩写
})

app.use(router);
app.mount('#app');
app.use(Lazyload);