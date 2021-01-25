<template>
  <div class="sign">
    <div class="sign-header">
      <router-link to="/index" class="icon" >x</router-link>
      <span>帮助</span>
    </div>
    <div class="sign-content">
      <div class="des">
        <h2>登录后可展示自己</h2>
        <p>登录即表明同意<a href="#">Oops协议</a>和<a href="#">隐私政策</a></p>
      </div>
      <div class="sign-box">
        <div class="sele">
          <select class="sele-controll" v-model="telErea">
            <option value="">+86</option>
          </select>
        </div>
        <div class="inp">
          <input @keyup="loginAction" v-model="phone" @input="changeTel" type="text" class="inp-controll" placeholder="请输入手机号">
        </div>
      
      </div>
      </br>
            <div class="sign-box">
        <div class="inp">
          <input v-model="phonez" type="text" class="inp-controll" placeholder="验证码">
        </div>
         <div class="sele">
         <span class="msgs">获取短信验证码</span>
         </div>
      
      </div>
              
      <div class="not-sign">
        <p>未注册手机号验证后将自动登录</p>
      </div>
      <div class="code-btn">
        <button  @click="register" :class="[btnBg?'act':'']" style="color:#9E9E9E; font-size:20px">登录</button>
      </div>
      <div class="other">
        <router-link tag="a" to="/tpsign">密码登录</router-link>
        <span @click="show">其他方式登录</span>
      </div>
    </div>

    <transition name="up">
    <div class="mask" v-if="showMask">
      <div class="oauth">
        <ul>
          <li class="oauth-item">今日头条登录</li>
          <li class="oauth-item">QQ登录</li>
          <li class="oauth-item">微信登录</li>
          <li class="oauth-item">微博登录</li>
          <li @click="close" class="oauth-item">取消</li>
        </ul>
      </div>
    </div>
    </transition>
  </div>
</template>

<script>

import $ from 'jquery'

//引入api
import { doLogin} from '@/api/login'

import { mapMutations } from 'vuex' 


$(function  () {
  //获取短信验证码
	var validCode=true;
	$(".msgs").click (function  () {
      var phone=$('.inp-controll').val();
      var regtel = /^1[345789]{1}\d{9}$/;
      if(phone==""){
        // console.log('手机号不可为空');
        alert('手机号不可为空')
      }else if(!regtel.test(phone)){
        // console.log('请输入正确的手机号');
        alert('请输入正确的手机号')
      }else{
        //发送短信验证码  
      $.post("http://localhost:8801/user/filter/transmit?phone="+phone);
		var time=60;
		var code=$(this);
		if (validCode) {
			validCode=false;
			code.addClass("msgs1");
		var t=setInterval(function  () {
			time--;
			code.html(time+"秒");
			if (time==0) {
				clearInterval(t);
			code.html("重新获取");
				validCode=true;
			code.removeClass("msgs1");
			}
		},1000)
    }
      }
	})
})

export default {
  data(){
    return{
      telErea:'',
      showMask:false,
      disabled:true,
      btnBg:false,
      //手机号
      phone:'',
      //验证码
      phonez:''
    }
  },
  methods:{
     
     ...mapMutations(['changeLogin']),
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
        console.log("手机号"+this.phone+"验证码"+this.phonez)
         doLogin(this.phone,this.phonez).then(res => {
            //localStorage.setItem('token',"这个是一个token"),
            console.log("返回值"+res.data.data.token)
            this.changeLogin({Authorization:res.data.data.token})
                  if(res.data.data.code==200){
                      // _this.changeLogin({Authorization:res.data.data.token});
                      window.location="/me";
                  }else if(res.data.data.code==201){
                  this.$router.push({
                   path: '/setting',
                   query: {
                   mallCode: this.phone
                   }
                   })
                  }else if(res.data.data.code==400){
                    //登录失败
                    this.$message.error('登录失败');
                  }else if (res.data.data.code==401) {
                    this.$message.error('验证码不匹配');
                  }
          })
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