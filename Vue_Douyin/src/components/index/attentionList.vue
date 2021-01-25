<template>
  <div class="atten-list">
    <swiper :options="swiperOption">
      <!-- 幻灯内容 -->
      <!-- 循环输出 -->
      <swiper-slide v-for="(item,index) in dataList" :key="index"  v-bind:index="2">
        <div>
          <!-- ref：节点 -->
          <videos ref="videos" :videoList="item" :index="index"></videos>
        </div>
        <div class="infobar-warp">
          <!-- <info-bar></info-bar> -->
          <div class="info-bar">
    <div class="infobar-item"><span>@{{item.userName}}</span></div>
    <div class="infobar-item"><span>{{item.videoDescript}}</span></div>
    <div class="infobar-item music-item">
      <span class="iconfont icon-yinfu"></span>
      <div class="music-name">
        <span :data-text="item.userName+'的原声'">{{item.userName}}的原声</span>
      </div>
    </div>
          </div>
        </div>
        <div class="right-warp">
          <!-- 接收RightBar.vue穿过来的方法 -->
            <div class="right-bar">
    <div class="rightbar-item">
      <div class="avatar-border" style="z-index: 9999999;">
       <a> <img @click="look(item.userId)" :src="item.head"> </a>
        <!-- <span class="iconfont  icon-jia-tianchong"></span> -->
      </div>
    </div>
    <!-- 点赞 图标-->
    <div class="item-icon" @click="myClick(index,item.videoCount,item.videoId,item.videoUrl)">
      <!-- :style="ai==true?'color:red':'color:#fffcfc' -->
      <span  @click="changeTop(1)" class="iconfont icon-aixin" :style="ai==true?'color:red':'color:#fffcfc' ">
        <a :class="aixinindex=0"></a>
      </span>
      <!-- 喜欢数 -->
      <p>{{zks==null?item.videoCount:zks}}</p>
    </div>

    <!-- 评论图标 -->
    <div class="item-icon" @click.stop="showCom($event,item.videoId,item.videoUrl)">
      <span class="iconfont icon-pinglun"></span>
      <p>评论</p>
    </div>
    <!-- 礼物图标 -->
    <div class="item-icon">
      <span class="iconfont el-icon-present"  @click="gift"></span>
      <p>礼物</p>
    </div>
    <div class="rightbar-item">
      <div class="right-music">
        <img :src="item.head">
      </div>
  </div>
  </div>
        </div>
        <div class="right-zds">
               <img v-if="gyds" :src="ccsrc"  
      style="
    width: 700px;
    z-index: 999999;
      ">
        </div>
      </swiper-slide>    

    </swiper>

      <!-- 礼物列表 -->
    <transition name="up"> 
    <div class="comment-warp" v-if="present">
      <div class="comment-list">
        <div class="comment-top">
          <div class="number">送礼物</div>
          <div class="close" @click="close"><span>x</span></div>
        </div>


        <div>
          <el-tabs v-model="activeName" @tab-click="handleClick">
          
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
          <el-tab-pane label="充值" name="se"><a href="/wallet">去充值</a></el-tab-pane>
          <el-tab-pane label="更多..." name="s"><a href="/shopping">前往商城</a>
          </br>
          <a href="/push">推他上热门</a>
          </el-tab-pane>
        </el-tabs>
        </div>
        <div>
          <!-- <span class="send">送给<img></span> -->
          <span><el-button type="danger" :plain="true" @click="confi" class="but" round>确定</el-button></span>
        </div>
      </div>
    </div>
    </transition>

    <!-- 评论 -->
    <transition name="up"> 
    <div class="comment-warp" v-if="showComment">
      <div class="comment-list">

        <div class="comment-top">
          <div class="number">评论</div>
          <div class="close" @click="close"><span>x</span></div>
        </div>
        <div class="comment-body">
          <div class="comment-box">
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
            <!-- 评论框 -->
            <div class="reply-input">
               <el-input
  placeholder="留下你的精彩评论"
  style="width: 65%"
  v-model="input"
  clearable>
