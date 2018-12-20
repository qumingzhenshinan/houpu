<template>
	<div id="quiz" class="totalw">
		<Header></Header>
		<div class="totalm">
			<div class="quiztitle">
				<el-input size="mini" placeholder="请输入试卷名称、科目" v-model="quizConent">
					<el-button slot="append" icon="el-icon-search"></el-button>
				</el-input>
			</div>
			<div class="quizmain">
				<div class="quizBU" v-for="item in quizs.slice((page-1)*Mpage,page*Mpage)">
					<div>
						<span> {{item.etsubject}} </span>
						<p> {{item.etname}} </p>
					</div>
					<div class="start" @click="goPaper(item)">
						开始测验>
					</div>
					<p>
						试卷时长：{{item.timeLength}}
					</p>
					<p>
						试卷介绍：{{item.content}}
					</p>
				</div>
			</div>
			<div class="center">
				<div class="pagination">
					<el-pagination background prev-text="上一页" next-text="下一页" layout="prev, pager, next" :current-page="page" @current-change="currentChange" :page-size='Mpage' @prev-click="prevPage" @next-click="nextPage" :total="quizs.length">
			    </el-pagination>
				</div>
			</div>
		</div>
		<Footer></Footer>
	</div>
</template>
<script>
import Header from '@/components/Header'
import Footer from '@/components/Footer'
import { mapActions } from 'vuex'
import api from "@/api"
export default {
	name: 'quiz',
	data() {
		return {
			quizConent: '',
			quizs: [
				{
					title: '语文类三年级小测试1',
					subject: '语文',
					timeLenght: '90分钟',
					intro: '试卷介绍试卷介绍试卷介绍试卷介绍试卷介绍试卷介绍试卷介绍试卷介绍'
				},
				{
					title: '语文类三年级小测试2',
					subject: '语文',
					timeLenght: '90分钟',
					intro: '试卷介绍试卷介绍试卷介绍试卷介绍试卷介绍试卷介绍试卷介绍试卷介绍'
				},{
					title: '语文类三年级小测试3',
					subject: '语文',
					timeLenght: '90分钟',
					intro: '试卷介绍试卷介绍试卷介绍试卷介绍试卷介绍试卷介绍试卷介绍试卷介绍'
				},{
					title: '语文类三年级小测试4',
					subject: '语文',
					timeLenght: '90分钟',
					intro: '试卷介绍试卷介绍试卷介绍试卷介绍试卷介绍试卷介绍试卷介绍试卷介绍'
				},{
					title: '语文类三年级小测试5',
					subject: '语文',
					timeLenght: '90分钟',
					intro: '试卷介绍试卷介绍试卷介绍试卷介绍试卷介绍试卷介绍试卷介绍试卷介绍'
				}
			],
			Mpage: 5,
			page: 1
		}
	},
	components: {
		Header,
		Footer,
	},
	created() {
		api.findExamAll().then(data => {
			this.quizs = data.exams
		})
	},
	methods: {
		...mapActions(['GetQuiz']),
		currentChange(data) {
			this.page = data
		},
		prevPage() {
			this.page--
		},
		nextPage() {
			this.page++
		},
		goPaper(data) {
			this.GetQuiz(data)
			this.$router.push('/quiz/testPaper')
		}
	}
}
</script>
<style scoped>
.quiztitle {
	margin: 25px 20px;
	width: 300px;
}

.quizmain {
	margin: 0 20px;
	width: 1130px;
}

.quizBU {
	border: 1px solid #E5EAF3;
	margin-bottom: 10px;
	padding: 15px;
}

.quizBU>div {
	height: 30px;
}

.quizBU>p {
	height: 30px;
	line-height: 30px;
  overflow: hidden;
  text-overflow: ellipsis;
  display: -webkit-box;
  -webkit-line-clamp: 1;
  -webkit-box-orient: vertical;
}

.quizBU>div>span {
	float: left;
	background: #8DCB8E;
	color: #fff;
	width: 55px;
	height: 26px;
	line-height: 26px;
	text-align: center;
	margin-right: 10px;
}

.quizBU>div>p {
	font-size: 18px;
	color: #000;
	font-weight: 700;
}

.start {
	float: right;
	width: 130px;
	height: 42px !important;
	background: #09f;
	color: #fff;
	text-align: center;
	line-height: 42px;
	cursor: pointer;
}
</style>