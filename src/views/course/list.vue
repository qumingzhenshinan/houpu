<template>
    <div class="totalw">
        <Header></Header>
        <div class="totalm">
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
                                <span><el-button size="small" @click="subjecttype('Chinese')" :class="{active:active == 'Chinese'}">语文</el-button></span>
                                <span><el-button size="small" @click="subjecttype('Mathematics')" :class="{active:active == 'Mathematics'}">数学</el-button></span>
                                <span><el-button size="small" @click="subjecttype('English')" :class="{active:active == 'English'}">英语</el-button></span>
                                <span><el-button size="small" @click="subjecttype('Physics')" :class="{active:active == 'Physics'}">物理</el-button></span>
                                <span><el-button size="small" @click="subjecttype('Chemistry')" :class="{active:active == 'Chemistry'}">化学</el-button></span>
                                <span><el-button size="small" @click="subjecttype('science')" :class="{active:active == 'science'}">科学</el-button></span>
                            </div>
                        </el-col>
                        <el-col :span="1.5">
                            <div class="mainclass">年级:</div>
                        </el-col>
                        <el-col :span="22">
                            <div class="miansubject">
                                <span><el-button size="small" @click="subjectclass('firstgrade')" :class="{active:active1 == 'firstgrade'}">一年级</el-button></span>
                                <span><el-button size="small" @click="subjectclass('secondgrade')" :class="{active:active1 == 'secondgrade'}">二年级</el-button></span>
                                <span><el-button size="small" @click="subjectclass('threegrade')" :class="{active:active1 == 'threegrade'}">三年级</el-button></span>
                            </div>
                        </el-col>
                        <el-col :span="1.5">
                            <div class="mainclass">类别:</div>
                        </el-col>
                        <el-col :span="22">
                            <div class="miansubject">
                                <span><el-button size="small"  @click="subjectstate('Regularcourse')" :class="{active:active2 == 'Regularcourse'}">常规课</el-button></span>
                                <span><el-button size="small" @click="subjectstate('Competitioncourse')" :class="{active:active2 == 'Competitioncourse'}">竞赛课</el-button></span>
                            </div>
                        </el-col>
                    </div>
                </el-row>
            </div>
            <div class="line"></div>
            <div class="mainlist">
                <div class="mainlist-content" v-for="item in mianlistarry.slice((currentPage-1)*Mpage,currentPage*Mpage)"  @click="courseDetails(item)">
                    <el-row class="">
                        <el-col :span="5">
                            <div class="mainlist-img">
                                <img :src="'http://www.houpuclass.com:8089' + item.gvimg" alt="">
                            </div>
                        </el-col>
                        <el-col :span="18">
                            <div class="mainlist-center">
                                <span style="font-family: MicrosoftYaHei-Bold;font-size: 18px;color: #000000;">{{item.gname}}</span>
                                <span style="display: block;margin-top: 20px;">主讲老师:  {{item.teacherName}}</span>
                                <div style="opacity: 0.6;font-family: MicrosoftYaHei;font-size: 14px;color: #000000;display: block;width: 600px;margin:31px 0 10px 0;min-height:40px;" v-html="item.gintro"></div>
                                <span style="font-family: MicrosoftYaHei-Bold;font-size: 30px;color: #F5A623;text-align: right;display: block;position: absolute;top:35px;right:20px;">¥{{item.gisVip}}</span>
                                <span style="opacity: 0.4;font-family: MicrosoftYaHei;font-size: 18px;color: #000000;text-decoration:line-through;text-align: right;display: block;position: absolute;top:75px;right:20px;">原价￥{{item.gmoney}}</span>
                            </div>    
                        </el-col>
                    </el-row>
                </div>
            </div>
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
                    :total="mianlistarry.length">
                </el-pagination>
            </div>
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
    components: {
        Header,
        Footer
    },
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
            ],
            subjectarry: [],
            Mpage: 5,
            currentPage: 1,
            active: '',
            active1: '',
            active2: '',
        }
    },
    created(){
        api.AllCourse().then(data => {
                this.mianlistarry = data.generalvideos
        });
    },
    methods: {
        courseDetails(val){
            this.$router.push({name:'detail',params: {gid:val.gid}})
        },
        handleSizeChange(val) {
        
        },
        //点击下一页和点击页码时执行
        handleCurrentChange(val) {
            
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
        subjecttype(val) {
            this.active = val
            this.subjectarry[0] = val
            // this.subjectarry.push(val)
        },
        subjectclass(val) {
            this.subjectarry[1] = val
            this.active1 = val
        },
        subjectstate(val){
            this.subjectarry[2] = val
             this.active2 = val
        }
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
     min-height: 160px;
     position: relative;
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
 .active {
     color:#0099ff;
 }
</style>

