<template>
  <div :style='{"minHeight":"100vh","padding":"20px 20px 20px","overflow":"hidden","color":"#93a2a9","background":"#e9ecf3","fontSize":"14px","position":"relative"}'>
    <el-form
	  :style='{"border":"0px solid #bababa","padding":"40px 30px 20px","borderRadius":"0px","alignItems":"flex-start","flexWrap":"wrap","background":"rgba(255,255,255,1)","display":"flex","fontSize":"inherit"}'
      class="add-update-preview"
      ref="ruleForm"
      :model="ruleForm"
      label-width="150px"
    >  
     <el-row>
        <el-form-item :style='{"border":"0px solid #eee","padding":"0","margin":"0 0 36px 0","color":"inherit","borderRadius":"0px","width":"100%","fontSize":"inherit"}'   v-if="flag=='kaifarenyuan'"  label="开发账号" prop="kaifazhanghao">
          <el-input v-model="ruleForm.kaifazhanghao" readonly              placeholder="开发账号" clearable></el-input>
        </el-form-item>
        <el-form-item :style='{"border":"0px solid #eee","padding":"0","margin":"0 0 36px 0","color":"inherit","borderRadius":"0px","width":"100%","fontSize":"inherit"}'   v-if="flag=='kaifarenyuan'"  label="开发姓名" prop="kaifaxingming">
          <el-input v-model="ruleForm.kaifaxingming"               placeholder="开发姓名" clearable></el-input>
        </el-form-item>
        <el-form-item :style='{"border":"0px solid #eee","padding":"0","margin":"0 0 36px 0","color":"inherit","borderRadius":"0px","width":"100%","fontSize":"inherit"}' v-if="flag=='kaifarenyuan'"  label="性别" prop="xingbie">
          <el-select v-model="ruleForm.xingbie"  placeholder="请选择性别">
            <el-option
                v-for="(item,index) in kaifarenyuanxingbieOptions"
                v-bind:key="index"
                :label="item"
                :value="item">
            </el-option>
          </el-select>
        </el-form-item>
        <el-form-item :style='{"border":"0px solid #eee","padding":"0","margin":"0 0 36px 0","color":"inherit","borderRadius":"0px","width":"100%","fontSize":"inherit"}'   v-if="flag=='kaifarenyuan'"  label="年龄" prop="nianling">
          <el-input v-model="ruleForm.nianling"               placeholder="年龄" clearable></el-input>
        </el-form-item>
        <el-form-item :style='{"border":"0px solid #eee","padding":"0","margin":"0 0 36px 0","color":"inherit","borderRadius":"0px","width":"100%","fontSize":"inherit"}'   v-if="flag=='kaifarenyuan'"  label="手机号" prop="shoujihao">
          <el-input v-model="ruleForm.shoujihao"               placeholder="手机号" clearable></el-input>
        </el-form-item>
        <el-form-item :style='{"border":"0px solid #eee","padding":"0","margin":"0 0 36px 0","color":"inherit","borderRadius":"0px","width":"100%","fontSize":"inherit"}' v-if="flag=='kaifarenyuan'" label="头像" prop="touxiang">
          <file-upload
          tip="点击上传头像"
          action="file/upload"
          :limit="3"
          :multiple="true"
          :fileUrls="ruleForm.touxiang?ruleForm.touxiang:''"
          @change="kaifarenyuantouxiangUploadChange"
          ></file-upload>
        </el-form-item>
        <el-form-item :style='{"border":"0px solid #eee","padding":"0","margin":"0 0 36px 0","color":"inherit","borderRadius":"0px","width":"100%","fontSize":"inherit"}'   v-if="flag=='ceshirenyuan'"  label="测试账号" prop="ceshizhanghao">
          <el-input v-model="ruleForm.ceshizhanghao" readonly              placeholder="测试账号" clearable></el-input>
        </el-form-item>
        <el-form-item :style='{"border":"0px solid #eee","padding":"0","margin":"0 0 36px 0","color":"inherit","borderRadius":"0px","width":"100%","fontSize":"inherit"}'   v-if="flag=='ceshirenyuan'"  label="测试姓名" prop="ceshixingming">
          <el-input v-model="ruleForm.ceshixingming"               placeholder="测试姓名" clearable></el-input>
        </el-form-item>
        <el-form-item :style='{"border":"0px solid #eee","padding":"0","margin":"0 0 36px 0","color":"inherit","borderRadius":"0px","width":"100%","fontSize":"inherit"}' v-if="flag=='ceshirenyuan'"  label="性别" prop="xingbie">
          <el-select v-model="ruleForm.xingbie"  placeholder="请选择性别">
            <el-option
                v-for="(item,index) in ceshirenyuanxingbieOptions"
                v-bind:key="index"
                :label="item"
                :value="item">
            </el-option>
          </el-select>
        </el-form-item>
        <el-form-item :style='{"border":"0px solid #eee","padding":"0","margin":"0 0 36px 0","color":"inherit","borderRadius":"0px","width":"100%","fontSize":"inherit"}'   v-if="flag=='ceshirenyuan'"  label="年龄" prop="nianling">
          <el-input v-model="ruleForm.nianling"               placeholder="年龄" clearable></el-input>
        </el-form-item>
        <el-form-item :style='{"border":"0px solid #eee","padding":"0","margin":"0 0 36px 0","color":"inherit","borderRadius":"0px","width":"100%","fontSize":"inherit"}'   v-if="flag=='ceshirenyuan'"  label="手机号" prop="shoujihao">
          <el-input v-model="ruleForm.shoujihao"               placeholder="手机号" clearable></el-input>
        </el-form-item>
        <el-form-item :style='{"border":"0px solid #eee","padding":"0","margin":"0 0 36px 0","color":"inherit","borderRadius":"0px","width":"100%","fontSize":"inherit"}' v-if="flag=='ceshirenyuan'" label="头像" prop="touxiang">
          <file-upload
          tip="点击上传头像"
          action="file/upload"
          :limit="3"
          :multiple="true"
          :fileUrls="ruleForm.touxiang?ruleForm.touxiang:''"
          @change="ceshirenyuantouxiangUploadChange"
          ></file-upload>
        </el-form-item>
		<el-form-item :style='{"border":"0px solid #eee","padding":"0","margin":"0 0 36px 0","color":"inherit","borderRadius":"0px","width":"100%","fontSize":"inherit"}' v-if="flag=='users'" label="用户名" prop="username">
			<el-input v-model="ruleForm.username" placeholder="用户名"></el-input>
		</el-form-item>
		<el-form-item :style='{"border":"0px solid #eee","padding":"0","margin":"0 0 36px 0","color":"inherit","borderRadius":"0px","width":"100%","fontSize":"inherit"}' v-if="flag=='users'" label="头像" prop="image">
		  <file-upload
		  tip="点击上传头像"
		  action="file/upload"
		  :limit="1"
		  :multiple="false"
		  :fileUrls="ruleForm.image?ruleForm.image:''"
		  @change="usersimageUploadChange"
		  ></file-upload>
		</el-form-item>
		<el-form-item :style='{"padding":"10px 0 20px","margin":"30px 0","alignItems":"center","textAlign":"center","display":"flex","width":"100%","perspective":"320px","-webkitPerspective":"320px","fontSize":"48px","justifyContent":"flex-start"}'>
			<el-button class="btn3" :style='{"border":"0px solid #0260ad","cursor":"pointer","padding":"0 20px","margin":"0px 4px","outline":"none","color":"#fff","borderRadius":"0px","background":"#0e90d2","width":"auto","fontSize":"14px","lineHeight":"24px","height":"36px"}' type="primary" @click="onUpdateHandler">
				<span class="icon iconfont icon-tijiao16" :style='{"margin":"0 2px","fontSize":"18px","color":"inherit","display":"none"}'></span>
				保存修改
			</el-button>
		</el-form-item>
      </el-row>
    </el-form>
  </div>
