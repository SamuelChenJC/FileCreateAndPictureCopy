package vo;

import java.util.List;

/**
 * Created by Chenpi on 2017/7/31.
 */
public class Student extends Human{

    private List<String> courses;


    public List<String> getCourses() {
        return courses;
    }

    public void setCourses(List<String> courses) {
        this.courses = courses;
    }
}
