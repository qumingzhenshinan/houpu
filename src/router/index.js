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
import PersonalCenterdetail from '@/views/personalCenter/personalCenterdetail'
import MyCoupon from '@/views/personalCenter/myCoupon'
import TeacherDeatail from '@/views/detail/teacher'
import StudentDeatail from '@/views/detail/student'

Vue.use(Router)

export default new Router({
  routes: [
    // 首页
    {
      path: '/',
      name: 'home',
      component: Home
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
    	path: '/courseDetail',
    	name: 'detail',
    	component: CourseDetail
    },
    // 个人中心 
    {
    	path: '/personalCenter',
    	name: 'personalCenter',
      component: PersonalCenter,
    },
    //个人信息修改
    {
      path: '/personalCenterdetail',
      name: 'personalCenterdetail',
      component: PersonalCenterdetail,
    },
    //我的优惠券
    {
      path: '/coupon',
      name: 'myCoupon',
      component: MyCoupon,
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
    // test 测试文件
    {
      path: '/test',
      name: 'test',
      component: test
    }
  ]
})
