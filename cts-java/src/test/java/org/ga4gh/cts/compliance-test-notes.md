## Compliance test notes

### These are the categories of the tests in the existing [ga4gh/compliance](https://github.com/ga4gh/compliance) repo.

The schema is detailed [here](http://ga4gh.org/#/api/v0.5.1).

1. Search read group sets (25 tests) [converted partially - missing fields]
    - Fetches read group sets from the specified dataset.

    *Query 1*: `/readgroupsets/search <dataset ID>`

    *Test 1*: assert that we received a result of type GASearchReadGroupSetsResponse, and that every
              GASearchReadGroupSet it contains has field `datasetId == <dataset ID>`

    *Test 2*: every GAReadGroup in that GASearchReadGroupSet has: an 'experiment' of type GAExperiment; datasetId == <dataset ID>;
              a program of type GAProgram which is not empty

2. Search variant sets (11 tests) [converted]
    - Fetches variant sets from the specified dataset.

    *Query 1*: `/variantsets/search <dataset ID>`

    *Test 1*: assert that we received a GASearchVariantSetsResponse containing an array of GAVariantSet of length > 0
     (should have a definite #, actually)

    *Test 2*: assert that the 'metadata' field of that GAVariantSet is of type GAVariantSetMetadata.

3. Reference sets (11 tests) [converted]
    -  Searches for reference set GRCh37 by accession (GCA_000001405.15) and then fetches that same reference set by ID.

    *Query 1*: `/referencesets/search accessions: ["GCA_000001405.15"] pageSize: 1`

    *Test 1*: assert that we received a GASearchReferenceSetsResponse object containing an array of GAReferenceSet objects.  For
        each one, assert that `ncbiTaxonId == 9606 AND assemblyId == GRCh38`.  And do this for each ID in referenceIds:

    *Query 2*: `/referencesets/<ref set ID>`

    *Test 2*: assert that the ID of the returned object == ref set ID above.

4. References (11 tests) [converted]
    - Searches for chr1 of GRCh37 by MD5 checksum (`1b22b98cdeb4a9304cb5d48026a85128`) and then fetches that same reference by ID.

    *Query 1*: `/references/search md5checksums: [md5checksum] pageSize: 1`

    *Test 1*: assert that the result is a GASearchReferencesResponse containing an array of GAReference objects. Array must be of length *(what?)*.
        Assert that every GAReference has `length == 249250621 AND md5checksum == <md5checksum> AND ncbiTaxonId == 9606` (human)

    *Query 2*: `/references/<ref ID>`

    *Test 2*: assert that the returned GAReference has `ID == ref ID`

5. Reference bases (2 tests) [converted]
    - Searches for chr1 of GRCh37 by MD5 checksum and then fetches 10 bases for that reference at offset 15000.

    *Query 1*: `/references/search md5checksums: [1b22b98cdeb4a9304cb5d48026a85128] pageSize: 1`

    *Test 1*: assert that we received a GASearchReferencesResponse object

    *Query 2*: `/references/<ref id>/bases start: 15000 end: 15010`

    *Test 2*: assert that we received a GAReference object with fields `offset == 15000 AND sequence == "ATCCGACATC"`

6. Search reads (28 tests) [converted]
    - Looks up a read group set for NA12878 from the specified dataset, then fetches reads.

    *Query 1*: `/readgroupsets/search datasetIds: 1 `(passed in)` name: 'NA12878', pageSize: 1`

    *Test 1*: assert that we received a GASearchReadGroupSetsResponse containing an array of GAReadGroupSet, length 1, with name 'NA12878'.
        Pull field 'id' from the first returned readGroups.

    *Query 2*: `/reads/search readGroupIds: readGroupIds referenceName: '22' start: 51005353 end: 51005354`

    *Test 2*: assert that the result is a GASearchReadsResponse containing an array of > 0 GAReadAlignment objects.

    *Test 3*: assert that each of the GAReadAlignment objects contains a nextMatePosition of type GAPosition with
        reference name == "22" AND alignment of type GALinearAlignment with field cigar holding a GACigarUnit.

7. Search call sets (8 tests) [converted]
    - Fetches call sets from the specified dataset.

    *Query 1*: `/variantsets/search datasetIds: `(passed in)`

    *Test 1*: assert that we received a GASearchVariantSetsResponse containing an array of GAVariantSet objects.  For
        each of the GAVariantSet objects, grab the `id` and pass it to....

    *Query 2*: `/callsets/search variantSetIds: [id]`

    *Test 2*: assert that the returned object is a GASearchCallSetsResponse, and that it contains > 0 GACallSet objects. We can check that the
        cal sets have distinct ID values.

8. Search variants (21 tests) [converted]
    - Fetches variants from the specified dataset.

    *Query 1*: `/variantsets/search datasetIds: 1 `(passed in)

    *Test 1*: assert that we received a GASearchVariantSetsResponse containing (how many? > 0) GAVariantSet
              objects.  Get the ID of the first one.

    *Query 2*: `/variants/search variantSetIds: [variantSetId] referenceName: '22' start: 51005353 end: 51015354 pageSize: 1`

    *Test 2*: assert that the first result is of type GAVariant AND has reference name == "22".

    *Test 3*: assert that the calls field (a GACall) of that GAVariant is not null.

    *Test 4*: assert that the genotype field of that GACall is an array of integers.

### Comments

Tests fields' presence and types (string, float, long, date, array, keyvalue, int, boolean).

Does not test HTTP methods or status codes.

Ensure no extra fields in returned objects. (Test that this is impossible in ProtoBuf.)

I'd like to start filling GAException with useful information.  This should be in a future version of the schemas.

(Would love it if the mentions of the types in the text of methods used `{@link}` or equivalent.)

