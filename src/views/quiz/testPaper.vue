<template>
  <div class="testPaper">
    <div class="totalw">
      <Header></Header>
      <header class="paperHead" id="headP">
        <div class="totalm">
          <span>{{$quiz.quiz.etsubject}}</span>
          <span style="cursor: pointer" @click="handIn">交卷</span>
          <span>试卷时长：{{$quiz.quiz.timeLength}}分钟{{seconds}}秒</span>
          <p>{{$quiz.quiz.etname}}</p>
        </div> 
      </header><!-- /header -->
      <div class="totalm">
        <section class="answer">
          <div class="topic" v-for="(item,i) in topics">
            <div style="margin-bottom: 20px;">
              <span class="topic_type"> {{item.type}} </span>
              <p class="topic_title"> {{item.name}} </p>
            </div>
            <div @click="selected(i,index)" class="topic_select" v-for="(data,index) in item.content">
              <span :class="{blueS: data.statu}"> {{zimu[index]}} </span>
              <p>{{data.name}}</p>
            </div>
          </div>
        </section>
        <section class="titleNumber">
          <div class="number" :class="{numbers: item.selected}" v-for="(item,index) in topics">
            {{index+1}}
          </div>
        </section>
      </div>
      <div class="clearfix">
        
      </div>
      <Footer></Footer>
    </div>
    <el-dialog
      :visible.sync="dialogVisible"
      width="30%"
      :before-close="handleClose">
      <span>您还有未提交的试题，确认提交吗？</span>
      <span slot="footer" class="dialog-footer">
        <el-button @click="dialogVisible = false">取 消</el-button>
        <el-button type="primary" @click="dialogVisible = false">确 定</el-button>
      </span>
    </el-dialog>
  </div>
</template>

