<template>
	<div id="app">
		<div @func="test">
			<div>
				<div class="header-placeholder" data-v-435f8597="">
					<header class="header" data-v-435f8597="">
						<div class="header-left" data-v-435f8597=""><a href="/" class="router-link-exact-active router-link-active"
							 data-v-435f8597="" aria-current="page">
								<h1 class="logo" data-v-435f8597="">Roops</h1>
							</a>
							<!---->
						</div>
						<div class="search" data-v-7bc9b185="" data-v-435f8597=""><input placeholder="请输入你要搜索的内容" type="text" value=""
							 class="search-input" data-v-7bc9b185=""><button type="button" class="search-button" data-v-7bc9b185=""><span
								 class="search-icon" data-v-7bc9b185=""></span> 搜索 </button></div>
						<div class="header-right" data-v-435f8597="">
							<ul class="navitation" data-v-8bff2fc0="" data-v-435f8597="">
								<li class="navitation-item navitation-item-user set-home" data-v-8bff2fc0=""><span data-v-8bff2fc0="">设为主页</span></li>
								<li class="navitation-item" data-v-8bff2fc0="">
									<div class="sub-list" data-v-f4c04048="" data-v-8bff2fc0="">
										<div class="sub-list-placeholder" data-v-f4c04048=""> 下载APP </div>
										<div class="sub-list-content" style="display:none;" data-v-f4c04048="">
											<div class="download-app" data-v-f4c04048="" data-v-8bff2fc0=""><img :src="userlist.head"
												 class="download-app-qr" data-v-f4c04048="" data-v-8bff2fc0="">
												<p class="download-app-desc" data-v-f4c04048="" data-v-8bff2fc0="">扫码下载 快手APP</p>
											</div>
										</div>
									</div>
								</li>
								<li class="navitation-item" data-v-8bff2fc0=""><a href="https://pay.ssl.kuaishou.com/pay" target="_blank" class="nav-link"
									 data-v-4dc5b8ec="" data-v-8bff2fc0="">R币充值</a></li>
								<li class="navitation-item" data-v-8bff2fc0="">
									<div class="sub-list" data-v-f4c04048="" data-v-8bff2fc0="">
										<div class="sub-list-placeholder arrow" data-v-f4c04048=""><span class="nav-link" data-v-4dc5b8ec=""
											 data-v-8bff2fc0="" data-v-f4c04048="">直播</span></div>
										<div class="sub-list-content" style="display:none;" data-v-f4c04048="">
											<ul class="navitation-sub-list" data-v-f4c04048="" data-v-8bff2fc0="">
												<li class="navitation-sub-list-item" data-v-f4c04048="" data-v-8bff2fc0=""><a href="https://live.kuaishou.com/"
													 target="_blank" class="nav-link" data-v-4dc5b8ec="" data-v-8bff2fc0="" data-v-f4c04048="">快手直播</a></li>
												<li class="navitation-sub-list-item" data-v-f4c04048="" data-v-8bff2fc0=""><a href="https://live.kuaishou.com/live-partner"
													 target="_blank" class="nav-link" data-v-4dc5b8ec="" data-v-8bff2fc0="" data-v-f4c04048="">直播伴侣</a></li>
												<li class="navitation-sub-list-item" data-v-f4c04048="" data-v-8bff2fc0=""><a href="https://liveopen.kuaishou.com/?from=kuaishou_www"
													 target="_blank" class="nav-link" data-v-4dc5b8ec="" data-v-8bff2fc0="" data-v-f4c04048="">直播开放平台</a></li>
											</ul>
										</div>
									</div>
								</li>
								<li class="navitation-item" data-v-8bff2fc0="">
									<div class="sub-list" data-v-f4c04048="" data-v-8bff2fc0="">
										<div class="sub-list-placeholder arrow" data-v-f4c04048=""><span class="nav-link" data-v-4dc5b8ec=""
											 data-v-8bff2fc0="" data-v-f4c04048="">退出登录</span></div>
										<div class="sub-list-content" style="display:none;" data-v-f4c04048="">
											<ul class="navitation-sub-list" data-v-f4c04048="" data-v-8bff2fc0="">
												<li class="navitation-sub-list-item" data-v-f4c04048="" data-v-8bff2fc0=""><a href="https://www.kuaishou.com/verify/"
													 target="_blank" class="nav-link" data-v-4dc5b8ec="" data-v-8bff2fc0="" data-v-f4c04048="">用户认证</a></li>
												<li class="navitation-sub-list-item" data-v-f4c04048="" data-v-8bff2fc0=""><a href="https://cp.kuaishou.com/article/publish/video?origin=www.kuaishou.com"
													 target="_blank" class="nav-link" data-v-4dc5b8ec="" data-v-8bff2fc0="" data-v-f4c04048="">上传视频</a></li>
												<li class="navitation-sub-list-item" data-v-f4c04048="" data-v-8bff2fc0=""><a href="https://cp.kuaishou.com/"
													 target="_blank" class="nav-link" data-v-4dc5b8ec="" data-v-8bff2fc0="" data-v-f4c04048="">创作者服务平台</a></li>
												<li class="navitation-sub-list-item" data-v-f4c04048="" data-v-8bff2fc0=""><a href="https://jigou.kuaishou.com/?from=www"
													 target="_blank" class="nav-link" data-v-4dc5b8ec="" data-v-8bff2fc0="" data-v-f4c04048="">机构服务平台</a></li>
												<li class="navitation-sub-list-item" data-v-f4c04048="" data-v-8bff2fc0=""><a href="https://music.kuaishou.com/#/"
													 target="_blank" class="nav-link" data-v-4dc5b8ec="" data-v-8bff2fc0="" data-v-f4c04048="">加入音乐人</a></li>
												<li class="navitation-sub-list-item" data-v-f4c04048="" data-v-8bff2fc0=""><a href="https://mcn.kuaishou.com/"
													 target="_blank" class="nav-link" data-v-4dc5b8ec="" data-v-8bff2fc0="" data-v-f4c04048="">机构入驻</a></li>
											</ul>
										</div>
									</div>
								</li>
								<li class="navitation-item navitation-item-user" data-v-8bff2fc0="">
									<div class="current-user" data-v-fccad332="" data-v-8bff2fc0="">
										<div data-v-f4c04048="" data-v-fccad332="" class="sub-list">
											<div data-v-f4c04048="" class="sub-list-placeholder">
												<div data-v-0a40485d="" data-v-fccad332="" class="avatar current-user-avatar" data-v-f4c04048=""><img
													 data-v-0a40485d="" :src="userlist.head"
													 class="avatar-img">
													<!---->
												</div>
											</div>
											<div data-v-f4c04048="" class="sub-list-content" style="display: none;">
												<ul data-v-fccad332="" data-v-f4c04048="" class="current-user-sub-list">
													<li data-v-fccad332="" data-v-f4c04048="" class="current-user-sub-list-item"><a data-v-fccad332=""
														 data-v-f4c04048="" href="https://cp.kuaishou.com/" target="_blank">创作者中心</a></li>
													<li data-v-fccad332="" data-v-f4c04048="" class="current-user-sub-list-item"><a data-v-fccad332="" href="/profile/3xr8m2f8eds5k44"
														 class="" data-v-f4c04048="">个人主页</a></li>
													<li data-v-fccad332="" data-v-f4c04048="" class="current-user-sub-list-item logout"> 退出登录 </li>
												</ul>
											</div>
										</div>
									</div>
								</li>
							</ul>
						</div>
					</header>
				</div>
				<!---->
			</div>
			<section class="main">
				<div class="sidebar" data-v-b849c210="">
					<div class="tabs" data-v-b849c210="">
						<div class="home" :id="active1=='pc_tab'?'active1':''"  data-v-b849c210=""  @click="toggleTabs('pc_tab')"><i  class="home-icon" data-v-b849c210=""></i>首页 </div>
						<div class="featured" :id="active1=='pc_tab1'?'active1':''" data-v-b849c210="" @click="toggleTabs('pc_tab1')"><i  class="featured-icon" data-v-b849c210=""></i>关注 </div>
                        <div class="featured" :id="active1=='pc_tab2'?'active1':''" data-v-b849c210="" @click="toggleTabs('pc_tab2')"><i  class="featured-icon" data-v-b849c210=""></i>上传视频 </div>
                        <div class="featured" :id="active1=='pc_tab3'?'active1':''" data-v-b849c210="" @click="toggleTabs('pc_tab3')"><i  class="featured-icon" data-v-b849c210=""></i>R币充值 </div>
                         <div class="featured" :id="active1=='pc_tab4'?'active1':''" data-v-b849c210="" @click="toggleTabs('pc_tab4')"><i  class="featured-icon" data-v-b849c210=""></i>内容管理 </div>
						<div class="reco" data-v-b849c210="">
							<!-- <p class="reco-title" data-v-b849c210="">推荐栏目</p>
							<ul data-v-b849c210="">
								<li class="reco-item" data-v-b849c210=""><i class="reco-icon hover" style="background-image:url(//s2-10623.kwimgs.com/kos/nlav10623/vision_images/tabbar_icon_anime_black.fd2edf9afe3284a5.svg);"
									 data-v-b849c210=""></i><i class="reco-icon normal" style="background-image:url(//s2-10623.kwimgs.com/kos/nlav10623/vision_images/tabbar_icon_anime_black.fd2edf9afe3284a5.svg);"
									 data-v-b849c210=""></i> 影视 </li>
								<li class="reco-item" data-v-b849c210=""><i class="reco-icon hover" style="background-image:url(//s2-10623.kwimgs.com/kos/nlav10623/vision_images/tabbar_icon_anime_black.fd2edf9afe3284a5.svg);"
									 data-v-b849c210=""></i><i class="reco-icon normal" style="background-image:url(//s2-10623.kwimgs.com/kos/nlav10623/vision_images/tabbar_icon_anime_black.fd2edf9afe3284a5.svg);"
									 data-v-b849c210=""></i> 动漫 </li>
								<li class="reco-item" data-v-b849c210=""><i class="reco-icon hover" style="background-image:url(//s2-10623.kwimgs.com/kos/nlav10623/vision_images/tabbar_icon_food_orange.166b85300946e459.svg);"
									 data-v-b849c210=""></i><i class="reco-icon normal" style="background-image:url(//s2-10623.kwimgs.com/kos/nlav10623/vision_images/tabbar_icon_food_black.a86b9ca0cd926f0b.svg);"
									 data-v-b849c210=""></i> 美食 </li>
								<li class="reco-item" data-v-b849c210=""><i class="reco-icon hover" style="background-image:url(//s2-10623.kwimgs.com/kos/nlav10623/vision_images/tabbar_icon_game_orange.c5f13fbbbb82ab52.svg);"
									 data-v-b849c210=""></i><i class="reco-icon normal" style="background-image:url(//s2-10623.kwimgs.com/kos/nlav10623/vision_images/tabbar_icon_game_orange.c5f13fbbbb82ab52.svg);"
									 data-v-b849c210=""></i> 游戏 </li>
								<li class="reco-item" data-v-b849c210=""><i class="reco-icon hover" style="background-image:url(//s2-10623.kwimgs.com/kos/nlav10623/vision_images/tabbar_icon_music_orange.72006df4aafda51a.svg);"
									 data-v-b849c210=""></i><i class="reco-icon normal" style="background-image:url(//s2-10623.kwimgs.com/kos/nlav10623/vision_images/tabbar_icon_music_black.0771d518e5daa496.svg);"
									 data-v-b849c210=""></i> 音乐 </li>
							</ul> -->
							<!---->
						</div>
						<div class="brilliant" data-v-b849c210=""><i class="video-icon" data-v-b849c210=""></i>精彩短视频 </div>
						<!-- <div class="profile" data-v-b849c210=""><i class="me-icon" data-v-b849c210=""></i>我的主页 </div> -->
					</div>
					<div class="links" data-v-b849c210="">
						<ul data-v-b849c210="">
							<!-- <li class="links-item" data-v-b849c210=""><a href="https://www.kuaishou.com/about/" target="_blank" class="links-item-href"
								 data-v-b849c210="">关于Oops</a></li> -->
							<li class="links-item" data-v-b849c210=""><a href="https://www.kuaishou.com/help/feedback" target="_blank" class="links-item-href"
								 data-v-b849c210="">帮助中心</a></li>
							<li class="links-item" data-v-b849c210=""><a href="https://zhaopin.kuaishou.com/" target="_blank" class="links-item-href"
								 data-v-b849c210="">加入我们</a></li>
							<li class="links-item" data-v-b849c210=""><a href="https://www.kuaishou.com/about/contact" target="_blank" class="links-item-href"
								 data-v-b849c210="">联系我们</a></li>
							<!-- <li class="links-item" data-v-b849c210=""><a href="https://www.kwaishop.com/" target="_blank" class="links-item-href"
								 data-v-b849c210="">快手电商</a></li> -->
							<li class="links-item" data-v-b849c210=""><a href="https://e.kuaishou.com/#/e/home" target="_blank" class="links-item-href"
								 data-v-b849c210="">商务合作</a></li>
							<li class="links-item" data-v-b849c210=""><a href="https://www.kuaishou.com/help/report" target="_blank" class="links-item-href"
								 data-v-b849c210="">违规举报</a></li>
							<li class="links-item" data-v-b849c210=""><a href="https://www.kuaishou.com/about/policy" target="_blank" class="links-item-href"
								 data-v-b849c210="">法律声明</a></li>
							<!-- <li class="links-item" data-v-b849c210=""><a href="https://www.kuaishou.com/csr/" target="_blank" class="links-item-href"
								 data-v-b849c210="">Os 行动 </a></li> -->
							<li class="links-item" data-v-b849c210=""><a href="https://www.kuaishou.com/committee/" target="_blank" class="links-item-href"
								 data-v-b849c210="">专家委员会</a></li>
						</ul>
					</div>
				</div>
               
				<div class="main-content"> 
					<div data-v-6fe1bef7="" class="home" style="overflow: overlay;">
						<div data-v-6fe1bef7="" style="min-height: 100%;">
							<header data-v-6fe1bef7="" class="home-header">
                              
							</header>
                             <div class="tabs">
                              <first :is="currentView" keep-alive></first>   
                            </div>
						</div>
						<footer data-v-23ae028c="" class="footer" data-v-6fe1bef7=""><span data-v-23ae028c="">www.kuaishou.com 2021 @ All
								 rights Reserved 京ICP备07035647号-4 </span><a data-v-23ae028c="" target="_blank" href="https://zzlz.gsxt.gov.cn/businessCheck/verifKey.do?showType=p&amp;serial=11000020190617100242000003563691-SAIC_SHOW_10002020190621144025721&amp;signData=MEQCIP0/+UH+ntaa/CsUaIa29DiFE/5haWZtEr21SBp7ZH3FAiAaZbzsn7SkDMMICyfCAsZly9BxiPl94sRConkJ4tEgzw=="><span
								 data-v-23ae028c="" class="license"></span></a><a data-v-23ae028c="" target="_blank" href="http://www.beian.gov.cn/portal/registerSystemInfo?recordcode=11010802020421"
							     class="police-link"><span data-v-23ae028c="" class="police"></span>京公网安备 11010802020421号 </a><span
							     data-v-23ae028c=""> 京网文（2017）2551-280号</span></footer>
					</div>
				</div>
			</section>
			<div data-v-2346bd69="" data-v-36dca710="">
			</div>
		</div>
	</div>
