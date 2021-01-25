<template>
  <div id="video"> 
        <div class="zkf">
<!-- <input type="text"  placeholder="请输入内容" > -->
<!-- <el-input
placeholder="请输入内容"
style="width: 88%"
v-model="input"
clearable>
</el-input> -->
<!-- <p class="zks">
<el-row>
  <el-button type="primary">主要按钮</el-button>
 </el-row>
</p> -->
     </div>
     

  <p class="barrages-drop">
    
  <vue-baberrage
   :isShow="barrageIsShow"
   :barrageList="barrageList"
   :maxWordCount="maxWordCount"
   :throttleGap="throttleGap"
   :loop="barrageLoop"
   :boxHeight="boxHeight"
   :messageHeight="messageHeight"
  >
  </vue-baberrage>
 </p>
    <div>
      </div>
     <div>
  <!-- 根据视频的id传值 -->
<div class="video-list">
      <!-- <img src="https://guil-file-200211.oss-cn-beijing.aliyuncs.com/%E7%A4%BC%E7%89%A9/%E5%8D%83%E5%BA%93%E7%BD%91_%E7%BA%A2%E8%89%B2%E8%8A%B1%E7%93%A3%E9%A3%98%E8%90%BDgif%E5%8A%A8%E5%9B%BE_%E5%85%83%E7%B4%A0%E7%BC%96%E5%8F%B711871479.gif"  data-width="700" data-height="340"
      style="width: 700px;
      max-width: 100%;
      background-color: ;
      cursor: pointer;
      z-index: 200000;
      "> -->
    <swiper :options="swiperOption" >
            <img v-if="gyds" :src="ccsrc" 
      style="
    width: 700px;
    z-index: 999999;
      ">
      <!-- 幻灯内容 -->
      <!-- 循环输出 -->
      <swiper-slide v-for="(item,index) in dataList" :key="index" v-bind:index="0">
        <div>
          <!-- ref：节点 -->
          <videos ref="videos" :videoList="item" :index="index" ></videos>
        </div>
        
      </swiper-slide>  

    </swiper>

    <div  class="baberrage-stage1">
        
    <div>
      <p class="zdf">182w 播放量</p>
      <p class="zdate">{{dataList.video.videoTime | formatDate}}</p>
        <!-- 用户名:描述 -->
      <p class="uz"><span style="color:#0f3865">{{sou.userName}}:</span><span style="color:#000">{{sou.videoDescript}}</span></p>
        </div>
        <!-- 对应使用的音乐 -->
        <p class="music iconfont icon-yinfu" ><span style="color: rgb(148, 141, 141);"></span>{{sou.userName}}的作品原声</p>
        <!-- 作品赞的数量 -->
        <p class="count"><span class="iconfont icon-aixin" style="color: rgb(148, 141, 141);"></span> <span style="color:#0f3865"> {{dataList.video.videoCount}}用户</span>赞了</p>

        <!-- 作品赞的数量 -->
        <p class="comment"><span style="color:#0f3865"><span  class="iconfont icon-pinglun" style="color: rgb(148, 141, 141);"></span> {{zgsd}}位用户</span>评论了</p>
    <!-- 用户的评论  -->  
      
    <div class="dis">
        <div class="zds">
        <div class="comment-body">
          <div class="comment-box" >
              <div class="comment-item" v-for="(item,index) in bookList " :key="index" :videoList="item" :index="index" >
              <div class="user-pic"><img :src="item.avatar"></div>
              <div class="item-info">
                <div class="reply">
                  <p class="name">{{item.name}}</p>  
                  <p class="reply-des">{{item.msg}} <span class="time"></span></p>
                </div>
                <div class="zan"><span class="iconfont icon-aixin"></span><p>200</p></div>
              </div>
            </div>
          </div>
          </div>
            </div>
            </div>
          </div>
</div>
        
        </div>
<div data-v-8c97cc72="" class="bottom_center_box">
  <el-button type="warning" icon="el-icon-back" circle></el-button>
  <el-input
  placeholder="请输入内容"
  style="width: 65%"
  v-model="input"
  clearable>
