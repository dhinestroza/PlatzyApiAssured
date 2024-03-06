package endpoints;

public class Routers {
    public static String base_url = "https://api.escuelajs.co";

    public static String category_post = base_url+"/api/v1/categories";
    public static String category_all_get = base_url+"/api/v1/{mypath}/";
    public static String category_get = base_url+"/api/v1/categories/{id}";
    public static String category_put = base_url+"/api/v1/categories/{id}";
    public static String category_delete = base_url+"/api/v1/categories/{id}";
}