<script>
window.onscroll= function(){
  //变量t是滚动条滚动时，距离顶部的距离
  var t = document.documentElement.scrollTop||document.body.scrollTop;
  var headP = document.getElementById('headP')
  if(headP) {
    if(t >= 160) {
      headP.style.position = "fixed"
      headP.style.margin = 0 + 'px'
      headP.style.top = 0 + 'px'
    }else {
      headP.style.position = "static"
      headP.style.marginTop = 20 + 'px'
      headP.style.marginBottom = 20 + 'px'
    }
  }
}
import Header from '@/components/Header'
import Footer from '@/components/Footer'
import { mapActions, mapGetters} from 'vuex'
import api from '@/api'
export default {
  name: 'testPaper',
  data () {
    return {
      seconds: 60,
      dialogVisible: false,
      zimu: ['A','B','C','D','E','F','G'],
      topics: [
        {
          type: '单选题',
          selected: false,
          title: '噪声严重污染环境,影响人们的生活和工作,已成为社会公害,下列措施中不能有效控制噪声的是( )',
          select: [
            {
              A: 'A清除城市垃圾，保持环境整洁清除城市垃圾，保持环境整洁清除城市垃圾，保持环境整洁清除城市垃圾，保持环境整洁清除城市垃圾，保持环境整洁',
              B: false
            },
            {
              A: 'B植树种草绿化',
              B: false
            },
            {
              A: 'C看到的鱼是光折射形成的实像',
              B: false
            },
            {
              A: 'D在公路与住宅区之间设置屏障',
              B: false
            }
          ]
        },{
          type: '单选题',
          selected: false,
          title: '噪声严重污染环境,影响人们的生活和工作,已成为社会公害,下列措施中不能有效控制噪声的是( )',
          select: [
            {
              A: 'A清除城市垃圾，保持环境整洁清除城市垃圾，保持环境整洁清除城市垃圾，保持环境整洁清除城市垃圾，保持环境整洁清除城市垃圾，保持环境整洁',
              B: false
            },
            {
              A: 'B植树种草绿化',
              B: false
            },
            {
              A: 'C看到的鱼是光折射形成的实像',
              B: false
            },
            {
              A: 'D在公路与住宅区之间设置屏障',
              B: false
            }
          ]
        },{
          type: '单选题',
          selected: false,
          title: '噪声严重污染环境,影响人们的生活和工作,已成为社会公害,下列措施中不能有效控制噪声的是( )',
          select: [
            {
              A: 'A清除城市垃圾，保持环境整洁清除城市垃圾，保持环境整洁清除城市垃圾，保持环境整洁清除城市垃圾，保持环境整洁清除城市垃圾，保持环境整洁',
              B: false
            },
            {
              A: 'B植树种草绿化',
              B: false
            },
            {
              A: 'C看到的鱼是光折射形成的实像',
              B: false
            },
            {
              A: 'D在公路与住宅区之间设置屏障',
              B: false
            }
          ]
        },{
          type: '单选题',
          selected: false,
          title: '噪声严重污染环境,影响人们的生活和工作,已成为社会公害,下列措施中不能有效控制噪声的是( )',
          select: [
            {
              A: 'A清除城市垃圾，保持环境整洁清除城市垃圾，保持环境整洁清除城市垃圾，保持环境整洁清除城市垃圾，保持环境整洁清除城市垃圾，保持环境整洁',
              B: false
            },
            {
              A: 'B植树种草绿化',
              B: false
            },
            {
              A: 'C看到的鱼是光折射形成的实像',
              B: false
            },
            {
              A: 'D在公路与住宅区之间设置屏障',
              B: false
            }
          ]
        },{
          type: '单选题',
          selected: false,
          title: '噪声严重污染环境,影响人们的生活和工作,已成为社会公害,下列措施中不能有效控制噪声的是( )',
          select: [
            {
              A: 'A清除城市垃圾，保持环境整洁清除城市垃圾，保持环境整洁清除城市垃圾，保持环境整洁清除城市垃圾，保持环境整洁清除城市垃圾，保持环境整洁',
              B: false
            },
            {
              A: 'B植树种草绿化',
              B: false
            },
            {
              A: 'C看到的鱼是光折射形成的实像',
              B: false
            },
            {
              A: 'D在公路与住宅区之间设置屏障',
              B: false
            }
          ]
        },{
          type: '单选题',
          selected: false,
          title: '噪声严重污染环境,影响人们的生活和工作,已成为社会公害,下列措施中不能有效控制噪声的是( )',
          select: [
            {
              A: 'A清除城市垃圾，保持环境整洁清除城市垃圾，保持环境整洁清除城市垃圾，保持环境整洁清除城市垃圾，保持环境整洁清除城市垃圾，保持环境整洁',
              B: false
            },
            {
              A: 'B植树种草绿化',
              B: false
            },
            {
              A: 'C看到的鱼是光折射形成的实像',
              B: false
            },
            {
              A: 'D在公路与住宅区之间设置屏障',
              B: false
            }
          ]
        },{
          type: '单选题',
          selected: false,
          title: '噪声严重污染环境,影响人们的生活和工作,已成为社会公害,下列措施中不能有效控制噪声的是( )',
          select: [
            {
              A: 'A清除城市垃圾，保持环境整洁清除城市垃圾，保持环境整洁清除城市垃圾，保持环境整洁清除城市垃圾，保持环境整洁清除城市垃圾，保持环境整洁',
              B: false
            },
            {
              A: 'B植树种草绿化',
              B: false
            },
            {
              A: 'C看到的鱼是光折射形成的实像',
              B: false
            },
            {
              A: 'D在公路与住宅区之间设置屏障',
              B: false
            }
          ]
        },{
          type: '单选题',
          selected: false,
          title: '噪声严重污染环境,影响人们的生活和工作,已成为社会公害,下列措施中不能有效控制噪声的是( )',
          select: [
            {
              A: 'A清除城市垃圾，保持环境整洁清除城市垃圾，保持环境整洁清除城市垃圾，保持环境整洁清除城市垃圾，保持环境整洁清除城市垃圾，保持环境整洁',
              B: false
            },
            {
              A: 'B植树种草绿化',
              B: false
            },
            {
              A: 'C看到的鱼是光折射形成的实像',
              B: false
            },
            {
              A: 'D在公路与住宅区之间设置屏障',
              B: false
            }
          ]
        },
      ],
    }
  },
  components: {
    Header,
    Footer
  },
  computed: {
    ...mapGetters(['$quiz']),
  },
  created() {
    // api.findExamOnly({etid: this.$quiz.quiz.etid}).then(data => {
    api.findExamOnly({etid: "1109c2e6311b4db18a012c42097e3f5b"}).then(data => {
      console.log(data.questions);
      data.questions.forEach(item => {
        item.content = item.content.split(";")
        item.selected = false
        var objs = []
        item.content.forEach(data => {
          var obj = {
            name: data,
            statu: false
          }
          objs.push(obj)
        })
        item.content = objs
      })
      this.topics = data.questions
    })
    this.countDown()
  },
  methods: {
    ...mapActions(['GetQuiz']),
    selected(i,int) {
      this.topics[i].selected = true
      this.topics[i].content.forEach(item => {
        item.statu = false
      })
      this.topics[i].content[int].statu = true
    },
    handleClose(done) {
      this.$confirm('确认关闭？')
        .then(_ => {
          done();
        })
        .catch(_ => {});
    },
    handIn() {
      this.topics.forEach(item => {
        var cout = 0
        if(item.selected == true) {
          cout++
        }else if(cout == 8) {
          this.$router.push('/quiz/resultPaper')
        }else{
          cout = cout
          this.dialogVisible = true
        }

      })
    },
    countDown() {
      --this.$quiz.quiz.timeLength
      var timer = setInterval(() => {
        if(this.seconds === 0) {
          this.seconds = 60
          this.$quiz.quiz.timeLength--
        }else if(this.$quiz.quiz.timeLength === 0) {
          clearInterval(timer)
          alert('时间到了')
          this.$router.push('/quiz/resultPaper')
        }else {
          this.seconds--
        }
      }, 1000);
    }
  }
}
</script>

