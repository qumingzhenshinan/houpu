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
                                <el-tab-pane label="我的小测试" name="first">
                                    <div style="margin-bottom:15px;">
                                        <div class="textcontent" v-for="item in textlist.slice((currentPage-1)*Mpage,currentPage*Mpage)">
                                            <p class="texttitle">{{item.title}}</p>
                                            <p class="textSubject">科目：{{item.Subject}}</p>
                                            <p class="textfraction">分数：{{item.fraction}}</p>
                                            <p class="textcomment">试卷后评语：{{item.comment}}</p>
                                            <el-button class="textbtn">查看推荐视频 &nbsp;></el-button>
                                        </div>
                                    </div>
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
                                :total="textlist.length">
                            </el-pagination>
                        </div>
                        
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
           classstate:'4',
           Mpage: 2,
		   currentPage: 1,
           textlist:[
                {
                    title:'一年级语文小测验一年级语文小测验一年级语文小测验',
                    Subject:'语文',
                    fraction: '100',
                    comment:'完善度较好完善度较好完善度较好完善度较好完善度较完善度较好完善度较好完善度较好完善度较好完善度较好'
                },
                {
                    title:'一年级语文小测验一年级语文小测验一年级语文小测验',
                    Subject:'语文',
                    fraction: '100',
                    comment:'完善度较好完善度较好完善度较好'
                },
                {
                    title:'一年级语文小测验一年级语文小测验一年级语文小测验',
                    Subject:'语文',
                    fraction: '100',
                    comment:'完善度较好完善度较好完善度较好'
                },
                {
                    title:'一年级语文小测验一年级语文小测验一年级语文小测验',
                    Subject:'语文',
                    fraction: '100',
                    comment:'完善度较好完善度较好完善度较好'
                },
                {
                    title:'一年级语文小测验一年级语文小测验一年级语文小测验',
                    Subject:'语文',
                    fraction: '100',
                    comment:'完善度较好完善度较好完善度较好'
                },
                {
                    title:'一年级语文小测验一年级语文小测验一年级语文小测验',
                    Subject:'语文',
                    fraction: '100',
                    comment:'完善度较好完善度较好完善度较好'
                },
           ]
        }
    },
    created(){
        api.ExamHistoy({uid:'681f95051bbf4978b455688a285b483a'}).then(data => {
            // this.textlist = data
        })
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
.textcontent {
    width: 43%;
    /* height: 100%; */
    padding:20px;
    border: 1px solid #999;
    float: left;
    margin: 0 0 20px 20px;
    position: relative;
}
.texttitle {
    font-size: 16px;
    font-weight: 600;
    width: 100%;
    min-height: 20px;
    line-height: 20px;
}
.textSubject {
    font-size: 14px;
    width: 100%;
    height: 30px;
    line-height: 30px;
}
.textfraction {
    font-size: 14px;
    width: 100%;
    height: 30px;
    line-height: 30px;
    color: darkorange;
}
.textcomment {
    font-size: 12px;
    width: 100%;
    min-height: 50px;
    margin-bottom: 20px;
}
.textbtn {
    border:0;
    font-size: 12px;
    color: #409EFF;
    position: absolute;
    top:155px;
    right: 0px;
    z-index: -9999;
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
