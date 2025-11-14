# ----- Stage 1: Build ด้วย Maven -----
FROM maven:3.9.9-eclipse-temurin-17 AS build
WORKDIR /app

# คัดลอกไฟล์ pom และ src เข้าไปใน container
COPY pom.xml .
COPY src ./src

# build เป็น jar (ข้ามเทสต์ได้)
RUN mvn -B -DskipTests clean package

# ----- Stage 2: Run แอปจริง -----
FROM eclipse-temurin:17-jre-jammy
WORKDIR /app

# คัดลอก jar ที่ build เสร็จมาเป็น app.jar
COPY --from=build /app/target/*.jar app.jar

# Spring Boot ปกติใช้ port 8080
EXPOSE 8080

# รันแอป
ENTRYPOINT ["java", "-jar", "app.jar"]
