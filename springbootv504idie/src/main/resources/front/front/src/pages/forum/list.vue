<template>
<div class="forum-preview" :style='{"minHeight":"500px","padding":"20px 20px 40px","margin":"0px auto","borderColor":"#ddd","background":"#fff","borderWidth":"0px","width":"1200px","position":"relative","borderStyle":"solid"}'>
    <div :style='{"padding":"30px 0 0","margin":"0px auto 0","borderColor":"#ffc652","textAlign":"center","background":"none","borderWidth":"0px 0 0","width":"100%","borderStyle":"solid","height":"60px"}'>
		<div :style='{"padding":"0 20px","color":"#222","textAlign":"center","background":"none","display":"inline-block","width":"auto","fontSize":"22px","fontWeight":"500"}'>论坛</div>
	</div>
    <el-form :style='{"padding":"20px 0","margin":"10px 0","alignItems":"center","flexWrap":"wrap","background":"none","display":"flex","width":"100%","justifyContent":"center","height":"auto"}' :inline="true" :model="formSearch" class="list-form-pv">
		<el-form-item :style='{"margin":"0 0px"}'>
			<el-input v-model="title" placeholder="标题"></el-input>
		</el-form-item>
		<div :style='{"alignItems":"center","display":"flex"}'>
			<el-button class="searchBtn" type="primary" @click="getForumList(1)">
				<span class="icon iconfont icon-fangdajing01" :style='{"margin":"0 10px 0 0","fontSize":"14px","color":"#fff","display":"none"}'></span>
				查询
			</el-button>
			<el-button class="pubBtn" type="primary" @click="toForumAdd">
				<span class="icon iconfont icon-tianjia14" :style='{"margin":"0 10px 0 0","fontSize":"14px","color":"#fff","display":"none"}'></span>
				发布帖子
			</el-button>
		</div>
    </el-form>
	<div class="z-box" :style='{"width":"100%","padding":"0px","background":"none"}'>
		<div class="section-content" v-for="item in forumList" :key="item.id" @click="toForumDetail(item)">
		  <div :style='{"overflow":"hidden","whiteSpace":"nowrap","color":"#666","flex":"1","width":"calc(100% - 260px)","fontSize":"14px","textOverflow":"ellipsis"}' class="item-style">{{item.title}}</div>
		  <div :style='{"color":"#999","margin":"0 30px 0 0","fontSize":"14px"}' class="item-style">发布人：{{item.username}}</div>
		  <div :style='{"color":"#999","fontSize":"14px"}' class="item-style">{{item.addtime}}</div>
		</div>
	</div>
	
    <el-pagination
      background
      id="pagination" class="pagination"
      :pager-count="7"
      :page-size="pageSize"
	  prev-text="<"
      next-text=">"
      :hide-on-single-page="false"
      :layout='["total","prev","pager","next","sizes"].join()'
      :total="total"
      :style='{"padding":"0","margin":"10px auto","color":"#333","textAlign":"center","width":"100%","lineHeight":"40px","float":"left","fontWeight":"500","height":"40px","order":"50"}'
      @current-change="curChange"
      @prev-click="prevClick"
      @next-click="nextClick"
    ></el-pagination>
	
</div>
</template>

<script>
  export default {
    //数据集合
    data() {
      return {
		formSearch: {},
        title: '',
        layouts: '',
        forumList: [],
        total: 1,
        pageSize: 10,
        totalPage: 1
      }
    },
    created() {
      this.getForumList(1);
    },
    //方法集合
    methods: {
      getForumList(page) {
        let params = {page, limit: this.pageSize, isdone: '开放', sort: 'istop,toptime', order: 'desc,desc'};
        let searchWhere = {};
        if(this.title != '') searchWhere.title = '%' + this.title + '%';
        this.$http.get('forum/flist', {params: Object.assign(params, searchWhere)}).then(res => {
          if (res.data.code == 0) {
            this.forumList = res.data.data.list;
            this.total = res.data.data.total;
            this.pageSize = Number(res.data.data.pageSize);
            this.totalPage = res.data.data.totalPage;
          }
        });
      },
      curChange(page) {
        this.getForumList(page);
      },
      prevClick(page) {
        this.getForumList(page);
      },
      nextClick(page) {
        this.getForumList(page);
      },
      toForumAdd() {
        this.$router.push('/index/forumAdd');
      },
      toForumDetail(item) {
        this.$router.push({path: '/index/forumDetail', query: {id: item.id}});
      }
    }
  }
</script>

