import fetch from "@/api/fetch"
import URL from "@/api/URL"

export function AllCourse(params) {
    return fetch.get(URL.course)
}
export function Coursecatalogue(params) {
    return fetch.post(URL.coursecatalogue,params)
}