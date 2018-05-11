package secondPart;

import java.util.ArrayList;
import java.util.List;

public class Blog {
    private List<Post> myposts = new ArrayList<>();

    public boolean addPost(Post newPost){
        boolean flag = false;
        boolean rt = false;
        for (Post post: this.myposts)
        {
            if (newPost.equals(post))
            {
                flag = true;
            }
        }
        if (!flag){
            myposts.add(newPost);
            //if the post is added the boolean is setted to true for the return
            rt = true;
        }
        return rt;
    }

    public boolean removePost(Post postToDelete){
        boolean rt = false;
        for (Post post: this.myposts)
        {
            if (post.getTitle().equals(postToDelete.getTitle())){
                myposts.remove(post);
                //if the post is removed the boolean is setted to true for the return
                rt = true;
            }
        }
        return rt;
    }

    public List<Post> getLastTen(){
        int size = myposts.size()-1;
        List<Post> lastTen = new ArrayList<>();
        for (int i=0;i<10;i++){
            lastTen.add(myposts.get(size));
            size--;
        }
        return lastTen;
    }

}
