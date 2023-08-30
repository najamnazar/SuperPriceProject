# Steps
1. Setup MySQL
2. Configure MySQL by running `sh mysql_config.sh`
3. Build the backend: `mvn clean install`
4. Start the backend: `java -jar target/SuperPriceBackend-0.0.1-SNAPSHOT.jar`
5. Install Flask with pip: `python -m pip install flask requests`
6. Start the front end: `cd frontend && python app.py`
7. Go to `http://127.0.0.1:5000`
