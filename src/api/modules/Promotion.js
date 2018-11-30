import fetch from "@/api/fetch"
import URL from "@/api/URL"

export function killEndTime(params) {
    return fetch.get(URL.killendtime)
}