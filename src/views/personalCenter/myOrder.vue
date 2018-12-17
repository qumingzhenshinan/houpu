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
                                <el-tab-pane label="我的订单" name="first">
                                    <div v-for="item in couponlist.slice((currentPage-1)*Mpage,currentPage*Mpage)" style="margin-bottom:15px;">
                                        <p class="ordernum">订单编号：{{item.orderNo}} <span style="margin-left:50px">{{item.ocreatTime | formatDate}}</span></p>
                                        <el-row class="ordercontent">
                                            <el-col :span="4">
                                                <img src="@/assets/img/Coupon1.png" alt="" style="width:100%;height:100%">
                                            </el-col>
                                            <el-col :span="19" style="margin-left:20px">
                                                <p style="font-weight:500;font-size:16px">{{item.payStyle}}</p>
                                                <!-- <div class="paymentmode">
                                                    <p>实际支付{{item.moneryvip}}</p>
                                                    <p>优惠券支付{{item.monery}}</p>
                                                </div> -->
                                                <span class="ordermonery">￥{{item.omoney}}</span>
                                                <el-button type="primary" class="orderbtn" v-if="item.oisPay == '0'">付款</el-button>
                                                <!-- <el-button class="cancelorderbtn">取消订单</el-button> -->                                              
                                                <!-- <p class="expired">已过期</p> -->
                                                <p class="paidbtn"  v-if="item.oisPay == '1'">已付款</p>
                                                <!-- <el-button class="cancelorderbtn">评价</el-button> -->
                                            </el-col>
                                        </el-row>
                                    </div>
                                </el-tab-pane>
                            </el-tabs>
                        </el-col>
                    </el-row>
                    <div class="line"></div>
                    <div style="text-align:center">
                        <el-pagination
                            background
                            :page-size='Mpage'
                            :current-page="currentPage"
                            @size-change="handleSizeChange"
                            @current-change="currentChange"
                            @prev-click="prevPage"
                            @next-click="nextPage"
                            next-text="下一页"
                            prev-text="上一页"
                            layout="prev, pager, next"
                            :total="couponlist.length">
                        </el-pagination>
                    </div>
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
           classstate:'3',
           Mpage: 5,
		   currentPage: 1,
           couponlist:[{
               title:'初一数学强化练习班（创新班）（秋季）',
               monery: '100.00',
               moneryvip:'69.00',
               zongmonery:'169.00'
           },{
               title:'初一语文强化练习班（创新班）（秋季）',
               monery: '100.00',
               moneryvip:'60.00',
               zongmonery:'160.00'
           },]
        }
    },
    created(){
        api.allOrder({uid:'681f95051bbf4978b455688a285b483a'}).then(data => {
            this.couponlist = data.orders
        })
    },
    filters: {
      formatDate(time) {
        if (time) {
            var dateee = new Date(time).toJSON();
            var date = new Date(+new Date(dateee)+8*3600*1000).toISOString().replace(/T/g,' ').replace(/\.[\d]{3}Z/,'')  
          return date;
        } else {
          return "";
        }
      }
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
        handleSizeChange(val) {
        
        },
        //点击下一页和点击页码时执行
        handleCurrentChange(val) {
        
        },
        handleClick(tab, event) {
            console.log(tab, event);
        },
        currentChange(val){
            this.currentPage = val
        },
        prevPage() {
			this.currentPage--
		},
		nextPage() {
			this.currentPage++
        },
    }
  }
</script>
<style scoped>
.ordernum {
    color:#999;
    height:40px;
    line-height:30px;
    text-indent: 15px;
}
 .ordercontent {
     border:1px solid #ddd;
     padding:15px;
     border-radius:5px;
     position: relative;
 }
 .ordermonery {
     color: darkorange;
     font-size: 18px;
     position: absolute;
     top: 50px;
     right: 350px;
 }
 .orderbtn {
     width: 100px;
     position: absolute;
     top: 30px;
     right: 30px;
 }
 .cancelorderbtn{
     border: 0;
     width: 100px;
     color: #409EFF;
     position: absolute;
     top: 70px;
     right: 30px;
 }
 .paidbtn {
     color:#999;
     position: absolute;
     top: 50px;
     right: 55px;
 }
 .deliveryrefund {
     color:#999;
     position: absolute;
     top: 20px;
     right: 48px;
 }
 .expired {
     color:#999;
     position: absolute;
     top: 50px;
     right: 55px;
 }
 .paymentmode {
     color:#999;
     position: absolute;
     top: 40px;
     right: 170px;
 }
.line {
     height: 20px;
     width: 100%;
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
