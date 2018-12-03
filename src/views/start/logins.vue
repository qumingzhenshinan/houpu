<template>
  <div class="start">
    <div class="mima">
      <img src="@/assets/img/computer.png" @click="tologinm" class="rightImg" alt="">
      <div class="code">
        密码登录
      </div>
      <div class="title">
        扫码登录
      </div>
      <div class="qscode">
        <div>
          <img src="@/assets/img/scode.png" alt="">
          <p style="margin-top:8px;">已扫描，正在登录···</p>
        </div>
        <div class="qscodeb" v-show="false">
          <i class="el-icon-loading"></i>
        </div>
        <div class="success" v-show="false">
          <img src="@/assets/img/successl.png" alt="">
          <p style="margin-top:58px;">登录成功</p>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: 'start',
  data () {
    return {
      
    }
  },
  methods: {
    tologinm() {
      this.$emit('gologinm')
    }
  },
  created() {
  },
  mounted() {
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
.mima {
  width: 100%;
  padding: 10px 15px;
  position: relative;
  box-sizing: border-box;
}

.code {
  width: 80px;
  height: 30px;
  background: url('../../assets/img/jiesB.png') no-repeat;
  background-size: 100%;
  text-align: center;
  line-height: 25px;
  font-size: 14px;
  color: #F5A623;
  position: absolute;
  top: 10px;
  right: 45px;
}

.rightImg {
  width: 43px;
  height: 43px;
  position: absolute;
  top: 0;
  right: 0;
  cursor: pointer;
}

.title {
  font-size: 16px;
  line-height: 26px;
  color: #2D3339;
}

.qscode {
  text-align: center;
  font-size: 16px;
  margin-top: 40px;
  position: relative;
}

.qscode img {
  width: 165px;
}

.qscodeb {
  width: 165px;
  height: 165px;
  font-size: 38px;
  line-height: 165px;
  position: absolute;
  top: 0;
  left: 59px;
  color: #fff;
  background: #000;
  opacity: 0.3;
}

.success {
  position: absolute;
  top: 47px;
  left: 106px;
  width: 67px;
  height: 67px;
  background: #fff;
  border-radius: 40px;
}

.success img {
  width: 67px;
}
</style>
