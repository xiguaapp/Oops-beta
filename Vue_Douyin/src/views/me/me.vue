<template>

  <div class="me" :style="{ height:160+'px' }">
    <div class="me-top" :style="bgPic">
      <div class="menu-box" v-if="modality">
        <el-button @click="drawer = true" type="primary" >
        <div class="menu-icon" ></div>
        </el-button>
  <el-drawer
   title="我是标题"
  :size="size"
  :visible.sync="drawer"
  :with-header="false">
     <div class="typeface">
     <p><span class="iconfont icon-shoucang"></span>&nbsp;我的收藏</p>
     <p><span class="iconfont icon-shoucang"></span>&nbsp;私密作品</p>
     <p><span class="iconfont icon-xiangji"></span>&nbsp;充值</p>
     <p><span class="iconfont icon-xiangji"></span>&nbsp;上热门</p>
     <p><span class="iconfont icon-qianbao"></span><router-link to="/wallet">&nbsp;钱包</router-link></p>
     <p><span class="iconfont icon-xiangji"></span>&nbsp;小程序</p> 
     <p><span class="iconfont icon-shezhi"></span>&nbsp;设置</p>
   </div>
</el-drawer>
      </div>
    </div>
<div class="comment-wzs1">

</div>
    <div class="me-wrap">
      <div class="me-content">
        <div class="info">
          <img :src="person.head">
           <p :class="[zfs==true?'gzs':'gz']" v-if="modality==true?false:true"><a @click="attention(datu)">{{datu}}</a></p>
          <router-link to="/compile" v-if="modality"><button class="btn">个人设置</button></router-link>
          <button class="btn" v-if="modality">+朋友</button>
        </div>
        <div class="des">
          <h2>{{person.userName}}</h2>
          <span>{{person.userId}}</span>
          <p>{{person.signature}}</p>
        </div>
        <div class="user-tag">
          <span>18岁</span>
          <span>中国-北京</span>
          <span>+添加学校等标签</span>
        </div>
        <div class="user-tag2">
          <span><a href="#">20w 获赞</a></span>
          <span><a @click="att('first')" >30w 关注</a></span>
          <span><a @click="att('fourth')">40w 粉丝</a></span>
        </div>
      </div>

      <div class="me-tab">
        <div class="me-navbar">
          <div class="item" @click="changeTab(0)" :class="indexTab==0?'active1':''">作品</div>
          <div class="item" @click="changeTab(1)" :class="indexTab==1?'active1':''">礼物</div>
          <div class="item" @click="changeTab(2)" :class="indexTab==2?'active1':''">喜欢</div>
        </div>
        <!-- <div
    v-loading="loading"
    element-loading-text="拼命加载中"
    element-loading-spinner="el-icon-loading"
    element-loading-background="rgba(0, 0, 0, 0.8)"
    :data="dataList"
    > -->
        <div class="tab-wrap">
          <div class="tab-con" v-show="indexTab==0">
            <div class="tab-img">
            <a @click="videocl(item.videoId)" v-for="(item,index) in dataList" :key="index" :videoList="item" :index="index"> 
              <video id="video"  width="25%;">  
              <source :src="item.videoUrl" :class="{'ellipsis-loading': tableText=='数据加载中'}" type="video/mp4">
            </video>
            </a> 
            </div>   
          </div>
        </div>
        </div>  
          <div class="tab-con" v-show="indexTab==1">送出去的礼物作品</div>
          <div class="tab-con" v-show="indexTab==2">喜欢数据</div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>

//引入api
import { pslhpage,some} from '@/api/user.js';
import { inverdict,deverdict } from '@/api/Attention.js';
// import { mapMutations } from 'vuex'

