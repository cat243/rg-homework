<script setup>
import {onMounted, ref} from "vue";
import myAxios from "../plugins/myAxios.js";
import {showFailToast, showSuccessToast} from "vant";
import { format } from 'date-fns';
const user=ref('');//当前的登录用户
//将后端传入的性别1,0分别转化为男，女的函数
function convertGender(genderCode) {
  if (genderCode === 1) {
    return "男";
  } else if (genderCode === 0) {
    return "女";
  } else {
    return "未知";
  }
}

//获取当前登录用户的信息
onMounted(async ()=>{
  const res = await myAxios.get('/user/get/login');
  if (res.code === 0){
    user.value =res.data;
  }else {
    showFailToast('获取用户信息失败');
  }
})
</script>

<template>
  <van-cell title="昵称" is-link :value="user?.userName" />
  <van-cell title="头像" is-link>
    <img style="height: 48px" :src="user?.userAvatar"/>
  </van-cell>
  <van-cell title="账号" is-link :value="user?.userAccount" />
  <van-cell title="性别" is-link :value="convertGender(user.gender)" />
  <van-cell title="注册时间" is-link :value="user.createTime"/>
</template>

<style scoped>

</style>