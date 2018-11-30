<template>
  <div class="teacher">
    <div class="teacherPresent totalm">
      <div class="title">
        名师介绍
      </div>
      <img id="leftimg" class="teacherLeft" src="@/assets/img/teacherleft.png" alt="">
      <img id="rightimg" class="teacherRight" src="@/assets/img/teacherright.png" alt="">
      <div class="banner totalm">
        <div id="bannerb" class="bannerbox">
          <div :style="{width: teacherW, height: teacherH + 'px'}">
            <div class="bannerBU" v-for="item in teacherPresent">
              <img :src="base + item.timgUrl" alt="">
              <p> {{item.tname}} </p>
              <p class="bannerP" v-html="item.tintro">
              </p>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import api from '@/api'
import Base from '@/baseimg'
export default {
  name: 'teacher',
  data () {
    return {
      teacherPresent: [
        {
          url: require('../../assets/img/touxiang.png'),
          name: '李丽丽',
          present: '介绍介绍介绍介绍介绍介绍介绍介绍介绍介绍介绍介绍介绍介绍介绍介绍介绍介绍介绍介绍介绍介绍介绍介绍介绍介绍介绍介绍介绍介绍介绍介绍介绍介绍'
        },
        {
          url: require('../../assets/img/touxiang.png'),
          name: '张三',
          present: '介绍介绍介绍介绍介绍介绍介绍介绍介绍介绍介绍介绍介绍介绍介绍介绍介绍介绍介绍介绍介绍介绍介绍介绍介绍介绍介绍介绍介绍介绍介绍介绍介绍介绍' 
        },
        {
          url: require('../../assets/img/touxiang.png'),
          name: 'jeck',
          present: '介绍介绍介绍介绍介绍介绍介绍介绍介绍介绍介绍介绍介绍介绍介绍介绍介绍介绍介绍介绍介绍介绍介绍介绍介绍介绍介绍介绍介绍介绍介绍介绍介绍介绍' 
        },
        {
          url: require('../../assets/img/touxiang.png'),
          name: 'tom',
          present: '介绍介绍介绍介绍介绍介绍介绍介绍介绍介绍介绍介绍介绍介绍介绍介绍介绍介绍介绍介绍介绍介绍介绍介绍介绍介绍介绍介绍介绍介绍介绍介绍介绍介绍' 
        },
        {
          url: require('../../assets/img/touxiang.png'),
          name: 'jerry',
          present: '介绍介绍介绍介绍介绍介绍介绍介绍介绍介绍介绍介绍介绍介绍介绍介绍介绍介绍介绍介绍介绍介绍介绍介绍介绍介绍介绍介绍介绍介绍介绍介绍介绍介绍' 
        }
      ],
      teacherW: 0,
      teacherH: 290,
      base: ''
    }
  },
  created() {
    api.homeTeachers().then(data => {
      this.teacherPresent = data.teacher
      this.teacherW = 312 * this.teacherPresent.length + 'px'
    })
    
    this.base = Base
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
.teacherPresent {
  background: url('../../assets/img/homeTeacherB.png');
  width: 100%;
  height: 470px;
  margin-top: 45px;
  text-align: center;
  position: relative;
}

.teacherLeft {
  position: absolute;
  left: 160px;
  top: 245px;
  cursor: pointer;
}

.teacherRight {
  position: absolute;
  right: 160px;
  top: 245px;
  cursor: pointer;
}

.teacherPresent .title {
  font-size: 24px;
  color: #fff;
  padding-top: 30px;
  font-family: MicrosoftYaHei;
}

.teacherPresent .title::after {
  content: "—————";
  padding: 0 20px;
  opacity: 0.3;
}

.teacherPresent .title::before {
  content: "—————";
  padding: 0 20px;
  opacity: 0.3;
}

.banner {
  margin-top: 72px;
  height: 290px;
  box-sizing: border-box;
  padding-left: 170px;
}

.bannerbox {
  width: 936px;
  overflow-x: scroll;
  height: 292px;
}

.bannerbox::-webkit-scrollbar{
  width: 0;
  height: 0;
}

.bannerBU {
  float: left;
  width: 234px;
  margin-right: 78px;
  height: 290px;
  background-color: #fff;
  border-radius: 12px;
  padding: 15px;
  box-shadow: 0 5px 8px 0 rgba(0,0,0,0.08);
  box-sizing: border-box;
  overflow: hidden;
}

.bannerBU img {
  width: 100px;
  height: 100px;
  border-radius: 50px;
}

.bannerP {
  overflow: hidden;
  text-overflow: ellipsis;
  display: -webkit-box;
  -webkit-line-clamp: 5;
  -webkit-box-orient: vertical;
}

</style>
