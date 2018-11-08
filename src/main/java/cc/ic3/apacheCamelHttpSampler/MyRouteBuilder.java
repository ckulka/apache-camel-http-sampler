package cc.ic3.apacheCamelHttpSampler;

import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class MyRouteBuilder extends RouteBuilder {

  public void configure() {
    from("timer:timer?period={{interval:1000}}")
        .setBody(simple("A: ${random(1,10)}, B: ${random(1,10)}, C: ${random(80,110)}"))
        .to("https4://collectors.de.sumologic.com/receiver/v1/http/{{sumologic-token}}")
        .filter(header(Exchange.HTTP_RESPONSE_CODE).isNotEqualTo(200))
        .log("Error (${header.CamelHttpResponseCode}): ${header.CamelHttpResponseText}");
  }
}