package pl.nazaweb.arquillian.wildfly;

import java.io.File;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.importer.ZipImporter;
import org.jboss.shrinkwrap.api.spec.WebArchive;

/**
 *
 * @author Marek Kawczyński (marekka@mikronika.com.pl)
 */
public class Deployments {

    public static WebArchive createDeployment() {

        WebArchive war = ShrinkWrap.create(ZipImporter.class, "ArquillianWildflyTest.war")
                .importFrom(new File("target/ArquillianWildflyTest.war"))
            .as(WebArchive.class);
        
//        WebArchive war = ShrinkWrap.create(WebArchive.class)
//                // add classes
//                .addClasses(Rest.class, TestRest.class, ResponseDto.class)
//                // add configuration
//                //.addAsResource("META-INF/persistence.xml", "META-INF/persistence.xml")
//                .addAsWebInfResource(new File("src/main/webapp/WEB-INF/beans.xml"))
//                //.addAsWebInfResource(new File("src/test/webapp/WEB-INF/faces-config.xml"))
//                // add pages
//                .addAsWebResource(new File("src/main/webapp/index.html"))
//                .addAsWebResource(new File("src/main/webapp/js/libs/jquery/jquery.js"))
//                .addAsWebResource(new File("src/main/webapp/js/test.js"))
//                .setWebXML(new File("src/main/webapp/WEB-INF/web.xml"));

        return war;
    }
}
