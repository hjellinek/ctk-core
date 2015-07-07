package org.ga4gh.cts

import spock.lang.Specification


/**
 * Created by wstidolph on 7/6/15.
 */
class HelloSpockSpec extends Specification {
        def "length of Spock's and his friends' names"() {
            expect:
            name.size() == length

            where:
            name     | length
            "Spock"  | 5
            "Kirk"   | 4
            "Scotty" | 6
        }

}