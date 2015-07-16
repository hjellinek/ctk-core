/**
 * <p>Provide test-oriented communication to Server.</p>
 * <p>This package currently provides the  communications between the tests
 * and the Server's JSON/HTTP endpoints (with messages and data elements as defined
 * in the Avro IDL).</p>
 * <p>(There is an URLMAPPING class to hold static strings defining Server endpoints
 * (extracted from the IDL comments).</p>
 * <p>This package provides RespCode as an enumeration/abstraction for the HTTP response
 * code integers. This class will provide GA4GH-specific comparators and trackers. This
 * is intended to be additional isolation from the HTTP layer in case the GA4GH effort
 * moves away from JSON/HTTP to a binary protocol while still needing to track communications
 * success/fail states.</p>
 * <p>Each API 'Protocol' has a matching "ProtocolClient" class. This class implements
 * the messages defined in the IDL and presents a pure Java interface to that endpoint
 * for test classes to use; each such method takes a single Request object and returns
 * a single Response object. Each endpoint method also has an overloaded version which
 * takes an additional WireTracker object the test can (optionally) supply. If present,
 * the WireTracker captures the details of the wire communications such as actual JSON
 * strings, response code, timing.</p>
 * <p>Created by Wayne Stidolph on 6/9/2015.</p>
 */
package org.ga4gh.ctk.transport.protocols;