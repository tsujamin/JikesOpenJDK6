# JikesRVM OpenJDK6 #
This project contains the replacement classes needed to load an OpenJDK6 container within JikesRVM.

## Usage ##
1. Compile a copy of JikesRVM with the OpenJDKContainer option enabled
2. Create a JAR containing the classes found in `src/`
3. Locate `classes.jar` in your local OpenJDK6 distribution
4. Execute the RVM: `rvm -X:openJDKClasses=rvmrt.jar:classes.jar:jikes-openjdk6.jar ClassToRunInContainer`

Consider using the following flags while debugging: `-verbose:class -X:verboseBoot=1 -X:vm:verboseTraceClassLoading=true`

## License ##
This code is licensed under the Eclipse Public License 1.0
