package testcases;

import com.github.javafaker.Faker;
import endpoints.CategoryEndPoints;
import io.qameta.allure.*;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import payloads.Category;


@Feature("Verify CRUD on Categories The Platzy API Fake")
public class CategoryTest {

    Faker faker;
    Category category;


    @BeforeClass
    public void data(){
        faker = new Faker();

        category = new Category();

        category.setName(faker.name().name());
        category.setImage(faker.avatar().image());


    }

    @Test(priority = 1)
    @Story("POST Request ")
    @Severity(SeverityLevel.NORMAL)
    @Description("Test Description:")
    public void testPostBooking(){

        Response rs = CategoryEndPoints.createCategory(category);
        rs.then().log().all();

        Assert.assertEquals(rs.getStatusCode(),201);

    }


    @Test(priority=2)
    @Story("All GET Request ")
    @Severity(SeverityLevel.NORMAL)
    @Description("Test Description:")
    public void testAllGetCategories(){
        Response rs = CategoryEndPoints.allReadCategory();
        rs.then().log().body();

        Assert.assertEquals(rs.getStatusCode(),200);
    }

    @Test(priority=3)
    @Story("GET Request ")
    @Severity(SeverityLevel.NORMAL)
    @Description("Test Description:")
    public void testGetBooking(){
       Response rs = CategoryEndPoints.readCategory(faker.number().randomDigit());
        rs.then().log().body();

        Assert.assertEquals(rs.getStatusCode(),200);

    }

    @Test(priority = 4)
    @Story("PUT Request ")
    @Severity(SeverityLevel.NORMAL)
    @Description("Test Description:")
    public void testUpdateBooking(){
        category.setName(faker.name().name());
        category.setImage(faker.avatar().image());

        //update data
        Response rs = CategoryEndPoints.updateCategory(faker.number().randomDigit(),category);
        rs.then().log().body();


        Assert.assertEquals(rs.getStatusCode(),200);



    }

    @Test(priority = 5)
    @Story("DELETE Request ")
    @Severity(SeverityLevel.NORMAL)
    @Description("Test Description:FOREIGN KEY constraint failed")
    public void testDeleteBooking(){

        Response rs = CategoryEndPoints.deleteCategory(faker.number().randomDigit());
        rs.then().log().body();

        Assert.assertEquals(rs.getStatusCode(),400);
    }
    

}
