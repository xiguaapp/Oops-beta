<template >
      <div class="search">
        <div class="ces">
             <!-- <input type="text" v-model="search"  placeholder="请输入关键词进行搜索" class="searchInput" style="padding-left: 10px;"> -->
             <!-- <el-input v-model="search" id="searchname" @blur="blurText" style="width:100%; margin-bottom:10px" placeholder="请输入内容"/>  -->
             <el-input  v-model="serc" id="searchname" @focus="blsd" @blur="blurText" style="width:100%; margin-bottom:10px" placeholder="请输入内容"/> 
             <!-- <input type="text"  id="searchname"  @blur="blurText"  placeholder="请输入内容" style="padding-left: 10px;"> -->
             <button class="cancel" @click="cancel">取消</button>

    <div v-if="ski">
          <ul >
            <!-- 视频标题  v-if="item.videoDescript.indexOf('font') !=-1 && showComment"-->
            <li  v-if="item.videoDescript!=null && item.videoDescript.indexOf('font') !=-1 && showComment"  v-for="(item,index) in lisker"  class="li" >
               <span class="iconfont icon-sousuo"></span> 
               <a @click="check(item.oid,item.videoDescript)" v-html="item.videoDescript">{{item.videoDescript}}</a><span></span>
            </li>

            <!--用户名 shows && item.username==item.username? index < 1:''-->
            <li  v-if="item.username.indexOf('font') !=-1" v-for="(item,index) in lisker"   class="li" >
               <span class="iconfont icon-sousuo"></span> 
               <a @click="check(item.oid,item.username)" v-html="item.username" ref="oopsname">{{item.username}}</a><span></span>
            </li>

            <!-- 注意！注意！注意！这里循环遍历的是items，不再是data里的list数组 -->    
            <li  v-for="(item,index) in items" class="li" v-if="showComment">
               <span class="iconfont icon-sousuo"></span> 
               <span v-html="item.msg">{{item.msg}}</span><span></span>
            </li>
        </ul>
    </div>
         <div class="zdsf" v-if="showss">
        <el-tabs v-model="activeName">
            <el-tab-pane label="视频" name="first">
              <div class="zwe"  
                  
               > 
         &nbsp;&nbsp;
        <div class="pitch" @click="videocl(item.videoId)"  v-for="(item,index) in liskerzs">
            <video id="video"  width="49.1%;">
              <source :src="item.videoUrl" type="video/mp4">
            </video>
              <div class="zpi">
                 <span class="zpa" v-html="item.videoDescript" >{{item.videoDescript}}</span></br>
                 <span class="info"><img :src="item.head"></span>
                 <span class="zps" v-html="item.username">{{item.username}}</span>
            </div>
                   &nbsp;&nbsp;
        </div>
         &nbsp;&nbsp;
            </div>
            </el-tab-pane>
         
            <el-tab-pane label="用户" name="fourth">
              <div>
                <div class="rd"  v-for="(item,index) in liskuser " @click="look(item.userid)">    
                    <div class="msg-list-box">
                            <div class="msg-list">
                            <img :src="item.head">
                            <div class="user-des">
                                <div class="top">
                                <span v-html="item.username">{{item.username}}</span>
                                </div>
                          <div class="top top-msg">
                              <span class="no-see" style="font-size:10px ;">粉丝:100W</span>
                          </div>

                          <div class="top top-msg">
                                <span class="no-see">{{item.signature}}</span>
                                </div>
                            </div>
                            <p class="gz"><a>查看</a></p>
                             </div>
                    </div>
                </div>
            </div>
            </el-tab-pane>
        </el-tabs>
    
       </div>

<div v-if="hotspot">
            <!--热点数据-->
        <div class="ger" v-if="showage"> 
            <span class="zds">猜你想搜</span>
            </br>
            <el-row :gutter="160" >
            <el-col :span="3"><div class="grid-content bg-purple">12321321</div></el-col>
            <el-col :span="3"><div class="grid-content bg-purple">123213123</div></el-col>
            <el-col :span="3"><div class="grid-content bg-purple">2132131231</div></el-col>
            <el-col :span="3"><div class="grid-content bg-purple">123213123123</div></el-col>
            <el-col :span="3"><div class="grid-content bg-purple">12321321</div></el-col>
            <el-col :span="3"><div class="grid-content bg-purple">123213123</div></el-col>
            <el-col :span="3"><div class="grid-content bg-purple">2132131231</div></el-col>
            <el-col :span="3"><div class="grid-content bg-purple">123213123123</div></el-col>
            </el-row>
        </div>   

         <!--排名-->
        <div class="get"  v-if="showage"> 
           <span class="hotspot">今日热点数据</span>
             <ur>
               <li v-for="item,key in listset" class="rd">
                 <span>{{key+1}}</span> <span>{{item.msg}}</span>
               </li>
             </ur>            
        </div>   
       
        </div>
