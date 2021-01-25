<template>
  <div class="right-bar">
    <div v-for="item in dataList">
    <div class="rightbar-item">
      <div class="avatar-border">
        <img src="../../assets/img/xxx.jpeg">
        <span class="iconfont  icon-jia-tianchong"></span>
      </div>
    </div>

    <!-- 点赞 图标-->
    <div class="item-icon">
      <span  @click="changeTop(1)" class="iconfont icon-aixin">
        <a :class="aixinindex=0"></a>
      </span>
      <!-- 喜欢数 -->
      <p>{{item.aixin}}</p>
    </div>

    <!-- 评论图标 -->
    <div class="item-icon" @click.stop="showCom($event)">
      <span class="iconfont icon-pinglun"></span>
      <p>{{item.pinglun}}</p>
    </div>

    <!-- 分享页面 -->
    <div class="item-icon">
      <span class="iconfont icon-fenxiang"></span>
      <p>{{item.fenxiang}}</p>
    </div>
    <div class="rightbar-item">
      <div class="right-music">
        <img src="../../assets/img/xxx.jpeg">
      </div>
    </div>
  </div>
  </div>
</template>

<script>
export default {
  // VideoList.vue传过来的
  props:["showComment"],
  data(){
    return {
      aixinindex:0,
      dataList:[
        {
           aixin:10,
           pinglun:100,
           fenxiang:1000
        },
        {
           aixin:20,
           pinglun:200,
           fenxiang:2000
        },
        {
           aixin:30,
           pinglun:300,
           fenxiang:3000
        },
        {
           aixin:40,
           pinglun:400,
           fenxiang:4000
        }
      ]
    }
  },
  methods:{
    showCom(e){
      e.preventDefault();
      this.$emit('changeCom',this.showComment);
    },
    //默认是0 
    changeTop(index){
      this.aixinindex =1;
    }
  }
}
</script>

<style>
  /* .right-bar {
    width:80px;
    border:1px solid red;
  } */
  .rightbar-item{
    height:70px;
    width:100%;
    display: flex;
    justify-content: center;
    align-items: center;
    padding-bottom: 10px;
  }
  .avatar-border{
    height:50px;
    width:50px;
    border:1px white solid;
    border-radius: 50%;
    position: relative;
    text-align: center;
  }
  .avatar-border img{
    height:49px;
    width:49px;
    border-radius: 50%;
  }
  .icon-jia-tianchong{
    color: red;
    position:absolute;
    top:35px;
    left:0;
    right:0;
  }
  .item-icon{
    height:60px;
    text-align: center;
    padding-top: 14px;
  }
  .item-icon .iconfont{
    color: #ffffff;
    font-size: 35px;
  }
  .item-icon p{
    color: #ffffff;
    font-size: 14px;
    padding-top: 5px;
  }
  .right-music{
    height:54px;
    width:54px;
    background: #2e2e2e;
    border-radius: 50%;
    display: flex;
    justify-content: center;
    align-items: center;

    animation: round 6s 0s linear infinite;
  }
  .right-music img{
    height:30px;
    width:30px;
    border-radius: 50%;
  }
  .iconfont icon-aixin{
    
    background-color: red;
    background-size: cover;
    width: 64px;
    height: 64px;
    display: inline-block;
    background-blend-mode: lighten
  }

  @keyframes round{
    0%{transform: rotate(0deg);}
    100%{transform: rotate(360deg);}
  }
</style>