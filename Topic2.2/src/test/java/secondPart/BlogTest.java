package secondPart;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class BlogTest {

    Blog myblog;

    @Before
    public void setUp()
    {
        myblog = new Blog();
    }

    @Test
    public void whenPostIsAdded(){
        Post p = new Post ("Example title","Example body");
        boolean result = myblog.addPost(p);
        Assert.assertEquals(true,result);
    }

    @Test
    public void whenPostIsDeleted(){
        Post p = new Post ("Example title","Example body");
        boolean result = myblog.addPost(p);
        Assert.assertEquals(true,result);

        boolean result2 = myblog.removePost(p);
        Assert.assertEquals(true,result2);
    }

    @Test
    public void whenShowLastTen(){
        Post p;
        for (int i=0; i<15; i++)
        {
           p = new Post("Example title "+i,"Example body" + i);
           myblog.addPost(p);
        }

        List<Post> result = myblog.getLastTen();
        Assert.assertEquals("Example title 5",result.get(9).getTitle());
        //The last ten posts are 15, 14, 13, 12, 11, 10, 9, 8, 7, 6, 5 so the first element of the lastTen list is the Example 5

    }

}
