package pathofexileuniques.eddytom.com.pathofexileuniques;

import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;

public class Unique{
    private final String name;
    private final int catagory;
    private final ArrayList<String> attributes;
    private final int image_Resource;


    public Unique(){
        name = null;
        catagory = -10;
        attributes = null;
        image_Resource = -10;
    }

    public Unique(String n, int cat, ArrayList<String> att, int image_Res){
        name = n;
        catagory = cat;
        attributes = att;
        image_Resource = image_Res;
    }

    public int getCatagory(){
        return catagory;
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