<style rel="stylesheet/scss" lang="scss" scoped>
  .section {
    width: 900px;
    margin: 0 auto;
  }

  .section-content {
    display: flex;
    justify-content: space-between;
    line-height: 60px;
    cursor: pointer;
    box-sizing: border-box;
    padding: 0 10px;
  }
  .section-content:hover {
    background-color: #E4E7ED;
    color: #fff;
  }
  .item-style {
    color: #909399;
    font-weight: 400;
  }
  .section-btn {
    text-align: right;
    margin-bottom: 15px;
    padding-right: 10px;
  }
  
	.forum-preview .el-form-item /deep/ .el-form-item__content {
				display: flex;
				align-items: center;
			}
	
	.forum-preview .el-form-item .el-input /deep/ .el-input__inner {
				border: 1px solid #eee;
				border-radius: 0px 0 0 0px;
				padding: 0 10px;
				margin: 0;
				color: #666;
				width: 280px;
				font-size: 14px;
				line-height: 36px;
				height: 36px;
			}
	
	.forum-preview .searchBtn {
				cursor: pointer;
				padding: 0px 24px;
				margin: 0 10px 0 0;
				color: #fff;
				font-size: 14px;
				border-color: #eccc19;
				line-height: 36px;
				border-radius: 0 0px 0px 0;
				background: #b4a078;
				width: auto;
				border-width: 0;
				border-style: solid;
				height: 36px;
			}
	
	.forum-preview .searchBtn:hover {
			}
	
	.forum-preview .pubBtn {
				cursor: pointer;
				border: 1px solid #ddd;
				border-radius: 2px;
				padding: 0px 10px;
				margin: 0 10px 0 0;
				color: #333;
				background: #f6f6f6;
				width: auto;
				font-size: 14px;
				line-height: 36px;
				height: 36px;
			}
	
	.forum-preview .pubBtn:hover {
			}
	
	.forum-preview .z-box .section-content {
				cursor: pointer;
				padding: 0 20px;
				margin: 0 0 10px;
				color: #333;
				display: flex;
				border-color: #eee;
				line-height: 40px;
				background: none;
				width: 100%;
				border-width: 1px;
				align-items: center;
				border-style: solid;
				height: 40px;
			}
	
	.forum-preview .z-box .section-content:hover {
				color: #fff;
				background: #fcfcfc;
			}
  
  #pagination.el-pagination /deep/ .el-pagination__total {
  	  	margin: 0 5px 0 0;
  	  	color: #666;
  	  	font-weight: 400;
  	  	display: inline-block;
  	  	vertical-align: top;
  	  	font-size: 13px;
  	  	line-height: 22px;
  	  	height: 22px;
  	  }
  
  #pagination.el-pagination /deep/ .btn-prev {
  	  	border: 1px solid #ccc;
  	  	border-radius: 2px;
  	  	padding: 0;
  	  	margin: 0 0px;
  	  	color: #666;
  	  	background: #fff;
  	  	display: inline-block;
  	  	vertical-align: top;
  	  	font-size: 12px;
  	  	line-height: 20px;
  	  	min-width: 16px;
  	  	height: 24px;
  	  }
  
  #pagination.el-pagination /deep/ .btn-next {
  	  	border: 1px solid #ccc;
  	  	border-radius: 2px;
  	  	padding: 0 0px;
  	  	margin: 0 0px;
  	  	color: #666;
  	  	background: #fff;
  	  	display: inline-block;
  	  	vertical-align: top;
  	  	font-size: 12px;
  	  	line-height: 20px;
  	  	min-width: 16px;
  	  	height: 24px;
  	  }
  
  #pagination.el-pagination /deep/ .btn-prev:disabled {
  	  	border: 1px solid #ccc;
  	  	cursor: not-allowed;
  	  	border-radius: 2px;
  	  	padding: 0 0px;
  	  	margin: 0 5px;
  	  	color: #ccc;
  	  	background: #f4f4f5;
  	  	display: inline-block;
  	  	vertical-align: top;
  	  	font-size: 12px;
  	  	line-height: 22px;
  	  	height: 24px;
  	  }
  
  #pagination.el-pagination /deep/ .btn-next:disabled {
  	  	border: 1px solid #ccc;
  	  	cursor: not-allowed;
  	  	border-radius: 2px;
  	  	padding: 0 0px;
  	  	margin: 0 5px;
  	  	color: #ccc;
  	  	background: #f4f4f5;
  	  	display: inline-block;
  	  	vertical-align: top;
  	  	font-size: 12px;
  	  	line-height: 22px;
  	  	height: 24px;
  	  }
  
  #pagination.el-pagination /deep/ .el-pager {
  	  	padding: 0;
  	  	margin: 0;
  	  	display: inline-block;
  	  	vertical-align: top;
  	  }
  
  #pagination.el-pagination /deep/ .el-pager .number {
  	  	cursor: pointer;
  	  	border: 1px solid #ccc;
  	  	padding: 0 6px;
  	  	margin: 0 5px;
  	  	color: #666;
  	  	display: inline-block;
  	  	vertical-align: top;
  	  	font-size: 12px;
  	  	line-height: 24px;
  	  	border-radius: 2px;
  	  	background: #fff;
  	  	text-align: center;
  	  	min-width: 25px;
  	  	height: 24px;
  	  }
  
  #pagination.el-pagination /deep/ .el-pager .number:hover {
  	  	cursor: pointer;
  	  	border: 1px solid #666;
  	  	padding: 0 4px;
  	  	margin: 0 5px;
  	  	color: #fff;
  	  	display: inline-block;
  	  	vertical-align: top;
  	  	font-size: 12px;
  	  	line-height: 24px;
  	  	border-radius: 2px;
  	  	background: #000;
  	  	text-align: center;
  	  	min-width: 25px;
  	  	height: 24px;
  	  }
  
  #pagination.el-pagination /deep/ .el-pager .number.active {
  	  	cursor: default;
  	  	border: 0px solid #A2161B;
  	  	padding: 0 4px;
  	  	margin: 0 5px;
  	  	color: #fff;
  	  	display: inline-block;
  	  	vertical-align: top;
  	  	font-size: 12px;
  	  	line-height: 24px;
  	  	border-radius: 2px;
  	  	background: #000;
  	  	text-align: center;
  	  	min-width: 25px;
  	  	height: 24px;
  	  }
  
  #pagination.el-pagination /deep/ .el-pagination__sizes {
  	  	display: inline-block;
  	  	vertical-align: top;
  	  	font-size: 12px;
  	  	line-height: 22px;
  	  	height: 22px;
  	  }
  
  #pagination.el-pagination /deep/ .el-pagination__sizes .el-input {
  	  	border: 1px solid #ccc;
  	  	border-radius: 2px;
  	  	margin: 0 5px;
  	  	width: 80px;
  	  	position: relative;
  	  }
  
  #pagination.el-pagination /deep/ .el-pagination__sizes .el-input .el-input__inner {
  	  	border: 0px solid #DCDFE6;
  	  	cursor: pointer;
  	  	border-radius: 3px;
  	  	padding: 0 25px 0 8px;
  	  	color: #606266;
  	  	background: #FFF;
  	  	display: inline-block;
  	  	width: 100%;
  	  	font-size: 12px;
  	  	line-height: 20px;
  	  	text-align: center;
  	  	height: 24px;
  	  }
  
  #pagination.el-pagination /deep/ .el-pagination__sizes .el-input span.el-input__suffix {
  	  	top: 0;
  	  	position: absolute;
  	  	right: 0;
  	  	height: 100%;
  	  }
  
  #pagination.el-pagination /deep/ .el-pagination__sizes .el-input .el-input__suffix .el-select__caret {
  	  	cursor: pointer;
  	  	color: #C0C4CC;
  	  	width: 25px;
  	  	font-size: 14px;
  	  	line-height: 22px;
  	  	text-align: center;
  	  }
  
  #pagination.el-pagination /deep/ .el-pagination__jump {
  	  	margin: 0 0 0 24px;
  	  	color: #606266;
  	  	display: inline-block;
  	  	vertical-align: top;
  	  	font-size: 12px;
  	  	line-height: 22px;
  	  	height: 22px;
  	  }
  
  #pagination.el-pagination /deep/ .el-pagination__jump .el-input {
  	  	border-radius: 3px;
  	  	padding: 0 2px;
  	  	margin: 0 2px;
  	  	display: inline-block;
  	  	width: 50px;
  	  	font-size: 14px;
  	  	line-height: 18px;
  	  	position: relative;
  	  	text-align: center;
  	  	height: 22px;
  	  }
  
  #pagination.el-pagination /deep/ .el-pagination__jump .el-input .el-input__inner {
  	  	border: 1px solid #DCDFE6;
  	  	cursor: pointer;
  	  	padding: 0 3px;
  	  	color: #606266;
  	  	display: inline-block;
  	  	font-size: 14px;
  	  	line-height: 22px;
  	  	border-radius: 3px;
  	  	outline: 0;
  	  	background: #FFF;
  	  	width: 100%;
  	  	text-align: center;
  	  	height: 22px;
  	  }
</style>
