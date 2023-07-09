FROM amazoncorretto:17.0.7-al2023-headless

VOLUME /tmp

COPY build/libs/aws-msa-cart-service-1.0.jar cart-service.jar

ENTRYPOINT ["java","-jar","cart-service.jar"]