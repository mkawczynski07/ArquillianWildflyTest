package pl.nazaweb.arquillian.wildfly;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author naza
 */
@Path("test")
public class TestRest {

    @GET
    @Path("ping")
    @Produces(MediaType.APPLICATION_JSON)
    public ResponseDto ping() {
        ResponseDto response = new ResponseDto();
        try {
            response.data = "pong";
        } catch (Exception e) {
            response.success = false;
            e.printStackTrace();
        }
        return response;
    }

}
