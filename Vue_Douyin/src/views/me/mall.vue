<template>

<div class="mui-content">
	    <div class="content-qianbao">
	    	<div class="qianbao-top">
	    		<div class="qianbao-top-xinxi">
	    			<ul>
	    				<li class="qianbao-li02">
	    					<!-- <p class="qianbao-p1">总资产  (R币)</p>
	    					<p class="qianbao-p2">1600</p> -->
	    					<p class="qianbao-p3">总收益:{{cc}}.00 (金额)</p>
							<p class="qianbao-p3">总消费:{{zz}}.00 (金额)</p>
	    				</li>
	    				<li class="qianbao-li01"><img class="head" :src="userlist.head"/>
						</li>
	    			</ul>
	    		</div>
	    	</div>
	    	<div class="qianbao-nr">
	    		<ul>
	    			<a href="/shopping" style="color:#191717">
		    			<li>
		    				<!-- <img src="../../assets/img/fasong.png"/> -->
		    				<p>返回</p>
		    			</li>
	    			</a>
	    			<a href="/Recharge" style="color:#191717">
		    			<li>
		    				<!-- <img src="../../assets/img/jieshou.png"/> -->
		    				<p>R币充值</p>
		    			</li>
	    			</a>
	    			<a href="/member" style="color:#191717">
		    			<li>
		    				<!-- <img src="../../assets/img/qiandao.png"/> -->
		    				<p>我的会员</p>
		    			</li>
	    			</a>
	    			<a href="shoufukuan.html" style="color:#191717">
		    			<li>
		    				<!-- <img src="../../assets/img/daifukuan.png"/> -->
		    				<p>收付款</p>
		    			</li>
	    			</a>
	    			<a href="/prepaid" style="color:#191717">
		    			<li>
		    				<!-- <img src="../../assets/img/duihuan.png"/> -->
		    				<p>会员充值</p>
		    			</li>
	    			</a>
	    		</ul>
	    	</div>
	    </div>
		<div>
		</div>
	    <div class="qianbao-nr2">
  <el-switch
  style="display: block"
  v-model="value2"
  active-color="#13ce66"
  inactive-color="#ff4949"
  active-text="收入"
  inactive-text="送出"
  >
  </el-switch>
	    	<div class="content-2" v-if="value2==true" v-for="items in obtainlist">
				<ul>
					<li class="qianbao-li03">		
					<span>{{items.gname}}</span>
					</li>
					<!-- R币 -->
					<li class="qianbao-li04">
						+{{items.r}}
					</li>
					<!--金额 -->
					<li class="qianbao-li05">
						${{items.water}}
					</li>
				</ul>
			</div>		
	    	<div class="content-2" v-if="value2==false" v-for="item in brushlist">
				<ul>
					<li class="qianbao-li03">
					<span>{{item.gname}}</span>
					</li>
					<!-- R币 -->
					<li class="qianbao-li04">
						-{{item.r}}
					</li>
					<!--金额 -->
					<li class="qianbao-li05">
						${{item.water}}
					</li>
				</ul>
			</div>		
	    </div>
	    <div style="height: 5em;"></div>
	</div>

</template>

<script>
import '../custom/css.css'

import { brush,obtain} from '@/api/user.js';

export default {
	created(){
       brush().then(res=>{
		 console.log("送出去的礼物"+res.data.message.gname)
		 this.brushlist=res.data.message;
	   });
       obtain().then(res1=>{
		 console.log("获取到的礼物"+res1.data.message.gname)
		 this.obtainlist=res1.data.message;
	   });

	    var userJsonStr = sessionStorage.getItem('user');
        this.userlist = JSON.parse(userJsonStr);

    //  let sum = 0;
    //  this.obtainlist.forEach((item) => {
    //  //遍历prodAllPrice这个字段，并累加
    //   sum += item.water;
	//  });

//返回
    this.sum = sum;
    console.log("总收益"+sum);
	},
	 methods:{

	 },
      data(){
		  return{
			 value2: true,
			 userlist:{},
			 obtainlist:{},
			 brushlist:{},		
			  list:[{
				  name:'火箭',
				  r:100,
				  money:10
			  },{
				  name:'飞机',
				  r:100,
				  money:10
			  },{
				  name:'火箭',
				  r:100,
				  money:10
			  }]
		  }
	  },
	  	 computed:{
          cc: function(){
          var sum = 0;
          for(var i= 0 ;i< this.obtainlist.length; i++) {
                sum += parseInt(this.obtainlist[i].water);
		  }
		  return sum;
	  },
	      zz:function(){
          var sum = 0;
          for(var i= 0 ;i< this.brushlist.length; i++) {
                sum += parseInt(this.brushlist[i].water);
		  }
		  return sum;
		  }
	 }
}
</script>
<style scoped>

.head{
    height: 70px;
    width: 76px;
    border-radius: 50%;
    margin-right: 0px;
}

</style>