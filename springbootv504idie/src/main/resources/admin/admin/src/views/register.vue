<template>
	<div>
		<div class="container" :style='{"minHeight":"100vh","alignItems":"center","background":"url(http://codegen.caihongy.cn/20231112/61b7ca6805d048858264d26fdba7d8cd.jpg)","display":"flex","width":"100%","backgroundSize":"100% 100%","backgroundPosition":"center center","backgroundRepeat":"no-repeat","justifyContent":"flex-end"}'>
			<el-form v-if="pageFlag=='register'" :style='{"border":"0px solid #ddd","padding":"20px 80px 40px","margin":"0","alignItems":"center","textAlign":"center","flexDirection":"column","display":"flex","justifyContent":"center","minHeight":"100vh","borderRadius":"0px","flexWrap":"wrap","background":"#fff","width":"33%","position":"relative","height":"auto"}' ref="rgsForm" class="rgs-form" :model="rgsForm" :rules="rules">
				<div v-if="true" :style='{"padding":"0 0 10px","margin":"0 0 10px","borderColor":"#d8ae86","color":"#53d192","textAlign":"center","display":"inline-block","background":"#fff","borderWidth":"0 0 0px","width":"100%","lineHeight":"1.2","fontSize":"22px","borderStyle":"solid","fontWeight":"500"}' class="title">基于软件研发过程中的缺陷管理系统的设计与实现注册</div>
				<el-form-item :style='{"padding":"0 0px","margin":"0 20px 0","textAlign":"left","flexWrap":"wrap","display":"flex","width":"100%","fontSize":"inherit","position":"relative","height":"auto"}' class="list-item" v-if="tableName=='kaifarenyuan'">
					<div v-if="true" :style='{"padding":"0 6px","color":"#53d192","textAlign":"right","left":"-120px","display":"inline-block","width":"120px","lineHeight":"40px","fontSize":"14px","position":"absolute","order":"2"}' class="lable" :class="changeRules('kaifazhanghao')?'required':''">开发账号：</div>
					<el-input  v-model="ruleForm.kaifazhanghao"  autocomplete="off" placeholder="开发账号"  type="text"  />
				</el-form-item>
				<el-form-item :style='{"padding":"0 0px","margin":"0 20px 0","textAlign":"left","flexWrap":"wrap","display":"flex","width":"100%","fontSize":"inherit","position":"relative","height":"auto"}' class="list-item" v-if="tableName=='kaifarenyuan'">
					<div v-if="true" :style='{"padding":"0 6px","color":"#53d192","textAlign":"right","left":"-120px","display":"inline-block","width":"120px","lineHeight":"40px","fontSize":"14px","position":"absolute","order":"2"}' class="lable" :class="changeRules('mima')?'required':''">密码：</div>
					<el-input  v-model="ruleForm.mima"  autocomplete="off" placeholder="密码"  type="password"  />
				</el-form-item>
				<el-form-item :style='{"padding":"0 0px","margin":"0 20px 0","textAlign":"left","flexWrap":"wrap","display":"flex","width":"100%","fontSize":"inherit","position":"relative","height":"auto"}' class="list-item" v-if="tableName=='kaifarenyuan'">
					<div v-if="true" :style='{"padding":"0 6px","color":"#53d192","textAlign":"right","left":"-120px","display":"inline-block","width":"120px","lineHeight":"40px","fontSize":"14px","position":"absolute","order":"2"}' class="lable" :class="changeRules('mima')?'required':''">确认密码：</div>
					<el-input  v-model="ruleForm.mima2" autocomplete="off" placeholder="确认密码" type="password" />
				</el-form-item>
				<el-form-item :style='{"padding":"0 0px","margin":"0 20px 0","textAlign":"left","flexWrap":"wrap","display":"flex","width":"100%","fontSize":"inherit","position":"relative","height":"auto"}' class="list-item" v-if="tableName=='kaifarenyuan'">
					<div v-if="true" :style='{"padding":"0 6px","color":"#53d192","textAlign":"right","left":"-120px","display":"inline-block","width":"120px","lineHeight":"40px","fontSize":"14px","position":"absolute","order":"2"}' class="lable" :class="changeRules('kaifaxingming')?'required':''">开发姓名：</div>
					<el-input  v-model="ruleForm.kaifaxingming"  autocomplete="off" placeholder="开发姓名"  type="text"  />
				</el-form-item>
				<el-form-item :style='{"padding":"0 0px","margin":"0 20px 0","textAlign":"left","flexWrap":"wrap","display":"flex","width":"100%","fontSize":"inherit","position":"relative","height":"auto"}' class="list-item" v-if="tableName=='kaifarenyuan'">
					<div v-if="true" :style='{"padding":"0 6px","color":"#53d192","textAlign":"right","left":"-120px","display":"inline-block","width":"120px","lineHeight":"40px","fontSize":"14px","position":"absolute","order":"2"}' class="lable" :class="changeRules('xingbie')?'required':''">性别：</div>
                    <el-select v-model="ruleForm.xingbie" placeholder="请选择性别" >
                        <el-option
                            v-for="(item,index) in kaifarenyuanxingbieOptions"
                            v-bind:key="index"
                            :label="item"
                            :value="item">
                        </el-option>
                    </el-select>
				</el-form-item>
				<el-form-item :style='{"padding":"0 0px","margin":"0 20px 0","textAlign":"left","flexWrap":"wrap","display":"flex","width":"100%","fontSize":"inherit","position":"relative","height":"auto"}' class="list-item" v-if="tableName=='kaifarenyuan'">
					<div v-if="true" :style='{"padding":"0 6px","color":"#53d192","textAlign":"right","left":"-120px","display":"inline-block","width":"120px","lineHeight":"40px","fontSize":"14px","position":"absolute","order":"2"}' class="lable" :class="changeRules('nianling')?'required':''">年龄：</div>
					<el-input  v-model="ruleForm.nianling"  autocomplete="off" placeholder="年龄"  type="text"  />
				</el-form-item>
				<el-form-item :style='{"padding":"0 0px","margin":"0 20px 0","textAlign":"left","flexWrap":"wrap","display":"flex","width":"100%","fontSize":"inherit","position":"relative","height":"auto"}' class="list-item" v-if="tableName=='kaifarenyuan'">
					<div v-if="true" :style='{"padding":"0 6px","color":"#53d192","textAlign":"right","left":"-120px","display":"inline-block","width":"120px","lineHeight":"40px","fontSize":"14px","position":"absolute","order":"2"}' class="lable" :class="changeRules('shoujihao')?'required':''">手机号：</div>
					<el-input  v-model="ruleForm.shoujihao"  autocomplete="off" placeholder="手机号"  type="text"  />
				</el-form-item>
				<el-form-item :style='{"padding":"0 0px","margin":"0 20px 0","textAlign":"left","flexWrap":"wrap","display":"flex","width":"100%","fontSize":"inherit","position":"relative","height":"auto"}' class="list-item" v-if="tableName=='kaifarenyuan'">
					<div v-if="true" :style='{"padding":"0 6px","color":"#53d192","textAlign":"right","left":"-120px","display":"inline-block","width":"120px","lineHeight":"40px","fontSize":"14px","position":"absolute","order":"2"}' class="lable" :class="changeRules('touxiang')?'required':''">头像：</div>
                    <file-upload
                        tip="点击上传头像"
                        action="file/upload"
                        :limit="3"
                        :multiple="true"
                        :fileUrls="ruleForm.touxiang?ruleForm.touxiang:''"
                        @change="kaifarenyuantouxiangUploadChange"
                    ></file-upload>
				</el-form-item>
				<el-form-item :style='{"padding":"0 0px","margin":"0 20px 0","textAlign":"left","flexWrap":"wrap","display":"flex","width":"100%","fontSize":"inherit","position":"relative","height":"auto"}' class="list-item" v-if="tableName=='ceshirenyuan'">
					<div v-if="true" :style='{"padding":"0 6px","color":"#53d192","textAlign":"right","left":"-120px","display":"inline-block","width":"120px","lineHeight":"40px","fontSize":"14px","position":"absolute","order":"2"}' class="lable" :class="changeRules('ceshizhanghao')?'required':''">测试账号：</div>
					<el-input  v-model="ruleForm.ceshizhanghao"  autocomplete="off" placeholder="测试账号"  type="text"  />
				</el-form-item>
				<el-form-item :style='{"padding":"0 0px","margin":"0 20px 0","textAlign":"left","flexWrap":"wrap","display":"flex","width":"100%","fontSize":"inherit","position":"relative","height":"auto"}' class="list-item" v-if="tableName=='ceshirenyuan'">
					<div v-if="true" :style='{"padding":"0 6px","color":"#53d192","textAlign":"right","left":"-120px","display":"inline-block","width":"120px","lineHeight":"40px","fontSize":"14px","position":"absolute","order":"2"}' class="lable" :class="changeRules('mima')?'required':''">密码：</div>
					<el-input  v-model="ruleForm.mima"  autocomplete="off" placeholder="密码"  type="password"  />
				</el-form-item>
				<el-form-item :style='{"padding":"0 0px","margin":"0 20px 0","textAlign":"left","flexWrap":"wrap","display":"flex","width":"100%","fontSize":"inherit","position":"relative","height":"auto"}' class="list-item" v-if="tableName=='ceshirenyuan'">
					<div v-if="true" :style='{"padding":"0 6px","color":"#53d192","textAlign":"right","left":"-120px","display":"inline-block","width":"120px","lineHeight":"40px","fontSize":"14px","position":"absolute","order":"2"}' class="lable" :class="changeRules('mima')?'required':''">确认密码：</div>
					<el-input  v-model="ruleForm.mima2" autocomplete="off" placeholder="确认密码" type="password" />
				</el-form-item>
				<el-form-item :style='{"padding":"0 0px","margin":"0 20px 0","textAlign":"left","flexWrap":"wrap","display":"flex","width":"100%","fontSize":"inherit","position":"relative","height":"auto"}' class="list-item" v-if="tableName=='ceshirenyuan'">
					<div v-if="true" :style='{"padding":"0 6px","color":"#53d192","textAlign":"right","left":"-120px","display":"inline-block","width":"120px","lineHeight":"40px","fontSize":"14px","position":"absolute","order":"2"}' class="lable" :class="changeRules('ceshixingming')?'required':''">测试姓名：</div>
					<el-input  v-model="ruleForm.ceshixingming"  autocomplete="off" placeholder="测试姓名"  type="text"  />
				</el-form-item>
				<el-form-item :style='{"padding":"0 0px","margin":"0 20px 0","textAlign":"left","flexWrap":"wrap","display":"flex","width":"100%","fontSize":"inherit","position":"relative","height":"auto"}' class="list-item" v-if="tableName=='ceshirenyuan'">
					<div v-if="true" :style='{"padding":"0 6px","color":"#53d192","textAlign":"right","left":"-120px","display":"inline-block","width":"120px","lineHeight":"40px","fontSize":"14px","position":"absolute","order":"2"}' class="lable" :class="changeRules('xingbie')?'required':''">性别：</div>
                    <el-select v-model="ruleForm.xingbie" placeholder="请选择性别" >
                        <el-option
                            v-for="(item,index) in ceshirenyuanxingbieOptions"
                            v-bind:key="index"
                            :label="item"
                            :value="item">
                        </el-option>
                    </el-select>
				</el-form-item>
				<el-form-item :style='{"padding":"0 0px","margin":"0 20px 0","textAlign":"left","flexWrap":"wrap","display":"flex","width":"100%","fontSize":"inherit","position":"relative","height":"auto"}' class="list-item" v-if="tableName=='ceshirenyuan'">
					<div v-if="true" :style='{"padding":"0 6px","color":"#53d192","textAlign":"right","left":"-120px","display":"inline-block","width":"120px","lineHeight":"40px","fontSize":"14px","position":"absolute","order":"2"}' class="lable" :class="changeRules('nianling')?'required':''">年龄：</div>
					<el-input  v-model="ruleForm.nianling"  autocomplete="off" placeholder="年龄"  type="text"  />
				</el-form-item>
				<el-form-item :style='{"padding":"0 0px","margin":"0 20px 0","textAlign":"left","flexWrap":"wrap","display":"flex","width":"100%","fontSize":"inherit","position":"relative","height":"auto"}' class="list-item" v-if="tableName=='ceshirenyuan'">
					<div v-if="true" :style='{"padding":"0 6px","color":"#53d192","textAlign":"right","left":"-120px","display":"inline-block","width":"120px","lineHeight":"40px","fontSize":"14px","position":"absolute","order":"2"}' class="lable" :class="changeRules('shoujihao')?'required':''">手机号：</div>
					<el-input  v-model="ruleForm.shoujihao"  autocomplete="off" placeholder="手机号"  type="text"  />
				</el-form-item>
				<el-form-item :style='{"padding":"0 0px","margin":"0 20px 0","textAlign":"left","flexWrap":"wrap","display":"flex","width":"100%","fontSize":"inherit","position":"relative","height":"auto"}' class="list-item" v-if="tableName=='ceshirenyuan'">
					<div v-if="true" :style='{"padding":"0 6px","color":"#53d192","textAlign":"right","left":"-120px","display":"inline-block","width":"120px","lineHeight":"40px","fontSize":"14px","position":"absolute","order":"2"}' class="lable" :class="changeRules('touxiang')?'required':''">头像：</div>
                    <file-upload
                        tip="点击上传头像"
                        action="file/upload"
                        :limit="3"
                        :multiple="true"
                        :fileUrls="ruleForm.touxiang?ruleForm.touxiang:''"
                        @change="ceshirenyuantouxiangUploadChange"
                    ></file-upload>
				</el-form-item>
				<button :style='{"border":"0px solid #4FA1D9","cursor":"pointer","padding":"0 20px","margin":"20px 0 0 ","color":"#fff","display":"inline-block","letterSpacing":"4px","float":"right","borderRadius":"6px","background":"#53d192","width":"20vw","fontSize":"16px","height":"40px"}' type="button" class="r-btn" @click="login()">注册</button>
				<div :style='{"cursor":"pointer","padding":"0","margin":"0","color":"rgba(159, 159, 159, 1)","textAlign":"right","display":"inline-block","width":"auto","lineHeight":"40px","fontSize":"14px"}' class="r-login" @click="close()">已有账号，直接登录</div>
			</el-form>
			
		</div>
	</div>
