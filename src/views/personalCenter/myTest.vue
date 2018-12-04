<template>
     <div class="totalw">
        <Header></Header>
        <div  class="totalm">
            <el-container style="margin-top:20px;">
                <el-aside width="130px">
                    <Menu></Menu>
                </el-aside>
                <el-main>
                    <el-row>
                        <el-col :span="24">
                            <el-tabs v-model="activeName" @tab-click="handleClick">
                                <el-tab-pane label="我的小测试" name="first">
                                    <div style="margin-bottom:15px;">
                                        <div class="textcontent" v-for="item in textlist">
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
                    <div style="text-align:center">
                        <el-pagination
                            background
                            :page-size="10"
                            :current-page="currentPage"
                            @size-change="handleSizeChange"
                            @current-change="handleCurrentChange"
                            next-text="下一页"
                            prev-text="上一页"
                            layout="prev, pager, next"
                            :total="total">
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
import Menu from './menu.vue'
import Header from '@/components/Header'
import Footer from '@/components/Footer'
  export default {
      components:{Menu,Header,Footer},
      data(){
        return {
           activeName: 'first',
           currentPage: 10,
           total: 100,
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

    },
    methods: {
        handleSizeChange(val) {
        
        },
        //点击下一页和点击页码时执行
        handleCurrentChange(val) {
        
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
 </style>