</el-input>
<!-- <el-button type="primary" >发送</el-button> -->
<!-- <span @click="zdsa">发送</span> -->
  <el-button type="primary" @click="zdsa" icon="el-icon-check" circle></el-button>
  <el-button type="danger" @click="gift" icon="el-icon-present" circle></el-button>
<!-- <span @click="zdsa">礼物</span>
<span @click="zdsa">上热门</span> -->
</div>  

<!-- 礼物列表 -->
      <!-- 礼物列表 -->
    <transition name="up"> 
    <div class="comment-warp" v-if="present">
        <!-- <div class="num">
          <span>{{my}} R币</span>&nbsp;
          <a href="/wallet">充值</a>
        </div>  -->

      <div class="comment-list">
        <div class="comment-top">
          <div class="number">送礼物</div>
          <div class="close" @click="cl"><span>x</span></div>
        </div>
        <div>
          <el-tabs v-model="activeName">
          <el-tab-pane label="背包" name="first">
                 <div v-if="list==''">
                   <span @click="dusd">背包暂无礼物请先前往商城购买(点击前往)</span>
                 </div>
                  <div class="zwe"> 
                    <div></div>
                  <p class="pitch" :class="{active2:currentIndex === index}" @click="liClick(index,item.gifprice,item.gifimageurl,item.money,item.gifname,item.giftCount,item.giftid)" v-for="(item,index)  in list">
                  <span></span></br>
                  <span><img class="gi" :src="item.gifimageurl"></span></br>  
                  <span>{{item.gifname}}x{{item.giftCount}}</span></br>
                  <span style="font-size:10px">{{item.gifprice}} R币</span>
                  </p>
                  </div>
          </el-tab-pane>
          <el-tab-pane label="R币" name="R">我的R币还剩余:{{my}} R币</el-tab-pane>
          <el-tab-pane label="充值" name="se"><span @click="du">去充值</span></el-tab-pane>
          <el-tab-pane label="商城" name="s"> <span @click="dusd">前往商城</span></br></el-tab-pane>
           <el-tab-pane label="热门" name="Y"> <span @click="he">推他上热门</span></br></el-tab-pane>
          <!--  href="" -->
          </el-tab-pane>
        </el-tabs>
        </div>
        <div>
          <!--<span class="send">送给<img></span> -->
          <span><el-button type="danger" :plain="true" @click="confi" style="background: #f17676;" class="but" round>确定</el-button></span>
        </div>
      </div>
    </div>
    </transition>
  </div>
      

</template>


<script>
// 导入baberrage组件
import Vue from 'vue';
import { vueBaberrage, MESSAGE_TYPE } from 'vue-baberrage';
Vue.use(vueBaberrage);

//引入api
import { personage,addcomment,giflist,bafelist,upgifbags} from '@/api/video'
import { formatDate } from '@/api/date'


