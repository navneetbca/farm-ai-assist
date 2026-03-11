# Farm AI Assist

Farm AI Assist is a **Spring Boot + Spring AI** project demonstrating how to build an **AI-powered and Intelligent backend system** using **Retrieval-Augmented Generation (RAG)**, vector databases, and web search.

The application answers farming-related queries using **LLM responses enriched with contextual retrieval** from a vector store and external web search.

---

## Features

* OpenAI API integration
* Retrieval-Augmented Generation (RAG)
* Vector search using Qdrant
* Web search augmentation
* Prompt templates & prompt stuffing
* Streaming LLM responses
* Structured AI outputs (JSON / POJO)
* Chat memory using JDBC
* Automatic container startup using Spring Boot Docker Compose

---

## Architecture

```
Client -> Spring Boot REST API -> Spring AI ChatClient -> Advisors (Chat Memory, Vector Retrieval (Qdrant), Web Search Retrieval -> Prompt Template + Retrieved Context -> OpenAI LLM -> Streaming Response

```

---

## Tech Stack

**Backend**

* Java
* Spring Boot
* Spring AI

**AI**

* OpenAI API
* RAG (Retrieval-Augmented Generation)
* Prompt Engineering

**Data**

* Qdrant Vector Database
* H2 Database (chat memory)

**Infrastructure**

* Docker
* Spring Boot Docker Compose

---

## API Endpoints

### Chat with Memory

```
GET /api/random-chat?message=Your question
```

### Chat with Vector Documents (RAG)

```
GET /api/document-chat?message=Your question
```

### Chat with Web Search

```
GET /api/web-search-chat?message=Your question
```

---

## Configuration

Example `application.yml` configuration:

```yaml
spring:
  ai:
    openai:
      api-key: ${OPENAI_API_KEY}

    vectorstore:
      qdrant:
        host: localhost
        port: 6334
        collection-name: navneet
        initialize-schema: true
```

---

## Running the Project

### Requirements

* Java 21+
* Docker
* OpenAI API Key
* Tavily API Key

### Environment Variables

```
export OPENAI_API_KEY=your_openai_key
export TAVILY_SEARCH_API_KEY=your_tavily_key
```

### Start Application

```
./mvnw spring-boot:run
```

When the application starts:

* Spring Boot automatically starts the **Qdrant container**
* The vector collection is created if missing

---

## Purpose

This project demonstrates how to build **modern AI-enabled backend systems** using:

* Spring AI
* Vector databases
* Retrieval-Augmented Generation
* Streaming LLM responses
* Structured AI outputs

---

## Author

Navneet ( Java Backend Developer | Spring Boot | AI Integration )
