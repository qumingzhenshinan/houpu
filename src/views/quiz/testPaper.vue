<template>
  <div class="testPaper">
    <div class="totalw">
      <Header></Header>
      <header class="paperHead">
        <div class="totalm">
          <span>{{$quiz.quiz.subject}}</span>
          <span>交卷</span>
          <span>试卷时长：{{$quiz.quiz.timeLenght}}</span>
          <p>{{$quiz.quiz.title}}</p>
        </div> 
      </header><!-- /header -->
      <Footer></Footer>
    </div>
  </div>
</template>

<script>
import Header from '@/components/Header'
import Footer from '@/components/Footer'
import { mapActions, mapGetters} from 'vuex'
export default {
  name: 'testPaper',
  data () {
    return {
      
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
    console.log(this.$quiz.quiz);
  },
  methods: {
    ...mapActions(['GetQuiz'])
  }
}
</script>

<style scoped>
.paperHead {
  height: 64px;
  width: 100%;
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
</style>
