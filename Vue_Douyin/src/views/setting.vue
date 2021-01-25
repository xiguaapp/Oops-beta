<template>
  <div class="sign">
    <div class="sign-header">
      <router-link to="/me" class="icon" >x</router-link>
      <span>帮助</span>
    </div>
    <div class="sign-content">
      <div class="des">
        <h2>设置密码</h2>
      </div>
       </br>

      <div class="sign-box">
        <div class="sign-box">
        <div class="inp">
          <!-- <el-input type="password" style="width: 135%;"  v-model="ruleForm.pass" autocomplete="off"></el-input> -->
          <!-- <input v-model="username" @blur="ver" type="text" class="inp-controll" placeholder="密码" show-password> -->
         <el-input placeholder="密码" style="width: 152%;" @blur="lo" v-model="username" show-password></el-input>
        </div>
      </div>
      </div>
      <span  :class="[verify?'active2':'active3']" >6-16位，可包含字母（区分大小写）、数字、符号组成</span>
      </br>
      </br>
        <div class="sign-box">
        <div class="inp">
          <el-input @blur="affirm" placeholder="确认密码" style="width: 152%;" v-model="pass" show-password></el-input>
        </div>
      </div>
      <span class="active2" v-if="veri">两次密码不一致</span>
      <div class="not-sign">
        <p></p>
      </div>
      
      <div class="code-btn">
        <button  @click="register" :class="[btnBg?'act':'']" style="color:#9E9E9E; font-size:20px">完成</button>
      </div>
    </div>
  </div>
</template>

<script>
//引入api
import { register} from '@/api/login'

import { mapMutations } from 'vuex'

export default {

  // getParams(){
  //   // 取到路由带过来的参数
  //   this.$route.query.mallCode
  //   // alert("this.routerParams"+this.routerParams)
  //   // 将数据放在当前组件的数据内
  //   //alert("传进来的值"+this.$route.query.mallCode);
  //},
  watch: {
   '$route': 'getParams'
  },
  data(){
     var validatePass = (rule, value, callback) => {
        if (value === '') {
          callback(new Error('请输入密码'));
        } else {
          if (this.ruleForm.checkPass !== '') {
            this.$refs.ruleForm.validateField('checkPass');
          }
          callback();
        }
      };
    return{
      telErea:'',
      showMask:false,
      disabled:true,
      btnBg:false,
      verify:false,
      veri:false,
      //密码
      username:'',
      //确认密码
      pass:''
    }
  },
  methods:{
    ...mapMutations(['changeLogin']),
    affirm(){
      if(this.pass!=this.username){
         this.veri=true;
         this.btnBg=false;
      }else if(this.username==""){
         this.veri=true;
         this.btnBg=false;
      }else{
        this.veri=false;
        this.btnBg=true;
      }
    },

    lo(){
      if(this.username.length<6){
        this.verify=true
      }else{
         this.verify=false
      }
    },
      loginAction(e){
      this.phone = e.target.value;
      // 手机号码正则
      var regtel = /^1[345789]{1}\d{9}$/;
      if(this.phone==""){
        // console.log('手机号不可为空');
        this.$toast('手机号不可为空')
      }else if(!regtel.test(this.phone)){
        // console.log('请输入正确的手机号');
        this.$toast({
          message:'请输入正确的手机号',
          type:'error',
          duration:3000
        })
        }
        return
    },
    register(){
       //alert("手机"+this.$route.query.mallCode)
       let _this = this;
       if(this.username!=this.pass){
           this.$message.error('两次密码不一致');
       }else{
      register(this.$route.query.mallCode,this.username).then(res => {
            //localStorage.setItem('token',"这个是一个token"),
            console.log("返回值"+res.data.success)
            if(res.data.success==true){
                    _this.changeLogin({Authorization:res.data.data.token});
                   this.$message({
                    message: '注册成功',
                    type: 'success'
                    });
                    window.location=res.data.message
            }else{
                  this.$message.error('注册失败');
                   window.location=res.data.message
            }
      })
       }
    },
    //获取焦点事件判断密码是否合格
    ver(){
          if(this.username<6){
          this.verify=true;
       }
    },
    show(){
      this.showMask = true;
    },
    close(){
      this.showMask = false;
    },
    changeTel(e){
      this.phone = e.target.value;
      // 手机号码正则
      var regtel = /^1[345789]{1}\d{9}$/;
      if(regtel.test(this.phone)){
        this.btnBg = true;
        this.disabled = false;
      }else{
        this.btnBg = false;
        this.disabled = true;
      }
    }
  }
}
</script>

<style>

.msgs{display:inline-block;width:104px;color:#fff;font-size:12px;border:1px solid #0697DA;text-align:center;height:30px;line-height:30px;background:#0697DA;cursor:pointer;}


  .sign{
    padding:30px;

  }
  .sign-header{
    display: flex;
    justify-content: space-between;
    align-items: center;
    }
  .icon{
    font-size: 30px;
  }
  .sign-content{
    padding:40px 10px;
  }
  .des h2{
    font-size: 24px;
    font-weight: bold;
  }
  .des p{
    line-height:50px;
    color: #666;
  }
  .des p a{
    color:#628088;
    padding:0 5px;
  }
  .sign-box{
    display: flex;
    height:50px;
    align-items: center;
    background: #f9f9f9;
  }
  .sele-controll{
    background: #f9f9f9;
    height: 36px;
    font-weight: bold;
    margin-left:5px;
    border:none ;
  }
  .inp-controll{
    height:36px;
    background: #f9f9f9;
    border: none;
    width: 90%;
    margin-left: 10px;
  }
  /* 光标颜色 */
  input{
    caret-color: #fe2c55;
  }
  input::-webkit-input-placeholder{
    color:#cccccc;
  }
  .not-sign p{
    color: #cccccc;
    font-size: 14px;
    margin-top: 10px;
  }
  .code-btn button{
    margin: 20px 0;
    width:100%;
    padding:15px 0;
    border: none;
    color: #ffffff;
  }
  .act{
    color:#ffffff;
    background:#fe2c55;
  }

  .active2{
    color:#fe2c55;
    font-size: 14px;
  }
  .active3{
    color:rgb(179 162 162);
    font-size: 14px;
  }
 

  .other{
    display: flex;
    justify-content:space-between;
  }
  .other a{
    color:#628088;
  }

  .mask{
    width:100%;
    height:100%;
    position: fixed;
    top: 0;
    left:0;
    background: rgba(0, 0, 0, .4);
  }
  .oauth{
    height:48%;
    width:100%;
    position: absolute;
    bottom: 0;
    border-top-left-radius: 5px;
    border-top-right-radius: 5px;
    background: white;
    text-align: center;
  }
  .oauth-item{
    border-bottom: 1px solid #f5f5f5;
    line-height: 63px;
  }
/* 
  .zks{
      display: flex;
      top: 23%;
  } */


  .up-enter-active, .up-leave-active {
    transition: all .5s;
  }
  .up-enter, .up-leave-to /* .fade-leave-active below version 2.1.8 */ {
    opacity: 1;
    transform: translateY(100%);
  }
</style>