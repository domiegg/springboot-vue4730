<template>
<div :style='{"minHeight":"500px","padding":"20px 20px 40px","margin":"0px auto","borderColor":"#ddd","background":"#fff","borderWidth":"0px","width":"1200px","position":"relative","borderStyle":"solid"}'>
    <el-button :style='{"border":"0px solid #1abc9e30","cursor":"pointer","padding":"0 10px","margin":"0 10px 0 0","color":"#fff","borderRadius":"0px","background":"#b4a078","width":"auto","lineHeight":"34px","fontSize":"14px","height":"34px"}' type="warning" size="mini" @click="backClick" class="el-icon-back">返回</el-button>
	<div class="section-title" :style='{"padding":"0","margin":"20px auto 0","borderColor":"#ffc652","color":"#222","textAlign":"center","background":"none","borderWidth":"0px 0 0 ","width":"100%","fontSize":"24px","borderStyle":"solid","fontWeight":"500","height":"60px"}'>我的发布</div>
    <el-table
      :data="tableData"
      style="width: 100%">
      <el-table-column
        label="标题"
        prop="title">
      </el-table-column>
      <el-table-column
        label="发布时间"
        prop="addtime">
      </el-table-column>
      <el-table-column label="操作" width="150">
        <template slot-scope="scope">
          <el-button
            size="mini"
            @click="handleEdit(scope.$index, scope.row)">修改</el-button>
          <el-button
            size="mini"
            type="danger"
            @click="handleDelete(scope.$index, scope.row)">删除</el-button>
        </template>
      </el-table-column>
    </el-table>
	
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
    data() {
      return {
		layouts: '',
        tableData: [],
        total: 1,
        pageSize: 10,
        totalPage: 1
      }
    },
    created() {
      this.getMyForumList(1);
    },
    methods: {
      backClick() {
          this.$router.push('/index/center')
      },
      getMyForumList(page) {
        this.$http.get('forum/page', {params: {page, limit: this.pageSize, parentid: 0, sort: 'istop,toptime', order: 'desc,desc'}}).then(res => {
          if (res.data.code == 0) {
            this.tableData = res.data.data.list;
            this.total = res.data.data.total;
            this.pageSize = Number(res.data.data.pageSize);
            this.totalPage = res.data.data.totalPage;
          }
        });
      },
      curChange(page) {
        this.getMyForumList(page);
      },
      prevClick(page) {
        this.getMyForumList(page);
      },
      nextClick(page) {
        this.getMyForumList(page);
      },
      handleEdit(index, row) {
        this.$router.push({path: '/index/forumAdd', query: {id: row.id}})
      },
      handleDelete(index, row) {
        this.$confirm('是否确认删除?', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
          let delIds = new Array();
          delIds.push(row.id);
          this.$http.post('forum/delete', delIds).then(res => {
            if (res.data.code == 0) {
              this.$message({
                type: 'success',
                message: '删除成功!',
                duration: 1500,
                onClose: () => {
                  this.getMyForumList(1);
                }
              });
            }
          });
        });
      }
    }
  }
</script>

<style rel="stylesheet/scss" lang="scss" scoped>
  .section {
    width: 900px;
    margin: 0 auto;
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
