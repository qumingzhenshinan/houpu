<template>
  <div class="start">
    <div class="mima">
      <img src="@/assets/img/code.png" class="rightImg" @click="gotext" alt="">
      <div class="code">
        扫码登录
      </div>
      <div class="title">
        密码登录
      </div>
      <el-form class="form" :model="login" status-icon :rules="rulesLogin" ref="login">
        <el-form-item prop="name">
          <el-input prefix-icon="el-icon-mobile-phone" oninput="value=value.replace(/[^\d]/g,'')" placeholder="请输入手机号" v-model.number="login.name"></el-input>
        </el-form-item>
        <el-form-item prop="pass" class="pass">
          <el-input type="password" placeholder="请输入密码6-12位密码字母组合" v-model="login.pass"></el-input>
          <img src="@/assets/img/pass.png" alt="">
        </el-form-item>
        <el-form-item prop="code">
          <el-input class="codes" v-model="login.code" placeholder="请输入验证码"></el-input>
          <span class="scode" @click="createCode">{{verificationCode}}</span>
        </el-form-item>
        <el-form-item>
          <el-button @click="submitForm('login')" class="login" type="primary">登录</el-button>
        </el-form-item>
      </el-form>
      <div class="wmima">
        <span style="cursor:pointer;" @click="$router.push('/start/retrieve')">忘记密码？</span>
        <span @click="goR">注册</span> 
      </div>
    </div>
  </div>
</template>

<script>
import api from "@/api"
export default {
  name: 'start',
  data () {
    var name = (rule, value, callback) => {
      if (!value) {
        return callback(new Error('手机号不能为空'));
      }else {
        setTimeout(() => {
          if (!Number.isInteger(value)) {
            callback(new Error('请输入数字值'));
          } else {
            if (!(/^1[3465789]\d{9}$/.test(value))) {
              callback(new Error('手机号格式不正确'));
            } else {
              callback();
            }
          }
        }, 100);
      }
    };
    var pass = (rule, value, callback) => {
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
        }, 100);
      }
    };
    var code = (rule, value, callback) => {
      var customerCode = value.toUpperCase();  //把你输入的小写转化为大写
      if (!value) {
        return callback(new Error('验证码不能为空'));
      }else {
        setTimeout(() => {
          if (customerCode !== this.verificationCode) {
            callback(new Error('验证码输入错误'));
          } else {
            callback();
          }
        }, 100);
      }
    };
    return {
      login: {
        name: '',
        pass: '',
        code: ''
      },
      rulesLogin: {
        name: [
          { validator: name, trigger: 'blur' }
        ],
        pass: [
          { validator: pass, trigger: 'blur' }
        ],
        code: [
          { validator: code, trigger: 'blur' }
        ]
      },
      verificationCode: ''
    }
  },
  inject: ['reload'],
  methods: {
    submitForm(formName) {
      this.$refs[formName].validate((valid) => {
        if (valid) {
          api.getlogin({
            phoneNo: this.login.name,
            passWord: this.login.pass
          }).then(data => {
            // 存入session
            if(data !== null) {
              this.$router.push('/')
              window.sessionStorage.setItem("user", data.uid);
            }else {
              alert('账号或密码错误，请重新登录')
              this.reload()
            }
            
          })
        } else {
          return false;
        }
      });
    },
    createCode() {    //通过随机数生成验证码
      var code = '';
      var codeLength = 4;     //验证码长度
      var random = new Array(0,1,2,3,4,5,6,7,8,9,'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R', 'S','T','U','V','W','X','Y','Z');
      for(var i = 0;i<codeLength;i++){
          var index = Math.floor(Math.random()*36);
          code += random[index];
      }
      this.verificationCode = code
    },
    gotext() {
      this.$emit('tologins')
    },
    goR() {
      this.$emit('toR')
    }
  },
  created() {
  },
  mounted() {
    this.createCode()
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
.mima {
  width: 100%;
  padding: 10px 15px;
  position: relative;
  box-sizing: border-box;
}

.code {
  width: 80px;
  height: 30px;
  background: url('../../assets/img/jiesB.png') no-repeat;
  background-size: 100%;
  text-align: center;
  line-height: 25px;
  font-size: 14px;
  color: #F5A623;
  position: absolute;
  top: 10px;
  right: 45px;
}

.rightImg {
  width: 43px;
  height: 43px;
  position: absolute;
  top: 0;
  right: 0;
  cursor: pointer;
}

.title {
  font-size: 16px;
  line-height: 26px;
  color: #2D3339;
}

.form {
  margin-top: 20px;
}

.text {
  width: 100%;
  height: 40px;
}

.pass {
  position: relative;
}

.pass img {
  position: absolute;
  top: 13px;
  left: 12px;
  width: 13px;
  opacity: 0.6;
}

.codes {
  width: 150px;
}

.login {
  width: 100%;
}

.wmima {
  color: #2D3339;
  font-size: 12px;
  margin-top: 5px;
}

.wmima>span:first-child {
  opacity: 0.4;
}

.wmima>span:nth-child(2) {
  float: right;
  cursor: pointer;
}

.scode {
  height: 40px;
  width: 120px;
  float: right;
  text-align: center;
  font-size: 30px;
}

</style>
