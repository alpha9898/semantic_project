# Football Team Ontology Project

This project is a Java application that uses the OWL API library to load and explore an ontology related to football teams. The primary ontology used in this project is located in the `RES.owl` file.

## Main Functionalities

The program performs the following tasks:

1.  **Load Ontology**: The `RES.owl` ontology file, located in the resources folder (`src/main/resources`), is loaded.
2.  **Display Ontology Components**:
    *   **Ontology ID**: The unique identifier of the loaded ontology is displayed.
    *   **Classes**: All classes (main concepts) defined in the ontology are listed.
    *   **Individuals**: All individuals (specific instances) defined in the ontology are listed.
    *   **Object Properties**: All object properties (relationships between individuals) defined in the ontology are listed.
    *   **Data Properties**: All data properties (attributes describing individuals with values) defined in the ontology are listed.
    *   **SWRL Rules**: Any SWRL (Semantic Web Rule Language) rules embedded in the ontology are listed.
3.  **Consistency Check**: The program checks whether the ontology is logically consistent.

## Requirements

*   Java Development Kit (JDK) version 17 or later.
*   Apache Maven (for dependency management and project building).

## How to Run

1.  Clone the repository.
2.  Navigate to the `football_team` project directory.
3.  Build the project using Maven:
    ```bash
    mvn clean package
    ```
4.  Run the program (this will execute the `com.example.football_team.Main` class):
    ```bash
    mvn exec:java
    ```

The program will print the ontology information and consistency check results to the console.

## Project File Structure

Here's an explanation of the key files in this project:

*   **`pom.xml`**: This is the Project Object Model (POM) file used by Apache Maven. It defines the project's dependencies (like the OWL API), how the project should be built (e.g., Java version, plugins), and other metadata such as the project's group ID, artifact ID, and version.

*   **`football_team/src/main/java/com/example/football_team/Main.java`**: This is the main Java source code file. It contains the `main` method, which serves as the entry point of the application. This file includes the logic to:
    *   Load the `RES.owl` ontology file.
    *   Access and list its various components (classes, individuals, object properties, data properties, SWRL rules).
    *   Print this information to the console.
    *   Check the logical consistency of the ontology.

*   **`football_team/src/main/resources/RES.owl`**: This is the OWL (Web Ontology Language) file that contains the actual ontology for the football team domain. It defines:
    *   **Classes**: General concepts or categories (e.g., Player, Team, Match).
    *   **Individuals**: Specific instances of classes (e.g., 'Player_A', 'Team_X').
    *   **Object Properties**: Relationships between individuals of classes (e.g., 'playsFor' connecting a Player to a Team).
    *   **Data Properties**: Attributes of individuals that take literal values (e.g., a Player's 'dateOfBirth').
    *   **SWRL Rules**: (Semantic Web Rule Language) rules that can infer new knowledge from the existing ontology data.

*   **`README.md`**: This file (the one you are currently reading). It provides a general overview of the project, its main functionalities, system requirements, and instructions on how to build and run the application.
