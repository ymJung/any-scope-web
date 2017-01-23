import axios from 'axios';

export function getPost(postId) {
    return axios.get('http://localhost:8080/board/' + postId);
    // return axios.get('https://jsonplaceholder.typicode.com/posts/' + postId);
  }

export function getComments(postId) {
    return axios.get('http://localhost:8080/board/comment/' + postId);
    // return axios.get(`https://jsonplaceholder.typicode.com/posts/${postId}/comments`)

}
