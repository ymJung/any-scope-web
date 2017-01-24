import React, {Component} from 'react';
import './Post.css';
import { CommentList } from '../';

class Post extends Component {
    constructor(props) {
        super(props);
        this.state = {
            postInfo: {
                title: null,
                content: null,
                comments: []
            },
            animate: false,
            direction: 'left'
        }
    }


    componentWillReceiveProps (nextProps) {

        const { title, content, comments } = nextProps;

        if(this.props.postId !== nextProps.postId) {
            // identify the animation direction
            const direction = this.props.postId < nextProps.postId ? 'left' : 'right';

            this.setState({
                direction,
                animate: true
            });

            // sync the props to state 0.5 sec later
            setTimeout(
                () => {
                    this.setState({
                        postInfo: {
                            title, content, comments
                        },
                        animate: false
                    })
                }, 500
            );
            return;
        }

        // sync the props to state directly (this is the first post)
        this.setState({
            postInfo: {
                title, content, comments
            }
        })
    }

    render() {
        const { title, content, comments } = this.state.postInfo;

        const { animate, direction } = this.state;

        const animation = animate
                          ? (direction==='left' ? 'bounceOutLeft' : 'bounceOutRight')
                          : (direction==='left' ? 'bounceInRight' : 'bounceInLeft');

        // show nothing when data is not loaded
        if(title===null) return null;

        return (
            <div className={`Post animated ${animation}`}>
                <h1>{title}</h1>
                <p>
                    {content}
                </p>
                <CommentList comments={comments}/>
            </div>
        );
    }
}

export default Post;
