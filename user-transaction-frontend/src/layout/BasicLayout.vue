<template>
  <van-nav-bar
      v-if="title!=='登录'"
      class="custom-tabbar"
      :title="title"
      left-text="返回"
      left-arrow
      @click-left="onClickLeft"
  />
  <van-nav-bar
      v-if="title==='登录'"
      class="custom-tabbar"
      :title="title"
  />
  <div id="content" class="content">
    <router-view />
  </div>
    <van-tabbar route v-if="!route.meta.hideTabBar" >
      <van-tabbar-item replace to="/" icon="home-o">主页</van-tabbar-item>
      <van-tabbar-item replace to="/PushGood" icon="add-o">发布</van-tabbar-item>
      <van-tabbar-item replace to="/message" icon="chat-o">消息</van-tabbar-item>
      <van-tabbar-item replace to="/User" icon="manager-o">我的</van-tabbar-item>
    </van-tabbar>
</template>

<script setup>
//点击返回键事件
import {useRoute, useRouter} from "vue-router";
import {ref} from "vue";
import routes from "../config/router.ts";

const router=useRouter();
const route=useRoute();
//默认标题
const DEFAULT_TITLE ='白糖';
const title=ref(DEFAULT_TITLE);

/**
 * 根据路由切换标题
 */
router.beforeEach((to, from) =>{
  const toPath = to.path;
  const route = routes.find((route) => {
    return toPath == route.path;
  })
  title.value = route?.title ?? DEFAULT_TITLE;
})
//当点击返回的时候，返回到上一次访问的页面
const onClickLeft = () => router.back();
// const active = ref('index');
const onChange = (index) => Toast(`标签 ${index}`);
</script>
<style>
.content{
  margin-bottom: 40px;
}
</style>