// 个人中心
import request from '@/utils/request'
// 引入了qs库，qs.stringify()可以将对象转成字符串形式
import qs from 'qs'

//个人中心
export function pslhpage() {
    return request({
      url: '/user/filtration/pslhpage',
      method: 'post'
    })
  }


//查询用户信息
export function some(userid) {
  console.log("用户id"+userid)
    let data = {
      userid
    }
    data = qs.stringify(data)
    return request({
      url: '/user/filtration/somezda',
      method: 'post',
      data
    })
}

//修改个人资料
export function amend(map) {
  console.log("用户id"+map)
    let data =map
    data = qs.stringify(data)
    return request({
      url: '/user/filtration/amend',
      method: 'post',
      data
    })
}

//修改密码
export function changepwd(map) {
  console.log("用户id"+map)
    let data =map
    data = qs.stringify(data)
    return request({
      url: '/user/filtration/changepwd',
      method: 'post',
      data
    })
}

//收到的礼物
export function obtain() {
    return request({
      url: '/user/filtration/obtain',
      method: 'post'
    })
}

//送出去的礼物
export function brush() {
    return request({
      url: '/user/filtration/brush',
      method: 'post'
    })
}

