<template>
  <div class="card-container">
    <div class="van-card" v-for="product in products">
        <img :src="product.images" alt="商品图片" class="goods-image" />
        <div class="goods-info">
          <p class="title"> {{product.goodsTitle}} </p>
          <p>{{product.description}}</p>
          <div>
            <p id="prices">
              ¥{{product.prices}}
              <van-button size="mini" type="primary" id="button" @click="productInfo(product.id)">查看</van-button>
            </p>
          </div>
        </div>
    </div>
  </div>
</template>

<script setup>
import {defineProps} from 'vue'
import {useRouter} from "vue-router";
const router=useRouter();
//点击查看的时候跳转商品详细页
const productInfo=(goodId)=>{
  router.push({
    path:'/Goods/Info/',
    query:{
      goodId,
    }
  })
}

// 接收从父组件传入的商品数组
const props = defineProps({
  products: {
    type: Array,
    required: true,
    default: () => [],
  },
})
</script>

<style scoped>
.card-container {
  display: flex;
  flex-wrap: wrap;
  justify-content: space-between; /* 保证卡片之间的间距 */
}

.van-card {
  width: 48%; /* 控制卡片的宽度 */
  height: 200px;
  box-sizing: border-box;
  margin-bottom: 10px; /* 添加卡片之间的垂直间距 */
  margin-right: 2%; /* 添加卡片之间的水平间距 */
}
.goods-image{
  width: 100%;
  height: 60%;
}
.title{
  font-weight: bold;
  font-family:Georgia ,serif;
}
.goods-info{
  background-color:white;
}
#button{
  margin-left: 110px;
}
p{
line-height: 0.4;
  font-family:Trebuchet MS,serif ;
}
#prices{
  color: red;
}
</style>
