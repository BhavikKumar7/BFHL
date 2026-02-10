# BFHL REST API --- Java Spring Boot Implementation

Production-ready REST API built using **Java + Spring Boot** that
performs mathematical operations and AI question answering while
following strict response schemas, error handling rules, and security
guardrails.

------------------------------------------------------------------------

## Live Endpoints

  Method   Endpoint    Description
  -------- ----------- --------------------------
  GET      `/health`   Service health check
  POST     `/bfhl`     Main functional endpoint

------------------------------------------------------------------------

## Tech Stack

-   Java 17
-   Spring Boot 3.2.5
-   Maven
-   Google Gemini AI (Official SDK)
-   REST Architecture

------------------------------------------------------------------------

## Environment Variable (Required)

The AI feature requires a Gemini API key.

### Windows

setx GEMINI_API_KEY "YOUR_API_KEY"

### Linux / Mac

export GEMINI_API_KEY=YOUR_API_KEY

------------------------------------------------------------------------

## Run Locally

git clone `<your-repo-url>`{=html} cd bfhl-api mvn clean package mvn
spring-boot:run

Server runs at: http://localhost:8080

------------------------------------------------------------------------

## API Specification

### 1. Health Check

GET /health

Response { "is_success": true, "official_email":
"bhavik0142.be23@chitkara.edu.in" }

------------------------------------------------------------------------

### 2. Main Endpoint

POST /bfhl

Exactly ONE key must be provided per request.

------------------------------------------------------------------------

## Functional Keys

  Key         Input           Output
  ----------- --------------- -----------------------
  fibonacci   Integer         Fibonacci series
  prime       Integer Array   Prime numbers
  lcm         Integer Array   LCM value
  hcf         Integer Array   HCF value
  AI          String          Single-word AI answer

------------------------------------------------------------------------

## Error Handling

Invalid Request (Multiple Keys) --- HTTP 400 Endpoint Not Found --- HTTP
404 Method Not Allowed --- HTTP 405 AI Failure / Timeout --- HTTP 200
("unknown")

------------------------------------------------------------------------

## Deployment

Build: mvn clean package

Run: java -jar target/bfhl-api-1.0.jar

Deployable on: Render / Railway

------------------------------------------------------------------------

## Author

Bhavik Kumar\
Chitkara University\
CSE Department