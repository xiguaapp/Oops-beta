import request from '@/utils/request'
// 引入了qs库，qs.stringify()可以将对象转成字符串形式
import qs from 'qs'

//查询关注
export function fans() {
    return request({
      url: '/mongo/fans',
      method: 'get'
    })
  }

//查询点赞
export function give() {
    return request({
      url: '/mongo/give',
      method: 'get'
    })
  }

//查询评论
export function comment() {
    return comment({
      url: '/mongo/comment',
      method: 'post'
    })
  }  
