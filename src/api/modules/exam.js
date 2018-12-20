import fetch from "@/api/fetch"
import URL from "@/api/URL"

export function findExamAll(params) {
	return fetch.get(URL.findExamAll)
}

export function findExamOnly(params) {
	return fetch.post(URL.findExamOnly, params)
}

export function getAnswer(params) {
	return fetch.post(URL.getAnswer, params)
}

export function findPAnswer(params) {
	return fetch.post(URL.findPAnswer, params)
}