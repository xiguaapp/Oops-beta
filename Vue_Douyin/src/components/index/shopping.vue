<template>
    <div id="app">

<el-drawer
  :size="size"
  :visible.sync="drawer"
  :direction="direction"
  :before-close="close"
  >
  <div class="zop">
    <p class="tite" >支付</p>
    <p class="sdf">{{r}} R币</p>
    <p class="sdt"></p>      
    <div class="sfg">     
             <ur>
                <li class="rd">    
                    <div class="msg-list-box">
                            <div class="msg-list">
                            
                            <span class="el-icon-user-solid" >R币支付</span>
                            
                             </div>
                    </div>
                </li>
            </ur>
    </div>
    <p><el-button type="info" class="ann" @click="payment">支付</el-button></p>
  </span>
  </div>
</el-drawer>


   <div class="block">
    <el-carousel height="150px">
        <span style="color:red">12</span>
        <el-carousel-item v-for="item in imglist" :key="item">
        <img  :src="item.scr"/>
      </el-carousel-item>
    </el-carousel>
  </div>
  <div>
     <p class="discount">
     <el-row>
     <el-button type="warning" icon="el-icon-back" circle @click="close"></el-button>    
     <span>&nbsp;</span>
     <a href="/mall"> <el-button type="danger" icon="el-icon-user" circle></el-button></a>
      </el-row>
     </p>
     <p></p>
  </div>
  <div class="zkd">
      <div class="zwe"> 
                  <p class="pitch" @click="liClick(index,item.gifprice,item.giftid,item.gifname)" v-for="(item,index)  in list">
                  <span></span></br>
                  <span><img class="gi" :src="item.gifimageurl"></span></br>  
                  <span>{{item.gifname}}</span></br>
                  <span style="font-size:10px">{{item.gifprice}} R币</span>
                  </p>
            </div>
    </div>
  </div>  
</template>

<script>

//引入api
import {giflist,addpayment}  from '@/api/video.js';
export default {
     methods:{
        close(){
            // location.href="/index"
            // alert("关闭")
            this.drawer=false
         }
         ,
         liClick(index,r,gid,gifname){
           //r币,礼物id,礼物昵称
          //  alert("R币"+r+"礼物id"+gid+"礼物昵称"+gifname);
           this.gid=gid;
           this.gifname=gifname;
           this.drawer=true
           this.r=r
          //  alert('rb币'+r+"金额"+money)
         },
        payment(){
           this.r
           this.gid
           this.gifname
          // alert("R币"+this.r+"礼物id"+this.gid+"礼物昵称"+this.gifname)
                     addpayment(this.r,this.gid,this.gifname).then(ref=>{
                         if (ref.data.message==true) {
                            this.drawer=false
                        this.$message({
                        showClose: true,
                        message: '购买成功',
                        type: 'success',
                        duration:800
                         });
                         }else if(ref.data.message==false){
                            this.drawer=false
                             this.$message({
                        showClose: true,
                        message: '发送失败',
                        type: 'error'
                          });
                         }else{
                            this.drawer=false
                         this.$message({
                           
                        showClose: true,
                        message: 'R币不足,请先充值',
                        type: 'error'
                        
                     })
                         }
                     })
         }
     },
    data(){
        return{
           drawer: false,
           size: '57%',
           direction: 'btt',
           r:0,
           gid:0,
           gifname:'',
          money:0,
          // 礼物id 礼物名称 礼物金额 礼物R币
          list:{},
          imglist:[
            {
              scr:'https://guil-file-200211.oss-cn-beijing.aliyuncs.com/Oops/1.jpg'
            },{
              scr:'https://guil-file-200211.oss-cn-beijing.aliyuncs.com/Oops/2.jpg'
            }, {
              scr:'https://guil-file-200211.oss-cn-beijing.aliyuncs.com/Oops/3.jpg'
            }, {
              scr:'https://guil-file-200211.oss-cn-beijing.aliyuncs.com/Oops/4.jpg'
            }
          ]
        }
    },
       created: function(){
  
     giflist().then(ren=>{
        this.list=ren.data.data.giftlist;
        //  alert("礼物"+res.data.data.giftlist);
      })
   }
}
</script>

<style scoped>

  .el-carousel__item img {
    color: #475669;
    font-size: 14%;
    opacity: 0.75;
    line-height: 150%;
    margin: 0;
  }

  .discount{
         position: absolute; 
        left: 9%;
        top: 25%;
      text-align: center;

  }

  .el-carousel__item:nth-child(2n) {
     background-color: #d3dce6;
  }
  
  .el-carousel__item:nth-child(2n+1) {
     background-color: #d3dce6;
  }

.block{
      background-color: #d3dce6;
}
.zdo{
   position: absolute; 
  left: 0%;
  top: 42%;
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
    height:68%;
    overflow: auto;
    margin-bottom:-4%;
}
.zkd{
    position: absolute;
    overflow: auto;
    bottom: 63%;
    height:6%;
}

