<script setup>
import { useRouter } from 'vue-router'; // 引入 Vue Router
import dog from '../images/dog.jpg';
import {onMounted, ref} from "vue";
import myAxios from "../plugins/myAxios.js";
import {showFailToast, showSuccessToast} from "vant";
//用OnMount钩子在页面加载的时候进行头像和名字数据的获取
const user=ref('');//当前的登录用户
//获取当前登录用户的信息
onMounted(async ()=>{
  const res = await myAxios.get('/user/get/login');
  if (res.code === 0){
    user.value =res.data;
  }else {
    showFailToast('获取用户信息失败');
  }
})


// 使用 Vue Router
const router = useRouter();

// 跳转到设置页面的函数
const goToSettings = () => {
  router.push('/User/Setting');
};
//todo 点击每个图标都会跳出相对应的页面

</script>

<template>
  <div class="user-header">
    <div class="user-profile">
      <van-image
          class="avatar"
          round
          width="6rem"
          height="6rem"
          :src="user?.userAvatar"
      />
      <span class="username">{{ user?.userName }}</span>
    </div>
    <van-icon name="setting-o" class="settings-icon" @click="goToSettings" />
  </div>

  <!-- 分割线 -->
  <van-divider />

  <!-- 我的交易 -->
  <div class="my-trade">
    <h3>我的交易</h3>
    <div class="trade-icons">
      <div class="trade-item">
        <van-icon name="bookmark-o" class="trade-icon" />
        <span>我发布的</span>
      </div>
      <div class="trade-item">
        <van-icon name="gold-coin-o" class="trade-icon" />
        <span>我卖出的</span>
      </div>
      <div class="trade-item">
        <van-icon name="completed-o" class="trade-icon" />
        <span>我买到的</span>
      </div>
      <div class="trade-item">
        <van-icon name="comment-circle-o" class="trade-icon" />
        <span>待评价</span>
      </div>
    </div>
  </div>
</template>

<style scoped>
.user-header {
  display: flex;
  justify-content: space-between; /* 左右分布 */
  align-items: center;
  padding: 1rem;
}

.user-profile {
  display: flex;
  align-items: center;
}

.avatar {
  margin-right: 1rem;
}

.username {
  font-size: 1.5rem;
  font-weight: bold;
}

.settings-icon {
  font-size: 2rem; /* 设置图标大小 */
  cursor: pointer; /* 鼠标悬停时显示为点击样式 */
}

/* 我的交易部分 */
.my-trade {
  padding: 1rem;
}

h3 {
  margin-bottom: 1rem;
  font-size: 1.2rem;
  font-weight: bold;
}

/* 图标部分，水平排列 */
.trade-icons {
  display: flex;
  justify-content: space-between;
}

.trade-item {
  display: flex;
  flex-direction: column;
  align-items: center;
  font-size: 1rem; /* 调整文字大小 */
  color: #333;
}

.trade-icon {
  font-size: 2.3rem; /* 增加图标的大小 */
}

.trade-item span {
  margin-top: 0.5rem;
  font-size: 1.0rem; /* 增加文字的大小 */
}
</style>
