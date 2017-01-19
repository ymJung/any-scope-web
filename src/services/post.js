import axios from 'axios';

export function getPost(postId) {
    return axios.get('localhost:3000/open/' + postId);
}

export function getComments(postId) {
    return axios.get('localhost:3000/open/comment/${postId}')
}
