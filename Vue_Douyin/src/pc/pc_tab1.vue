<template>
   <div>
       <p data-v-6fe1bef7="" class="home-header-title">关注</p>
               <div data-v-6fe1bef7="" class="brilliant-video"> 
								<div data-v-76a466a3="" data-v-6fe1bef7="" class="video-card video-item vertical" show-description="">
									<div data-v-76a466a3="" v-for="item in dataList" class="video-card-main">
										<a data-v-76a466a3="" href="/short-video/3xebzdqqtjjir2q?authorId=3xi2zbf8nj8hpyc&amp;streamSource=find"
										 class="" target="">
											 <div data-v-76a466a3="" class="poster" > 
												 <!-- 视频 -->
												                          <video   width="100%;">
                                                                            <source :src="item.videoUrl" type="video/mp4">
                                                                          </video>
											</div> 
										</a>
										<p data-v-76a466a3="" class="info"><a data-v-76a466a3="" href="/profile/3xi2zbf8nj8hpyc" target="_blank"
											 class="info-avatar">
												<div data-v-0a40485d="" data-v-76a466a3="" class="avatar video-avatar">
													<img data-v-0a40485d="" :src="item.head"
													 class="avatar-img">
													<!--头像-->
												</div>
												<!---->
											</a><span data-v-76a466a3="" class="info-like">{{item.videoCount}}</span></p>
									</div>
									<!---->
								</div>
								
							</div>
   </div>
</template>

<script>
//引入api
import {attentionlist} from '@/api/video.js';

export default {
  data(){
    return{
      currentIndex:'',
      money:'',
      R:'',
      id:'',
      dialogTableVisible :false,
	  list:[],
	  dataList:{}
    }
  },
  created(){
	   //查询关注的视频
	            // alert("12321")
	            attentionlist().then(res => {
				 console.log("res.data.data"+res.data.data.v);
				 console.log(res.data.data.v)
				 this.dataList=res.data.data.v;
				  console.log( this.dataList)
					})
       
}
}

</script>
