<template>
  <div class="pagination">
    <el-pagination
      background
      prev-text="上一页"
      next-text="下一页"
      layout="prev, pager, next"
      :page-size='leng'
      :total="message.length">
    </el-pagination>
  </div>
</template>

<script>
export default {
  name: 'pagination',
  data () {
    return {
      msg: 'Welcome to Your Vue.js App'
    }
  },
  props: {
    message: Array,
    leng: Number,
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>

</style>
