import axios from 'axios'
import { Message, MessageBox} from 'element-ui'
import store from '../store'

// 创建axios实例
const service = axios.create({
    baseURL: 'http://localhost:8801', // api的base_url
    timeout: 50000, // 请求超时时间
    headers: {
      //'token':"1232132"
      'token':sessionStorage.getItem('Authorization')
  },
  })
// request拦截器
// service.interceptors.request.use(config => {
//   if (store.getters.token && !isEmpty(store.getters.token)) {
//     // config.headers['Authorization'] = getToken() // 让每个请求携带自定义token 请根据实际情况自行修改
//     try{
//       config.params.token = getToken();
//     } catch (error){
//     }
//   }
//   return config
// }, error => {
//   // Do something with request error
//   console.log(error) // for debug
//   Promise.reject(error)
// })
// respone拦截器
// service.interceptors.response.use(
//   response => {
//     //  const res = response.data
//     //  alert("response"+response.data.data);
//     // // console.log("res",res);
//     // alert("res.code:"+res.code)
//     // if (res.code !== 0 && res.code != 15) {
//     //   Message({
//     //     message: res.msg,
//     //     type: 'error',
//     //     duration: 3 * 1000
//     //   })

//     //   if(res.code === 200000){
//     //     MessageBox.confirm('你已被登出，可以取消继续留在该页面，或者重新登录', '确定登出', {
//     //       confirmButtonText: '重新登录',
//     //       cancelButtonText: '取消',
//     //       type: 'warning'
//     //     })
//     //   }
//     //   // 401:未登录;
//     //   if (res.code === 401) {
//     //       MessageBox.confirm('你已被登出，可以取消继续留在该页面，或者重新登录', '确定登出', {
//     //       confirmButtonText: '重新登录',
//     //       cancelButtonText: '取消',
//     //       type: 'warning'
//     //     }).then(() => {
//     //       store.dispatch('FedLogOut').then(() => {
//     //         location.reload()// 为了重新实例化vue-router对象 避免bug
//     //       })
//     //     })
//     //   }
//     //   return Promise.reject('error')
//     // } else {
//     //   return response.data
//     // }
//     // return response.data
//     // let data = data = response;
//     return response;
//   },
//   error => {
//     console.log('拦截器')

//     console.log(error)
    
//     if(error.request){
    
//     console.log(111)
    
//     console.log(error.request)
    
//     } else if(error.response){
    
//     console.log(222)
    
//     console.log(error.response.data);
    
//     console.log(error.response.status);
    
//     console.log(error.response.headers);
//     }
//     if (error && error.response) {
//       switch (error.response.status) {
      
//       case 400: error.message = '请求错误(400)' ;
//       Message.error('请求错误(400)')
//       break;
      
//       case 401: error.message = '未授权，请重新登录(401)';
      
//       Message.error('未授权，请重新登录(401)');
//       break;
      
//       case 403: error.message = '拒绝访问(403)';
//       Message.error('拒绝访问(403)')
//       break;

//       case 404: error.message = '请求出错(404)'; 
//       Message.error('请求出错(404)')
//       break;

//       case 408: error.message = '请求超时(408)'; 
//       Message.error('请求出错(408)')
//       break;
      
//       case 500: error.message = '服务器错误(500)'; 
//       Message.error('暂无数据,你还没登录')
//       break;
      
//       case 501: error.message = '服务未实现(501)';
//       Message.error("服务未实现(501)")
//       break;
      
//       case 502: error.message = '网络错误(502)'; 
//       Message.error("网络错误(502)")
//       break;
      
//       case 503: error.message = '服务不可用(503)';
//       Message.error("服务不可用(503)")
//       break;
      
//       case 504: error.message = '网络超时(504)';
//       Message.error("网络超时(504)")
//       break;
      
//       case 505: error.message = 'HTTP版本不受支持(505)';
//       Message.error("HTTP版本不受支持(505)")
//       break;
      
//       default: error.message = `连接出错(${error.response.status})!`;
//       }
//       }else{     
//         Message.error("连接服务器失败")
//       }
//       return Promise.reject(error)
//   }
// )
export default service;
