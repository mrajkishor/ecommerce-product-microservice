# 🛒 **Product Microservice for E-commerce Application**

This repository contains the **Product Microservice** for an e-commerce application. The microservice is built using **Spring Boot** and follows a **microservices architecture**. It handles product-related operations such as product creation, retrieval, and checking stock availability. This service is designed to work within a larger system of microservices, deployed using **Docker** and **Kubernetes**.

---

## 📚 **Table of Contents**

1. [Features](#features)
2. [Technology Stack](#technology-stack)
3. [Endpoints](#endpoints)
4. [Setup Instructions](#setup-instructions)
5. [Run Locally](#run-locally)
6. [Test Locally](#test-locally)
7. [Docker Support](#docker-support)
8. [Kubernetes Deployment](#kubernetes-deployment)
9. [Contributing](#contributing)
10. [License](#license)

---

## ✨ **Features**

- Create and manage products for the e-commerce system.
- Retrieve product details by ID.
- Check if a product is in stock.
- Easily scalable and containerized using Docker.
- Can be deployed and managed with Kubernetes.

---

## 🛠️ **Technology Stack**

- **Backend**: Java 17, Spring Boot
- **Database**: MySQL/PostgreSQL (configurable)
- **Containerization**: Docker
- **Orchestration**: Kubernetes
- **Testing**: JUnit, Mockito
- **Build Tool**: Maven

---

## 🚀 **Endpoints**

Here are the available REST API endpoints for managing products:

| HTTP Method | Endpoint                            | Description                           |
|-------------|-------------------------------------|---------------------------------------|
| **POST**    | `/products`                         | Create a new product                  |
| **GET**     | `/products/{id}`                    | Retrieve product by ID                |
| **GET**     | `/products/{id}/in-stock`           | Check if the product is in stock      |

### Example Request Payload (Product Creation):

```json
{
  "name": "Laptop",
  "description": "High-end gaming laptop",
  "price": 1500.0,
  "stockQuantity": 10
}
```

---

## ⚙️ **Setup Instructions**

Follow these steps to get the **Product Microservice** up and running:

### 1. **Clone the Repository**

```bash
git clone https://github.com/mrajkishor/ecommerce-product-microservice.git
cd ecommerce-product-microservice
```

### 2. **Configure the Database**

Ensure you have a running instance of MySQL or PostgreSQL. Update the database settings in `src/main/resources/application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/ecommerce
spring.datasource.username=root
spring.datasource.password=yourpassword
spring.jpa.hibernate.ddl-auto=update
```

### 3. **Build the Project**

Use Maven to build the project:

```bash
mvn clean install
```

---

## 💻 **Run Locally**

To run the service locally, use the following command:

```bash
mvn spring-boot:run
```

Once the application is running, you can access the service at `http://localhost:8082`.

---

## 🧪 **Test Locally**

You can run the unit tests (written using JUnit and Mockito) by executing:

```bash
mvn test
```

The tests ensure that the product creation, retrieval, and stock check features work as expected.

---

## 🐳 **Docker Support**

This project includes a `Dockerfile` for easy containerization. Follow these steps to build and run the Docker container:

### 1. **Build Docker Image**

```bash
docker build -t product-service:latest .
```

### 2. **Run Docker Container**

```bash
docker run -d -p 8082:8082 --name product-service product-service:latest
```

The service will now be accessible at `http://localhost:8082`.

---

## ☸️ **Kubernetes Deployment**

To deploy the product service in a Kubernetes cluster, create a Kubernetes manifest (`product-service.yaml`) and apply it using `kubectl`.

### Example Kubernetes Deployment Manifest:

```yaml
apiVersion: apps/v1
kind: Deployment
metadata:
  name: product-service-deployment
spec:
  replicas: 2
  selector:
    matchLabels:
      app: product-service
  template:
    metadata:
      labels:
        app: product-service
    spec:
      containers:
      - name: product-service
        image: product-service:latest
        ports:
        - containerPort: 8082
---
apiVersion: v1
kind: Service
metadata:
  name: product-service
spec:
  selector:
    app: product-service
  ports:
  - protocol: TCP
    port: 8082
    targetPort: 8082
  type: ClusterIP
```

### 1. **Apply Kubernetes Manifest**

```bash
kubectl apply -f product-service.yaml
```

### 2. **Verify Deployment**

```bash
kubectl get pods
kubectl get services
```

---

## 🤝 **Contributing**

Contributions are welcome! Feel free to open issues or submit pull requests.

### How to Contribute:
1. Fork the repository.
2. Create a new branch: `git checkout -b my-new-feature`.
3. Make your changes and commit: `git commit -m 'Add some feature'`.
4. Push to the branch: `git push origin my-new-feature`.
5. Submit a pull request.

---

## 📄 **License**

This project is licensed under the **Apache License**. See the [LICENSE](LICENSE) file for details.

---

### 📧 **Contact**

For questions or feedback, feel free to contact the project owner at **mrajkishor331@gmail.com**.

