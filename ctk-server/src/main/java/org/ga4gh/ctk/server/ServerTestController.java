package org.ga4gh.ctk.server;

import org.ga4gh.ctk.*;
import org.ga4gh.ctk.config.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Wayne Stidolph on 7/15/2015.
 */
@Controller
@RequestMapping("/servertest")
public class ServerTestController {

    @Autowired
    private TestRunner testrunner;

    public void setTestrunner(TestRunner testrunner) {
        this.testrunner = testrunner;
    }

    @Autowired
    public Props props;

    @RequestMapping(method = RequestMethod.GET)
    public
    @ResponseBody
    String runTests() {

        String testResultId =
                testrunner.doTestRun(
                        "https://192.168.2.214:8000/v0.5.1/",
                        "**/*ReadMethods*",//props.ctk_matchstr,
                        props.ctk_testjar);
        return testResultId;
    }
/*    protected ModelAndView redirect(){
        return new ModelAndView(new RedirectView());
    }*/
}
