\# ☢️ UB Nuclear Plant Simulation



!\[Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge\&logo=openjdk\&logoColor=white)

!\[Swing](https://img.shields.io/badge/Java\_Swing-GUI-blue?style=for-the-badge)

!\[Academic](https://img.shields.io/badge/Academic\_Project-Year\_1-lightgrey?style=for-the-badge)



A management simulation software for a nuclear power plant ("Unitat de Biomonitorització"), developed as a final project for the \*\*Programming II\*\* course at the \*\*Universitat de Barcelona (UB)\*\*.



> \*\*⚠️ Disclaimer: Academic Project (Year 1)\*\*

> This project represents my first steps into Object-Oriented Programming (OOP) and GUI development. The architecture and code structure reflect my knowledge at that time (20XX) and have been preserved for archival purposes.



\## 📸 Screenshots

\*(Aquí pondremos tu imagen más tarde, de momento déjalo así)\*

<img src="https://via.placeholder.com/800x450.png?text=GUI+Screenshot+Here" alt="Main Interface" width="100%">



\## 🚀 Key Features

\* \*\*Nuclear Management:\*\* Control reactors and cooling pumps manually.

\* \*\*Real-time Monitoring:\*\* Visual feedback on power demand, rod insertion levels, and system status.

\* \*\*Economics \& Progression:\*\* Manage daily profits/losses and advance through days using the "Finalitzar dia" cycle.

\* \*\*Persistence System:\*\* Save and load the full state of the simulation using \*\*Java Serialization\*\*.

\* \*\*Incidents Log:\*\* Automatic logging of system failures (e.g., Reactor overheating > 1000ºC).



\## 🛠️ Technical Concepts

Despite being a freshman project, it implements solid OOP principles:

\* \*\*Architecture:\*\* MVC Pattern (Model-View-Adapter) to separate logic from the Swing GUI.

\* \*\*Polymorphism \& Interfaces:\*\* Uses `InComponent` interface for standardizing components (Turbines, Reactors).

\* \*\*Exception Handling:\*\* Custom `CentralUBException` for logic errors.

\* \*\*Event Driven:\*\* Interactive UI with `ActionListener`.



\## 💻 How to Run

This project was developed using \*\*NetBeans IDE\*\*.

1\. Clone the repository.

2\. Open the project folder in NetBeans.

3\. Run `AppCentralUB.java` (located in `prog2.vista`).

