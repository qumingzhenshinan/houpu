<template>
    <div class="totalw">
        <Header></Header>
        <div class="totalm">
            <div v-if="$route.path == '/zeroCourse' || $route.path == '/newCourse'  || $route.path == '/courseList'">
                <el-row style="padding: 15px 0">
                    <div style="font-size:16px;color:#ccc;margin-bottom:2px;">当前条件 >
                        <span class="activedel" v-if="subjectarry.gsbuject !== undefined">
                            <span class="condition">{{subjectarry.gsbuject}}
                                <i class="el-icon-close del" @click="delected('1')"></i>
                            </span>
                        </span>
                        <span class="activedel" v-if="subjectarry.gclass !== undefined">
                            <span class="condition">{{subjectarry.gclass}}
                                <i class="el-icon-close del" @click="delected('2')"></i>
                            </span>
                        </span>
                        <span class="activedel" v-if="subjectarry.gclassify !== undefined">
                            <span class="condition">{{subjectarry.gclassify}}
                                <i class="el-icon-close del" @click="delected('3')"></i>
                            </span>
                        </span>
                    </div>
                </el-row>
                <el-row>
                    <div class="mainheader">
                        <el-col :span="1.5">
                            <div class="mainclass">学科:</div>
                        </el-col>
                        <el-col :span="22">
                            <div class="miansubject">
                                <span v-for="item in arrysubject[0].subject">
                                    <el-button size="small" @click="subjecttype(item)" :class="{active:active == item}">{{item}}</el-button>
                                </span>
                            </div>
                        </el-col>
                        <el-col :span="1.5">
                            <div class="mainclass">年级:</div>
                        </el-col>
                        <el-col :span="22">
                            <div class="miansubject">
                                <span v-for="item in arrysubject[0].class">
                                    <el-button size="small" @click="subjectclass(item)" :class="{active:active1 == item}">{{item}}</el-button>
                                </span>
                            </div>
                        </el-col>
                        <el-col :span="1.5">
                            <div class="mainclass">类别:</div>
                        </el-col>
                        <el-col :span="22">
                            <div class="miansubject">
                                <span v-for="item in arrysubject[0].subjectstate">
                                    <el-button size="small"  @click="subjectstate(item)" :class="{active:active2 == item}">{{item}}</el-button>
                                </span>
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
                                <p style="opacity: 0.6;font-family: MicrosoftYaHei;font-size: 14px;color: #000000;display: block;width: 600px;margin:31px 0 10px 0;min-height:40px;" v-if="item.gintro == ''">暂无课程介绍</p>
                                <p style="opacity: 0.6;font-family: MicrosoftYaHei;font-size: 14px;color: #000000;display: block;width: 600px;margin:31px 0 10px 0;min-height:40px;" v-html="item.gintro" v-if="item.gintro != ''"></p>
                                <span style="font-family: MicrosoftYaHei-Bold;font-size: 30px;color: #F5A623;text-align: right;display: block;position: absolute;top:35px;right:20px;">¥{{item.gisVip}}</span>
                                <span style="opacity: 0.4;font-family: MicrosoftYaHei;font-size: 18px;color: #000000;text-decoration:line-through;text-align: right;display: block;position: absolute;top:75px;right:20px;">原价￥{{item.gmoney}}</span>
                            </div>    
                        </el-col>
                    </el-row>
                </div>
                <no-data :inforData='mianlistarry' :tips='terms'></no-data>
            </div>
            <div class="line"></div>
            <div style="text-align:center" v-if="mianlistarry.length !== 0">
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
                        :total="mianlistarry.length">
                    </el-pagination>
                </div>
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
import noData from '@/components/noDataDisplay'
import axios from 'axios'
import { mapGetters } from 'vuex'

