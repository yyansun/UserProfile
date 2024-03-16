import request from '@/utils/request'

// 查询单人画像列表
export function listProfile(query) {
  return request({
    url: '/tags/profile/list',
    method: 'get',
    params: query
  })
}

// 查询单人画像详细
export function getProfile(userId) {
  return request({
    url: '/tags/profile/' + userId,
    method: 'get'
  })
}

// 新增单人画像
export function addProfile(data) {
  return request({
    url: '/tags/profile',
    method: 'post',
    data: data
  })
}

// 修改单人画像
export function updateProfile(data) {
  return request({
    url: '/tags/profile',
    method: 'put',
    data: data
  })
}

// 删除单人画像
export function delProfile(userId) {
  return request({
    url: '/tags/profile/' + userId,
    method: 'delete'
  })
}
