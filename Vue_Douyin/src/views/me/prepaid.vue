<template>
    <div id="app">
        <section class="aui-scrollView">
                <div class="aui-flex aui-flex-gradual">
                    <div class="aui-flex-user">
                        <img  alt="">
                        <span class="aui-flex-vip">
                            <img src="">
                        </span>
                    </div>
                    <div class="aui-flex-box">
                        <h2>{{name}}</h2>
                        <p>
                            <em>{{estate}}</em>
                        </p>
                    </div>
                    <div class="aui-flex-Member">
                        <p>{{time}}会员到期</p>
                    </div>
                </div>
                <div class="aui-flex-member-list">
                    <h2>优享会员</h2>
                    <ul class="aui-cho-box">
                        <li class="aui-flex " @click="iosr(item.price,index)" :class="{on:currentIndex === index}" v-for="(item,index) in list">
                            <div class="aui-flex-box">
                                <h3>
                                    {{item.names}} 
             
                                    <em class="aui-flex-box-tj">
                                        <img  alt="">
                                    </em>
                                </h3>
                                <p>{{item.synopsis}}</p>
                            </div>
                            <div class="aui-original-thj">
                                特惠价 <i>￥</i>
                            </div>
                            <i class="aui-price">{{item.price}}</i>
                        </li>
                    </ul>
                    <div style="display:none">
                        <input name="" type="text" value="1" class="auiSks">
                    </div>
                    <p class="aui-total b-line">
                        需要支付： <span>{{pos}}</span>
                        元
                    
                    
                    </p>
                    <div class="chi">
                        
                        <div class="aui-flex b-line" style="padding:15px 0">
                            <div class="aui-flex-wx">
                                <img src="" alt="">
                            </div>
                            <div class="aui-flex-box">
                                <h4>支付宝支付</h4>
                                <p>亿万用户的选择</p>
                            </div>
                            <div class="aui-payment-method">
                                <label class="cell-right">
                                    <input type="radio" name="radio" value="zfb">
                                    <i class="cell-radio-icon"></i>
                                </label>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="bottom_center_box">
                 <p class="zlos">   
                <span class="zlot">返回</span>
                <span class="zloz">会员充值</span>
                 </p>
</div>
<el-drawer
    :size="size"
  :visible.sync="drawer"
  :direction="direction"
  :before-close="handleClose">
  <span><div class="aui-flex b-line">
				<i class="icon icon-close" id="cancel"></i>
				<div class="aui">
					<h3>确认付款</h3>
				</div>
				<i class="icon icon-doubt"></i>
			</div>
            <div class="jage">
				<h1><i>￥</i>{{pos}}</h1>&nbsp;
			</div>
            <div class="aui-info-line">
				<a href="javascript:;" class="aui-flex b-line">
					<div class="aui-flex-box">
						<h5>订单信息</h5>
					</div>
					<div class="aui-text">会员充值</div>
				</a>
				<a href="javascript:;" class="aui-flex b-line">
					<div class="aui-flex-box">
						<h5>付款方式</h5>
					</div>
					<div class="aui-arrow">支付宝</div>
				</a>
			</div>
            <div class="aui-coll-cancel">
				<a href="javascript:;" id="cancel" class="">立即付款</a>
			</div>            
            </span>
</el-drawer>
            </section>
            <footer class="aui-tabBar aui-tabBar-fixed">
                <button class="aui-tabBar-btn" @click="payment">续费会员卡,继续享受5%返现</button>
            </footer>

            
                 </div>   
</template>


<script>