export default {
    components: {
        Header,
        Footer,
        noData
    },
    computed: {
        ...mapGetters(['$course']),
    },
    data(){
        return {
            terms: '当前课程暂无',
            mianlistarry: [],
            arrysubject: [
                {
                    subject: [],
                    class: [],
                    subjectstate: []
                }
            ],
            subjectarry: {},
            Mpage: 5,
            currentPage: 1,
            active: null,
            active1: null,
            active2: null,
        }
    },
    created(){
        var paths = this.$route.path
        axios.get('http://www.houpuclass.com:8080/course/selectGclassify').then(data => {
            this.arrysubject[0].subjectstate = data.data.data.lists
        })
        axios.get('http://www.houpuclass.com:8080/course/selectGclass').then(data => {
            this.arrysubject[0].class = data.data.data.lists
        })
        axios.get('http://www.houpuclass.com:8080/course/selectGsbuject').then(data => {
            this.arrysubject[0].subject = data.data.data.lists
        })
        if(paths === '/courseList') {
            // 所有课程 条件筛选
            if(this.$course.term.sub !== undefined) {
                this.subjectarry.gsbuject = this.$course.term.sub
                this.subjectarry.gclass = this.$course.term.gclass
                this.subjectarry.gclassify = this.$course.term.gtype
                this.active = this.$course.term.sub
                this.active1 = this.$course.term.gclass
                this.active2 = this.$course.term.gtype
                this.subjectquery()
            }else {
                api.AllCourse().then(data => {
                    this.mianlistarry = data.generalvideos
                })
            }
        }else if(paths === '/selectCourse') {
            console.log(this.$course);
            this.mianlistarry = this.$course.courseList
        }else if(paths === '/newCourse') {
            // 最新课程
            api.newAllC().then(data => {
                this.mianlistarry = data.generalvideos
            })

        }else if(paths === '/recommended') {
            // 推荐课程
            api.getrecommendedC({
                uid: window.sessionStorage.getItem("user"),
                // etid: 'fa315beb4a984093b608439b79baa484'
                etid: this.$quiz.quiz.etid
            }).then(data => {
                this.mianlistarry = data.generalvideos
            })
        }else if(paths === '/myCourses') {
            // 我的课程
            api.myCourseLise({userid: window.sessionStorage.getItem("user")}).then(data => {
                if(data.data !== null) {
                    this.mianlistarry = data.userLearns
                }else {
                    this.terms = '暂无购买课程'
                }
            })
        } else {
            // 0元课程
            api.allZeroC().then(data => {
                this.mianlistarry = data.generalvideos
            })
        }
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
            this.terms = '搜索条件不完整'
            this.active = val
            this.subjectarry.gsbuject  = val
            this.subjectquery()
        },
        subjectclass(val) {
            this.terms = '搜索条件不完整'
            this.subjectarry.gclass = val
            this.active1 = val
            this.subjectquery()
        },
        subjectstate(val){
            this.terms = '当前课程暂无'
            this.subjectarry.gclassify = val
            this.active2 = val
            this.subjectquery()
        },
        subjectquery(){
            var paths = this.$route.path
            if(this.active === null && this.active1 === null && this.active2 === null){
                console.log('2');
                api.AllCourse().then(data => {
                    this.mianlistarry = data.generalvideos
                })
            }else {
                if(paths === '/courseList') {
                   api.SubjectQuery(this.subjectarry).then(data => {
                        if(data.generalvideos !== undefined) {
                            this.mianlistarry = data.generalvideos
                        }else {
                            this.mianlistarry = []
                        }
                        
                    }) 
               }else if(paths === '/newCourse') {
                    api.NewCourse(this.subjectarry).then(data => {
                        if(data.generalvideos !== undefined) {
                            this.mianlistarry = data.generalvideos
                        }else {
                            this.mianlistarry = []
                        }
                    })
               }else {
                    api.ZeroCourse(this.subjectarry).then(data => {
                        if(data.generalvideos !== undefined) {
                            this.mianlistarry = data.generalvideos
                        }else {
                            this.mianlistarry = []
                        }
                    })
               }
            }
        },
        delected(val){
            if(val === '1') {
                this.subjectarry.gsbuject = undefined
                this.active = null
            }else if(val === '2') {
                this.subjectarry.gclass = undefined
                this.active1 = null
            }else {
                this.subjectarry.gclassify = undefined
                this.active2 = null
            }
            this.subjectquery()
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
  height: 20px;
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
  width: 100%;
  height: 143px;
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
  padding: 0 5px;
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

