# Installing The CTK/CTS

- `git clone https://github.com/wstidolph/ctk-core.git` (checkout this project)
- `cd ctk-core`
- `git submodule init` (to register the `schemas` directory as a git submodule)
- `git submodule update` (to clone the schema from git; you may want to cd into the schema directory and check out a specific branch or tag such as `git checkout v0.5.1` to develop tests against)
- `mvn clean install` (this will run the `clean` and `install` maven goals from the aggregator POM in `ctk-core`, `schema`, `transport` and `testpack` modules for you; this puts the resulting artifacts into your local Maven repository. When those goals run they will pick up dependency and plugin information from the `parent` module's `pom.xml` file.)

In the above we use git submodule init and update rather than recursive clone, for clarity and to make it obvious where to check in your own schemas module if you're working on an API change. But, you could also just use `git clone --recursive  https://github.com/wstidolph/ctk-core.git`

Suggestion: create an environment variable "ctk.tgt.urlRoot" to point to your available GA4GH server, to save yourself having to add it to command lines and module POMs.