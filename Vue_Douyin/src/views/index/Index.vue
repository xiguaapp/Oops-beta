<template>
  <div class="indexwarp">
    <!-- 首页 -->
    <!-- <span class="iconfont icon-sousuo"></span> -->
    <top-bar @changeUrl="zdfs" ></top-bar>
    <component :is="comName" />

  </div>
</template>

<script>
import TopBar from '../../components/index/TopBar'
import attentionList  from '../../components/index/attentionList.vue'
import videoList  from '../../components/index/VideoList.vue'

export default { 
  name:'Index',
  data(){
    return{
       weight:1,
       comName:'videoList'
    }
  },
  components:{
    TopBar,
    attentionList,
    videoList
  },
    methods:{
    zdfs(index){
      this.weight=index;
      if(index==0){
        this.comName='attentionList';
      }else{
        this.comName='videoList';
      }
    } 
    }
}
</script>

<style>
  .indexwarp{
    height:100%;
    background: #000;
  }
</style>