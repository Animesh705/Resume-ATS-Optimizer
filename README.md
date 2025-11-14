📌 Project Title

Resume ATS Optimizer
⸻
📖 Overview
A full-stack web application that evaluates a candidate’s resume against a job description using text processing and lightweight AI.
The tool identifies matched and missing keywords, calculates an ATS-style compatibility score, and generates improved resume bullet points to increase job match accuracy.
Built using React (frontend), Spring Boot (backend), and custom NLP utilities (Java).
⸻
✨ Features
	•	Paste or upload resume text
	•	Enter job description
	•	ATS Match Score (%)
	•	Matched vs Missing Keywords
	•	Smart Keyword Extraction using TF-IDF
	•	AI-generated bullet point suggestions
	•	Clean and simple UI for quick evaluation
	•	Explainable scoring logic
⸻
🧠 Tech Stack
Frontend
	•	React
	•	Fetch API / Axios
	•	Vite or Create React App
	•	CSS / Tailwind (optional)

Backend
	•	Java
	•	Spring Boot
	•	Maven
	•	Custom NLP logic (tokenization, TF-IDF, similarity scoring)

Other Tools
	•	Git & GitHub
	•	IntelliJ IDEA
	•	Postman / cURL for testing
  
⸻⸻

📂 Project Structure :

resume-ats-optimizer/
├── backend/
│   ├── src/main/java/com/yourname/ats/
│   │   ├── controller/
│   │   ├── service/
│   │   ├── model/
│   │   ├── util/
│   │   └── AtsApplication.java
│   └── pom.xml
│
└── frontend/
    ├── src/
    ├── package.json
    └── public/
