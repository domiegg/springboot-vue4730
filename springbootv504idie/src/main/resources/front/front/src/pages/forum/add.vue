<template>
  <div :style='{"minHeight":"500px","padding":"20px 20px 40px","margin":"0px auto","borderColor":"#ddd","background":"#fff","borderWidth":"0px","width":"1200px","position":"relative","borderStyle":"solid"}'>
    <div class="section-title" :style='{"padding":"0","margin":"20px auto 0","borderColor":"#ffc652","color":"#222","textAlign":"center","background":"none","borderWidth":"0px 0 0 ","width":"100%","fontSize":"24px","borderStyle":"solid","fontWeight":"500","height":"60px"}'>论坛</div>
	<div :style='{"padding":"20px","margin":"0px auto","borderColor":"#d3d3d3","borderRadius":"0px","background":"#fff","borderWidth":"0px","width":"1200px","borderStyle":"solid"}'>
		<el-button size="mini" @click="backClick">返回</el-button>
	</div>
    <el-form class="add-update-preview" :model="form" :rules="rules" ref="form" label-width="150px">
      <el-form-item :style='{"width":"100%","padding":"0px","margin":"0 0 20px","background":"none","display":"inline-block"}' label="标题" prop="title">
        <el-input v-model="form.title" placeholder="请输入标题"></el-input>
      </el-form-item>
      <el-form-item :style='{"width":"100%","padding":"0px","margin":"0 0 20px","background":"none","display":"inline-block"}' label="类型" prop="isdone">
        <el-radio-group v-model="form.isdone">
          <el-radio label="开放">公开</el-radio>
          <el-radio label="关闭">私人</el-radio>
        </el-radio-group>
      </el-form-item>
      <el-form-item :style='{"width":"100%","padding":"0px","margin":"0 0 20px","background":"none","display":"inline-block"}' label="内容" prop="content">
        <editor
            :style='{"minHeight":"200px","border":"0","outline":"none","color":"#333","borderRadius":"4px","width":"100%","lineHeight":"32px","fontSize":"14px"}'
            v-model="form.content" 
            class="editor" 
            action="file/upload">
        </editor>
      </el-form-item>
      <el-form-item :style='{"width":"100%","padding":"0","margin":"20px 0 0","textAlign":"center"}'>
        <el-button :style='{"border":"0px solid #eccc19","cursor":"pointer","padding":"0","margin":"0 20px 0 0","color":"#fff","borderRadius":"0px","background":"#b4a078","width":"150px","lineHeight":"40px","fontSize":"16px","height":"40px"}' type="primary" @click="submitForm('form')">{{this.isEdit ? '修改' : '发布帖子'}} </el-button>
        <el-button :style='{"border":"0px solid #ccc","cursor":"pointer","padding":"0","margin":"0","color":"#fff","borderRadius":"0px","background":"#999","width":"150px","lineHeight":"40px","fontSize":"16px","height":"40px"}' @click="resetForm('form')">重置</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<script>
  export default {
    //数据集合
    data() {
      return {
        form: {
          title: '',
          isdone: '开放',
          content: '',
          parentid: 0,
          userid: localStorage.getItem('frontUserid'),
          username: localStorage.getItem('username'),
		  toptime: ''
        },
        editorOption: {
          modules: {
            toolbar: [
              ["bold", "italic", "underline", "strike"],
              ["blockquote", "code-block"],
              [{ header: 1 }, { header: 2 }],
              [{ list: "ordered" }, { list: "bullet" }],
              [{ script: "sub" }, { script: "super" }],
              [{ indent: "-1" }, { indent: "+1" }],
              [{ direction: "rtl" }],
              [{ size: ["small", false, "large", "huge"] }],
              [{ header: [1, 2, 3, 4, 5, 6, false] }],
              [{ color: [] }, { background: [] }],
              [{ font: [] }],
              [{ align: [] }],
              ["clean"],
              ["image", "video"]
            ]
          }
        },
        isEdit: false,
        rules: {
          title: [
            { required: true, message: '请输入标题', trigger: 'blur' }
          ]
        }
      }
    },
    created() {
      if (this.$route.query.id != undefined) {
        this.isEdit = true;
        this.$http.get('forum/detail/' + this.$route.query.id,{}).then(res=>{
			if(res.data.code==0){
				this.form = res.data.data
			}
		})
      }
    },
    //方法集合
    methods: {
		// 返回按钮
		backClick(){
			history.back()
		},
      onEditorReady(editor) {
        editor.root.setAttribute('data-placeholder', "请输入内容...");
      },
      submitForm(formName) {
        this.$refs[formName].validate((valid) => {
          if (valid) {
			if(!this.isEdit){
				this.form.toptime = this.getCurDateTime()
			}
            this.$http.post(`forum/${this.isEdit ? 'update' : 'add'}`, this.form).then(res => {
              if (res.data.code === 0) {
                this.$message({
                  message: `${this.isEdit ? '修改' : '发布'}成功`,
                  type: 'success',
                  duration: 1500,
                  onClose: () => {
                    if (this.isEdit) {
                      this.$router.push('/index/myForumList');
                    } else {
                      this.$router.push('/index/forum');
                    }
                  }
                });
              } else {
                this.$message.error(res.data.msg);
              }
            });
          } else {
            return false;
          }
        });
      },
      resetForm(formName) {
        this.$refs[formName].resetFields();
      }
    }
  }
