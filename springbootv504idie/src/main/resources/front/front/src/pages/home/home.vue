<template>
<div class="home-preview" :style='{"padding":"0","margin":"0 auto","flexWrap":"wrap","flexDirection":"row","background":"#fff","display":"flex","width":"100%","justifyContent":"center"}'>



		<!-- 关于我们 -->
		<div id="about" class="animate__animated" :style='{"padding":"40px calc((100% - 1200px)/2)","margin":"0","borderColor":"#f1635f","background":"rgb(245, 245, 245)","borderWidth":"0px 0 0","width":"100%","position":"relative","borderStyle":"solid","height":"auto","order":"3"}'>
		  <div :style='{"padding":"0","margin":"0","borderColor":"#C10D0C","color":"rgb(51, 51, 51)","textAlign":"left","display":"inline-block","top":"100px","background":"url() no-repeat 10px center","borderWidth":"0px","width":"auto","fontSize":"28px","lineHeight":"33px","position":"absolute","borderStyle":"solid","fontWeight":"600","height":"36px"}'>{{aboutUsDetail.title}}</div>
		  <div :style='{"margin":"0 0 30px","color":"#888","textAlign":"left","display":"none","width":"100%","lineHeight":"1.5","fontSize":"16px"}'>{{aboutUsDetail.subtitle}}</div>
		  <div :style='{"padding":"0","margin":"0","flexWrap":"wrap","display":"flex","width":"60%","float":"right","height":"auto"}'>
		    <img :style='{"width":"calc(40% - 0px)","margin":"0 0px 0 0","objectFit":"cover","display":"block","height":"360px"}' :src="baseUrl + aboutUsDetail.picture1">
		    <img :style='{"width":"calc(60% - 20px)","margin":"0 0 0 20px","objectFit":"cover","display":"block","height":"360px"}' :src="baseUrl + aboutUsDetail.picture2">
		    <img :style='{"margin":"0 10px","objectFit":"cover","flex":1,"display":"none","height":"120px"}' :src="baseUrl + aboutUsDetail.picture3">
		  </div>
		  <div :style='{"padding":"0","margin":"120px 20px 0 0","overflow":"hidden","color":"rgb(102, 102, 102)","background":"none","width":"calc(40% - 20px)","fontSize":"14px","lineHeight":"24px","float":"left","height":"168px"}' v-html="aboutUsDetail.content"></div>
		  <div :style='{"top":"0","left":"52%","background":"url(http://codegen.caihongy.cn/20230920/8a35b5134ee644b8a9a87ea99a0f1490.png) no-repeat","display":"none","width":"200px","position":"absolute","height":"100%"}' />
		  <div :style='{"width":"285px","background":"url(http://codegen.caihongy.cn/20201114/7856ba26477849ea828f481fa2773a95.jpg) 0% 0% / cover no-repeat","display":"none","height":"100px"}' />
		  <div :style='{"width":"285px","background":"url(http://codegen.caihongy.cn/20201114/7856ba26477849ea828f481fa2773a95.jpg) 0% 0% / cover no-repeat","display":"none","height":"100px"}' />
		  <div :style='{"width":"285px","background":"url(http://codegen.caihongy.cn/20201114/7856ba26477849ea828f481fa2773a95.jpg) 0% 0% / cover no-repeat","display":"none","height":"100px"}' />
		  <div :style='{"border":"1px solid #000","cursor":"pointer","padding":"0 40px","margin":"0","textAlign":"center","display":"block","float":"left","top":"350px","borderRadius":"20px","background":"url(http://codegen.caihongy.cn/20240304/bde4adc0687f4affb0887552058edc54.png) no-repeat 90% center,#fff","width":"auto","lineHeight":"32px","position":"absolute"}' @click="toDetail('aboutusDetail',aboutUsDetail)">
		    <span :style='{"color":"#333","fontSize":"16px"}'>查看更多</span>
		    <span class="icon iconfont " :style='{"color":"#fff","fontSize":"16px","display":"inline-block"}'></span>
		  </div>
		</div>
		<!-- 关于我们 -->

		
	<!-- 新闻资讯 -->
	<div id="animate_newsnews" class="news animate__animated" :style='{"padding":"0 calc((100% - 1200px)/2)","margin":"30px auto","backgroundAttachment":"fixed","background":"#fff","width":"100%","position":"relative","order":"5"}'>
		<div v-if="false" class="idea newsIdea" :style='{"padding":"20px","flexWrap":"wrap","background":"#efefef","justifyContent":"space-between","display":"flex"}'>
			<div class="box1" :style='{"width":"20%","background":"#fff","height":"80px"}'></div>
			<div class="box2" :style='{"width":"20%","background":"#fff","height":"80px"}'></div>
			<div class="box3" :style='{"width":"20%","background":"#fff","height":"80px"}'></div>
			<div class="box4" :style='{"width":"20%","background":"#fff","height":"80px"}'></div>
			<div class="box5" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
			<div class="box6" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
			<div class="box7" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
			<div class="box8" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
			<div class="box9" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
			<div class="box10" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		</div>
		
		<div class="title" :style='{"padding":"0px","margin":"0 auto","borderColor":"#C10D0C","textAlign":"left","background":"none","borderWidth":"0 0 0px","width":"100%","borderStyle":"solid","height":"36px"}'>
			<span :style='{"fontSize":"28px","lineHeight":"33px","color":"rgb(51, 51, 51)","fontWeight":"600"}'>公告资讯</span>
		</div>
		
			
			
			
			
			
			
			
			
			
			
		


		<div v-if="newsList.length" class="list list13 index-pv1" :style='{"padding":"0px","margin":"20px auto 0","color":"#999","background":"none","width":"100%","fontSize":"14px","height":"auto"}'>
		  <div :style='{"width":"100%","margin":"0 0 20px","background":"#fff","justifyContent":"space-between","display":"flex","height":"auto"}'>
		    <div :style='{"width":"50%","padding":"0 10px","height":"auto","order":"2"}'>
			  <template v-for="(item,index) in newsList">
		      <div v-if="index < 3" @click="toDetail('newsDetail', item)" class="list-item animation-box" :style='{"cursor":"pointer","width":"100%","padding":"10px","margin":"10px 0","background":"none","height":"auto"}'>
		        <div :style='{"overflow":"hidden","whiteSpace":"nowrap","color":"#000","width":"100%","lineHeight":"1.5","fontSize":"14px","textOverflow":"ellipsis","fontWeight":"600"}' class="name">{{item.title}}</div>
		        <div :style='{"lineHeight":"24px","fontSize":"14px","overflow":"hidden","color":"#666","textIndent":"2em","height":"48px"}' class="name">{{item.introduction}}</div>
		        <div :style='{"padding":"0 10px","display":"inline-block"}'>
		          <span class="icon iconfont icon-shijian21" :style='{"margin":"0 2px 0 0","lineHeight":"1.5","fontSize":"inherit","color":"inherit"}'></span>
		          <span :style='{"color":"inherit","lineHeight":"1.5","fontSize":"inherit"}'>{{item.addtime}}</span>
		        </div>
		        <div :style='{"padding":"0 10px","display":"inline-block"}'>
		          <span class="icon iconfont icon-geren16" :style='{"margin":"0 2px 0 0","lineHeight":"1.5","fontSize":"inherit","color":"inherit"}'></span>
		          <span :style='{"color":"inherit","lineHeight":"1.5","fontSize":"inherit"}'>{{item.name}}</span>
		        </div>
		        <div :style='{"padding":"0 10px","display":"inline-block"}'>
		          <span class="icon iconfont icon-zan10" :style='{"margin":"0 2px 0 0","lineHeight":"1.5","fontSize":"inherit","color":"inherit"}'></span>
		          <span :style='{"color":"inherit","lineHeight":"1.5","fontSize":"inherit"}'>{{item.thumbsupnum}}</span>
		        </div>
		        <div :style='{"padding":"0 10px","display":"inline-block"}'>
		          <span class="icon iconfont icon-shoucang10" :style='{"margin":"0 2px 0 0","lineHeight":"1.5","fontSize":"inherit","color":"inherit"}'></span>
		          <span :style='{"color":"inherit","lineHeight":"1.5","fontSize":"inherit"}'>{{item.storeupnum}}</span>
		        </div>
		        <div :style='{"padding":"0 10px","display":"inline-block"}'>
		          <span class="icon iconfont icon-chakan2" :style='{"margin":"0 2px 0 0","lineHeight":"1.5","fontSize":"inherit","color":"inherit"}'></span>
		          <span :style='{"color":"inherit","lineHeight":"1.5","fontSize":"inherit"}'>{{item.clicknum}}</span>
		        </div>
		      </div>
			  </template>
		    </div>
		    <div :style='{"width":"50%","padding":"0px","height":"auto"}'>
		      <div v-if="newsList.length > 3" class="swiper-container newsSwiper13 new-list-13news">
		        <div class="swiper-wrapper">
				  <template v-for="(item,index) in newsList">
		          <div v-if="index > 2 && index < 6" class="swiper-slide">
		            <div :style='{"width":"100%","position":"relative","height":"auto"}' @click="toDetail('newsDetail', item)">
		              <img :style='{"width":"100%","objectFit":"cover","display":"block","height":"360px"}' :src="baseUrl + item.picture">
		              <div :style='{"width":"100%","position":"absolute","left":"0","bottom":"0","background":"rgba(0,0,0,.3)"}'>
		                <div :style='{"padding":"0 10px","overflow":"hidden","whiteSpace":"nowrap","color":"#fff","width":"100%","lineHeight":"44px","fontSize":"14px","textOverflow":"ellipsis"}'>{{item.title}}</div>
		              </div>
		            </div>
		          </div>
				  </template>
		        </div>
		        <!-- Add Pagination -->
		        <div class="swiper-pagination" :style='{"width":"100%","left":"0","textAlign":"right","bottom":"10px"}'></div>
		      </div>
		    </div>
		  </div>
		  <div v-if="newsList.length > 6" :style='{"width":"100%","justifyContent":"space-between","display":"none","height":"auto"}'>
			<template v-for="(item,index) in newsList">
		    <div v-if="index > 5" @click="toDetail('newsDetail', item)" class="list-item animation-box" :style='{"width":"24%","padding":"0 0 10px","position":"relative","background":"#fff","height":"auto"}'>
		      <img :style='{"width":"100%","objectFit":"cover","display":"block","height":"250px"}' :src="baseUrl + item.picture">
		      <div :style='{"padding":"5px 10px","overflow":"hidden","whiteSpace":"nowrap","color":"#333","width":"100%","lineHeight":"1.5","fontSize":"14px","textOverflow":"ellipsis"}' class="name">{{item.title}}</div>
		      <div :style='{"padding":"0 10px","lineHeight":"24px","fontSize":"14px","overflow":"hidden","color":"#999","height":"48px"}' class="name">{{item.introduction}}</div>
		      <div :style='{"padding":"0 10px","margin":"10px 0 0"}'>
		        <span class="icon iconfont icon-shijian21" :style='{"margin":"0 2px 0 0","lineHeight":"1.5","fontSize":"inherit","color":"inherit"}'></span>
		        <span :style='{"color":"inherit","lineHeight":"1.5","fontSize":"inherit"}'>{{item.addtime}}</span>
		      </div>
		      <div :style='{"padding":"0 10px","margin":"10px 0 0","display":"inline-block"}'>
		        <span class="icon iconfont icon-geren16" :style='{"margin":"0 2px 0 0","lineHeight":"1.5","fontSize":"inherit","color":"inherit"}'></span>
		        <span :style='{"color":"inherit","lineHeight":"1.5","fontSize":"inherit"}'>{{item.name}}</span>
		      </div>
		      <div :style='{"padding":"0 10px","display":"inline-block"}'>
		        <span class="icon iconfont icon-zan10" :style='{"margin":"0 2px 0 0","lineHeight":"1.5","fontSize":"inherit","color":"inherit"}'></span>
		        <span :style='{"color":"inherit","lineHeight":"1.5","fontSize":"inherit"}'>{{item.thumbsupnum}}</span>
		      </div>
		      <div :style='{"padding":"0 10px","display":"inline-block"}'>
		        <span class="icon iconfont icon-shoucang10" :style='{"margin":"0 2px 0 0","lineHeight":"1.5","fontSize":"inherit","color":"inherit"}'></span>
		        <span :style='{"color":"inherit","lineHeight":"1.5","fontSize":"inherit"}'>{{item.storeupnum}}</span>
		      </div>
		      <div :style='{"padding":"0 10px","display":"inline-block"}'>
		        <span class="icon iconfont icon-chakan9" :style='{"margin":"0 2px 0 0","lineHeight":"1.5","fontSize":"inherit","color":"inherit"}'></span>
		        <span :style='{"color":"inherit","lineHeight":"1.5","fontSize":"inherit"}'>{{item.clicknum}}</span>
		      </div>
		    </div>
			</template>
		  </div>
		</div>









		<div @click="moreBtn('news')" :style='{"border":"1px solid #000","cursor":"pointer","padding":"0 40px","margin":"0","textAlign":"center","display":"block","right":"calc((100% - 1200px)/2)","top":"0px","borderRadius":"30px","background":"url(http://codegen.caihongy.cn/20240304/bde4adc0687f4affb0887552058edc54.png) no-repeat 90% center,#fff","width":"auto","lineHeight":"32px","position":"absolute"}'>
			<span :style='{"color":"#333","fontSize":"16px"}'>查看更多</span>
			<i :style='{"color":"#fff","fontSize":"16px","display":"inline-block"}' class="icon iconfont "></i>
		</div>
		
		</div>
	<!-- 新闻资讯 -->


	