//导入swiper组件'
import {Swiper,SwiperSlide} from 'vue-awesome-swiper'
import 'video.js/dist/video-js copy.css'
//导入播放组件
import Videos from '../../components/index/particulars'
import InfoBar from './InfoBar'
import RightBar from './RightBar'
export default {
  name:'VideoList',
  routerParams:'null',
  //弹框
  name: 'Barrages',
  components:{
    //注册swiper组件
    Swiper,
    SwiperSlide,
    Videos,
    InfoBar,
    RightBar
  },
  created(){
   this.getParams()
  },
  methods:{

  addToList() {
  let list = [
  {
   id: 1,
   avatar: 'https://guil-file-200211.oss-cn-beijing.aliyuncs.com/Oops/logo.jpg',
   msg: 1232,
   time: 3,
   barrageStyle: 'red'
  }
  ];
  list.forEach((v) => {
  this.barrageList.push({
   id: v.id,
   avatar: v.avatar,
   msg: v.msg,
   time: v.time,
   type: MESSAGE_TYPE.NORMAL,
   barrageStyle: v.barrageStyle
  });
  });
 },
    playAction(index){
      //下标从几开始播放
      this.$refs.videos[index].playOrStop()
    },
    //弹出评论
    showCom(){
      this.showComment = true;
    },
    he(){
       this.$router.replace('/push')
    },
    du(){
      //前往充值
      this.$router.replace('/wallet')
    },
    dusd(){
      //前往商城
      this.$router.replace('/shopping')
    },
    close(){
      this.showComment = false;
    },
    cl(){
      this.present=false;
      this.showComment = false;
    },
      gift(){
      this.present=true;
        bafelist().then(ren=>{
        this.list=ren.data.data.gifbags;
        //alert("礼物"+res.data.data.giftlist);
      })
      //查询背包
        bafelist().then(ren1=>{
        this.bagelist=ren1.data.data.gifbags;
        //  alert("礼物"+res.data.data.giftlist);
      })
    },
    
    //点击变色 , 获取 礼物R币
liClick(index,r,url,money,gname,count,giftid){
        this.currentIndex = index
        this.R=r  
        this.ttsrc=url;
        this.money=money;
        this.gname=gname;
        this.giftid=giftid
        this.count=count;
        // alert("数量"+count+"礼物id"+giftid);
        this.index=index;
				},
       confi(){
       if(this.R>this.my){
        // this.dataList.userId 用户视频

        console.log(this.dataList.video)
        // alert("礼物金额"+this.money);
        // alert("R币"+this.R);
        // alert("礼物昵称"+this.gname)
        const ins=this.index;
        // alert("in"+ins);
        this.list[ins];
        // alert("礼物数组:")
        //前端传礼物id到后台
        this.list[ins].giftCount=this.count-1;
        // alert("礼物数量"+this.count);
        if (this.count<=0) {
          this.$message({
          showClose: true,
          message: '礼物数量不够请先去商城购买',
          type: 'error'
        });
        }
        upgifbags(this.dataList.video,this.money,this.R,this.gname,this.giftid).then(reds=>{
           if (reds.data.message==true) {
                     this.gyds=true
                     this.$message({
                    showClose: true,
                      message: '发送成功',
                      type: 'success',
                      duration:800
        });
                  var ios=this;
                    setTimeout(function() {
                        ios.gyds=false;   
                    }, 3600)
           }else if (reds.data.message==false) {
                        this.$message({
                        showClose: true,
                        message: '发送失败',
                        type: 'error'
        });
           }else{
             this.$message({
                        showClose: true,
                        message: '发送失败,自己不能给自己送礼物',
                        type: 'error'
             })
           }
           
           {

           }
        })

        this.ccsrc=this.ttsrc;
        this.present=false;
        this.showComment = false;

        //this.showComment = false;
       }else if(this.R==''){
         this.$message({
          showClose: true,
          message: '请选择礼物发送',
          type: 'error'
        });
       }else{
        // alert("送物发送成功")
       }
    },
      
    zdsa(){
       if(this.input=="" || this.input==null){
           this.$message({
                        showClose: true,
                        message: '请规范输入',
                        type: 'error'
           });
       }else{
         this.zgsd=this.zgsd+1
         this.bookList.push({
            avatar:this.userlist.head,
            name:this.userlist.userName,
            msg: this.input
         })
          //this.$route.query.mallCode视频id;
          addcomment(this.userlist.userName,this.userlist.head,this.input,this.$route.query.mallCode).then(resjusd=> {
         })

       this.barrageList.push({
        id: 7,
        //用户头像
        avatar: this.userlist.head,
        //弹幕的内容
        msg: this.input,
        time: 7,
        barrageStyle: 'red'
        });
        this.input=null
       }
    },
    getParams(){
    // 取到路由带过来的参数
    this.$route.query.mallCode
    // alert("this.routerParams"+this.routerParams)
    // 将数据放在当前组件的数据内
   }
  },
   watch: {
   '$route': 'getParams'
  },
  created(){
   //alert("传进来的值"+this.$route.query.mallCode);
  //查询视频+描述+赞数+弹框数量 
        // this.showComment = true;
        // console.log("showComment"+showComment)
         const Pthis=this;
         personage(this.$route.query.mallCode).then(res => {
            Pthis.dataList=res.data.data.video;
            console.log(Pthis.dataList);
            console.log("所有"+this.ahsd)
            // console.log("视频描述"+res.data.data.video.video.videoDescript)
            // console.log("返回值"+res.data.data.video.video.videoId)
            // console.log("用户信息"+res.data.data.user.userName)
            this.sou.userName=res.data.data.user.userName
            this.sou.videoDescript=res.data.data.video.video.videoDescript
            console.log("评论"+res.data.data.barrage)
            Pthis.barrageList=res.data.data.barrage;
            this.bookList=res.data.message;
            this.zgsd=this.bookList.length;
  //            let list = [
  // {
  //  id: 1,
  //  avatar: 'https://guil-file-200211.oss-cn-beijing.aliyuncs.com/Oops/logo.jpg',
  //  msg: 1232,
  //  time: 3,
  //  barrageStyle: 'red'
  // }
  // this.list.msg="JHHHH";  
         })
                  var userJsonStr = sessionStorage.getItem('user');
                  this.userlist = JSON.parse(userJsonStr);
  },
  filters: {
        formatDate(time) {
            var date = new Date(time);
            return formatDate(date,'yyyy-MM-dd hh:mm:ss');
        }
    },
  data(){
    return{
      giftid:0,
      gname:'',
      money:'',
      msg: '哈哈哈哈~',
      activeName: 'first',
      count:0,
      gyds:false,
      present :false,
      barrageIsShow: true,
      userlist:{},
      currentIndex:'',
      messageHeight: 3,
      boxHeight: 150,
      barrageLoop: true,
      maxWordCount: 3,
      throttleGap: 5000,
      barrageList: [],
      bookList:[],
      ccsrc:'',
      ttsrc:'',
      zgsd:0,
      ahsd:[{
      id:1,
      avatar:'123',
      msg:"12321",
      barrageStyle:"red",
      time:3,
      name:"1232",
      index:'',
    }],
      sou:{
        userName:'1232',
        videoDescript:'1231'
      },
       //我的信息
       //我的名称
       //我的头像
      //我的R币
      my:0,

     //礼物的R币
      R:'',
      // 弹幕的值 
       input: null,
      ///////////
      showComment:false,
      page:1,
      swiperOption: {
        //垂直方向滑动
        direction:"vertical",
        grabCursor: true, 
        setWrapperSize: true, 
        autoHeight: true, //自动高度。设置为true时，wrapper和container会随着当前slide的高度而发生变化
        slidesPerView: 1,
        mousewheel: true, 
        mousewheelControl: true, 
        // 高度设置，占满设备高度
        height: window.innerHeight,
        resistanceRatio: 0, 
        observeParents: true, 
        on:{
          //详见：https://www.swiper.com.cn/api/event/226.html
          tap:() => {
              this.playAction(this.page-1);
          },
        }
      },
      // 某个发布者的视频,点赞数 播放数 发布的日期 发布者的头像
  dataList:{},  
      bagelist:[], 
      list:[
              {
                id:1,
                name:'烟花',
                currency:98,
                scrimg:'https://wimg.588ku.com/gif620/20/12/06/350cc05ccdbdfb5b195f7d045f6da356.gif',
              },
              {
                id:1,
                name:'牛年大吉',
                currency:108,
                scrimg:'https://wimg.588ku.com/gif620/20/11/12/100410d50538e639a731c33107837d7a.gif',
              },
              {
                id:1,
                name:'招财进宝',
                currency:168,
                scrimg:'https://wimg.588ku.com/gif620/20/12/21/251f703322afa52c5f2b2f2b89dbb513.gif',
              },
              {
                 id:1,
                name:'牛气冲天',
                currency:668,
                scrimg:'https://wimg.588ku.com/gif620/20/12/08/c4d38780361d737d193916eee8c6c61b.gif',
              },
              {
                 id:1,
                name:'财神爷',
                currency:1680,
                scrimg:'https://wimg.588ku.com/gif620/20/11/26/ecfef86ba5a3ea1a810311936f9efcae.gif',
              },
              {
                 id:1,
                name:'财源滚滚',
                currency:1260,
                scrimg:'https://wimg.588ku.com/gif620/20/11/26/4d7002eba45c480e7723999d8a61dd9a.gif',
              },
              {
                 id:1,
                name:'棒棒糖',
                currency:10,
                 scrimg:'https://wimg.588ku.com/gif620/20/12/06/350cc05ccdbdfb5b195f7d045f6da356.gif',
              },
              {
                 id:1,
                name:'爱你久久',
                currency:10,
                 scrimg:'https://wimg.588ku.com/gif620/20/12/06/350cc05ccdbdfb5b195f7d045f6da356.gif',
              },
              {
                id:1,
                name:'飞机',
                currency:10,
                 scrimg:'https://wimg.588ku.com/gif620/20/12/06/350cc05ccdbdfb5b195f7d045f6da356.gif',
              },
              {
                 id:1,
                name:'富贵锦鲤',
                currency:10,
                 scrimg:'https://wimg.588ku.com/gif620/20/12/06/350cc05ccdbdfb5b195f7d045f6da356.gif',
              },
              {
                id:1,
                name:'助威',
                currency:10,
                 scrimg:'https://wimg.588ku.com/gif620/20/12/06/350cc05ccdbdfb5b195f7d045f6da356.gif',
              },
              {
                id:1,
                name:'生日蛋糕',
                currency:10,
                 scrimg:'https://wimg.588ku.com/gif620/20/12/06/350cc05ccdbdfb5b195f7d045f6da356.gif',
              },
              {
                id:1,
                name:'黑卡',
                currency:10,
                 scrimg:'https://wimg.588ku.com/gif620/20/12/06/350cc05ccdbdfb5b195f7d045f6da356.gif',
              },
              {
               id:1,
                name:'火箭',
                currency:10,
                 scrimg:'https://wimg.588ku.com/gif620/20/12/06/350cc05ccdbdfb5b195f7d045f6da356.gif',
              },
              {
               id:1,
                name:'我来啦',
                currency:10,
                 scrimg:'https://wimg.588ku.com/gif620/20/12/06/350cc05ccdbdfb5b195f7d045f6da356.gif',
              },
              {
                id:1,
                name:'约吗',
                currency:10,
                scrimg:'https://wimg.588ku.com/gif620/20/12/06/350cc05ccdbdfb5b195f7d045f6da356.gif',
              }
        ] 
    }
    addToList :[

    ]
},
 mounted() {
 this.addToList();
 },
//   methods: {
//  addToList() {
//   let list = [
//   {
//    id: 1,
//    avatar: 'https://guil-file-200211.oss-cn-beijing.aliyuncs.com/Oops/logo.jpg',
//    msg: this.msg,
//    time: 3,
//    barrageStyle: 'red'
//   },
//   {
//    id: 2,
//    avatar: 'https://guil-file-200211.oss-cn-beijing.aliyuncs.com/Oops/logo.jpg',
//     msg: this.msg,
//    time: 8,
//    barrageStyle: 'green'
//   },
//   {
//    id: 3,
//    avatar: 'https://guil-file-200211.oss-cn-beijing.aliyuncs.com/Oops/logo.jpg',
//     msg: this.msg,
//    time: 10,
//    barrageStyle: 'normal'
//   },
//   {
//    id: 4,
//    avatar: 'https://guil-file-200211.oss-cn-beijing.aliyuncs.com/Oops/logo.jpg',
//    msg: this.msg,
//    time: 5,
//    barrageStyle: 'blue'
//   },
//   {
//    id: 5,
//    avatar: 'https://guil-file-200211.oss-cn-beijing.aliyuncs.com/Oops/logo.jpg',
//    msg: this.msg,
//    time: 6,
//    barrageStyle: 'red'
//   }
//   ];
//   list.forEach((v) => {
//   this.barrageList.push({
//    id: v.id,
//    avatar: v.avatar,
//    msg: v.msg,
//    time: v.time,
//    type: MESSAGE_TYPE.NORMAL,
//    barrageStyle: v.barrageStyle
//   });
//   });
//  }
//  }
}
</script>

