<script setup lang="ts">
import { ref } from "vue";

// 图片上传列表
const fileList = ref([]);
// 物品描述
const message = ref('');
// 价格
const price = ref('');
const titile=ref('');
</script>

<template>
  <div class="container">
    <!-- 页面标题 -->
    <h2 class="title">发布闲置物品</h2>

    <!-- 物品标题输入框 -->
    <van-cell-group inset>
      <van-field
          v-model="titile"
          label="商品标题"
          type="text"
          input-align="left"
          class="input-field"
      />
    </van-cell-group>

    <!-- 物品描述输入框 -->
    <van-cell-group inset>
      <van-field
          v-model="message"
          rows="4"
          autosize
          label="物品描述"
          type="textarea"
          maxlength="200"
          placeholder="请输入物品的详细描述"
          show-word-limit
          class="input-field"
      />
    </van-cell-group>

    <!-- 图片上传区域 -->
    <van-uploader
        v-model="fileList"
        multiple
        preview-size="80px"
        class="uploader"
        max-count="3"
    />

    <!-- 物品价格输入框 -->
    <van-cell-group inset>
      <van-field
          v-model="price"
          label="价格 (元)"
          placeholder="请输入价格"
          type="number"
          input-align="right"
          class="input-field"
      />
    </van-cell-group>

    <!-- 提交按钮 -->
    <van-button round type="success" class="submit-button">发布物品</van-button>
  </div>
</template>

<style scoped>
/* 容器样式 */
.container {
  padding: 16px;
  background-color: #f9f9f9;
}

/* 页面标题 */
.title {
  text-align: center;
  font-size: 18px;
  font-weight: bold;
  margin-bottom: 12px;
  color: #333;
}

/* 输入框样式 */
.input-field {
  background-color: #fff;
  border-radius: 6px;
  padding: 10px;
  box-shadow: 0px 1px 5px rgba(0, 0, 0, 0.1);
  border: 1px solid #ebebeb;
  margin-bottom: 12px; /* 调整为12px以减小组件间的间距 */
}

/* 图片上传区域样式 */
.uploader {
  margin-bottom: 12px; /* 调整间距 */
  padding: 10px;
  margin-left: 15px;
  background-color: #fff;
  border-radius: 6px;
  box-shadow: 0px 1px 5px rgba(0, 0, 0, 0.1);
}

/* 提交按钮样式 */
.submit-button {
  width: 100%;
  max-width: 400px;
  height: 45px;
  margin: 20px auto 0; /* 使按钮在容器内居中 */
  font-size: 16px;
  color: white;
  background-color: #07c160;
  border-radius: 22px;
  box-shadow: 0px 2px 8px rgba(0, 0, 0, 0.1);
}
</style>