.tite[data-v-39e661de] {
    width: 85%;
    height: 10%;
    position: absolute;
    left: 45%;
    top: 5%;
    font-size: 20px;
}


.sdt[data-v-39e661de] {
    position: absolute;
    left: 43%;
    top: 24%;
}
.sfg[data-v-39e661de] {
    position: absolute;
    left: 0%;
    top: 42%;
}
.msg-list span[data-v-39e661de] {
    position: relative;
    left: 3%;
    top: 34%;
    bottom: 33px;
    color: rgb(24, 3, 3);
    font-size: 18px;
}
.ann[data-v-39e661de] {
    width: 85%;
    height: 10%;
    position: absolute;
    left: 8%;
    top: 85%;
    font-size: 16px;
}
button[data-v-39e661de] {
    color: #ffff;
    background-color: #f78989;
}
.sdf{
    font-size: 28px;
    color: #000000;
    position: absolute;
    left: 40%;
    top: 14%;
  }
  .sdt{
  
    position: absolute; 
    left: 43%;
    top: 24%;
  }
  
  .sfg{
     position: absolute; 
    left: 0%;
    top: 42%;
  }
  
    .el-drawer {
      position: absolute;
      box-sizing: border-box;
      background-color: #808080;
      display: flex;
      flex-direction: column;
      box-shadow: 0 8px 10px -5px rgba(0,0,0,.2), 0 16px 24px 2px rgba(0,0,0,.14), 0 6px 30px 5px rgba(0,0,0,.12);
  }
  
  
  .user{
      width: 100%;
      display: block;
      margin-top: -2%;
  }
  
  element.style {
      height: 58%;
  }
  
  
  
  
  .return .r{
    float:left;
  }
  .return .w{
  position: absolute; 
  left: 85%;
  top: 34%;
  }
  
  .zwe p{
    text-align: center;
    display: inline-block;
    width: 33%;
    margin-bottom:-4%;
    margin-top: 10%;
  }
  
  .return .b{
     position: absolute;   
     left: 45%;
     top: 34%;
      color: #fff;
      font-size: 18px;
  }
  
  .msg-list span{
     position: relative;   
     left: 3%;
     top: 34%;
     bottom: 33px;
      color: rgb(24, 3, 3);
      font-size: 18px;
  } 
  
  button{
    color:#ffff;
    background-color: #f78989;
  }
  
  button span{
     color:#ffff;
    background-color: #f78989;
  };
  
  
  .resource{
      display: block;
      margin-top: 19%;
      margin-left: 90%;
       
  }
  .zsd{
      position: absolute;
      left: 6%;
      top: 131%;
      color: #fff;
      font-size: 13px;
      width: 88%;
      height: 201%;
      background-image: url("/img/bq.a86aedb1.jpg"); background-repeat: no-repeat; background-size: 100% 100%;
    
  }
  .zd{
    position: absolute;
      left: 11%;
      top: 31%;
  }
  .zz{
    position: absolute;
      left: 34%;
      top: 144%;
      font-size: 18px;
  }
  
  .z{
    position: absolute;
      left: 64%;
      top: 31%;
  }
  .zl{
    position: absolute;
      left: 34%;
      top: 144%;
      font-size: 18px;
  }
  .come{
  position: absolute;
      left: 6%;
      top: 364%;
  }
  .total{
  position: absolute;
      left: 67%;
      top: 364%;
  
  }
  .show{
    position: absolute;
      left: 6%;
      top: 437%;
      width: 88%;
      height: 451%;
   
    filter:alpha(opacity=50);  
    opacity:0.5; 
    background-color:#31383185;
  }
  .deposit{
      position:relative;
      left: 72%;
          transform:translateY(-50%);/**上移元素**/
  }
  .zks{
     position:relative;
        left: 10%;
      transform: translateY(27%);
  }
  
  
  
  
   .top-bar{
      position: fixed;
      /* background-color:black; */
      height:55px;
      width:100%;
      font-size:18px;
      color:#cccccc;
      padding:20px;
      display: flex;
      box-sizing: border-box;
      /* 使用层级关系让被视频盖住的部分显示出来 */
      z-index: 999;
    }
  
  .v-modal {
      position: fixed;
      left: 0;
      top: 0;
      width: 100%;
      height: 100%;
      opacity: .5;
      background: #000;
  }
    a{
        COLOR: #ffffff;
    }
    .ann{
      width: 85%;
      height: 10%;
      position: absolute;
      left: 8%;
      top: 85%;
      font-size: 16px;
    }
  
    .tite{
      width: 85%;
      height: 10%;
      position: absolute;
      left: 45%;
      top: 5%;
      font-size: 20px;
    }
      .msg-list img{
    width: 15%;
    height: 42%;
    border-radius: 50%;

    }
  
    .rd{
      display: block;
  }
  
   .el-tabs__item {
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
  }
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
</style>