</template>
<script>
import pc_tab1 from './pc_tab1';
import pc_tab from './pc_tab.vue';
import pc_tab2 from './pc_tab2.vue';
import pc_tab3 from './pc_tab3.vue';
import pc_tab4 from './pc_tab4.vue';
import {mapGetters,mapActions} from 'vuex';
export default {
data(){
return{
       pc_tab: "pc_tab",   //导航栏文本1
       pc_tab1: "pc_tab1", //导航栏文本2
       pc_tab2: "pc_tab2", //上传视频
       pc_tab3: "pc_tab3", //上传视频
       pc_tab4: "pc_tab4",
       currentView: 'pc_tab', //默认选中first子组件
       active1:'pc_tab',
       userlist:{},
       head:''
}
},
 created(){
                  var userJsonStr = sessionStorage.getItem('user');
                  this.userlist = JSON.parse(userJsonStr);
                  console.log("图片"+this.userlist.head)
                  this.head=this.userlist.head;
                  console.log("图片"+this.head)
 },
 computed:{
	        ...mapGetters(['isActive'])
        },
        watch:{
            isActive(val){
                console.log('aa');
                if(val){
                    this.active1='pc_tab4';
                    this.currentView='pc_tab4'
                }
            },
            currentView(val){
                if(val!='pc_tab4'){
                    this.setIsActive(false);
                }
            }
        },
components:{
    pc_tab,
    pc_tab1,
    pc_tab2,
    pc_tab3,
    pc_tab4,
},
            // created(){
            //      this.currentView = 'pc_tab4';
            //      this.active1='pc_tab4';
            // }
            //接收子组件的值

         methods: {
              ...mapActions(['setIsActive']),
             toggleTabs (tabText) {
                 this.active1=tabText;
                //  alert("TA"+tabText)
                 this.currentView = tabText;
             },
               test() {
                console.log("父组件中的方法---")
              }
         }
}
</script>

<style>
.ps {
    touch-action: auto;
    overflow: hidden!important;
    -ms-overflow-style: none
}

@supports (-ms-overflow-style: none) {
    .ps {
        overflow:auto!important
    }
}

@media (-ms-high-contrast:none),screen and (-ms-high-contrast:active) {
    .ps {
        overflow: auto!important
    }
}

.ps.ps--active-x>.ps__scrollbar-x-rail,.ps.ps--active-y>.ps__scrollbar-y-rail {
    display: block;
    background-color: transparent
}

.ps.ps--in-scrolling.ps--x>.ps__scrollbar-x-rail {
    background-color: #eee;
    opacity: .9
}

.ps.ps--in-scrolling.ps--x>.ps__scrollbar-x-rail>.ps__scrollbar-x {
    background-color: #999;
    height: 11px
}

.ps.ps--in-scrolling.ps--y>.ps__scrollbar-y-rail {
    background-color: #eee;
    opacity: .9
}

.ps.ps--in-scrolling.ps--y>.ps__scrollbar-y-rail>.ps__scrollbar-y {
    background-color: #999;
    width: 11px
}

.ps>.ps__scrollbar-x-rail {
    display: none;
    position: absolute;
    opacity: 0;
    transition: background-color .2s linear,opacity .2s linear;
    bottom: 0;
    height: 15px
}

.ps>.ps__scrollbar-x-rail>.ps__scrollbar-x {
    position: absolute;
    background-color: #aaa;
    border-radius: 6px;
    transition: background-color .2s linear,height .2s linear,width .2s ease-in-out,border-radius .2s ease-in-out;
    bottom: 2px;
    height: 6px
}

.ps>.ps__scrollbar-x-rail:active>.ps__scrollbar-x,.ps>.ps__scrollbar-x-rail:hover>.ps__scrollbar-x {
    height: 11px
}