<style scoped>

.ksls{
      z-index: 50;
}
.video-js.vjs-fluid, .video-js.vjs-16-9, .video-js.vjs-4-3{
      width: 18%;
    /* max-width: 100%; */
    height: -73%;
}

.bottom_center_box[data-v-8c97cc72] {
    width: 100%;
    height: 40px;
    overflow: hidden;
    position: fixed;
    bottom: 0px;
    z-index: 215;
    background-color: #FFF;
    border-top: 1px solid #CCC;
}

  .aui-scrollView{
    width: 100%;
    height: 12%;
    flex: 1;
    overflow-y: auto;
    overflow-x: hidden;
    -webkit-overflow-scrolling: touch;
    position: relative;
    margin-top: 52px;
    padding-bottom: -14px;
  }

 .blue {
 border-radius: 100px;
 background: #e6ff75;
 color: #fff;
 }
 .green {
 border-radius: 100px;
 background: #75ffcd;
 color: #fff;
 }
 .red {
 border-radius: 100px;
 background: #e68fba;
 color: #fff;
 }
 .yellow {
 border-radius: 100px;
 background: #dfc795;
 color: #fff;
 }
 .baberrage-stage {
 position: absolute;
 width: 100%;
 height: 212px;
 overflow: hidden;
 top: 0;
 margin-top: 15%;
 /* background-color: red; */
position: absolute; z-index: 10
 }

  .baberrage-stage1 {
    position: absolute;
    width: 100%;
    height: 288px;
    overflow: hidden;
    top: 310px;
    margin-top: 15%;
    background-color: rgb(255, 255, 255);
    position: absolute;
    z-index: 10;
 }




