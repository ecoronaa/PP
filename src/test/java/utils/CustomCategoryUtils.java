package utils;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CustomCategoryUtils {
    @SerializedName("name")
    private String name;
//    @SerializedName("messageRegex")
//    private String messageRegex;
    @SerializedName("matchedStatuses")
    private List<String> matchedStatuses;

    public CustomCategoryUtils(String name, List<String> matchedStatuses) {
        this.name = name;
//        this.messageRegex = messageRegex;
        this.matchedStatuses = matchedStatuses;
    }
}
