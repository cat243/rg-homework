<script setup>
import {onMounted, ref} from "vue";
import {showFailToast, showToast} from "vant";
import ProductList from "../components/ProductList.vue";
import myAxios from "../plugins/myAxios.js";

const value = ref('');
const onSearch = (val) => showToast(val);
const onCancel = () => showToast('取消');
const productArray = ref([]);

onMounted(async ()=>{
  const res=await myAxios.get("/goods/list");
  if(res?.code==0){
    productArray.value=res.data;
  }else {
    showFailToast("加载队伍失败，请刷新重试")
  }
})
</script>

<template>
  <form action="/">
      <van-search
          v-model="value"
          show-action
          placeholder="请输入搜索关键词"
          @search="onSearch"
          @cancel="onCancel"
      />
  </form>
  <ProductList :products="productArray" />
</template>

<style scoped>

</style>