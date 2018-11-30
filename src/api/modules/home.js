import fetch from "@/api/fetch"
import URL from "@/api/URL"

export function homeTeachers(params) {
    return fetch.get(URL.teachers)
}
export function homeStudents(params) {
    return fetch.get(URL.students)
}
export function homeCourse(params) {
    return fetch.get(URL.course)
}
export function homeLoop(params) {
    return fetch.get(URL.loop)
}