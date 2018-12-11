import fetch from "@/api/fetch"
import URL from "@/api/URL"


export function Getmycoupon(params) {
    return fetch.post(URL.getmycoupon,params)
}
export function DetailUsername(params) {
    return fetch.post(URL.detailusername,params)
}