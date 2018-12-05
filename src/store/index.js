import Vue from 'vue'
import Vuex from 'vuex'
import getters from './getters'
import $quiz from './modules/quiz'

Vue.use(Vuex)
const store = new Vuex.Store({
	modules: {
		$quiz
	},
	getters
})

export default store