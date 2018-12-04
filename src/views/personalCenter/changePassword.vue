<template>
    <div class="totalw">
        <Header></Header>
        <div class="totalm">
            <el-container style="margin-top:20px;">
                <el-aside width="130px">
                    <Menu></Menu>
                </el-aside>
                <el-main>
                    <el-row>
                        <el-col :span="24">
                            <el-tabs v-model="activeName" @tab-click="handleClick">
                                <el-tab-pane label="修改密码" name="first">
                                    <div style="margin-top:50px;">
                                        <el-steps :active="1" align-center finish-status="success">
                                            <el-step title="验证账号"></el-step>
                                            <el-step title="修改密码"></el-step>
                                            <el-step title="修改成功"></el-step>
                                        </el-steps>
                                        <div class="userinformation">
                                            <el-form :model="phone" status-icon :rules="phoneRules" ref="phone">
                                                <el-form-item class="num" prop="num">
                                                    <el-input placeholder="     手机号码" type="text" v-model.number="phone.num" oninput="value=value.replace(/[^\d]/g,'')" />
                                                    <img src="@/assets/img/person.png" alt="">
                                                </el-form-item>
                                            </el-form>
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
import Menu from './menu.vue'
import Header from '@/components/Header'
import Footer from '@/components/Footer'
export default {
    components:{Menu,Header,Footer},
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
            },
            activeName: 'first',
		}
	}
}
</script>
<style scoped>
.userinformation{
    margin-top:50px;
    width: 100%;
    height: 100%;
}
.num {
  position: relative;
  width: 30%;
  text-align: center;
  margin:0 auto;
}
 .num input {
     text-indent: 20px;
 }
.num img {
  position: absolute;
  top: 8px;
  left: 12px;
  width: 20px;
  opacity: 0.6;
}

</style>