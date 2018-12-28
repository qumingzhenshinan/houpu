const $course = {
	state: {
		term: {},
	},
	mutations: {
		GET_TERM: (state, data) => {
			state.term = data
		},

	},
	actions: {
		GetTerm({commit}, data){
			commit('GET_TERM', data) 
		},

	}
}

export default $course