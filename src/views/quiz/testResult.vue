<template>
  <div class="testResult totalw">
    <Header></Header>
    <header>
      <div class="totalm">
        <span>{{$quiz.quiz.subject}}</span>
        <p>{{$quiz.quiz.title}}</p>
      </div>
    </header><!-- /header -->
    <div class="totalm">
      <div class="fractions">
        <div class="errorBU" v-for="i in 3">
          <p class="error_p1">
            <span>单选题</span>
            <p>(1分)</p>
          </p>
          <p class="topic_title">噪声严重污染环境,影响人们的生活和工作,已成为社会公害,下列措施中不能有效控制噪声的是( )</p>
          <div class="topic_select" v-for="i in 4">
            <span v-show="false">{{zimus[i-1]}}</span>
            <i v-show="false" class="topic_select_span el-icon-error"></i>
            <i v-show="true" class="topic_select_span1 el-icon-success"></i>
            <p>清除城市垃圾，保持环境整洁清除城市垃圾，保持环境整洁清除城市垃圾，保持环境整洁清除城市垃圾，保持环境整洁清除城市垃圾，保持环境整洁</p>
          </div>
          <p class="errorBU_p">正确答案：D</p>
          <p class="errorBU_p">考生答案：D</p>
          <p class="errorBU_p">题目解析：</p>
          <p class="errorBU_p1">噪声严重污染环境,影响人们的生活和工作,已成为社会公害,下列措施中不能有效控制噪声的是噪声严重污染环境,影响人们的生活和工作,已成为社会公害,下列措施中。</p>
        </div>
      </div>
    </div>
    <div class="totalm">
      <div class="fractions">
        <div class="recommended">
          <span>推荐课程</span>
        </div>
        <div class="sec" v-for="item in course" >
          <img class="sec1" src="@/assets/img/Bitmap.png" alt="">
          <div class="sec2">
            <p> {{item.title}} </p>
            <p> 主讲老师：{{item.teacher}} </p>
            <p class="sec2_3p"> {{item.intro}} </p>
          </div>
          <div class="sec3">
            <span> ￥{{item.price}} </span>
            <span> 原价￥{{item.rprice}} </span>
          </div>
        </div>
      </div>
    </div>
    <Footer></Footer>
  </div>
</template>

<script>
import Header from '@/components/Header'
import Footer from '@/components/Footer'
import { mapActions, mapGetters} from 'vuex'

export default {
  name: 'testResult',
  data () {
    return {
      zimus: ["A","B","C","D","E","F","G","H"],
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
    Footer
  },
  computed: {
    ...mapGetters(['$quiz'])
  },
  created() {
    console.log(this.$quiz);
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
header {
  height: 64px;
  width: 1366px;
  background: #f5f9ff;
  margin: 20px 0;
}

header .totalm {
  padding: 10px 20px;
}

.totalm {
  padding: 0 20px;
  box-sizing: border-box;
}

header span {
  float: left;
  width: 55px;
  height: 26px;
  background: #8DCB8E;
  line-height: 26px;
  text-align: center;
  color: #fff;
  margin: 8px 15px 8px 0;
}

header p {
  font-weight: 700;
  font-size: 18px;
  margin: 8px 0;
}

.errorBU {
  text-align: left;
  margin-bottom: 30px;
}

.error_p1 span {
  float: left;
  width: 60px;
  height: 24px;
  background: #E5EAF3;
  border-radius: 4px;
  text-align: center;
  margin-right: 10px;
}

.topic_title {
  font-size: 16px;
  color: #2D3339;
  margin: 10px 0;
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

.fractions {
  width: 750px;
  text-align: center;
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

.topic_select_span {
  font-size: 38px;
  color: #F58136;
}

.topic_select_span1 {
  font-size: 38px;
  color: #4FC17C;
}

.errorBU_p {
  margin: 5px 0;
  font-family: HiraginoSansGB-W3;
  font-size: 14px;
  color: #2D3339;
}

.errorBU_p1 {
  line-height: 20px;
  color: #666;
}
</style>
