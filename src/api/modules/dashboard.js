/**
 * 工作台api
 * @param {*} data
 */
import fetch from '../fetch'
import url from '../URL'

let uploadTime = 0
let myInterval = ''
let formData = ''
let hadData = false;

export function upload(url, file, data) {
    return new Promise(resolve => {
        if (!formData) {
            formData = new FormData()
        }
        if (file instanceof Array) {
            file.forEach((item, index) => {
                formData.append('file', item)
            })
        } else {
            formData.append('file', file)
        }
        uploadTime = 10
        if (!myInterval) {
            if (data && !hadData) {
                hadData = true;
                formData.append('data', data)
            }
            myInterval = setInterval(() => {
                if (uploadTime <= 0) {
                    clearInterval(myInterval)
                    myInterval = undefined
                    hadData = false;
                    fetch({
                        url: url,
                        headers: {
                            'Content-Type': 'multipart/form-data;charset=utf-8',
                            'Access-Control-Allow-Origin': '*',
                        },
                        method: 'post',
                        data: formData
                    }).then(res => {
                        formData = undefined
                        resolve(res)
                    }).catch(function(error) { //加上catch
                    })
                }
                uploadTime--
            }, 1)
        }
    })
}