export default {

  created(){
    // 取到路由带过来的参数
    const id=this.$route.query.mallCode
    // alert("查看用户信息"+id);
    if (id==null) {
      // alert("查看个人信息")
      const Pthis=this;
          pslhpage().then(res => {
              //console.log("返回值"+res.data.data.user.use2.userName)
              ////localStorage.setItem('token',"这个是一个token"),
              Pthis.person=res.data.data.user.use2;
              sessionStorage.setItem("user",JSON.stringify(res.data.data.user.use2));
              console.log("视频"+res.data.data.user.user1)
              Pthis.dataList=res.data.data.user.user1
              this.loading=true;
              //alert(""+Pthis.dataList.length)
              // if (Pthis.dataList.length==0) {
              //    this.loading=false;
              // }
              //setTimeout(() => {
              //this.loading=false;
              //},5000);         
             })
    }else{
          var userJsonStr = sessionStorage.getItem('user');
          this.userlist = JSON.parse(userJsonStr);
          console.log("hhhh"+this.userlist.userId)
          // alert("id"+id+"用户id"+this.userlist.userId)
          if (id==this.userlist.userId) {
            //  alert("查看个人信息")
           const Pthis=this;
          pslhpage().then(res => {
              //console.log("返回值"+res.data.data.user.use2.userName)
              ////localStorage.setItem('token',"这个是一个token"),
              Pthis.person=res.data.data.user.use2;
              sessionStorage.setItem("user",JSON.stringify(res.data.data.user.use2));
              console.log("视频"+res.data.data.user.user1)
              Pthis.dataList=res.data.data.user.user1
              this.loading=true;
              //alert(""+Pthis.dataList.length)
              // if (Pthis.dataList.length==0) {
              //    this.loading=false;
              // }
              //setTimeout(() => {
              //this.loading=false;
              //},5000);         
             })
          }else{
      //  alert("某个用户的信息展示")
       const Pthis=this;
        some(id).then(res1=>{
        Pthis.person=res1.data.data.user.use2;
        console.log("yongh"+Pthis.person)
        console.log("视频"+res1.data.data.user.user1)
        Pthis.dataList=res1.data.data.user.user1
        //我是否关注了这个用户
        // alert("ccc"+res1.data.message)
        if (res1.data.message==null) {
          Pthis.datu='关注'
          Pthis.zfs=false;
        }else{
          Pthis.datu='取消关注'
          Pthis.zfs=true;
        }
        this.loading=true;
      })
      if (this.datu=='关注') {
         this.zfs=false;
      }else{
       this.zfs=true;
      }
      this.modality=false
    }
    const that = this
    that.timer = setInterval(function () {
        console.log(document.readyState)
        if (document.readyState === 'complete') {
            that.loading=false;
            window.clearInterval(that.timer)
        }
    }, 1000)
        //  localStorage.setItem('token',"hhhhh12hh1221h321h12312321");
        //  console.log("请求头"+localStorage.getItem("token"))
        //mapMutations(['changeLogin']),
        //this.changeLogin({ Authorization:'aa123123232' });
          // let para={
          // loginName:this.loginForm.username,       
          // passWord:this.loginForm.password
          //  }; 
        // axios.post("http://localhost:8801/user/filtration/pslhpage")
        // .then(res=>{
        //    console.log("返回值"+res.data)
        // })
        //携带token 
      // console.log("请求头"+localStorage.getItem("token"))
    //  console.log("请求头"+localStorage.getItem("Authorization"))
    }
  },
  data(){
    return{
      modality:true,
      datu:'关注',
      zfs:'',
      userlist:{},
      bgPic:{
        backgroundImage:'url(https://guil-file-200211.oss-cn-beijing.aliyuncs.com/Oops/45D38CE836D36F646DB6EBC3BEED25F9.jpg)',
        backgroundRepeat:'no-repeat',
        backgroundSize:'100% 100%'
      },
      indexTab:0,
      showComment:false,
      drawer: false,
      size: '60%',
      timer: null, // 定时器
      //根据屏幕大小自适应
      clientHeight: document.body.clientHeight,
      person:{
         //用户头像
         head:'http://oopsimg.oss-cn-beijing.aliyuncs.com/APP/1607947656812.gif?Expires=1923307651&amp;OSSAccessKeyId=LTAI4GDfvhhmNraXYBcBNfDg&amp;Signature=Jy4VHXOeVAiJpU3zc9Iq%2FuSHavg%3D',
         //用户昵称
         userName:'',
          //用户id:
          userId:'',
          //用户简介
          brief:'',
          //地区
          region:''
      },
      dataList:[
        // {
        //   videoId:1,
        //   videoUrl:"https://thomas-zfd.icu/sv/18d3c0d9-1768023060a/18d3c0d9-1768023060a.mp4"
        // }
      ],
       loading: true,
    }
  },
  mounted() {
    const that = this
    window.onresize = () => {
      return (() => {
        window.screenHeight = document.body.clientHeight
        that.clientHeight = window.screenHeight
      })()
    }
  },
  watch: {
     dataList:function(){
     this.$nextTick(function(){
  //////方法
    // alert("执行完成..")
    // this.loading=false;
     });
  },
    clientHeight(val) {
      // 为了避免频繁触发resize函数导致页面卡顿，使用定时器
      if (!this.timer) {
        // 一旦监听到的screenWidth值改变，就将其重新赋给data里的screenWidth
        this.clientHeight = val
        this.timer = true
        let that = this
        setTimeout(function() {
          // 打印screenWidth变化的值
          console.log(that.clientHeight)
          that.timer = false
        }, 400)
      }
    }
  },
  methods:{
    changeTab(index){
      this.indexTab = index;
    },
    //弹出评论
    showCom(){
      this.showComment = true;
    },
    close(){
      this.showComment = false;
    },
    //关注或者取消关注
    attention(name){
    // 取到路由带过来的参数
    const id=this.$route.query.mallCode
    alert("id"+id)
     if (name=='关注') {
          //关注操作
          this.datu='取消关注';
          this.zfs=true;
          inverdict(id,this.userlist).then(res2=>{
            console.log("关注"+res2.data.data)
          });
      }else{
          //取消关注
          this.datu='关注'
          this.zfs=false;
          deverdict(id).then(res2=>{
            console.log("关注"+res2.data.data)
          });
      }
    },
    //传递视频的id
    videocl(index){
      this.$router.push({
      path: '/details',
      query: {
       mallCode: index
       }
       })
      // alert("点击了.."+index);
    },
    att(names){
      this.$router.push({
      path: '/attention',
      query: {
       mallCode: names
       }
       })
      //alert(names);
    }
  }
}
</script>

