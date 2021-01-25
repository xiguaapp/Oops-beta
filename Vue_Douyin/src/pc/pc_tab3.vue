<template>
    <div>
        <div class="pay-wrap">
            <div>
               
                <el-dialog title="去支付" :visible.sync="dialogTableVisible" >
                    <div style="text-align: center;">
                         <!-- <form id="payForm" method="get" action="/alipay/pps" aria-label=9999> -->
                            <!-- <div style=" font-size: 18px;">产品编号:
                              <input name="orderid" value="1610253562105872241" style="color: #ff5000;">
                            </div>
                            
                            <div style=" font-size: 18px;">产品名称:
                              <input name="orderid1" value="1610253562105872241" style="color: #ff5000;">
                            </div>
                            
                            <div style=" font-size: 18px;">购买个数:
                              <input name="orderid2" value="1610253562105872241" style="color: #ff5000;">
                            </div>

                            <div style=" font-size: 18px;">产品价格:
                              <input name="orderid" :value="money" style="color: #ff5000;">
                            </div>
     
      -->
                         <div></div>
                         </br>
                         <div>
                             <span class="checked">
                                 <input type="submit" @click="hel" value="前往支付宝进行支付">
                                </span></div>
                            <!-- </form> -->
                    </div>     
                 </el-dialog>
    
            </div>
	<ul>
		<li>
			<div class="item-name">充值账号</div>
			<div class="fake-login">
				<div class="user-info"></div>
				<div class="checkout">[切换账号]</div>
			</div>
		</li>
		<li class="money-cell"><span class="item-name item-amount">充值金额</span>
			<div class="money-desc">
				<p class="money-desc-bi-default">充值比例：1 元 = 10 R币</p>
			</div>
			<div>
				<div class="recharge">
					<div v-for="item in list " @click="liClick(item.money,item.R,item.id)" class="recharge-gear payItem" data-bank="{&quot;fen&quot;:3000,&quot;kscoin&quot;:300}">
                        <span
						 class="pay-yuan">{{item.money}}元</span> <span class="kscoin">{{item.R}}R币</span>
                    </div>
				</div>
			</div>
		</li>
		<li>
			<div class="private"><span class="serve-policy"><i class="check-icon checked"></i> 同意 <a href="https://www.kuaishou.com/protocol.html"
					 target="_blank">服务条款及隐私政策</a></span></div>
		</li>
		<li>
			<div><span class="go-button go-pay go-pay-checked"></span></div>
		</li>
	</ul>
</div>

    </div>
</template>

<script>
export default {
  data(){
    return{
      currentIndex:'',
      money:'',
      R:'',
      id:'',
      dialogTableVisible :false,
      list:[{
          id:1,
          R:100,
          money:10
      },
      {
          id:2,
          R:200,
          money:20
      },
      {
          id:3,
          R:200,
          money:20
      },
      {
          id:4,
          R:300,
          money:30
      },
      {
          id:5,
          R:400,
          money:40
      },
      {
          id:6,
          R:500,
          money:50
      }
      ]
    }
  },
    methods:{
        liClick(money,R,id){
            this.money=money;
            this.R=R;
            this.dialogTableVisible=true;
            alert("id"+id)
            this.id=id;

 },
 hel(){
    //  alert("点击了")
     axios.post("http://localhost:9999/alipay/alipayNotifyNotice").then(function (resp){
                 alert("...."+resp.data.result)
                // Pthis.books=resp.data;
                /*alert("...."+resp.data.authorname)
                // // //打印日志*/
                console.log(resp.data);
    })
    // alert("12321")
 }
    }
}

</script>

<style>
a,b,body,button,dd,div,dl,dt,em,footer,h1,h2,h3,h4,header,html,i,img,input,li,ol,p,select,span,strong,textarea,ul {
    margin: 0;
    padding: 0;
    font: inherit;
    font-size: 100%;
    vertical-align: baseline;
    background-repeat: no-repeat;
    -webkit-tap-highlight-color: rgba(0,0,0,0)
}

body {
    width: 100%;
    min-width: 1200px;
    line-height: 1;
    font-size: 12px;
    font-family: PingFang SC,Helvetica Neue,Helvetica,Arial,Microsoft YaHei,sans-serif;
    -webkit-overflow-scrolling: touch
}

li,ol,ul {
    list-style: none
}

a {
    background-color: rgba(0,0,0,0);
    -webkit-text-decoration-skip: objects;
    text-decoration: none
}

a:active,a:hover {
    outline-width: 0
}

b,em,i,strong {
    font-style: normal;
    font-weight: 400
}

button,input,textarea {
    -webkit-appearance: none
}

button,input,textarea {
    background: rgba(0,0,0,0);
    border-radius: 0;
    -webkit-box-shadow: none;
    box-shadow: none
}

button {
    border: none
}

input::-webkit-input-placeholder,textarea::-webkit-input-placeholder {
    color: #d1cece
}

input,select,textarea {
    resize: none;
    border: none;
    outline: none;
    -webkit-box-shadow: none;
    box-shadow: none;
    border-radius: 0
}

img {
    border-style: none
}

textarea {
    overflow: auto
}

::-webkit-input-placeholder {
    color: inherit;
    opacity: .54
}

.qrlogin .close {
    background: url(/static/i/pages/account/qrlogin_mobilecode.png)
}

.qrlogin .qrpanel .helpicon {
    background: url(/static/i/pages/account/qrlogin_scan.png)
}

.qrlogin .userpanel .tip1 {
    color: rgba(51,0,51,0) 3
}

.hide {
    display: none!important
}

.show {
    display: block!important
}

.icon-layer-close {
    color: #5e5e5e
}

.pos-abs {
    position: absolute
}

.pos-rel {
    position: relative
}

.ie-tip {
    position: absolute;
    top: 0;
    left: 0;
    right: 0;
    bottom: 0;
    margin: auto;
    width: 500px;
    height: 300px;
    line-height: 300px;
    text-align: center;
    background: url(/static/kuaishou/static/img/ie-up.png) center 15%;
    background-repeat: no-repeat
}

.ie-tip a {
    color: #006fe1
}

.com-main-wrap {
    width: 1200px;
    margin: 0 auto;
    min-height: 600px
}

.com-main-wrap .com-main {
    width: 960px;
    padding: 0 50px;
    margin: 0 auto
}

.com-tip-wrap {
    position: fixed;
    width: 100%;
    height: 100%;
    background: rgba(0,0,0,.3);
    top: 0;
    left: 0;
    display: none;
    z-index: 100
}

.com-tip-wrap .com-tip {
    height: 320px;
    width: 430px;
    margin: auto;
    position: absolute;
    left: 0;
    top: 0;
    right: 0;
    bottom: 0;
    background: #fff
}

.com-tip-wrap .com-tip .tip-title {
    height: 60px;
    line-height: 60px;
    text-align: center;
    font-size: 18px;
    background: #f6f6f6;
    position: relative
}