.ps>.ps__scrollbar-y-rail {
    display: none;
    position: absolute;
    opacity: 0;
    transition: background-color .2s linear,opacity .2s linear;
    right: 0;
    width: 15px
}

.ps>.ps__scrollbar-y-rail>.ps__scrollbar-y {
    position: absolute;
    background-color: #aaa;
    border-radius: 6px;
    transition: background-color .2s linear,height .2s linear,width .2s ease-in-out,border-radius .2s ease-in-out;
    right: 2px;
    width: 6px
}

.ps>.ps__scrollbar-y-rail:active>.ps__scrollbar-y,.ps>.ps__scrollbar-y-rail:hover>.ps__scrollbar-y {
    width: 11px
}

.ps:hover.ps--in-scrolling.ps--x>.ps__scrollbar-x-rail {
    background-color: #eee;
    opacity: .9
}

.ps:hover.ps--in-scrolling.ps--x>.ps__scrollbar-x-rail>.ps__scrollbar-x {
    background-color: #999;
    height: 11px
}

.ps:hover.ps--in-scrolling.ps--y>.ps__scrollbar-y-rail {
    background-color: #eee;
    opacity: .9
}

.ps:hover.ps--in-scrolling.ps--y>.ps__scrollbar-y-rail>.ps__scrollbar-y {
    background-color: #999;
    width: 11px
}

.ps:hover>.ps__scrollbar-x-rail,.ps:hover>.ps__scrollbar-y-rail {
    opacity: .6
}

.ps:hover>.ps__scrollbar-x-rail:hover {
    background-color: #eee;
    opacity: .9
}

.ps:hover>.ps__scrollbar-x-rail:hover>.ps__scrollbar-x {
    background-color: #999
}

.ps:hover>.ps__scrollbar-y-rail:hover {
    background-color: #eee;
    opacity: .9
}

.ps:hover>.ps__scrollbar-y-rail:hover>.ps__scrollbar-y {
    background-color: #999
}

.sub-list-placeholder[data-v-f4c04048],.sub-list[data-v-f4c04048] {
    display: flex;
    width: 100%;
    height: 72px;
    justify-content: center;
    align-items: center
}

.sub-list-placeholder.arrow[data-v-f4c04048]:after {
    content: "";
    display: block;
    width: 20px;
    height: 20px;
    /* background: url(../img/arrow.e028e6a2.svg) no-repeat 50% */
}

.sub-list-placeholder.arrow.rotate[data-v-f4c04048]:after {
    transform: rotate(180deg)
}

.sub-list-content[data-v-f4c04048] {
    position: absolute;
    top: calc(100% + 2px);
    left: 50%;
    transform: translate(-50%);
    background: #fff;
    border-radius: 4px
}

.avatar[data-v-0a40485d] {
    width: 68px;
    height: 68px;
    position: relative
}

.avatar-img[data-v-0a40485d] {
    border-radius: 50%;
    width: 100%;
    height: 100%;
    border: 0;
    background-repeat: no-repeat;
    background-size: cover
}

.avatar-v {
    width: 24px;
    height: 24px;
    position: absolute;
    bottom: 0;
    right: 0;
    border-radius: .833333333333333vw
}

.avatar-v-blue {
    /* background: url(../img/blue.f05c2d2f.svg) no-repeat; */
    background-size: contain
}

p,ul {
    margin: 0
}

ul {
    padding: 0
}

li {
    list-style: none
}

a,a:active,a:hover,a:link,a:visited {
    text-decoration: none;
    color: #303030
}

h1,h2,h3,h4,h5,h6 {
    margin: 0
}

.avatar-v-orange[data-v-0a40485d] {
    /* background: url(../img/orange.8cdb2be4.svg) no-repeat; */
    background-size: contain
}

.avatar-v-music[data-v-0a40485d] {
    /* background: url(../img/music.b6028a7c.svg) no-repeat; */
    background-size: contain
}

.current-user-no-login[data-v-fccad332] {
    cursor: pointer;
    box-sizing: border-box;
    width: 80px;
    height: 36px;
    border: 1px solid #ff4906;
    border-radius: 18px;
    display: flex;
    justify-content: center;
    align-items: center;
    color: #ff4906
}

.current-user-no-login[data-v-fccad332]:before {
    content: "";
    /* background: url(../img/no-login.42991a00.svg) no-repeat; */
    background-size: 100%;
    margin-right: 6px;
    width: 20px;
    height: 20px
}

.current-user[data-v-fccad332] .sub-list-content {
    margin-left: -53px
}

.current-user-avatar[data-v-fccad332] {
    width: 44px;
    height: 44px;
    border-radius: 50px
}

.current-user-sub-list[data-v-fccad332] {
    width: 136px;
    padding: 14px 0
}

.current-user-sub-list-item[data-v-fccad332] {
    display: flex;
    justify-content: center;
    color: #222;
    padding: 12px 0;
    line-height: 16px
}

.current-user-sub-list-item.logout[data-v-fccad332] {
    cursor: pointer;
    padding-bottom: 0;
    border-top: 2px solid #f0f0f0;
    color: #999
}

.nav-link[data-v-4dc5b8ec] {
    color: #222
}

.navitation[data-v-8bff2fc0] {
    display: flex;
    align-items: center
}

.navitation-item[data-v-8bff2fc0] {
    flex-shrink: 0;
    display: flex;
    justify-content: center;
    align-items: center;
    position: relative;
    width: 102px;
    height: 72px;
    cursor: default
}

.navitation-item-user[data-v-8bff2fc0] {
    width: auto;
    margin: 0 26px 0 25px
}

.navitation-sub-list[data-v-8bff2fc0] {
    width: 136px;
    padding: 14px 0
}

.navitation-sub-list-item[data-v-8bff2fc0] {
    display: flex;
    justify-content: center;
    color: #222;
    padding: 12px 0;
    line-height: 16px
}

.navitation .download-app-qr[data-v-8bff2fc0] {
    background: #fff;
    display: block;
    margin: 16px;
    border: 1px solid #c6c6c6;
    border-radius: 4px;
    width: 136px;
    height: 136px;
    padding: 3px
}

.navitation .download-app-desc[data-v-8bff2fc0] {
    text-align: center;
    border-top: 1px solid #f0f0f0;
    color: #999;
    line-height: 40px
}

.navitation .set-home[data-v-8bff2fc0] {
    padding-left: 25px;
    cursor: pointer
}

.dark-mode .navitation-item[data-v-8bff2fc0] {
    color: #fff;
    width: auto;
    text-shadow: 0 1px 1px rgba(0,0,0,.5);
    padding: 0 20px
}

.dark-mode .navitation-item .nav-link[data-v-8bff2fc0],.dark-mode .navitation-item .sub-list-placeholder .nav-link[data-v-8bff2fc0],.dark-mode .navitation-item .sub-list-placeholder[data-v-8bff2fc0] {
    color: #fff
}

.dark-mode .navitation-item[data-v-8bff2fc0] .sub-list .arrow:after {
    /* background: url(../img/rank_icon_arrow_up.66389645.svg) no-repeat 50% */
}

.dark-mode .navitation-item .sub-list-content .nav-link[data-v-8bff2fc0] {
    color: #222;
    text-shadow: 0 0
}

.dark-mode .navitation-item.navitation-item-user[data-v-8bff2fc0] {
    position: relative;
    right: -680px;
    bottom: 0
}

.dark-mode[data-v-8bff2fc0] .current-user-no-login {
    border: 0
}

.dark-mode[data-v-8bff2fc0] .current-user-no-login:before {
    /* background: url(../img/unlogin.e0cb72ce.svg) no-repeat; */
    width: 26px;
    height: 26px
}

.dark-mode.navitation[data-v-8bff2fc0] {
    position: relative;
    left: 12px
}

.search[data-v-7bc9b185] {
    background: hsla(0,0%,94.5%,.5);
    border-radius: 999px;
    display: flex;
    flex: 1;
    min-width: 180px
}

.search-input[data-v-7bc9b185] {
    width: 100%;
    line-height: 42px;
    padding: 0 24px;
    border: 1px solid hsla(0,0%,94.5%,.5);
    border-top-left-radius: 999px;
    border-bottom-left-radius: 999px;
    background-color: inherit
}

.search-button[data-v-7bc9b185] {
    display: flex;
    align-items: center;
    justify-content: center;
    border: none;
    width: 88px;
    min-width: 88px;
    height: 44px;
    border-top-right-radius: 999px;
    border-bottom-right-radius: 999px;
    font-size: 16px;
    font-weight: 400;
    color: #9c9c9c;
    cursor: pointer;
    transition: background-color .15s ease-in-out;
    background-color: #eaeaea
}

.search-button[data-v-7bc9b185]:active {
    box-shadow: inset 0 2px 4px rgba(0,0,0,.15),0 1px 2px rgba(0,0,0,.05)
}

.search-button[data-v-7bc9b185]:hover {
    background-color: #ff5000;
    color: #fff
}

.search-button:hover .search-icon[data-v-7bc9b185] {
    /* background-image: url(../img/search-hover.7ab471b5.svg) */
}

.search-icon[data-v-7bc9b185] {
    /* background: url(../img/search.5a83eae8.svg) no-repeat; */
    background-size: 100%;
    margin-right: 4px;
    width: 18px;
    height: 18px
}

.header[data-v-435f8597] {
    background-color: inherit;
    position: fixed;
    height: 72px;
    width: 100%;
    top: 0;
    z-index: 10;
    display: flex;
    align-items: center;
    justify-content: space-between
}

.header-placeholder[data-v-435f8597] {
    width: 100%;
    height: 72px;
    background-color: #fff
}

.header-left[data-v-435f8597],.header-right[data-v-435f8597] {
    height: 100%;
    display: flex;
    align-items: center
}

