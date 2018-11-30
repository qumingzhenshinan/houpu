<template>
  <div class="home">
    <div class="totalw">
      <div class="block">
        <el-carousel height="300px">
          <el-carousel-item v-for="item in 4" :key="item">
            <h3>{{ item }}</h3>
          </el-carousel-item>
        </el-carousel>
      </div>
      <Course></Course>
      <Teacher></Teacher>
      <Student></Student>
      <Learning></Learning>
    </div>
  </div>
</template>

<script>
window.onload=function(){
  // 首页教师展示
  var bannerb = document.getElementById('bannerb');
  var goleft = document.getElementById('leftimg');
  var goright = document.getElementById('rightimg');
  goleft.onclick=function(){
    bannerb.scrollLeft=bannerb.scrollLeft-312
  }
  goright.onclick=function(){
    bannerb.scrollLeft=bannerb.scrollLeft+312
  }
  // 首页学生展示
  var bannerT = document.getElementById('bannerT');
  var goleftT = document.getElementById('leftT');
  var gorightT = document.getElementById('rightT');
  goleftT.onclick=function(){
    bannerT.scrollLeft=bannerT.scrollLeft-255
  }
  gorightT.onclick=function(){
    bannerT.scrollLeft=bannerT.scrollLeft+255
  }
}
import Student from './student.vue'
import Teacher from './teacher.vue'
import Course from './course.vue'
import Learning from './learning'

export default {
  name: 'home',
  data () {
    return {
      
    }
  },
  components: {
    Student,
    Teacher,
    Course,
    Learning
  },
  methods: {
    
  },
  created() {
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
.el-carousel__item h3 {
  color: #475669;
  font-size: 14px;
  opacity: 0.75;
  margin: 0;
}

.el-carousel__item:nth-child(2n) {
   background-color: #99a9bf;
}

.el-carousel__item:nth-child(2n+1) {
   background-color: #d3dce6;
}
</style>
