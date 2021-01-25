import request from '@/utils/request'
// 引入了qs库，qs.stringify()可以将对象转成字符串形式
import qs from 'qs'

//查询关注
export function attention() {
    return request({
      url: '/user/filtration/attention',
      method: 'get'
    })
  }

//查询粉丝
export function fans() {
    return request({
      url: '/user/filtration/fans',
      method: 'get'
    })
  }

//添加关注
export function inverdict(userid,userlist) {
  console.log("用户id"+userid)
    let data = {
      userid,
      userlist
    }
    data = qs.stringify(data)
    return request({
      url: '/user/filtration/inverdict',
      method: 'post',
      data
    })
}

//取消关注
export function deverdict(userid) {
  console.log("用户id"+userid)
    let data = {
      userid
    }
    data = qs.stringify(data)
    return request({
      url: '/user/filtration/deverdict',
      method: 'post',
      data
    })
}




