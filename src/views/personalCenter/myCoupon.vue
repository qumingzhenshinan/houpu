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
                                    <i>
                                        <img v-if="classstate !== '1'" src="@/assets/img/business.png" alt="">
                                        <img v-if="classstate == '1'" src="@/assets/img/businessB.png" alt="">
                                    </i>
                                    <span slot="title">个人资料</span>
                                </el-menu-item>                   
                                <el-menu-item index="2" :class="{menuborser:true,active:classstate == '2'}" @click.native="mycoupon">
                                    <i>
                                        <img v-if="classstate !== '2'" src="@/assets/img/Coupon.png" alt="">
                                        <img v-if="classstate == '2'" src="@/assets/img/CouponB.png" alt="">
                                    </i>
                                    <span slot="title">我的优惠券</span>
                                </el-menu-item>
                                <el-menu-item index="3"  :class="{menuborser:true,active:classstate == '3'}" @click.native="myorder">
                                    <i>
                                        <img v-if="classstate !== '3' " src="@/assets/img/order.png" alt="">
                                        <img v-if="classstate == '3'" src="@/assets/img/orderB.png" alt="">
                                    </i>
                                    <span slot="title">我的订单</span>
                                </el-menu-item>
                                <el-menu-item index="4"  :class="{menuborser:true,active:classstate == '4'}" @click.native="mytest">
                                    <i>
                                        <img v-if="classstate !== '4' " src="@/assets/img/pen.png" alt="">
                                        <img v-if="classstate == '4'" src="@/assets/img/penB.png" alt="">
                                    </i>
                                    <span slot="title">我的小测试</span>
                                </el-menu-item>
                                <el-menu-item index="5"  :class="{menuborser:true,active:classstate == '5'}" @click.native="mypassword">
                                    <i>
                                        <img style="width: 15px;height: 17px;" v-if="classstate !== '5' " src="@/assets/img/password.png" alt="">
                                        <img src="@/assets/img/passwordB.png" v-if="classstate == '5'" alt="">
                                    </i>
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
                                                <div class="PCquan">
                                                    <p><span>￥</span><span>{{item.couponPrice}}</span></p>
                                                    <p>{{item.ctype}}</p>
                                                </div>
                                            </el-col>
                                            <el-col :span="19" style="margin-left:20px">
                                                <p style="font-weight:600;">{{item.cname}}</p>
                                                <p style="font-size:13px;margin-top:10px;min-height:50px">优惠券描述：这是一个这是一个这是一个这是一个这是一个这是一个这是一个这是一个这是一个这是一个这是一个这是一个这是一个这是一个这是一个</p>
                                                <p style="font-size:12px;margin-top:10px;">使用期限制：{{item.validity.substr(0,10)}}</p>
                                            </el-col>
                                        </el-row>
                                    </div>
                                    <no-data :inforData='couponlist' tips='您还没有优惠券'></no-data>
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
import noData from '@/components/noDataDisplay'

  export default {
      components:{ Header, Footer, noData},
      data(){
        return {
           activeName: 'first',
           classstate:'2',
           couponlist:[{

           }]
        }
    },
    created(){

        api.Getmycoupon({uid:'a958d03cc43c44db83b0178b8a752fd6'}).then(data => {
            console.log(data);
            if(data.coupons === undefined) {
                this.couponlist = data.coupons
            }else {
                this.couponlist = []
            }
            
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

.PCquan {
    width: 100%;
    height: 107px;
}

.PCquan p:nth-child(1) {
    height: 70%;
    background: #83D8D9;
    line-height: 75px;
    text-align: center;
    color: #fff;
}

.PCquan p:nth-child(1) span:nth-child(2) {
    font-size: 36px;
}

.PCquan p:nth-child(2) {
    height: 30%;
    background: #5FBEC0;
    text-align: center;
    line-height: 32px;
    font-size: 18px;
    color: #fff;
}
</style>
