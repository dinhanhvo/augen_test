##Time summary: 
1. Analise Requirement: 1 hour 
2. Preparation: 2 hours 
3. Coding: 18 hours (including tests) 
4. Styling 30 minutes 
5. Building and testing 30 minutes 
	=> Grand total: 22 hours

## Environment require:
1. Java 8
2. Maven
3. Node

## Sumary to run application 

1. **Clone the application**

	```bash
	git clone https://github.com/dinhanhvo/augen_test.git
	```
2. **Run server
	```bash
	cd augen_test\augen_beckend
	mvn clean package install
	mvnw spring-boot:run
	```
3. **Run client
	```bash	
	cd augen_fontend
	yarn || npm i
	ng serve --port 4300
	```
## Design and reasons
- docs/Test Summary.docx

## User guide
- docs/User document.docx
