package org.ga4gh.ctk.config;

import org.springframework.boot.autoconfigure.*;
import org.springframework.context.annotation.*;

/**
 * Created by Wayne Stidolph on 6/16/2015.
 */

@EnableAutoConfiguration
@Configuration
@ComponentScan(basePackages = "org.ga4gh.ctk")
public class AppConfig {

    @Bean
    public AppConfig config() {
        return new AppConfig();
    }

/*    @Bean
    public TestFinder testFinder() {
        return new TestFinder();
    }*/

}
