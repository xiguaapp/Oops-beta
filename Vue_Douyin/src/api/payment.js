// 个人中心
import request from '@/utils/request'
// 引入了qs库，qs.stringify()可以将对象转成字符串形式
import qs from 'qs'

//查询充值的消费记录
export function record() {
    return request({
      url: '/pay/filtration/record',
      method: 'post'
    })
  }