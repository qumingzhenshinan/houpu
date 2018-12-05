const $quiz = {
	state: {
		quiz: [{title: '哈哈'}],
	},
	mutations: {
		GET_QUIZ: (state, data) => {
			state.quiz = data
		}
	},
	actions: {
		GetQuiz({commit}, data){
			commit('GET_QUIZ', data) 
		}
	}
}

export default $quiz