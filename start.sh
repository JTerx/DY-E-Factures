cd dy-invoice/
./mvnw clean install -Dmaven.test.skip=true
cd ..
docker-compose build
docker-compose up
