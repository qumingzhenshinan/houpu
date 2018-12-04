const BASE = 'http://www.houpuclass.com:8089'   //接口网址

const urls = {
	students: BASE + '/trophy/select',//get获取所有学员
	teachers: BASE + '/teacher/select',// get获取老师列表
	course: BASE + '/course/select',//get获取所有课程
	loop:BASE + '/article/select',//get轮播图
	findteacher: BASE + '/teacher/selectById',//post根据id获取老师详情
	findstudent: BASE +'/trophy/selectById',//post根据id获取学生详情
	findstuimg: BASE + '/stuimg/selectByProthyId',//post通过关联学员id获取学员证书图片
	killendtime: BASE + '/course/selectKillEndTime',//get限时促销
	zerocourse: BASE + '/course/selectByMoney',//post0元体验列表
	allorder: BASE + '/orders/selectAll', //get查询所有订单
	coursecatalogue: BASE + '/videoChild/select', // 获取课程目录
	// todos: 'http://www.houpuclass.com:8089/teacher/select'
}

export default urls
