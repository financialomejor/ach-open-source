FROM maven:3.6.3-jdk-8-openj9
ARG PROJECT_PATH=/home/fm-ach-service
COPY ./ach ${PROJECT_PATH}
WORKDIR ${PROJECT_PATH}
#Import all elements of the project
COPY pse.cer pse.cer
#Add the certificate to the Java keystore
RUN keytool -import -alias ach -keystore $JAVA_HOME/jre/lib/security/cacerts -file pse.cer -storepass changeit -noprompt -trustcacerts
RUN apt-get install nano -y
#Storing the STDOUT in output.txt
CMD mvn spring-boot:run | tee -a output.txt
EXPOSE 80
EXPOSE 443