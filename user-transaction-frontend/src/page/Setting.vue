<script setup lang="ts">
// 使用 Vue Router
import {useRouter} from "vue-router";
import {showConfirmDialog, showFailToast, showSuccessToast} from "vant";
import myAxios from "../plugins/myAxios.js";

const router = useRouter();
//退出登录按钮
const logout = () => {
  showConfirmDialog({
    title: '你确定要退出登录吗?',
  })
      .then(
          //点击确认
          async () => {
        const res = await myAxios.post("/user/logout",{});
        console.log(res);
        if (res.code == 0 && res.data != null) {
          showSuccessToast("退出登录成功");
          router.replace("/user/login")
        } else {
          showFailToast("退出登录失败");
        }
      })
      .catch(() => {
        // on cancel
      });
}

</script>

<template>
  <van-cell title="个人资料" is-link to="/Person"/>
  <van-cell title="地址管理" is-link/>
  <van-cell title="支付方式" is-link value="暂未开通"/>
  <van-cell title="退出登录" is-link @click="logout"/>
  <div>
    <router-view/>
  </div>
</template>
<style scoped>

</style>