export default {
     data(){
         return{
            drawer: false,
            size: '57%',
            direction: 'btt',
            currentIndex:0, 
            //会员的头像
            // src:require+('https://guil-file-200211.oss-cn-beijing.aliyuncs.com/Oops/logo.jpg'),           
            // 会员名称
            name:'Oops',
            //会员等级
            estate:'V2',
            //到期日期
            time:'2021-12-1',
            //默认价格
            pos:6,
            list:[{
              names:'连续包月',
              synopsis:'连续包月享受会员优惠',
              price:8
            },
            {
              names:'一个月',
              synopsis:'包月享受会员优惠',
              price:10
            },
            {
              names:'五个月',
              synopsis:'连续包月享受会员优惠',
              price:40
            },
            {
              names:'八个月',
              synopsis:'连续包月享受会员优惠',
              price:64
            },{
              names:'一年',
              synopsis:'连续包月享受会员优惠',
              price:80
            }
            ]
         }
     },
     methods:{
        iosr(price,index){
            this.currentIndex=index
            this.pos=price
         },
         payment(){
             this.drawer=true;
            // alert("支付")
         },
      handleClose(done) {
            done();
      }
     }
}
</script>

<style scoped>

.bottom_center_box {

}


.zlos{
    width: 100%;
    height: 12%;
    overflow: hidden;
    position: fixed;
    bottom: 619px;
    z-index: 9;
    background-color: #FFF;
    border-top: 1px solid #CCC;
    position: fixed;
    font-size: 20px;

}

.active3{
    /* background-color:#dda0a0; */
    border: 1px solid #fe941f;
    background: #fffaef;
        }

.zlot{
    position: fixed;
    left: 7px;
    right: 12;
    top: 2%;
}

.zloz{
    position: fixed;
    left: 163px;
    right: 12;
     top: 2%;
}

.aui-flex-Member {
    position: absolute;
    bottom: 10px;
    right: 10px;
    color: #fff;
    font-size: 0.8rem;
}

.cell-right input[type="radio"], .cell-right input[type="checkbox"]:not(.m-switch) {
    -moz-appearance: none;
    left: -9971em;
    opacity: 0;
}

.aui-total {
    font-weight: bold;
    color: #333;
    padding-bottom: 15px;
    font-size: 0.8rem;
}

.aui-flex {
    display: -webkit-box;
    display: -webkit-flex;
    display: flex;
    -webkit-box-align: center;
    -webkit-align-items: center;
    align-items: center;
    padding: 12px;
    position: relative;
}

.cell-right input[type="radio"]:checked + .cell-radio-icon:after, .cell-right input[type="checkbox"]:not(.m-switch):checked + .cell-radio-icon:after {
    content: '';
    background-image: url(data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAADwAAAA8CAYAAAA6/NlyAAAAAXNSR…G4CWMgg78UqDiCyHn84sg+Y9dUxVkd32/D7sReVVyI8D/rWSJXH/qHhAAAAABJRU5ErkJggg==);
    width: 21px;
    height: 22px;
    display: inline-block;
    background-size: 22px;
}

.aui-scrollView[data-v-616eafdc] {
    width: 100%;
    height: 74%;
    flex: 1;
    overflow-y: auto;
    overflow-x: hidden;
    -webkit-overflow-scrolling: touch;
    position: relative;
    margin-top: 57px;
    padding-bottom: 50px;
}

