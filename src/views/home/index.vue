<template>
  <div class="home">
    <Header></Header>
    <div class="totalw">
      <div class="block">
        <el-carousel height="300px">
          <el-carousel-item v-for="(item,index) in banners" :key="index">
            <img style="width: 100%;height: 100%;" :src="base + item.atUrl" alt="">
          </el-carousel-item>
        </el-carousel>
      </div>
      <Course></Course>
      <Teacher></Teacher>
      <Student></Student>
      <Learning></Learning>
      <Footer></Footer>
    </div>
  </div>
</template>

<script>
import Student from './student.vue'
import Teacher from './teacher.vue'
import Course from './course.vue'
import Learning from './learning'
import Header from '@/components/Header'
import Footer from '@/components/Footer'
import api from "@/api"
import Base from '@/baseimg'

export default {
  name: 'home',
  data () {
    return {
      banners: [],
      base: ''
    }
  },
  components: {
    Student,
    Teacher,
    Course,
    Learning,
    Header,
    Footer
  },
  methods: {
    
  },
  created() {
    this.base = Base
    api.homeLoop().then(data => {
      this.banners = data.articleImg
    })
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
