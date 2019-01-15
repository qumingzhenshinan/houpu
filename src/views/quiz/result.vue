<template>
  <div class="result totalw">
    <Header></Header>
    <div class="totalm">
      <div class="fraction">
        恭喜获得{{$quiz.testResult}}分，继续努力！
      </div>
      <div class="fractions">
        <el-button @click="getAnswer" type="primary">查看答案</el-button>
        <div v-if="$quiz.testResult < 60">
            <div class="recommended">
            <span>推荐课程</span>
          </div>
          <div class="sec" v-for="item in course" >
            <img class="sec1" :src="base + item.gvimg" alt="">
            <div class="sec2">
              <p> {{item.gname}} </p>
              <p> 主讲老师：{{item.teacherName}} </p>
              <div class="sec2_3p" v-html="item.gintro"></div>
            </div>
            <div class="sec3">
              <span> ￥{{item.price}} </span>
              <span> 原价￥{{item.gmoney}} </span>
            </div>
          </div>
          <no-data :inforData='course' tips='暂无课程'></no-data>
        </div>  
      </div>
    </div>
    <Footer></Footer>
  </div>
</template>

<script>
import Header from '@/components/Header'
import { mapActions, mapGetters} from 'vuex'
import Footer from '@/components/Footer'
import noData from '@/components/noDataDisplay'
import api from '@/api'
import base from '@/baseimg'
export default {
  name: 'result',
  data () {
    return {
      base: '',
      course: [
        {
          title: '文学常识梳理班——聚力计划语文一',
          teacher: '田园',
          intro: '这是课程介绍这是课程介绍这是课程介绍这是课程介绍这是课程介绍这是课程介绍这是课程介绍这是课程介绍这是课程介绍这是课程介绍',
          price: '1680.00',
          rprice: '2000.00'
        },{
          title: '文学常识梳理班——聚力计划语文一',
          teacher: '田园',
          intro: '这是课程介绍这是课程介绍这是课程介绍这是课程介绍这是课程介绍这是课程介绍这是课程介绍这是课程介绍这是课程介绍这是课程介绍',
          price: '1680.00',
          rprice: '2000.00'
        },{
          title: '文学常识梳理班——聚力计划语文一',
          teacher: '田园',
          intro: '这是课程介绍这是课程介绍这是课程介绍这是课程介绍这是课程介绍这是课程介绍这是课程介绍这是课程介绍这是课程介绍这是课程介绍',
          price: '1680.00',
          rprice: '2000.00'
        },{
          title: '文学常识梳理班——聚力计划语文一',
          teacher: '田园',
          intro: '这是课程介绍这是课程介绍这是课程介绍这是课程介绍这是课程介绍这是课程介绍这是课程介绍这是课程介绍这是课程介绍这是课程介绍',
          price: '1680.00',
          rprice: '2000.00'
        },
      ]
    }
  },
  components: {
    Header,
    Footer,
    noData
  },
  computed: {
    ...mapGetters(['$quiz']),
  },
  created() {
    this.base = base
    api.getrecommendedC({
      uid: window.sessionStorage.getItem("user"),
      etid: this.$quiz.quiz.etid
      // etid: 'fa315beb4a984093b608439b79baa484'
    }).then(data => {
      console.log(data);
      this.course = data.generalvideos
    })
  },
  methods: {
    getAnswer() {
      this.$router.push('/quiz/testResult')
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
.fraction {
  width: 750px;
  margin: 0 auto;
  background: url(../../assets/img/quizRB.png) no-repeat;
  height: 195px;
  font-size: 30px;
  color: #F5A623;
  text-align: center;
  line-height: 190px;
}

.fractions {
  width: 750px;
  margin: 0 auto;
  text-align: center;
  padding-top: 20px;
  margin-bottom: 40px;
}

.recommended {
  border-bottom: 1px solid #E6E6E6;
  height: 30px;
  margin: 10px 0;
}

.recommended span {
  float: left;
  color: #09f;
  border-bottom: 2px solid #09f;
  height: 29px;
}

.sec {
  height: 90px;
  padding: 15px 0;
  border-bottom: 1px solid #e6e6e6;
}

.sec1 {
  width: 160px;
  height: 90px;
  float: left;
}

.sec2 {
  width: 310px;
  height: 90px;
  float: left;
  margin-left: 15px;
}

.sec2 p:nth-child(1) {
  opacity: 1;
}

.sec2 p {
  text-align: left;
  padding: 2px 0;
  opacity: 0.6;
}

.sec2_3p {
  overflow: hidden;
  text-overflow: ellipsis;
  display: -webkit-box;
  -webkit-line-clamp: 2;
  -webkit-box-orient: vertical;
  padding: 0 !important;
  text-align: left;
  opacity: 0.6;
  height: 40px;
}

.sec3 {
  float: right;
}

.sec3 span {
  display: block;
}

.sec3 span:nth-child(1) {
  color: #F5A623;
  font-size: 20px;
}

.sec3 span:nth-child(2) {
  color: #000;
  opacity: 0.4;
  font-size: 12px;
  text-decoration: line-through;
}

</style>
