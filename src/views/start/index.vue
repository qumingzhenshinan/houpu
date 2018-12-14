<template>
  <div class="start">
    <div class="totalw">
      <div class="totalm">
        <img style="margin: 10px 0;" src="@/assets/img/logo.png" alt="">
      </div>
      <div class="main">
        <div class="mainbox">
          <Loginm v-show="booleans.loginm" @tologins='gologins' @toR="goRegister"></Loginm>
          <Logins v-show="booleans.logins" @gologinm="gologinm"></Logins>
          <Register @tologin="gologin" v-show="booleans.register"></Register>
        </div>
      </div>
      <footer class="footer">
        Copyright © 2018 厚朴教育 All Rights Reserved 京ICP备12028606号-22
      </footer>
    </div>
  </div>
</template>

<script>
import Loginm from './loginm.vue'
import Logins from './logins.vue'
import Register from './register.vue'

export default {
  name: 'start',
  data() {
    return {
      booleans: {
        loginm: true,
        logins: false,
        register: false,
      }
    }
  },
  components: {
    Loginm,
    Logins,
    Register,
  },
  methods: {
    gologins() {
      this.booleans.loginm = false
      this.booleans.register = false
      this.booleans.logins = true
    },
    goRegister() {
      this.booleans.register = true
      this.booleans.logins = false
      this.booleans.loginm = false
    },
    gologin() {
      this.booleans.loginm = true
      this.booleans.register = false
      this.booleans.logins = false
    },
    gologinm() {
      this.booleans.loginm = true
      this.booleans.register = false
      this.booleans.logins = false
    }
  },
  created() {
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
.main {
  background: url("../../assets/img/startB.png") -30px;
  width: 100%;
  height: 450px;
  position: relative;
}

.mainbox {
  width: 310px;
  background-color: #fff;
  padding: 5px;
  position: absolute;
  top: 55px;
  right: 135px;
}

.footer {
  font-size: 14px;
  margin: 15px 0 40px;
  color: #2D3339;
  text-align: center;
  opacity: 0.5;
}

.retrieve {
  width: 1000px;
  height: 490px;
  margin: 0 auto;
  box-shadow: 0 0 6px 0 rgba(136,136,136,0.20);
  border-radius: 2px;
  padding: 20px;
  box-sizing: border-box;
}
</style>
