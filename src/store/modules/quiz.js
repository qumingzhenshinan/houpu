const $quiz = {
	state: {
		quiz: [],
		testResult: null,
	},
	mutations: {
		GET_QUIZ: (state, data) => {
			state.quiz = data
		},
		GET_QUIZRESULT: (state, data) => {
			state.testResult = data
		}
	},
	actions: {
		GetQuiz({commit}, data){
			commit('GET_QUIZ', data) 
		},
		GetQuizResult({commit}, data) {
			commit('GET_QUIZRESULT', data)
		}
	}
}

export default $quiz