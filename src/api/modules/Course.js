import fetch from "@/api/fetch"
import URL from "@/api/URL"

export function AllCourse(params) {
    return fetch.get(URL.course)
}
export function Coursecatalogue(params) {
    return fetch.post(URL.coursecatalogue,params)
}
export function Coursecomment(params) {
    return fetch.post(URL.coursecomment,params)
}
export function Coursedetails(params) {
    return fetch.post(URL.coursedetails,params)
}
export function SubjectQuery(params) {
    return fetch.post(URL.subjectquery,params)
}
export function findCourse(params) {
	return fetch.post(URL.findCourse, params)
}
export function getrecommendedC(params) {
	return fetch.post(URL.getrecommendedC, params)
}