.header-left[data-v-435f8597] {
    flex: 1
}

.header-left .logo[data-v-435f8597] {
    margin-left: 26px;
    width: 86px;
    height: 32px;
    text-indent: -9999999px;
    background: url(https://guil-file-200211.oss-cn-beijing.aliyuncs.com/Oops/Oops-icon-web.png) no-repeat 50%;
    background-size: 53%
}

.header-left .home[data-v-435f8597] {
    width: 102px;
    height: 72px;
    font-size: 14px;
    font-weight: 400;
    text-align: center;
    line-height: 72px
}

.header-right[data-v-435f8597] {
    justify-content: flex-end
}

.header[data-v-7e92e16e] {
    background-color: inherit;
    position: fixed;
    height: 72px;
    width: 100%;
    top: 0;
    z-index: 10;
    display: flex;
    align-items: center
}

.header-placeholder[data-v-7e92e16e] {
    width: 100%
}

.header-left[data-v-7e92e16e] {
    height: 100%;
    display: flex;
    align-items: center
}

.header-left .logo[data-v-7e92e16e] {
    margin-left: 80px;
    width: 81px;
    height: 32px;
    text-indent: -9999999px;
    /* background: url(../img/dark-home-logo.930d7740.svg) no-repeat 50%; */
    background-size: 100%
}

.header-left .home[data-v-7e92e16e] {
    width: 102px;
    height: 72px;
    font-size: 14px;
    font-weight: 400;
    text-align: center;
    line-height: 72px
}

.header .main-header[data-v-7e92e16e] {
    width: 1190px;
    margin: 0 auto;
    padding-right: 161px;
    display: flex;
    align-items: center;
    justify-content: space-between
}

.header .main-header .header-right[data-v-7e92e16e] {
    width: 562px;
    padding-right: 5px
}

.dark-search[data-v-7e92e16e] {
    width: 562px;
    background: #131415;
    margin-left: 35px;
    margin-right: 55px
}

.dark-search[data-v-7e92e16e] .search-input {
    border: 0;
    color: #fff
}

.dark-search[data-v-7e92e16e] .search-button {
    background: #131415;
    color: #ff4906
}

/* .dark-search[data-v-7e92e16e] .search-icon {
    background: url(../img/dark-search.f34c842f.svg) no-repeat 50%
}

.dark-search[data-v-7e92e16e]:hover .search-icon {
    background-image: url(../img/dark-search.f34c842f.svg)
} */

.sidebar[data-v-b849c210] {
    overflow: auto;
    display: flex;
    flex-direction: column;
    justify-content: space-between;
    position: relative;
    flex: 0 0 220px;
    background-color: #fff;
    font-size: 14px;
    color: #222
}

.sidebar .brilliant[data-v-b849c210],.sidebar .featured[data-v-b849c210],.sidebar .home[data-v-b849c210],.sidebar .like[data-v-b849c210],.sidebar .profile[data-v-b849c210] {
    font-size: 14px;
    font-weight: 400;
    padding-left: 26px
}

.sidebar .brilliant[data-v-b849c210]:hover,.sidebar .featured[data-v-b849c210]:hover,.sidebar .home[data-v-b849c210]:hover,.sidebar .like[data-v-b849c210]:hover,.sidebar .profile[data-v-b849c210]:hover {
    font-weight: 500;
    background: #f0f0f0
}

.sidebar .featured[data-v-b849c210],.sidebar .home[data-v-b849c210] {
    height: 40px;
    display: flex;
    align-items: center;
    margin-bottom: 16px;
    cursor: pointer
}

.sidebar .reco[data-v-b849c210] {
    margin-bottom: 16px
}

.sidebar .reco-title[data-v-b849c210] {
    height: 56px;
    line-height: 56px;
    font-size: 16px;
    font-weight: 500;
    padding-left: 26px
}

.sidebar .reco-item[data-v-b849c210] {
    height: 40px;
    display: flex;
    align-items: center;
    padding-left: 36px;
    cursor: pointer
}

.sidebar .reco-item[data-v-b849c210]:hover {
    font-weight: 500;
    background: #f0f0f0
}

.sidebar .reco-item .hover[data-v-b849c210] {
    display: none
}

.sidebar .reco-item:hover .hover[data-v-b849c210] {
    display: inline-block
}

.sidebar .reco-item:hover .normal[data-v-b849c210] {
    display: none
}

.sidebar .reco .active .hover[data-v-b849c210] {
    display: inline-block
}

.sidebar .reco .active .normal[data-v-b849c210] {
    display: none
}

.sidebar .reco .more[data-v-b849c210] {
    height: 40px;
    display: flex;
    align-items: center;
    cursor: pointer;
    padding-left: 36px;
    font-size: 14px;
    color: #c6c6c6;
    line-height: 16px
}

.sidebar .brilliant[data-v-b849c210],.sidebar .like[data-v-b849c210] {
    height: 40px;
    display: flex;
    align-items: center;
    margin: 16px 0 18px 0;
    cursor: pointer
}

.sidebar .profile[data-v-b849c210] {
    height: 40px;
    display: flex;
    align-items: center;
    cursor: pointer
}

.sidebar .links[data-v-b849c210] {
    padding: 26px
}

.sidebar .links ul[data-v-b849c210] {
    display: flex;
    flex-wrap: wrap
}

.sidebar .links-item[data-v-b849c210] {
    line-height: 16px;
    margin-bottom: 12px
}

.sidebar .links-item[data-v-b849c210]:nth-child(odd) {
    margin-right: 32px
}

.sidebar .links-item[data-v-b849c210]:last-child,.sidebar .links-item[data-v-b849c210]:nth-last-child(2) {
    margin-bottom: 0
}

.sidebar .links-item-href[data-v-b849c210] {
    font-size: 13px;
    color: #666;
    transition: color .15s ease-in-out
}

.sidebar .links-item-href[data-v-b849c210]:hover {
    color: #ff5000
}

.sidebar .down-icon[data-v-b849c210],.sidebar .featured-icon[data-v-b849c210],.sidebar .home-icon[data-v-b849c210],.sidebar .like-icon[data-v-b849c210],.sidebar .me-icon[data-v-b849c210],.sidebar .reco-icon[data-v-b849c210],.sidebar .up-icon[data-v-b849c210],.sidebar .video-icon[data-v-b849c210] {
    display: inline-block;
    width: 20px;
    height: 20px;
    margin-right: 12px;
    background-size: 100% 100%
}

/* .sidebar .home-icon[data-v-b849c210] {
    background-image: url(../img/home_normal.014a70ae.svg)
} */

/* .sidebar .video-icon[data-v-b849c210] {
    background-image: url(../img/video_normal.dbd45585.svg)
} */

/* .sidebar .up-icon[data-v-b849c210] {
    background-image: url(../img/arrow_up.29ca9f4a.svg)
} */

/* .sidebar .down-icon[data-v-b849c210] {
    background-image: url(../img/arrow_down.b2b48188.svg)
} */

/* .sidebar .me-icon[data-v-b849c210] {
    background-image: url(../img/me_normal.f2e4c578.svg)
}

.sidebar .featured-icon[data-v-b849c210] {
    background-image: url(../img/featured-normal.948c1a8c.svg)
} */

/* .sidebar .like-icon[data-v-b849c210] {
    background-image: url(../img/like_normal.22cfe62f.svg)
} */

/* .sidebar .home:hover .home-icon[data-v-b849c210] {
    background-image: url(../img/home_active.5ffe69d8.svg)
}

.sidebar .brilliant:hover .video-icon[data-v-b849c210] {
    background-image: url(../img/video_active.5e5b443e.svg)
}

.sidebar .profile:hover .me-icon[data-v-b849c210] {
    background-image: url(../img/me_active.db4330de.svg)
}

.sidebar .featured:hover .featured-icon[data-v-b849c210] {
    background-image: url(../img/featured_active.caa49ea3.svg)
}

.sidebar .like:hover .like-icon[data-v-b849c210] {
    background-image: url(../img/like_active.e943ce9c.svg)
} */

.sidebar .active[data-v-b849c210] {
    font-weight: 500;
    background: #f0f0f0
}

#active1[data-v-b849c210] {
    font-weight: 500;
    background: #f0f0f0
}

/* .sidebar .active .home-icon[data-v-b849c210] {
    background-image: url(../img/home_active.5ffe69d8.svg)
}

.sidebar .active .video-icon[data-v-b849c210] {
    background-image: url(../img/video_active.5e5b443e.svg)
}

.sidebar .active .me-icon[data-v-b849c210] {
    background-image: url(../img/me_active.db4330de.svg)
}

.sidebar .active .featured-icon[data-v-b849c210] {
    background-image: url(../img/featured_active.caa49ea3.svg)
}

.sidebar .active .like-icon[data-v-b849c210] {
    background-image: url(../img/like_active.e943ce9c.svg)
} */

.footer[data-v-23ae028c] {
    height: 20px;
    font-size: 12px;
    text-align: center;
    color: #999;
    line-height: 20px
}

