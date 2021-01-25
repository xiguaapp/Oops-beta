<template>
  <div class="message">
    <my-header :title="news" :hasRight="true" rightTx="发起聊天"></my-header>
    <div class="msg-warp">
      <div class="msg-list-box">
         
        <div class="msg-list" v-if="news=='粉丝'" v-for="item in fanslist" >
          <img :src="item.head">
          <div class="user-des">
            <div class="top">
              <span>{{item.userName}}</span>
              <span>></span>
            </div>
            <!-- {{cc}} -->
            <div class="top top-msg">
              <span>关注了你</span>&nbsp;
              <span style="
    POSITION: RELATIVE;
    LEFT: 32%;">{{item.datime}}</span>
                
              <!-- <span class="no-see"></span> -->
          </div>
        </div>
          </div>

        <div class="msg-list" v-if="news=='评论'" v-for="item1 in commentlist">
          <img src="../../assets/img/xxx.jpeg">
          <div class="user-des">
            <div class="top">
              <span>{{item1.userName}}</span>
              <span>></span>
            </div>
            <div class="top top-msg">
              <span>赞了你的作品</span>
        <span style="
    POSITION: RELATIVE;
    LEFT: 32%;"></span>
            </div>
          </div>
        </div>

        <div class="msg-list" v-if="news=='点赞'" v-for="item in givelist" :v-text="rr">
          <img src="../../assets/img/xxx.jpeg">
          <div class="user-des">
            <div class="top">
              <span>{{item.userName}}</span>
              <span>></span>
            </div>
            <div class="top top-msg">
              <span>赞了你的作品</span>
    <span style="
    POSITION: RELATIVE;
    LEFT: 32%;">{{item.datime}}</span>
            </div>
          </div>
        </div>

      </div>
    </div>
  </div>
</template>
<script>
import myHeader from '../../components/header/myHeader'
import { fans,give,comment} from '@/api/message.js';
export default {
     created(){
         this.news=this.$route.query.mallCode;
         alert(" this.news"+ this.news)
    //   alert("this.$route.query.mallCode;"+this.$route.query.mallCode);
  },
  components:{
    myHeader
  },
  watch:{
    news(){
        if(this.news=="粉丝"){
         fans().then(res1=>{
            console.log("粉丝触发"+res1.data.message)
            this.fanslist=res1.data.message;
          });
        }else if(this.news=="评论") {
            //  alert("评论")
             comment().then(res2=>{
             console.log("评论触发"+res2.data.message)
             this.commentlist=res2.data.message;
          });
            //  fans().then(res1=>{
            //     console.log("粉丝触发"+res1.data.message)
            //     this.fanslist=res1.data.message;
            //   });
        }else{
             give().then(res3=>{
            console.log("点赞触发"+res3.data.message)
             this.givelist=res3.data.message;
          });
        }
    }
  },
  data(){
		  return{
          news:'',
          //关注
          fanslist:[],
          //评论
          commentlist:[],
          //点赞
          givelist:[]
      }
   },
    // computed:{
    //     //粉丝触发
    //   cc: function(){
    //       alert("粉丝触发")
    //       var sum = 0;
    //       fans().then(res1=>{
    //         console.log("粉丝触发"+res1.data.message)
    //         this.fanslist=res1.data.message;
    //       });
	// 	  return sum;
    //   },
    //   //评论触发
    //   aa: function(){
    //       var sum = 0;
    //        comment().then(res2=>{
    //         console.log("评论触发"+res2.data.message)
    //         this.commentlist=res2.data.message;
    //       });
	// 	  return sum;
    //   },
    //   //点赞触发
    //   rr: function(){
    //       var sum = 0;
    //        give().then(res3=>{
    //         console.log("点赞触发"+res3.data.message)
    //          this.givelist=res3.data.message;
    //       });
	// 	  return sum;
    //   }
}
</script>
<style>
  .msg-warp{
    padding:0 20px;
    color: #ffffff;
    background-color: #101821;
    /* height:-webkit-fill-available; */
    height:1000px;
  }
  .msg-nav{
    padding:20px 5px;
    display: flex;
    justify-content: space-between;

  }
  .msg-nav-item{
    text-align: center;
    width:60px;
  }
  .icon-box{
    height:60px;
    width:60px;
    background-color:#ff4074;
    border-radius: 5px;
    margin-bottom: 5px;
  }
  .msg-list-box{
    padding-top:30px;

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
</style>