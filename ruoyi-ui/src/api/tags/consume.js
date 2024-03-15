import request from '@/utils/request'

// 查询消费特征列表
export function listConsume(query) {
  return request({
    url: '/tags/consume/list',
    method: 'get',
    params: query
  })
}

// 查询消费特征详细
export function getConsume(id) {
  return request({
    url: '/tags/consume/' + id,
    method: 'get'
  })
}

// 新增消费特征
export function addConsume(data) {
  return request({
    url: '/tags/consume',
    method: 'post',
    data: data
  })
}

// 修改消费特征
export function updateConsume(data) {
  return request({
    url: '/tags/consume',
    method: 'put',
    data: data
  })
}

// 删除消费特征
export function delConsume(id) {
  return request({
    url: '/tags/consume/' + id,
    method: 'delete'
  })
}
