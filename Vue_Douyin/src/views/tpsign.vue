<template>
  <div class="sign">
    <div class="sign-header">
      <router-link to="/sign" tag="span" class="icon">←</router-link>
      <span>帮助</span>
    </div>
    <div class="sign-content">
      <div class="des">
        <h2>手机号密码登录</h2>
      </div>
      <div class="sign-box">
        <div class="sele">
          <select class="sele-controll" v-model="telErea">
            <option value="">+86</option>
          </select>
        </div>
        <div class="inp">
          <input @keyup="loginAction" v-model="phone"   type="text" class="inp-controll" placeholder="请输入手机号">
        </div>
      </div>
      <div class="sign-box">
        
        <div class="inp">
          <input v-model="password" type="password" class="inp-controll" placeholder="请输入密码">
        </div>
      </div>
      <div class="not-sign">
        <p>登录即表明同意<a href="#">抖音协议</a>和<a href="#">隐私政策</a></p>
      </div>
      <div class="code-btn">
        <button @click="register" style="color:#9E9E9E; font-size:20px" :disabled="disabled" :class="[btnBg?'active':'']">登录</button>
      </div>
      <div class="other">
        <span>忘记了？<a href="#">找回密码</a></span>
      </div>
    </div>
  </div>
</template>

<script>
//引入api
import { loginpass } from '@/api/login'

import { mapMutations } from 'vuex' 

export default {
  data(){
    return{
      telErea:'',
      phone:'',
      password:'',
      disabled:false,
      btnBg:false
    }
  },
  methods:{
         ...mapMutations(['changeLogin']),
    register(){
        //alert("手机号"+this.phone+"密码"+this.password)
        var regtel = /^1[345789]{1}\d{9}$/;
        if(this.phone=="" || !regtel.test(this.phone)){
           this.$message.error('手机号格式部正确');
        }else if(this.password==""){
           this.$message.error('请输入密码');
        }else{
        loginpass(this.phone,this.password).then(res => {
            //localStorage.setItem('token',"这个是一个token"),
            console.log("返回值"+res.data.success)
            if(res.data.success==true){
              this.changeLogin({Authorization:res.data.data.token})
                 this.$message({
                 message: '登录成功',
                 type: 'success'
                  });
            window.location="/me";
            }else{
                this.$message.error('账号或密码输入有误');
            }
        })
        }
      // var pa=new URLSearchParams();
      // pa.append('phone',this.phone)
      // pa.append('password',this.password)
      // axios.post("http://localhost:8002/consumer/loginpass",pa).then(function (resp){
      //           //Pthis.books=resp.data;
      //           alert("...."+resp.data)
      //            if(resp.data=='登录成功'){
      //               window.location="/me"; 
      //            }    
      //       })
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
    }
  }
}
</script>

<style>
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
  .des{
    margin-bottom: 30px;
  }
  .des h2{
    font-size: 24px;
    font-weight: bold;
    color: black;
  }
  .des p{
    line-height:50px;
    color: #666;
  }
  .des,.not-sign p a{
    color:#628088;
    padding:0 5px;
  }
  .sign-box{
    display: flex;
    height:50px;
    align-items: center;
    background: #f9f9f9;
    margin-top: 12px;
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
    color: #f9f9f9;
  }
  .active{
    color:#ffffff;
    background:#fe2c55;
  }
  .other{
    display: flex;
    justify-content:space-between;
  }
  .other a{
    color:#628088;
    
  }
</style>