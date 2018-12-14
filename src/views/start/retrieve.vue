<template>
  <div class="start">
    <div class="totalw">
      <div class="totalm">
        <img style="margin: 10px 0;" src="@/assets/img/logo.png" alt="">
      </div>
      <div class="retrieve">
        找回密码
        <div style="padding:20px;box-sizing:border-box">
					<el-steps :active="active" align-center finish-status="success">
					  <el-step title="输入账号"></el-step>
					  <el-step title="账号验证"></el-step>
					  <el-step title="重置密码"></el-step>
					</el-steps>
					<!-- 步骤1 -->
					<div class="step" v-if="active === 1">
						<p>请登录您要找回的帐号</p>
						<p>
							<el-form :model="phone" status-icon :rules="phoneRules" ref="phone" class="demo-ruleForm">
							  <el-form-item class="num" prop="num">
							    <el-input placeholder="手机号码" type="text" v-model.number="phone.num" oninput="value=value.replace(/[^\d]/g,'')" ></el-input>
							    <img src="@/assets/img/person.png" alt="">
							  </el-form-item>
							</el-form>
						</p>
						<p>
							<el-button @click="active++" class="p3btn" type="primary">下一步</el-button>
						</p>
					</div>
					<!-- 步骤2 -->
					<div class="step step2" v-if="active === 2">
						<p>请登录您要找回的帐号</p>
						<p>
							<input type="text" name="" value="" placeholder="输入验证码">
							<span>| 获取验证码</span>
						</p>
						<p>
							<el-button @click="active++" class="p3btn" type="primary">下一步</el-button>
						</p>
					</div>
					<div class="step step3" v-if="active === 3">
						<p>
							<el-form :model="step3" status-icon :rules="step3Rules" ref="step3" class="demo-ruleForm">
							  <el-form-item class="step3I" prop="mima">
							    <el-input suffix-icon="el-icon-view" placeholder="新密码" type="password" v-model="step3.mima" oninput="value=value.replace(/[^\d]/g,'')" ></el-input>
							    <img src="@/assets/img/pass.png" alt="">
							  </el-form-item>
							  <el-form-item class="step3I" prop="rmima">
							    <el-input suffix-icon="el-icon-view" placeholder="确认密码" type="password" v-model="step3.rmima" oninput="value=value.replace(/[^\d]/g,'')" ></el-input>
							    <img src="@/assets/img/pass.png" alt="">
							  </el-form-item>
							</el-form>
						</p>
						<p>
							<el-button @click="active++" class="p3btn" type="primary">下一步</el-button>
						</p>
					</div>
					<div class="step step4" v-if="active === 4">
						<p>密码重置成功</p>
						<p><span style="color:#09f">{{countDown}}秒</span>后自动跳转到登录，点击按钮直接跳转</p>
						<p>
							<el-button class="p3btn" type="primary">手动跳转</el-button>
						</p>
					</div>
				</div>
      </div>
      <footer class="footer">
        Copyright © 2018 厚朴教育 All Rights Reserved 京ICP备12028606号-22
      </footer>
    </div>
  </div>
</template>
<script>
export default {
	name: 'retireves',
	data() {
		var phone = (rule, value, callback) => {
			if (value === '') {
        callback(new Error('请输入手机号'));
      } else{
      	setTimeout(() => {
          if (!Number.isInteger(value)) {
            callback(new Error('请输入数字值'));
          } else {
            if (!(/^1[3456789]\d{9}$/.test(value))) {
              callback(new Error('手机号格式不正确'));
            } else {
              callback();
            }
          }
        }, 1000);
      }
		};
		var validatePass = (rule, value, callback) => {
      var pattern = /^[\w]{6,12}$/;
      if (!value) {
        return callback(new Error('密码不能为空'));
      }else {
        setTimeout(() => {
          if (!(pattern.test(value))) {
            callback(new Error('密码格式不正确'));
          } else {
            callback();
          }
        }, 500);
      }
    };
    var validatePass1 = (rule, value, callback) => {
      if (value === '') {
        callback(new Error('请再次输入密码'));
      } else if (value !== this.step3.mima) {
        callback(new Error('两次输入密码不一致!'));
      } else {
        callback();
      }
    };
		return {
			active: 1,
			countDown: 5,
			phone: {
				num: ''
			},
			step3: {
				mima: '',
				rmima: ''
			},
			phoneRules: {
				num: [
					{ validator: phone, trigger: 'blur' }
				]
			},
			step3Rules: {
				mima: [{ validator: validatePass, trigger: 'blur' }],
				rmima: [{ validator: validatePass1, trigger: 'blur' }]
			}
		}
	},
	methods: {
		countDowns() {
			var timer = setInterval(() => {
				if(this.countDown === 0) {
					this.$router.push('/start')
					clearInterval(timer)
				}else {
					this.countDown--
				}
			},1000)
		}
	},
	created() {
		this.countDowns()
	}
}
</script>
<style scoped>
.step {
	margin-top: 65px;
	text-align: center;
}

.step p {
	width: 280px;
	margin: 0 auto;
	margin-bottom: 40px;
}

.p3btn {
	width: 100%;
	border-radius: 50px;
}

.num {
  position: relative;
}

.num img {
  position: absolute;
  top: 8px;
  left: 12px;
  width: 20px;
  opacity: 0.6;
}

.step2 p:nth-child(2) {
	height: 40px;
	border: 1px solid #dcdfe6;
	line-height: 40px;
	border-radius: 20px;
	padding: 0 15px;
	box-sizing: border-box;
	font-size: 14px;
}

.step2 p:nth-child(2) input {
	outline: none;
	border: none;
	width: 150px;
}

.step2 p:nth-child(2) span {
	color: #0099ff;
	cursor: pointer;
}

.step3I {
  position: relative;
}

.step3I img {
  position: absolute;
  top: 13px;
  left: 13px;
  width: 13px;
  opacity: 0.6;
}

.step4 p:nth-child(1) {
	font-size: 23px;
	color: #666;
}

.step4 p:nth-child(2) {
	color: rgba(0, 0, 0, 0.3);
	font-size: 14px;
}

.footer {
  font-size: 14px;
  margin: 15px 0 40px;
  color: #2D3339;
  text-align: center;
  opacity: 0.5;
}

.retrieve {
  width: 1000px;
  height: 490px;
  margin: 0 auto;
  box-shadow: 0 0 6px 0 rgba(136,136,136,0.20);
  border-radius: 2px;
  padding: 20px;
  box-sizing: border-box;
}
</style>