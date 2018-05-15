#!/bin/bash
# rm -rf ../app/dal/src/main/resources/META-INF/mappers/auto
mkdir -p ../app/dal/src/main/resources/META-INF/mappers/auto
mkdir -p ../app/dal/src/main/java
java -cp .:mybatis-generator-core-1.3.3-SNAPSHOT-baidu.jar org.mybatis.generator.api.ShellRunner -configfile config.xml -overwrite
echo "\033[32m Gen SUCCESSFUL!!! \033[0m"
