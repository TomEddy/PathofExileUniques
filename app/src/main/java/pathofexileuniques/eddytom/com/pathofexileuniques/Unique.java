package pathofexileuniques.eddytom.com.pathofexileuniques;


public class Unique{
    private final String name;
    private final int category;
    private final String url;
    private final int image_Resource;
    private int index;


    public Unique(){
        name = null;
        category = -10;
        url = null;
        image_Resource = -10;
        index = -10;
    }

    public Unique(String n, int cat, String att, int image_Res){
        name = n;
        category = cat;
        url = att;
        image_Resource = image_Res;
        index = -10;
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

    public String getURL(){
        return url;
    }

    public int getIndex(){return index;}

    public void setIndex(int num){
        index = num;
    }
}
