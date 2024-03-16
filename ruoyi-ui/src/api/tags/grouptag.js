import request from '@/utils/request'

// 查询组合标签列表
export function listGrouptag(query) {
  return request({
    url: '/tags/grouptag/list',
    method: 'get',
    params: query
  })
}

// 查询组合标签详细
export function getGrouptag(id) {
  return request({
    url: '/tags/grouptag/' + id,
    method: 'get'
  })
}

// 新增组合标签
export function addGrouptag(data) {
  return request({
    url: '/tags/grouptag',
    method: 'post',
    data: data
  })
}

// 修改组合标签
export function updateGrouptag(data) {
  return request({
    url: '/tags/grouptag',
    method: 'put',
    data: data
  })
}

// 删除组合标签
export function delGrouptag(id) {
  return request({
    url: '/tags/grouptag/' + id,
    method: 'delete'
  })
}