</div>
</template>

<script>
import 'animate.css'
import Swiper from "swiper";

  export default {
    //数据集合
    data() {
      return {
        baseUrl: '',
        aboutUsDetail: {},
        newsList: [],


		newListSwiper13news: null,



      }
    },
    created() {
		this.baseUrl = this.$config.baseUrl;
		this.getNewsList();
		this.getAboutUs();
		this.getList();
    },
	mounted() {
		window.addEventListener('scroll', this.handleScroll)
		setTimeout(()=>{
			this.handleScroll()
		},100)
		
		this.swiperChanges()
	},
	beforeDestroy() {
	  window.removeEventListener('scroll', this.handleScroll)
	},
    //方法集合
    methods: {
		swiperChanges() {
			if (this['newListSwiper13news']) this['newListSwiper13news'].destroy()
			setTimeout(()=>{
				this['newListSwiper13news'] = new Swiper(".new-list-13news", {"autoplay":{"delay":2500,"disableOnInteraction":false},"pagination":{"el":".swiper-pagination","clickable":true}})
			},750)
		},

		listIndexClick12(index, name) {
			this['listIndex12' + name] = index
			this.getList()
			
			document.querySelectorAll('.lists .list12' + name + ' .list .item').forEach(el => {
			  el.classList.remove("active")
			})
			setTimeout(() => {
			  document.querySelectorAll('.lists .list12' + name + ' .list .item').forEach(el => {
			    el.classList.add("active")
			  })
			}, 1);
		},

		handleScroll() {
			let arr = [
				{id:'search',css:'animate__fadeInUp'},
				{id:'about',css:'animate__'},
				{id:'system',css:'animate__'},
				{id:'animate_newsnews',css:'animate__'},
				{id:'msgs',css:'animate__'},
				{id:'friendly',css:'animate__'}
			]
			
			for (let i in arr) {
				let doc = document.getElementById(arr[i].id)
				if (doc) {
					let top = doc.offsetTop
					let win_top = window.innerHeight + window.pageYOffset
					// console.log(top,win_top)
					if (win_top > top && doc.classList.value.indexOf(arr[i].css) < 0) {
						// console.log(doc)
						doc.classList.add(arr[i].css)
					}
				}
			}
		},
      preHttp(str) {
          return str && str.substr(0,4)=='http';
      },
      getAboutUs() {
          this.$http.get('aboutus/detail/1', {}).then(res => {
            if(res.data.code == 0) {
              this.aboutUsDetail = res.data.data;
            }
          })
      },
		getNewsList() {
			let data = {
				page: 1,
				limit: 6,
                sort: 'addtime',
				order: 'desc'
			}
			this.$http.get('news/list', {params: data}).then(res => {
				if (res.data.code == 0) {
					this.newsList = res.data.data.list;
					
					
				}
			});
		},
		getList() {
			let autoSortUrl = "";
			let data = {}
			
		},
		toDetail(path, item) {
			this.$router.push({path: '/index/' + path, query: {id: item.id}});
		},
		moreBtn(path) {
			this.$router.push({path: '/index/' + path});
		}
    }
  }
