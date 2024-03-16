import request from '@/utils/request'

// 查询兴趣特征列表
export function listPreference(query) {
  return request({
    url: '/tags/preference/list',
    method: 'get',
    params: query
  })
}

export function findBy() {
  return request({
    url:'/tags/preference/datalist',
    method: 'get'
  })
}

// 查询兴趣特征详细
export function getPreference(id) {
  return request({
    url: '/tags/preference/' + id,
    method: 'get'
  })
}

// 新增兴趣特征
export function addPreference(data) {
  return request({
    url: '/tags/preference',
    method: 'post',
    data: data
  })
}

// 修改兴趣特征
export function updatePreference(data) {
  return request({
    url: '/tags/preference',
    method: 'put',
    data: data
  })
}

// 删除兴趣特征
export function delPreference(id) {
  return request({
    url: '/tags/preference/' + id,
    method: 'delete'
  })
}