.com-tip-wrap .com-tip .tip-title .tip-title-inner {
    display: inline-block
}

.com-tip-wrap .com-tip .tip-title i {
    position: absolute;
    right: 20px;
    cursor: pointer
}

.com-tip-wrap .com-tip .tip-type {
    color: red
}

.com-tip-wrap .com-tip .normal-type,.com-tip-wrap .com-tip .tip-type {
    margin-top: 35px;
    height: 25px;
    line-height: 25px;
    text-align: center;
    font-size: 18px
}

.com-tip-wrap .com-tip .normal-type {
    color: #303030
}

.com-tip-wrap .com-tip .tip-desc {
    margin: 25px 35px;
    height: 30px;
    line-height: 30px;
    text-align: center;
    font-size: 14px;
    color: #303030
}

.com-tip-wrap .com-tip .tip-btn-wrap {
    margin: 50px auto auto;
    text-align: center
}

.com-tip-wrap .com-tip .tip-btn {
    display: none;
    width: 160px;
    height: 50px;
    line-height: 50px;
    background: #ff5000;
    color: #fff;
    text-align: center;
    border-radius: 25px;
    font-size: 16px;
    cursor: pointer
}

.com-tip-wrap .com-tip .tip-btn.left,.com-tip-wrap .com-tip .tip-btn.tip-btn-left {
    background: #7089a8;
    margin-right: 20px
}

.com-ie-wrap {
    display: none;
    z-index: 90
}

.com-ie-wrap,.com-ie-wrap .ie-mask {
    position: fixed;
    width: 100%;
    height: 100%;
    top: 0;
    left: 0
}

.com-ie-wrap .ie-mask {
    background: #000;
    z-index: 95;
    filter: alpha(opacity=50)
}

.com-ie-wrap .com-tip {
    height: 300px;
    min-width: 460px;
    position: absolute;
    left: 300px;
    top: 50%;
    margin-top: -100px;
    right: 300px;
    bottom: 0;
    background: #fff;
    z-index: 100
}

.com-ie-wrap .com-tip .tip-title {
    height: 60px;
    line-height: 60px;
    text-align: center;
    font-size: 18px;
    background: #f6f6f6;
    position: relative
}

.com-ie-wrap .com-tip .tip-desc {
    margin: 90px 35px;
    height: 30px;
    line-height: 30px;
    text-align: center;
    font-size: 14px;
    color: #303030
}

.com-ie-wrap .com-tip .tip-desc a {
    display: block
}

.no-user-select {
    -webkit-user-select: none;
    -moz-user-select: none;
    -ms-user-select: none;
    user-select: none
}

.svelte-login .modal,.svelte-login .modal-background {
    z-index: 10
}

@-webkit-keyframes live {
    0% {
        background-position: 0 0
    }

    1.89% {
        background-position: -110px 0
    }

    3.77% {
        background-position: -220px 0
    }

    5.66% {
        background-position: -330px 0
    }

    7.55% {
        background-position: -440px 0
    }

    9.43% {
        background-position: -550px 0
    }

    11.32% {
        background-position: -660px 0
    }

    13.21% {
        background-position: -770px 0
    }

    15.09% {
        background-position: -880px 0
    }

    16.98% {
        background-position: -990px 0
    }

    18.87% {
        background-position: -1100px 0
    }

    20.75% {
        background-position: -1210px 0
    }

    22.64% {
        background-position: -1320px 0
    }

    24.53% {
        background-position: -1430px 0
    }

    26.42% {
        background-position: -1540px 0
    }

    28.30% {
        background-position: -1650px 0
    }

    30.19% {
        background-position: -1760px 0
    }

    32.08% {
        background-position: -1870px 0
    }

    33.96% {
        background-position: -1980px 0
    }

    35.85% {
        background-position: -2090px 0
    }

    37.74% {
        background-position: -2200px 0
    }

    39.62% {
        background-position: -2310px 0
    }

    41.51% {
        background-position: -2420px 0
    }

    43.40% {
        background-position: -2530px 0
    }

    45.28% {
        background-position: -2640px 0
    }

    47.17% {
        background-position: -2750px 0
    }

    49.06% {
        background-position: -2860px 0
    }

    50.94% {
        background-position: -2970px 0
    }

    52.83% {
        background-position: -3080px 0
    }

    54.72% {
        background-position: -3190px 0
    }

    56.60% {
        background-position: -3300px 0
    }

    58.49% {
        background-position: -3410px 0
    }

    60.38% {
        background-position: -3520px 0
    }

    62.26% {
        background-position: -3630px 0
    }

    64.15% {
        background-position: -3740px 0
    }

    66.04% {
        background-position: -3850px 0
    }

    67.92% {
        background-position: -3960px 0
    }

    69.81% {
        background-position: 0 -110px
    }

    71.70% {
        background-position: -110px -110px
    }

    73.58% {
        background-position: -220px -110px
    }

    75.47% {
        background-position: -330px -110px
    }

    77.36% {
        background-position: -440px -110px
    }

    79.25% {
        background-position: -550px -110px
    }

    81.13% {
        background-position: -660px -110px
    }

    83.02% {
        background-position: -770px -110px
    }

    84.91% {
        background-position: -880px -110px
    }

    86.79% {
        background-position: -990px -110px
    }

    88.68% {
        background-position: -1100px -110px
    }

    90.57% {
        background-position: -1210px -110px
    }

    92.45% {
        background-position: -1320px -110px
    }

    94.34% {
        background-position: -1430px -110px
    }

    96.23% {
        background-position: -1540px -110px
    }

    98.11% {
        background-position: -1650px -110px
    }
}

