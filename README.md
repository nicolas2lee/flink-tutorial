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
``