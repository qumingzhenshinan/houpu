<template>
    <div class="totalw">
        <Header></Header>
        <div class="totalm">
            <div class="mian-header">
                <el-row>
                    <el-col :span="7">
                        <div class="video">
                            <!-- <video-player class="video-player vjs-custom-skin"
                                ref="videoPlayer"
                                :playsinline="true"
                                :options="playerOptions"
                                @play="onPlayerPlay($event)"
                                @pause="onPlayerPause($event)">
                            </video-player> -->
                            <img src="../../assets/img/视频播放.png" alt="" style="width: 100%;height: 100%;">
                        </div>
                    </el-col>
                    <el-col :span="17">
                        <div class="videoTitle">
                            <div>
                                <span style="font-family: MicrosoftYaHei-Bold;font-size: 26px;color: #000000;font-weight:600">文学常识梳理班——聚力计划语文一</span>
                                <span style="font-family: MicrosoftYaHei-Bold;font-size: 30px;color: #F5A623;display: block;position: relative;margin-top: 10px;">
                                    ¥1680.00
                                </span>
                                <span style="opacity: 0.4;font-family: MicrosoftYaHei;font-size: 18px;color: #000000;text-decoration:line-through;position:relative;display: block;left:150px;top:-30px;">
                                    原价￥100.00
                                </span>
                                <span style="opacity: 0.6;font-family: MicrosoftYaHei;font-size: 12px;color: #000000;display: block;width: 530px;height: 38px;">
                                    这是课程介绍这是课程介绍这是课程介绍这是课程介绍这是课程介绍这是课程介绍这是课程介绍这是课程介绍这是课程介绍这是课程介绍
                                </span>
                            </div>
                            <div style="height: 65px;">
                                <div style="position: relative;top: 12px;">
                                    <span>
                                        <img src="../../assets/img/播放.png" alt="" style="width: 21px;height: 21px;position: absolute;top: 9px;left: 12px;">
                                    </span>
                                    <el-button size="small" style="background: #0099FF;text-indent: 22px;font-family: MicrosoftYaHei;font-size: 18px;color: #FFFFFF;">点击试看</el-button>
                                    <span>
                                        <img src="../../assets/img/购物车.png" alt="" style="width: 21px;height: 21px;position: absolute;top: 9px;left: 150px;">
                                    </span>
                                    <el-button size="small" style="text-indent: 22px;font-family: MicrosoftYaHei;font-size: 18px;color: #FFFFFF;background: #F5A623;margin-left:10px;">立即购买</el-button>
                                    <span style="margin-left:10px;">分享至：</span>
                                    <span>
                                        <img src="../../assets/img/微信.png" alt="" style="width: 21px;height: 21px;;position: absolute;top: 9px;left: 350px;">
                                    </span>
                                </div>
                            </div>
                        </div>
                    </el-col>
                </el-row>
            </div>
            <div class="mian-content">
                <el-tabs v-model="activeName" @tab-click="handleClick">
                    <el-tab-pane label="课程目录" name="first">
                        <div v-for="item in chaptersList" style="margin-bottom:20px;">
                            <div class="chapterscontent">
                                <p class="chapters">&emsp;<span style="width: 60px;height: 25px;text-align: center;color:#fff;line-height:25px;background-color: #0099FF;border-radius: 0 12.5px 12.5px 0;float: left;margin-top: 18px;position:absolute;top:-7px;left:0;">章节{{item.chaptersnum}}</span><span class="chaptertitle">{{item.title}}</span></p>
                            </div>
                            <div class="chaptersList" v-for="itemd in item.chapters">
                                <p class="downOn"><span>▷&emsp;第{{item.chaptersnum}}节：{{itemd}}</span><span class="chapterstime">{{item.date}}</span><el-button size="small" style="background: #0099FF;color: #fff;float:right;font-family:MicrosoftYaHei;font-size: 14px;margin-top:10px;">回放课程</el-button></p>
                            </div>
                        </div>
                    </el-tab-pane>
                    <el-tab-pane label="课程介绍" name="second">
                        <el-row>
                            <el-col :span="24">
                                <span class="introduction-title">适合学员</span>
                                <div class="introduction-content">
                                    <p>1、介绍介绍介绍介绍介绍介绍介绍介绍介绍介绍</p>
                                    <p>2、介绍介绍介绍介绍介绍介绍介绍介绍介绍介绍</p>
                                    <p>3、介绍介绍介绍介绍介绍介绍介绍介绍介绍介绍</p>
                                </div>
                                <div>
                                    <span class="introduction-title">培养目标</span>
                                    <div class="introduction-content" >
                                        <p>1、介绍介绍介绍介绍介绍介绍介绍介绍介绍介绍</p>
                                        <p>2、介绍介绍介绍介绍介绍介绍介绍介绍介绍介绍</p>
                                    </div>
                                </div>
                            </el-col>
                        </el-row>
                        <div class="thinline"></div>
                        <el-row style="min-height:150px;">
                            <div >
                                <el-col :span="3">
                                    <div>
                                        <span class="introduction-title">授课老师</span>
                                    </div>
                                    <div style="width:100%;height:100%;">
                                        <img src="../../assets/img/头像1.png" alt="" style="width:45px;height:45px;position:absolute;top:60px;left:100px;">
                                        <span style="color:red;font-size:12px;position:absolute;top:105px;left:110px;">田园</span>
                                    </div>
                                </el-col>
                                <el-col :span="21">
                                    <p style="margin-top:65px;text-index:5px;width:60%;min-height:30px;text-indent:2em;margin-bottom:20px;">绍介绍介绍介绍介绍介绍介绍介绍介绍绍介绍介绍介绍介绍介绍介绍介绍介绍介绍绍介绍介绍介绍介绍绍介绍绍介绍介绍介绍介绍介绍介绍介绍绍介绍介绍介绍介绍介绍介绍介绍介绍介绍绍介绍介绍介绍绍介绍介绍介绍介绍介绍介绍介绍介绍介绍</p>
                                </el-col>
                            </div>
                        </el-row>
                        <div class="thinline"></div>
                        <el-row >
                            <el-col :span="24">
                                <div>
                                    <span class="introduction-title">课程优势</span>
                                </div>
                                <div style="width:65%;margin-top:20px;">
                                    <div class="advantage-content">
                                        <img src="../../assets/img/心.png" style="width:45px;height:45px;"> 
                                        <p class="advantage-title">知识体系化，专业只为提升</p>
                                        <p class="advantage-main">十年语文沉淀，十年语文沉淀十年语文沉淀十年语文沉淀十年语文沉淀</p>
                                    </div>
                                    <div class="advantage-content" style="margin-left:30px;">
                                        <img src="../../assets/img/心.png" style="width:45px;height:45px;"> 
                                        <p class="advantage-title">知识体系化，专业只为提升</p>
                                        <p class="advantage-main">十年语文沉淀，十年语文沉淀十年语文沉淀十年语文沉淀十年语文沉淀</p>
                                    </div>
                                    <div class="advantage-content">
                                        <img src="../../assets/img/心.png" style="width:45px;height:45px;"> 
                                        <p class="advantage-title">知识体系化，专业只为提升</p>
                                        <p class="advantage-main">十年语文沉淀，十年语文沉淀十年语文沉淀十年语文沉淀十年语文沉淀</p>
                                    </div>
                                    <div class="advantage-content" style="margin-left:30px;">
                                        <img src="../../assets/img/心.png" style="width:45px;height:45px;"> 
                                        <p class="advantage-title">知识体系化，专业只为提升</p>
                                        <p class="advantage-main">十年语文沉淀，十年语文沉淀十年语文沉淀十年语文沉淀十年语文沉淀</p>
                                    </div>
                                </div>
                            </el-col>
                        </el-row>
                        <div class="thinline"></div>
                        <el-row style="margin-bottom:20px;">
                            <el-col>
                                <div>
                                    <span class="introduction-title">学科架构</span>
                                </div>
                                <img src="../../assets/img/架构.png" alt="" style="width:60%;margin-top:20px;">
                            </el-col>
                        </el-row>
                    </el-tab-pane>
                    <el-tab-pane label="课程评论" name="third">
                        <div class="comment">
                            <el-row style="border-bottom: 1px solid #999;min-height:120px;">
                                <div>                           
                                    <el-col :span="20">
                                        <span>
                                            <img src="../../assets/img/头像1.png" alt="" style="width:45px;height:45px;margin-top: 20px;">
                                        </span>
                                        <span style="position:absolute;top:20px;left:60px;">李磊</span>
                                        <p style="font-size: 14px;color: #333333;text-align: left;line-height: 22px;width: 79%;min-height:30px;display: block;margin:-20px 0 20px 60px;">
                                            评价内容评价内容评价内容评价内容评价内容评价内容评价内容评价内容评价内容评价内容评价内容评价内容评价内容价内容评价内容评价内容评价内容评价内容评价内容评价内容评价内容评价内容评价内容评价内容
                                        </p>
                                    </el-col>
                                    <el-col :span="4">
                                        <div class="rate">
                                            <el-rate v-model="value1"></el-rate>
                                        </div>
                                    </el-col>
                                </div>
                            </el-row>
                        </div>
                        <div class="line"></div>
                        <div style="text-align:center;margin-top:20px;">
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
                    </el-tab-pane>
                </el-tabs>
            </div>
        </div>
        <Footer></Footer>
    </div>
