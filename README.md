## RDW_Common
RDW modules used by at least two apps.

Additional documentation:
* RDW_Common is part of the RDW suite of projects and applications. 
For all things RDW please refer to [RDW repo](https://github.com/SmarterApp/RDW)
* [License](LICENSE)
* There are jdbc integration tests. The [RDW Schema](https://github.com/SmarterApp/RDW_Schema) 
project has instructions for setting up MySQL locally to run these tests.  

#### Building
Java 8.
MySQL (see note above about RDW Schema project).

This is a gradle project so you can use the gradle wrapper `./gradlew clean build` or 
local gradle (v3.3+) `gradle clean build`. It is highly recommended to install gdub
(https://github.com/dougborg/gdub) because it handles some shortcomings of
gradle's commandline behavior.

Resulting module jars can be found in `./build/libs`

Jacoco code coverage is included as part of the module test task, `./build/reports/jacoco/test/html/index.html`.

Maven plugin is turned on so `gradle build install` will put a dependency artifact in your local repo.