@keyframes live {
    0% {
        background-position: 0 0
    }

    1.89% {
        background-position: -110px 0
    }

    3.77% {
        background-position: -220px 0
    }

    5.66% {
        background-position: -330px 0
    }

    7.55% {
        background-position: -440px 0
    }

    9.43% {
        background-position: -550px 0
    }

    11.32% {
        background-position: -660px 0
    }

    13.21% {
        background-position: -770px 0
    }

    15.09% {
        background-position: -880px 0
    }

    16.98% {
        background-position: -990px 0
    }

    18.87% {
        background-position: -1100px 0
    }

    20.75% {
        background-position: -1210px 0
    }

    22.64% {
        background-position: -1320px 0
    }

    24.53% {
        background-position: -1430px 0
    }

    26.42% {
        background-position: -1540px 0
    }

    28.30% {
        background-position: -1650px 0
    }

    30.19% {
        background-position: -1760px 0
    }

    32.08% {
        background-position: -1870px 0
    }

    33.96% {
        background-position: -1980px 0
    }

    35.85% {
        background-position: -2090px 0
    }

    37.74% {
        background-position: -2200px 0
    }

    39.62% {
        background-position: -2310px 0
    }

    41.51% {
        background-position: -2420px 0
    }

    43.40% {
        background-position: -2530px 0
    }

    45.28% {
        background-position: -2640px 0
    }

    47.17% {
        background-position: -2750px 0
    }

    49.06% {
        background-position: -2860px 0
    }

    50.94% {
        background-position: -2970px 0
    }

    52.83% {
        background-position: -3080px 0
    }

    54.72% {
        background-position: -3190px 0
    }

    56.60% {
        background-position: -3300px 0
    }

    58.49% {
        background-position: -3410px 0
    }

    60.38% {
        background-position: -3520px 0
    }

    62.26% {
        background-position: -3630px 0
    }

    64.15% {
        background-position: -3740px 0
    }

    66.04% {
        background-position: -3850px 0
    }

    67.92% {
        background-position: -3960px 0
    }

    69.81% {
        background-position: 0 -110px
    }

    71.70% {
        background-position: -110px -110px
    }

    73.58% {
        background-position: -220px -110px
    }

    75.47% {
        background-position: -330px -110px
    }

    77.36% {
        background-position: -440px -110px
    }

    79.25% {
        background-position: -550px -110px
    }

    81.13% {
        background-position: -660px -110px
    }

    83.02% {
        background-position: -770px -110px
    }

    84.91% {
        background-position: -880px -110px
    }

    86.79% {
        background-position: -990px -110px
    }

    88.68% {
        background-position: -1100px -110px
    }

    90.57% {
        background-position: -1210px -110px
    }

    92.45% {
        background-position: -1320px -110px
    }

    94.34% {
        background-position: -1430px -110px
    }

    96.23% {
        background-position: -1540px -110px
    }

    98.11% {
        background-position: -1650px -110px
    }
}

@-webkit-keyframes upload {
    0% {
        background-position: 0 0
    }

    to {
        background-position: -5610px 0
    }
}

@keyframes upload {
    0% {
        background-position: 0 0
    }

    to {
        background-position: -5610px 0
    }
}

.com-header-wrap {
    min-width: 1200px;
    height: 120px;
    font-size: 14px;
    border-bottom: 1px solid #f1f1f1
}

.com-header-wrap .com-header {
    width: 1200px;
    height: 100%;
    margin: 0 auto;
    position: relative
}

.com-header-wrap .com-header .header-logo {
    position: absolute;
    display: block;
    cursor: pointer;
    left: 65px;
    height: 48px;
    top: 36px;
    z-index: 1
}

