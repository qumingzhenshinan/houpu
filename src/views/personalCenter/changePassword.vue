<template>
    <div class="totalw">
        <Header></Header>
        <div class="totalm">
            <el-container style="margin-top:20px;">
                <el-aside width="130px">
                    <el-row>
                        <el-col :span="24" style="margin-bottom:20px;">
                            <el-menu
                                style="border:0;"
                                default-active="1"
                                class="el-menu-vertical-demo">
                                <el-menu-item index="1" :class="{menuborser:true,active:classstate == '1'}" @click.native="personal">
                                    <i><img src="@/assets/img/business.png" alt=""></i>
                                    <span slot="title">个人资料</span>
                                </el-menu-item>                   
                                <el-menu-item index="2" :class="{menuborser:true,active:classstate == '2'}" @click.native="mycoupon">
                                    <i><img src="@/assets/img/Coupon.png" alt=""></i>
                                    <span slot="title">我的优惠卷</span>
                                </el-menu-item>
                                <el-menu-item index="3"  :class="{menuborser:true,active:classstate == '3'}" @click.native="myorder">
                                    <i><img src="@/assets/img/order.png" alt=""></i>
                                    <span slot="title">我的订单</span>
                                </el-menu-item>
                                <el-menu-item index="4"  :class="{menuborser:true,active:classstate == '4'}" @click.native="mytest">
                                    <i><img src="@/assets/img/pen.png" alt=""></i>
                                    <span slot="title">我的小测试</span>
                                </el-menu-item>
                                <el-menu-item index="5"  :class="{menuborser:true,active:classstate == '5'}" @click.native="mypassword">
                                    <i><img src="@/assets/img/password.png" alt=""></i>
                                    <span slot="title">修改密码</span>
                                </el-menu-item>
                            </el-menu>
                        </el-col>
                    </el-row>
                </el-aside>
                <el-main>
                    <el-row>
                        <el-col :span="24">
                            <el-tabs v-model="activeName" @tab-click="handleClick">
                                <el-tab-pane label="修改密码" name="first">
                                    <div style="margin-top:50px;">
                                        <el-steps :active="activenum" align-center finish-status="success">
                                            <el-step title="验证账号"></el-step>
                                            <el-step title="修改密码"></el-step>
                                            <el-step title="修改成功"></el-step>
                                        </el-steps>
                                        <div class="userinformation">
                                            <div v-show="phonestate">
                                                <el-form :model="phone" status-icon :rules="phoneRules" ref="phone">
                                                    <el-form-item class="num" prop="num">
                                                        <el-input placeholder="     手机号码" type="text" v-model.number="phone.num" oninput="value=value.replace(/[^\d]/g,'')" />
                                                        <img src="@/assets/img/person.png" alt="" class="phoneimg">
                                                    </el-form-item>
                                                </el-form>   
                                                <el-form :model="password" status-icon :rules="passwordRules" ref="password"> 
                                                    <el-form-item class="num" prop="verificationcode">
                                                        <el-input placeholder="     验证码" type="text" v-model.number="password.verificationcode" oninput="value=value.replace(/[^\d]/g,'')" />
                                                        <span class="verificationcode"><span style="color:#ddd;">|&nbsp;</span> 获取验证码</span>
                                                    </el-form-item>
                                                </el-form>
                                                <div>
                                                    <el-button class="nextbtn" type="primary" @click="phonenext">下一步</el-button>
                                                </div>
                                            </div>
                                            <div v-show="passwordstate">
                                                <el-form :model="step3" status-icon :rules="step3Rules" ref="step3" class="demo-ruleForm">
                                                    <el-form-item class="num" prop="mima">
                                                        <el-input suffix-icon="el-icon-view" placeholder="      新密码" type="password" v-model="step3.mima" oninput="value=value.replace(/[^\d]/g,'')" ></el-input>
                                                        <img src="@/assets/img/pass.png" alt="" class="passwordimg">
                                                    </el-form-item>
                                                    <el-form-item class="num" prop="rmima">
                                                        <el-input suffix-icon="el-icon-view" placeholder="      确认密码" type="password" v-model="step3.rmima" oninput="value=value.replace(/[^\d]/g,'')" ></el-input>
                                                        <img src="@/assets/img/pass.png" alt="" class="passwordimg">
                                                    </el-form-item>
                                                </el-form>
                                                <div>
                                                    <el-button class="nextbtn" type="primary" @click="passwordnext">确定</el-button>
                                                </div>
                                            </div>
                                            <div v-show="passwordsuccess">
                                                <img src="@/assets/img/success.png" alt="">
                                                <p class="passwordsuccess">密码重置成功</p>
                                            </div>
                                        </div>
                                    </div>
                                </el-tab-pane>
                            </el-tabs>
                        </el-col>
                    </el-row>
                </el-main>
            </el-container>
        </div> 
        <Footer></Footer>
	</div>
