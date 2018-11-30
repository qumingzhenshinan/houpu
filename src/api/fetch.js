import axios from "axios"
import qs from "qs"
import bus from "@/bus"

const service = axios.create()

service.interceptors.request.use(
  request => {
      // if (token) {  // 每次发送请求之前判断是否存在token，如果存在，则统一在http请求的header都加上token，不用每次请求都手动添加了
      //   request.headers.Authorization = token;
      // }
      // bus.$emit('backLoading')
      request.data = qs.stringify(request.data)
      return request;
  },
  err => {
      return Promise.reject(err);
  })

service.interceptors.response.use(
    response => {

        if (response.status !== 200) {
            const msg = `接口返回错误, status = ${response.status}`
            // bus.$emit('backendError', msg)
            // bus.$emit('backLoadEnd')
            throw new Error(msg)
        } else if (response.data && response.data.code && response.data.code !== 1) {
            const msg = `接口返回错误, code='${response.data.code}' msg ='${response.data.msg}'`
            // bus.$emit('backendError', response.data.msg)
            // bus.$emit('backLoadEnd')
            throw new Error(msg)
        } else {
            // bus.$emit('backLoadEnd')
            return response.data.data
        }
    })

export default service
