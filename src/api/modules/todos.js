import fetch from "@/api/fetch"
import URL from "@/api/URL"

export function todos(params) {
	return fetch.get(URL.todos, {...params})
	return new Promise(resolve => {
    setTimeout(() => {
      resolve(
        {
          paId: '11111',
          paName: '张是',
          list: [{reId: "挂号单号",
          docitemId: "处方号",
          priority: "优先级",
          sheetType: "（0药品1检查2检验3其他）",
          itemName: "项目名称",
          leastUnit: "单位",
          leastNumber: "数量",
          itemAmount: "123",
          price: "单价",
          sheetDpid: "开单科室ID",
          sheetDpname: "开单科室名称",
          psId: "医师ID",
          sheetPsname: "医师名称",
          dpId: "执行科室ID",
          dpName: "执行科室名称"
          }],
        },
      )
    })
  })
}