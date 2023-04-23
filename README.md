# GUI
This project comprises 3 java files, each of which play a part in creating an application which provides a GUI for users to see the power usage of any task they are running.

## Technologies used
1. Java
2. Java Swing framework (for displaying GUI)
3. powermetrics command line utility for Mac
4. IntelliJ IDE
5. Netbeans IDE

## Documentation

The Javadoc generated from the project is hosted on: [Project Javadoc](https://spontaneous-semifreddo-5b214e.netlify.app/package-summary.html).

## Features
1. Simplicity
  - Using the application does not require any technical expertise. Users are only required to run the .jar file.
  - Code is split evenly into the 3 java files: 
    1. GUI.java
      - Generates the first Swing frame and invokes methods from PowerTracker.java
    2. PowerTracker.java 
      - Using the Java Process and ProcessBuilder API, uses superuser permissions to run the powermetrics command. Also filters out irrelevant information from the command.
    3. TasksGUI.java
      - Creates and displays the Swing pane which allows users to scroll through tasks and find out their power consumption.
2. Friendly UI
  - Swing was used to create a simple GUI for users to interact with the program, rather than using a terminal-based application.

## Program Flow

1. Upon launching the application, users are prompted to enter their account password. This is because the application runs the powermetrics command, which requires root privileges.
<img width="407" alt="Screenshot 2023-04-23 at 4 45 06 PM" src="https://user-images.githubusercontent.com/22656175/233829479-8aa39e37-a05c-4206-92a7-b88806cf5056.png">
2. If the password entered is invalid, an error message is shown. Upon pressing "ok", the pop-up disappears, allowing users to re-enter their password.
<img width="405" alt="Screenshot 2023-04-23 at 4 46 19 PM" src="https://user-images.githubusercontent.com/22656175/233829541-457b41d1-4ae4-4417-a460-c4c9ae8138b7.png">
3. If the password entered is valid, a new window is created, where users can scroll through all their tasks, and choose any task they want to check the power consumption of. The double value displayed changes with the selected application.
<img width="533" alt="Screenshot 2023-04-23 at 4 47 14 PM" src="https://user-images.githubusercontent.com/22656175/233829576-ab7c0712-3909-4774-a5b9-bbc7fef48d15.png">

## Motivation
Tools such as the Intel Power Gadget allow users to measure CPU and GPU Consumption of the computer, and not individual processes. This project allows users to be aware of CPU usage in quantitative terms.

## How to run the program
The executable .jar file can be downloaded from this repository, by going to GUI > out > artifacts/GUI_jar > GUI.jar.

## Limitations 
1. Reliance on the powermetrics command
  - The CPU usage data used and displayed by this program is obtained via the powermetrics command. As such, only Mac OS (which come pre-installed with the command line utility) are able to use the program.
  - As the powermetrics command requires root privileges to be run, our program has to obtain the user's password.
2. Usage of programming language
  - Java was chosen as a programming language due to familiarity with the Java syntax and documentation.
3. Accuracy
  - The power usage is represented via CPU usage of the application. However, we may wish to include GPU usage in our calculations.
  
## Possible improvements
1. Choice of programming language
  - Rather than Java, a lower-level programming language such as C++ could be used, as it provides low-level access to the operating system and low overhead.
2. Operating System limitations
  - There may be other ways to obtain application-specific CPU and GPU usage which could be supported by a wider range of operating systems.
