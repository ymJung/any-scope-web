import React from 'react';
import './Post.css';

const Post = () => (
    <div className="Post">
        <h1>Title</h1>
        <p>
            Body
        </p>
        <CommentList/>
    </div>
);

export default Post;
