import React from 'react';
import './CommentList.css';

const CommentList = () => {
    return (
        <ul className="CommentList">
           <Comment/>
           <Comment/>
           <Comment/>
        </ul>
    );
};


export default CommentList;
