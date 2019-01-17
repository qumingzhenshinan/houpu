import fetch from "@/api/fetch"
import URL from "@/api/URL"

export function getPhoneC(params) {
	return fetch.post(URL.getPhoneC, params)
}

export function reMCUser(params) {
	return fetch.post(URL.reMCUser, params)
}

export function getlogin(params) {
	return fetch.post(URL.getlogin, params)
}

export function queryPhone(params) {
	return fetch.post(URL.queryPhone, params)
}