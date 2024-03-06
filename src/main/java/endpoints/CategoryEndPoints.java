package endpoints;


import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.response.Response;
import io.restassured.http.ContentType;
import payloads.Category;

import static io.restassured.RestAssured.given;



public class CategoryEndPoints {

    public static Response createCategory(Category payload){
        Response rs = given()
                .filter(new AllureRestAssured())
                .contentType(ContentType.JSON)
                .header("accept","*/*")
                .header("Content-Type","application/json")
                .body(payload)
                .when()
                .post(Routers.category_post);

        return rs;


    }
    public static Response allReadCategory(){
        Response rs = given()
                .filter(new AllureRestAssured()).header("accept","*/*")
                .pathParam("mypath","categories")
                .queryParam("limit",10)
                .when()
                .get(Routers.category_all_get);
        return rs;


    }
    public static Response readCategory(int id){
        Response rs = given()
                .filter(new AllureRestAssured())
                .header("accept","*/*")
                .pathParam("id",id)
                .when()
                .get(Routers.category_get);

        return rs;

    }
    public static Response updateCategory(int id, Category
            payload){
        Response rs = given()
                .filter(new AllureRestAssured())
                .contentType(ContentType.JSON)
                .header("accept","*/*")
                .pathParam("id",id)
                .body(payload)
                .when()
                .put(Routers.category_put);

        return rs;

    }
    public static Response deleteCategory(int id){
        Response rs = given()
                .filter(new AllureRestAssured())
                .contentType(ContentType.JSON)
                .header("accept","*/*")
                .pathParam("id",id)
                .when()
                .delete(Routers.category_delete);

        return rs;

    }




}
