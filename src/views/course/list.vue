<template>
    <div class="totalw">
        <div>
            <el-row>
                <div style="font-size:16px;color:#ccc;margin-bottom:2px;">当前条件 ></div>
            </el-row>
            <el-row>
                <div class="mainheader">
                    <el-col :span="1.5">
                        <div class="mainclass">学科:</div>
                    </el-col>
                    <el-col :span="22">
                        <div class="miansubject">
                            <span><el-button size="small">语文</el-button></span>
                            <span><el-button size="small">数学</el-button></span>
                            <span><el-button size="small">英语</el-button></span>
                            <span><el-button size="small">物理</el-button></span>
                            <span><el-button size="small">化学</el-button></span>
                            <span><el-button size="small">科学</el-button></span>
                        </div>
                    </el-col>
                    <el-col :span="1.5">
                        <div class="mainclass">年级:</div>
                    </el-col>
                    <el-col :span="22">
                        <div class="miansubject">
                            <span><el-button size="small">一年级</el-button></span>
                            <span><el-button size="small">二年级</el-button></span>
                            <span><el-button size="small">三年级</el-button></span>
                        </div>
                    </el-col>
                    <el-col :span="1.5">
                        <div class="mainclass">类别:</div>
                    </el-col>
                    <el-col :span="22">
                        <div class="miansubject">
                            <span><el-button size="small">常规课</el-button></span>
                            <span><el-button size="small">竞赛课</el-button></span>
                        </div>
                    </el-col>
                </div>
            </el-row>
        </div>
        <div class="line"></div>
        <div class="mainlist">
            <div class="mainlist-content" v-for="item in mianlistarry"  @click="courseDetails">
                <el-row class="">
                    <el-col :span="5">
                        <div class="mainlist-img">
                            <img :src="item.img" alt="">
                        </div>
                    </el-col>
                    <el-col :span="18">
                        <div class="mainlist-center">
                            <span style="font-family: MicrosoftYaHei-Bold;font-size: 18px;color: #000000;">{{item.title}}</span>
                            <span style="display: block;margin-top: 20px;">主讲老师:  {{item.teacher}}</span>
                            <span style="opacity: 0.6;font-family: MicrosoftYaHei;font-size: 14px;color: #000000;display: block;width: 500px;margin-top: 31px;height: 38px;">{{item.describe}}</span>
                            <span style="font-family: MicrosoftYaHei-Bold;font-size: 30px;color: #F5A623;text-align: right;display: block;position: relative;margin-top: -102px;">¥{{item.money}}</span>
                            <span style="opacity: 0.4;font-family: MicrosoftYaHei;font-size: 18px;color: #000000;text-decoration:line-through;text-align: right;display: block;margin-top: 6px;">原价￥{{item.oldmony}}</span>
                        </div>    
                    </el-col>
                </el-row>
            </div>
        </div>
        <div class="line"></div>
        <div style="text-align:center">
            <el-pagination
                background
                next-text="下一页"
                prev-text="上一页"
                layout="prev, pager, next"
                :total="1000">
            </el-pagination>
        </div>
    </div>
</template>
<script>
import Vue from 'vue'
export default {
    data(){
        return {
            mianlistarry: [
                {
                    img:require('../../assets/img/Bitmap.png'),
                    title:' 文学常识梳理班——聚力计划语文一',
                    teacher: '田园',
                    describe: '这是课程介绍这是课程介绍这是课程介绍这是课程介绍这是课程介绍这是课程介绍这是课程介绍这是课程介绍这是课程介绍这是课程介绍',
                    money: '1600.00',
                    oldmony: '100.00'
                },
                {   
                    img:require('../../assets/img/Bitmap.png'),
                    title:' 文学常识梳理班——聚力计划语文一',
                    teacher: '田园',
                    describe: '这是课程介绍这是课程介绍这是课程介绍这是课程介绍这是课程介绍这是课程介绍这是课程介绍这是课程介绍这是课程介绍这是课程介绍',
                    money: '1600.00',
                    oldmony: '100.00'
                },
            ]
        }
    },
    created(){
        // AllCourse().then(data => {
        //         // console.log(data.generalvideos)
        //         this.mianlistarry = data.generalvideos
        // });
    },
    methods: {
        courseDetails(val){
            this.$router.push({name:'detail'})
        },
    }
}
</script>
<style scoped>
    .mainheader{
       border-bottom: 2px solid #fff; 
    }
 .mainclass {
     background: #E5EAF3;
     width:86px;
     height:36px;
     line-height: 36px;
     font-family: MicrosoftYaHei;
     font-size: 14px;
     color: #000000;
     text-align: center;
     display: inline-block;
 }
 .miansubject { 
    float: left;
    width:100%;
    height:36px;
    line-height: 36px;
    background: #F8FAFF;
    border:2px solid #fff; 
 }
 .miansubject button {
     width: 86px;
     font-size: 14px;
     background: #F8FAFF;
     border:none;
     text-align: center;
 }
 .line {
     height: 10px;
     width: 100%;
 }
 .mainlist {
     width: 100%;
     height: 100%;
 }
 .mainlist-center {
     width: 100%;
     margin-left: 10px;
     height: 180px;
 }
 .mainlist-content {
     margin-bottom: 10px;
     border-bottom: 1px solid #999;
 }
 .mainlist-img {
     height: 100%;
     width: 100%;
 }
 .mainlist-img  img{
     height: 100%;
     width: 100%;
 }
</style>

