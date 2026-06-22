package tms_maven;

import java.util.ArrayList;
import java.util.List;

public class SonnetData {
    String firstName;
    String lastName;
    String title;
    List<String> lines;

    SonnetData() {
        lines = new ArrayList<>();
    }

    String getFileName() {
        return firstName + "_" + lastName + "_" + title + ".txt";
    }
}
