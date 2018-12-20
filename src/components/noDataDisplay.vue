<template>
  <div class="noData">
    <div class="center nodata" v-if="!inforData || inforData.length === 0">
      {{tips}}
    </div>
  </div>
</template>

<script>
export default {
  name: 'noData',
  data () {
    return {
    }
  },
  props: ['inforData', 'tips']
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
.nodata {
  color: #999;
  font-size: 24px;
  padding: 30px 0;
}
</style>
