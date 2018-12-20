import fetch from "@/api/fetch"
import URL from "@/api/URL"


export function Getmycoupon(params) {
    return fetch.post(URL.getmycoupon,params)
}
export function DetailUsername(params) {
    return fetch.post(URL.detailusername,params)
}
export function GetPhonenum(params) {
    return fetch.post(URL.getphonenum,params)
}
export function ExamHistoy(params) {
    return fetch.post(URL.examhistoy,params)
}
export function ChangePassword(params) {
    return fetch.post(URL.changepassword,params)
}
export function UpdataImg(params) {
    return fetch.post(URL.updataimg,params)
}