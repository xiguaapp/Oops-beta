<template>
  <div class="huiyuan_box color_1 fl">
  <div class="huiyuan" style=" background: -prefix-linear-zgradient(to bottom, #000000, #736a6a, #525252); background: linear-gradient(to bottom, #000000, #736a6a, #525252); ">
    <p class="zks">
    <div class="huiyuan_tou fl"><img src="../../assets/images/sc_index_case_r11_c2.jpg" /></div>
  
    <span class="huiyuan_top">
      <el-steps :active="active" finish-status="success">
      <el-step title="v1"></el-step>
      <el-step title="v2"></el-step>
      <el-step title="v3"></el-step>
      <el-step title="v4"></el-step>
      <el-step title="v5"></el-step>
      <el-step title="v6"></el-step>
      <el-step title="V7"></el-step>
      </el-steps>
      <i>V2</i><b>NO：2252155875464</b> </span>
    </p>  
    <span>
    <div class="waic progress">
    </div>
    </span>
    <p><sub class="fl"><span class="huiyuan_shengji">升级</span><a href="chongzhi.html">在获取40成长值升级为铂金会员</a></sub> </p>
  </div>
  <div class="fenge"></div>

  <div class="menus fl">
    <ul>
      <li> <a href="details.html"><img src="../../assets/images/ico10.png"><span>等级权益</span></a> </li>
      <li> <a href="jifen_ye.html"><img src="../../assets/images/ico11.png"><span>积分余额</span></a> </li>
      <li> <a href="/detail"> <img src="../../assets/images/ico12.png"> <span>关于我们</span> </a> </li>
      <li> <a href="liquanbao.html"> <img src="../../assets/images/ico12.2.png"> <span>会员礼券包</span> </a> </li>
    </ul>
  </div>
  <div class="fenge"></div>

  <div class="gr_menu">
    <ul>
      <li><a href="qd/index.html"><b>&nbsp;</b><i>签到有礼</i></a></li>
      <li><a href="jifen.html"><b>&nbsp;</b><i>积分商城</i></a></li>
      <li><a href="shangcheng.html"><b>&nbsp;</b><i>热门精选</i></a></li>
      <li><a href="shangcheng.html"><b>&nbsp;</b><i>今日推荐</i></a></li>
      <li><a href="wdsc.html"><b>&nbsp;</b><i>我的收藏</i></a></li>
      <li><a href="chongzhi.html"><b>&nbsp;</b><i>在线充值</i></a></li>
      <li><a href="wddd.html"><b>&nbsp;</b><i>我的订单</i></a></li>
    </ul>
  </div>
<div class="fenge"></div>
<div class="cuzhi fl"><a href="chongzhi.html"><img src="../../assets/images/20190322133623_r2_c1.jpg"></a></div>

<div class="bottom_center_box">
  <ul>
    <li><a href="/member"><img src="../../assets/images/sc_index_bottom_r1_c15.jpg"><span>会员</span></a></li>
    <li><a href="/"><img src="../../assets/images/sc_index_bottom_r1_c6.jpg"><span>返回首页</span></a></li>
    <li><a href="/prepaid"><img src="../../assets/images/sc_index_bottom_r1_c1.jpg"><span>会员充值</span></a></li>
    <li><a href="/push"><img src="../../assets/images/sc_index_bottom_r1_c16.jpg"><span>热门推送</span></a></li>
  </ul>
</div>
  </div>
</template>

<script>
// import $ from 'jquery'
// import zhang from './js/jquery-progress.js'
// Vue.prototype.zhang=zhang

export default {  
 data() {
      return {
        customColor: '#409eff',
        active: 1,
      };
    },
}

// $(function(){
//   alert("进来了")
// 	var geshu = $(".djwai").children(".dengji").length;
//     // alert(geshu);
// 	var wid = $(".djwai").width()/geshu/2;
// 	// alert(wid);
// 	var widt = wid + "px";
// 	// alert(widt);
// 	$(".xianpa").css({"padding-left":widt,"padding-right":widt});
// 	$(".yixif").css({"padding-left":widt,"padding-right":widt});
// });
// $(".progress").startProgress({
//  "nodes":[
// 			{"name":"活力会员","money":0},
// 			 {"name":"黄金会员","money":100},
// 			  {"name":"铂金会员","money":300},
// 			   {"name":"钻石会员","money":500},
// 				{"name":"至尊会员","money":1000}
// 		  ],
//   "hasPay":260
// })

</script>

