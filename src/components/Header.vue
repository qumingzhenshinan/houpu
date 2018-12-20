<template>
	<div class="header">
		<div class="top">
			<div class="logo">
				<img src="../assets/img/logo.png" alt="">
			</div>
			<div class="search">
				<input type="text" name="" value="" placeholder="请输入课程名称或者教师姓名"><el-button type="primary" icon="el-icon-search"></el-button>
			</div>
			<div class="phone">
				<p>客服电话：<span>400-898-9991</span></p>
				<span class="telTime">(周一至周日 09:00-20:00)</span>
			</div>
		</div>
		<div class="headerTitleOut">
			<ul class="totalm">
				<li class="allClass">
					<p class="allClassP">全部分类</p>
					<ul class="crouseType">
						<li>
						<p>语文</p>
						<div class="grade">
                            <div class="selectGrade">一年级</div>
                            <div class="chooseCourse">
                                <a href="">常规课</a>
                                <a href="">竞赛课</a>
                                <a href="">字少</a>
                                <a href="">竞赛课</a>
                                <a href="">常规课</a>
                                <a href="">竞赛课</a>
                                <a href="">常规课</a>
                            </div>
                            <div class="selectGrade">二年级</div>
                            <div class="chooseCourse">
                                <a href="">常规课</a>
                                <a href="">竞赛课</a>
                            </div>
                            <div class="selectGrade">三年级</div>
                            <div class="chooseCourse">
                                <a href="">常规课</a>
                                <a href="">竞赛课</a>
                            </div>
                        </div>
						</li>
						<li>
							<p>英语</p>
							<div class="grade">
                                <div class="selectGrade">一年级</div>
                                <div class="chooseCourse">
                                    <a href="">常规课1</a>
                                    <a href="">竞赛课</a>
                                    <a href="">字少</a>
                                    <a href="">竞赛课</a>
                                    <a href="">常规课</a>
                                    <a href="">竞赛课</a>
                                    <a href="">常规课</a>
                                </div>
                                <div class="selectGrade">二年级</div>
                                <div class="chooseCourse">
                                    <a href="">常规课</a>
                                    <a href="">竞赛课</a>
                                </div>
                                <div class="selectGrade">三年级</div>
                                <div class="chooseCourse">
                                    <a href="">常规课</a>
                                    <a href="">竞赛课</a>
                                </div>
                            </div>
						</li>
						<li>
							<p>数学</p>
							<div class="grade">
                                <div class="selectGrade">一年级</div>
                                <div class="chooseCourse">
                                    <a href="">常规课2</a>
                                    <a href="">竞赛课</a>
                                    <a href="">字少</a>
                                    <a href="">竞赛课</a>
                                    <a href="">常规课</a>
                                    <a href="">竞赛课</a>
                                    <a href="">常规课</a>
                                </div>
                                <div class="selectGrade">二年级</div>
                                <div class="chooseCourse">
                                    <a href="">常规课</a>
                                    <a href="">竞赛课</a>
                                </div>
                                <div class="selectGrade">三年级</div>
                                <div class="chooseCourse">
                                    <a href="">常规课</a>
                                    <a href="">竞赛课</a>
                                </div>
                            </div>
						</li>
						<li>
							<p>物理</p>
							<div class="grade">
                                <div class="selectGrade">一年级</div>
                                <div class="chooseCourse">
                                    <a href="">常规课3</a>
                                    <a href="">竞赛课</a>
                                    <a href="">字少</a>
                                    <a href="">竞赛课</a>
                                    <a href="">常规课</a>
                                    <a href="">竞赛课</a>
                                    <a href="">常规课</a>
                                </div>
                                <div class="selectGrade">二年级</div>
                                <div class="chooseCourse">
                                    <a href="">常规课</a>
                                    <a href="">竞赛课</a>
                                </div>
                                <div class="selectGrade">三年级</div>
                                <div class="chooseCourse">
                                    <a href="">常规课</a>
                                    <a href="">竞赛课</a>
                                </div>
                            </div>
						</li>
						<li>
							<p>化学</p>
							<div class="grade">
                                <div class="selectGrade">一年级</div>
                                <div class="chooseCourse">
                                    <a href="">常规课4</a>
                                    <a href="">竞赛课</a>
                                    <a href="">字少</a>
                                    <a href="">竞赛课</a>
                                    <a href="">常规课</a>
                                    <a href="">竞赛课</a>
                                    <a href="">常规课</a>
                                </div>
                                <div class="selectGrade">二年级</div>
                                <div class="chooseCourse">
                                    <a href="">常规课</a>
                                    <a href="">竞赛课</a>
                                </div>
                                <div class="selectGrade">三年级</div>
                                <div class="chooseCourse">
                                    <a href="">常规课</a>
                                    <a href="">竞赛课</a>
                                </div>
                            </div>
						</li>
					</ul>
				</li>
				<li class="headerHight" @click="zeroCourse"><p>0元课程 <span></span></p></li>
				<li class="headerHight" @click="newCourse"><p>最新课程 <span></span></p></li>
				<li class="headerHight"><p><router-link :to="{ path: '/quiz' }">小测验</router-link> <span></span></p></li>
				<li class="headerHight"><p>我的课程 <span></span></p></li>
				<li class="user" @click="Personal"><img src="../assets/Header/userImg.png" alt=""><span>张三</span></li>
			</ul>
		</div>
	</div>
