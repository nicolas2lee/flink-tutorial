# flink-tutorial
      
Generate java maven flink project

      mvn archetype:generate                               \
      -DarchetypeGroupId=org.apache.flink              \
      -DarchetypeArtifactId=flink-quickstart-java      \
      -DarchetypeVersion=1.5.0
     
    
Generate scala flink project

    sbt new tillrohrmann/flink-project.g8
    
If you have problem with auth fail problem, try to use below command, the issue is https://github.com/lagom/lagom/issues/683 
    
    sbt new https://github.com/tillrohrmann/flink-project.g8

#flink scala

SBT

    libraryDependencies += "org.scala-tools" % "scala-stm_2.11" % "0.3"

Assuming the scalaVersion for your build is 2.11.1, the following is identical (note the double %% after "org.scala-tools"):

    libraryDependencies += "org.scala-tools" %% "scala-stm" % "0.3"
    
refer to this link: https://www.scala-sbt.org/1.x/docs/Library-Dependencies.html