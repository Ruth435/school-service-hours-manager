# 🏫 School Portfolio Service Hours Manager

A Java desktop application with a Microsoft Access backend, originally developed as a High School Grade 12 IT Practical Assessment Task (PAT) project in 2022.

---

## 📌 Problem Overview

High school service portfolios (e.g., Catering, First Aid, Audio/Visual, Community Outreach) often rely on fragmented paper log sheets or basic spreadsheets to track student service hours. This manual process leads to:
* High risk of unrecorded or lost service hours.
* Difficulty for staff in auditing student hours for awards or graduation requirements.
* Lack of transparency for students trying to view their current hour totals across multiple portfolios.

---

## 💡 Solution

The **School Portfolio Service Hours Manager** automates and centralizes service hour tracking into a single desktop application:
* **Student Module:** Allows students to view accumulated hours, log event attendance, and track participation across various portfolios.
* **Portfolio & Admin Module:** Enables portfolio leaders and staff to verify hours, log new service events, approve student requests, and generate activity summaries.

---

## 🛠️ Tech Stack & Architecture

* **Language:** Java (JDK 8+)
* **GUI Framework:** Java Swing (NetBeans GUI Builder)
* **Database:** Microsoft Access (`.accdb`) using JDBC-ODBC / UCanAccess connection drivers
* **Architecture:** Object-Oriented Programming (OOP) with modular managers (`StudentManager`, `EventManager`, `ParticipationManager`, `AdminManager`)

---

## 🗄️ Database Structure

The Microsoft Access backend (`2022PAT.accdb`) consists of four primary entities:

* **Students:** Stores student profiles, grade levels, and total accumulated hours.
* **Events:** Tracks service events, assigned portfolio, date, duration, and supervisor details.
* **Participation:** A junction table linking students to specific events with verification status.
* **Admins/Portfolios:** Manages administrative permissions for portfolio leaders.

---

## 🚀 Key Features

* **User Authentication:** Role-based access control (Student vs. Administrator views).
* **Hour Logging & Validation:** Prevents duplicate entries and calculates total hours dynamically.
* **Event Management:** Create, update, and search upcoming or past service opportunities.
* **Record Filtering & Reporting:** Query student records by portfolio, grade, or date range.

---

## 📝 Project Context
Developer: High School IT Student Project (PAT 2022)

Status: Completed (Archived)

Note: Built as an academic capstone project to demonstrate full-stack Java Swing desktop application development and relational database design.

---
