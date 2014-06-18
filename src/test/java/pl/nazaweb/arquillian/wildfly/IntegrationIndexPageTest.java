package pl.nazaweb.arquillian.wildfly;

import java.net.URL;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.drone.api.annotation.Drone;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.jboss.arquillian.testng.Arquillian;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 *
 * @author naza
 */
public class IntegrationIndexPageTest extends Arquillian {

    @Drone
    WebDriver driver;
    @ArquillianResource
    URL contextPath;

    @Deployment(testable = false)
    public static WebArchive createDeployment() {
        return Deployments.createDeployment();
    }

    @Test
    public void emptytest() {
        driver.get(contextPath + "index.html");
        Assert.assertTrue(driver.findElement(By.id("todo")).isDisplayed());
    }

    @Test(dependsOnMethods = "emptytest")
    public void restPingPongTest() throws InterruptedException {
        driver.get(contextPath + "index.html");
        Thread.sleep(2000);//waiting for js render
        Assert.assertTrue(driver.findElement(By.id("pong")).isDisplayed());
    }

}
