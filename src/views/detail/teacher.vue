<template>
	<div id="student" class="totalw">
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
					<header class="leftH">
						<img :src="base + teacher.timgUrl" alt="">
						<p>{{teacher.tname}}</p>
						<p> {{teacher.subject}} </p>
					</header>
					<footer class="leftF">
						<div class="Tabstract">
							<div class="title">
								<span></span>
								老师简介
							</div>
							<span v-html="teacher.tintro"></span>
						</div>
					</footer>
				</div>
				<div class="Tright">
					<div v-for="item in course" class="trightbox">
						<img :src="base + item.gvimg" alt="">
						<p>{{item.gname}}</p>
	          <p> {{item.gcreatTime.substr(0,16)}}  <span>￥{{item.gmoney}}</span> </p>
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
			base: '',
			teacher: {},
			course: []
		}
	},
	components: {
		Header,
		Footer
	},
	created() {
		this.base = Base
		api.findTeacher({tid: this.$route.params.id}).then(data => {
			this.teacher = data
		})
		api.homeCourse().then(data => {
			this.course = data.generalvideos.splice(0,8)
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

.leftH {
	width: 100%;
	height: 230px;
	text-align: center;
	padding: 20px;
	box-sizing: border-box;
	color: #fff;
	background: url('../../assets/img/detail/bitmaps.png') no-repeat 34%;
}

.leftH img {
	width: 100px;
	height: 100px;
	border-radius: 50px;
}

.leftH p:nth-child(2) {
	font-size: 16px;
	margin: 15px 0;
}

.leftH p:nth-child(3) {
	font-size: 14px;
	opacity: 0.6;
}

.leftF {
	height: 185px;
	box-sizing: border-box;
	background: #f7f7f7;
	padding: 20px;
	margin-top: 15px;
}

.Tabstract {
	overflow: hidden;
  text-overflow: ellipsis;
  display: -webkit-box;
  -webkit-line-clamp: 5;
  -webkit-box-orient: vertical;
}

.Tabstract .title {
	color: #000;
	font-size: 16px;
	margin-bottom: 10px;
	height: 20px;
	line-height: 20px;
}

.Tabstract .title span {
	float: left;
	height: 20px;
	width: 3px;
	background: #09f;
	margin-right: 15px;
}

.Tright {
	float: left;
	margin-left: 15px;
	width: 900px;
}

.trightbox {
	background: #FFFFFF;
	box-shadow: 0 5px 8px 0 rgba(0,0,0,0.08);
	border-radius: 4px;
	width: 210px;
	height: 185px;
	margin: 0 0 15px 10px;
	float: left;
	color: rgba(0, 0, 0, 0.8);
}

.trightbox img {
	width: 100%;
}

.trightbox p {
	padding: 0 10px;
}

.trightbox p:nth-child(2) {
	font-size: 16px;
	padding: 6px 10px;
}

.trightbox p:nth-child(3) {
	font-size: 14px;
}

.trightbox p:nth-child(3) span {
  color: orange;
  float: right;
}

</style>