.footer .license[data-v-23ae028c],.footer .police[data-v-23ae028c] {
    display: inline-block;
    width: 18px;
    height: 18px;
    /* background: url(data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAACQAAAAkCAYAAADhAJiYAAAAGXRFWHRTb2Z0d2FyZQBBZG9iZSBJbWFnZVJlYWR5ccllPAAAAyNpVFh0WE1MOmNvbS5hZG9iZS54bXAAAAAAADw/eHBhY2tldCBiZWdpbj0i77u/IiBpZD0iVzVNME1wQ2VoaUh6cmVTek5UY3prYzlkIj8+IDx4OnhtcG1ldGEgeG1sbnM6eD0iYWRvYmU6bnM6bWV0YS8iIHg6eG1wdGs9IkFkb2JlIFhNUCBDb3JlIDUuNi1jMTQwIDc5LjE2MDQ1MSwgMjAxNy8wNS8wNi0wMTowODoyMSAgICAgICAgIj4gPHJkZjpSREYgeG1sbnM6cmRmPSJodHRwOi8vd3d3LnczLm9yZy8xOTk5LzAyLzIyLXJkZi1zeW50YXgtbnMjIj4gPHJkZjpEZXNjcmlwdGlvbiByZGY6YWJvdXQ9IiIgeG1sbnM6eG1wPSJodHRwOi8vbnMuYWRvYmUuY29tL3hhcC8xLjAvIiB4bWxuczp4bXBNTT0iaHR0cDovL25zLmFkb2JlLmNvbS94YXAvMS4wL21tLyIgeG1sbnM6c3RSZWY9Imh0dHA6Ly9ucy5hZG9iZS5jb20veGFwLzEuMC9zVHlwZS9SZXNvdXJjZVJlZiMiIHhtcDpDcmVhdG9yVG9vbD0iQWRvYmUgUGhvdG9zaG9wIENDIChNYWNpbnRvc2gpIiB4bXBNTTpJbnN0YW5jZUlEPSJ4bXAuaWlkOkM5Q0IyNUYzOTgyNDExRUE4MDNCQ0UyQUFBNjE3MTVFIiB4bXBNTTpEb2N1bWVudElEPSJ4bXAuZGlkOkM5Q0IyNUY0OTgyNDExRUE4MDNCQ0UyQUFBNjE3MTVFIj4gPHhtcE1NOkRlcml2ZWRGcm9tIHN0UmVmOmluc3RhbmNlSUQ9InhtcC5paWQ6QzlDQjI1RjE5ODI0MTFFQTgwM0JDRTJBQUE2MTcxNUUiIHN0UmVmOmRvY3VtZW50SUQ9InhtcC5kaWQ6QzlDQjI1RjI5ODI0MTFFQTgwM0JDRTJBQUE2MTcxNUUiLz4gPC9yZGY6RGVzY3JpcHRpb24+IDwvcmRmOlJERj4gPC94OnhtcG1ldGE+IDw/eHBhY2tldCBlbmQ9InIiPz49DDD2AAALiklEQVR42rRYC3QU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) no-repeat top; */
    background-size: 100% 100%;
    vertical-align: -4px;
    margin-right: 4px
}

.footer .police[data-v-23ae028c] {
    /* background: url(data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAABQAAAAUCAMAAAC6V+0/AAACLlBMVEVHcEzmwlr788zdqFb58Nj/wn/gqlX/+Ojz56rerGj368Tt46rt3H/mw3Pr04TXrn38/OecaFjftWjx16/z6JL034rYmXLKg1rmvGzntVvam1HYrYPq0ZfCfz7r14/nxnv/+ND52X/92I/ryHj4znn/7obiu2jktYHjtYD//9//9ZXaq2GzlH2ti3rjwI7buobRrnX8vlPrvlnVHhgAAXgBAW3tyl7nulrNAALouFLktV3w13TrwWHmv1DksE7gplDwz2b/0ljXPiDWij/aSikEAmfklTj90GiRinnrzGrtvE/qxlztsEnVkEbZlE7mrEndmkXislPeoES7jlvQfjvUAwlRNlHdhTX8wVz1fy/+xVLYlD//216ZXzMGAF93eH7JJxPWZTDTOCJveYbQFg3pgj7SwXTQPym0nl/9LA/VYjj5oj+7ABDtcTDoXybgbjbBvIOclYTIsnptgpEZN5AAAIC7TCbz5HL34nTnxGbyyVbemEPpxWHmwFXVdCg4FjfYnljPLBqRelnWMR+sonP/723ooD38jiz/2E3yy23RDBHBDAs6EjnNrFKptJHJWSpWTm9ODk5CJETFUiTEGApeWWaUd1xgHlBcX3jwXh7ZAAaxDg7VdTfLPSHGPh1pAjZMADkAG47VSCrZdTqEj5mjfVKBWDqEaUrEazN5ZGDYzHcAEHr0sEBrc4Tgjkf/4mPiRh42Gk2njVluYmL/tUnTvIcACJH6xETxym+1gD8uldpjAAAAMnRSTlMA8lvGHALoCELjQYDn6ZSsJfn8aau6FF285NJIjJwn+0wwssTBvuDHsRg19cvRn5hvw9AzOaMAAAFrSURBVBjTY2CAAE1hHV1hFgZkwMUvGLts+VJBfgWEGHtwfeyKvFyhlp5gdpgYi0pYU2RokotFdl+YElRUQGjj1HZj40aXlO6ItZN45cCCWh6lm2aGNht3JVnkFZh6KII1G3qY7Nwwy9jJydjCaZVpvKoAUNAgu7A0I9KiP9p2XUpummmhIzdQUN+taNvm7WXzEhfnO69faVKwRg8oyBm+o8S0LHXR3Kz0/CzXEms3TqCgdsiWYpOczMTJc1Izc0yLo5zVgIIaQe5bFy6YPSUhwSV9/uoi90A+oKB6tL37EhPXuInT41xNkmOs/JWBgvINfm6dadOSM3pnTIi3aQuw4wEKMtna+9ZFxHRE+Ti2Oob7BppxgFzPxFgb4uxgZGfu4BDg58nLAQk3Tu8aSyNvGzOjIHPrSjaIoGiFtZWVkZ2NZbW9ublnuQgkNPkYLau8fLz8jcxszXi4WaEBKiYuyyzFJsksISMNFgIA90Jid0ICY00AAAAASUVORK5CYII=) no-repeat top */
}

.footer .police-link[data-v-23ae028c] {
    color: #999
}

.user-modal[data-v-2346bd69] {
    position: fixed;
    z-index: 1080;
    top: 0;
    right: 0;
    bottom: 0;
    left: 0;
    background: rgba(0,0,0,.5);
    overflow: auto;
    outline: 0
}

.user-modal-dialog[data-v-2346bd69] {
    position: relative;
    margin: 200px auto 100px;
    background-color: #fff;
    box-shadow: 0 2px 4px rgba(0,0,0,.5);
    outline: 0;
    opacity: 1;
    border-radius: 2px;
    border: none
}

.user-modal-body[data-v-2346bd69] {
    position: relative;
    overflow: hidden
}

.user-modal-close[data-v-2346bd69] {
    position: absolute;
    width: 18px;
    height: 18px;
    top: 26px;
    right: 26px;
    z-index: 22;
    cursor: pointer;
    /* background: url(../img/close-ico.9f9752c8.svg) no-repeat 50%; */
    background-size: 100%
}

.user-modal-enter-active .user-modal-dialog[data-v-2346bd69],.user-modal-enter-active[data-v-2346bd69],.user-modal-leave-active .user-modal-dialog[data-v-2346bd69],.user-modal-leave-active[data-v-2346bd69] {
    transform: translateZ(0);
    transition: all .3s ease-out
}

.user-modal-enter[data-v-2346bd69],.user-modal-leave-active[data-v-2346bd69] {
    background: transparent
}

.user-modal-enter .user-modal-dialog[data-v-2346bd69],.user-modal-leave-active .user-modal-dialog[data-v-2346bd69] {
    transform: translateY(-25%);
    opacity: 0
}

.qrcode[data-v-cd063228] {
    display: inline-block;
    text-align: center
}

.qrcode-detail[data-v-cd063228] {
    position: relative;
    width: 158px;
    height: 158px;
    background: #f8f8f8;
    border: 1px solid #c6c6c6;
    border-radius: 4px;
    display: flex;
    justify-content: center;
    align-items: center
}

.qrcode-img[data-v-cd063228] {
    width: 143px;
    height: 143px;
    overflow: hidden
}

.qrcode-img img[data-v-cd063228] {
    display: block;
    margin: -8px 0 0 -8px;
    width: 159px;
    height: 159px
}

.qrcode-icon[data-v-cd063228] {
    position: absolute;
    top: 50%;
    left: 50%;
    margin: -16px 0 0 -16px;
    width: 32px;
    height: 32px;
    /* background: url(../img/logo-simple.f8bc2fc9.svg) no-repeat; */
    background-size: contain
}

.qrcode-status[data-v-cd063228] {
    position: absolute;
    top: 0;
    right: 0;
    bottom: 0;
    left: 0;
    border-radius: 4px;
    padding-top: 94px;
    /* background: hsla(0,0%,97.3%,.96) url(../img/qr-confirm.f32a3c57.svg) no-repeat 50% 44px; */
    display: none
}

.qrcode-status-confirm[data-v-cd063228] {
    display: block
}

.qrcode-status-timeout[data-v-cd063228] {
    /* background-image: url(../img/qr-timeout.36ec9078.svg); */
    display: block
}

.qrcode-status strong[data-v-cd063228] {
    color: #909090
}

.qrcode-refresh[data-v-cd063228] {
    cursor: pointer;
    color: #303030;
    transition: color .15s ease-in-out
}

.qrcode-refresh[data-v-cd063228]:hover {
    color: #ff4906
}

.qrcode-download[data-v-cd063228] {
    margin-top: 24px;
    color: #000
}

.qrcode-download a[data-v-cd063228] {
    color: #ff4906
}

.pl-btn {
    display: inline-block;
    margin-bottom: 0;
    font-weight: 400;
    text-align: center;
    vertical-align: middle;
    cursor: pointer;
    background-image: none;
    border: 1px solid transparent;
    white-space: nowrap;
    -webkit-box-sizing: content-box;
    box-sizing: content-box;
    padding: 10px 25px;
    font-size: 12px;
    line-height: 1
}

