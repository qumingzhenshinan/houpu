import fetch from "@/api/fetch"
import URL from "@/api/URL"

export function getCUser() {
	return new Promise(resolve => {
    setTimeout(() => {
      resolve(
      	[{name: '111', password: '222'}, {name: '333', password: '222'}, {name: '444', password: '222'}]
    	)
    })
  })
}

export function getGUser() {
	return new Promise(resolve => {
		setTimeout(() => {
			resolve(
				[{
					name: 'aaa',
					password: '222',
				},{
					name: 'bbb',
					passoword: '222'
				},{
					name: 'ccc',
					password: '222'
				}]
			)
		})
	})
}