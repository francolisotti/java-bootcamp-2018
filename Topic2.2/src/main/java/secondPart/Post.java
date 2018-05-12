package secondPart;

import java.util.Objects;

public class Post {
    private String title;
    private String body;

    public Post(String title, String body){
        this.title = title;
        this.body = body;
    }

    public String getTitle() {
        return title;
    }

}
