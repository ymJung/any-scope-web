import React from 'react';
import {Comment} from '../';

import './CommentList.css';

const CommentList = ({comments}) => {

    // map data to components
    const commentList = comments.map(
        (comment, index)=>(
            <Comment
                name={comment.displayName}
                content={comment.content}
                key={index}
            />
        )
    );

    return (
        <ul className="CommentList">
            {commentList}
        </ul>
    );
};

export default CommentList;
