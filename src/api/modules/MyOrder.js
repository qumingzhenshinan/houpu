import fetch from "@/api/fetch"
import URL from "@/api/URL"

export function allOrder(params) {
    return fetch.get(URL.allorder+'?uid='+ params.uid)
    
}
