package tests;

import base.BaseTest;
import pages.LoginPage;
import pages.ProductsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test(groups = {"smoke"})
    public void validLoginShouldOpenProductsPage() {
        LoginPage loginPage = new LoginPage(driver());
        ProductsPage productsPage = new ProductsPage(driver());

        loginPage.open(baseUrl())
                 .login("standard_user", "secret_sauce");

        Assert.assertTrue(
                productsPage.isDisplayed(),
                "Products page should be displayed after successful login."
        );

        Assert.assertEquals(
                productsPage.getTitle(),
                "Products",
                "Unexpected page title."
        );
    }
}