</div>        
      </div>
</template>

<script>
//引入api
import { inq,usvideo,usersss} from '@/api/inquire.js'

export default {

     
     data () {
        return {
            serc:'',
             timer: null, // 定时器
            dus:'',
            shows:true,
            ski:'',
              loading: true,
            //根据名称查询包含的数据
            list:[
                {msg:'aaa文本介绍1'},
                {msg:'bbb文本介绍2'},
                {msg:'ccc文本介绍3'},
                {msg:'ddd文本介绍4'},
                {msg:'eee文本介绍5'},
            ],
              // 查询热点的数据
             listset:[
             {msg:'热点1'},
             {msg:'热点2'},
             {msg:'热点3'},
             {msg:'热点4'},
             {msg:'热点5'},
            ],
            lisker:[],
            //视频内容
            liskerzs:[],
            //用户内容
            liskuser:[],
            showComment:false,
            showage:true,
            showss:false,
            hotspot:true,
            numses:'',
            n1:true,
            n2:false,
            yus:0,
            jiao:0,
            activeName: 'first'
        }
    },
    methods:{    
       videocl(index){
      this.$router.push({
      path: '/details',
      query: {
       mallCode: index
       }
       })
      alert("点击了.."+index);
       },
      look(id){
     this.$router.push({
      path: '/me',
      query: {
       mallCode: id
       }
       })
      alert("点击了.."+id);
},

        blurText(){
            this.showComment=true;
            var _search = this.serc;
            if(_search!=null && _search!=""){
             this.showage=false;
            }
      },

      blsd(){
         this.ski=true;
         this.showss=false;
        if(this.jiao==2){
            var _search = this.serc;
            //alert("输入"+_search)
            if (_search=="" || _search==null) {
               this.showage=false;
               this.hotspot=true;
                //alert("kong")
                this.shows=false;
                this.showss=false;
                this.showComment=true;
            }
            if(_search!=null && _search!=""){
              //this.jiao==2;
              //  输入事件
               this.showage=false;
               this.hotspot=true;
               //alert("kong")
               this.shows=false;
               this.showss=false;
                  inq(_search).then(res => {
                  this.lisker=res.data.data.ceshi;
                //  console.log(res.data.data.ceshi)
                 console.log("hhhh"+this.lisker)
                })
               this.showComment=true;
               this.showage=false;
               this.showComment=true;
               this.shows=true;
               
            if (_search) {
                //不区分大小写处理
                var reg = new RegExp(_search, 'ig')
                //es6 filter过滤匹配，有则返回当前，无则返回所有
                return this.list.filter(function(e) {
                    //匹配所有字段
                    return Object.keys(e).some(function(key) {
                        return e[key].match(reg);
                    })
                    //匹配某个字段
                    //return e.name.match(reg);
                })
            };
            return this.list;
        }else{
            this.showage=true;
        }
        }
      },
      cancel(){
        window.history.go(-1); 
       document.querySelector('body').setAttribute('style', 'background-color:#FFFFFF')
      },
      zhsds(na){
        //  alert("执行了"+na);
          this.serc="";
          this.serc=na;
          this.ski=false;
          this.yus=2;
          usvideo(na).then(res => {
                  this.liskerzs=res.data.data.ceshi;
                  //console.log(res.data.data.ceshi)
                 console.log("zzzz"+this.lisker)
                })
          usersss(na).then(rts=>{
             this.liskuser=rts.data.data.ceshi;
            console.log("llala"+this.lisker)
          })      

 const that = this
    that.timer = setInterval(function () {
        console.log(document.readyState)
        if (document.readyState === 'complete') {
            that.loading=false;
            window.clearInterval(that.timer)
        }
    }, 1000)


        //  this.serc=na;
      },
      check(id,nameall){
        this.serc="";
        let reg=new RegExp("<font color='red'>","g")//g代表全部
         let reg1=new RegExp("</font>","g")//g代表全部
        let na=nameall.replace(reg,'');
        let names=na.replace(reg1,'');
        this.zhsds(names);
        // this.serc=names
        // this.numses=names;
        // this.serc=names;
        //alert("..."+names)
        // alert("查询id"+id+"name"+this.$refs.oopsname.value);
        this.showss=true;
        this.showage=false;
        // //alert("kong")
        this.shows=false;
        this.showComment=false;
        // this.hotspot=false;
        // alert("search"+this.search)
      }
    },
    computed: {
        //过滤方法
        items: function() {
            if(this.yus==2){
               this.jiao=2;
            var _search = this.serc;
            //alert("输入"+_search)
            if (_search=="" || _search==null) {
               this.showage=false;
               this.hotspot=true;
                //alert("kong")
                this.shows=false;
                this.showss=false;
                this.showComment=true;
            }
            if(_search!=null && _search!=""){
              //  输入事件
               this.showage=false;
              //  this.hotspot=true;
              //  //alert("kong")
               this.shows=true;
              //  this.showss=false;
               this.showComment=true;
              //  this.showage=false;
              //  this.showComment=true;
              //  this.shows=true;
              inq(_search).then(res => {
                  this.lisker=res.data.data.ceshi;
                //  console.log(res.data.data.ceshi)
                 console.log("hhhh"+this.lisker)
                })
            if (_search) {
                //不区分大小写处理
                var reg = new RegExp(_search, 'ig')
                //es6 filter过滤匹配，有则返回当前，无则返回所有
                return this.list.filter(function(e) {
                    //匹配所有字段
                    return Object.keys(e).some(function(key) {
                        return e[key].match(reg);
                    })
                    //匹配某个字段
                    //return e.name.match(reg);
                })
            };
            return this.list;
        }else{
            this.showage=true;
        }
            }else{
            var _search = this.serc;
        
            if (_search=="" || _search==null) {
               this.showage=false;
               this.hotspot=true;
                //alert("kong")
                this.shows=false;
                this.showss=false;
                this.showComment=true;
            }
            if(_search!=null && _search!=""){
                // 输入事件
               this.showage=false;
               this.hotspot=true;
                //alert("kong")
                this.shows=false;
                this.showss=false;
                 this.showComment=true;
                inq(_search).then(res => {
                  this.lisker=res.data.data.ceshi;
                //  console.log(res.data.data.ceshi)
                 console.log("hhhh"+this.lisker)
                })
                this.showage=false;
                this.showComment=true;
                this.shows=true;
            if (_search) {
                //不区分大小写处理
                var reg = new RegExp(_search, 'ig')
                //es6 filter过滤匹配，有则返回当前，无则返回所有
                return this.list.filter(function(e) {
                    //匹配所有字段
                    return Object.keys(e).some(function(key) {
                        return e[key].match(reg);
                    })
                    //匹配某个字段
                    //return e.name.match(reg);
                })
            };
            return this.list;
        }else{
            this.showage=true;
        }

        }
        }
    },
    beforeCreate () {
    document.querySelector('body').setAttribute('style', 'background-color:#101821')
  }

}
</script>