</script>

<style rel="stylesheet/scss" lang="scss" scoped>
	.home-preview {
		// -------- search --------
		.search .select /deep/ .el-input__inner {
			border: 0px solid #ddd;
			border-radius: 2px;
			padding: 0 30px 0 10px;
			box-shadow: 0 0 0px rgba(64, 158, 255, .3);
			outline: none;
			color: rgba(64, 158, 255, 1);
			width: 180px;
			font-size: 14px;
			height: 32px;
		}
		
		.search .input /deep/ .el-input__inner {
			border-radius: 2px;
			padding: 0 10px;
			color: rgba(64, 158, 255, 1);
			width: 280px;
			font-size: 14px;
			border-color: #ddd;
			border-width: 0px;
			border-style: solid;
			height: 32px;
		}
		// -------- search --------
		.recommend {
			.list3 .swiper-button-prev {
				left: 10px;
				right: auto;
			}
			
			.list3 .swiper-button-prev::after {
				color: rgb(64, 158, 255);
			}
			
			.list3 .swiper-button-next {
				left: auto;
				right: 10px;
			}
			
			.list3 .swiper-button-next::after {
				color: rgb(64, 158, 255);
			}
			
			.list5 .swiper-button-prev {
				left: 10px;
				right: auto;
			}
			
			.list5 .swiper-button-prev::after {
				color: rgb(64, 158, 255);
        }
        
        .list5 .swiper-button-next {
				left: auto;
				right: 10px;
			}
			
			.list5 .swiper-button-next::after {
				color: rgb(64, 158, 255);
			}
			
			.list5 {
				.swiper-slide-prev {
					position: relative;
					z-index: 3;
				}
		
				.swiper-slide-next {
					position: relative;
					z-index: 3;
				}
		
				.swiper-slide-active {
					position: relative;
					z-index: 5;
				}
			}
			
			.index-pv1 .animation-box {
				transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
				z-index: initial;
			}
			
			.index-pv1 .animation-box:hover {
				transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
				-webkit-perspective: 1000px;
				perspective: 1000px;
				transition: 0.3s;
				z-index: 1;
			}
			
			.index-pv1 .animation-box img {
				transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
			}
			
			.index-pv1 .animation-box img:hover {
				transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
				-webkit-perspective: 1000px;
				perspective: 1000px;
				transition: 0.3s;
			}
		}
		
		.news {
			.list3 .swiper-button-prev {
				left: 10px;
				right: auto;
			}
			
			.list3 .swiper-button-prev::after {
				color: rgb(64, 158, 255);
			}
			
			.list3 .swiper-button-next {
				left: auto;
				right: 10px;
			}
			
			.list3 .swiper-button-next::after {
				color: rgb(64, 158, 255);
			}
			
			.list6 .swiper-button-prev {
				left: 10px;
				right: auto;
			}
			
			.list6 .swiper-button-prev::after {
				color: rgb(64, 158, 255);
			}
			
			.list6 .swiper-button-next {
				left: auto;
				right: 10px;
			}
			
			.list6 .swiper-button-next::after {
				color: rgb(64, 158, 255);
			}
			
			.index-pv1 .animation-box {
				transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
				z-index: initial;
			}
			
			.index-pv1 .animation-box:hover {
				transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
				-webkit-perspective: 1000px;
				perspective: 1000px;
				transition: 0.3s;
				z-index: 1;
			}
			
			.index-pv1 .animation-box img {
				transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
			}
			
			.index-pv1 .animation-box img:hover {
				transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
				-webkit-perspective: 1000px;
				perspective: 1000px;
				transition: 0.3s;
			}
		}
	
		.lists {
			.list3 .swiper-button-prev {
				left: 10px;
				right: auto;
			}
			
			.list3 .swiper-button-prev::after {
				color: #333;
				font-size: 16px;
			}
			
			.list3 .swiper-button-next {
				left: auto;
				right: 10px;
        }
        
        .list3 .swiper-button-next::after {
				color: #333;
				font-size: 16px;
			}
			
			.list5 .swiper-button-prev {
				left: 10px;
				right: auto;
			}
			
			.list5 .swiper-button-prev::after {
				color: rgb(64, 158, 255);
			}
			
			.list5 .swiper-button-next {
            left: auto;
            right: 10px;
			}
			
			.list5 .swiper-button-next::after {
				color: rgb(64, 158, 255);
			}
			
			.list5 {
				.swiper-slide-prev {
					position: relative;
					z-index: 3;
				}
		
				.swiper-slide-next {
					position: relative;
					z-index: 3;
				}
		
				.swiper-slide-active {
					position: relative;
					z-index: 5;
				}
			}
			
			.index-pv1 .animation-box {
				transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
				z-index: initial;
			}
			
			.index-pv1 .animation-box:hover {
				transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
				-webkit-perspective: 1000px;
				perspective: 1000px;
				transition: 0.3s;
				z-index: 1;
			}
			
			.index-pv1 .animation-box img {
				transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
			}
			
			.index-pv1 .animation-box img:hover {
				transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
				-webkit-perspective: 1000px;
				perspective: 1000px;
				transition: 0.3s;
			}
		}
	}
	

	.home-preview .news .list13 .newsSwiper13 .swiper-pagination /deep/ span.swiper-pagination-bullet {
				border-radius: 100%;
				margin: 0 4px;
				background: #fff;
				display: inline-block;
				width: 10px;
				opacity: .2;
				height: 10px;
			}
	
	.home-preview .news .list13 .newsSwiper13 .swiper-pagination /deep/ span.swiper-pagination-bullet:hover {
				background: #F5BB00;
				opacity: 1;
			}
	
	.home-preview .news .list13 .newsSwiper13 .swiper-pagination /deep/ span.swiper-pagination-bullet.swiper-pagination-bullet-active {
				background: #F5BB00;
				opacity: 1;
			}









	.home-preview .lists .list12 .tab .item {
				cursor: pointer;
				padding: 0 8px;
				margin: 0;
				color: #909090;
				display: inline-block;
				font-size: 14px;
				border-color: #ddd;
				line-height: auto;
				background: none;
				width: auto;
				border-width: 0 1px 0 0;
				align-items: center;
				border-style: solid;
			}
	
	.home-preview .lists .list12 .tab .item:hover {
			}
	
	.home-preview .lists .list12 .tab .item.active {
			}
	
	.home-preview .lists .list12 .tab .more {
				cursor: pointer;
				padding: 5px 10px;
				margin: 0 10px;
				color: #666;
				background: #fff;
				display: none;
				line-height: 44px;
				align-items: center;
			}
	
	.home-preview .lists .list12 .tab .more:hover {
			}
	
	.home-preview .lists .list12 .item.active {
	  animation-name: mymove;
	
	  &:nth-of-type(1) {
	    animation-duration: 1s;
	  }
	  &:nth-of-type(2) {
	    animation-duration: 1.2s;
	  }
	  &:nth-of-type(3) {
	    animation-duration: 1.4s;
	  }
	  &:nth-of-type(4) {
	    animation-duration: 1.6s;
	  }
	  &:nth-of-type(5) {
	    animation-duration: 1.8s;
	  }
	  &:nth-of-type(6) {
	    animation-duration: 2s;
	  }
	}
	
	@keyframes mymove
	{
		from {top: 320px;}
		to {top: 0;}
	}
</style>