</el-input>
              <span class="at1">  <el-button type="primary" @click="zdsa" icon="el-icon-check" circle></el-button></span>
              <span class="iconfont icon-pinglun"></span>
            </div>
          </div>
        </div>

      </div>
    </div>
    </transition>
  </div>
</template>

<script>
//导入swiper组件'
import {Swiper,SwiperSlide} from 'vue-awesome-swiper'
import 'swiper/css/swiper.css'
import 'video.js/dist/video-js.css'
//导入播放组件
import Videos from '../../components/index/Videos'
import InfoBar from './InfoBar'
import RightBar from './RightBar'

//引入api
import { attentionlist,giflist } from '@/api/video.js';

//引入api
import { personage,addcomment,give,callgive,bafelist,upgifbags} from '@/api/video';

export default {
  name:'VideoList',
  routerParams:'null',
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
      
    look(id){
     this.$router.push({
      path: '/me',
      query: {
       mallCode: id
       }
       })
      alert("点击了.."+id);
},
     myClick(index,count,vid,vurl){
            alert("视频id"+vid);
            if (this.ai==true) {
            //取消点赞
            this.zks=count-1
            this.dataList[index].videoCount=this.zks
            this.ai=false;
            callgive(vid).then(res => {
              })
            }else{
            this.zks=count+1
             this.ai=true;
            this.dataList[index].videoCount=this.zks
          
            alert("点赞用户"+vurl)
             //点赞
              give(vid,this.userlist,vurl).then(res => {
                
              })
            }
               //alert("点赞"+ this.zks)
              },
//点击变色 , 获取 礼物R币
liClick(index,r,url){
        this.currentIndex = index
        this.R=r  
        this.ttsrc=url
				},
    gift(){
      this.present=true;
       giflist().then(ren=>{
        this.list=ren.data.data.giftlist;
        //  alert("礼物"+res.data.data.giftlist);
      })
    },
    playAction(index){
      //下标从几开始播放
      this.$refs.videos[index].playOrStop()
    },
    //上滑
    nextVideo(index){
       this.ccsrc="";
       this.zks=null
      //通过DOM元素来获取子组件的方法
      //上一个视频停止
      this.$refs.videos[index-1].stop();
      //下一个视频开始
      this.$refs.videos[index].play();
    },
    //下滑
    preVideo(index){
      this.ccsrc="";
      this.zks=null
      this.$refs.videos[index+1].stop();
      this.$refs.videos[index].play();
    },
    //弹出评论
    showCom(index,vid,vvrl){
      this.vids=vid;
      this.vurls=vvrl;
      this.showComment = true;
      //执行弹幕
      // alert("视频id"+vid);
       const Pthis=this;
         personage(vid).then(res => {
            alert("评论"+res.data.message)
            this.bookList=res.data.message;
         })
    },
    close(){
      this.present=false;
      this.showComment = false;
    },
        zdsa(){

       if(this.input=="" || this.input==null){
           alert("请规范输入")
       }else{
         this.zgsd=this.zgsd+1
         this.bookList.push({
            avatar: this.userlist.head,
            name:this.userlist.userName,
            msg: this.input
         })
         addcomment(this.userlist.userName,this.userlist.head,this.input,this.vids,this.userlist,this.vurls).then(res => {
      
         })

        this.input=null
       }
    },

           confi(){
       if(this.R>this.my){
          this.$message({
          showClose: true,
          message: '发送成功',
          type: 'success',
          duration:800
        });
        this.ccsrc=this.ttsrc;
        this.present=false;
        this.showComment = false;
        this.gyds=true
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

    getParams(){
    // 取到路由带过来的参数
    
    this.routerParams = this.$route.query.mallCode
    // alert("this.routerParams"+this.routerParams)
    // 将数据放在当前组件的数据内
    //alert("传进来的值"+routerParams);
   }
  },
   watch: {
   '$route': 'getParams'
  },
  // directives:{
  //   swiper:directive
  // },
        // 一加载就获取视频
        /*初始化操作  当页面一加载就执行这个操作*/
        created(){
            alert("关注人的视频")
             attentionlist().then(res => {
                 console.log("res.data.data"+res.data.data.v);
                 this.dataList=res.data.data.v;
                 var userJsonStr = sessionStorage.getItem('user');
                 this.userlist = JSON.parse(userJsonStr);
                 
                //  console.log("hhhh"+this.userlist.userId)
               // console.log(userEntity.userName); // => tom
                // alert("session值"+this.userlist.userName)
                //this.uuname=this.dataList[0].username;
                //this.srcimgs=this.dataList[0].head;
                //uuname:'',
                //srcimgs:'',
                //alert("关注人"+this.dataList)
             })
            /*相当于jquery的get和post提交  then回调函数  后台date 数据返回*/
            /*这里会出现跨域问题  在后端去解决 添加一个配置类*/
            //有数据就赋值给页面上
           
           //const _this=this
            // axios.get("http://localhost:8989/vue").then(function (resp){
            //     //Pthis.books=resp.data;
            //     alert("...."+resp.data.name)
            //     // //打印日志*/
            //     //console.log(resp.data);
            // })
        },
  data(){
    return{
      uuname:'',
      srcimgs:'',
      vids:'',
      current:0,
       input: null,
      activeName: 'first',
      showComment:false,
      present :false,
      currentIndex:'',
      bookList:[],
      userlist:[],
      ai:true,
      count:0,
      zks:null,
      gyds:false,
      ccsrc:'',
     //我的R币
      my:0,
     ttsrc:'',
     //礼物的R币
      R:'',
      vurls:'',
      page:1,
       // 礼物id 礼物名称 礼物图片 礼物O币 送礼物的id 送给某个用户的id和头像 
        list:[
        ],
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
          //上滑
          //详见：https://www.swiper.com.cn/api/event/290.html
          slideNextTransitionStart: () => {
            this.page += 1;
            this.nextVideo(this.page-1);
            console.log(this.page);
          }, 
          slidePrevTransitionStart: () =>{
            if(this.page>1){
              this.page -= 1;
              this.preVideo(this.page-1);
              console.log(this.page);
            }
          }    
        }
      },
      // 用户视频 用户点赞数量 用户id 用户视频id
  dataList:[
        // {
        //   id: 4,
        //   aixin:4,
        //   pinglun:100,
        //   fenxiang:1000,
        //   videoUrl:"https://guil-file-200211.oss-cn-beijing.aliyuncs.com/Opps%E6%B5%8B%E8%AF%95%E5%AD%98%E5%82%A8%E8%A7%86%E9%A2%91/QQ%E8%A7%86%E9%A2%9120201210200011.mp4"
          
        // },
        // {
        //   id: 2,
        //   aixin:20,
        //   pinglun:200,
        //   fenxiang:3000,
        //   videoUrl:"https://guil-file-200211.oss-cn-beijing.aliyuncs.com/Opps%E6%B5%8B%E8%AF%95%E5%AD%98%E5%82%A8%E8%A7%86%E9%A2%91/QQ%E8%A7%86%E9%A2%9120201210195803.mp4"
        // },
        // {
        //   id: 3,
        //   aixin:30,
        //   pinglun:300,
        //   fenxiang:3000,
        //   videoUrl:"https://guil-file-200211.oss-cn-beijing.aliyuncs.com/Opps%E6%B5%8B%E8%AF%95%E5%AD%98%E5%82%A8%E8%A7%86%E9%A2%91/QQ%E8%A7%86%E9%A2%9120201214113527.mp4"
        // },
        // {
        //   id: 4,
        //   aixin:40,
        //   pinglun:400,
        //   fenxiang:5000,
        //   videoUrl:"http://video.jishiyoo.com/161b9562c780479c95bbdec1a9fbebcc/8d63913b46634b069e13188b03073c09-d25c062412ee3c4a0758b1c48fc8c642-ld.mp4"
        // }
      ] 
    }
}
}
</script>
<style>

.active2{

    /* background-color:#dda0a0; */
    
     background:#f56c6c42;;
        }

  .atten-list{
    height:100%;
  }
  .swiper-container{
    height:100%;
    position: relative;
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
     z-index: 9999999;
  }
   .right-zds{
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