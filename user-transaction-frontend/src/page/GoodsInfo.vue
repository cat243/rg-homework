<script setup>
import {useRoute} from "vue-router";
import {onMounted, ref} from "vue";
import dog from "../images/dog.jpg"
import myAxios from "../plugins/myAxios.js";
import {showFailToast} from "vant";
const route=useRoute();
//获取点击查看的商品的id
const goodInfo=ref('');
//根据商品的id来查询商品的信息
onMounted(async ()=>{
  const res=await myAxios.get("/goods/GetGoodInfo",{
    params:{
      id:route.query.goodId,
    }
  });
  if(res?.code==0){
    goodInfo.value=res.data;
  }else {
    showFailToast("查看商品信息失败，请刷新重试")
  }
})
</script>

<<template>
  <div class="container">
    <div class="header">
      <van-image
          class="avatar"
          round
          width="3rem"
          height="3rem"
          :src="goodInfo.user?.userAvatar"
      />
      <span class="username">{{goodInfo.user?.userName}}</span>
      <p class="prices">¥{{goodInfo.prices}}</p>
    </div>
    <div class="description">
      {{goodInfo.description}}
    </div>
    <div class="images" v-for="image in goodInfo.images" :key="image">
      <van-image
          class="image-item"
          width="150"
          height="150"
          :src="image"
      />
    </div>
    <div class="footer">
      <van-action-bar>
        <van-action-bar-icon icon="chat-o" text="联系"/>
        <van-action-bar-icon icon="star" text="已收藏" color="#ff5000" />
        <van-action-bar-button type="danger" text="立即购买"  />
      </van-action-bar>
    </div>
  </div>
</template>

<style scoped>
.container {
  display: flex;
  flex-direction: column;
  min-height: 100vh; /* 使容器高度占满整个视口 */
}

.header {
  position: relative;
}

.avatar {
  margin-left: 1rem;
  margin-top: 1rem;
}

.username {
  position: absolute;
  top: 5%;
  left: 16%;
  font-size: 1rem;
  margin: 1rem;
  font-weight: bold;
  font-family: "微软雅黑", serif;
}

.prices {
  margin-left: 20px;
  color: red;
  font-weight: bold;
  font-size: 1.5rem;
}

.description {
  line-height: 1.5;
  font-family: "仿宋_GB2312", serif;
  margin: 1rem 0;
}

.images {
  display: flex;
  flex-wrap: wrap;
  justify-content: flex-start;
  gap: 0.5rem;
  padding: 0 1rem;
  flex: 1; /* 使中间内容区域可伸缩 */
  overflow-y: auto; /* 允许上下滚动 */
}

.image-item {
  width: 100px;
  height: 100px;
}

#chat {
  margin-top: 60px;
  margin-left: 20px;
}
#button {
  margin-left: 60px;
}
</style>