</template>

<script>
export default {
	data() {
		return {
			ruleForm: {
			},
			forgetForm: {},
            pageFlag : '',
			tableName:"",
			rules: {},
            kaifarenyuanxingbieOptions: [],
            ceshirenyuanxingbieOptions: [],
		};
	},
	mounted(){
		this.pageFlag = this.$route.query.pageFlag
		if(this.$route.query.pageFlag=='register'){
			
			let table = this.$storage.get("loginTable");
			this.tableName = table;
			if(this.tableName=='kaifarenyuan'){
				this.ruleForm = {
					kaifazhanghao: '',
					mima: '',
					kaifaxingming: '',
					xingbie: '',
					nianling: '',
					shoujihao: '',
					touxiang: '',
				}
			}
			if(this.tableName=='ceshirenyuan'){
				this.ruleForm = {
					ceshizhanghao: '',
					mima: '',
					ceshixingming: '',
					xingbie: '',
					nianling: '',
					shoujihao: '',
					touxiang: '',
				}
			}
			if ('kaifarenyuan' == this.tableName) {
				this.rules.kaifazhanghao = [{ required: true, message: '请输入开发账号', trigger: 'blur' }]
			}
			if ('kaifarenyuan' == this.tableName) {
				this.rules.mima = [{ required: true, message: '请输入密码', trigger: 'blur' }]
			}
			if ('kaifarenyuan' == this.tableName) {
				this.rules.kaifaxingming = [{ required: true, message: '请输入开发姓名', trigger: 'blur' }]
			}
			if ('ceshirenyuan' == this.tableName) {
				this.rules.ceshizhanghao = [{ required: true, message: '请输入测试账号', trigger: 'blur' }]
			}
			if ('ceshirenyuan' == this.tableName) {
				this.rules.mima = [{ required: true, message: '请输入密码', trigger: 'blur' }]
			}
			if ('ceshirenyuan' == this.tableName) {
				this.rules.ceshixingming = [{ required: true, message: '请输入测试姓名', trigger: 'blur' }]
			}
			this.kaifarenyuanxingbieOptions = "男,女".split(',')
			this.ceshirenyuanxingbieOptions = "男,女".split(',')
		}
	},
	created() {
	},
	destroyed() {
		  	},
	methods: {
		changeRules(name){
			if(this.rules[name]){
				return true
			}
			return false
		},
		// 获取uuid
		getUUID () {
			return new Date().getTime();
		},
		close(){
			this.$router.push({ path: "/login" });
		},
        kaifarenyuantouxiangUploadChange(fileUrls) {
            this.ruleForm.touxiang = fileUrls;
        },
        ceshirenyuantouxiangUploadChange(fileUrls) {
            this.ruleForm.touxiang = fileUrls;
        },

        // 多级联动参数


		// 注册
		login() {
			var url=this.tableName+"/register";
					if((!this.ruleForm.kaifazhanghao) && `kaifarenyuan` == this.tableName){
						this.$message.error(`开发账号不能为空`);
						return
					}
					if((!this.ruleForm.mima) && `kaifarenyuan` == this.tableName){
						this.$message.error(`密码不能为空`);
						return
					}
					if((this.ruleForm.mima!=this.ruleForm.mima2) && `kaifarenyuan` == this.tableName){
						this.$message.error(`两次密码输入不一致`);
						return
					}
					if((!this.ruleForm.kaifaxingming) && `kaifarenyuan` == this.tableName){
						this.$message.error(`开发姓名不能为空`);
						return
					}
					if(`kaifarenyuan` == this.tableName && this.ruleForm.shoujihao &&(!this.$validate.isMobile(this.ruleForm.shoujihao))){
						this.$message.error(`手机号应输入手机格式`);
						return
					}
            if(this.ruleForm.touxiang!=null) {
                this.ruleForm.touxiang = this.ruleForm.touxiang.replace(new RegExp(this.$base.url,"g"),"");
            }
					if((!this.ruleForm.ceshizhanghao) && `ceshirenyuan` == this.tableName){
						this.$message.error(`测试账号不能为空`);
						return
					}
					if((!this.ruleForm.mima) && `ceshirenyuan` == this.tableName){
						this.$message.error(`密码不能为空`);
						return
					}
					if((this.ruleForm.mima!=this.ruleForm.mima2) && `ceshirenyuan` == this.tableName){
						this.$message.error(`两次密码输入不一致`);
						return
					}
					if((!this.ruleForm.ceshixingming) && `ceshirenyuan` == this.tableName){
						this.$message.error(`测试姓名不能为空`);
						return
					}
					if(`ceshirenyuan` == this.tableName && this.ruleForm.shoujihao &&(!this.$validate.isMobile(this.ruleForm.shoujihao))){
						this.$message.error(`手机号应输入手机格式`);
						return
					}
            if(this.ruleForm.touxiang!=null) {
                this.ruleForm.touxiang = this.ruleForm.touxiang.replace(new RegExp(this.$base.url,"g"),"");
            }
			this.$http({
				url: url,
				method: "post",
				data:this.ruleForm
			}).then(({ data }) => {
				if (data && data.code === 0) {
					this.$message({
						message: "注册成功",
						type: "success",
						duration: 1500,
						onClose: () => {
							this.$router.replace({ path: "/login" });
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
	.container {
	  position: relative;
	  background: url(http://codegen.caihongy.cn/20231112/61b7ca6805d048858264d26fdba7d8cd.jpg);

		.el-date-editor.el-input {
		  width: 100%;
		}
		
		.rgs-form .el-input /deep/ .el-input__inner {
						border-radius: 0px;
						padding: 0 10px;
						color: #666;
						background: none;
						width: 100%;
						font-size: 14px;
						border-color: #ddd;
						border-width: 0 0 1px;
						border-style: solid;
						min-width: 20vw;
						height: 44px;
					}
		
		.rgs-form .el-select /deep/ .el-input__inner {
						border-radius: 0px;
						padding: 0 10px;
						color: #666;
						background: none;
						width: 100%;
						font-size: 14px;
						border-color: #ddd;
						border-width: 0 0 1px;
						border-style: solid;
						min-width: 20vw;
						height: 44px;
					}
		
		.rgs-form .el-date-editor /deep/ .el-input__inner {
						border-radius: 0px;
						padding: 0 10px 0 30px;
						margin: 0 0 10px;
						color: #666;
						background: none;
						width: 100%;
						font-size: 14px;
						border-color: #ddd;
						border-width: 0 0 1px;
						border-style: solid;
						min-width: 20vw;
						height: 44px;
					}
		
		.rgs-form .el-date-editor /deep/ .el-input__inner {
						border-radius: 0px;
						padding: 0 10px 0 30px;
						margin: 0 0 10px;
						color: #666;
						background: none;
						width: 100%;
						font-size: 14px;
						border-color: #ddd;
						border-width: 0 0 1px;
						border-style: solid;
						min-width: 20vw;
						height: 44px;
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
		  		  border: 1px solid #ddd;
		  		  cursor: pointer;
		  		  border-radius: 20px;
		  		  color: #999;
		  		  background: none;
		  		  font-weight: 600;
		  		  width: 90px;
		  		  font-size: 18px;
		  		  line-height: 44px;
		  		  text-align: center;
		  		  height: 44px;
		  		}
		
		.rgs-form /deep/ .el-upload-list .el-upload-list__item {
		  		  border: 1px solid #ddd;
		  		  cursor: pointer;
		  		  border-radius: 20px;
		  		  color: #999;
		  		  background: none;
		  		  font-weight: 600;
		  		  width: 90px;
		  		  font-size: 18px;
		  		  line-height: 44px;
		  		  text-align: center;
		  		  height: 44px;
		  		}
		
		.rgs-form /deep/ .el-upload .el-icon-plus {
		  		  border: 1px solid #ddd;
		  		  cursor: pointer;
		  		  border-radius: 20px;
		  		  color: #999;
		  		  background: none;
		  		  font-weight: 600;
		  		  width: 90px;
		  		  font-size: 18px;
		  		  line-height: 44px;
		  		  text-align: center;
		  		  height: 44px;
		  		}
	}
	.required {
		position: relative;
	}
	.required::after{
				color: red;
				position: absolute;
				right: 3px;
				content: "*";
				order: 3;
			}
	.editor>.avatar-uploader {
		line-height: 0;
		height: 0;
	}
</style>