</template>
<script>
// 数字，邮件，手机，url，身份证校验
import { isNumber,isIntNumer,isEmail,isMobile,isPhone,isURL,checkIdCard } from "@/utils/validate";

export default {
  data() {
    return {
      ruleForm: {},
      flag: '',
      usersFlag: false,
      kaifarenyuanxingbieOptions: [],
      ceshirenyuanxingbieOptions: [],
    };
  },
  mounted() {
    var table = this.$storage.get("sessionTable");
    this.flag = table;
    this.$http({
      url: `${this.$storage.get("sessionTable")}/session`,
      method: "get"
    }).then(({ data }) => {
      if (data && data.code === 0) {
        this.ruleForm = data.data;
      } else {
        this.$message.error(data.msg);
      }
    });
    this.kaifarenyuanxingbieOptions = "男,女".split(',')
    this.ceshirenyuanxingbieOptions = "男,女".split(',')
  },
  methods: {
    kaifarenyuantouxiangUploadChange(fileUrls) {
        this.ruleForm.touxiang = fileUrls;
    },
    ceshirenyuantouxiangUploadChange(fileUrls) {
        this.ruleForm.touxiang = fileUrls;
    },
	usersimageUploadChange(fileUrls) {
		this.ruleForm.image = fileUrls;
	},
    onUpdateHandler() {
      if((!this.ruleForm.kaifazhanghao)&& 'kaifarenyuan'==this.flag){
        this.$message.error('开发账号不能为空');
        return
      }


      if((!this.ruleForm.mima)&& 'kaifarenyuan'==this.flag){
        this.$message.error('密码不能为空');
        return
      }

      if((!this.ruleForm.kaifaxingming)&& 'kaifarenyuan'==this.flag){
        this.$message.error('开发姓名不能为空');
        return
      }








      if( 'kaifarenyuan' ==this.flag && this.ruleForm.shoujihao&&(!isMobile(this.ruleForm.shoujihao))){
        this.$message.error(`手机号应输入手机格式`);
        return
      }


        if(this.ruleForm.touxiang!=null) {
                this.ruleForm.touxiang = this.ruleForm.touxiang.replace(new RegExp(this.$base.url,"g"),"");
        }
      if((!this.ruleForm.ceshizhanghao)&& 'ceshirenyuan'==this.flag){
        this.$message.error('测试账号不能为空');
        return
      }


      if((!this.ruleForm.mima)&& 'ceshirenyuan'==this.flag){
        this.$message.error('密码不能为空');
        return
      }

      if((!this.ruleForm.ceshixingming)&& 'ceshirenyuan'==this.flag){
        this.$message.error('测试姓名不能为空');
        return
      }








      if( 'ceshirenyuan' ==this.flag && this.ruleForm.shoujihao&&(!isMobile(this.ruleForm.shoujihao))){
        this.$message.error(`手机号应输入手机格式`);
        return
      }


        if(this.ruleForm.touxiang!=null) {
                this.ruleForm.touxiang = this.ruleForm.touxiang.replace(new RegExp(this.$base.url,"g"),"");
        }
      if('users'==this.flag && this.ruleForm.username.trim().length<1) {
	this.$message.error(`用户名不能为空`);
        return	
      }
	  if(this.flag=='users'){
	  	this.ruleForm.image = this.ruleForm.image.replace(new RegExp(this.$base.url,"g"),"")
	  }
      this.$http({
        url: `${this.$storage.get("sessionTable")}/update`,
        method: "post",
        data: this.ruleForm
      }).then(({ data }) => {
        if (data && data.code === 0) {
          this.$message({
            message: "修改信息成功",
            type: "success",
            duration: 1500,
            onClose: () => {
				if(this.flag=='users'){
					this.$storage.set('headportrait',this.ruleForm.image)
				}
            }
          });
        } else {
          this.$message.error(data.msg);
        }
      });
    }
  }
};
</script>
<style lang="scss" scoped>
	.el-date-editor.el-input {
		width: auto;
	}
	
	.add-update-preview .el-form-item /deep/ .el-form-item__label {
	  	  padding: 0 10px 0 0;
	  	  color: #999;
	  	  font-weight: 500;
	  	  display: inline-block;
	  	  width: 150px;
	  	  font-size: inherit;
	  	  line-height: 40px;
	  	  text-align: right;
	  	}
	
	.add-update-preview .el-form-item /deep/ .el-form-item__content {
	  margin-left: 150px;
	}
	
	.add-update-preview .el-input /deep/ .el-input__inner {
	  	  border-radius: 0px;
	  	  padding: 0 12px;
	  	  box-shadow: 0 0 0px rgba(64, 158, 255, .5);
	  	  color: inherit;
	  	  background: none;
	  	  width: 300px;
	  	  font-size: 14px;
	  	  border-color: #ccc;
	  	  border-width: 1px;
	  	  border-style: solid;
	  	  height: 39px;
	  	}
	
	.add-update-preview .el-select /deep/ .el-input__inner {
	  	  border-radius: 0px;
	  	  padding: 0 10px;
	  	  box-shadow: 0 0 0px rgba(64, 158, 255, .5);
	  	  color: inherit;
	  	  background: none;
	  	  width: 300px;
	  	  font-size: 14px;
	  	  border-color: #ccc;
	  	  border-width: 1px;
	  	  border-style: solid;
	  	  height: 39px;
	  	}
	
	.add-update-preview .el-date-editor /deep/ .el-input__inner {
	  	  border-radius: 0px;
	  	  padding: 0 10px 0 30px;
	  	  box-shadow: 0 0 0px rgba(64, 158, 255, .5);
	  	  outline: none;
	  	  color: inherit;
	  	  background: none;
	  	  width: 300px;
	  	  font-size: 14px;
	  	  border-color: #ccc;
	  	  border-width: 1px;
	  	  border-style: solid;
	  	  height: 39px;
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
	
	.add-update-preview /deep/ .el-upload-list .el-upload-list__item {
	  	  cursor: pointer;
	  	  color: #bbb;
	  	  object-fit: cover;
	  	  font-size: 24px;
	  	  border-color: #ccc;
	  	  line-height: 80px;
	  	  border-radius: 0px;
	  	  background: none;
	  	  width: 120px;
	  	  border-width: 1px;
	  	  border-style: solid;
	  	  text-align: center;
	  	  height: 80px;
	  	}
	
	.add-update-preview /deep/ .el-upload .el-icon-plus {
	  	  cursor: pointer;
	  	  color: #bbb;
	  	  object-fit: cover;
	  	  font-size: 24px;
	  	  border-color: #ccc;
	  	  line-height: 80px;
	  	  border-radius: 0px;
	  	  background: none;
	  	  width: 120px;
	  	  border-width: 1px;
	  	  border-style: solid;
	  	  text-align: center;
	  	  height: 80px;
	  	}
	
	.add-update-preview .el-textarea /deep/ .el-textarea__inner {
	  	  padding: 12px;
	  	  color: inherit;
	  	  font-size: 14px;
	  	  border-color: #ccc;
	  	  min-height: 120px;
	  	  border-radius: 0px;
	  	  box-shadow: 0 0 0px rgba(64, 158, 255, .5);
	  	  outline: none;
	  	  background: none;
	  	  width: auto;
	  	  border-width: 1px;
	  	  border-style: solid;
	  	  min-width: 400px;
	  	  height: auto;
	  	}
	
	.add-update-preview .btn3 {
				border: 0px solid #0260ad;
				cursor: pointer;
				border-radius: 0px;
				padding: 0 20px;
				margin: 0px 4px;
				outline: none;
				color: #fff;
				background: #0e90d2;
				width: auto;
				font-size: 14px;
				line-height: 24px;
				height: 36px;
			}
	
	.add-update-preview .btn3:hover {
			}
	
	.editor>.avatar-uploader {
		line-height: 0;
		height: 0;
	}
</style>
