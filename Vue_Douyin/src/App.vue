<template>
  <div id="app">
    <router-view/>
  </div>
</template>


<script>
export default { 
  name:'Index',
  data(){
    return{
       weight:1,
       comName:'videoList',
       _isMobile:''
    }
  },
  // mounted() {
  //   if (this._isMobile()) {
  //     // 跳转至手机端路由
  //     // alert("手机端");
  //     this.$router.replace("/me");
  //   } else {
  //     // 跳转至 pc 端路由
  //     // alert("pc端");
  //     this.$router.replace("/pc_index");
  //   }
  // },
  methods: {
   _isMobile() {
      let flag = navigator.userAgent.match(
        /(phone|pad|pod|iPhone|iPod|ios|iPad|Android|Mobile|BlackBerry|IEMobile|MQQBrowser|JUC|Fennec|wOSBrowser|BrowserNG|WebOS|Symbian|Windows Phone)/i
      );
      return flag;
    }
  },
}
</script>

<style>
#app{
  height:100%;
}
</style>