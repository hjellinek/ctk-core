# CTK/CTS Design - Structure and Rationale

## Design Goals

The intent of the CTK is to make it easy to run and write GA4GH API-centric tests, and to use the test results in various reporting environments.

## Layout Overview

The CTK is structured as a set of Maven modules:

- **parent** is the common dependency management POM module
- **ctk-core** is an aggregator POM which provides common lifecycle and cross-module operations (such as building out a 'site')
- **dist** is a maven assembly module, to build the distributions of the CTK (22 June 2015 builds a single ZIP which unpacks to be the command-line tool)
- **schemas** is some fork or branch of the GA4GH [schemas](https://github.com/ga4gh/schemas) repository
- **transport** is the JSON/HTTP/Avro connection module
- **testpack** is the framework and general dependencies
- **cts-java** is the tests of the server (all in the src\test tree, treated as integration tests)