.pl-btn.pl-btn-radius {
    border-radius: 9999px
}

.pl-btn:hover {
    text-decoration: none
}

.pl-btn:focus,.pl-btn:hover {
    outline: none
}

.pl-btn.active,.pl-btn:active {
    -webkit-box-shadow: inset 0 2px 4px rgba(0,0,0,.15),0 1px 2px rgba(0,0,0,.05);
    box-shadow: inset 0 2px 4px rgba(0,0,0,.15),0 1px 2px rgba(0,0,0,.05)
}

.pl-btn-primary {
    color: #fff;
    background-color: #ff8000;
    border-color: #ff8000;
    -webkit-transition: all .15s ease-in-out;
    transition: all .15s ease-in-out
}

.pl-btn-primary {
    cursor: not-allowed
}

.pl-btn-primary,.pl-btn-primary:hover {
    background-color: rgba(255,128,0,.2);
    border-color: transparent
}

.pl-btn-primary:hover {
    background: #ff8d1a;
    border-color: #ff8d1a
}

.pl-btn-secondary {
    color: #fff;
    background-color: #61d575;
    border-color: #61d575;
    -webkit-transition: all .15s ease-in-out;
    transition: all .15s ease-in-out
}

.pl-btn-secondary {
    cursor: not-allowed
}

.pl-btn-secondary,.pl-btn-secondary:hover {
    background-color: rgba(97,213,117,.2);
    border-color: transparent
}

.pl-btn-secondary:hover {
    background: #71d983;
    border-color: #71d983
}

.pl-btn-default {
    color: #303030;
    background-color: #fff;
    border-color: #e5e5e5;
    -webkit-transition: all .15s ease-in-out;
    transition: all .15s ease-in-out
}

.pl-btn-default {
    cursor: not-allowed
}

.pl-btn-default,.pl-btn-default:hover {
    background-color: hsla(0,0%,100%,.2);
    border-color: transparent
}

.pl-btn-default:hover {
    color: #ff8000;
    border-color: #ff8000
}

.pl-btn-success {
    color: #fff;
    background-color: #3ae0ff;
    border-color: #3ae0ff;
    -webkit-transition: all .15s ease-in-out;
    transition: all .15s ease-in-out
}

.pl-btn-success {
    cursor: not-allowed
}

.pl-btn-success,.pl-btn-success:hover {
    background-color: rgba(58,224,255,.2);
    border-color: transparent
}

.pl-btn-success:hover {
    background: #4ee3ff;
    border-color: #4ee3ff
}

.pl-btn-info {
    color: #fff;
    background-color: #428bca;
    border-color: #428bca;
    -webkit-transition: all .15s ease-in-out;
    transition: all .15s ease-in-out
}

.pl-btn-info {
    cursor: not-allowed
}

.pl-btn-info,.pl-btn-info:hover {
    background-color: rgba(66,139,202,.2);
    border-color: transparent
}

.pl-btn-info:hover {
    background: #5597cf;
    border-color: #5597cf
}

.pl-btn-warning {
    color: #fff;
    background-color: #ffa832;
    border-color: #ffa832;
    -webkit-transition: all .15s ease-in-out;
    transition: all .15s ease-in-out
}

.pl-btn-warning {
    cursor: not-allowed
}

.pl-btn-warning,.pl-btn-warning:hover {
    background-color: rgba(255,168,50,.2);
    border-color: transparent
}

.pl-btn-warning:hover {
    background: #ffb147;
    border-color: #ffb147
}

.pl-btn-danger {
    color: #fff;
    background-color: #ff2100;
    border-color: #ff2100;
    -webkit-transition: all .15s ease-in-out;
    transition: all .15s ease-in-out
}

.pl-btn-danger {
    cursor: not-allowed
}

.pl-btn-danger,.pl-btn-danger:hover {
    background-color: rgba(255,33,0,.2);
    border-color: transparent
}

.pl-btn-danger:hover {
    background: #ff371a;
    border-color: #ff371a
}

.pl-btn-large {
    padding: 13px 35px;
    font-size: 17.5px;
    line-height: 1
}

.pl-btn-small {
    padding: 7px 15px;
    font-size: 12px;
    line-height: 1
}

.pl-btn-block {
    display: block;
    width: 100%
}

.pl-btn+.pl-btn {
    margin-left: 20px
}

.pl-btn-block+.pl-btn-block {
    margin-top: 10px
}

.pl-input {
    display: -webkit-box;
    display: -ms-flexbox;
    display: flex;
    position: relative;
    height: 100%;
    width: 100%;
    overflow: hidden;
    background-color: transparent
}

.pl-input-container {
    -webkit-box-sizing: border-box;
    box-sizing: border-box;
    border: 1px solid #eaeaea;
    background-color: #fff;
    -webkit-transition: border-color .15s ease-in-out;
    transition: border-color .15s ease-in-out;
    color: #303030;
    display: inline-block;
    position: relative;
    width: 210px;
    height: 32px
}

.pl-input-container.radius,.pl-input-container.radius .pl-input,.pl-input-container.radius .pl-input-text {
    border-radius: 999px
}

.pl-input-container:hover {
    border-color: #d3d3d3
}

.pl-input-container.focus {
    border-color: #ff8000
}

.pl-input-container.readonly {
    border-color: #eaeaea
}

.pl-input-container.disabled {
    cursor: not-allowed;
    background-color: #eef1f6
}

.pl-input-append,.pl-input-prepend {
    padding: 0 5px;
    display: -webkit-box;
    display: -ms-flexbox;
    display: flex;
    -webkit-box-align: center;
    -ms-flex-align: center;
    align-items: center
}

.pl-input-text {
    outline: none;
    padding: 0 5px;
    font-size: 12px;
    border: none;
    -webkit-box-sizing: border-box;
    box-sizing: border-box;
    vertical-align: top;
    background-color: transparent;
    width: 100%;
    -webkit-box-flex: 1;
    -ms-flex: 1;
    flex: 1
}

.pl-input-text {
    cursor: not-allowed
}

.verify-login {
    position: relative;
    width: 330px
}

.verify-login-title {
    font-weight: 400;
    line-height: 28px;
    color: #222
}

.verify-login-content {
    margin-top: 16px
}

.verify-login-input {
    margin-bottom: 16px;
    width: 100%;
    height: 46px;
    border-radius: 999px;
    border-color: transparent;
    background-color: #f8f8f8
}

.verify-login-input .pl-input-text {
    font-size: 14px;
    padding-left: 16px
}

.verify-login-error {
    font-size: 12px;
    color: #ff4906;
    line-height: 20px;
    margin: -4px 0 -16px
}

.verify-login-country-code {
    color: #222;
    margin-left: 11px;
    padding-right: 16px;
    position: relative
}

.verify-login-country-code:after {
    content: "";
    position: absolute;
    width: 1px;
    height: 16px;
    background-color: #c6c6c6;
    right: 0;
    top: 2px
}

.verify-login-button {
    display: block;
    box-sizing: border-box;
    margin-top: 48px;
    padding: 12px 0;
    width: 100%;
    font-size: 16px;
    background: #ff4906
}

.verify-login-button:disabled,.verify-login-button:disabled:hover {
    background: #fea383
}

.verify-login .get-verification {
    color: #ff4906;
    cursor: pointer;
    margin-right: 11px;
    font-size: 14px
}

.verify-login .get-verification.disabled {
    opacity: .5;
    cursor: not-allowed
}

.verify-login .change-login {
    margin-top: -3px;
    margin-bottom: 17px;
    color: #ff4906;
    cursor: pointer;
    font-size: 14px
}

.third-part {
    display: flex;
    justify-content: center;
    align-items: center
}

.third-part a {
    border-radius: 50%;
    display: block;
    margin-left: 16px;
    width: 24px;
    height: 24px
}

.third-part-wechat {
    /* background: url(../img/wechat.7c26c5cd.svg) no-repeat; */
    background-size: 100%
}

.third-part-qq {
    /* background: url(../img/qq.0f70559b.svg) no-repeat; */
    background-size: 100%
}

.fade-bottom-enter-active,.fade-bottom-leave-active {
    opacity: 1;
    -webkit-transition: all .3s ease-out;
    transition: all .3s ease-out;
    -webkit-transform-origin: center bottom;
    transform-origin: center bottom
}

.fade-bottom-enter,.fade-bottom-leave,.fade-bottom-leave-active {
    opacity: 0;
    -webkit-transform: scaleY(0);
    transform: scaleY(0)
}

.fade-top-enter-active,.fade-top-leave-active {
    opacity: 1;
    -webkit-transition: all .3s ease-out;
    transition: all .3s ease-out;
    -webkit-transform-origin: center top;
    transform-origin: center top
}

.fade-top-enter,.fade-top-leave,.fade-top-leave-active {
    opacity: 0;
    -webkit-transform: scaleY(0);
    transform: scaleY(0)
}

.scale-enter-active,.scale-leave-active {
    -webkit-transition: all .15s ease-in-out;
    transition: all .15s ease-in-out;
    opacity: 1;
    -webkit-transform: scale(1);
    transform: scale(1)
}

.scale-enter,.scale-leave,.scale-leave-active {
    -webkit-transform: scale(0);
    transform: scale(0);
    opacity: 0
}

.pl-radio {
    display: inline-block;
    cursor: default;
    font-size: 14px;
    vertical-align: top;
    line-height: 1
}

.pl-radio-input,.pl-radio-label {
    display: inline-block;
    -webkit-box-sizing: border-box;
    box-sizing: border-box;
    vertical-align: top
}

