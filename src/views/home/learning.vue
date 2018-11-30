<template>
  <div class="learning">
    <div class="learnProcess totalm">
      <div class="title">
        四方面入手解决学习难题
      </div>
      <div class="learnPbox">
        <div class="learndiv" v-for="learn in learnP">
          <img :src="learn.url" alt="">
          <p> {{learn.title}} </p>
          <p> {{learn.present}} </p>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: 'learning',
  data () {
    return {
      learnP: [
        {
          url: require('@/assets/img/learn1.png'),
          title: '一诊',
          present: '通过评测，发现知识漏洞。选择适合课程，精准学习。'
        },{
          url: require('@/assets/img/learn2.png'),
          title: '二学',
          present: '名师讲解，深刻讲解重难点。讲义下载，随时随地学习。'
        },{
          url: require('@/assets/img/learn3.png'),
          title: '三练',
          present: '一讲一练，检测、巩固学习效果、查漏补缺'
        },{
          url: require('@/assets/img/learn4.png'),
          title: '四问',
          present: '不懂就问，学习群内老师实时答疑解惑'
        }
      ]
    }
  },

}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
.learnProcess {
  margin-top: 45px;
}

.title {
  font-size: 24px;
  line-height: 24px;
  text-align: center;
}

.title::after {
  content: "";
  padding: 0 80px;
  background: url('../../assets/img/learnr.png') no-repeat 18px 5px;
}

.title::before {
  content: "";
  padding: 0 80px;
  background: url('../../assets/img/learnl.png') no-repeat -15px 5px;
}

.title img {
  display: inline-block;
}

.learnPbox {
  margin: 0 auto;
  width: 1100px;
  margin-top: 45px;
  text-align: center;
  height: 180px;
}

.learndiv {
  width: 230px;
  float: left;
  margin: 0 22px;
  color: #2D3339;
}

.learndiv p:nth-child(2) {
  font-size: 20px;
  height: 40px;
  line-height: 30px;
}

.learndiv p:nth-child(3) {
  font-size: 15px;
}
</style>
