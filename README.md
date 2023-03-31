# unlimint


## Description

Develop an application for parsing incoming data and converting the result of the parsing into the resulting format.

1.	A simple task solution is required, as if the application could be supported and maintained by other less experienced developers.
2.	The application must be implemented using the Spring framework.
3.	The source code of the application must be a maven project and hosted on GitHub. Only dependencies from public repositories may be used.
4.	The final application must be built by running the command:
      mvn clean install
5.	The application must be a console application. Example command to run: java -jar orders_parser.jar orders1.csv orders2.json
      where orders1.csv and orders2.json are parsing files.
6.	The result of the execution should be output to the stdout stream.
      Note: only output data should go into stdout, no logs should be there.
7.	Parsing and conversion must be done in parallel in multiple threads.
8.	Provision must be made for correct error handling in the source files. For example, a string value in the amount field may be instead of a number
9.	Language tools no higher than Java 8 may be used.
10.	Consideration should be given to adding new formats for incoming data


## Prerequisites

1. Minimum Java 1.8 version must be installed on PC
2. Maven must be installed on PC

## Notes

The Project is tested on Java: v1.11 &  Maven: Apache Maven 3.9.1

## How to Setup on local

1. Make a Git clone of main branch on local machine.
2. Change Directory command "cd unlimint".
3. To set up dependencies run command "mvn clean install".
4. To package project in target folder run command "mvn clean package"
5. To test run command "java -jar .\target\UnlimintJavaTest-1.0-SNAPSHOT.jar "%CSVFilePath%\orders1.csv" "%JsonFilePath%\orders2.json"
   

## Result on command line

{"result":"OK","amount":100.0,"filename":"orders1.csv","orderId":1.0,"line":1,"comment":"order payment","id":1}
{"result":"OK","amount":123.0,"filename":"orders1.csv","orderId":2.0,"line":2,"comment":"order payment","id":2}
{"result":"OK","amount":1.23,"filename":"orders2.json","orderId":3,"line":1,"comment":"order payment","id":3}
{"result":"OK","amount":1.24,"filename":"orders2.json","orderId":4,"line":2,"comment":"order payment","id":4}