<style scoped>
.paperHead {
  height: 64px;
  width: 1366px;
  background: #f5f9ff;
  margin: 20px 0;
}

.paperHead .totalm {
  padding: 10px 20px;
  box-sizing: border-box;
  height: 64px;
}

.paperHead .totalm span:nth-child(1) {
  float: left;
  width: 55px;
  height: 26px;
  background: #8DCB8E;
  line-height: 26px;
  text-align: center;
  color: #fff;
  margin: 8px 15px 8px 0;
}

.paperHead .totalm p:nth-child(4) {
  font-weight: 700;
  font-size: 18px;
  margin: 8px 0;
}

.paperHead .totalm span:nth-child(3) {
  float: right;
  margin: 11px 15px 11px 0;
  font-size: 14px;
}

.paperHead .totalm span:nth-child(2) {
  float: right;
  width: 130px;
  height: 42px;
  line-height: 42px;
  text-align: center;
  background: #09f;
  color: #fff;
  font-size: 16px;
  border-radius: 4px;
}

.answer {
  float: left;
  width: 760px;
  padding-left: 20px;
  margin-top: 10px;
}

.topic {
  border-bottom: 1px solid #E5EAF3;
  margin-bottom: 20px;
  padding-bottom: 10px;
}

.topic_type {
  width: 60px;
  height: 24px;
  background: #E5EAF3;
  border-radius: 4px;
  font-size: 14px;
  line-height: 24px;
  text-align: center;
  float: left;
  margin-right: 10px;
}

.topic_title {
  font-size: 16px;
  color: #2D3339;
}

.topic_select {
  width: 740px;
  border: 1px solid #E5EAF3;
  border-radius: 4px;
  margin-bottom: 10px;
  padding: 10px;
  min-height: 36px;
  display: table;
}

.topic_select:hover {
  border: 1px solid #09f;
}

.topic_select span {
  width: 38px;
  background: #E6EEF0;
  border-radius: 19px;
  text-align: center;
  vertical-align: middle;
  display: table-cell;
}

.topic_select p {
  font-size: 14px;
  min-height: 36px;
  vertical-align: middle;
  height: inherit;
  width: 689px;
  display: table-cell;
  padding-left: 20px;
}

.titleNumber {
  float: right;
  width: 350px;
  padding: 0 14px;
}

.titleNumber .number {
  width: 28px;
  height: 28px;
  border-radius: 2px;
  background: #E5EAF3;
  color: #2D3339;
  margin: 0 0 25px 15px;
  float: left;
  line-height: 28px;
  text-align: center;
  cursor: pointer;
}

.numbers {
  background: #09f !important;
  color: #fff !important;
}

.blueS {
  background: #09f !important;
  color: #fff;
}

</style>
