import Vue from 'vue'
import Router from 'vue-router'
import HelloWorld from '@/components/HelloWorld'
import Home from '@/views/home/index'
import Start from '@/views/start/index'
import Retrieve from '@/views/start/retrieve'
import CourseList from '@/views/course/list'
import CourseDetail from '@/views/course/detail'
import PersonalCenter from '@/views/personalCenter/index'
import ConfirmationOrder from '@/views/order/confirmationOrder'
import PaymentOrder from '@/views/order/payment/index'
import test from '@/views/test/test'
import MyCoupon from '@/views/personalCenter/myCoupon'
import TeacherDeatail from '@/views/detail/teacher'
import StudentDeatail from '@/views/detail/student'
import MyOrder from '@/views/personalCenter/myOrder'
import MyTest from '@/views/personalCenter/myTest'
import ChangePassword from '@/views/personalCenter/changePassword'
import Quiz from '@/views/quiz/index'
import TestPaper from '@/views/quiz/testPaper'
import ResultPaper from '@/views/quiz/result'
import TestResult from '@/views/quiz/testResult'
// 
Vue.use(Router)

export default new Router({
  routes: [
    // 首页
    {
      path: '/',
      name: 'home',
      component: Home,
    },
    // 登录注册页
    {
      path: '/start',
      name: 'start',
      component: Start
    },
    {
      path: '/start/retrieve',
      name: 'retrieve',
      component: Retrieve
    },
    // 课程列表
    {
    	path: '/courseList',
    	name: 'list',
    	component: CourseList
    },
    // 课程详细 
    {
    	path: '/courseDetail/:gid',
    	name: 'detail',
    	component: CourseDetail
    },
    // 0元课程
    {
      path: '/zeroCourse',
    	name: 'zerocourse',
    	component: CourseList
    },
    // 最新课程
    {
      path: '/newCourse',
    	name: 'newcourse',
    	component: CourseList
    },
    // 推荐课程
    {
      path: '/recommended',
      name: 'recommended',
      component: CourseList
    },
    // 我的课程
    {
      path: '/myCourses',
      name: 'myCourses',
      component: CourseList
    },
    // 搜素跳转的课程列表
    {
      path: '/selectCourse',
      name: 'selectCourse',
      component: CourseList
    },
    // 个人中心 
    {
    	path: '/personalCenter',
    	name: 'personalCenter',
      component: PersonalCenter,
    },
    //我的优惠券
    {
      path: '/coupon',
      name: 'myCoupon',
      component: MyCoupon,
    },
    //我的订单
    {
      path: '/order',
      name: 'myOrder',
      component: MyOrder,
    },
    // 我的小测试
    {
      path: '/mytest',
      name: 'myTest',
      component: MyTest,
    },
    // 修改密码
    {
      path: '/changepassword',
      name: 'changePassword',
      component: ChangePassword,
    },
    // 确认订单
    {
    	path: '/ConfirmationOrder',
    	name: 'ConfirmationOrder',
    	component: ConfirmationOrder
    },
    // 订单支付
    {
    	path: '/paymentOrder',
    	name: 'paymentOrder',
    	component: PaymentOrder
    },
    // 老师详情页
    {
      path: '/detail/teacher/:id',
      name: 'teacherDetail',
      component: TeacherDeatail
    },
    // 学生详情页
    {
      path: '/detail/student/:id',
      name: 'studentDetail',
      component: StudentDeatail
    },
    // 小测验
    {
      path: '/quiz',
      name: 'quiz',
      component: Quiz
    },
    // 测验试卷
    {
      path: '/quiz/testPaper',
      name: 'testPaper',
      component: TestPaper
    },
    // 测验结果
    {
      path: '/quiz/resultPaper',
      name: 'resultPaper',
      component: ResultPaper
    },
    // 错题结果
    {
      path: '/quiz/testResult',
      name: 'testResult',
      component: TestResult
    },
    // test 测试文件
    {
      path: '/test',
      name: 'test',
      component: test
    },

  ]
})
