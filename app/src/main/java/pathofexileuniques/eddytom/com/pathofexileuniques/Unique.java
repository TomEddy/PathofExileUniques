package pathofexileuniques.eddytom.com.pathofexileuniques;

import java.util.ArrayList;

public class Unique{
    private final String name;
    private final int category;
    private final ArrayList<String> attributes;
    private final int image_Resource;


    public Unique(){
        name = null;
        category = -10;
        attributes = null;
        image_Resource = -10;
    }

    public Unique(String n, int cat, ArrayList<String> att, int image_Res){
        name = n;
        category = cat;
        attributes = att;
        image_Resource = image_Res;
    }

    public int getCategory(){
        return category;
    }

    public int getImage_Resource(){
        return image_Resource;
    }

    public String getName(){
        return name;
    }

    public ArrayList<String> getAttributes(){
        return attributes;
    }
}
