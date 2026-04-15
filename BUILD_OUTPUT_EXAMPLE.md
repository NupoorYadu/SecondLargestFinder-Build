# Example Jenkins Build Output

## Build Console Log

```
Started by GitHub push by john-developer
Building on master in workspace /var/jenkins_home/workspace/SecondLargestFinder-Build
The recommended git tool is: NONE
Using strategy: Default
Cloning the remote Git repository
Cloning with depth: 1
Cloning into '/var/jenkins_home/workspace/SecondLargestFinder-Build'...
[2026-04-16T14:32:12.456Z] Fetching upstream changes from https://github.com/your-org/second-largest-finder.git
[2026-04-16T14:32:15.123Z] From https://github.com/your-org/second-largest-finder
[2026-04-16T14:32:15.234Z]  * branch            main       -> FETCH_HEAD
[2026-04-16T14:32:15.345Z] Checking out Revision a1b2c3d4 (main)
[2026-04-16T14:32:15.456Z] 
> git config core.sparsecheckout # timeout=10
> git checkout -f a1b2c3d4
> git rev-list a1b2c3d4 # timeout=10

[Pipeline] Start of Pipeline
[2026-04-16T14:32:16.123Z] Running in Declarative agent
[Pipeline] node
[2026-04-16T14:32:16.234Z] Running on Jenkins in /var/jenkins_home/workspace/SecondLargestFinder-Build
[Pipeline] {
[Pipeline] timestamps

====== STAGE: Checkout ======
[2026-04-16T14:32:17.123Z] [Pipeline] stage
[2026-04-16T14:32:17.234Z] [Pipeline] { (Checkout)
[2026-04-16T14:32:17.345Z] [Pipeline] echo
[2026-04-16T14:32:17.456Z] ========== Checking out source code ==========
[2026-04-16T14:32:17.567Z] [Pipeline] checkout
[2026-04-16T14:32:17.678Z] Using strategy: Default
[2026-04-16T14:32:18.123Z] Fetching changes from the remote Git repository
[2026-04-16T14:32:18.234Z] Selected Maven version 3.8.1
[2026-04-16T14:32:18.345Z] [Pipeline] sh
[2026-04-16T14:32:18.456Z] + git log --oneline -5
[2026-04-16T14:32:18.567Z] a1b2c3d Fix test case edge case
[2026-04-16T14:32:18.678Z] e2f3g4h Add documentation
[2026-04-16T14:32:18.789Z] i5j6k7l Initial commit with algorithm
[2026-04-16T14:32:18.890Z] m8n9o0p Create Maven project structure
[2026-04-16T14:32:19.001Z] q1r2s3t Add .gitignore
[2026-04-16T14:32:19.112Z] [Pipeline] }

====== STAGE: Build ======
[2026-04-16T14:32:19.223Z] [Pipeline] stage
[2026-04-16T14:32:19.334Z] [Pipeline] { (Build)
[2026-04-16T14:32:19.445Z] [Pipeline] echo
[2026-04-16T14:32:19.556Z] ========== Building Maven project ==========
[2026-04-16T14:32:19.667Z] [Pipeline] sh
[2026-04-16T14:32:19.778Z] + mvn clean compile
[2026-04-16T14:32:19.889Z] Apache Maven 3.8.1 (05682f835b591f4a4f87f3736db57f7c0a4dde15; 2021-04-04T13:36:97-05:00)
[2026-04-16T14:32:20.000Z] Maven home: /usr/share/maven
[2026-04-16T14:32:20.111Z] Java version: 11.0.15, vendor: Ubuntu, runtime name: OpenJDK Runtime Environment
[2026-04-16T14:32:20.222Z] Java home: /usr/lib/jvm/java-11-openjdk-amd64
[2026-04-16T14:32:20.333Z] Default locale: en_US, platform encoding: UTF-8
[2026-04-16T14:32:20.444Z] OS name: "linux", version: "5.15.0-58-generic", arch: "x86_64", family: "unix"
[2026-04-16T14:32:20.555Z] [INFO] Scanning for projects...
[2026-04-16T14:32:21.234Z] [INFO] 
[2026-04-16T14:32:21.345Z] [INFO] ----------- second-largest-finder 1.0.0 -----------
[2026-04-16T14:32:21.456Z] [INFO] Building Second Largest Finder 1.0.0
[2026-04-16T14:32:21.567Z] [INFO] -------- [ jar ]---------
[2026-04-16T14:32:21.678Z] [INFO]
[2026-04-16T14:32:21.789Z] [INFO] --- maven-clean-plugin:2.6.1:clean (default-clean) @ second-largest-finder ---
[2026-04-16T14:32:22.123Z] [INFO] Deleting /var/jenkins_home/workspace/SecondLargestFinder-Build/target
[2026-04-16T14:32:22.234Z] [INFO]
[2026-04-16T14:32:22.345Z] [INFO] --- maven-resources-plugin:2.6:resources (default-resources) @ second-largest-finder ---
[2026-04-16T14:32:22.456Z] [INFO] Using 'UTF-8' encoding to copy filtered resources.
[2026-04-16T14:32:22.567Z] [INFO] skip non existing resourceDirectory /var/jenkins_home/workspace/SecondLargestFinder-Build/src/main/resources
[2026-04-16T14:32:22.678Z] [INFO]
[2026-04-16T14:32:22.789Z] [INFO] --- maven-compiler-plugin:3.11.0:compile (default-compile) @ second-largest-finder ---
[2026-04-16T14:32:23.234Z] [INFO] Compiling 1 source file to /var/jenkins_home/workspace/SecondLargestFinder-Build/target/classes
[2026-04-16T14:32:24.123Z] [INFO] BUILD SUCCESS
[2026-04-16T14:32:24.234Z] [INFO] Total time: 3.891 s
[2026-04-16T14:32:24.345Z] [INFO] Finished at: 2026-04-16T14:32:24-05:00
[2026-04-16T14:32:24.456Z] [Pipeline] }

====== STAGE: Test ======
[2026-04-16T14:32:24.567Z] [Pipeline] stage
[2026-04-16T14:32:24.678Z] [Pipeline] { (Test)
[2026-04-16T14:32:24.789Z] [Pipeline] echo
[2026-04-16T14:32:24.890Z] ========== Running unit tests ==========
[2026-04-16T14:32:25.001Z] [Pipeline] sh
[2026-04-16T14:32:25.112Z] + mvn test
[2026-04-16T14:32:26.234Z] Apache Maven 3.8.1 (05682f835b591f4a4f87f3736db57f7c0a4dde15; 2021-04-04T13:36:97-05:00)
[2026-04-16T14:32:26.345Z] Maven home: /usr/share/maven
[2026-04-16T14:32:26.456Z] Java version: 11.0.15, vendor: Ubuntu, runtime name: OpenJDK Runtime Environment
[2026-04-16T14:32:26.567Z] Java home: /usr/lib/jvm/java-11-openjdk-amd64
[2026-04-16T14:32:26.678Z] Default locale: en_US, platform encoding: UTF-8
[2026-04-16T14:32:26.789Z] OS name: "linux", version: "5.15.0-58-generic", arch: "x86_64", family: "unix"
[2026-04-16T14:32:26.890Z] [INFO] Scanning for projects...
[2026-04-16T14:32:27.456Z] [INFO]
[2026-04-16T14:32:27.567Z] [INFO] ---------- second-largest-finder 1.0.0 ----------
[2026-04-16T14:32:27.678Z] [INFO] Building Second Largest Finder 1.0.0
[2026-04-16T14:32:27.789Z] [INFO] -------- [ jar ]---------
[2026-04-16T14:32:27.890Z] [INFO]
[2026-04-16T14:32:28.001Z] [INFO] --- maven-resources-plugin:2.6:resources (default-resources) @ second-largest-finder ---
[2026-04-16T14:32:28.112Z] [INFO] Using 'UTF-8' encoding to copy filtered resources.
[2026-04-16T14:32:28.223Z] [INFO] skip non existing resourceDirectory /var/jenkins_home/workspace/SecondLargestFinder-Build/src/main/resources
[2026-04-16T14:32:28.334Z] [INFO]
[2026-04-16T14:32:28.445Z] [INFO] --- maven-compiler-plugin:3.11.0:compile (default-compile) @ second-largest-finder ---
[2026-04-16T14:32:28.556Z] [INFO] Compiling 1 source file to /var/jenkins_home/workspace/SecondLargestFinder-Build/target/classes
[2026-04-16T14:32:29.234Z] [INFO] BUILD SUCCESS
[2026-04-16T14:32:29.345Z] [INFO]
[2026-04-16T14:32:29.456Z] [INFO] --- maven-resources-plugin:2.6:resources-testResources (default-testResources) @ second-largest-finder ---
[2026-04-16T14:32:29.567Z] [INFO] Using 'UTF-8' encoding to copy filtered resources.
[2026-04-16T14:32:29.678Z] [INFO] skip non existing resourceDirectory /var/jenkins_home/workspace/SecondLargestFinder-Build/src/test/resources
[2026-04-16T14:32:29.789Z] [INFO]
[2026-04-16T14:32:29.890Z] [INFO] --- maven-compiler-plugin:3.11.0:testCompile (default-testCompile) @ second-largest-finder ---
[2026-04-16T14:32:30.001Z] [INFO] Compiling 1 test file to /var/jenkins_home/workspace/SecondLargestFinder-Build/target/test-classes
[2026-04-16T14:32:30.234Z] [INFO] BUILD SUCCESS
[2026-04-16T14:32:30.345Z] [INFO]
[2026-04-16T14:32:30.456Z] [INFO] --- maven-surefire-plugin:3.0.0-M9:test (default-test) @ second-largest-finder ---
[2026-04-16T14:32:30.567Z] [INFO] -------------------------------------------------------
[2026-04-16T14:32:30.678Z]  T E S T S
[2026-04-16T14:32:30.789Z] -------------------------------------------------------
[2026-04-16T14:32:30.890Z] Running com.example.SecondLargestFinderTest
[2026-04-16T14:32:31.234Z] Tests run: 8, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.234 s
[2026-04-16T14:32:31.345Z] 
[2026-04-16T14:32:31.456Z] -------------------------------------------------------
[2026-04-16T14:32:31.567Z]  R E S U L T S
[2026-04-16T14:32:31.678Z] -------------------------------------------------------
[2026-04-16T14:32:31.789Z] Tests run: 8, Failures: 0, Errors: 0, Skipped: 0
[2026-04-16T14:32:31.890Z] 
[2026-04-16T14:32:32.001Z] [INFO] BUILD SUCCESS
[2026-04-16T14:32:32.112Z] [INFO] Total time: 5.234 s
[2026-04-16T14:32:32.223Z] [INFO] Finished at: 2026-04-16T14:32:32-05:00
[2026-04-16T14:32:32.334Z] [Pipeline] }

====== STAGE: Package ======
[2026-04-16T14:32:32.445Z] [Pipeline] stage
[2026-04-16T14:32:32.556Z] [Pipeline] { (Package)
[2026-04-16T14:32:32.667Z] [Pipeline] echo
[2026-04-16T14:32:32.778Z] ========== Packaging JAR artifact ==========
[2026-04-16T14:32:32.889Z] [Pipeline] sh
[2026-04-16T14:32:33.000Z] + mvn package -DskipTests
[2026-04-16T14:32:33.456Z] Apache Maven 3.8.1 (05682f835b591f4a4f87f3736db57f7c0a4dde15; 2021-04-04T13:36:97-05:00)
[2026-04-16T14:32:33.567Z] Maven home: /usr/share/maven
[2026-04-16T14:32:33.678Z] Java version: 11.0.15, vendor: Ubuntu
[2026-04-16T14:32:33.789Z] [INFO] Scanning for projects...
[2026-04-16T14:32:34.234Z] [INFO]
[2026-04-16T14:32:34.345Z] [INFO] ---------- second-largest-finder 1.0.0 ----------
[2026-04-16T14:32:34.456Z] [INFO] Building Second Largest Finder 1.0.0
[2026-04-16T14:32:34.567Z] [INFO] -------- [ jar ]---------
[2026-04-16T14:32:34.678Z] [INFO]
[2026-04-16T14:32:34.789Z] [INFO] --- maven-jar-plugin:3.3.0:jar (default-jar) @ second-largest-finder ---
[2026-04-16T14:32:35.234Z] [INFO] Building jar: /var/jenkins_home/workspace/SecondLargestFinder-Build/target/second-largest-finder-1.0.0.jar
[2026-04-16T14:32:35.345Z] [INFO]
[2026-04-16T14:32:35.456Z] [INFO] BUILD SUCCESS
[2026-04-16T14:32:35.567Z] [INFO] Total time: 2.891 s
[2026-04-16T14:32:35.678Z] [INFO] Finished at: 2026-04-16T14:32:35-05:00
[2026-04-16T14:32:35.789Z] [Pipeline] }

====== STAGE: Archive Artifacts ======
[2026-04-16T14:32:35.890Z] [Pipeline] stage
[2026-04-16T14:32:36.001Z] [Pipeline] { (Archive Artifacts)
[2026-04-16T14:32:36.112Z] [Pipeline] echo
[2026-04-16T14:32:36.223Z] ========== Archiving build artifacts ==========
[2026-04-16T14:32:36.334Z] [Pipeline] archiveArtifacts
[2026-04-16T14:32:36.445Z] Archiving artifacts
[2026-04-16T14:32:36.556Z] Archiving artifact 'target/second-largest-finder-1.0.0.jar'
[2026-04-16T14:32:36.667Z] [Pipeline] }

====== POST ACTIONS ======
[2026-04-16T14:32:36.778Z] [Pipeline] stage
[2026-04-16T14:32:36.889Z] [Pipeline] { (Post)
[2026-04-16T14:32:37.000Z] [Pipeline] junit
[2026-04-16T14:32:37.234Z] Publishing test results...
[2026-04-16T14:32:37.345Z] Recording test results
[2026-04-16T14:32:37.456Z] TEST RESULTS:
  - Total tests run: 8
  - Failures: 0
  - Errors: 0
  - Skipped: 0
[2026-04-16T14:32:37.567Z] [Pipeline] emailext
[2026-04-16T14:32:37.678Z] Sending email...
[2026-04-16T14:32:38.234Z] Email sent successfully to: developer@example.com
[2026-04-16T14:32:38.345Z] 
[2026-04-16T14:32:38.456Z] ✓ Build SUCCESS - Build #123 completed successfully
[2026-04-16T14:32:38.567Z] [Pipeline] deleteDir
[2026-04-16T14:32:38.678Z] Workspace cleaned up
[2026-04-16T14:32:38.789Z] [Pipeline] }
[2026-04-16T14:32:38.890Z] [Pipeline] End of Pipeline
[2026-04-16T14:32:39.001Z] Finished: SUCCESS
```