body{
    height: 100px;

}
  .comment-body{
    max-width: 450px;
    height: 20vh;
    overflow: auto;
    margin-top: 20px;
  }

  /* .barrages-drop{
    max-width: 450px;
    overflow: auto;
    margin-top: 278px;
    background-color: #e68fba;
  } */

  .comment-item{
    display: flex;
  }

    .user-pic img{
    height:33px;
    width:33px;
    border-radius: 50%;
  }

    .item-info{
    margin-left: 10px;
    display: flex;
    flex:1 1 auto;
  }

    .reply{width:90%;}
     .reply-des{line-height: 24px;}
       .zan{text-align: center;}
  .zan .iconfont{
    font-size:20px;
  }
  .zan p{
    color:#cccccc;
    margin-top: 5px;
  }


.zki{
    position: relative;
    top: 23px;
    left: -267px;
    COLOR: #030100;
}

.zks{
   position: absolute;
    top: 0%;
    left: 106%;
    COLOR: #030100;
}



  .msg-list{
    display: flex;
    padding:10px 0;
    /* justify-content: space-between; */
  }
  .msg-list img{
    width:50px;
    height:50px;
    border-radius: 50%;
  }

  .rd{
    display: block;
}

 /* .el-tabs__item {
    padding: 0 20px;
    height: 50px;
    box-sizing: border-box;
    line-height: 40px;
    display: inline-block;
    list-style: none;
    font-size: 18px;
    font-weight: 500;
    color: #303133;
    position: relative;
} */
.user{
    display: block;
    text-align: center;
    margin-top: -2%;
}

