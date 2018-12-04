<template>
	<div class="student totalw">
		<Header></Header>
		<div class="totalm">
			<div style="margin: 25px 0">
				<el-breadcrumb separator-class="el-icon-arrow-right">
				  <el-breadcrumb-item :to="{ path: '/' }">首页</el-breadcrumb-item>
				  <el-breadcrumb-item >教师列表</el-breadcrumb-item>
				  <el-breadcrumb-item >教师详情</el-breadcrumb-item>
				</el-breadcrumb>
			</div>
			<div class="main">
				<div class="Tleft">
				
				</div>
				<div class="Tright">
					
				</div>
			</div>
		</div>
		<Footer></Footer>
	</div>
</template>
<script>
import Header from '@/components/Header.vue'
import Footer from '@/components/Footer.vue'
export default {
	name: 'student',
	data() {
		return {

		}
	},
	components: {
		Header,
		Footer
	}
}
</script>
<style scoped>
.main {
	width: 100%;
	height: 400px;
}

.Tleft {
	float: left;
	width: 265px;
}


</style>