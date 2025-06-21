import VueRouter from 'vue-router'

//引入组件
import Index from '../pages'
import Home from '../pages/home/home'
import Login from '../pages/login/login'
import Register from '../pages/register/register'
import Center from '../pages/center/center'
import Forum from '../pages/forum/list'
import ForumAdd from '../pages/forum/add'
import ForumDetail from '../pages/forum/detail'
import MyForumList from '../pages/forum/myForumList'
import Storeup from '../pages/storeup/list'
import News from '../pages/news/news-list'
import NewsDetail from '../pages/news/news-detail'
import payList from '../pages/pay'

import kaifarenyuanList from '../pages/kaifarenyuan/list'
import kaifarenyuanDetail from '../pages/kaifarenyuan/detail'
import kaifarenyuanAdd from '../pages/kaifarenyuan/add'
import ceshirenyuanList from '../pages/ceshirenyuan/list'
import ceshirenyuanDetail from '../pages/ceshirenyuan/detail'
import ceshirenyuanAdd from '../pages/ceshirenyuan/add'
import quexianxinxiList from '../pages/quexianxinxi/list'
import quexianxinxiDetail from '../pages/quexianxinxi/detail'
import quexianxinxiAdd from '../pages/quexianxinxi/add'
import newstypeList from '../pages/newstype/list'
import newstypeDetail from '../pages/newstype/detail'
import newstypeAdd from '../pages/newstype/add'
import aboutusList from '../pages/aboutus/list'
import aboutusDetail from '../pages/aboutus/detail'
import aboutusAdd from '../pages/aboutus/add'

const originalPush = VueRouter.prototype.push
VueRouter.prototype.push = function push(location) {
	return originalPush.call(this, location).catch(err => err)
}

//配置路由
export default new VueRouter({
	routes:[
		{
      path: '/',
      redirect: '/index/home'
    },
		{
			path: '/index',
			component: Index,
			children:[
				{
					path: 'home',
					component: Home
				},
				{
					path: 'center',
					component: Center,
				},
				{
					path: 'pay',
					component: payList,
				},
				{
					path: 'forum',
					component: Forum
				},
				{
					path: 'forumAdd',
					component: ForumAdd
				},
				{
					path: 'forumDetail',
					component: ForumDetail
				},
				{
					path: 'myForumList',
					component: MyForumList
				},
				{
					path: 'storeup',
					component: Storeup
				},
				{
					path: 'news',
					component: News
				},
				{
					path: 'newsDetail',
					component: NewsDetail
				},
				{
					path: 'kaifarenyuan',
					component: kaifarenyuanList
				},
				{
					path: 'kaifarenyuanDetail',
					component: kaifarenyuanDetail
				},
				{
					path: 'kaifarenyuanAdd',
					component: kaifarenyuanAdd
				},
				{
					path: 'ceshirenyuan',
					component: ceshirenyuanList
				},
				{
					path: 'ceshirenyuanDetail',
					component: ceshirenyuanDetail
				},
				{
					path: 'ceshirenyuanAdd',
					component: ceshirenyuanAdd
				},
				{
					path: 'quexianxinxi',
					component: quexianxinxiList
				},
				{
					path: 'quexianxinxiDetail',
					component: quexianxinxiDetail
				},
				{
					path: 'quexianxinxiAdd',
					component: quexianxinxiAdd
				},
				{
					path: 'newstype',
					component: newstypeList
				},
				{
					path: 'newstypeDetail',
					component: newstypeDetail
				},
				{
					path: 'newstypeAdd',
					component: newstypeAdd
				},
				{
					path: 'aboutus',
					component: aboutusList
				},
				{
					path: 'aboutusDetail',
					component: aboutusDetail
				},
				{
					path: 'aboutusAdd',
					component: aboutusAdd
				},
			]
		},
		{
			path: '/login',
			component: Login
		},
		{
			path: '/register',
			component: Register
		},
	]
})
