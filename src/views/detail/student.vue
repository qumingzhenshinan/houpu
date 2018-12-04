<template>
	<div class="student totalw">
		<Header></Header>
		<div class="totalm">
			<div style="margin: 25px 0">
				<el-breadcrumb separator-class="el-icon-arrow-right">
				  <el-breadcrumb-item :to="{ path: '/' }">首页</el-breadcrumb-item>
				  <el-breadcrumb-item >学生列表</el-breadcrumb-item>
				  <el-breadcrumb-item >学生详情</el-breadcrumb-item>
				</el-breadcrumb>
			</div>
			<div class="main">
				<div class="Tleft">
					<div class="leftH">
						<img :src="base + student.pimgUrl" alt="">
						<p> {{student.pname}} </p>
					</div>
				</div>
				<div class="Tright">
					<div class="title">
						<span></span>
						学生简介
					</div>
					<div style="margin-bottom:15px;" v-html="student.pintro">
						
					</div>
					<div class="title">
						<span></span>
						学院风采
					</div>
					<div>
						<img class="studImg" v-for="item in studImg" :src="base + item.stUrl" alt="">
					</div>
				</div>
			</div>
		</div>
		<Footer></Footer>
	</div>
</template>
<script>
import Header from '@/components/Header.vue'
import Footer from '@/components/Footer.vue'
import api from '@/api'
import Base from '@/baseimg'

export default {
	name: 'student',
	data() {
		return {
			student: {},
			base: '',
			studImg: []
		}
	},
	components: {
		Header,
		Footer
	},
	created() {
		this.base = Base
		api.findStudent({pid: this.$route.params.id}).then(data => {
			this.student = data
		})
		api.findstuimg({pid: this.$route.params.id}).then(data => {
			console.log(data);
			this.studImg = data.stuImg
		})
	}
}
</script>
<style scoped>
.main {
	width: 100%;
	height: 450px;
}

.Tleft {
	float: left;
	width: 265px;
}

.Tright {
	float: left;
	margin-left: 15px;
	width: 900px;
}

.leftH {
	width: 100%;
	height: 230px;
	text-align: center;
	padding: 20px;
	box-sizing: border-box;
	color: #fff;
	background: url('../../assets/img/detail/Bitmap.png') no-repeat;
}

.leftH img {
	width: 100px;
	height: 100px;
	border-radius: 50px;
}

.leftH p {
	font-size: 16px;
	margin-top: 20px;
}

.Tright .title {
	color: #000;
	font-size: 16px;
	margin-bottom: 10px;
	height: 20px;
	padding-bottom: 6px;
	line-height: 20px;
	border-bottom: 1px solid #DADADA;
}

.Tright .title span {
	float: left;
	height: 20px;
	width: 3px;
	background: #09f;
	margin-right: 15px;
}

.studImg {
	width: 250px;
	height: 150px;
	margin-right: 20px;
}
</style>