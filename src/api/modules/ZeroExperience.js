import fetch from "@/api/fetch"
import URL from "@/api/URL"

export function ZeroCourse(params) {
    return fetch.post(URL.zerocourse,params)
}

export function allZeroC(params) {
    return fetch.get(URL.allZeroC)
}

export function NewCourse(params) {
    return fetch.post(URL.newcourse,params)
}

export function newAllC(params) {
    return fetch.get(URL.newAllC)
}