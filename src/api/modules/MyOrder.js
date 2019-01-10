import fetch from "@/api/fetch"
import URL from "@/api/URL"

export function allOrder(params) {
    return fetch.post(URL.allorder, params)
    
}
export function OrderDetail(params) {
    return fetch.post(URL.oederdetail,params)    
}

export function addping(params) {
	return fetch.post(URL.addping, params)
}