---

## Build Summary

```
BUILD SUCCESSFUL
Time Elapsed: 00:00:39 seconds
Build Number: #123
Git Commit: a1b2c3d
Branch: main

STAGE BREAKDOWN:
✓ Checkout     [4.2 sec]  - Git clone, commit verification
✓ Build        [3.9 sec]  - Maven compile
✓ Test         [5.2 sec]  - 8 JUnit tests passed
✓ Package      [2.9 sec]  - JAR created
✓ Archive      [1.2 sec]  - Artifacts stored
✓ Post Actions [6.1 sec]  - Tests published, email sent

ARTIFACTS:
✓ second-largest-finder-1.0.0.jar (4.2 MB)
  Location: target/second-largest-finder-1.0.0.jar
  Download: http://jenkins:8080/job/name/123/artifact/target/...

TEST RESULTS:
✓ SecondLargestFinderTest: 8/8 passed
  - testNormalArray: PASS (2ms)
  - testSimpleArray: PASS (1ms)
  - testArrayWithDuplicates: PASS (1ms)
  - testNegativeNumbers: PASS (1ms)
  - testMixedNumbers: PASS (1ms)
  - testNullArray: PASS (2ms)
  - testSingleElement: PASS (1ms)
  - testIdenticalElements: PASS (1ms)

NOTIFICATIONS:
✓ Email sent to: john-developer@example.com
```

---

## Artifact Information

```
Artifact: second-largest-finder-1.0.0.jar
Size: 4.2 MB
Created: 2026-04-16T14:32:35Z
Algorithm: Find 2nd largest in O(n) time, O(1) space

Execution:
$ java -jar second-largest-finder-1.0.0.jar

Output:
Array: [12, 35, 1, 10, 34, 1, 45, 23]
Second Largest Element: 34

Array: [100, 50, 75, 25, 90]
Second Largest Element: 90

Array: [-5, -10, -1, -20]
Second Largest Element: -5
```

---

## Key Metrics

| Metric | Value |
|--------|-------|
| Build Duration | 39 seconds |
| Compilation Time | 3.9 seconds |
| Test Execution | 5.2 seconds |
| Packaging Time | 2.9 seconds |
| Tests Passed | 8/8 (100%) |
| Code Coverage | N/A |
| Artifact Size | 4.2 MB |

---

**Build Status**: ✅ SUCCESS  
**Build Date**: 2026-04-16  
**Build Time**: 14:32:39 UTC
