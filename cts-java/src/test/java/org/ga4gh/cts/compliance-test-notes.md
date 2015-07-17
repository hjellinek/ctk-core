## Compliance test notes

### These are the categories of the tests in the existing [ga4gh/compliance](https://github.com/ga4gh/compliance) repo.

The schema is detailed [here](http://ga4gh.org/#/api/v0.5.1):

1. Search read group sets (25 tests)
    - Fetches read group sets from the specified dataset.

    *Query 1*: `/readgroupsets/search <dataset ID>`

    *Test 1*: assert that we received a result of type *(type?)* with field datasetId == <dataset ID>

    *Test 2*: assert that its 'experiment' is conformant to its type *(type? Experiment?)* and has datasetId == <dataset ID>

    *Test 3*: assert that its 'programs' is an array that is conformant to its type

2. Search variant sets (11 tests)
    - Fetches variant sets from the specified dataset.

    *Query 1*: `/variantsets/search <dataset ID>`

    *Test 1*: assert that we received an array of variantSet of length > 0 (should have a definite #, actually)

    *Test 2*: assert that the 'metadata' field is conformant to *(type?)*

3. Reference sets (11 tests)
    -  Searches for reference set GRCh37 by accession (GCA_000001405.15) and then fetches that same reference set by ID.

    *Query 1*: `/referencesets/search accessions: ["GCA_000001405.15"] pageSize: 1`

    *Test 1*: test reference set objects returned for conformance and values `ncbiTaxonId == 9606 AND assemblyId == GRCh38`.  Then,
               for each one, do this:

    *Query 2*: `/referencesets/<ref set ID>`

    *Test 2*: assert that the ID of the returned object == ref set ID above

4. References (11 tests)
    - Searches for chr1 of GRCh37 by MD5 checksum (`1b22b98cdeb4a9304cb5d48026a85128`) and then fetches that same reference by ID.

    *Query 1*: `/references/search md5checksums: [md5checksum] pageSize: 1`

    *Test 1*: assert that: `length == 249250621 AND md5checksum == <md5checksum> AND ncbiTaxonId == 9606` (human)

    *Query 2*: `/references/<ref ID>`

    *Test 2*: assert that the returned value *(type?)* has `ID == ref ID`

5. Reference bases (this is known by a different name in the schema, no?) (2 tests)
    - Searches for chr1 of GRCh37 by MD5 checksum and then fetches 10 bases for that reference at offset 15000.

    *Query 1*: `/references/search md5checksums: [1b22b98cdeb4a9304cb5d48026a85128] pageSize: 1`

    *Test 1*: assert that we received one *(type?)* object

    *Query 2*: `/references/<ref id>/bases start: 15000 end: 15010`

    *Test 2*: assert that we received one *(type?)* object with fields `offset == 15000 AND sequence == "ATCCGACATC"

6. Search reads (28 tests)
    - Looks up a read group set for NA12878 from the specified dataset, then fetches reads.

    *Query 1*: `/readgroupsets/search datasetIds: 1 `(passed in)` name: 'NA12878', pageSize: 1`

    *Process*: result is array of ReadGroupSets, length 1, with name 'NA12878'.  Pull field 'id' from readGroups returned.

    *Query 2*: `/reads/search readGroupIds: readGroupIds referenceName: '22' start: 51005353 end: 51005354`

    *Test*: result is array of alignments with all fields accounted for.

7. Search call sets (8 tests)
    - Fetches call sets from the specified dataset.

    *Query 1*: `/variantsets/search datasetIds: [runner.datasetId]`

    *Process*: for each of the variant sets that comes back, test it for conformance.  Grab the `id` and pass it to....

    *Query 2*: `/callsets/search variantSetIds: [id]`

    *Test*: that return values are `CallSet` objects and that fields have the expected types.

8. Search variants (21 tests)
    - Fetches variants from the specified dataset.

    *Query 1*: `/variantsets/search datasetIds: 1 `(passed in)

    *Test 1*: assert that we received (how many? > 0) variant sets.  Get the ID of the first one.

    *Query 2*: `/variants/search variantSetIds: [variantSetId] referenceName: '22' start: 51005353 end: 51015354 pageSize: 1`

    *Test 2*: assert that the first result is of type variants AND has reference name == "22".

    *Test 3*: assert that the calls field of that object is conformant

    *Test 4*: assert that the genotype field of that object is conformant

### Comments

Tests fields' presence and types (string, float, long, date, array, keyvalue, int, boolean).

Does not test values (except implicitly - as in "we did/did not receive an object in reply to this request").

Does not test HTTP methods or status codes.
Every method in the API must be annotated with the request types it accepts.

Ensure no extra fields in returned objects. (Test that this is impossible in ProtoBuf.)

I'd like to start filling GAException with useful information.  This should be in a future version of the schemas.

()Would love it if the mentions of the types in the text of methods used `{@link}` or equivalent.)

