import fetch from "@/api/fetch"
import URL from "@/api/URL"

export function findTeacher(params) {
    return fetch.post(URL.findteacher,params)
}