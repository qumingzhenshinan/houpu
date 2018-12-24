const BASE = 'http://www.houpuclass.com:8089'   //接口网址
const BASE1 = 'http://192.168.137.143:8089'   // 测试网址

const urls = {
	students: BASE + '/trophy/select',//get获取所有学员
	teachers: BASE + '/teacher/select',// get获取老师列表
	course: BASE + '/course/select',//get获取所有课程
	getrecommendedC: BASE + '/course/recommend', // post 获取推荐课程
	findCourse: BASE + '/course/selectByKind', // post三级查询获取课程
	loop:BASE + '/article/select',//get轮播图
	findteacher: BASE + '/teacher/selectById',//post根据id获取老师详情
	findstudent: BASE +'/trophy/selectById',//post根据id获取学生详情
	findstuimg: BASE + '/stuimg/selectByProthyId',//post通过关联学员id获取学员证书图片
	killendtime: BASE + '/course/selectKillEndTime',//get限时促销
	zerocourse: BASE + '/course/selectByMoney',//post 0元体验列表
	allZeroC: BASE + '/course/selectAllByMoney', // get 获取所有0元课程
	allorder: BASE + '/orders/selectAll', //get查询所有订单
	coursecatalogue: BASE + '/videochild/select', // post获取课程目录
	coursecomment: BASE + '/comment/selectByGid', // post获取课程评论
	coursedetails: BASE + '/course/selectById', // post获取课程详情
	getmycoupon:  BASE + '/coupon/selectByUid', // post获取优惠卷
	detailusername:  BASE + '/user/updateUserName', // post修改用户昵称
	// 试卷 exam
	findExamAll: BASE + '/exam/selectAll', // gett获取所有试卷
	findExamOnly: BASE + '/questions/select', // post获取某一套试卷的所有题目
	subjectquery: BASE + '/course/selectByKind', // post课程三级分类查询
	getphonenum:  BASE + '/message/ycode', // post获取手机验证码	
	newcourse: BASE + '/course/selectByCreatTime', // post 时间排序最新课程
	newAllC: BASE + '/course/selectAllByCreatTime',  // get  获取所有最新课程
	examhistoy: BASE + '/exam/selectExamHistoy', // post查询我做过的题目
	changepassword:  BASE + '/user/updatePassWord', // post用户修改密码
	oederdetail: BASE + '/orders/update', // post修改订单状态
	updataimg:  BASE + '/user/profiles',// post修改用户头像
	// todos: 'http://www.houpuclass.com:8089/teacher/select'
	getAnswer: BASE + '/exam/selectAnswer', // post分数统计并添加错题
	findPAnswer: BASE + '/errorquestions/selectByUid', // 查询答题结果
	// 注册
	getPhoneC: BASE + '/message/ycode', // post根据手机号获取验证码
	reMCUser: BASE + '/user/regist', // post密码手机号注册验证
	getlogin: BASE + '/user/login' // post 登录
}

export default urls
