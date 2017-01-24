import React from 'react';
import './Comment.css';

const Comment = ({name, content}) => {
    return (
        <li className="Comment">
            <p>
                <b>{name}</b> {content}
            </p>
        </li>
    );
};

export default Comment;
