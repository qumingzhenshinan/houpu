<template>
    <div class="totalw">
        <Header></Header>
        <div class="totalm">
            <div class="mian-header">
                <el-row>
                    <el-col :span="7">
                        <div class="video">
                            <video-player class="video-player vjs-custom-skin"
                                ref="videoPlayer"
                                :playsinline="true"
                                :options="playerOptions"
                                @play="onPlayerPlay($event)"
                                @pause="onPlayerPause($event)">
                            </video-player>
                        </div>
                    </el-col>
                    <el-col :span="17">
                        <div class="videoTitle">
                            <div>
                                <span style="font-family: MicrosoftYaHei-Bold;font-size: 26px;color: #000000;font-weight:600">{{coursedetails.gname}}</span>
                                <span style="font-family: MicrosoftYaHei-Bold;font-size: 30px;color: #F5A623;display: block;position: relative;margin-top: 10px;">
                                    ¥{{coursedetails.gisVip}}
                                </span>
                                <span style="opacity: 0.4;font-family: MicrosoftYaHei;font-size: 18px;color: #000000;text-decoration:line-through;position:relative;display: block;left:150px;top:-30px;">
                                    原价￥{{coursedetails.gmoney}}
                                </span>
                                <!-- <span style="opacity: 0.6;font-family: MicrosoftYaHei;font-size: 12px;color: #000000;display: block;width: 530px;min-height: 38px;">
                                    这是课程介绍这是课程介绍这是课程介绍这是课程介绍这是课程介绍这是课程介绍这是课程介绍这是课程介绍这是课程介绍这是课程介绍这是课程介绍这是课程介绍这是课程介绍
                                </span> -->
                                <span style="opacity: 0.6;font-family: MicrosoftYaHei;font-size: 12px;color: #000000;display: block;width: 530px;height:100px;overflow:hidden" v-html="coursedetails.gintro">
                                   
                                </span>
                            </div>
                            <div style="height: 65px;">
                                <div style="position: relative;top: 12px;">
                                    <span>
                                        <img src="@/assets/img/play.png" alt="" style="width: 21px;height: 21px;position: absolute;top: 9px;left: 12px;">
                                    </span>
                                    <el-button size="small" style="background: #0099FF;text-indent: 22px;font-family: MicrosoftYaHei;font-size: 18px;color: #FFFFFF;">点击试看</el-button>
                                    <span>
                                        <img src="@/assets/img/shop.png" alt="" style="width: 21px;height: 21px;position: absolute;top: 9px;left: 150px;">
                                    </span>
                                    <el-button size="small" style="text-indent: 22px;font-family: MicrosoftYaHei;font-size: 18px;color: #FFFFFF;background: #F5A623;margin-left:10px;">立即购买</el-button>
                                    <span style="margin-left:10px;">分享至：</span>
                                    <span>
                                        <img src="@/assets/img/WeChat.png" alt="" style="width: 21px;height: 21px;;position: absolute;top: 9px;left: 350px;">
                                    </span>
                                </div>
                            </div>
                        </div>
                    </el-col>
                </el-row>
            </div>
            <div class="mian-content">
                <el-tabs v-model="activeName">
                    <el-tab-pane label="课程目录" name="first" v-if="cataloguearr.length != 0">
                        <div v-for="item in cataloguearr" style="margin-bottom:20px;">
                            <div class="chaptersList">
                                <p class="downOn">
                                    <span>
                                        <span @click="startMp4(item)">▷</span>
                                        &emsp;{{item.vcname}}
                                    </span>
                                    <el-button size="small" style="background: #0099FF;color: #fff;float:right;font-family:MicrosoftYaHei;font-size: 14px;margin-top:10px;">回放课程</el-button>
                                </p>
                            </div>
                        </div>
                    </el-tab-pane>
                    <el-tab-pane label="课程介绍" name="second" v-if="coursedetails.gintro != ''">
                        <span  v-html="coursedetails.gintro"></span>
                    </el-tab-pane>
                    <el-tab-pane label="课程评论" name="third">
                        <div class="comment">
                            <div v-for="item in commentlist.slice((currentPage-1)*Mpage,currentPage*Mpage)">
                                <el-row style="border-bottom: 1px solid #999;min-height:120px;">
                                    <div>                           
                                        <el-col :span="20">
                                            <span>
                                                <img src="@/assets/img/touxiang.png" alt="" style="width:45px;height:45px;margin-top: 20px;">
                                            </span>
                                            <span style="position:absolute;top:20px;left:60px;">{{item.userName}}</span>
                                            <p style="font-size: 14px;color: #333333;text-align: left;line-height: 22px;width: 79%;min-height:30px;display: block;margin:-20px 0 20px 60px;">
                                                {{item.content}}
                                            </p>
                                        </el-col>
                                        <!-- <el-col :span="4">
                                            <div class="rate">
                                                <el-rate v-model="item.score"></el-rate>
                                            </div>
                                        </el-col> -->
                                    </div>
                                </el-row>
                            </div>
                            <No-data :inforData="commentlist" tips="暂无评论"></No-data>
                        </div>
                        <div class="line"></div>
                        <div style="text-align:center;margin-top:20px;">
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
                                :total="commentlist.length">
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
import NoData from '@/components/noDataDisplay'
import api from '@/api'
export default {
    components: {
        Header,
        Footer,
        videoPlayer,
        NoData
    },
    data(){
        return {
            activeName: 'first',
            value1:2,
            Mpage: 2,
			currentPage: 1,
            playerOptions: {
                //playbackRates: [0.7, 1.0, 1.5, 2.0], //播放速度
                autoplay: false, //如果true,浏览器准备好时开始回放。
                muted: false, // 默认情况下将会消除任何音频。
                loop: false, // 导致视频一结束就重新开始。
                preload: 'auto', // 建议浏览器在<video>加载元素后是否应该开始下载视频数据。auto浏览器选择最佳行为,立即开始加载视频（如果浏览器支持）
                language: 'zh-CN',
                aspectRatio: '16:9', // 将播放器置于流畅模式，并在计算播放器的动态大小时使用该值。值应该代表一个比例 - 用冒号分隔的两个数字（例如"16:9"或"4:3"）
                fluid: true, // 当true时，Video.js player将拥有流体大小。换句话说，它将按比例缩放以适应其容器。
                sources: [{
                type: "video/mp4",
                src: "" //你的m3u8地址（必填）
                }],
                poster: "", //你的封面地址
                // width: document.documentElement.clientWidth,
                notSupportedMessage: '此视频暂无法播放，请稍后再试', //允许覆盖Video.js无法播放媒体源时显示的默认信息。
                 controlBar: {
                  timeDivider: true,
                  durationDisplay: true,
                  remainingTimeDisplay: false,
                  fullscreenToggle: true //全屏按钮
                 }
            },
            chaptersList: [],
            introductionlist: [
                {
                    title:'知识体系化，专业只为提升',
                    main: '十年语文沉淀，十年语文沉淀十年语文沉淀十年语文沉淀十年语文沉淀'
                },
                {
                    title:'知识体系化，专业只为提升',
                    main: '十年语文沉淀，十年语文沉淀十年语文沉淀十年语文沉淀十年语文沉淀'
                },
                {
                    title:'知识体系化，专业只为提升',
                    main: '十年语文沉淀，十年语文沉淀十年语文沉淀十年语文沉淀十年语文沉淀'
                },
                {
                    title:'知识体系化，专业只为提升',
                    main: '十年语文沉淀，十年语文沉淀十年语文沉淀十年语文沉淀十年语文沉淀'
                },
            ],
            commentlist: [],
            cataloguearr: [],
            coursedetails: {},
        }
    },
    created(){
        
        // for(let key in this.playerOptions.sources){
             // this.playerOptions.sources[key].src=require('../../assets/Course/test.mp4')
        // }
        var data = {
            gid:this.$route.params.gid,
            // gid:'3b88734212ce439c83e5b9b181183fd9'
        }
        // 获取评论
        api.Coursecomment(data).then(data =>{
            console.log(data);
            data.comments.forEach(item => {
                api.selectUser({uid: item.cuid}).then(data => {
                    this.commentlist.push({...data,content:data.content})
                })
            })
            
        })
        // 获取课程详情
        var _data = data
        api.Coursedetails(_data).then(data =>{
            this.playerOptions.poster = 'http://www.houpuclass.com:8080' + data.gvimg
            this.coursedetails = data
            if(data.gvideoUrl != ''){
                for(let key in this.playerOptions.sources){
                    this.playerOptions.sources[key].src = 'http://www.houpuclass.com:8080' + data.gvideoUrl
                }
            }else{
                // 获取章节
                api.coursecatalogue(_data).then(data => {
                    // console.log(data.videoChild)
                    this.cataloguearr = data.videoChild
                    console.log(this.cataloguearr)
                    this.playerOptions.sources[0].src = 'http://www.houpuclass.com:8080' + data.videoChild[0].vcideoUrl
                })
            }
        })
    },
    methods: {
        onPlayerPlay(event){
            // console.log(event);
        },// 视频播放
        onPlayerPause(){},// 视频暂停
        handleSizeChange(val) {
        
        },
        startMp4(data) {
            this.playerOptions.sources[0].src = 'http://www.houpuclass.com:8080' + data.vcideoUrl
            var t = document.documentElement||document.body
            t.scrollTop = 100
            this.playerOptions.autoplay = true
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
    },
    computed: {
        player() {
            return this.$refs.videoPlayer.player
            
        }
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
.downOn span {
    cursor: pointer;
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
    margin: 20px 0 0 70px;
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


