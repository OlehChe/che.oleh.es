:: This guy runs apps
ECHO OFF
SETLOCAL
SET currentPort=8081

CLS
REM ***************************** es-discovery-service *****************************
ECHO ***************************** es-discovery-service *****************************
START java -jar .\..\es-discovery-service\target\es-discovery-service-0.0.1-SNAPSHOT.jar
TIMEOUT 10
C:\Users\Oleh_Cherniienko\Desktop\curl-7.68.0-win64-mingw\bin\curl -I http://localhost:8761 | findstr 200
ECHO Started es-discovery-service on 8761
REM ***************************** es-account *****************************
ECHO ***************************** es-account *****************************
start java -Dserver.port=%currentPort% -jar .\..\es-account\target\es-account-0.0.1-SNAPSHOT.jar
TIMEOUT 10
C:\Users\Oleh_Cherniienko\Desktop\curl-7.68.0-win64-mingw\bin\curl -I http://localhost:8081 | findstr 200
ECHO Started es-account on %currentPort%
REM ***************************** es-landing *****************************
ECHO ***************************** es-landing *****************************
SET currentPort=8082
start java -Dserver.port=%currentPort% -jar .\..\es-landing\target\es-landing-0.0.1-SNAPSHOT.jar
TIMEOUT 10
jps -m
PAUSE