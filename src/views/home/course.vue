<template>
  <div class="course">
    <div class="coursePresent totalm">
      <el-card class="box-card left" v-for="(item,index) in coursePresent"  :key="index">
        <div @click="goDetail(item)">
          <img :src="base + item.gvimg" alt="">
          <p class="bannerP">{{item.gname}}</p>
          <p>主讲人： {{item.gsbuject}}  <span>￥{{item.gmoney}}</span> </p>
        </div>
      </el-card>
    </div>
  </div>
</template>

<script> 
import api from '@/api'
import base from '@/baseimg'
export default {
  name: 'course',
  data () {
    return {
      coursePresent: [
        {
          url: require('@/assets/img/caption.png'),
          title: '高考化学复习',
          speaker: '李梅梅',
          cost: '300'
        },{
          url: require('@/assets/img/caption.png'),
          title: '高考化学复习',
          speaker: '李梅梅',
          cost: '300'
        },{
          url: require('@/assets/img/caption.png'),
          title: '高考化学复习',
          speaker: '李梅梅',
          cost: '300'
        },{
          url: require('@/assets/img/caption.png'),
          title: '高考化学复习',
          speaker: '李梅梅',
          cost: '300'
        },{
          url: require('@/assets/img/caption.png'),
          title: '高考化学复习',
          speaker: '李梅梅',
          cost: '300'
        },{
          url: require('@/assets/img/caption.png'),
          title: '高考化学复习',
          speaker: '李梅梅',
          cost: '300'
        },{
          url: require('@/assets/img/caption.png'),
          title: '高考化学复习',
          speaker: '李梅梅',
          cost: '300'
        },{
          url: require('@/assets/img/caption.png'),
          title: '高考化学复习',
          speaker: '李梅梅',
          cost: '300'
        },{
          url: require('@/assets/img/caption.png'),
          title: '高考化学复习',
          speaker: '李梅梅',
          cost: '300'
        },{
          url: require('@/assets/img/caption.png'),
          title: '高考化学复习',
          speaker: '李梅梅',
          cost: '300'
        }
      ],
      base: ''
    }
  },
  created() {
    api.newAllC().then(data => {
      this.coursePresent = data.generalvideos.splice(0,10)
    })
    this.base = base
  },
  methods: {
    goDetail(data) {
      console.log(data);
      this.$router.push(`/courseDetail/${data.gid}`)
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
.coursePresent {
  margin-top: 45px;
  height: 400px;
}

.coursePresent>.el-card {
  width: 19%;
  margin: 0 10px 15px 0;
}

.coursePresent>.el-card img {
  width: 100%;
  height: 127px;
}

.coursePresent>.el-card p {
  padding: 5px 10px;
}

.coursePresent>.el-card p span {
  color: orange;
  float: right;
}

.bannerP {
  overflow: hidden;
  white-space: nowrap;
  text-overflow:ellipsis;
}
</style>
