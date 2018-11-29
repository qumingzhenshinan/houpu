<template>
  <div id="app">
    <router-view/>
  </div>
</template>

<script>
export default {
  name: 'App'
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


</style>
