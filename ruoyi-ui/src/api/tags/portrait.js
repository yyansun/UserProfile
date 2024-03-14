import request from '@/utils/request'

// 查询用户特征列表
export function listPortrait(query) {
  return request({
    url: '/tags/portrait/list',
    method: 'get',
    params: query
  })
}

export function findByGender() {
  return request({
    url:'/tags/portrait/genderlist',
    method: 'get'
  })
}

// 查询用户特征详细
export function getPortrait(id) {
  return request({
    url: '/tags/portrait/' + id,
    method: 'get'
  })
}

// 新增用户特征
export function addPortrait(data) {
  return request({
    url: '/tags/portrait',
    method: 'post',
    data: data
  })
}

// 修改用户特征
export function updatePortrait(data) {
  return request({
    url: '/tags/portrait',
    method: 'put',
    data: data
  })
}

// 删除用户特征
export function delPortrait(id) {
  return request({
    url: '/tags/portrait/' + id,
    method: 'delete'
  })
}