<style>
.gzs{
    width: 52%;
    height: 125%;
    border: 4px solid rgb(140 139 139 / 96%);
    background: rgb(158 149 149 / 96%);
    text-align: center;
    line-height: 267%;
    font-size: 12px;
    position: relative;
    top: 2px;
    left: -6%;
    border-radius: 8px;
}
.gz{
    width: 52%;
    height: 125%;
    border: 4px solid rgb(242 52 51 / 96%);
    background: rgb(242 52 52 / 96%);
    text-align: center;
    line-height: 267%;
    font-size: 12px;
    position: relative;
    top: 2px;
    left: -6%;
    border-radius: 8px;
}

  .me{
    position: relative;
  }
  .me-top{
    height:160px;
    display: flex;
    justify-content: flex-end;
    padding:20px;
  }
  .menu-box{
    width:30px;
    height:30px;
    border-radius: 50%;
    background: rgba(0, 0, 0, .3);
    display:flex;
    align-items: center;
    justify-content: center;
  }
  .menu-icon{
    background: white;
    border-top:2px solid white;
    border-bottom:2px solid white;
    background-clip: content-box;
    width:31px;
    height:16px;
    padding:5px 0;
    
  }
.el-button--primary {
opacity:0.1; 
}

  .active {
    color: #ffffff;
}
  .me-wrap{
    position: absolute;
    top:99%;
    height:449%;
    width:100%;
    background-color: #101821;
    color:#ffffff;
  }
  .me-content{
    padding:0 20px;
  }
  .info{
    display: flex;
    align-items: center;
    justify-content: space-between;
    /* padding-bottom:20px ; */
  }
  .info img{
    height:100px;
    width:100px;
    border-radius: 50%;
    margin-right: 20px;
  }
  .info button{
    height:40px;
    padding:0 24px;
    background-color: #393842;
    border:none;
    color:white;
  }

  .des {
    padding:20px 0;
  }
  .des h2{
    font-size: 24px;
    font-weight: bold;
  }
  .des span{
    padding:10px 0 15px 0;
    /* display: block; */
  }
.des p{
  line-height: 24px;
}
.user-tag span{
  font-size: 14px;
  color: #cccccc;
  margin-right: 5px;
  background: rgba(0, 0, 0, .6);
  padding:5px 8px;
}
.user-tag2{
  padding:20px 0;
}
.user-tag2 span{
  font-size: 14px;
  margin-right: 15px;
  color: #cccccc;
}
.user-tag2 a{
  /* font-size: 18px; */
  margin-right: 5px;
  color: #cccccc;
}
.me-tab{
  height:300px;

}
.me-navbar{
  display: flex;
  padding:0 20px;
  justify-content: space-between;
  align-items: center;
}
.me-navbar .item{
  padding:10px 25px;
  color:#cccccc;
}
.me-navbar .active{
  border-bottom:2px solid #ffdf0e;
  color:white;
}
.me-navbar .active1{
  border-bottom:2px solid #ffdf0e;
  color:white;
}

.tab-img img{
  width:33.3%;
  height:150px;
}

.comment-wzs{
position:fixed;
    position: fixed;
    bottom: 0;
    left: 181px;
    right: 0;
    height: 736px;
    width: 95%;
    background: #101821;
    border-top-left-radius: 23px;
    border-top-right-radius: 22px;
    z-index: 1007;
    padding: 45px 4px;
    box-sizing: border-box;
}
.comment-top{
    display: flex;
    align-items: center;
  }
 .close{
    position:absolute;left:10px;top:14px;
   font-size: 11px;
   color:#6666;
 } 

 .typeface p{
   font-size: 19px;
   margin: 41px;
   color: #130202;
 }

  .typeface a{
   color: #130202;
 }
 .typeface span{
   display:inline-block;width:47px;font-weight:bold;font-size: 161%;
 }

   a{
      COLOR: #ffffff;
  }

  .el-drawer {
    position: absolute;
    box-sizing: border-box;
    background-color: #808080;
    display: flex;
    flex-direction: column;
    box-shadow: 0 8px 10px -5px rgba(0,0,0,.2), 0 16px 24px 2px rgba(0,0,0,.14), 0 6px 30px 5px rgba(0,0,0,.12);
}

</style>