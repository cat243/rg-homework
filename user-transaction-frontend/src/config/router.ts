import Index from "../page/index.vue";
import User from "../page/User.vue";
import pushgood from "../page/pushgood.vue";
import chat from "../page/Chat.vue";
import Setting from "../page/Setting.vue";
import UserInfo from "../page/UserInfo.vue";
import PersonalData from "../page/PersonalData.vue";
import GoodsInfo from "../page/GoodsInfo.vue";
import UserLoginPage from "../page/UserLoginPage.vue";
import RegisterPage from "../page/RegisterPage.vue";

const routes = [
    {path: '/', title:'主页',component: Index},
    {path: '/PushGood', title:'发布', component: pushgood},
    {path: '/message', title:'消息', component: chat},
    {path: '/User',  title:'用户',component: User},
    {path: '/User/Setting',  title:'设置',component: Setting},
    {path: '/Person',title:'个人资料',component: PersonalData},
    {path:'/Goods/Info/',title:'商品信息',component:GoodsInfo,meta:{hideTabBar:true}},
    {path: '/user/login', title:'登录',component: UserLoginPage,meta:{hideTabBar:true} },
    {path:'/user/register',title:'用户注册',component:RegisterPage,meta:{hideTabBar:true}}
]
export default routes;