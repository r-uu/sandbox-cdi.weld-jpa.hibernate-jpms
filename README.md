# sandbox-jpms-cdi.weld
environment for problems (and, hopefully, solutions) regarding the use of jmps together with cdi (weld)

the environment consists of a simple maven multi project. it is a _multi_ project to make extension of the environment easy.

notice the location of ```beans.xml``` in ```src/test/resources``` because cdi is used in tests only.

also notice the content of ```module-info.java```.