</template>
<script>
import Vue from 'vue'
import { videoPlayer } from 'vue-video-player';
import Header from '@/components/Header'
import Footer from '@/components/Footer'
import api from '@/api'
export default {
    components: {
        Header,
        Footer
    },
    data(){
        return {
            activeName: 'first',
            value1:2,
            total: 0,
            currentPage: 10,
            chaptersList: [
                {
                    title:' 先秦诗歌与史传散文',
                    chapters:[' 先秦诗歌与史传散文',' 先秦诗歌与史传散文1'],
                    date: '8:20',
                    chaptersnum:'一',
                },
                {
                    title:' 先秦诗歌与史传散文',
                    chapters:[' 先秦诗歌与史传散文',' 先秦诗歌与史传散文',' 先秦诗歌与史传散文'],
                    date: '8:20',
                    chaptersnum:'二',
                },

            ],
        }
    },
    created(){
        var data = {
            gid:this.$route.params.gid,
        }
        api.Coursecatalogue(data).then(data =>{
            this.cataloguearr = data.generalvideos
        })
    },
    methods: {
        onPlayerPlay(){

        },
       onPlayerPause(){

       },
        handleSizeChange(val) {
        
        },
        //点击下一页和点击页码时执行
      handleCurrentChange(val) {
       
      },
       handleClick(tab, event) {
            console.log(tab, event);
        },
    }
}
</script>
<style scoped>
.mian-header {
    margin-top: 20px;
}
.video {
    width: 100%;
    height: 100%;
}
.videoTitle {
    width: 100%;
    height: 100%;
    margin-left: 20px;
}
.mian-content {
    width: 100%;
    height: 100%;
    margin-top:20px; 
}
.chapterscontent {
    height: 50px;
    line-height: 50px;
    border-bottom: 1px solid #ddd;
}
.chapters {
    color: #424242;
    font-size:13px;
    font-weight: 600;
    position: relative;
}
.chaptertitle {
    margin-left:70px; 
}
.chaptersList {
    width: 100%;
    height: 100%;
}
.chaptersList p {
    width: 100%;
    height: 50px;
    line-height: 50px;
    border-bottom: 1px solid #ddd;
    text-indent: 20px;
    position: relative;
}
.chapterstime {
    position: absolute;
    top: 0;
    left: 650px;
}
.downOn{
    color: #0196fd;
}
.other{
    color: black;
}
.comment {
    width: 100%;
    height: 100%;
}
.line {
     height: 10px;
     width: 100%;
 }
.rate {
    margin: 20px 0 0 100px;
}
.introduction-title {
    color: darkgreen;
    font-size: 30px;
    top: 10px;
    left: 10px;
    position: relative;
}
.introduction-content {
    width: 60%;
    height: 100%;
    margin: 20px 0 20px 0;
    text-indent: 100px;
}
.advantage-content {
    width:48%;
    min-height:170px;
    float:left;
    text-align: center;
    margin-bottom: 20px;
}
.advantage-title {
    color:darkorange;
    font-size: 18px;
    width: 100%;
    margin-top:10px; 
}
.advantage-main {
    font-size: 14px;
    margin-top:10px; 
    min-height: 40px;
}
.thinline {
    border-bottom: 1px solid #999;
    width: 65%;
}
</style>


