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
      <van-field
          v-model="checkPassword"
          type="password"
          name="checkPassword"
          label="确认密码"
          placeholder="请再次输入密码"
          :rules="[{ required: true, message: '请再次填写密码' }]"
      />
    </van-cell-group>
    <div style="margin: 16px;">
      <van-button round block type="primary" native-type="submit">
        提交
      </van-button>
    </div>
  </van-form>
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
const checkPassword=ref();
//提交事件
const onSubmit = async () => {
  const res = await myAxios.post("/user/register", {
    userAccount: userAccount.value,
    userPassword: userPassword.value,
    checkPassword:checkPassword.value
  });
  console.log(res);
  if (res.code == 0 && res.data != null) {
    showSuccessToast("注册成功");
    //注册成功跳转到登录页面
    router.replace('/user/login')
  } else {
    showFailToast(res?.message);
  }
};

</script>

<style scoped>

</style>