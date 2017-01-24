import axios from 'axios';

export function getPost(boardId) {
    return axios.get('http://localhost:8080/board/' + boardId);
    // return axios.get('https://jsonplaceholder.typicode.com/posts/' + boardId);
  }

export function getComments(boardId) {
    return axios.get('http://localhost:8080/board/comment/' + boardId);
    // return axios.get(`https://jsonplaceholder.typicode.com/posts/${boardId}/comments`)

}
