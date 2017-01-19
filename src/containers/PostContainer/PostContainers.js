import React, {Component} from 'react';
import { PostWrapper } from '../../components';

class PostContainer extends Component {
    render() {
        return (
            <PostWrapper>
              <Navigate/>
              <Post/>
            </PostWrapper>
        );
    }
}

export default PostContainer;
