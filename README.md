# GUI
This project comprises 3 java files, each of which play a part in creating an application which provides a GUI for users to see the power usage of any task they are running.

**Technologies used**
1. Java
2. Java Swing framework (for displaying GUI)
3. powermetrics
4. IntelliJ IDE
5. Netbeans IDE

**Program flow**

1. Upon launching the application, users are prompted to enter their account password. This is because the application runs the powermetrics command, which requires root privileges.
<img width="407" alt="Screenshot 2023-04-23 at 4 45 06 PM" src="https://user-images.githubusercontent.com/22656175/233829479-8aa39e37-a05c-4206-92a7-b88806cf5056.png">
2. If the password entered is invalid, an error message is shown. Upon pressing "ok", the pop-up disappears, allowing users to re-enter their password.
<img width="405" alt="Screenshot 2023-04-23 at 4 46 19 PM" src="https://user-images.githubusercontent.com/22656175/233829541-457b41d1-4ae4-4417-a460-c4c9ae8138b7.png">
3. If the password entered is valid, a new window is created, where users can scroll through all their tasks, and choose any task they want to check the power consumption of. The double value displayed changes with the selected application.
<img width="533" alt="Screenshot 2023-04-23 at 4 47 14 PM" src="https://user-images.githubusercontent.com/22656175/233829576-ab7c0712-3909-4774-a5b9-bbc7fef48d15.png">

##Motivation

##Limitations and possible improvements
