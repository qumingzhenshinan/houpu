import fetch from "@/api/fetch"
import URL from "@/api/URL"

export function allOrder() {
    return fetch.get(URL.allorder)
    
}
export function OrderDetail(params) {
    return fetch.post(URL.oederdetail,params)    
}