import fetch from "@/api/fetch"
import URL from "@/api/URL"

export function ZeroCourse(params) {
    return fetch.post(URL.zerocourse,params)
}