.zds{
     
    display: block;
    margin-top: 4%;
    margin-left: 1%;
}

.fan{
   position: relative;
   top: 13px;
   left: 12px;
       COLOR: #030100;
}

  .user-des{
    flex: 1;
    height:60px;
  }
  .user-des .top{
    font-size: 14px;
    margin-left: 10px;
    display: flex;
    justify-content: space-between;
    line-height: 25px;
  }
  .top-msg{
    color: #666;
    align-items: center;
  }
  .no-see{
    width:8px;
    height: 8px;
    border-radius: 50%;
    background-color:#face15 ;
  }


div{

}
.dis{
    position: absolute;
    bottom: 31%;
    height: 26%;
    width: 100%;
}
.zdf{
     color: rgb(148, 141, 141);
    font-size: 10px;
    position: absolute;
    left: 4%;
    bottom: 73%;
    height: 26%;
    
}
.uz{
    font-size: 15px;
    position: absolute;
    left: 4%;
    bottom: 65%;
    height: 26%;
    overflow: auto;
}
.music{
    font-size: 15px;
    position: absolute;
    left: 3%;
    bottom: 56%;
    height: 26%;
    overflow: auto
}
.comment{
    font-size: 15px;
    position: absolute;
    left: 3%;
    bottom: 38%;
    height: 26%;
    overflow: auto;
}
.count{
font-size: 15px;
    position: absolute;
    left: 3%;
    bottom: 46.6%;
    height: 26%;
    overflow: auto;

}
.zdate{
    color: rgb(148, 141, 141);
   font-size: 10px;
 position: absolute;
    right: 4%;
    bottom: 73%;
    height: 26%;
    overflow: auto;
}
.video-js .vjs-tech {
    position: fixed;;
    top: 0;
    left: 0;
    width: 112%;
    height: 51%;
}

