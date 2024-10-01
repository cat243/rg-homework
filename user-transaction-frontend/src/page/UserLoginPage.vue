<template>
  <van-form @submit="onSubmit">
    <van-cell-group inset>
      <van-field
          v-model="userAccount"
          name="userAccount"
          label="账号"
          placeholder="请输入账号"
          :rules="[{ required: true, message: '请填写用户名' }]"
      />
      <van-field
          v-model="userPassword"
          type="password"
          name="userPassword"
          label="密码"
          placeholder="请输入密码"
          :rules="[{ required: true, message: '请填写密码' }]"
      />
    </van-cell-group>
    <div style="margin: 16px;">
      <van-button round block type="primary" native-type="submit">
        提交
      </van-button>
    </div>
  </van-form>
  <div class="register" @click="pushRegister">
    没有账号?点我注册
  </div>
</template>

<script setup>

import myAxios from "../plugins/myAxios.js";
import {showFailToast, showSuccessToast, Toast} from "vant";
import {ref} from "vue";
import {useRouter} from "vue-router";
import {useRoute} from "vue-router";
const route=useRoute();
const router=useRouter();
const userAccount = ref();
const userPassword = ref();
//提交事件
const onSubmit = async () => {
  // console.log("用户登录");
  const res = await myAxios.post("/user/login", {
    userAccount: userAccount.value,
    userPassword: userPassword.value
  });
  console.log(res);
  if (res.code == 0 && res.data != null) {
    showSuccessToast("登录成功");
    //跳转到之前的页面
    const redirectUrl=route.query?.redirect ?? '/';
    window.location.href=redirectUrl;
  } else {
    showFailToast("登录失败");
  }
};
//点击注册事件
const pushRegister=()=>{
  router.push('/user/register');
}


</script>

<style scoped>
.register{
  margin-top: 20px;
  margin-left: 250px;
  font-family: "仿宋_GB2312", serif;
  font-size: 12px;
  color: blue;
}
</style>