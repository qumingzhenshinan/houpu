const $course = {
	state: {
		term: {},
		courseList: []
	},
	mutations: {
		GET_TERM: (state, data) => {
			state.term = data
		},
		GET_LIST: (state, data) => {
			state.courseList = data
		}

	},
	actions: {
		GetTerm({commit}, data){
			commit('GET_TERM', data) 
		},
		GetList({commit}, data){
			commit('GET_LIST', data)
		}

	}
}

export default $course