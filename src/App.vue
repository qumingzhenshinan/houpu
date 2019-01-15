<template>
  <div id="app">
    <router-view v-if="isRouterAlive" />
  </div>
</template>

<script>
export default {
  name: 'App',
  data() {
    return {
      isRouterAlive: true
    }
  },
  provide() {
    return {
      reload: this.reload
    }
  },
  created() {
    if(window.sessionStorage.getItem("user") === null) {
      this.$router.push('/start')
    }
  },
  methods: {
    reload() {
      this.isRouterAlive = false
      this.$nextTick(function() {
        this.isRouterAlive = true
      })
    }
  }
}
</script>

<style>
* {
  margin: 0;
  padding: 0;
  border: 0;
}

ul,li,ol {
  list-style: none;
}

a {
  text-decoration: none;
  color: #333;
}

.center {
  text-align: center;
}

.totalw {
  width: 1366px;
  margin: 0 auto;
}

.left {
  float: left;
}

.right {
  float: right;
}

.totalm {
  width: 1200px;
  margin: 0 auto;
}

.clearfix:after {
   content:""; 
   display: block; 
   clear:both; 
}

.coursePresent .el-card__body {
  padding: 0;
}

.mima .el-input__inner {
  padding-left: 35px;
}

.mima .el-form-item {
  margin-bottom: 18px;
}

.retrieve .el-step__head.is-success {
  color: #0099FF;
  border-color: #0099FF;
}

.retrieve .el-step__head.is-process {
  color: #c0c4cc;
  border-color: #c0c4cc;
}

.retrieve .el-step__title.is-process {
  color: #c0c4cc;
}

.retrieve .el-step__title.is-success {
  color: #0099ff;
}

.step .el-input__inner {
  padding-left: 35px;
  border-radius: 50px;
}

.quiztitle .el-input-group__append {
  background-color: #fff;
}
/* 分页特殊处理 */
.pagination .btn-prev{
  width: 70px;
  border: 1px solid #EEEEEE;
  border-radius: 4px;
  padding: 0;
  margin-right: 5px;
}

.pagination .btn-next {
  width: 70px;
  border: 1px solid #EEEEEE;
  border-radius: 4px;
  padding: 0;
  margin-left: 5px;
}

.pagination .number {
  border: 1px solid #EEEEEE;
  border-radius: 4px;
  margin: 0 5px;
}

.pagination .el-pager li.active+li {
  border: 1px solid #EEEEEE;
}

.pagination .el-pagination.is-background .btn-next, .el-pagination.is-background .btn-prev, .el-pagination.is-background .el-pager li {
  background: #fff;
}

.el-dialog__body {
  text-align: center;
  font-size: 16px;
  color: #333;
}

.el-dialog--center .el-dialog__body {
  text-align: center;
}
/* 评价星级 */
.el-rate__icon {
    font-size: 24px;
}
</style>
