import fetch from "@/api/fetch"
import URL from "@/api/URL"

export function AllCourse(params) {
    return fetch.get(URL.course)
}