.com-header-wrap .com-header .header-logo .logo-bg {
    width: 48px;
    height: 48px;
    margin-right: 10px;
    display: inline-block;
    background: url(//ali.static.yximgs.com/static/ks-mcn/img/kwai_icon.5bca665f.svg) no-repeat 0 0;
    background-size: contain;
    background: 0 0\9;
    filter: progid:DXImageTransform.Microsoft.AlphaImageLoader(src="//ali.static.yximgs.com/static/ks-mcn/img/kwai_icon.5bca665f.svg",sizingMethod="scale")
}

.com-header-wrap .com-header .header-logo i {
    font-size: 32px;
    line-height: 48px;
    display: inline-block;
    vertical-align: top;
    color: #656464
}

.com-header-wrap .com-header .header-logo-new {
    position: absolute;
    display: block;
    cursor: pointer;
    left: 65px;
    top: 36px;
    z-index: 1;
    width: 131px;
    height: 48px;
    background: url(//static.yximgs.com/udata/pkg/fe/widgets_header_logo.4e8554cd.png) no-repeat 0 0;
    background-size: cover
}

.com-header-wrap .com-header .list {
    text-align: right;
    padding-right: 65px;
    position: relative;
    top: 40px
}

.com-header-wrap .com-header .list .item {
    display: inline-block;
    height: 40px;
    line-height: 40px;
    text-align: center;
    position: relative;
    margin-right: 35px
}

.com-header-wrap .com-header .list .item .nav {
    position: relative;
    display: inline-block;
    height: 100%;
    color: #5e5e5e
}

.com-header-wrap .com-header .list .item .nav.checked,.com-header-wrap .com-header .list .item .nav:hover {
    color: #303030;
    border-bottom: 3px solid #ff5000
}

.com-header-wrap .com-header .list .item .nav.m-l {
    margin-left: 20px
}

.com-header-wrap .com-header .list .item .nav .live-animation {
    background-image: url(//static.yximgs.com/udata/pkg/fe/hot_new.png);
    -webkit-animation: live 2.12s steps(1) 0s infinite normal none;
    animation: live 2.12s steps(1) 0s infinite normal none
}

.com-header-wrap .com-header .list .item .nav .live-animation,.com-header-wrap .com-header .list .item .nav .upload-animation {
    height: 110px;
    width: 110px;
    position: absolute;
    top: -60px;
    right: -66px;
    -webkit-transform-origin: 50%;
    -ms-transform-origin: 50%;
    transform-origin: 50%;
    -webkit-transform: scale(.5);
    -ms-transform: scale(.5);
    transform: scale(.5)
}

.com-header-wrap .com-header .list .item .nav .upload-animation {
    background-image: url(//static.yximgs.com/udata/pkg/fe/3.876a1807.png);
    -webkit-animation: upload 3.62s steps(51) 0s infinite normal none;
    animation: upload 3.62s steps(51) 0s infinite normal none
}

.com-header-wrap .com-header .list .item i {
    font-size: 12px;
    width: 20px;
    margin-left: -4px;
    cursor: pointer;
    color: #5e5e5e;
    display: inline-block
}

.com-header-wrap .com-header .list .item .down-item {
    display: none
}

.com-header-wrap .com-header .list .item.sub-menu {
    margin-right: 34px
}

.com-header-wrap .com-header .list .item.sub-menu .icon-nav-up {
    display: none
}

.com-header-wrap .com-header .list .item.sub-menu:hover .down-item {
    display: block
}

.com-header-wrap .com-header .list .item.sub-menu:hover .icon-nav-down {
    display: none
}

.com-header-wrap .com-header .list .item.sub-menu:hover .icon-nav-up {
    display: inline-block
}

.com-header-wrap .com-header .list .item.submenu:last-child,.com-header-wrap .com-header .list .item:last-child {
    margin-right: 0
}

.com-header-wrap .com-header .list .relative {
    position: relative
}

.com-header-wrap .com-header .list .down-item {
    position: absolute;
    width: 100px;
    right: -15px;
    top: 36px;
    z-index: 2;
    border: 1px solid #f1f1f1;
    -webkit-box-shadow: 0 2px 8px #f1f1f1 inset;
    box-shadow: inset 0 2px 8px #f1f1f1
}

.com-header-wrap .com-header .list .down-item li a {
    display: inline-block;
    line-height: 50px;
    width: 100%;
    color: #fff;
    text-align: center;
    height: 50px;
    background: #fff;
    color: #5e5e5e
}

.com-header-wrap .com-header .list .down-item li:hover>a {
    color: #303030;
    background: #f1f1f1
}

.com-header-wrap .com-header .photo {
    position: absolute;
    right: 0;
    height: 36px;
    width: 36px;
    border-radius: 18px;
    cursor: pointer;
    padding-bottom: 10px;
    top: 43px
}

.com-header-wrap .com-header .photo img {
    border: none;
    border-radius: 18px
}

.com-header-wrap .com-header .photo:hover .logout {
    display: block
}

.com-header-wrap .com-header .photo .logout {
    display: none;
    position: absolute;
    left: 50%;
    top: 100%;
    margin-left: -60px;
    width: 120px;
    height: 50px;
    line-height: 50px;
    text-align: center;
    font-size: 14px;
    color: #303030;
    cursor: pointer;
    border: 1px solid #f1f1f1;
    background-color: #fff;
    z-index: 10
}

.com-header-wrap .com-header .photo .logout:hover {
    display: block
}

.com-footer-wrap {
    min-width: 1200px;
    height: 100px;
    padding: 50px 0;
    background-color: #fcfcfc
}

.com-footer-wrap .com-footer {
    height: 100%;
    width: 960px;
    margin: 0 auto;
    position: relative;
    font-size: 12px
}

.com-footer-wrap .com-footer .list {
    height: 30px;
    line-height: 30px;
    text-align: center
}

.com-footer-wrap .com-footer .list .item {
    display: inline-block;
    width: 165px;
    text-align: center;
    color: #5e5e5e
}

.com-footer-wrap .com-footer .info-1,.com-footer-wrap .com-footer .info-2 {
    margin-top: 6px;
    text-align: center;
    line-height: 14px;
    color: #919191;
    font-size: 0
}

.com-footer-wrap .com-footer .info-1 a,.com-footer-wrap .com-footer .info-1 span,.com-footer-wrap .com-footer .info-2 a,.com-footer-wrap .com-footer .info-2 span {
    font-size: 12px
}

.com-footer-wrap .com-footer .info-1>span,.com-footer-wrap .com-footer .info-2>span {
    margin-right: 10px
}

.com-footer-wrap .com-footer .info-1 .police-icon,.com-footer-wrap .com-footer .info-2 .police-icon {
    display: inline-block;
    width: 18px;
    height: 18px;
    margin-right: 2px;
    background: url(//ali.static.yximgs.com/static/img/widgets/footer/img/police-9ecb5b55.png) no-repeat;
    background-size: 18px 18px;
    vertical-align: -4px
}

.com-footer-wrap .com-footer .info-1 .license-icon,.com-footer-wrap .com-footer .info-2 .license-icon {
    display: inline-block;
    width: 18px;
    height: 18px;
    margin-right: 2px;
    background: url(//ali.static.yximgs.com/static/img/widgets/footer/img/license-6ee34392.png) no-repeat;
    background-size: 18px 18px;
    vertical-align: -4px
}

.com-footer-wrap .com-footer .info-1 .police-link,.com-footer-wrap .com-footer .info-2 .police-link {
    margin-right: 10px;
    display: inline-block;
    color: #919191
}

.com-footer-wrap .com-footer .info-1 {
    margin-top: 16px
}

.com-footer-wrap .com-footer .info-1 span {
    margin-left: 10px
}

@font-face {
    font-family: iconfont;
    src: url(//static.yximgs.com/s1/font/iconfont-37c5fd16d2.eot);
    src: url(//static.yximgs.com/s1/font/iconfont-37c5fd16d2.eot#iefix) format("embedded-opentype"),url(//static.yximgs.com/s1/font/iconfont-cabcd9c68a.woff) format("woff"),url(//static.yximgs.com/s1/font/iconfont-e3e425d3c5.ttf) format("truetype"),url(//static.yximgs.com/s1/font/iconfont-c0f387c06c.svg#iconfont) format("svg")
}

.iconfont {
    font-family: iconfont!important;
    font-size: 16px;
    font-style: normal;
    -webkit-font-smoothing: antialiased;
    -moz-osx-font-smoothing: grayscale
}

.icon-check-square:before {
    content: "\e600"
}

.icon-alipay:before {
    content: "\e646"
}

.icon-play:before {
    content: "\e604"
}

.icon-layer-close:before {
    content: "\e601"
}

.icon-nav-down:before {
    content: "\e602"
}

.icon-nav-up:before {
    content: "\e603"
}

.icon-xuanzhongjiaobiao:before {
    content: "\e605"
}

.icon-suc-hook:before {
    content: "\e606"
}

.icon-loading:before {
    content: "\e86b"
}

.icon-img-browse:before {
    content: "\e607"
}

.icon-img-like:before {
    content: "\e608"
}

.icon-img-message:before {
    content: "\e609"
}

.icon-img-share:before {
    content: "\e60a"
}

.icon-sound-close:before {
    content: "\e60b"
}

.icon-sound-open:before {
    content: "\e60c"
}

.icon-video-play:before {
    content: "\e60d"
}

.icon-video-stop:before {
    content: "\e60e"
}

.icon-question-mark:before {
    content: "\e60f"
}

.icon-layer-close-copy-small:before {
    content: "\e610"
}

.icon-nav-right:before {
    content: "\e611"
}

.icon-nav-left:before {
    content: "\e612"
}

.icon-error:before {
    content: "\e6e0"
}

.icon-sure:before {
    content: "\e6e1"
}

.icon-data:before {
    content: "\e6e2"
}

.icon-add:before {
    content: "\e6e3"
}

.icon-edit:before {
    content: "\e6e4"
}

.icon-download:before {
    content: "\e6e5"
}

.icon-exposure:before {
    content: "\e6e6"
}

.icon-half-checked:before {
    content: "\e6e9"
}

.icon-all-checked:before {
    content: "\e6ea"
}
.checked {
    font-size: 14px;
    display: inline-block;
    width: 128px;
    height: 37px;
    background: #ccc;
    text-align: center;
    line-height: 37px;
    color: #fff;
    border-radius: 24px;
    margin-top: 24px;
    cursor: pointer;
    background: #ff5000;
}

.icon-circle-close:before {
    content: "\e6e7"
}

.icon-trumpet:before {
    content: "\e6e8"
}

.icon-step-done:before {
    content: "\e6f1"
}

.icon-step-wait:before {
    content: "\e64d"
}

.icon-spring:before {
    content: "\e6eb"
}

.icon-add-t:before {
    content: "\e949"
}

.icon-circle-check:before {
    content: "\e6ec"
}

.icon-cost:before {
    content: "\e6ed"
}

.icon-cycle:before {
    content: "\e6ee"
}

.icon-ques:before {
    content: "\e6ef"
}

.icon-zixuanguba-:before {
    content: "\e61b"
}

.icon-step-cur:before {
    content: "\e662"
}

.icon-wechat:before {
    content: "\e6f0"
}

.icon-ks-logo:before {
    content: "\e6f2"
}

.icon-follow:before {
    content: "\e616"
}

.icon-thumbup:before {
    content: "\e613"
}

.icon-thumbdown:before {
    content: "\e614"
}

.icon-thumbdown-pressed:before {
    content: "\e615"
}

.icon-thumbup-pressed:before {
    content: "\e617"
}

.icon-time:before {
    content: "\e618"
}

.icon-cup:before {
    content: "\e619"
}

.icon-video:before {
    content: "\e61a"
}

.icon-down-arrow:before {
    content: "\e6f3"
}

.icon-gerenzhongxin:before {
    content: "\e6f4"
}

.icon-shut-down:before {
    content: "\e6f7"
}

.icon-no-order:before {
    content: "\e6f8"
}

.icon-question_mark:before {
    content: "\e61c"
}

.icon-setting-icon-arrow-n:before {
    content: "\e61e"
}

.icon-nav-more:before {
    content: "\e6f9"
}

.icon-nav-back:before {
    content: "\e6fa"
}

.icon-nav-like:before {
    content: "\e6fb"
}

.icon-nav-forward:before {
    content: "\e94a"
}

.icon-nav-like-empty:before {
    content: "\e94b"
}

.icon-e-video-btn-unlike:before {
    content: "\e6ff"
}

.icon-e-back:before {
    content: "\e700"
}

.icon-e-show-arrow-right:before {
    content: "\e701"
}

.icon-e-detail-caption:before {
    content: "\e702"
}

.icon-e-video-like-checked:before {
    content: "\e703"
}

.icon-e-video-like-default:before {
    content: "\e704"
}

.icon-e-video-unlike:before {
    content: "\e705"
}

.icon-e-show-look:before {
    content: "\e706"
}

.icon-e-detail-like:before {
    content: "\e707"
}

.icon-approve_icon_idcard:before {
    content: "\e61d"
}

.icon-delete-btn-icon:before {
    content: "\e61f"
}

.icon-btn_camera_white_nor:before {
    content: "\e708"
}

.icon-detail_icon_position:before {
    content: "\e709"
}

.icon-edit_music_btn_play_:before {
    content: "\e70a"
}

.icon-edit_music_btn_stop_:before {
    content: "\e70b"
}

.icon-up-arrow:before {
    content: "\e94c"
}

.icon-info-icon:before {
    content: "\e620"
}

.icon-detail_ico_at_normal:before {
    content: "\e70c"
}

.icon-detail_ico_send_norm:before {
    content: "\e70d"
}

.icon-arrow:before {
    content: "\e621"
}

.com-login-wrap {
    position: fixed;
    width: 100%;
    height: 100%;
    background: rgba(0,0,0,.3);
    top: 0;
    left: 0;
    display: none;
    z-index: 9
}

.com-login-wrap .login-title {
    height: 60px;
    line-height: 60px;
    text-align: center;
    font-size: 18px;
    background: #f6f6f6;
    position: relative
}

.com-login-wrap .login-title i {
    position: absolute;
    right: 20px;
    cursor: pointer
}

.com-login-wrap .com-login {
    width: 620px;
    height: 460px;
    margin: auto;
    position: absolute;
    left: 0;
    top: 0;
    right: 0;
    bottom: 0;
    background: #fff;
    border: 1px solid #e2e2e2
}

.com-login-wrap .com-login .login-item-panel {
    position: relative
}

.com-login-wrap .com-login .login-item-wrap {
    padding: 60px 150px;
    width: 320px;
    height: 340px
}

.com-login-wrap .com-login .login-item-qr {
    position: absolute;
    top: 0;
    right: 0;
    width: 229px;
    height: 72px;
    background: url(//ali.static.yximgs.com/static/img/widgets/login/img/qrlogin_qr-58b74f2e.png);
    background-size: 100%;
    cursor: pointer
}

.com-login-wrap .com-login .item {
    height: 50px;
    line-height: 50px;
    width: 320px;
    margin-top: 20px;
    position: relative
}

.com-login-wrap .com-login .item span {
    position: absolute;
    font-size: 18px;
    left: -70px;
    color: #303030;
    text-align: left
}

.com-login-wrap .com-login .item .getVcode {
    left: auto;
    top: 0;
    right: 20px;
    color: #ff9000;
    font-size: 14px;
    cursor: pointer
}

.com-login-wrap .com-login .item .getingVcode {
    color: #919191
}

.com-login-wrap .com-login .item input {
    height: 48px;
    padding-left: 20px;
    width: 298px;
    border: 1px solid #e2e2e2;
    font-size: 14px;
    color: #000;
    line-height: 48px
}

.com-login-wrap .com-login .item input.error {
    border-color: red
}

.com-login-wrap .com-login .login-btn {
    margin: 30px 0;
    height: 50px;
    line-height: 50px;
    background: #ff5000;
    color: #fff;
    text-align: center;
    border-radius: 25px;
    font-size: 16px;
    cursor: pointer
}

.com-login-wrap .com-login .loging {
    background-color: #e58100
}

.com-login-wrap .com-login .login-desc {
    margin-top: 50px;
    color: #919191;
    text-align: center
}

.com-login-wrap .com-login-error {
    height: 320px;
    width: 430px;
    margin: auto;
    position: absolute;
    left: 0;
    top: 0;
    right: 0;
    bottom: 0;
    background: #fff
}

.com-login-wrap .com-login-error .login-error-type {
    margin-top: 35px;
    height: 25px;
    line-height: 25px;
    text-align: center;
    font-size: 18px;
    color: red
}

.com-login-wrap .com-login-error .login-error-desc {
    margin: 25px 35px;
    height: 30px;
    line-height: 30px;
    text-align: center;
    font-size: 14px;
    color: #303030
}

.com-login-wrap .com-login-error .login-error-btn {
    margin: 50px auto auto;
    width: 160px;
    height: 50px;
    line-height: 50px;
    background: #ff5000;
    color: #fff;
    text-align: center;
    border-radius: 25px;
    font-size: 16px;
    cursor: pointer
}

.qrlogin {
    position: relative
}

.qrlogin .color1 {
    color: #fc9025
}

.qrlogin .close {
    position: absolute;
    top: 0;
    right: 0;
    width: 72px;
    height: 72px;
    background: url(//ali.static.yximgs.com/static/img/widgets/login/img/qrlogin_mobilecode-ac1d550d.png);
    background-size: 100%;
    cursor: pointer
}

.qrlogin .qrpanel {
    padding: 50px 0 0
}

.qrlogin .qrpanel .title {
    text-align: center;
    font-size: 16px;
    color: #5e5e5e
}

.qrlogin .qrpanel .qrbox {
    position: relative;
    width: 140px;
    height: 140px;
    margin: 50px auto 0
}

.qrlogin .qrpanel .help {
    margin-top: 50px;
    text-align: center;
    font-size: 12px;
    color: #5e5e5e
}

.qrlogin .qrpanel .helpicon {
    display: inline-block;
    width: 16px;
    height: 16px;
    vertical-align: -4px;
    background: url(//ali.static.yximgs.com/static/img/widgets/login/img/qrlogin_scan-379f4cba.png);
    background-size: 100%
}

.qrlogin .qrpanel .helptext {
    display: inline;
    margin-left: 10px
}

.qrlogin .qrpanel .qr {
    display: block;
    width: 100%;
    height: 100%
}

.qrlogin .qrpanel .error {
    position: absolute;
    top: 0;
    left: 0;
    right: 0;
    bottom: 0;
    z-index: 1
}

.qrlogin .qrpanel .error_bg {
    position: absolute;
    top: 0;
    left: 0;
    right: 0;
    bottom: 0;
    background: #fff;
    opacity: .9;
    z-index: -1
}

.qrlogin .qrpanel .error_msg {
    margin-top: 37px;
    font-size: 14px;
    color: #303030;
    text-align: center
}

.qrlogin .qrpanel .error_btn {
    margin: 10px 10px 0;
    line-height: 42px;
    border-radius: 21px;
    font-size: 16px;
    color: #fff;
    text-align: center;
    background: #fc9025;
    cursor: pointer
}

.qrlogin .userpanel {
    padding-top: 50px
}

.qrlogin .userpanel .avatar {
    display: block;
    margin: 0 auto;
    width: 120px;
    height: 120px;
    border-radius: 50%
}

.qrlogin .userpanel .tip1 {
    margin-top: 20px;
    font-size: 20px;
    color: #303030;
    text-align: center
}

.qrlogin .userpanel .tip2 {
    margin-top: 10px;
    font-size: 14px;
    color: #5e5e5e;
    text-align: center
}

.qrlogin .userpanel .tip3 {
    cursor: pointer;
    margin-top: 44px;
    font-size: 12px;
    color: #919191;
    text-align: center
}

.choose-panel h1 {
    font-family: PingFangSC-Semibold;
    font-size: 18px;
    color: #303030;
    line-height: 86px;
    padding-left: 40px
}

.choose-panel .account-item {
    display: -webkit-box;
    display: -ms-flexbox;
    display: flex;
    -webkit-box-align: center;
    -ms-flex-align: center;
    align-items: center;
    height: 76px
}

.choose-panel .account-item:hover {
    background: rgba(48,48,48,.2)
}

.choose-panel .account-item img {
    border-radius: 50%;
    margin-left: 40px
}

.choose-panel .account-item .name {
    font-family: PingFangSC-Regular;
    font-size: 16px;
    color: #303030;
    margin-left: 20px;
    -webkit-box-flex: 1;
    -ms-flex: 1 1;
    flex: 1 1
}

.choose-panel .account-item .name p {
    width: 160px;
    overflow: hidden;
    -o-text-overflow: ellipsis;
    text-overflow: ellipsis;
    white-space: nowrap
}

.choose-panel .account-item .circle {
    width: 18px;
    height: 18px;
    background: url(//ali.static.yximgs.com/static/img/widgets/login/img/circle-87f37e53.svg) 50% no-repeat!important;
    margin-right: 40px
}

.choose-panel .account-item.selected .circle {
    background: url(//ali.static.yximgs.com/static/img/widgets/login/img/select-7ed12da5.svg) 50% no-repeat!important
}

.choose-panel .choose-btn {
    margin: 50px 30px 0;
    height: 50px;
    line-height: 50px;
    background: #ff5000;
    color: #fff;
    text-align: center;
    border-radius: 25px;
    font-size: 16px;
    cursor: pointer
}

@font-face {
    font-family: iconfont;
    src: url(//static.yximgs.com/s1/font/iconfont-37c5fd16d2.eot);
    src: url(//static.yximgs.com/s1/font/iconfont-37c5fd16d2.eot#iefix) format("embedded-opentype"),url(//static.yximgs.com/s1/font/iconfont-cabcd9c68a.woff) format("woff"),url(//static.yximgs.com/s1/font/iconfont-e3e425d3c5.ttf) format("truetype"),url(//static.yximgs.com/s1/font/iconfont-c0f387c06c.svg#iconfont) format("svg")
}

.iconfont {
    font-family: iconfont!important;
    font-size: 16px;
    font-style: normal;
    -webkit-font-smoothing: antialiased;
    -moz-osx-font-smoothing: grayscale
}

.icon-check-square:before {
    content: "\e600"
}

.icon-alipay:before {
    content: "\e646"
}

.icon-play:before {
    content: "\e604"
}

.icon-layer-close:before {
    content: "\e601"
}

.icon-nav-down:before {
    content: "\e602"
}

.icon-nav-up:before {
    content: "\e603"
}

.icon-xuanzhongjiaobiao:before {
    content: "\e605"
}

.icon-suc-hook:before {
    content: "\e606"
}

.icon-loading:before {
    content: "\e86b"
}

.icon-img-browse:before {
    content: "\e607"
}

.icon-img-like:before {
    content: "\e608"
}

.icon-img-message:before {
    content: "\e609"
}

.icon-img-share:before {
    content: "\e60a"
}

.icon-sound-close:before {
    content: "\e60b"
}

.icon-sound-open:before {
    content: "\e60c"
}

.icon-video-play:before {
    content: "\e60d"
}

.icon-video-stop:before {
    content: "\e60e"
}

.icon-question-mark:before {
    content: "\e60f"
}

.icon-layer-close-copy-small:before {
    content: "\e610"
}

.icon-nav-right:before {
    content: "\e611"
}

.icon-nav-left:before {
    content: "\e612"
}

.icon-error:before {
    content: "\e6e0"
}

.icon-sure:before {
    content: "\e6e1"
}

.icon-data:before {
    content: "\e6e2"
}

.icon-add:before {
    content: "\e6e3"
}

.icon-edit:before {
    content: "\e6e4"
}

.icon-download:before {
    content: "\e6e5"
}

.icon-exposure:before {
    content: "\e6e6"
}

.icon-half-checked:before {
    content: "\e6e9"
}

.icon-all-checked:before {
    content: "\e6ea"
}

.icon-circle-close:before {
    content: "\e6e7"
}

.icon-trumpet:before {
    content: "\e6e8"
}

.icon-step-done:before {
    content: "\e6f1"
}

.icon-step-wait:before {
    content: "\e64d"
}

.icon-spring:before {
    content: "\e6eb"
}

.icon-add-t:before {
    content: "\e949"
}

.icon-circle-check:before {
    content: "\e6ec"
}

.icon-cost:before {
    content: "\e6ed"
}

.icon-cycle:before {
    content: "\e6ee"
}

.icon-ques:before {
    content: "\e6ef"
}

.icon-zixuanguba-:before {
    content: "\e61b"
}

.icon-step-cur:before {
    content: "\e662"
}

.icon-wechat:before {
    content: "\e6f0"
}

.icon-ks-logo:before {
    content: "\e6f2"
}

.icon-follow:before {
    content: "\e616"
}

.icon-thumbup:before {
    content: "\e613"
}

.icon-thumbdown:before {
    content: "\e614"
}

.icon-thumbdown-pressed:before {
    content: "\e615"
}

.icon-thumbup-pressed:before {
    content: "\e617"
}

.icon-time:before {
    content: "\e618"
}

.icon-cup:before {
    content: "\e619"
}

.icon-video:before {
    content: "\e61a"
}

.icon-down-arrow:before {
    content: "\e6f3"
}

.icon-gerenzhongxin:before {
    content: "\e6f4"
}

.icon-shut-down:before {
    content: "\e6f7"
}

.icon-no-order:before {
    content: "\e6f8"
}

.icon-question_mark:before {
    content: "\e61c"
}

.icon-setting-icon-arrow-n:before {
    content: "\e61e"
}

.icon-nav-more:before {
    content: "\e6f9"
}

.icon-nav-back:before {
    content: "\e6fa"
}

.icon-nav-like:before {
    content: "\e6fb"
}

.icon-nav-forward:before {
    content: "\e94a"
}

.icon-nav-like-empty:before {
    content: "\e94b"
}

.icon-e-video-btn-unlike:before {
    content: "\e6ff"
}

.icon-e-back:before {
    content: "\e700"
}

.icon-e-show-arrow-right:before {
    content: "\e701"
}

.icon-e-detail-caption:before {
    content: "\e702"
}

.icon-e-video-like-checked:before {
    content: "\e703"
}

.icon-e-video-like-default:before {
    content: "\e704"
}

.icon-e-video-unlike:before {
    content: "\e705"
}

.icon-e-show-look:before {
    content: "\e706"
}

.icon-e-detail-like:before {
    content: "\e707"
}

.icon-approve_icon_idcard:before {
    content: "\e61d"
}

.icon-delete-btn-icon:before {
    content: "\e61f"
}

.icon-btn_camera_white_nor:before {
    content: "\e708"
}

.icon-detail_icon_position:before {
    content: "\e709"
}

.icon-edit_music_btn_play_:before {
    content: "\e70a"
}

.icon-edit_music_btn_stop_:before {
    content: "\e70b"
}

.icon-up-arrow:before {
    content: "\e94c"
}

.icon-info-icon:before {
    content: "\e620"
}

.icon-detail_ico_at_normal:before {
    content: "\e70c"
}

.icon-detail_ico_send_norm:before {
    content: "\e70d"
}

.icon-arrow:before {
    content: "\e621"
}

html {
    overflow-y: scroll
}

.pay-wrap {
    background-color: white;
    margin-top: -33px;
    font-size: 14px;
    padding-left: 5px
}

.pay-wrap ul {
    width: 100%;
    margin-bottom: 40px;
    font-size: 16px
}

.pay-wrap ul .item-name {
    display: block;
    color: #5e5e5e;
    height: 22px;
    line-height: 22px;
    font-size: 16px;
    font-weight: 500;
    margin-bottom: 32px
}

.pay-wrap ul .item-amount {
    margin-top: 60px;
    margin-bottom: 4px
}

.pay-wrap ul .item-value {
    line-height: 22px;
    display: inline-block
}

.pay-wrap ul .item-value-flex {
    display: -webkit-box;
    display: -ms-flexbox;
    display: flex;
    -webkit-box-align: center;
    -ms-flex-align: center;
    align-items: center
}

.pay-wrap ul .ks-number {
    position: relative
}

.pay-wrap ul .ks-number .confirm-btn {
    -webkit-user-select: none;
    -moz-user-select: none;
    -ms-user-select: none;
    user-select: none;
    display: none;
    position: absolute;
    width: 74px;
    height: 32px;
    border-radius: 18px;
    font-size: 16px;
    font-family: PingFangSC,PingFangSC-Medium;
    font-weight: 500;
    text-align: center;
    line-height: 32px;
    cursor: pointer;
    top: 50%;
    right: 12px;
    -webkit-transform: translateY(-50%);
    -ms-transform: translateY(-50%);
    transform: translateY(-50%);
    background-color: #ed5d2a;
    color: #f9eeea
}

.pay-wrap ul .ks-number .blur-status {
    background: #d8d8d8;
    color: #969798;
    cursor: default
}

.pay-wrap ul .ks-number .error-tips {
    display: none;
    position: absolute;
    height: 20px;
    font-size: 14px;
    font-family: PingFangSC,PingFangSC-Regular;
    font-weight: 400;
    color: #ff5000;
    line-height: 20px;
    top: calc(100% + 4px);
    left: 0
}

.pay-wrap ul .ks-number input {
    padding-left: 12px;
    padding-right: 100px;
    -webkit-box-sizing: border-box;
    box-sizing: border-box;
    width: 350px;
    height: 54px;
    border: 1px solid #ccc;
    border-radius: 4px;
    font-size: 16px;
    font-family: PingFangSC,PingFangSC-Medium;
    font-weight: 500;
    color: #131415
}

.pay-wrap ul .ks-number input::-webkit-input-placeholder {
    font-size: 16px;
    font-family: PingFangSC,PingFangSC-Medium;
    font-weight: 500;
    color: #cbcccd
}

.pay-wrap ul .ks-number input::-moz-placeholder {
    font-size: 16px;
    font-family: PingFangSC,PingFangSC-Medium;
    font-weight: 500;
    color: #cbcccd
}

.pay-wrap ul .ks-number input:-ms-input-placeholder {
    font-size: 16px;
    font-family: PingFangSC,PingFangSC-Medium;
    font-weight: 500;
    color: #cbcccd
}

.pay-wrap ul .ks-number input::-ms-input-placeholder {
    font-size: 16px;
    font-family: PingFangSC,PingFangSC-Medium;
    font-weight: 500;
    color: #cbcccd
}

.pay-wrap ul .ks-number input::placeholder {
    font-size: 16px;
    font-family: PingFangSC,PingFangSC-Medium;
    font-weight: 500;
    color: #cbcccd
}

.pay-wrap ul .fake-login {
    height: 54px;
    display: none;
    -webkit-box-align: center;
    -ms-flex-align: center;
    align-items: center
}

.pay-wrap ul .fake-login .user-info {
    color: #131415
}

.pay-wrap ul .fake-login .checkout,.pay-wrap ul .fake-login .user-info {
    font-size: 16px;
    font-family: PingFangSC,PingFangSC-Medium;
    font-weight: 500;
    line-height: 22px
}

.pay-wrap ul .fake-login .checkout {
    margin-left: 16px;
    color: #006fe1;
    cursor: pointer
}

.pay-wrap ul .item-user {
    color: #131415;
    font-weight: 500
}

.pay-wrap ul .pay-method {
    margin-bottom: 30px
}

.pay-wrap ul .pay-method span {
    display: inline-block;
    width: 157px;
    height: 48px;
    -webkit-box-sizing: border-box;
    box-sizing: border-box;
    text-align: center;
    border: 1px solid #979797;
    margin-right: 24px;
    font-size: 16px;
    color: #5e5e5e;
    line-height: 48px;
    cursor: pointer
}

.pay-wrap ul .pay-method span.checked {
    background: #ff9000;
    border: none;
    color: #fff
}

.pay-money-wrap {
    margin-right: 20px;
    height: 20px;
    line-height: 90px;
    border: 1px solid #ccc
}

.pay-money {
    display: inline-block;
    width: 80px;
    height: 33px;
    border-bottom: .5px solid rgba(150,151,152,.5)
}

.money-desc {
    display: inline-block;
    width: 200px;
    vertical-align: middle;
    font-size: 14px;
    margin-bottom: 24px
}

.money-desc-bi-default {
    color: #303030;
    line-height: 20px;
    height: 20px;
    color: #919191;
    display: block
}

.money-desc-bi-more {
    display: inline-block;
    line-height: 10px;
    width: 85px
}

.remain-li {
    height: 60px
}

.color-green {
    color: #ff5000!important
}

.pay-item {
    color: #303030;
    text-align: center;
    display: inline-block;
    width: 174px;
    height: 46px;
    margin-right: 20px;
    border: 1px solid #ccc;
    line-height: 48px;
    margin-bottom: 20px;
    font-size: 0;
    cursor: pointer;
    vertical-align: top
}

.pay-item i {
    color: #ff5000;
    display: none;
    position: absolute;
    bottom: -11px;
    right: -1px;
    font-size: 28px
}

.pay-item.mr0 {
    margin-right: 0
}

.pay-item-price {
    font-size: 14px;
    color: #303030
}

.pay-item-coin {
    color: #5e5e5e;
    font-size: 12px;
    height: 18px;
    line-height: 18px;
    display: none
}

.pay-checked {
    border-color: #ff5000;
    position: relative
}

.pay-checked .pay-item-price {
    height: 26px;
    line-height: 26px
}

.pay-checked .pay-item-coin {
    display: block
}

.pay-checked i {
    display: inline-block
}

.checkout-accout {
    margin-left: 16px;
    color: #006fe1;
    font-weight: 500
}

.checkout-accout:hover {
    cursor: pointer
}

.checkout-accout span {
    color: #d5d7d8;
    cursor: default
}

.recharge {
    width: 700px;
    font-size: 0
}

.recharge .input-test {
    height: 50px;
    width: 300px
}

.recharge-gear {
    text-align: center;
    display: inline-block;
    width: 190px;
    height: 80px;
    margin: 0 24px 24px 0;
    line-height: 50px;
    -webkit-box-sizing: border-box;
    box-sizing: border-box;
    border: 1px solid #ccc;
    vertical-align: top;
    border-radius: 4px;
    font-weight: 500
}

.recharge-gear .pay-yuan {
    height: 29px;
    color: #131415;
    font-size: 20px;
    display: block
}

.recharge-gear .kscoin {
    height: 22px;
    color: #969798;
    font-size: 16px;
    font-weight: 400
}

.recharge-gear .input-recharge {
    display: none
}

.recharge-gear .pay-unit {
    color: #5e5e5e;
    font-size: 21px;
    display: block;
    height: 20px;
    display: inline-block
}

.recharge-gear .other-recharge {
    outline: none
}

.recharge-gear .other-recharge-text {
    font-size: 18px;
    line-height: 75px;
    color: #969798
}

.recharge-gear .com-input {
    display: none
}

.recharge-gear .input-yuan {
    height: 28px;
    color: #131415;
    font-size: 21px;
    display: block
}

.recharge-gear .input-kscoin {
    height: 22px;
    color: #969798
}

.recharge-gear:hover {
    cursor: pointer
}

.recharge .pay-gear-checked {
    border: 2px solid #ff5000;
    position: relative
}

.shold-pay {
    display: inline-block;
    color: #ff5000;
    font-size: 30px;
    height: 48px;
    line-height: 48px
}

.private {
    height: 17px;
    line-height: 17px;
    margin-top: 36px
}

.private .serve-policy {
    font-size: 12px
}

.private .serve-policy i {
    display: inline-block;
    width: 16px;
    height: 16px;
    vertical-align: -22%;
    margin-right: 4px;
    cursor: pointer;
    background-image: url(//ali.static.yximgs.com/static/img/pages/pay/index/img/checkDefault-d20a24fd.png);
    background-repeat: no-repeat;
    background-size: contain;
    color: #ccc
}

.private .serve-policy i.checked {
    background-image: url(//ali.static.yximgs.com/static/img/pages/pay/index/img/checked-052dcdd0.png)
}

.private .serve-policy a {
    color: #006fe1
}

.go-button {
    font-size: 16px;
    display: inline-block;
    width: 176px;
    height: 48px;
    background: #ccc;
    text-align: center;
    line-height: 48px;
    color: #fff;
    border-radius: 24px;
    margin-top: 24px;
    cursor: pointer
}

.go-button.go-pay-checked {
    background: #ffffff
}

.dialog-popup {
    display: none;
    position: fixed;
    top: 0;
    left: 0;
    right: 0;
    bottom: 0;
    z-index: 10000
}

.dialog-popup .dialog-cover {
    background-color: #000;
    opacity: .2;
    position: fixed;
    z-index: 1;
    top: 0;
    left: 0;
    width: 100%;
    height: 100%
}

.dialog-popup .dialog-content {
    position: absolute;
    top: 50%;
    left: 50%;
    -webkit-transform: translate(-50%,-50%);
    -ms-transform: translate(-50%,-50%);
    transform: translate(-50%,-50%);
    overflow: hidden;
    margin: auto;
    z-index: 2;
    background-color: #fff;
    width: 416px;
    border-radius: 8px;
    -webkit-box-shadow: 0 4px 10px 0 rgba(26,26,36,.2);
    box-shadow: 0 4px 10px 0 rgba(26,26,36,.2);
    text-align: center
}

.dialog-popup .dialog-content .dialog-header {
    font-size: 21px;
    font-weight: 500;
    color: #131415;
    line-height: 30px;
    margin-bottom: 8px
}

.dialog-popup .dialog-content .dialog-icon {
    display: block;
    width: 58px;
    height: 58px;
    margin: 56px auto 16px;
    background-repeat: no-repeat;
    background-size: contain
}

.dialog-popup .dialog-content .dialog-icon.success {
    background-image: url(//ali.static.yximgs.com/static/img/pages/pay/index/img/success-911a4117.png)
}

.dialog-popup .dialog-content .dialog-icon.info {
    background-image: url(//ali.static.yximgs.com/static/img/pages/pay/index/img/fail-87e4da7b.png)
}

.dialog-popup .dialog-content .dialog-text {
    font-size: 14px;
    font-weight: 500;
    color: #969798;
    line-height: 20px;
    margin: 0 20px 24px
}

.dialog-popup .dialog-content .dialog-btn {
    background: #ff5000;
    margin: 24px 0
}

</style>