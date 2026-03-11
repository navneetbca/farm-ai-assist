# Farm AI Assist

Farm AI Assist is a **Spring Boot + Spring AI** project demonstrating how to build **AI-powered backend systems**
using Retrieval-Augmented Generation (RAG), vector databases, and web search.

The system answers farming-related questions using:

* LLM responses
* Vector database retrieval
* Web search augmentation
* Prompt engineering
* Structured AI outputs
* Streaming responses

---

# Features

### AI & LLM Integration

* OpenAI API integration
* Prompt engineering and prompt templates
* Prompt stuffing with retrieved context
* Streaming AI responses
* Structured AI outputs (JSON / POJO)

### Retrieval Augmented Generation (RAG)

* Vector embeddings stored in Qdrant
* Similarity search for document retrieval
* Context injection into prompts

### Web Search Augmentation

* Real-time web search using Tavily
* External knowledge retrieval when local data is insufficient

### Chat System

* Conversation memory
* User-based chat sessions
* Context-aware responses

---

# Architecture

User Query
⬇
Spring Boot REST API
⬇
ChatClient (Spring AI)
⬇
Advisors
• Chat Memory
• RAG Retrieval
• Web Search Retrieval
⬇
Vector Store / Web Search
⬇
Prompt Template + Context
⬇
LLM (OpenAI)
⬇
Streaming AI Response

---

# Tech Stack

Backend

* Java
* Spring Boot
* Spring AI

AI & Data

* OpenAI API
* Qdrant Vector Database
* Retrieval Augmented Generation (RAG)
* Prompt Engineering

Infrastructure

* Docker
* H2 Database

---

# API Endpoints

### Chat with Memory

GET /api/random-chat

### Chat with Documents (RAG)

GET /api/document-chat

### Chat with Web Search

GET /api/web-search-chat

---

# How to Run

Clone repository:

git clone https://github.com/navneetbca/farm-ai-assist.git
cd farm-ai-assist

Set environment variables:

export OPENAI_API_KEY=your_key
export TAVILY_SEARCH_API_KEY=your_key

Run the application:

./mvnw spring-boot:run

---

# Vector Database

The project uses Qdrant for storing embeddings.

Start Qdrant:

docker compose up

---

# Purpose

This project demonstrates how modern backend systems can integrate AI capabilities such as:

* RAG pipelines
* Prompt engineering
* Streaming LLM responses
* Structured AI outputs
* Vector search

---

# Author

Navneet
Java Backend Developer
Spring Boot | AI Integration | RAG Systems