<style scoped>

.gz{
    width: 27%;
    height: 42%;
    border: 1px solid rgb(242 52 52 / 96%);
    background:rgb(242 52 52 / 96%);
    text-align: center;
    line-height: 267%;
    font-size: 12px;
    position: relative;
    top: 6px;
    left: 21%;
        border-radius:8px;
}
.gzf{
    width: 27%;
    height: 42%;
    border: 1px solid rgb(143 142 142);
    background:rgb(143 142 142);
    text-align: center;
    line-height: 267%;
    font-size: 12px;
    position: relative;
    top: 6px;
    left: 21%;
    
    border-radius:8px;
}
.zpi{
    font-size: 16px;
    color: rgb(155, 149, 149);
    position: absolute;
    top: -47px;
    left: 3px;
    z-index: 900;
}
.zps{
    font-size: 13px;
    color:rgb(0, 0, 0);
    position: absolute;
    top: 29px;
    left: 42px;
    z-index: 9999;
}

 .info img{
    /* width:38%; */
    border-radius: 50%;
    margin-right: 20px;
  }
  .rd{
    display: block;
}

  .no-see{
    width:231%;

  }

   .msg-list{
    display: flex;
    padding:10px 0;
    /* justify-content: space-between; */
  }
  .msg-list img{
width: 56px;
    height: 57px;
    border-radius: 125%;
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
  }

    .top-msg{
    color: #666;
    align-items: center;
  }
    .info img{
    /* height:100px;
    width:100px;
    border-radius: 50%;
    margin-right: 20px; */
        width: 34%;
    border-radius: 50%;
    margin-right: 28px;
  }

