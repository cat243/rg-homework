// 创建实例时配置默认值
import axios from "axios";

const myAxios = axios.create({
    baseURL: 'http://localhost:7529/api'
});

myAxios.defaults.withCredentials=true;//axios发送请求携带cookie

// 添加全局响应拦截器
myAxios.interceptors.response.use(function (response) {
    console.log('我接受到响应了');
    // 2xx 范围内的状态码都会触发该函数。
    // 对响应数据做点什么
    if(response?.data?.code === 40100){//如果接受的响应为未登录，跳转到登录接口
        const redirectUrl=window.location.href;
        window.location.href=`/user/login?redirect=${redirectUrl}`;
    }
    return response.data;
}, function (error) {
    // 超出 2xx 范围的状态码都会触发该函数。
    // 对响应错误做点什么
    return Promise.reject(error);
});

export default myAxios;