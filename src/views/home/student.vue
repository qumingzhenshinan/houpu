<template>
  <div class="student">
    <div class="studentPresent totalm">
      <div class="studentTitle">
        优秀学员
      </div>
      <div class="banner">
        <div id="bannerT" class="bannerbox">
          <img id="leftT" @click="goleft" class="leftimg" src="@/assets/img/studentleft.png" alt="">
          <img id="rightT" @click="goright" class="rightimg" src="@/assets/img/studentright.png" alt="">
          <div :style="{width: studentW}" class="bannerdiv">
            <div class="bannerBU" @click="toDetail(item.pid)"  v-for="item in studentPresent">
              <img :src="base + item.pimgUrl" alt="">
              <p> {{item.pname}} </p>
              <p class="bannerP"> {{item.pintro}} </p>
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
  name: 'student',
  data () {
    return {
      studentW: 0,
      studentPresent: [
        {
          url: require('../../assets/img/touxiang2.png'),
          name: 'duck',
          present: '介绍介绍介绍介绍介绍介绍介绍介绍介绍介绍介绍介绍介绍介绍介绍介绍'
        },
        {
          url: require('../../assets/img/touxiang2.png'),
          name: 'ww',
          present: '介绍介绍介绍介绍介绍介绍介绍介绍介绍介绍介绍介绍介绍介绍介绍介绍'
        },
        {
          url: require('../../assets/img/touxiang2.png'),
          name: 'ss',
          present: '介绍介绍介绍介绍介绍介绍介绍介绍介绍介绍介绍介绍介绍介绍介绍介绍'
        },
        {
          url: require('../../assets/img/touxiang2.png'),
          name: 'ee',
          present: '介绍介绍介绍介绍介绍介绍介绍介绍介绍介绍介绍介绍介绍介绍介绍介绍'
        },
        {
          url: require('../../assets/img/touxiang2.png'),
          name: 'aa',
          present: '介绍介绍介绍介绍介绍介绍介绍介绍介绍介绍介绍介绍介绍介绍介绍介绍'
        },
        {
          url: require('../../assets/img/touxiang2.png'),
          name: 'ee',
          present: '介绍介绍介绍介绍介绍介绍介绍介绍介绍介绍介绍介绍介绍介绍介绍介绍'
        },
        {
          url: require('../../assets/img/touxiang2.png'),
          name: 'rr',
          present: '介绍介绍介绍介绍介绍介绍介绍介绍介绍介绍介绍介绍介绍介绍介绍介绍'
        }
      ],
      base: ''

    }
  },
  created() {
    api.homeStudents().then(data => {
      this.studentPresent = data.trophy
      this.studentW = 255 * this.studentPresent.length + 'px'
    })
    this.base = Base
  },
  methods: {
    goleft() {
      document.getElementById('bannerT').scrollLeft -= 255
    },
    goright() {
      document.getElementById('bannerT').scrollLeft += 255
    },
    toDetail(id) {
      this.$router.push(`/detail/student/${id}`)
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
.studentTitle {
  color: #000;
  text-align: center;
  font-size: 24px;
}

.studentTitle::after {
  content: "—————";
  padding: 0 20px;
  opacity: 0.3;
}

.studentTitle::before {
  content: "—————";
  padding: 0 20px;
  opacity: 0.3;
}

.studentPresent {
  margin-top: 45px;
}

.banner {
  width: 100%;
  position: relative;
}

.bannerbox {
  overflow-x: scroll;
  width: 1020px;
  height: 211px;
  margin: 0 auto;
  margin-top: 50px;
  box-sizing: border-box;
}

.bannerbox::-webkit-scrollbar{
  width: 0;
  height: 0;
}

.bannerdiv {
  width: 2000px;
  height: 210px;
}

.bannerBU {
  margin: 5px 15px;
  width: 225px;
  height: 200px;
  border-radius: 12px;
  box-shadow: 0 0 6px 0 rgba(136,136,136,0.20);
  background: #fff;
  float: left;
  text-align: center;
  overflow: hidden;
  padding: 10px;
  box-sizing: border-box;
  cursor: pointer;
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
  -webkit-line-clamp: 3;
  -webkit-box-orient: vertical;
}

.leftimg {
  position: absolute;
  top: 75px;
  left: 40px;
  cursor: pointer;
}

.rightimg {
  position: absolute;
  top: 75px;
  right: 40px;
  cursor: pointer;
}

</style>
