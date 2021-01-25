<template>
    <div>
            <p>
                <a class="fan" @click="cancel"><</a>
                <span class="user">{{username}}</span>
                </p>
       <div class="zds">
        <el-tabs v-model="activeName">
            <el-tab-pane label="关注" name="first">
            <div  v-for="(item,index) in listattention" :key="index" :videoList="item" :index="index">
                <div class="rd">    
                    <div class="msg-list-box">
                            <div class="msg-list">
                            <img :src="item.head">
                            <div class="user-des">
                                <div class="top">
                                <span>{{item.userName}}</span>
                                </div>
                                <div class="top top-msg">
                                <span>{{item.signature}}</span>
                                  <el-button type="info" size="mini" round>发送信息</el-button>
                                </div>
                            </div>
                            </div>
                    </div>
                </div>
            </div>

            </el-tab-pane>
         
            <el-tab-pane label="粉丝" name="fourth">
            <div  v-for="(item,index) in listfans" :key="index" :videoList="item" :index="index">
                <div class="rd">    
                    <div class="msg-list-box">
                            <div class="msg-list">
                            <img :src="item.head">
                            <div class="user-des">
                                <div class="top">
                                <span>Opps小助手</span>
                                </div>
                                <div class="top top-msg">
                                 <span></span>
                                <span class="no-see">{{item.userName}}</span>
                                </div>
                            </div>
                             </div>
                    </div>
                </div>
            </div>
            </el-tab-pane>
        </el-tabs>
    
       </div>
    </div>
</template>

<script>

//引入api
import {attention , fans} from '@/api/Attention.js'

export default {

    data(){ 
        return{
          username:'我的Oops',
          activeName: 'first',
          listattention:[],
          listfans:[]
        }
    },
  created(){
          attention().then(res => {
            this.listattention=res.data.message
              console.log("返回值"+res.data.message)
              ////localStorage.setItem('token',"这个是一个token"),
          })

          fans().then(res => {
              this.listfans=res.data.message
          })
          this.getParams()
  },
    methods:{
        cancel(){
        document.querySelector('body').setAttribute('style', 'background-color:#FFFFFF')
        window.history.go(-1); 
      },
      getParams(){
    // 取到路由带过来的参数
       this.activeName = this.$route.query.mallCode
   //alert("this.routerParams"+this.routerParams)
    // 将数据放在当前组件的数据内
    // alert("传进来的值"+routerParams);
   }
    },
  watch: {
   '$route': 'getParams'
  },
    
}
</script>

<style scoped>


body{
  background-color: #FFFFFF;
}

.bot{
     position: fixed; /*or前面的是absolute就可以用*/  
     bottom: 0px;  
}

 .msg-list-box{
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