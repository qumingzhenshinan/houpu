<template>
    <div class="totalw">
        <Header></Header>
        <div class="totalm">
            <div>
                <el-row>
                    <div style="font-size:16px;color:#ccc;margin-bottom:2px;">当前条件 > <span class="activedel" v-if="subjectarry.gsbuject !== undefined"><span class="condition">{{subjectarry.gsbuject}}<i class="el-icon-close del" @click="delected(subjectarry.gsbuject)"></i></span></span> <span class="activedel" v-if="subjectarry.gclass !== undefined"><span class="condition1">{{subjectarry.gclass}}<i class="el-icon-close del"></i></span></span><span class="activedel" v-if="subjectarry.gclassify !== undefined"><span class="condition1">{{subjectarry.gclassify}}<i class="el-icon-close del"></i></span></span></div>
                </el-row>
                <el-row>
                    <div class="mainheader">
                        <el-col :span="1.5">
                            <div class="mainclass">学科:</div>
                        </el-col>
                        <el-col :span="22">
                            <div class="miansubject">
                                <span v-for="item in arrysubject[0].subject"><el-button size="small" @click="subjecttype(item)" :class="{active:active == item}">{{item}}</el-button></span>
                            </div>
                        </el-col>
                        <el-col :span="1.5">
                            <div class="mainclass">年级:</div>
                        </el-col>
                        <el-col :span="22">
                            <div class="miansubject">
                                <span v-for="item in arrysubject[0].class"><el-button size="small" @click="subjectclass(item)" :class="{active:active1 == item}">{{item}}</el-button></span>
                            </div>
                        </el-col>
                        <el-col :span="1.5">
                            <div class="mainclass">类别:</div>
                        </el-col>
                        <el-col :span="22">
                            <div class="miansubject">
                                <span v-for="item in arrysubject[0].subjectstate"><el-button size="small"  @click="subjectstate(item)" :class="{active:active2 == item}">{{item}}</el-button></span>
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
                                <img :src="'http://www.houpuclass.com:8080' + item.gvimg" alt="">
                            </div>
                        </el-col>
                        <el-col :span="18">
                            <div class="mainlist-center">
                                <span style="font-family: MicrosoftYaHei-Bold;font-size: 18px;color: #000000;">{{item.gname}}</span>
                                <span style="display: block;margin-top: 20px;">主讲老师:  {{item.teacherName}}</span>
                                <p style="opacity: 0.6;font-family: MicrosoftYaHei;font-size: 14px;color: #000000;display: block;width: 600px;margin:31px 0 10px 0;min-height:40px;" v-html="item.gintro"></p>
                                
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
            arrysubject: [
                {
                    subject:['语文','数学','英语','物理','化学','科学'],
                    class: ['一年级','二年级','三年级','四年级'],
                    subjectstate: ['常规课','竞赛课']
                }
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
        api.ZeroCourse({gmoney: '0'}).then(data => {
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
            this.subjectarry.gsbuject  = val
            this.subjectquery()
        },
        subjectclass(val) {
            this.subjectarry.gclass = val
            this.active1 = val
            this.subjectquery()
        },
        subjectstate(val){
            this.subjectarry.gclassify = val
             this.active2 = val
             this.subjectquery()
        },
        subjectquery(){
            api.SubjectQuery(this.subjectarry).then(data => {

            })
        },
        delected(val){
 
            
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
 .condition {
     display:inline-block;
     border:1px solid #ccc;
     font-size:12px;
     width:50px;
     text-align: center;
     margin-left: 10px;
 }
 .condition1 {
     display:inline-block;
     border:1px solid #ccc;
     font-size:12px;
     width:60px;
     text-align: center;
     margin-left: 10px;
 }
 .activedel {
     color: #ccc;
 }
  .activedel :hover .del{
     color: #0099ff;
 }
</style>