</template>
<script>
import Header from '@/components/Header'
import Footer from '@/components/Footer'
export default {
    components:{Header,Footer},
	name: 'retireves',
	data() {
		var phone = (rule, value, callback) => {
			if (value === '') {
                callback(new Error('请输入手机号'));
            } else{
                if (!Number.isInteger(value)) {
                    callback(new Error('请输入数字值'));
                } else {
                    if (!(/^1[3456789]\d{9}$/.test(value))) {
                    callback(new Error('手机号格式不正确'));
                    } else {
                    callback();
                    }
                }
            }
        }
        var password = (rule, value, callback) => {
            if (value === '') {
                callback(new Error('请输入验证码'));
            }else{
                if (!Number.isInteger(value)) {
                    callback(new Error('请输入数字值'));
                }
            }
        }
        var validatePass = (rule, value, callback) => {
            var pattern = /^[\w]{6,12}$/;
            if (!value) {
                return callback(new Error('密码不能为空'));
            }else {
                if (!(pattern.test(value))) {
                    callback(new Error('密码格式不正确'));
                } else {
                    callback();
                }
            }
        }
        var validatePass1 = (rule, value, callback) => {
            if (value === '') {
                callback(new Error('请再次输入密码'));
            } else if (value !== this.step3.mima) {
                callback(new Error('两次输入密码不一致!'));
            } else {
                callback();
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
            },
            password: {
				verificationcode: ''
			},
			passwordRules: {
				verificationcode: [
					{ validator: password, trigger: 'blur' }
				]
            },
            step3: {
				mima: '',
				rmima: ''
            },
            step3Rules: {
				mima: [{ validator: validatePass, trigger: 'blur' }],
				rmima: [{ validator: validatePass1, trigger: 'blur' }]
			},
            activeName: 'first',
            classstate:'5',
            activenum: 1,
            passwordstate:false,
            phonestate:true,
            passwordsuccess: false,
		}
    },
    created(){

    },
    methods: {
        personal(val){
            this.classstate = '1'
            this.$router.push({name:'personalCenter'})
        },
        mycoupon(val){
            this.classstate = '2'
            this.$router.push({name:'myCoupon'})
        },
        myorder(){
            this.classstate = '3'
            this.$router.push({name:'myOrder'})
        },
        mytest(){
            this.classstate = '4'
            this.$router.push({name:'myTest'})
        },
        mypassword(){
            this.classstate = '5'
            this.$router.push({name:'changePassword'})
        },
        phonenext(){
            this.phonestate = false;
            this.passwordstate = true;
            this.activenum = 2
        },
        passwordnext(){
            this.activenum = 3
            this.passwordstate = false;
            this.passwordsuccess= true
        },
        handleClick(tab, event) {
            console.log(tab, event);
        },
    }
}
</script>
<style scoped>
.userinformation{
    margin-top:50px;
    width: 100%;
    height: 100%;
    text-align: center;
}
.num {
  position: relative;
  width: 30%;
  text-align: center;
  margin:20px auto;
  position: relative;
}
 .num input {
     text-indent: 20px;
 }
.phoneimg {
  position: absolute;
  top: 8px;
  left: 12px;
  width: 20px;
  opacity: 0.6;
}
.passwordimg {
  position: absolute;
  top: 10px;
  left: 10px;
  width: 16px;
  opacity: 0.6;
}
.verificationcode {
    position: absolute;
    top: 3px;
    right: 9px;
    color: #409EFF;
    background: #fff;
    height: 35px;
    line-height: 35px;
}
.nextbtn {
    width: 30%;
	border-radius: 5px;
}
.passwordsuccess {
    font-size: 30px;
    color: gray;
}
.menuborser {
       border-bottom:1px solid #ccc;
       color: black;
    }
    .active {
        background: #0099ff;
        color: #fff;
    }
</style>