plugins {
    id "com.commercehub.gradle.plugin.avro" version "0.3.4"
}

apply plugin: "com.commercehub.gradle.plugin.avro"

repositories {
    jcenter()
}
dependencies {
    compile "org.apache.avro:avro:1.7.7"
}

avro {
    encoding = "UTF-8"
}

task generateAvro(type: com.commercehub.gradle.plugin.avro.GenerateAvroJavaTask) {
    source("src/main/avro")
    outputDir = file("dest/avro")
}