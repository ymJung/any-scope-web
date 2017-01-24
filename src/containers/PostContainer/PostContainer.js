import React, {Component} from 'react';
import { PostWrapper, Navigate, Post, Warning } from '../../components';
import * as service from '../../services/post';


class PostContainer extends Component {

     constructor(props) {
        super();
        // initializes component state
        this.state = {
            boardId: 1,
            fetching: false, // tells whether the request is waiting for response or not
            post: {
                title: null,
                content: null
            },
            comments: [],
            warningVisibility: false
        };
    }

    componentDidMount() {
        this.fetchPostInfo(1);
    }

    showWarning = () => {
        this.setState({
            warningVisibility: true
        });

        // after 1.5 sec

        setTimeout(
            () => {
                this.setState({
                    warningVisibility: false
                });
            }, 1500
        );
    }


    fetchPostInfo = async (boardId) => {
        this.setState({
            fetching: true // requesting..
        });

        try {
            // wait for two promises
            const info = await Promise.all([
                service.getPost(boardId),
                service.getComments(boardId)
            ]);

            // Object destructuring Syntax,
            // takes out required values and create references to them
            const {title, content} = info[0].data;

            const comments = info[1].data;

            this.setState({
                boardId,
                post: {
                    title,
                    content
                },
                comments,
                fetching: false // done!
            });

        } catch(e) {
            // if err, stop at this point
            this.setState({
                fetching: false
            });
            this.showWarning();
        }
    }


    handleNavigateClick = (type) => {
        const boardId = this.state.boardId;

        if(type === 'NEXT') {
            this.fetchPostInfo(boardId+1);
        } else {
            this.fetchPostInfo(boardId-1);
        }
    }

    render() {
        const {boardId, fetching, post, comments, warningVisibility} = this.state;

        return (
            <PostWrapper>
                <Navigate
                    boardId={boardId}
                    disabled={fetching}
                    onClick={this.handleNavigateClick}
                />
                <Post
                    boardId={boardId}
                    title={post.title}
                    content={post.content}
                    comments={comments}
                />
                <Warning visible={warningVisibility} message="That post does not exist"/>
            </PostWrapper>
        );
    }
}

export default PostContainer;