<style scoped>
/* .huiyuan {
    width: 96%;
    margin-left: 0%;
    float: left;
    border-radius: .5em;
    padding: 2% 2%;
    background-position: center center;
    background-repeat: no-repeat;
    background-size: 110%;
}
.huiyuan_tou {
    width: 17%;
    margin-left: 42%;
    border-radius: 50%;
    margin-top: 0%;
    height: 0px;
    padding-bottom: 17%;
    position: relative;
    overflow: hidden;
}
.huiyuan .huiyuan_top {
     float: left;
    margin-top: -10%;
    width: 100%;
    display: block;
    background-color: #000;
    border-radius: 1.5em;
    background-position: center center;
    background-repeat: no-repeat;
    background-size: 105%;
    background-image: url(/img/1111.dd93dad4.jpg);
    padding-top: 39%;
    text-shadow: 0px 0px 1px #9B7A45;
}

.huiyuan i {
    float: left;
    width: 100%;
    color: #FFF;
    line-height: 2em;
    text-align: center;
    font-weight: 600;
}
.huiyuan b {
    float: left;
    width: 100%;
    text-align: left;
    color: #FFF;
    line-height: 2em;
    font-size: 0.9em;
    text-align: center;
}
.huiyuan p {
    color: #FFF;
    line-height: 2em;
    float: left;
    width: 100%;
    padding-bottom: 2%; */
@charset "utf-8";



.aui-navBar {
    height: 44px;
    position: relative;
    display: -webkit-box;
    display: -webkit-flex;
    display: -ms-flexbox;
    display: flex;
    z-index: 1002;
    background: #fff;
}

.menus {
    width: 100%;
    margin: 0 auto;
    padding-top: 5%;
    background: #fff;
}
.gr_menu ul li b {
    width: 100%;
    background-position: center center;
    background-size: 27px;
    background-repeat: no-repeat;
    float: left;
    line-height: 2.9em;
}
.huiyuan[data-v-8c97cc72] {
    width: 100%;
    margin-left: 0%;
    float: left;
    border-radius: .5em;
    padding: 2% 2%;
    background-position: center center;
    background-repeat: no-repeat;
    background-size: 110%;
}

.gr_menu {
    width: 100%;
    float: left;
    overflow: hidden;
}
.menus ul li img {
    width: 35%;
    display: block;
    margin: 0 auto;
}


.gr_menu ul li i {
    font-style: normal;
    width: 100%;
    text-align: center;
    line-height: 5.4em;
    font-size: .9em;
    float: left;
    color: #616161;
}

.gr_menu ul li a {
    float: left;
    width: 100%;
}





.menus ul li {
    width: 25%;
    float: left;
    text-align: center;
}

    .zks{
           display: block;
    margin-top: 4%;
    }
