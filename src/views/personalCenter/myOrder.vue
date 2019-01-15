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
                                <el-tab-pane label="我的订单" name="first">
                                    <div v-for="item in couponlist.slice((currentPage-1)*Mpage,currentPage*Mpage)" style="margin-bottom:15px;">
                                        <p class="ordernum">订单编号：{{item.orderNo}} <span style="margin-left:50px">{{item.ocreatTime | formatDate}}</span></p>
                                        <el-row class="ordercontent">
                                            <el-col :span="4" v-if="item.gid === its.gid" v-for="(its,i) in courses" :key="i">
                                                <img :src="base + its.gvimg" alt="" style="width:100%;height:100%">
                                            </el-col>
                                            <el-col :span="19" style="margin-left:20px">
                                                <p style="font-weight:500;font-size:16px">{{item.payStyle}}</p>
                                                <div class="paymentmode" v-if="item.oisPay == '1'">
                                                    <p>实际支付{{item.moneryvip}}</p>
                                                    <p>优惠券支付{{item.monery}}</p>
                                                </div>
                                                <span class="ordermonery">￥{{item.omoney}}</span>
                                                <el-button type="primary" class="orderbtn" v-if="item.oisPay == '0' && item.isKill == 0" @click="paymonery(item.num)">付款</el-button>
                                                <el-button class="cancelorderbtn" @click="cancelpayment(item.num,item.oid)" v-if="item.oisPay == '0' && item.isKill == 0">取消订单</el-button>                                              
                                                <p class="expired" disabled v-if="item.isKill == 2">已过期</p>
                                                <p  class="expired1">{{time}}</p>
                                                <p class="paidbtn"  v-if="item.oisPay == '1'">已付款</p>
                                                <el-button class="cancelorderbtn" @click="cancelorder(item)" v-if="item.oisPay == '1'">评价</el-button>
                                            </el-col>
                                        </el-row>
                                    </div>
                                    <no-data :inforData='couponlist' tips='您还没有订单'></no-data>
                                </el-tab-pane>
                            </el-tabs>
                        </el-col>
                    </el-row>
                    <div class="line"></div>
                    <div class="center">
                        <div class="pagination">
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
                    </div>
                </el-main>
            </el-container>
        </div>
        <Footer></Footer>
        <el-dialog
            title="评论"
            :visible.sync="pinglun"
            width="45%"
            :before-close="handleClose">
            <span class="pingbody">
                <div class="pingleft">
                    <img v-for="item in courses" v-if="pingluns.gid === item.gid" :src="base + item.gvimg" alt="" style="width:180px;">
                    <p>{{pingluns.payStyle}}</p>
                </div>
                <div class="pingright">
                    <el-rate v-model="value1" @change="getvalue" :allow-half="true"></el-rate>
                    <el-input
                        class="txtB"
                        type="textarea"
                        placeholder="请输入内容"
                        :rows="4"
                        v-model="textarea3">
                    </el-input>
                    <span>{{textarea3.length}}/200</span>
                </div>
            </span>
            <span slot="footer" class="dialog-footer">
                <el-button @click="pinglun = false">取 消</el-button>
                <el-button type="primary" @click="addPing">提 交</el-button>
            </span>
        </el-dialog>
    </div>
</template>
<script>
import Vue from 'vue'
import api from '@/api'
import Header from '@/components/Header'
import Footer from '@/components/Footer'
import noData from '@/components/noDataDisplay'
import { setTimeout } from 'timers'
import base from '@/baseimg'
export default {
    components:{Header,Footer,noData},
    data(){
        return {
            value1: null,
            textarea3: '',
            base: '',
            pingluns: {},
            pinglun: false,
            activeName: 'first',
            classstate:'3',
            Mpage: 5,
            currentPage: 1,
            time: '',
            couponlist:[],
            courses: []
            }
        },
    created(){
        this.base = base
        api.allOrder({uid: window.sessionStorage.getItem("user")}).then(data => {
            if(data.status !== 201) {
                this.couponlist = data.orders
                var num = 0
                this.couponlist.forEach((item,index) => {
                    item.num = index
                })
            }else {
                this.couponlist = []
            }
                
        })
        api.AllCourse().then(data => {
            this.courses = data.generalvideos
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
        addPing() {
            var data = new Date()
            api.addping({comment: {
                oid: this.pingluns.oid,
                uid: this.pingluns.uid,
                creatTime: data.getFullYear() + '-' + data.getMonth() + '-' + data.getDate() + ' ' + data.getHours() + ':' + data.getUTCMinutes() + ':' + data.getSeconds(), // 评论时间
                score: this.value1, // 星级
                content: this.textarea3, // 内容
                gid: this.pingluns.gid
            }}).then(data => {
                this.pinglun = false
            })
        },
        getvalue() {
            console.log(this.value1)
        },
        cancelorder(data) {
            this.pinglun = true
            this.pingluns = data
        },
        handleClose(done) {
            this.$confirm('确认要放弃评论吗？')
                .then(_ => {
                    done();
                })
                .catch(_ => {});
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
        cancelpayment(index, val){
            this.$confirm('确认取消订单？', {
            confirmButtonText: '确定',
            cancelButtonText: '取消',
            type: 'warning'
            }).then(() => {   
                // this.couponlist.splice(index,1) 
                this.couponlist[index].isKill = 1
                var data = {
                    isKill: 1,
                    oid: val
                }
                api.OrderDetail(data).then(data => {
                    var num = 0
                    this.couponlist.forEach((item,index) => {                      
                        item.num = index
                    })
                    if(data.status = 200){
                        this.$message({
                            type: 'success',
                            message: '取消成功!'
                        })
                    }
                })                            
            }).catch(() => {
                
            })
        },
        // 支付触发的事件
        paymonery(index){
            var maxtime = 60*60
            setInterval(() =>{
                if (maxtime > 0) {
                    maxtime = maxtime-1
                    // var minutes = Math.floor(maxtime / 60);
                    // var seconds = Math.floor(maxtime % 60);
                    // this.time = "距离结束还有" + minutes + "分" + seconds + '秒'
                    // console.log(maxtime)
                } else{
                     clearInterval()
                     this.couponlist[index].isKill = 2
                }
            },1000)
        }
    }
}
</script>
<style scoped>
.txtB {
    width: 350px;
    height: 100px;
    margin-top: 20px;
}
.pingbody {
    height: 120px;
    display: block;
}
.pingleft {
    float: left;
    text-align: left;
    width: 185px;
    padding-right: 20px;
}
.pingright {
    float: left;
    text-align: left;
    position: relative;
}

.pingright span {
    font-size: 14px;
    color: #ccc;
    position: absolute;
    bottom: 15px;
    right: 20px;
}

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
  /* .expired1 {
     color:#999;
     position: absolute;
     top: 50px;
     right: 155px;
 } */
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
