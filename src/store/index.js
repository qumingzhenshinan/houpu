import Vue from 'vue'
import Vuex from 'vuex'
import getters from './getters'
import $quiz from './modules/quiz'
import $course from './modules/course'

Vue.use(Vuex)
const store = new Vuex.Store({
	modules: {
		$quiz,
		$course
	},
	getters
})

export default store