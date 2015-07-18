package org.ga4gh.ctk.server;

import org.springframework.context.annotation.*;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.resource.*;

/**
 * Created by Wayne Stidolph on 7/17/2015.
 */
@Configuration
public class CtkServerConfig extends WebMvcConfigurerAdapter{

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry){
        registry
                .addResourceHandler("/testresults/**")
                .addResourceLocations("/testresults/")
                .resourceChain(true)
                .addResolver(new PathResourceResolver());
    }
}