</script>

<style rel="stylesheet/scss" lang="scss" scoped>
  .add-update-preview .el-form-item /deep/ .el-form-item__label {
        padding: 0 10px 0 0;
        color: #666;
        font-weight: 500;
        width: 150px;
        font-size: 14px;
        line-height: 40px;
        text-align: right;
      }
  
  .add-update-preview .el-form-item /deep/ .el-form-item__content {
    margin-left: 150px;
  }
  
  .add-update-preview .el-input /deep/ .el-input__inner {
        border: 1px solid #ddd;
        padding: 0 12px;
        color: #666;
        font-size: 14px;
        border-color: #ddd;
        border-radius: 0px;
        box-shadow: 0 0 0px rgba(64, 158, 255, .5);
        outline: none;
        background: none;
        width: auto;
        border-width: 1px;
        border-style: solid;
        min-width: 200px;
        height: 40px;
      }
  
  .add-update-preview .el-select /deep/ .el-input__inner {
        border-radius: 0px;
        padding: 0 10px;
        color: #666;
        background: none;
        width: auto;
        font-size: 14px;
        border-color: #ddd;
        border-width: 1px;
        border-style: solid;
        min-width: 250px;
        height: 40px;
      }
  
  .add-update-preview .el-date-editor /deep/ .el-input__inner {
        border-radius: 0px;
        padding: 0 10px 0 30px;
        color: #666;
        background: none;
        width: auto;
        font-size: 14px;
        border-color: #ddd;
        border-width: 1px;
        border-style: solid;
        min-width: 250px;
        height: 40px;
      }
  
  .add-update-preview /deep/ .el-upload--picture-card {
  	background: transparent;
  	border: 0;
  	border-radius: 0;
  	width: auto;
  	height: auto;
  	line-height: initial;
  	vertical-align: middle;
  }
  
  .add-update-preview /deep/ .upload .upload-img {
        cursor: pointer;
        color: #999;
        font-size: 24px;
        border-color: #ddd;
        line-height: 54px;
        border-radius: 2px;
        background: none;
        width: auto;
        border-width: 1px;
        border-style: solid;
        text-align: center;
        min-width: 150px;
        height: 54px;
      }
  
  .add-update-preview /deep/ .el-upload-list .el-upload-list__item {
        cursor: pointer;
        color: #999;
        font-size: 24px;
        border-color: #ddd;
        line-height: 54px;
        border-radius: 2px;
        background: none;
        width: auto;
        border-width: 1px;
        border-style: solid;
        text-align: center;
        min-width: 150px;
        height: 54px;
      }
  
  .add-update-preview /deep/ .el-upload .el-icon-plus {
        cursor: pointer;
        color: #999;
        font-size: 24px;
        border-color: #ddd;
        line-height: 54px;
        border-radius: 2px;
        background: none;
        width: auto;
        border-width: 1px;
        border-style: solid;
        text-align: center;
        min-width: 150px;
        height: 54px;
      }
  
  .add-update-preview .el-textarea /deep/ .el-textarea__inner {
        border: 1px solid #ddd;
        border-radius: 0px;
        padding: 12px;
        box-shadow: 0 0 0px rgba(64, 158, 255, .5);
        outline: none;
        color: #666;
        background: none;
        width: 96%;
        font-size: 14px;
        height: 120px;
      }
</style>