</template>
<script type="text/javascript">
export default{
	data(){
		return {
			aa:["123","123"]
		}
	},
	methods: {
		Personal(){
			this.$router.push({name:'personalCenter'})
		},
		zeroCourse(){
			this.$router.push({name:'zerocourse'})
		},
		newCourse(){
			this.$router.push({name:'newcourse'})
		}
	}
}
</script>
<style scoped>
.header{
	width: 1366px;
	margin: 0 auto;
}
.top{
	width: 1200px;
	height: 80px;
	margin: 0 auto;
}
.logo,.search,.phone{
	float: left;
	height: 80px;
}
.logo img{
	width: 147px;
	height: 80px;
}
.search input{
	width: 400px;
	height: 40px;
	border: 1px solid #cfcfcf;
	border-right: 0;
	padding-left: 12px;
	margin-top: 20px;
	margin-left: 172px;
}
.search .el-button{
	border-radius: 0;
	height: 42px;
}
.phone{
	position: relative;
}
.phone p{
	height: 33px;
	margin-left: 132px;
	margin-top: 26px;
	background: url('../assets/Header/phone.png') no-repeat 2px 12px;
	padding-left: 30px;
}
.phone p span{
	font-family: MicrosoftYaHei-Bold;
	font-size: 25px;
	color: #F5A623;
}
.telTime{
	position: absolute;
	right: 3px;
	bottom: 0px;
	font-family: MicrosoftYaHei;
	font-size: 12px;
	color: #9e9e9e;
	line-height: 15px;
}
.headerTitleOut{
	width: 1366px;
	height: 50px;
	background: #0099ff;
	margin-top: 10px;
	box-shadow: 0px 1px 1px #fff;
}
.headerHight p{
	position: relative;
}
.headerHight p:hover span{
	display: block;
}
.headerHight p span{
	display: none;
	position: absolute;
	bottom: 5px;
	left: 89px;
	width: 20px;
	height: 3px;
	background: #FFFFFF;
	border-radius: 3.5px;
}
.headerHight p a {
	color: #fff;
}
.headerHight p:hover{
}
.headerTitleOut li{
	text-align: center;
	line-height: 50px;
	float: left;
	color: #fff;
	font-family: MicrosoftYaHeiUI;
	font-size: 18px;
	width: 196px;
	height: 50px;
	cursor:pointer;
}
.headerTitleOut .allClass{
	width: 150px;
	background-color: #0f68cb;
	padding-left: 30px;
	position: relative;
	
}
.allClassP{
	padding-left: 0px;
	background: url('../assets/Header/allClass.png') no-repeat 0px 20px;
}
.allClass{
	position: relative;
}
.allClass:hover .crouseType{
	display: block;
}
.crouseType{
	display: none;
	position: absolute;
	left: 0px;
	text-align: center;
	z-index: 9999;
}
.crouseType p{
	height: 59px;
	margin-left: 15px;
	width: 150px;
	border-bottom: 1px solid #40474e;
}
.crouseType li{
	width: 180px;
	height: 60px;
	background: #2B333B;
}
.crouseType li:hover{
	background: #1D242C;
	color: #0099FF;
}
.crouseType li:hover p{
	border: 0;
}
.user{
	position: relative;
}
.user span{
	margin-left: 10px;
	float: right;
}
.user img{
	width: 30px;
	height: 30px;
	margin-left: 3px;
	position: absolute;
	top: 10px;
	left: 120px;
}
.selectGrade{
    text-align: left;
    margin-left: 26px;
    height: 40px;
}
.grade{
    width: 460px;
    height: 300px;
    position: absolute;
    bottom: 0px;
    left: 150px;
    margin-left: 26px;
    color: #0099FF;
    display: none;
    background-color: #FFFFFF;
    z-index: 9999;
}
.chooseCourse{
    margin-top: 10px;
    line-height: 30px;
    text-align: left;
}
.chooseCourse a{
    display: inline-block;
    margin-left: 26px;
    font-size: 17px;
    color: #2D3339;
}
.crouseType li:hover .grade{
    display: block;
}
</style>