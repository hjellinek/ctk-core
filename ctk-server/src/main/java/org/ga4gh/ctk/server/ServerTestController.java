package org.ga4gh.ctk.server;

import org.ga4gh.ctk.*;
import org.ga4gh.ctk.config.*;
import org.ga4gh.ctk.transport.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Wayne Stidolph on 7/15/2015.
 */
@Controller
@RequestMapping("/servertest")
public class ServerTestController implements CtkLogs {

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
    String runTests(@RequestParam(value="urlRoot", required = false) String urlRoot,
                    @RequestParam(value="matchstr",required = false) String mstr) {
        if(urlRoot == null)
            urlRoot = URLMAPPING.getInstance().getUrlRoot();
        if(mstr == null)
            mstr = props.ctk_matchstr;
        log.info("about to run tests " + urlRoot + " " + mstr + " " + props.ctk_testjar);
        String testResultId =
                testrunner.doTestRun(urlRoot,mstr,props.ctk_testjar,"testresults/1/");
        log.info("test complete " + testResultId);
        return "redirect:"+testResultId;
    }
/*    protected ModelAndView redirect(){
        return new ModelAndView(new RedirectView());
    }*/
}
