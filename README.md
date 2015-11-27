# JikesRVM OpenJDK6 #
This project contains the replacement classes needed to load an OpenJDK6 container within JikesRVM.

## Usage ##
1. Compile a copy of JikesRVM with the OpenJDKContainer option enabled
2. Compile `jikes-openjdk6.jar` using ant (`ant build`)
3. Locate `classes.jar` in your local OpenJDK6 distribution
4. Execute the RVM: `rvm -X:openJDKClasses=classes.jar:jikes-openjdk6.jar ClassToRunInContainer`

Consider using the following flags while debugging: `-verbose:class -X:verboseBoot=1 -X:vm:verboseTraceClassLoading=true`

## Examples ##
### HashcodeDemo ###
Demonstrates a simple replacement by calling Object.hashCode()

`rvm -X:openJDKClasses=classes.jar:jikes-openjdk6.jar HashcodeDemo`

### ContainerDemo ###
Instantiates 10 OpenJDK containers within a regular GNU Classpath backed java program and executes HashcodeDemo in each of them.

`rvm -classpath jikes-openjdk6.jar ContainerDemo classes.jar:jikes-openjdk6.jar HashcodeDemo`

## License ##
This code is licensed under the Eclipse Public License 1.0
