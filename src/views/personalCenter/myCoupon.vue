<template>
    <div class="totalw">
        <Header></Header>
        <div  class="totalm">
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
                <el-main style="margin-left:30px">
                    <el-row>
                        <el-col :span="24">
                            <el-tabs v-model="activeName" @tab-click="handleClick">
                                <el-tab-pane label="我的优惠券" name="first">
                                    <div v-for="item in couponlist">
                                        <el-row style="border:1px solid #999;padding:15px;border-radius:5px">
                                            <el-col :span="4">
                                                <img src="@/assets/img/Coupon1.png" alt="" style="width:100%;height:100%">
                                            </el-col>
                                            <el-col :span="19" style="margin-left:20px">
                                                <p style="font-weight:600;">立减￥10元</p>
                                                <p style="font-size:13px;margin-top:10px;min-height:50px">优惠券描述：这是一个这是一个这是一个这是一个这是一个这是一个这是一个这是一个这是一个这是一个这是一个这是一个这是一个这是一个这是一个</p>
                                                <p style="font-size:12px;margin-top:10px;">使用期限制：2018-09-20</p>
                                            </el-col>
                                        </el-row>
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
import Vue from 'vue'
import api from '@/api'
import Header from '@/components/Header'
import Footer from '@/components/Footer'
  export default {
      components:{Header,Footer},
      data(){
        return {
           activeName: 'first',
           classstate:'2',
           couponlist:[{

           }]
        }
    },
    created(){

        api.Getmycoupon({uid:'107eaf81f1074538a1a40f8d4cbb6269'}).then(data => {
            console.log(data);
        })
    },
    methods: {
        handleClick(tab, event) {
            console.log(tab, event);
        },
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
        }
    }
  }
</script>
<style scoped>
    .menuborser {
       border-bottom:1px solid #ccc;
       color: black;
    }
    .active {
        background: #0099ff;
        color: #fff;
    }
    
</style>
