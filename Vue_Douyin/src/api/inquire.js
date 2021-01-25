import request from '@/utils/request'
// 引入了qs库，qs.stringify()可以将对象转成字符串形式
import qs from 'qs'

//搜索
export function inq(uty) {
  console.log("查询值"+uty);
    let data = {
        uty
    }
    data = qs.stringify(data)
    return request({
      url: '/solrse/ceshi',
      method: 'post',
      data
    })
  }

export function usvideo(uty) {
  console.log("查询值"+uty);
    let data = {
        uty
    }
    data = qs.stringify(data)
    return request({
      url: '/solrse/usvideo',
      method: 'post',
      data
    })
  }  
  export function usersss(uty) {
    console.log("查询值"+uty);
      let data = {
          uty
      }
      data = qs.stringify(data)
      return request({
        url: '/solrse/userdis',
        method: 'post',
        data
      })
    }  

