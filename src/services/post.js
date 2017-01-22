import axios from 'axios';

export function getPost(postId) {
    return axios.get('localhost:8080/board/' + postId);
}

export function getComments(postId) {
    return axios.get('localhost:8080/board/comment/${postId}')
}
