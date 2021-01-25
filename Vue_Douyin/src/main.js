import Vue from 'vue'
import './plugins/axios'
import App from './App.vue'
import router from './router'
import store from './store'


//自定义弹框
import Toast from './components/toast/toast.js'
//挂载(链式)
Vue.prototype.$toast = Toast

//引入阿里图标库
import './assets/iconfont/iconfont.css'
//导入组件+样式
import  VueAwesomeSwiper from 'vue-awesome-swiper'
import 'swiper/css/swiper.css'
//播放器
import VueVideoPlayer from 'vue-video-player'
//样式
import '../public/anc.css'

import ElementUI from 'element-ui'   

import 'element-ui/lib/theme-chalk/index.css'   //引用 element-ui 样式

import axios from 'axios';

// 在请求头中加token
axios.interceptors.request.use(
  config => {
  // 判断是否存在token，如果存在的话，则每个http header都加上token
    let token = sessionStorage.getItem('Authorization')
    if (!config.headers.hasOwnProperty('Authorization') && token) {
      config.headers.Authorization = token;
    }
    return config;
  },
  error => {
    return Promise.reject(error);
  });

Vue.use(ElementUI )  //最后要use ElementUI ，不然会报错
//使用
Vue.use(VueAwesomeSwiper)
Vue.use(VueVideoPlayer)

// Vue.config.productionTip = false

new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app')