.pl-radio-hidden {
    opacity: 0;
    outline: none;
    position: absolute;
    margin: 0;
    visibility: hidden;
    left: -99999px
}

.pl-radio-input {
    background: #fff;
    margin: 0 5px;
    width: 12px;
    height: 12px;
    border-radius: 50%;
    -webkit-transition: background .3s ease-in-out,-webkit-box-shadow .3s ease-in-out;
    transition: background .3s ease-in-out,-webkit-box-shadow .3s ease-in-out;
    transition: background .3s ease-in-out,box-shadow .3s ease-in-out;
    transition: background .3s ease-in-out,box-shadow .3s ease-in-out,-webkit-box-shadow .3s ease-in-out;
    cursor: pointer;
    position: relative;
    -webkit-box-shadow: 0 0 0 1px #fff,0 0 0 2px #bbb;
    box-shadow: 0 0 0 1px #fff,0 0 0 2px #bbb
}

.pl-radio-input:after,.pl-radio-input:before {
    content: "";
    -webkit-box-sizing: content-box;
    box-sizing: content-box;
    width: 2px;
    background: #fff;
    border-top-left-radius: 999px;
    border-top-right-radius: 999px;
    -webkit-transition: -webkit-transform .3s ease-in-out;
    transition: -webkit-transform .3s ease-in-out;
    transition: transform .3s ease-in-out;
    transition: transform .3s ease-in-out,-webkit-transform .3s ease-in-out;
    position: absolute;
    -webkit-transform-origin: bottom;
    transform-origin: bottom
}

.pl-radio-input:before {
    top: 4px;
    left: 5px;
    height: 4px;
    -webkit-transform: rotate(-45deg) scale(0);
    transform: rotate(-45deg) scale(0)
}

.pl-radio-input:after {
    top: 2px;
    left: 4px;
    height: 6px;
    -webkit-transform: rotate(45deg) scale(0);
    transform: rotate(45deg) scale(0)
}

.pl-radio-input.checked,.pl-radio-input:hover {
    -webkit-box-shadow: 0 0 0 1px #fff,0 0 0 2px #ff8000;
    box-shadow: 0 0 0 1px #fff,0 0 0 2px #ff8000
}

.pl-radio-input.checked {
    background: #ff8000
}

.pl-radio-input.checked:before {
    -webkit-transform: rotate(-45deg) scale(1);
    transform: rotate(-45deg) scale(1)
}

.pl-radio-input.checked:after {
    -webkit-transform: rotate(45deg) scale(1);
    transform: rotate(45deg) scale(1)
}

.pl-radio-input.disabled {
    -webkit-box-shadow: 0 0 0 1px #fff,0 0 0 2px #c1c1c1;
    box-shadow: 0 0 0 1px #fff,0 0 0 2px #c1c1c1;
    background: #f1f1f1;
    cursor: not-allowed
}

.pl-radio-input.disabled:after {
    background: #fff
}

.choose-user[data-v-3fa578f0] {
    padding-top: 5px
}

.choose-user-list[data-v-3fa578f0] {
    margin-top: 54px;
    height: 190px
}

.choose-user-list-item[data-v-3fa578f0] {
    display: flex;
    align-items: center;
    margin-bottom: 45px
}

.choose-user-list-item[data-v-3fa578f0]:last-child {
    margin-bottom: 0
}

.choose-user-list-item-detail[data-v-3fa578f0] {
    box-sizing: border-box;
    max-width: 270px;
    white-space: nowrap;
    word-wrap: normal;
    overflow: hidden;
    text-overflow: ellipsis;
    display: inline-block;
    width: 270px;
    padding-left: 15px
}

.choose-user-list-item img[data-v-3fa578f0] {
    width: 46px;
    height: 46px;
    border-radius: 50%
}

.cofirm-button[data-v-3fa578f0] {
    display: block;
    box-sizing: border-box;
    margin-bottom: 50px;
    padding: 13px 0;
    width: 100%;
    font-size: 18px
}

.login-modal-header[data-v-36dca710] {
    font-size: 20px;
    line-height: 64px;
    border-bottom: 1px solid #f0f0f0;
    padding-left: 28px;
    color: #222
}

.login-modal-content[data-v-36dca710] {
    margin-top: 40px;
    display: flex
}

.login-modal-verify-login[data-v-36dca710] {
    padding-right: 27px;
    border-right: 1px solid #f0f0f0;
    margin-left: 60px
}

.login-modal-qr-login[data-v-36dca710] {
    margin: 44px 0 0 27px
}

.login-modal-footer[data-v-36dca710] {
    margin: 48px 0 31px;
    font-size: 12px;
    text-align: center;
    color: #9c9c9c
}

.login-modal-footer a[data-v-36dca710] {
    color: rgba(0,53,105,.8);
    transition: color .15s ease-in-out
}

.login-modal-footer a[data-v-36dca710]:hover {
    color: #003569
}

.login-modal-footer .agreement[data-v-36dca710] {
    margin-top: 19px
}

.login-modal-choose-user[data-v-36dca710] {
    margin: 0 auto;
    width: 50%
}

/*! normalize.css v8.0.1 | MIT License | github.com/necolas/normalize.css */
html {
    line-height: 1.15;
    -webkit-text-size-adjust: 100%
}

body {
    margin: 0
}

main {
    display: block
}

h1 {
    font-size: 2em;
    margin: .67em 0
}

hr {
    box-sizing: content-box;
    height: 0;
    overflow: visible
}

pre {
    font-family: monospace,monospace;
    font-size: 1em
}

a {
    background-color: transparent
}

abbr[title] {
    border-bottom: none;
    text-decoration: underline;
    -webkit-text-decoration: underline dotted;
    text-decoration: underline dotted
}

b,strong {
    font-weight: bolder
}

code,kbd,samp {
    font-family: monospace,monospace;
    font-size: 1em
}

small {
    font-size: 80%
}

sub,sup {
    font-size: 75%;
    line-height: 0;
    position: relative;
    vertical-align: baseline
}

sub {
    bottom: -.25em
}

sup {
    top: -.5em
}

img {
    border-style: none
}

button,input,optgroup,select,textarea {
    font-family: inherit;
    font-size: 100%;
    line-height: 1.15;
    margin: 0
}

button,input {
    overflow: visible
}

button,select {
    text-transform: none
}

/* [type=button],[type=reset],[type=submit],button {
    -webkit-appearance: button
} */
/* 
[type=button]::-moz-focus-inner,[type=reset]::-moz-focus-inner,[type=submit]::-moz-focus-inner,button::-moz-focus-inner {
    border-style: none;
    padding: 0
} */

/* [type=button]:-moz-focusring,[type=reset]:-moz-focusring,[type=submit]:-moz-focusring,button:-moz-focusring {
    outline: 1px dotted ButtonText
} */

fieldset {
    padding: .35em .75em .625em
}

legend {
    box-sizing: border-box;
    color: inherit;
    display: table;
    max-width: 100%;
    padding: 0;
    white-space: normal
}

progress {
    vertical-align: baseline
}

textarea {
    overflow: auto
}
/* 
[type=checkbox],[type=radio] {
    box-sizing: border-box;
    padding: 0
} */

/* [type=number]::-webkit-inner-spin-button,[type=number]::-webkit-outer-spin-button {
    height: auto
} */

/* [type=search] {
    -webkit-appearance: textfield;
    outline-offset: -2px
} */

/* [type=search]::-webkit-search-decoration {
    -webkit-appearance: none
} */

::-webkit-file-upload-button {
    -webkit-appearance: button;
    font: inherit
}

details {
    display: block
}

summary {
    display: list-item
}

[hidden],template {
    display: none
}

.svg-icon {
    display: inline-block;
    width: 16px;
    height: 16px;
    color: inherit;
    vertical-align: middle;
    fill: none;
    stroke: currentColor
}

.svg-fill {
    fill: currentColor;
    stroke: none
}

.svg-up {
    -webkit-transform: rotate(0deg);
    transform: rotate(0deg)
}

.svg-right {
    -webkit-transform: rotate(90deg);
    transform: rotate(90deg)
}

.svg-down {
    -webkit-transform: rotate(180deg);
    transform: rotate(180deg)
}

.svg-left {
    -webkit-transform: rotate(-90deg);
    transform: rotate(-90deg)
}

body {
    font-family: fontsc,PingFang SC,Helvetica Neue For Number,-apple-system,BlinkMacSystemFont,Segoe UI,Roboto,Hiragino Sans GB,Microsoft YaHei,Helvetica Neue,Helvetica,Arial,sans-serif;
    font-size: 14px;
    line-height: 1.5;
    background: #f5f5f5;
    -webkit-font-smoothing: antialiased;
    -moz-osx-font-smoothing: grayscale
}


:focus {
    outline: none
}

dd {
    margin-left: 0
}

dl {
    margin: 0
}

.short-main {
    height: 100vh!important
}

.short-main-content {
    width: 100%;
    overflow-x: hidden
}

.main {
    display: flex;
    height: calc(100vh - 72px)
}

.main-content {
    width: 100%;
    overflow-x: auto
}

.home-skeleton[data-v-058007b5] {
    width: 100%;
    min-height: 100%;
    box-sizing: border-box
}

.home-skeleton-header[data-v-058007b5] {
    height: 40px;
    display: flex;
    justify-content: space-between;
    align-items: center
}

.home-skeleton-header-title[data-v-058007b5] {
    font-size: 24px;
    font-weight: 500;
    color: #222;
    line-height: 24px
}

.home-skeleton-header-more[data-v-058007b5] {
    font-size: 14px;
    color: #666;
    line-height: 24px
}

