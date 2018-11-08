# Apache Camel HTTP Sample

This is just a simple Apache Camel route to produce sample data in Sumo Logic used for a demo... in a few hours.

## Usage

This project is available as `ckulka/apache-camel-http-sampler` and all it needs is a token from the Sumo Logic HTTP source.

```bash
docker run --rm -it -e sumologic-token=<token> docker pull ckulka/apache-camel-http-sampler
```

## Build from source

Use Gradle to build the JAR file first, then run it.

```bash
gradle build

# Alternatively, if Gradle is not installed
./gradlew build

# Run the JAR
java -jar -Dsumologic-token=<token> build/libs/apache-camel-http-sampler-1.0-SNAPSHOT.jar
```
