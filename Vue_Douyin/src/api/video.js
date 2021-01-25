//查询视频详情
import request from '@/utils/request'

// 引入了qs库，qs.stringify()可以将对象转成字符串形式
import qs from 'qs'

//评论的显示
export function personage(vid) {
    console.log("视频id"+vid)
      let data = {
        vid
      }
      data = qs.stringify(data)
      return request({
        url: '/videoserver/filtration/peVideo',
        method: 'post',
        data
      })
    }

//添加评论
export function addcomment(name,head,msg,vid,userlist,vurl) {
  console.log("视频评论"+name,head,msg,vid);
  console.log("视频地址"+vurl)
    let data = {
      name,head,msg,vid,userlist,vurl
    } 
    data = qs.stringify(data)
    return request({
      url: '/videoserver/filtration/addcomment',
      method: 'post',
      data
    })
  }

//查询推荐视频
export function recommend() {
  console.log("进来了...热点视频")
  return request({
    url: '/mongo/recommend',
    method: 'post'
  })
}
 
//查询关注人的视频
export function attentionlist() {
    console.log("进来了...关注人的视频")
    return request({
      url: '/videoserver/filtration/attentionlist',
      method: 'post'
    })
  }

  //点赞
export function give(vid,maps,vurl) {
  console.log("give点赞视频id"+vid)
  let data = {
    vid,maps,vurl
  } 
  data = qs.stringify(data)
  return request({
    url: '/videoserver/filtration/addlike',
    method: 'post',
    data
  })
}

  //取消点赞
  export function callgive(vid) {
    console.log("取消点赞视频id"+vid)
    let data = {
      vid
    } 
    data = qs.stringify(data)
    return request({
      url: '/videoserver/filtration/derlike',
      method: 'post',
      data
    })
  }

//查询所有的礼物
export function giflist() {
  return request({
    url: '/gift/filtration/giftlist',
    method: 'get'
  })
}  

//查询个人背包的礼物
export function bafelist() {
  return request({
    url: '/gift/filtration/gifbags',
    method: 'get'
  })
}  
//送出去的礼物修改背包的礼物 this.money,this.R,this.gname
export function upgifbags(map,money,R,gname,giftid) {
  // alert("礼物"+video)
  console.log('map')
  console.log(map)
  let data ={map,money,R,gname,giftid}
  
  data = qs.stringify(data)
  console.log("hhhh")
  console.log(data)
  return request({
    url: '/gift/filtration/upgifbags',
    method: 'post',
    data
  })
}  
//购买礼物
// this.r
// this.gid
// this.gifname
export function addpayment(r,gid,gifname) {
  // alert("礼物"+video)
  // console.log('map')
  // console.log(map)

  let data ={r,gid,gifname}
  
  data = qs.stringify(data)
  console.log(data)
  return request({
    url: '/user/filtration/addpayment',
    method: 'post',
    data
  })
} 
