import request from '@/utils/request'

export function login(data) {
    return request({
      url: '/files/upload',
      method: 'post',
      data
    })
  }