/* 
.container {
  position:relative;
}  */
 /* .container video {
 position:relative; 
 z-index:0; 
}  */
.pitch {
  position:relative;
} 
 .pitch video {
 position:relative; 
 z-index:0; 
} 
 .overlay {
 position:absolute; 
 top:80%; 
 left:0; 
 z-index:1; 
} 
.zks{
    position: absolute;
    font-size: 18px;
    top: 51%;
    left: 48%;
    width: 70%;
}
.hsd{
    position: absolute;
    font-size: 18px;
    top: 51%;
    left: 152%;
        width: 70%;
}

.zwe div{
display:inline;
}
.zdis{

}
.zwe{
position:relative;
} 

.tab-img img{
  width:33.3%;
  height:150px;
}

.zds{
    color: #FFFFff;
    height: 55px;
    width: 319px;
    position: relative;
    left: -50px;
    top: 0px;
    padding-left: 35px;
    padding-top: 18px;
    font-size: 21px;
}
.hotspot{
  position: relative;
    left: 0px;
    top: -14px;
}

.zdsf{
    color: #FFFFff;
    height: 55px;
    width: 407px;
    position: relative;
    left: -128px;
    top: -23px;
    padding-left: 35px;
    padding-top: 18px;
    font-size: 21px;
}
.rd{
    display: block;
    height: 46%;
    width: 277px;
    margin-top: 1%;
    margin-left: 2%;
}

.ger{
    color: #FFFFff;
    position: relative;
    left: -17%;
    padding-top: 20%;
}

.get{
     color: #FFFFff;
    position: relative;
    font-size: 127%;
    /* width: 371px; */
    left: -26%;
}

 .el-row {
    margin-bottom: 28px;
  }
  .el-col {
    border-radius: 4px;
  }
  .bg-purple-dark {
    background: #99a9bf;
  }
  .bg-purple {
    background: #d3dce6;
  }
  .bg-purple-light {
    background: #e5e9f2;
  }
  .grid-content {
    border-radius: 4px;
    min-height: 36px;
  }
  .row-bg {
    padding: 10px 0;
    background-color: #f9fafc;
  }

.li{
    color: #FFFFff;
    height: 55px;
    border-bottom: 1px solid #ccc;
    width: 319px;
    position: relative;
    left: -58px;
    top: 9px;
    padding-left: 35px;
    padding-top: 18px;
}


.icon-sousuo{
    width: 319px;
    position: relative;
    left: -67px;
    top: 0px;
    padding-left: 35px
}


.search{
    margin: 0 auto;
    padding-top: 27px;
    height: 50px;
    width: 100%;
  }
  .ces{
    margin: 0 auto;
    width: 50%;
    position: relative;
  }
  .cancel{
    display: inline-block;
    font-size: 20px;
    color: red;
    position: absolute;
    background-color: transparent; background-repeat:no-repeat; border: none; cursor:pointer; overflow: hidden; 

  }

  .searchInput{
    display: inline-block;
    width: 85%;
    height: 38px;
    border: 1px solid #cccccc;
    float: left;
    box-sizing: border-box;
    -moz-box-sizing:border-box; /* Firefox */
    -webkit-box-sizing:border-box; /* Safari */
    border-bottom-left-radius: 5px;
    border-top-left-radius: 5px;
  }

  .el-input__inner {
    -webkit-appearance: none;
    background-color: #8b7f7f30;
    background-image: none;
    border-radius: 4px;
    border: 1px solid #dcdfe673;
    box-sizing: border-box;
    color: #606266;
    display: inline-block;
    font-size: inherit;
    height: 40px;
    line-height: 40px;
    outline: 0;
    padding: 0 15px;
    transition: border-color .2s cubic-bezier(.645,.045,.355,1);
    width: 100%;
}

.zds{
     
    display: block;

    margin-top: 4%;
    margin-left: 1%;
}


</style>