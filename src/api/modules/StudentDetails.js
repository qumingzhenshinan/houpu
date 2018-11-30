import fetch from "@/api/fetch"
import URL from "@/api/URL"

export function findStudent(params) {
    return fetch.post(URL.findstudent,params)
}

export function findstuimg(params) {
    return fetch.post(URL.findstuimg,params)
}
