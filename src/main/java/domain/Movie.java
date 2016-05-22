package domain;

import java.util.ArrayList;
import java.util.List;

public class Movie {
    private int id;
    private String title;
    private String genre;
    private int year;
    private List<Comment> commentList = new ArrayList<>(  );

    public final static Movie NULL;

    static {
        NULL = new Movie();
        NULL.setId( -1 );
        NULL.setTitle( "" );
        NULL.setGenre( "" );
        NULL.setYear( 0 );
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public List< Comment > getComments() {
        return commentList;
    }

    public void setComments( List< Comment > commentList ) {
        this.commentList = commentList;
    }
}
