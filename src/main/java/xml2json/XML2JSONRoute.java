package xml2json;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.dataformat.xmljson.XmlJsonDataFormat;
import org.apache.camel.impl.DefaultCamelContext;
import org.apache.camel.main.Main;

/**
 * Created by Sushma on 11/19/2017.
 */
public class XML2JSONRoute {

    public static void main(String[] args) throws Exception {

        CamelContext context = new DefaultCamelContext();
        context.addRoutes(new RouteBuilder() {
            public void configure() throws Exception {
                from("file:resource/inbox").marshal().xmljson().to("file:resource/outbox");

            }
        });
        context.start();
        Thread.sleep(4000);
        context.stop();


    }
}
