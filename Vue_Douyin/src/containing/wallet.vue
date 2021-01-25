<template>
    <div class="top-bar" >
<el-drawer
  :size="size"
  :visible.sync="drawer"
  :direction="direction"
  :before-close="handleClose">
  <div class="zop">
    <p class="tite" >支付</p>
    <p class="sdf">￥{{cur}}</p>
    <p class="sdt">{{price}} 币</p>      
    <div class="sfg">     
             <ur>
                <li class="rd">    
                    <div class="msg-list-box">
                            <div class="msg-list">
                            <img src="">
                            <span>微信支付</span>
                            </div>
                    </div>
                </li>

                <li class="rd">    
                    <div class="msg-list-box">
                            <div class="msg-list">
                            <img src="">
                            <span>支付宝支付</span>
                            
                             </div>
                    </div>
                </li>
            </ur>
    </div>
    <p><el-button type="info" class="ann">支付</el-button></p>
  </span>
  </div>
</el-drawer>

                <P class="return" >
                <span class="r" @click="close"><</span>
                <span class="b">钱包</span>
                <span class="w">账单</span>
                </p>
              
                <transition-group name="test">
              
                  <div class="zwe" v-if="showzs" :key="1" >
                  <p v-if="showzs"  v-for="item in list" @click="sum(item.currency,item.money.toFixed(2))">
                  <span style="color: #fff;">{{item.currency}}</span></br>
                  <span style="font-size:10px">{{item.money.toFixed(2)}}元</span>
                  </p>
                  </div>
                </transition-group>
                <div class="resource">
                      <div class="zsd ogin-containe" >
                         <span class="zd">
                           <!-- 我的Oops币 <button  @click="Show">首充</button></br> -->
                            我的Oops币 <button > <a href="/Recharge">首充</a></button></br>
                          <span class="zz">{{currency}}</span>
                         </span>
                          <el-divider direction="vertical"></el-divider>
                         <span class="z">
                           零钱提现 <button :plain="true" @click="open2">提现</button></br>
                         
                          <span class="zl">{{change.toFixed(2)}}</span>
                         </span>
                      </div>
                </div>


              <div v-if="income" class="zop">
                <div >
                   <span class="come">我的收入</span>
                   <span class="total">总计: {{parseInt(redbao+creation).toFixed(2)}}元</span>
                </div>

                <div class="show">
                       <p class="zks">
                       <span class="">创作收入</span></br>
                       <span class="">￥{{creation.toFixed(2)}}</span>
                        </p>
                       <p class="deposit"><el-button type="danger" style="background-color: #f78989;color: #ffff;"  :plain="true" @click="open2">提现</el-button></p>
                      
                       <el-divider></el-divider>
                       <p class="zks">
                       <span class="">红包收入</span></br>
                       <span class="">￥{{redbao.toFixed(2)}}</span>
                       
                       </p>
                        <p class="deposit"><el-button style="background-color: #f78989;color: #ffff;" :plain="true" @click="open2" type="danger">提现</el-button></p>
                </div>
              </div>        
    </div>
</template>

<script>
export default {
       data(){
          return{
            drawer: false,
            direction: 'btt',
            //Oops 币
            currency:0.00,
            //零钱
            change:0.00,
            //创作收入
            creation:0.00,
            //红包收入
            redbao:0.00,
            size: '57%',
            income:true,
            Pay:false,
            showzs:false,
            zdsss:false,
            radio: '1',
            //价格
            price:0,
            //O币
            cur:0,
            list:[
              {
                id:1,
                currency:10,
                money:1.00
              },
              {
                id:2,
                currency:300,
                money:30.00
              },
              {
                id:3,
                currency:980,
                money:98.00
              },
              {
                id:4,
                currency:2980,
                money:298.00
              },
              {
                id:5,
                currency:5180,
                money:518.00
              },
              {
                id:6,
                currency:15980,
                money:1598.00
              }      
            ]
          }
       },
       methods:{
        cancel(){
        window.history.go(-1); 
      },
      close(){
        window.history.go(-1); 
       document.querySelector('body').setAttribute('style', 'background-color:#FFFFFF')
      },
        handleClose(done) {
       
          
            done();
        
         
      },
      sum(currency,money){
        this.drawer=true
        this.price=currency;
        this.cur=money;
      },
       Show(){
     
        this.showzs=true;
        this.zdsss=true;
          document.querySelector('.zwe').setAttribute('style','position: absolute;'+
            'left: 6%;'+
            'top: 318%;'+
            'width: 88%;'+
            'height: 343%;'+
            'filter:alpha(opacity=50);'+  
            'opacity:0.5;'+
            'background-color:#31383185;'
            )
       
       document.querySelector('.show').setAttribute('style','position: absolute;'+
      'left: 6%;'+
      'top: 743%;'+
     'width: 88%;'+
     'filter: alpha(opacity=50);'+
    'opacity: 0.5;'+
    'background-color: #31383185;')

     document.querySelector('.come').setAttribute('style','position: absolute;'+
      'left: 6%;'+
      'top: 682%')

      document.querySelector('.total').setAttribute('style','position: absolute;'+
      ' left: 67%;'+
      'top: 682%')
       document.querySelector('.zsd').setAttribute('style','position: absolute;'+
      'left: 6%;'+
      'top: 131%;'+
      'color: #fff;'+
      'font-size: 13px;'+
      'width: 88%;'+
      'height: 201%;'+
      'background-image: url("/img/bq.a86aedb1.jpg"); background-repeat: no-repeat; background-size: 100% 100%;')
      },
      pycli(){
          this.income=false,
          this.Pay=true
      },
       open2(){
        this.income=true,
        this.Pay=false
        if(this.change<10&&this.creation<10&&this.redbao<10){
        this.$message.error('提现失败,低于10元不能提现');
        }
       }
       },
    beforeCreate () {
        document.querySelector('body').setAttribute('style', 'background-color:#101821')
    }  
}
</script>

<style scoped>

.sdf{
  font-size: 28px;
  color: #000000;
  position: absolute; 
  left: 34%;
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