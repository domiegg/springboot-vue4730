<template>
	<div>

	<div class="container" :style='{"minHeight":"100vh","alignItems":"center","background":"url(http://codegen.caihongy.cn/20240305/e457456d29994b099927c39c8d5bec96.jpg)","display":"flex","width":"100%","backgroundSize":"cover","backgroundPosition":"center center","backgroundRepeat":"no-repeat","justifyContent":"center"}'>
		<el-form class='rgs-form' v-if="pageFlag=='register'" :style='{"border":"4px groove #333","padding":"30px 20px 30px 20px","boxShadow":"0px 26px 26px -30px #333","margin":"0 auto","alignItems":"center","textAlign":"center","flexDirection":"column","display":"flex","justifyContent":"center","minHeight":"500px","borderRadius":"20px","flexWrap":"wrap","background":"rgba(255,255,255,.9)","width":"600px","position":"relative","height":"auto"}' ref="registerForm" :model="registerForm" :rules="rules">
			<div v-if="false" :style='{"width":"100%","margin":"0 0 10px 0","lineHeight":"44px","fontSize":"20px","color":"rgba(64, 158, 255, 1)","textAlign":"center"}'>USER / REGISTER</div>
			<div v-if="true" :style='{"margin":"0px auto 10px","-webkit-text-stroke":"6px transparent","color":"#fff","textAlign":"center","background":"#000","-webkitTextFillColor":"#ffffff","width":"100%","letterSpacing":"6px","lineHeight":"44px","fontSize":"24px","-webkitBackgroundClip":"text"}'>基于软件研发过程中的缺陷管理系统的设计与实现注册</p></div>
			<el-form-item :style='{"width":"100%","padding":"0","margin":"0 auto 15px","textAlign":"left","height":"auto"}' v-if="tableName=='kaifarenyuan'" prop="kaifazhanghao">
				<div v-if="true" :style='{"padding":"0 10px","color":"#333","textAlign":"right","background":"none","display":"inline-block","width":"150px","lineHeight":"36px","fontSize":"14px"}' :class="changeRules('kaifazhanghao')?'required':''">开发账号：</div>
				<el-input v-model="registerForm.kaifazhanghao"  placeholder="请输入开发账号" />
			</el-form-item>
			<el-form-item :style='{"width":"100%","padding":"0","margin":"0 auto 15px","textAlign":"left","height":"auto"}' v-if="tableName=='kaifarenyuan'" prop="mima">
				<div v-if="true" :style='{"padding":"0 10px","color":"#333","textAlign":"right","background":"none","display":"inline-block","width":"150px","lineHeight":"36px","fontSize":"14px"}' :class="changeRules('mima')?'required':''">密码：</div>
				<el-input v-model="registerForm.mima" type="password" placeholder="请输入密码" />
			</el-form-item>
			<el-form-item :style='{"width":"100%","padding":"0","margin":"0 auto 15px","textAlign":"left","height":"auto"}' v-if="tableName=='kaifarenyuan'" prop="mima2">
				<div v-if="true" :style='{"padding":"0 10px","color":"#333","textAlign":"right","background":"none","display":"inline-block","width":"150px","lineHeight":"36px","fontSize":"14px"}' :class="changeRules('mima')?'required':''">确认密码：</div>
				<el-input v-model="registerForm.mima2" type="password" placeholder="请再次输入密码" />
			</el-form-item>
			<el-form-item :style='{"width":"100%","padding":"0","margin":"0 auto 15px","textAlign":"left","height":"auto"}' v-if="tableName=='kaifarenyuan'" prop="kaifaxingming">
				<div v-if="true" :style='{"padding":"0 10px","color":"#333","textAlign":"right","background":"none","display":"inline-block","width":"150px","lineHeight":"36px","fontSize":"14px"}' :class="changeRules('kaifaxingming')?'required':''">开发姓名：</div>
				<el-input v-model="registerForm.kaifaxingming"  placeholder="请输入开发姓名" />
			</el-form-item>
			<el-form-item :style='{"width":"100%","padding":"0","margin":"0 auto 15px","textAlign":"left","height":"auto"}' v-if="tableName=='kaifarenyuan'" prop="xingbie">
				<div v-if="true" :style='{"padding":"0 10px","color":"#333","textAlign":"right","background":"none","display":"inline-block","width":"150px","lineHeight":"36px","fontSize":"14px"}' :class="changeRules('xingbie')?'required':''">性别：</div>
                <el-select v-model="registerForm.xingbie" placeholder="请选择性别" >
                  <el-option
                      v-for="(item,index) in kaifarenyuanxingbieOptions"
                      :key="index"
                      :label="item"
                      :value="item">
                  </el-option>
                </el-select>
			</el-form-item>
			<el-form-item :style='{"width":"100%","padding":"0","margin":"0 auto 15px","textAlign":"left","height":"auto"}' v-if="tableName=='kaifarenyuan'" prop="nianling">
				<div v-if="true" :style='{"padding":"0 10px","color":"#333","textAlign":"right","background":"none","display":"inline-block","width":"150px","lineHeight":"36px","fontSize":"14px"}' :class="changeRules('nianling')?'required':''">年龄：</div>
				<el-input v-model="registerForm.nianling"  placeholder="请输入年龄" />
			</el-form-item>
			<el-form-item :style='{"width":"100%","padding":"0","margin":"0 auto 15px","textAlign":"left","height":"auto"}' v-if="tableName=='kaifarenyuan'" prop="shoujihao">
				<div v-if="true" :style='{"padding":"0 10px","color":"#333","textAlign":"right","background":"none","display":"inline-block","width":"150px","lineHeight":"36px","fontSize":"14px"}' :class="changeRules('shoujihao')?'required':''">手机号：</div>
				<el-input v-model="registerForm.shoujihao"  placeholder="请输入手机号" />
			</el-form-item>
			<el-form-item :style='{"width":"100%","padding":"0","margin":"0 auto 15px","textAlign":"left","height":"auto"}' v-if="tableName=='kaifarenyuan'" prop="touxiang">
				<div v-if="true" :style='{"padding":"0 10px","color":"#333","textAlign":"right","background":"none","display":"inline-block","width":"150px","lineHeight":"36px","fontSize":"14px"}' :class="changeRules('touxiang')?'required':''">头像：</div>
                <file-upload
					tip="点击上传头像"
					action="file/upload"
					:limit="1"
					:multiple="true"
					:fileUrls="registerForm.touxiang?registerForm.touxiang:''"
					@change="kaifarenyuantouxiangUploadChange"
				></file-upload>
			</el-form-item>
			<el-form-item :style='{"width":"100%","padding":"0","margin":"0 auto 15px","textAlign":"left","height":"auto"}' v-if="tableName=='ceshirenyuan'" prop="ceshizhanghao">
				<div v-if="true" :style='{"padding":"0 10px","color":"#333","textAlign":"right","background":"none","display":"inline-block","width":"150px","lineHeight":"36px","fontSize":"14px"}' :class="changeRules('ceshizhanghao')?'required':''">测试账号：</div>
				<el-input v-model="registerForm.ceshizhanghao"  placeholder="请输入测试账号" />
			</el-form-item>
			<el-form-item :style='{"width":"100%","padding":"0","margin":"0 auto 15px","textAlign":"left","height":"auto"}' v-if="tableName=='ceshirenyuan'" prop="mima">
				<div v-if="true" :style='{"padding":"0 10px","color":"#333","textAlign":"right","background":"none","display":"inline-block","width":"150px","lineHeight":"36px","fontSize":"14px"}' :class="changeRules('mima')?'required':''">密码：</div>
				<el-input v-model="registerForm.mima" type="password" placeholder="请输入密码" />
			</el-form-item>
			<el-form-item :style='{"width":"100%","padding":"0","margin":"0 auto 15px","textAlign":"left","height":"auto"}' v-if="tableName=='ceshirenyuan'" prop="mima2">
				<div v-if="true" :style='{"padding":"0 10px","color":"#333","textAlign":"right","background":"none","display":"inline-block","width":"150px","lineHeight":"36px","fontSize":"14px"}' :class="changeRules('mima')?'required':''">确认密码：</div>
				<el-input v-model="registerForm.mima2" type="password" placeholder="请再次输入密码" />
			</el-form-item>
			<el-form-item :style='{"width":"100%","padding":"0","margin":"0 auto 15px","textAlign":"left","height":"auto"}' v-if="tableName=='ceshirenyuan'" prop="ceshixingming">
				<div v-if="true" :style='{"padding":"0 10px","color":"#333","textAlign":"right","background":"none","display":"inline-block","width":"150px","lineHeight":"36px","fontSize":"14px"}' :class="changeRules('ceshixingming')?'required':''">测试姓名：</div>
				<el-input v-model="registerForm.ceshixingming"  placeholder="请输入测试姓名" />
			</el-form-item>
			<el-form-item :style='{"width":"100%","padding":"0","margin":"0 auto 15px","textAlign":"left","height":"auto"}' v-if="tableName=='ceshirenyuan'" prop="xingbie">
				<div v-if="true" :style='{"padding":"0 10px","color":"#333","textAlign":"right","background":"none","display":"inline-block","width":"150px","lineHeight":"36px","fontSize":"14px"}' :class="changeRules('xingbie')?'required':''">性别：</div>
                <el-select v-model="registerForm.xingbie" placeholder="请选择性别" >
                  <el-option
                      v-for="(item,index) in ceshirenyuanxingbieOptions"
                      :key="index"
                      :label="item"
                      :value="item">
                  </el-option>
                </el-select>
			</el-form-item>
			<el-form-item :style='{"width":"100%","padding":"0","margin":"0 auto 15px","textAlign":"left","height":"auto"}' v-if="tableName=='ceshirenyuan'" prop="nianling">
				<div v-if="true" :style='{"padding":"0 10px","color":"#333","textAlign":"right","background":"none","display":"inline-block","width":"150px","lineHeight":"36px","fontSize":"14px"}' :class="changeRules('nianling')?'required':''">年龄：</div>
				<el-input v-model="registerForm.nianling"  placeholder="请输入年龄" />
			</el-form-item>
			<el-form-item :style='{"width":"100%","padding":"0","margin":"0 auto 15px","textAlign":"left","height":"auto"}' v-if="tableName=='ceshirenyuan'" prop="shoujihao">
				<div v-if="true" :style='{"padding":"0 10px","color":"#333","textAlign":"right","background":"none","display":"inline-block","width":"150px","lineHeight":"36px","fontSize":"14px"}' :class="changeRules('shoujihao')?'required':''">手机号：</div>
				<el-input v-model="registerForm.shoujihao"  placeholder="请输入手机号" />
			</el-form-item>
			<el-form-item :style='{"width":"100%","padding":"0","margin":"0 auto 15px","textAlign":"left","height":"auto"}' v-if="tableName=='ceshirenyuan'" prop="touxiang">
				<div v-if="true" :style='{"padding":"0 10px","color":"#333","textAlign":"right","background":"none","display":"inline-block","width":"150px","lineHeight":"36px","fontSize":"14px"}' :class="changeRules('touxiang')?'required':''">头像：</div>
                <file-upload
					tip="点击上传头像"
					action="file/upload"
					:limit="1"
					:multiple="true"
					:fileUrls="registerForm.touxiang?registerForm.touxiang:''"
					@change="ceshirenyuantouxiangUploadChange"
				></file-upload>
			</el-form-item>
			<el-button :style='{"border":"0","cursor":"pointer","padding":"0 24px","margin":"20px 0px 20px 0","color":"#fff","borderRadius":"4px","background":"#b4a078","display":"inline-block","width":"auto","letterSpacing":"4px","fontSize":"16px","height":"36px"}' type="primary" @click="submitForm('registerForm')">注册</el-button>
			<el-button :style='{"border":"1px solid #fff","cursor":"pointer","padding":"0 24px","margin":"0","color":"#666","textAlign":"center","display":"inline-block","letterSpacing":"4px","textDecoration":"underline","borderRadius":"4px","background":"rgba(255,255,255,.5)","width":"100px","fontSize":"16px","height":"36px"}' @click="resetForm('registerForm')">重置</el-button>
			<router-link :style='{"cursor":"pointer","padding":"0px 8px","margin":"0px 0 0 0","color":"#666","borderRadius":"4px","textAlign":"right","background":"none","display":"inline-block","width":"100%","lineHeight":"20px","fontSize":"14px","textDecoration":"underline"}' to="/login">已有账户登录</router-link>
			<div class="idea1" :style='{"width":"100%","background":"red","display":"none","height":"40px"}'></div>
			<div class="idea2" :style='{"width":"100%","background":"blue","display":"none","height":"40px"}'></div>
		</el-form>
    </div>
  </div>