/* CSS Document */
body, div, dl, dt, dd, ul, ol, li, h1, h2, h3, h4, h5, h6, pre, form, fieldset, input, textarea, p, blockquote, th, td, font { padding: 0; margin: 0; }
fieldset, img { border: 0; vertical-align: top; }
table { border-collapse: collapse; border-spacing: 0; }
h1, h2, h3, h4, h5, h6 { font-size: 100%; }
ol, ul, li, dl, dt, dd { list-style: none; }
a { color: #000; text-decoration: none; }
a:link, a:visited { text-decoration: none; }
a:hover { text-decoration: none; }
.red { color: #F00; }
.yellow { color: #ffb138; }
.fl { float: left; }
.fr { float: right; }
.clr { clear: both; }
.mright { margin-right: 20px; }
.blank { height: 20px; font-size: 0; line-height: 0; clear: both; overflow: hidden; }
body, td, th { font-family: "Microsoft YaHei", "微软雅黑", \5FAE\8F6F\96C5\9ED1; }
input { outline: none; }
i { font-style: normal; }
b { font-weight: normal; }
@font-face { font-family: '微软雅黑';   /*字体名称*/ /*字体路径*/ }
.main { width: 100%; overflow: hidden; margin: 0px auto; }
.fenge { width: 100%; height: 1em; overflow: hidden; margin: 0px auto; }
.box { width: 1200px; height: auto; margin: 0px auto; display: block; }
.box_bg { width: 100%; height: auto; margin: 0px auto; background-color: #FAFAFA; }
/* .box_bg_2 { width: 100%; height: auto; margin: 0px auto; background-image: url(../../assets/images/index_r7_c1.jpg); background-position: center center; background-size: 100%; background-repeat: no-repeat; height: 250px; } */
/* top */
.top_box { width: 100%; }
.top_box img { width: 100%; }
/* menu */
.menu { width: 100%; height: auto; overflow: hidden; margin: 0px auto; }
.menu ul { }
.menu ul li { float: left; width: 20%; line-height: 2em; text-align: center; }
.menu ul li img { width: 60%; height: auto; }
.menu ul li span { color: #585858; display: block; width: 100%; white-space: nowrap; float: left; font-size: 0.9em; }
/* 首页产品图展示 */
.product_box { width: 100%; overflow: hidden; background-color: #f5f5f5; }
.share_title { width: 100%; height: auto; text-align: center; font-size: 1.2em; color: #454545; padding-top: 5%; }
.share_title span { color: #B5B5B5; font-size: 0.75em; text-align: center; display: block; width: 100%; line-height: 2em; }
.product { width: 96%; margin: 0px auto; padding-bottom: 10%; min-height: 100px; overflow: hidden; }
.product_2 { width: 96%; margin: 0px auto; padding-bottom: 0%; min-height: 100px; overflow: hidden; }
.product ul { }
.product ul li { float: left; width: 46%; overflow: hidden; background-color: #FFF; margin: 2% 2%; }
.product ul li img { width: 100%; }
.product ul li span { float: left; width: 100%; text-align: center; line-height: 2em; font-size: 1em; }
.more { width: 40%; margin: 0px auto; line-height: 2.5em; font-size: 1em; border: 1px solid #CCC; text-align: center; border-radius: 1em; margin-bottom: 10%; }
/* 首页案例展示 */
.case_box { width: 100%; overflow: hidden; background-color: #fff; }
/* 首页关于我们 */
.about_box { width: 100%; overflow: hidden; background-color: #f5f5f5; }
.about { width: 96%; margin: 0px auto; min-height: 700px; overflow: hidden; padding-bottom: 60px; }
.about img { width: 100%; }
/* bottom */
.bottom_center_box { width: 100%; height: 60px; overflow: hidden; position: fixed; bottom: 0px; z-index: 9; background-color: #FFF; border-top: 1px solid #CCC; }
.bottom_center_box ul { }
.bottom_center_box ul li a { display: block; outline: none; }
.bottom_center_box ul li { float: left; width: 25%; text-align: center; }
.bottom_center_box ul li img { width: 50%; height: auto; }
.bottom_center_box ul li span { color: #585858; display: block; width: 100%; white-space: nowrap; float: left; font-size: 0.9em; }
.page { width: 100%; margin-bottom: 60px; text-align: center; line-height: 2em; font-size: 0.9em; }
.news { width: 96%; overflow: hidden; margin: 0 auto; }
.news ul { }
.news ul li { float: left; margin-top: 3%; width: 100%; min-height: 80px; overflow: hidden; color: #5A5A5A; border-bottom: 1px dotted #dbd4cd; padding-bottom: 10px; }
.news ul li a { display: block; }
.news ul li a i { font-style: normal; font-size: 0.8em; padding-top: 5px; color: #666666; text-decoration: none; width: 66%; text-overflow: ellipsis; display: -webkit-box; -webkit-line-clamp: 2; -webkit-box-orient: vertical; overflow: hidden; float: left; padding-left: 2%; text-indent: 2em; line-height: 2em; }
.news ul li a span { display: block; float: left; width: 30%; border: solid 1px #ccc; overflow: hidden; }
.news ul li a span img { width: 100%; }
.news ul li a b { font-style: normal; width: 66%; text-align: left; text-overflow: ellipsis; display: -webkit-box; -webkit-line-clamp: 1; -webkit-box-orient: vertical; float: left; font-weight: normal; padding-left: 2%; font-size: 1em; overflow: hidden; }
/*---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------*/
.color_1 { background-color: #ececee; }
.color_2 { background-color: #fff; }
.color_3 { color: #F00; }
.huiyuan_box { width: 100%; }
.huiyuan_box2 { width: 96%; margin-left: 2%; background-color: #fff; height: -webkit-fill-available; }
.huiyuan { width: 96%; margin-left: 0%; float: left; border-radius: .5em; padding: 2% 2%; background-position: center center; background-repeat: no-repeat; background-size: 110%; }
.huiyuan_tou { width: 17%; margin-left: 42%; border-radius: 50%; margin-top: 0%; height: 0px; padding-bottom: 17%; position: relative; overflow: hidden; }
.huiyuan_tou img { width: 100%; height: 100%; position: absolute; }
.huiyuan span { }
.huiyuan .huiyuan_top { 
  float: left; margin-top: -8%; width: 100%; display: block; background-color: #000; border-radius: .5em; background-position: center center; background-repeat: no-repeat; background-size: 100%; background-image: url(../../assets/images/1111.jpg); padding-top: 28%; text-shadow: 0px 0px 1px #9B7A45; }
.huiyuan i { float: left; width: 100%; color: #FFF; line-height: 2em; text-align: center; font-weight: 600; }
.huiyuan b { float: left; width: 100%; text-align: left; color: #FFF; line-height: 2em; font-size: 0.9em; text-align: center; }
.huiyuan p { color: #FFF; line-height: 2em; float: left; width: 100%; padding-bottom: 2%; }
.huiyuan sub { width: 94%; text-align: left; color: #9B7B48; border-radius: 5em; margin-left: 3%; }
.huiyuan .huiyuan_shengji { width: 40px; margin-right: 1%; background: -prefix-linear-zgradient(top, #FC544B, #ff655b, #fb8a7c); background: linear-gradient(to right, #e3b652, #F0D069, #F7DC8B); display: block; float: left; margin-left: 5%; border-radius: 0.5em; line-height: 1.8em; text-align: center; margin-top: 1.2%; }
.huiyuan sub a { color: #4b3b21; }
.huiyuan small { width: 100%; text-align: right; line-height: 2em; color: #FFF; float: left; }
.huiyuan h1 { width: 100%; float: left; text-align: center; font-size: 1.3em; color: #FFF; line-height: 3em; }
.ljfh { width: 100%; float: left; text-align: center; font-size: 1.2em; color: #000; line-height: 3em; background-color: #FFF; width: 90%; margin-left: 3%; padding: 2% 2%; }
.ljfh span { float: left; width: 100%; display: block; font-size: 1.1em; line-height: 2em; color: #F00; }
.huiyuan_chongzhi { width: 96%; margin-left: 0%; float: left; border-radius: .5em; padding: 2% 2%; background-position: center center; background-repeat: no-repeat; background-size: 110%; box-shadow: 0px 9px 19px 2px #e9e9e9; -moz-box-shadow: 0px 9px 19px 2px #e9e9e9; -webkit-box-shadow: 0px 9px 19px 2px #e9e9e9; position: relative; z-index: 1; }
.huiyuan_chongzhi_tou { width: 26%; margin-left: 37%; border-radius: 50%; margin-top: 7%; height: 0px; padding-bottom: 26%; position: relative; overflow: hidden; box-shadow: 0px 9px 19px 2px #e9e9e9; -moz-box-shadow: 0px 9px 19px 2px #e9e9e9; -webkit-box-shadow: 0px 0px 19px 7px #e9e9e9; position: relative; z-index: 1; }
.huiyuan_chongzhi_tou img { width: 100%; height: 100%; position: absolute; }
.huiyuan_chongzhi i { float: left; width: 100%; color: #000; line-height: 3em; text-align: center; }
.huiyuan_chongzhi b { float: left; width: 100%; text-align: left; color: #000; font-size: 1.8em; text-align: center; }
/*个人会员卡主界面*/
.huiyuan_jl { background-color: #FFF; width: 100%; float: left; }
.huiyuan_jilu { width: 96%; padding-left: 2%; padding-right: 2%; margin-top: 20px; }
.huiyuan_jilu li { width: 25%; text-align: center; float: left; position: relative; }
.huiyuan_jilu li a img { height: 30px; margin: 0 auto; }
.huiyuan_jilu li a h1 { color: #616161; font-size: 0.9em; white-space: nowrap; line-height: 2em; }
.huiyuan_jilu li span { width: 15px; height: 15px; line-height: 15px; display: block; font-size: 0.7em; border: 1px solid #ff9903; border-radius: 5em; text-align: center; position: absolute; color: #FF5722; top: 0%; background-color: #fff; right: 25%; z-index: 1; }
.gr_menu { width: 99.5%; float: left; overflow: hidden; padding-left: 0.5%; }
.gr_menu ul { }
.gr_menu ul li { width: 32.5%; float: left; text-align: center; margin-bottom: 0.5%; background-color: #FFF; margin-left: 0.5%; }
.gr_menu ul li a { float: left; width: 100%; }
.gr_menu ul li b { width: 100%; background-position: center center; background-size: 27px; background-repeat: no-repeat; float: left; line-height: 2.9em; }
.gr_menu ul li:nth-of-type(1) b { background-image: url(../../assets/images/ico1.png); }
.gr_menu ul li:nth-of-type(2) b { background-image: url(../../assets/images/ico2.png); }
.gr_menu ul li:nth-of-type(3) b { background-image: url(../../assets/images/ico3.png); }
.gr_menu ul li:nth-of-type(4) b { background-image: url(../../assets/images/ico8.png); }
.gr_menu ul li:nth-of-type(5) b { background-image: url(../../assets/images/ico5.png); }
.gr_menu ul li:nth-of-type(6) b { background-image: url(../../assets/images/ico6.png); }
.gr_menu ul li:nth-of-type(7) b { background-image: url(../../assets/images/ico7.png); }
.gr_menu ul li:nth-of-type(8) b { background-image: url(../../assets/images/ico8.png); }
.gr_menu ul li:nth-of-type(9) b { background-image: url(../../assets/images/ico9.png); }


</style>