<template>
    <div class="totalw">
        <Header></Header>
        <div class="totalm">
            <el-container style="margin-top:20px;">
                <el-aside width="130px">
                    <el-row>
                        <el-col :span="24">
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
                        </el-col>
                    </el-row>
                </el-aside>
                <el-main>
                    <el-row  v-show="setupstate == true">
                        <el-col :span="24">
                            <div style="width:100%;height:100%;text-align:center;">
                                <img src="@/assets/img/Headportrait.png" alt="" style="widh:140px;height:140px;">
                                <p style="margin-top:20px;">昵称：李磊</p>
                                <p style="color:#ccc;font-size:12px;margin-top:10px;">年级：一年级</p>
                                <el-button type="primary" size="medium" style="width:100px;margin-top:20px;" @click="Setup">设置</el-button>
                            </div>
                        </el-col>
                    </el-row>
                    <el-row v-show="setupstate == false">
                        <el-col :span="24">
                            <div style="width:100%;height:100%;text-align:center;">
                                <img src="@/assets/img/Headportrait.png" alt="" style="widh:140px;height:140px;">
                                <el-form label-width="450px" >
                                    <el-row>
                                        <el-col :span="14">
                                            <el-form-item label="昵称:" prop="username">
                                                <el-input v-model="username" size="small" style="width:112%"/>
                                            </el-form-item>
                                        </el-col>
                                    </el-row>
                                    <el-row>
                                        <el-col :span="14">
                                            <el-form-item label="年级:" prop="classname">
                                                <el-input v-model="classname" size="small" style="width:112%"/>
                                            </el-form-item>
                                        </el-col>
                                    </el-row>
                                </el-form>
                                <el-button type="primary" size="medium" style="width:100px;margin-top:20px;">完成</el-button>
                                <el-button  size="medium" style="width:100px;margin-top:20px;" >取消</el-button>
                            </div>
                        </el-col>
                    </el-row>

                </el-main>
            </el-container>
        </div>
        <Footer></Footer>
    </div>
</template>
<script>
import Vue from 'vue'
import api from '@/api'
import Header from '@/components/Header'
import Footer from '@/components/Footer'
  export default {
      components:{Header,Footer},
      data(){
        return {
           username:"李磊",
           classname:'一年级',
           setupstate: true,
            classstate:'1',
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
        Setup(){
            this.setupstate = false
        }
    }
  }
</script>
<style scoped>
    .el-form-item {
        margin: 0;
    }
    .menuborser {
       border-bottom:1px solid #ccc;
       color: black;
    }
    .active {
        background: #0099ff;
        color: #fff;
    }
</style
</style>
