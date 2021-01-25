import Vue from 'vue'
import VueRouter from 'vue-router'


const Home = () =>import('../views/Home.vue')

const Index = ()=> import('../views/index/Index.vue')
const Follow = ()=> import('../views/follow/Follow.vue')
const VideoList = () => import('../components/index/VideoList.vue')
const Sign = ()=> import('../views/Sign.vue')
const tpsign = ()=> import('../views/tpsign.vue')
const toast = ()=> import('../components/toast/toast.vue')
const me = ()=> import('../views/me/me.vue')
const edit = ()=> import('../views/me/edit.vue')
const msg = ()=> import('../views/msg/msg.vue')
const particulars = ()=> import('../views/msg/particulars.vue')
//设置密码
const setting = ()=> import('../views/setting.vue')
//查询页面 路由
const search=()=> import('../components/search/inquire.vue')
//钱包 路由
const wallet=()=> import('../containing/wallet.vue')
//上传路由
const uploading=()=>import('../issue/uploading.vue')
//关注路由
const attention=()=>import('../views/me/attention.vue')

//详细视频路由
const details=()=>import('../components/index/Details.vue')

//商城路由
const shopping=()=>import('../components/index/shopping.vue')

//我的商城
const mall=()=>import('../views/me/mall.vue')

//会员路由
const member=()=>import('../views/me/member.vue')

//等级介绍
const detail=()=>import('../views/detail/de.vue')

//会员充值
const prepaid=()=>import('../views/me/prepaid.vue')

//热门推送
const push=()=>import('../views/me/push.vue')

//个人资料
const compile=()=>import('../views/me/compile.vue')

//充值页面
const Recharge=()=>import('../views/me/Recharge.vue')

//PC端首页
const pc_index=()=>import('../pc/pc_index.vue')

Vue.use(VueRouter)


  const routes = [
    // 默认首页显示
  {
    path: '/',
    redirect: '/index'
  },
  
  {
    path: '',
    redirect: '/pc_index',
  },
  {
    path:'/pc_index',
    name:'pc_index',
    component:pc_index,
  },
  {
    path: '/home',
    name: 'Home',
    component: Home,
    children:[
      {
        path:'/index',
        name:'index',
        component:Index,
        //子路由
        children:[
          {
            path:'/index',
            component:VideoList
          }
        ]
      },
      {
        path:'/follow',
        name:'follow',
        component:Follow
      },
      {
        path:'/me',
        name:'me',
        component:me
      },
      {
        path:'/msg',
        name:'msg',
        component:msg
      },
      {
        path:'/particulars',
        name:'particulars',
        component:particulars
      }
  ]
  },
  {
    path:'/sign',
    name:'sign',
    component:Sign
  },
  {
    path:'/tpsign',
    name:'tpsign',
    component:tpsign
  },
  {
    path:'/toast',
    name:'toast',
    component:toast
  },
  {
    path:'/edit',
    name:'edit',
    component:edit
  },
  {
    path:'/search',
    name:'search',
    component:search
  },
  {
    path:'/wallet',
    name:'wallet',
    component:wallet
    
  },
  {
    path:'/uploading',
    name:'uploading',
    component:uploading
  },
  {
    path:'/attention',
    name:'attention',
    component:attention
  },
  {
    path:'/details',
    name:'details',
    component:details
  },
  {
    path:'/shopping',
    name:'shopping',
    component:shopping
  },
  {
    path:'/mall',
    name:'mall',
    component:mall
  },
  //会员等级
  {
    path:'/member',
    name:'member',
    component:member
  },

  //R币充值
  {
    path:'/Recharge',
    name:'Recharge',
    component: Recharge
  },

  //个人设置
  {
    path:'/compile',
    name:'compile',
    component:compile
  },

  //设置密码
  {
    path:'/setting',
    name:'setting',
    component:setting
  },

   //热门推送
   {
    path:'/push',
    name:'push',
    component:push
   },
      {
        path:'/detail',
        name:'detail',
        component:detail
      }
      ,
      {
        path:'/prepaid',
        name:'prepaid',
        component:prepaid
      }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})
import { Message, MessageBox} from 'element-ui'

// 导航守卫
// 使用 router.beforeEach 注册一个全局前置守卫，判断用户是否登陆
router.beforeEach((to, from, next) => {
  //debugger
  if (to.path === '/Sign'|| to.path === '/setting' || to.path === '/index' || to.path ==='/tpsign' ) {
    next();
  } else {
    let token = sessionStorage.getItem('Authorization');
    if (!token) {
      Message.error('请先登录')
      next('/Sign');
    } else {
      next();
    }
  }
});
export default router;

