<template>
  <div class="start">
    <div class="totalw">
      <div class="totalm">
        <img style="margin: 10px 0;" src="@/assets/img/logo.png" alt="">
      </div>
      <div class="retrieve">
        找回密码
        <div style="padding:20px;box-sizing:border-box">
					<el-steps :active="2" align-center finish-status="success">
					  <el-step title="输入账号"></el-step>
					  <el-step title="账号验证"></el-step>
					  <el-step title="重置密码"></el-step>
					</el-steps>
					<!-- 步骤1 -->
					<div class="step" v-show="false">
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
							<el-button class="p3btn" type="primary">下一步</el-button>
						</p>
					</div>
					<!-- 步骤2 -->
					<div class="step step2">
						<p>请登录您要找回的帐号</p>
						<p>
							<input type="text" name="" value="" placeholder="输入验证码">
							<span>| 获取验证码</span>
						</p>
						<p>
							<el-button class="p3btn" type="primary">下一步</el-button>
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
		}
		return {
			phone: {
				num: ''
			},
			phoneRules: {
				num: [
					{ validator: phone, trigger: 'blur' }
				]
			}
		}
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