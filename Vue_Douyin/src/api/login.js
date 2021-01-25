import request from '@/utils/request'
// 引入了qs库，qs.stringify()可以将对象转成字符串形式
import qs from 'qs'

//手机号验证+短信验证的方法
export function doLogin (phone,code) {
  console.log("值:"+phone+"验证码"+code)
    let data = {
      phone,
      code
    }
    data = qs.stringify(data)
    return request({
      url: '/user/filter/login',
      method: 'post',
      data
    })
  }
  //手机号+密码登录
export function loginpass (phone,password) {
  console.log("手机号:"+phone+"验证码"+password)
    let data = {
      phone,
      password
    }
    data = qs.stringify(data)
    return request({
      url: '/user/filter/loginpass',
      method: 'post',
      data
    })
  }

  //注册
  export function register (phone,password) {
    console.log("手机号:"+phone+"验证码"+password)
      let data = {
        phone,
        password
      }
      data = qs.stringify(data)
      return request({
        url: '/user/filter/register',
        method: 'post',
        data
      })
    }
  
//验证手机号是否存在
// export function verify (phone) {
//   console.log("值:"+phone)
//     let data = {
//       phone
//     }
//     data = qs.stringify(data)
//     return request({
//       url: '/user/filter/verify',
//       method: 'post',
//       data
//     })
//   }



//   //登录的方法
// export function dol (phone) {
//   console.log("值:"+phone)
//     let data = {
//       phone
//     }
//     data = qs.stringify(data)
//     return request({
//       url: '/user/provider/login',
//       method: 'post',
//       data
//     })
//   } 