.home-skeleton .brilliant-video[data-v-058007b5] {
    display: flex;
    margin: 16px 0
}

.home-skeleton .brilliant-video .video-item[data-v-058007b5] {
    margin-right: 12px
}

.home-skeleton .brilliant-video .video-item[data-v-058007b5]:nth-child(6n) {
    margin-right: 0
}

.home-skeleton .reco-video[data-v-058007b5] {
    display: flex;
    flex-wrap: wrap;
    margin-top: 16px
}

.home-skeleton .reco-video .video-item[data-v-058007b5] {
    margin-right: 12px;
    margin-bottom: 40px
}

.home-skeleton .reco-video .video-item[data-v-058007b5]:nth-child(4n) {
    margin-right: 0
}

.home-skeleton .loading[data-v-058007b5] {
    text-align: center;
    height: 10.416666666666668vw;
    line-height: 10.416666666666668vw
}

.home[data-v-6fe1bef7] {
    width: 100%;
    height: 100%;
    min-height: 100%;
    min-width: 912px;
    box-sizing: border-box;
    padding: 30px;
    overflow: auto
}

.home-header[data-v-6fe1bef7] {
    height: 40px;
    display: flex;
    justify-content: space-between;
    align-items: center
}

.home-header-title[data-v-6fe1bef7] {
    font-size: 24px;
    font-weight: 500;
    color: #222;
    line-height: 24px
}

.home-header-more[data-v-6fe1bef7] {
    font-size: 14px;
    color: #666;
    line-height: 24px;
    transition: color .15s ease-in-out
}

.home-header-more[data-v-6fe1bef7]:hover {
    color: #ff5000
}

.home .brilliant-video[data-v-6fe1bef7] {
    display: flex;
    margin: 16px 0
}

.home .brilliant-video .video-item[data-v-6fe1bef7] {
    margin-right: 12px
}

.home .brilliant-video .video-item[data-v-6fe1bef7]:nth-child(6n) {
    margin-right: 0
}

.home .reco-video[data-v-6fe1bef7] {
    margin-top: 16px
}

.home .reco-video[data-v-6fe1bef7] .scroll-list-content {
    margin-right: 12px;
    margin-bottom: 40px
}

.home .reco-video[data-v-6fe1bef7] .scroll-list-content:nth-child(4n) {
    margin-right: 0
}

.video-card[data-v-76a466a3] {
    min-width: 132px;
    width: calc((100vw - 340px)/6)
}

.video-card-main[data-v-76a466a3] {
    position: relative
}

.video-card-main .poster[data-v-76a466a3] {
    position: relative;
    min-height: 184px;
    height: calc((100vw - 340px)/6*345/247);
    border-radius: 4px;
    background-color: #eaeaea;
    background-size: cover;
    background-position: 50%;
    background-repeat: no-repeat;
    cursor: pointer;
    overflow: hidden
}

.video-card-main .poster .duration[data-v-76a466a3] {
    position: absolute;
    right: 8px;
    bottom: 9px;
    min-width: 38px;
    padding: 0 8px;
    height: 24px;
    background: rgba(0,0,0,.5);
    border-radius: 16px;
    font-size: 14px;
    font-weight: 500;
    text-align: center;
    color: #fff;
    line-height: 24px
}

.video-card-main .poster[data-v-76a466a3]:after {
    position: absolute;
    left: 0;
    right: 0;
    top: 0;
    bottom: 0;
    margin: auto;
    content: "";
    width: 2.60417vw;
    height: 2.60417vw;
    min-width: 40px;
    min-height: 40px;
    max-width: 50px;
    max-height: 50px;
    /* background-image: url(../img/play-icon.bad1c3cd.svg); */
    background-size: 100% 100%;
    background-position: 50%;
    background-repeat: no-repeat;
    opacity: 0;
    will-change: transform;
    transform: scale(1.5) translateZ(0);
    transition: transform .15s ease-in-out
}

.video-card-main .poster[data-v-76a466a3]:hover:before {
    opacity: 1
}

.video-card-main .poster[data-v-76a466a3]:hover:after {
    opacity: 1;
    background-size: 90% 90%;
    transform: scale(1) translateZ(0)
}

.video-card-main .info[data-v-76a466a3] {
    position: relative;
    width: 100%;
    height: 24px;
    margin-top: 3px;
    display: flex;
    align-items: flex-end;
    justify-content: space-between
}

.video-card-main .info-avatar[data-v-76a466a3] {
    cursor: pointer;
    margin-left: 14px;
    margin-right: 5px;
    display: inline-flex;
    align-items: flex-end;
    font-size: 14px;
    font-weight: 500;
    color: #222;
    line-height: 24px;
    overflow: hidden;
    text-overflow: ellipsis;
    white-space: nowrap;
    transition: color .15s ease-in-out
}

.video-card-main .info-avatar[data-v-76a466a3]:hover {
    color: #f50
}

.video-card-main .info-avatar .video-avatar[data-v-76a466a3] {
    width: 40px;
    height: 40px;
    border-radius: 50%;
    border: 2px solid #f5f5f5;
    box-sizing: border-box
}

.video-card-main .info-avatar span[data-v-76a466a3] {
    margin-left: 10px;
    overflow: hidden;
    text-overflow: ellipsis;
    white-space: nowrap
}

.video-card-main .info-like[data-v-76a466a3] {
    font-size: 14px;
    font-weight: 500;
    color: #c6c6c6;
    line-height: 24px;
    overflow: hidden;
    text-overflow: ellipsis;
    white-space: nowrap
}

.video-card-main .info-like[data-v-76a466a3]:before {
    content: "";
    display: inline-block;
    width: 14px;
    height: 14px;
    /* background-image: url(../img/like-normal.970e553f.svg); */
    background-size: 100% 100%;
    vertical-align: -2px;
    margin-right: 2px
}

.video-card-desc[data-v-76a466a3] {
    height: 44px;
    font-size: 16px;
    font-weight: 500;
    color: #222;
    line-height: 22px;
    margin-top: 10px;
    transition: color .15s ease-in-out;
    text-overflow: -o-ellipsis-lastline;
    overflow: hidden;
    text-overflow: ellipsis;
    display: -webkit-box;
    -webkit-line-clamp: 2;
    line-clamp: 2;
    -webkit-box-orient: vertical
}

.video-card-desc[data-v-76a466a3]:hover {
    color: #f50
}

.horizontal[data-v-76a466a3] {
    min-width: 204px;
    width: calc((100vw - 316px)/4)
}

.horizontal .video-card-main .poster[data-v-76a466a3] {
    min-height: 115px;
    height: calc((100vw - 316px)/4*211/376)
}

.scroll-list-flex[data-v-ac3b1c9a] {
    display: flex;
    flex-wrap: wrap
}

.spinning[data-v-ac3b1c9a] {
    height: 10.416666666666668vw;
    line-height: 10.416666666666668vw;
    text-align: center;
    color: #999
}

.skeleton[data-v-d0c9e646] {
    background: -webkit-gradient(linear,left top,right top,color-stop(25%,#f2f2f2),color-stop(37%,#e5e5e5),color-stop(63%,#f2f2f2));
    background: linear-gradient(90deg,#f2f2f2 25%,#e5e5e5 37%,#f2f2f2 63%);
    -webkit-animation: skeleton-loading-data-v-d0c9e646 1.4s ease infinite;
    animation: skeleton-loading-data-v-d0c9e646 1.4s ease infinite;
    background-size: 400% 100%;
    display: inline-block
}

.circle[data-v-d0c9e646] {
    border-radius: 50%
}

@-webkit-keyframes skeleton-loading-data-v-d0c9e646 {
    0% {
        background-position: 100% 50%
    }

    to {
        background-position: 0 50%
    }
}

@keyframes skeleton-loading-data-v-d0c9e646 {
    0% {
        background-position: 100% 50%
    }

    to {
        background-position: 0 50%
    }
}

.video-card-skeleton[data-v-1e4e6776] {
    min-width: 132px;
    width: calc((100vw - 340px)/6)
}

.video-card-skeleton-main .poster[data-v-1e4e6776] {
    position: relative;
    min-height: 184px;
    height: calc((100vw - 340px)/6*345/247);
    border-radius: 4px;
    background-color: #eaeaea
}

.video-card-skeleton-main .info[data-v-1e4e6776] {
    position: relative;
    width: 100%;
    height: 24px;
    margin-top: 3px;
    display: flex;
    align-items: flex-end;
    justify-content: space-between
}

.video-card-skeleton-main .info-avatar[data-v-1e4e6776] {
    margin-left: 14px;
    margin-right: 5px;
    display: inline-flex;
    align-items: flex-end;
    line-height: 24px
}

.video-card-skeleton-main .info-avatar img[data-v-1e4e6776] {
    width: 40px;
    height: 40px;
    border-radius: 50%;
    border: 2px solid #f5f5f5;
    box-sizing: border-box
}

.video-card-skeleton-main .info-avatar span[data-v-1e4e6776] {
    width: 72px;
    height: 22px;
    margin-left: 10px;
    border-radius: 4px;
    background-color: #eaeaea
}

.video-card-skeleton-main .info-like[data-v-1e4e6776] {
    color: #c6c6c6;
    line-height: 24px
}

.video-card-skeleton-desc[data-v-1e4e6776] {
    height: 44px;
    line-height: 22px;
    margin-top: 10px;
    border-radius: 4px;
    background-color: #eaeaea
}

.horizontal[data-v-1e4e6776] {
    min-width: 204px;
    width: calc((100vw - 316px)/4)
}

.horizontal .video-card-skeleton-main .poster[data-v-1e4e6776] {
    min-height: 115px;
    height: calc((100vw - 316px)/4*211/376)
}


</style>