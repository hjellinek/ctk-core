# Installing The CTK/CTS

- `git clone https://github.com/wstidolph/ctk-core.git` (checkout this project)
- `cd ctk-core`
- Set up your `schemas` submodule; to use the schema as modified to create the
  CTK/CTS: 
    - `git submodule init` (to register the `schemas` directory as a git submodule)
    - `git submodule update` (to clone the schema from git)
    - `cd schemas`
    - `git checkout v0.5.2` (to ensure you have same schema)
- `mvn clean install` (this will run the `clean` and `install` maven goals from the aggregator POM in `ctk-core`, `schema`, `transport` and `testpack` modules for you; this puts the resulting artifacts into your local Maven repository. When those goals run they will pick up dependency and plugin information from the `parent` module's `pom.xml` file.)

In the above we use git submodule init and update rather than recursive clone,
for clarity and to make it obvious where to check in your own schemas module
if you're working on an API change. But, you could also just use
`git clone --recursive  https://github.com/wstidolph/ctk-core.git`

To work with the git submodel 

Suggestion: create an environment variable "ctk.tgt.urlRoot"
to point to your available GA4GH server, to save yourself having to add it to
command lines and module POMs.

## Installing your Schema Version
The project as it sits in https://github.com/wstidolph/ctk-core.git loads schema
from a particular version of schemas:

```

[submodule "schemas"]
	path = schemas
	url = https://github.com/wstidolph/schemas

```

This version of the schemas has some minor non-semantic changes
(like using String instead of CharSequence for the strings, and swapping the order
of some union fields to meet Avro/Java requirements). 

**This version of the Schema is not tracking changes to the real v0.5.1 Schema!**

Nor, of course, does it track to your own version of the schema if you were changing that.
So you need to use standard git mechanisms to ensure this git submodule is tracking
the version/branch of Schema you care about.

If you change the schema, you need to do a couple things:

- assign a local version number for your schema, so it can be deployed and used
without confusing the dependency trackers. Set your version in the properties part of
the `parent/pom.xml/`, for example: `<ga4gh.schema.local.version>0.5.2-SNAPSHOT</ga4gh.schema.local.version>`
- regenerate the custom Assertions, to ensure you have asserts matching your fields

To regenerate the assertions, first we need your schema available to the
assertions generator, so lets put it in it's jar and push that to a local maven
repository (with its new version number!):

- `cd schemas`
- `mvn clean install`

Now we can run the generator:

- `cd ../transport`
- `mvn assertj:generate-assertions`

(Or just run the `transport` modules assertj:generate-assertions goal using your IDE's maven runner)

You now have custom assertions, as source, in `transport/src/main/assertj-assertions` - you
manage these in your local git branch, or push them to your remotes like any other source.

If you want the build process to regenerate the assertions for you (say you're changing the
domain classes frequently) then uncomment the binds in `transport/pm.xml` and you waont have
to do this by hand - BUT, you stand a chance of the generator overwriting any editing
you've done on the domain-specific assertions.
