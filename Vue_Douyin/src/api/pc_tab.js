// 个人上传视频
import request from '@/utils/request'
// 引入了qs库，qs.stringify()可以将对象转成字符串形式
import qs from 'qs'

//上传视频
export function ceshishdf(file,userdis,vname) {
    alert("值"+vname);
     const form = new FormData(); // FormData 对象
    //  alert("yongh"+sessionStorage.getItem('user'))
    //  let userlist=sessionStorage.getItem('user');
    //  let zjs =qs.stringify(sessionStorage.getItem('user'));
    //  let zjs=map
    // alert("tt"+zjs)
     form.append("file", file); // 文件对象  'upload'是后台接收的参数名
     form.append("userdis",userdis)//用户id
     form.append("vname",vname) //视频描述
    console.log("文件"+form)
    // let zjs = qs.stringify(map)
    // alert(zjs)
      let data =form
      return request({
        url: '/videoserver/filtration/ceshishdf',
        method: 'post',
        timeout:1000000000,
        data
      })
  }

  //查询个人的视频查询传一个值(天数)
export function nomday(day) {
    let data ={day};
    data = qs.stringify(data)
    return request({
      url: '/videoserver/filtration/nomday',
      method: 'post',
      data
    })
}

//删除个人视频
export function devideo(vid) {
  let data ={vid};
  data = qs.stringify(data)
  return request({
    url: '/videoserver/filtration/devideo',
    method: 'post',
    data
  })
}