.aui-flex-gradual {
    background-image: -webkit-gradient(linear,left top,right top,from(#fe941f),to(#ffbf56));
    background-image: -webkit-linear-gradient(left,#fe941f,#ffbf56);
    background-image: -moz-linear-gradient(left,#fe941f,#ffbf56);
    background-image: linear-gradient(to right,#fe941f,#ffbf56);
    background-color: #ffbf56;
    padding: 40px 15px;
}

.aui-flex-user {
    width: 70px;
    height: 70px;
    margin-right: 15px;
    position: relative;
}
.aui-flex-user img {
    width: 100%;
    height: auto;
    display: block;
    border: 1px solid #fff;
    border-radius: 100%;
}

.aui-flex-vip {
    width: 25px;
    height: 25px;
    display: block;
    position: absolute;
    right: -2px;
    top: 44px;
    /* border-radius: 60px; */
    /* border: 1px solid #fff; */
}

.aui-flex-box {
    -webkit-box-flex: 1;
    -webkit-flex: 1;
    flex: 1;
    min-width: 0;
    font-size: 14px;
    color: #fff;
}

.aui-flex-Member {
    position: absolute;
    bottom: 10px;
    right: 10px;
    color: #fff;
    font-size: 0.8rem;
}

.aui-flex-member-list {
    padding: 15px;
}

.aui-flex-box p em {
    color: #835a06;
    font-size: 0.7rem;
    border-radius: 20px;
    border: 1px solid #faca78;
    padding: 0.05rem 0.35rem;
    background-image: -webkit-gradient(linear,left top,right top,from(#fdf0b9),to(#f69b18));
    background-image: -webkit-linear-gradient(left,#fdf0b9,#f69b18);
    background-image: -moz-linear-gradient(left,#fdf0b9,#f69b18);
    background-image: linear-gradient(to right,#fdf0b9,#f69b18);
    background-color: #f69b18;
    font-style: normal;
}


.aui-tabBar-btn {
    /* background: #fbb20b; */
    color: #fff;
    font-size: 0.9rem;
    border: none;
    width: 100%;
    border-radius: 2px;
    height: 40px;
    line-height: 40px;
    background-image: -webkit-gradient(linear,left top,right top,from(#fe941f),to(#ffbf56));
    background-image: -webkit-linear-gradient(left,#fe941f,#ffbf56);
    background-image: -moz-linear-gradient(left,#fe941f,#ffbf56);
    background-image: linear-gradient(to right,#fe941f,#ffbf56);
    background-color: #ffbf56;
}


.aui-tabBar {
    width: 100%;
    position: relative;
    z-index: 100;
    display: -webkit-box;
    display: -webkit-flex;
    display: -ms-flexbox;
    display: flex;
    -webkit-box-align: center;
    -webkit-align-items: center;
    -ms-flex-align: center;
    align-items: center;
    padding: 8px 15px;
    background-color: #ffffff;
}

.aui-flex-member-list h2 {
    font-size: 0.9rem;
    color: #444;
    font-weight: normal;
    padding-bottom: 15px;
}

.on {
    border: 1px solid #fe941f;
    background: #fffaef;
}

.aui-flex-member-list ul li {
    border: 1px solid #c6c6c6;
    border-radius: 3px;
    margin-bottom: 15px;
}


.aui-original-pic {
    color: #969696;
    font-size: 0.7rem;
    position: absolute;
    right: 15px;
    bottom: 5px;
    text-decoration: line-through;
}

.aui-flex-member-list .aui-flex-box {
    color: #333;
}

.aui-flex-box h3 {
    font-weight: normal;
    font-size: 0.9rem;
}

.aui-flex-box-tj img {
    width: 100%;
}

.aui-flex-box-tj {
    width: 30px;
    display: inline-block;
}

.aui-flex-box p {
    color: #999;
    font-size: 0.75rem;
}

.aui-original-thj {
    color: #fe9f2f;
    font-size: 0.86rem;
    position: absolute;
    right: 35px;
    bottom: 23px;
}


.aui-price {
    color: #f69b18;
    font-style: normal;
    font-weight: bold;
    font-size: 1.2rem;
}

.aui-tabBar.aui-tabBar-fixed {
    position: fixed;
    bottom: 0;
    left: 0;
    z-index: 100;
}

button {
    outline: 0;
}

img {
    border: 0;
}

input{
	color:fff;
}

button,input,optgroup,select,textarea {
    margin: 0;
    font: inherit;
    color: inherit;
    outline: none;
}

li {
    list-style: none;
}

a {
    color: #666;
}

.r-line {
    position: relative;
}

.r-line:after {
    content: '';
    position: absolute;
    z-index: 0;
    top: 0;
    right: 0;
    height: 100%;
    border-right: 1px solid #D9D9D9;
    -webkit-transform: scaleX(0.5);
    transform: scaleX(0.5);
    -webkit-transform-origin: 100% 0;
    transform-origin: 100% 0;
}

.b-line {
    position: relative;
}

.b-line:after {
    content: '';
    position: absolute;
    z-index: 2;
    bottom: 0;
    left: 0;
    width: 100%;
    height: 1px;
    border-bottom: 1px solid #e2e2e2;
    -webkit-transform: scaleY(0.5);
    transform: scaleY(0.5);
    -webkit-transform-origin: 0 100%;
    transform-origin: 0 100%;
}

/* 必要布局样式css */
.aui-flexView {
    width: 100%;
    height: 100%;
    margin: 0 auto;
    display: -webkit-box;
    display: -webkit-flex;
    display: -ms-flexbox;
    display: flex;
    -webkit-box-orient: vertical;
    -webkit-box-direction: normal;
    -webkit-flex-direction: column;
    -ms-flex-direction: column;
    flex-direction: column;
}

.aui-navBar {
    height: 44px;
    position: relative;
    display: -webkit-box;
    display: -webkit-flex;
    display: -ms-flexbox;
    display: flex;
    z-index: 102;
    background: #2955ff;
}

.aui-navBar-item {
    height: 44px;
    min-width: 25%;
    -webkit-box-flex: 0;
    -webkit-flex: 0 0 25%;
    -ms-flex: 0 0 25%;
    flex: 0 0 25%;
    padding: 0 0.9rem;
    display: -webkit-box;
    display: -webkit-flex;
    display: -ms-flexbox;
    display: flex;
    -webkit-box-align: center;
    -webkit-align-items: center;
    -ms-flex-align: center;
    align-items: center;
    font-size: 0.85rem;
    white-space: nowrap;
    overflow: hidden;
    color: #fff;
    position: relative;
}

.aui-navBar-item:first-child {
    -webkit-box-ordinal-group: 2;
    -webkit-order: 1;
    -ms-flex-order: 1;
    order: 1;
    margin-right: -25%;
}

.aui-navBar-item:last-child {
    -webkit-box-ordinal-group: 4;
    -webkit-order: 3;
    -ms-flex-order: 3;
    order: 3;
    -webkit-box-pack: end;
    -webkit-justify-content: flex-end;
    -ms-flex-pack: end;
    justify-content: flex-end;
}

.aui-center {
    -webkit-box-ordinal-group: 3;
    -webkit-order: 2;
    -ms-flex-order: 2;
    order: 2;
    display: -webkit-box;
    display: -webkit-flex;
    display: -ms-flexbox;
    display: flex;
    -webkit-box-pack: center;
    -webkit-justify-content: center;
    -ms-flex-pack: center;
    justify-content: center;
    -webkit-box-align: center;
    -webkit-align-items: center;
    -ms-flex-align: center;
    align-items: center;
    height: 44px;
    width: 50%;
    margin-left: 25%;
}

.aui-center-title {
    text-align: center;
    width: 100%;
    white-space: nowrap;
    overflow: hidden;
    display: block;
    text-overflow: ellipsis;
    font-size: 1.2rem;
    color: #fff;
}

.icon {
    width: 20px;
    height: 20px;
    display: block;
    border: none;
    float: left;
    background-size: 20px;
    background-repeat: no-repeat;
}

.icon-return {
    /* background-image:url('data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAADwAAAA8CAYAAAA6/NlyAAACTUlEQVRoQ+3a/U3DMBAF8PcmACagGwATUDZgA2ACYAOYADagTMAIwATABnSDMsGhk1ypipwPNWffheJ/qVp+eb5z4pjYscEd8+IfHC1xEZkBOATwRXI19v8LnbCIzAG8ANgH8AngbCw6LFhEjgG8Juw62GeSl2NSDgluwapzSVKn+NYjHLgDq8h7kndba4FYXboHO3o664UKk3ANbBhwWno+Gg3KrFFtloB7wiKiS452Y+3KzWEyjcOAe7DvJHUdNh1uCfdgvwDMx95k5K6UC9gL69K0PLHVwd5YD/ATgNy9cLGabdZxtRoWkTbsUpekEg3KrWl1YH9SN9ZHvyqjeMKRsMVrOBq2KDgithhYRG4APGSKsnrNFu/SIqLLjnbk5nDHmifcgdXfuiK5qNKKO37ErEtPAWuW8FSwJmAROU97x7mJFGIam24AiIjuVuQe1MNhrRJ+A3CaifeW5KN3kzJfltJuo6L3MrhwKZt06Z1qWutUp4I2SXhKaFOwwqMnbQ4egNZ3vNrkXEYRcA9a3+Irutouh+mNR1dMIqLr8HXmM27oYglvNDJ9QrqIgi4OTtM7DLoKOBK6GngA+oTkd+nWXRXcgzY5ltR3waqDE7rtCas42gusb/0VfZRJpCjaBZxSdkG7gb3QrmAPtDt4AHpB8qqv+w79ewjwBloblh4Vbg4zdBhwQutZrbb9MRN0KPAA9N86XLrxhNWW9IrkwdB6zX0uXMI96NFHEcOCM9Pb5KRPaHBC6wn4mdU+WHjwmHqdVA1bQ9fft3MJ/wISRCdMRcXH5wAAAABJRU5ErkJggg=='); */
}

.aui-scrollView {
    width: 100%;
    height: 100%;
    -webkit-box-flex: 1;
    -webkit-flex: 1;
    -ms-flex: 1;
    flex: 1;
    overflow-y: auto;
    overflow-x: hidden;
    -webkit-overflow-scrolling: touch;
    position: relative;
    padding-bottom:53px;
}

.aui-reset-phone{
    width:25px;
    height:25px;
}

.aui-recharge-iphone {
    display: -webkit-box;
    display: -webkit-flex;
    display: flex;
    -webkit-box-align: center;
    -webkit-align-items: center;
    align-items: center;
    padding: 15px;
    position: relative;
	background: #2955ff;
}

.aui-well-bd {
    -webkit-box-flex: 1;
    -webkit-flex: 1;
    flex: 1;
    min-width: 0;
    font-size: 14px;
    color: #fff;
}

.aui-well-hd {
    margin-left: .8em;
    width: 30px;
    height: 40px;
    line-height: 40px;
    text-align: center;
}

.aui-well-hd img {
    width: 100%;
    max-height: 100%;
    vertical-align: top;
    display: block;
    border: none;
}

.aui-well-bd p input {
    width: 100%;
    padding: 4px 0;
    font-size: 1.5rem;
    border: none;
    background: none;
	color: #FFF;
}

.aui-well-bd p {
    color: #a9c2fe;
    font-size: 0.8rem;
}

.aui-well-bd p em {
    font-style: normal;
}

.aui-recharge-iphone::after {
    content: '';
    position: absolute;
    z-index: 2;
    bottom: 0;
    left: 0;
    width: 100%;
    height: 1px;
    border-bottom: 0px solid #B2B2B2;
    -webkit-transform: scaleY(0.5);
    transform: scaleY(0.5);
    -webkit-transform-origin: 0 100%;
    transform-origin: 0 100%;
}


.aui-blue-box{
    width:100%;
    height:10rem;
    /* background-color:; */
    /* background-image: url("../images/beijing.jpg"); */
    background-size:cover;
    background-position:top center;
    position:relative;
    margin-bottom:4.5rem;
}

.aui-palace {
    padding: 0.5rem 0;
    position: relative;
    overflow: hidden;
}
.aui-palace-one{
    width:92%;
    position:absolute;
    left:50%;
    bottom:-2rem;
    margin-left:-46%;
    background:#fff;
    border-radius:5px;
    box-shadow:0 5px 15px #d2d0d0;
}

.aui-current-box {
    position: relative;
    background: #ffffff;
    padding: 20px 10px 1px 10px;
}

.aui-current-item {
    position: relative;
    float: left;
    padding: 10px 8px 10px 8px;
    width: 29.333333%;
    box-sizing: border-box;
    text-align: center;
    border-radius: 5px;
    border: 1px solid #108ee9;
    margin: 0 2% 4% 2%;
    height:4rem;
}

.aui-current-item-hd {
    width:auto;
    text-align: center;
    margin: 0 auto;
}

.aui-current-item-hd  h1{
    color:#108ee9;
    font-size:1.2rem;
}

.aui-current-item-hd  h3{
    color:#8e8e8e;
    font-size:0.1rem;
    font-weight:normal;
}

.m-actionsheet {
    text-align: center;
    position: fixed;
    bottom: 0;
    left: 0;
    width: 100%;
    z-index: 1000;
    background-color: rgba(255,255,255,0.9);
    -webkit-transform: translate(0, 100%);
    transform: translate(0, 100%);
    -webkit-transition: -webkit-transform .3s;
    transition: -webkit-transform .3s;
    transition: transform .3s;
    transition: transform .3s, -webkit-transform .3s;
}

.mask-black {
    background-color: rgba(0, 0, 0, 0.3);
    position: fixed;
    z-index: 500;
    bottom: 0;
    right: 0;
    left: 0;
    top: 0;
    display: -webkit-box;
    display: -webkit-flex;
    display: -ms-flexbox;
    display: flex;
    -webkit-box-pack: center;
    -webkit-justify-content: center;
    -ms-flex-pack: center;
    justify-content: center;
    -webkit-box-align: center;
    -webkit-align-items: center;
    -ms-flex-align: center;
    align-items: center;
    z-index: 998;
}

.actionsheet-action {
    display: block;
    margin-top: .15rem;
    font-size: 0.28rem;
    color: #555;
    height: 1rem;
    line-height: 1rem;
    background-color: #FFF;
}

.m-actionsheet {
    text-align: center;
    position: fixed;
    bottom: 0;
    left: 0;
    width: 100%;
    z-index: 10005;
    background-color: #ffffff;
    -webkit-transform: translate(0, 100%);
    transform: translate(0, 100%);
    -webkit-transition: -webkit-transform .3s;
    transition: -webkit-transform .3s;
    transition: transform .3s;
    transition: transform .3s, -webkit-transform .3s;
}

.actionsheet-toggle {
    -webkit-transform: translate(0, 0);
    transform: translate(0, 0);
}

.actionsheet-item {
    display: block;
    position: relative;
    font-size: 0.85rem;
    color: #555;
    height: 2rem;
    line-height: 2rem;
    background-color: #FFF;
}

.actionsheet-item {
    display: block;
    position: relative;
    font-size: 0.85rem;
    color: #555;
    height: 2rem;
    line-height: 2rem;
    background-color: #FFF;
}

.aui-coll-share-box {
    position: relative;
    overflow: hidden;
    padding: 1.8rem 0 1rem 0;
}

.aui-coll-share-item {
    position: relative;
    float: left;
    padding: 8px 10px;
    width: 33.333%;
    box-sizing: border-box;
    font-size: 12px;
    height: 85px;
}

.aui-coll-share-box h1 {
    color: #2f2f2f;
    font-size: 0rem;
    font-weight: normal;
}

.aui-coll-share-box h1 i {
    font-style: normal;
    color: #000000;
    font-size: 1.5rem;
}

.aui-flex {
    display: -webkit-box;
    display: -webkit-flex;
    display: flex;
    -webkit-box-align: center;
    -webkit-align-items: center;
    align-items: center;
    padding: 10px;
    position: relative;
}

.aui-flex-box {
    -webkit-box-flex: 1;
    -webkit-flex: 1;
    flex: 1;
    min-width: 0;
    font-size: 14px;
    color: #333;
}

.aui-flex-box h1 {
    color: #2f2f2f;
    font-size: 1.4rem;
    font-weight: normal;
}

.aui-flex-box h4 {
    color: #050505;
    font-weight: normal;
    font-size: 1rem;
}

.aui-flex-box h5 {
    text-align: left;
    color: #989898;
    font-weight: normal;
    font-size: 0.9rem;
}

.aui-flex-box h2{
    font-size:0.95rem;
    margin-bottom:0.3rem;
}

.aui-flex-box p{
    font-size:0.5rem;
    color:#b3b3b3;
}

.aui-monthly{
    text-align:right;
}

.aui-monthly h3{
    color:#2f2f2f;
    font-size:0.95rem;
}


.icon-close {
    /* background-image: url('data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAADwAAAA8CAYAAAA6/NlyAAAB/0lEQVRoQ+3aTW7DIBAFYHOz9CRNl5yIZdOTtDcjojKSmxLmh3kQ22QbB+bzGyPbwS0n+7iTeZcJPnriM+GZ8MHOwGzpUqAhhItz7j19F2P88t7/vELwmrrIhNdBv7fAGOOH9/42Eh1CuDrnPh/qeqPC4IBvOd1XQZewm+671oJQg9cJuif9DGsJTtfvn5YelXQNu4LbWzoNxJgInrRVDWRL5zStJtQsdJZzs8GjkrbEJoMI3BttjVWBe6ERWDUYjUZhm8AoNBLbDLZGo7EmYCt0D6wZuBXdC2sK1qJ7Ys3BUnRvLATMRf9O/vA82+OhRHynxb0XptKrjYN8wQADc5IuoZFYWEtvIZKk0dguYG7SPbATzF2QJMedqqUl2HwS0a0NW6U12B5oCJjCphQPc+PBweZ/LSTHStaN2rGmCWsAmt+04M3ALYW3/FaKNwFbFGwxBgffDLYs1HKsZ/gmMKJAxJhbvBqMLAw5tgqMLCingZpDDEYVUrrmEHOJwIgCqJXVek422HpiCip5iSB54GCBR2Ktr2kSXNrF0+PtovKabt/yEEIo7uJJBUlaSdLCtWNr3bbuIcPs4hmBpdrbCvxvF89IbA0dY2xv6fWt42VZltwqN2q3m1X7UuOk9UVaF7loUZPu7fsJ3lti0npnwtIztrfjZ8J7S0xa7+kSvgMcXXJb5Dh3xwAAAABJRU5ErkJggg=='); */
}

.aui-arrow {
    position: relative;
    padding-right: 0.8rem;
    color: #929292;
    font-size: 0.85rem;
}

.aui-arrow:after {
    content: " ";
    display: inline-block;
    height: 6px;
    width: 6px;
    border-width: 2px 2px 0 0;
    border-color: #848484;
    border-style: solid;
    -webkit-transform: matrix(0.71, 0.71, -0.71, 0.71, 0, 0);
    transform: matrix(0.71, 0.71, -0.71, 0.71, 0, 0);
    position: relative;
    top: -2px;
    position: absolute;
    top: 50%;
    margin-top: -4px;
    right: 2px;
    border-radius: 1px;
}

.aui-info-line {
    margin-bottom: 5rem;
}

.aui-coll-cancel a {
    color: red;

}

.aui-info-line .b-line:after {
    left: 15px;
}

.aui-text {
    color: #363636;
    font-size: 0.85rem;
}

.aui-coll-cancel {
    padding: 1rem;
}

.aui-coll-cancel a {
    color: rgb(255, 255, 255);
    font-size: 0.9rem;
    width: 100%;
    height: 2.7rem;
    line-height: 2.7rem;
    display: block;
    background: rgb(16, 142, 233);
    border-radius: 3px;
    border-width: initial;
    border-style: none;
    border-color: initial;
    border-image: initial;
        text-align: center;
}
.aui {
    position: absolute;
    left: 41%;
    top: -137%;
    text-align: center;
}

.jage h1 {
    color: rgb(54, 54, 54);
    font-size: 2.5rem;
    font-weight: normal;
    position: absolute;
    left: 35%;
    top: 13%;
}

</style>