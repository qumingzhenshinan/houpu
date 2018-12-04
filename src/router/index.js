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
    	path: 'personalCenter',
    	name: 'personalCenter',
    	component: PersonalCenter
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
    // test 测试文件
    {
        path: '/test',
        name: 'test',
        component: test
    }
  ]
})