</div>
</template>

<script>

export default {
    //数据集合
    data() {
		return {
            pageFlag : '',
			tableName: '',
			registerForm: {},
			forgetForm: {},
			rules: {},
			requiredRules: {},
            kaifarenyuanxingbieOptions: [],
            ceshirenyuanxingbieOptions: [],
		}
    },
	mounted() {
		if(this.$route.query.pageFlag=='register'){
			this.tableName = this.$route.query.role;
			if(this.tableName=='kaifarenyuan'){
				this.registerForm = {
					kaifazhanghao: '',
					mima: '',
					mima2: '',
					kaifaxingming: '',
					xingbie: '',
					nianling: '',
					shoujihao: '',
					touxiang: '',
				}
			}
			if(this.tableName=='ceshirenyuan'){
				this.registerForm = {
					ceshizhanghao: '',
					mima: '',
					mima2: '',
					ceshixingming: '',
					xingbie: '',
					nianling: '',
					shoujihao: '',
					touxiang: '',
				}
			}
			if ('kaifarenyuan' == this.tableName) {
				this.requiredRules.kaifazhanghao = [{ required: true, message: '请输入开发账号', trigger: 'blur' }]
			}
			if ('kaifarenyuan' == this.tableName) {
				this.requiredRules.mima = [{ required: true, message: '请输入密码', trigger: 'blur' }]
			}
			if ('kaifarenyuan' == this.tableName) {
				this.requiredRules.kaifaxingming = [{ required: true, message: '请输入开发姓名', trigger: 'blur' }]
			}
			if ('ceshirenyuan' == this.tableName) {
				this.requiredRules.ceshizhanghao = [{ required: true, message: '请输入测试账号', trigger: 'blur' }]
			}
			if ('ceshirenyuan' == this.tableName) {
				this.requiredRules.mima = [{ required: true, message: '请输入密码', trigger: 'blur' }]
			}
			if ('ceshirenyuan' == this.tableName) {
				this.requiredRules.ceshixingming = [{ required: true, message: '请输入测试姓名', trigger: 'blur' }]
			}
		}
	},
    created() {
		this.pageFlag = this.$route.query.pageFlag;
		if(this.$route.query.pageFlag=='register'){
		  if ('kaifarenyuan' == this.tableName) {
			this.rules.kaifazhanghao = [{ required: true, message: '请输入开发账号', trigger: 'blur' }];
		  }
		  if ('kaifarenyuan' == this.tableName) {
			this.rules.mima = [{ required: true, message: '请输入密码', trigger: 'blur' }];
		  }
		  if ('kaifarenyuan' == this.tableName) {
			this.rules.kaifaxingming = [{ required: true, message: '请输入开发姓名', trigger: 'blur' }];
		  }
			this.kaifarenyuanxingbieOptions = "男,女".split(',');
		  if ('kaifarenyuan' == this.tableName) {
			this.rules.shoujihao = [{ required: true, validator: this.$validate.isMobile, trigger: 'blur' }];
		  }
		  if ('ceshirenyuan' == this.tableName) {
			this.rules.ceshizhanghao = [{ required: true, message: '请输入测试账号', trigger: 'blur' }];
		  }
		  if ('ceshirenyuan' == this.tableName) {
			this.rules.mima = [{ required: true, message: '请输入密码', trigger: 'blur' }];
		  }
		  if ('ceshirenyuan' == this.tableName) {
			this.rules.ceshixingming = [{ required: true, message: '请输入测试姓名', trigger: 'blur' }];
		  }
			this.ceshirenyuanxingbieOptions = "男,女".split(',');
		  if ('ceshirenyuan' == this.tableName) {
			this.rules.shoujihao = [{ required: true, validator: this.$validate.isMobile, trigger: 'blur' }];
		  }
		}
    },
    //方法集合
    methods: {
		changeRules(name){
			if(this.requiredRules[name]){
				return true
			}
			return false
		},
      // 获取uuid
      getUUID () {
        return new Date().getTime();
      },
        // 下二随
      kaifarenyuantouxiangUploadChange(fileUrls) {
          this.registerForm.touxiang = fileUrls.replace(new RegExp(this.$config.baseUrl,"g"),"");
      },
      ceshirenyuantouxiangUploadChange(fileUrls) {
          this.registerForm.touxiang = fileUrls.replace(new RegExp(this.$config.baseUrl,"g"),"");
      },

        // 多级联动参数


      submitForm(formName) {
        this.$refs[formName].validate((valid) => {
          if (valid) {
            var url=this.tableName+"/register";
				if((!this.registerForm.kaifazhanghao) && `kaifarenyuan` == this.tableName){
					this.$message.error(`开发账号不能为空`);
					return
				}
               if(`kaifarenyuan` == this.tableName && this.registerForm.mima!=this.registerForm.mima2) {
                this.$message.error(`两次密码输入不一致`);
                return
               }
				if((!this.registerForm.mima) && `kaifarenyuan` == this.tableName){
					this.$message.error(`密码不能为空`);
					return
				}
				if((!this.registerForm.kaifaxingming) && `kaifarenyuan` == this.tableName){
					this.$message.error(`开发姓名不能为空`);
					return
				}
					if(`kaifarenyuan` == this.tableName && this.registerForm.shoujihao &&(!this.$validate.isMobile2(this.registerForm.shoujihao))){
						this.$message.error(`手机号应输入手机格式`);
						return
					}
				if((!this.registerForm.ceshizhanghao) && `ceshirenyuan` == this.tableName){
					this.$message.error(`测试账号不能为空`);
					return
				}
               if(`ceshirenyuan` == this.tableName && this.registerForm.mima!=this.registerForm.mima2) {
                this.$message.error(`两次密码输入不一致`);
                return
               }
				if((!this.registerForm.mima) && `ceshirenyuan` == this.tableName){
					this.$message.error(`密码不能为空`);
					return
				}
				if((!this.registerForm.ceshixingming) && `ceshirenyuan` == this.tableName){
					this.$message.error(`测试姓名不能为空`);
					return
				}
					if(`ceshirenyuan` == this.tableName && this.registerForm.shoujihao &&(!this.$validate.isMobile2(this.registerForm.shoujihao))){
						this.$message.error(`手机号应输入手机格式`);
						return
					}
            this.$http.post(url, this.registerForm).then(res => {
              if (res.data.code === 0) {
                this.$message({
                  message: '注册成功',
                  type: 'success',
                  duration: 1500,
                  onClose: () => {
                    this.$router.push('/login');
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
	.container {
		position: relative;
		background: url(http://codegen.caihongy.cn/20240305/e457456d29994b099927c39c8d5bec96.jpg);
		
		.el-input {
		  width: auto;
		}
		
		.el-date-editor.el-input {
			width: auto;
		}
		
		.el-form-item /deep/ .el-form-item__content {
						display: flex;
						flex-wrap: wrap;
					}
		
		.rgs-form .el-input /deep/ .el-input__inner {
						border-radius: 0px;
						padding: 0 10px;
						color: #666;
						background: rgba(255,255,255,.9);
						width: 100%;
						font-size: 14px;
						border-color: #ddd;
						border-width: 0 0 1px;
						border-style: dashed;
						min-width: 300px;
						height: 40px;
					}
		
		.rgs-form .el-select /deep/ .el-input__inner {
						border-radius: 0px;
						padding: 0 10px;
						color: #666;
						background: rgba(255,255,255,.9);
						width: auto;
						font-size: 14px;
						border-color: #ddd;
						border-width: 0 0 1px;
						border-style: dashed;
						min-width: 300px;
						height: 40px;
					}
		
		.rgs-form .el-date-editor /deep/ .el-input__inner {
						border-radius: 0px;
						padding: 0 10px 0 30px;
						color: #666;
						background: rgba(255,255,255,.9);
						width: auto;
						font-size: 14px;
						border-color: #ddd;
						border-width: 0 0 1px;
						border-style: dashed;
						min-width: 300px;
						height: 40px;
					}
		
		.rgs-form .el-date-editor /deep/ .el-input__inner {
						border-radius: 0px;
						padding: 0 10px 0 30px;
						color: #666;
						background: rgba(255,255,255,.9);
						width: auto;
						font-size: 14px;
						border-color: #ddd;
						border-width: 0 0 1px;
						border-style: dashed;
						min-width: 300px;
						height: 40px;
					}
		
		.rgs-form /deep/ .el-upload--picture-card {
			background: transparent;
			border: 0;
			border-radius: 0;
			width: auto;
			height: auto;
			line-height: initial;
			vertical-align: middle;
		}
		
		.rgs-form /deep/ .upload .upload-img {
		  		  cursor: pointer;
		  		  border-radius: 0px;
		  		  color: #999;
		  		  background: rgba(255,255,255,.9);
		  		  width: 100px;
		  		  font-size: 24px;
		  		  border-color: #ddd;
		  		  border-width: 1px;
		  		  line-height: 60px;
		  		  border-style: dashed;
		  		  text-align: center;
		  		  height: 60px;
		  		}
		
		.rgs-form /deep/ .el-upload-list .el-upload-list__item {
		  		  cursor: pointer;
		  		  border-radius: 0px;
		  		  color: #999;
		  		  background: rgba(255,255,255,.9);
		  		  width: 100px;
		  		  font-size: 24px;
		  		  border-color: #ddd;
		  		  border-width: 1px;
		  		  line-height: 60px;
		  		  border-style: dashed;
		  		  text-align: center;
		  		  height: 60px;
		  		}
		
		.rgs-form /deep/ .el-upload .el-icon-plus {
		  		  cursor: pointer;
		  		  border-radius: 0px;
		  		  color: #999;
		  		  background: rgba(255,255,255,.9);
		  		  width: 100px;
		  		  font-size: 24px;
		  		  border-color: #ddd;
		  		  border-width: 1px;
		  		  line-height: 60px;
		  		  border-style: dashed;
		  		  text-align: center;
		  		  height: 60px;
		  		}
	}
	.required {
		position: relative;
	}
	.required::after{
				color: red;
				left: 138px;
				position: absolute;
				content: "*";
				order: 2;
			}
</style>