.active2{

    /* background-color:#dda0a0; */
    
     background:#f56c6c42;;
        }

  .video-list{
    height:100%;
  }
  .swiper-container{
    /* height:100%;
    position: relative; */
  }
  .infobar-warp{
    position: absolute;
    bottom:55px;
    left:0;
  }
  .right-warp{
    position: absolute;
    bottom: 50px;
    right:10px;
  }
  /* 评论 */
  .up-enter-active, .up-leave-active {
    transition: all .5s;
  }
  .up-enter, .up-leave-to /* .fade-leave-active below version 2.1.8 */ {
    opacity: 1;
    transform: translateY(100%);
  }

  .zwe p{
  text-align: center;
  display: inline-block;
  width: 33%;
  margin-bottom:-4%;
  margin-top: 4%;
}
.zwe{
  position:fixed;
    height:40%;
    overflow: auto;
}
.but{
    color: rgb(255 250 250);
    font-size: 18px;
    position: absolute;
    left: 39%;
    bottom: 9%;
    height: 8%;
}

.gi{
  max-width:41%;height:auto;
}

.send{
    color: rgb(4, 1, 7);
    font-size: 19px;
    position: absolute;
    left: 6%;
    bottom: 8%;
    height: 8%;
}

  .comment-warp{
    position:fixed;
    bottom:0;
    left:0;
    right:0;
    height:70%;
    width: 100%;
    background:white ;
    border-top-left-radius:10px;
    border-top-right-radius: 10px;
    z-index:999;
    padding:10px 10px;
    box-sizing: border-box;
  }
  .comment-top{
    display: flex;
    align-items: center;
  }
  .number{
    flex-grow: 1;
    text-align: center;
  }

    .num{
        position: absolute;
font-size: 16px;
    left: 62%;
    bottom: 89.5%;
  }

  .close{
    padding-right:10px;
    font-size: 21px;
    color:#666;
  }
  .comment-body{
    max-width: 450px;
    overflow: auto;
    margin-top: 20px;
  }
  .comment-item{
    display: flex;
  }
  .user-pic img{
    height:33px;
    width:33px;
    border-radius: 50%;
  }
  .item-info{
    margin-left: 10px;
    display: flex;
    flex:1 1 auto;
  }
  .reply{width:90%;}
  .reply-des{line-height: 24px;}
  .reply .name{
    color:#666;
    font-size: 14px;
    margin-bottom: 10px;
  }
  .reply .time{
    color:#666;
  }
  .zan{text-align: center;}
  .zan .iconfont{
    font-size:20px;
  }
  .zan p{
    color:#cccccc;
    margin-top: 5px;
  }

  .reply-input{
    width:100%;
    height:50px;
    position: fixed;
    bottom: 0;
    left:0;
    right:0;
    background: #ffffff;
    display: flex;
    align-items: center;
  }
  .reply-input input{
    line-height: 40px;
    width: 70%;
    border: none;
    padding:0 10px;
  }
  .reply-input .at1{
    font-size: 30px;
    color: #cccccc;
    margin-right: 8%;
  }
  .reply-input .iconfont{
    font-size: 30px;
    color: #cccccc;
  }
  html,body{height:100%}

</style>

