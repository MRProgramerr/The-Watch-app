**Time Blocks**
==============

**Introduction**
==============

Welcome to "**Time Blocks**".

<h4>Time Blocks is a timer task application which allows the user to schedule task easily with any duration the user wants.
Time Blocks has been developed by three developers where we have built additional features on this application which includes importing and exporting the tasks to and from a .CSV file and also allowing the user to choose the background colour from the colour palette. </h4>

How to Run?
=============

**Time Blocks** is an open source application that is being hosted on GITLAB.

**Pre-Requisites**

SSH / HTTPS Git Key - Found in **My Projects** in your account, if you were granted access by the developer.
<br>**Java JDK** as well as **JavaFX** present on your computer.
If you have not installed Java JDK or JavaFX, the links to download them are provided below: <br>
**JDK** [https://www.oracle.com/java/technologies/javase-downloads.html](url) <br>
**JavaFX** [https://gluonhq.com/products/javafx/](url) <br>
An Integrated Development Environment (**IDE**) is required to interact and run this application. The preferred **IDE**(s) are IntelliJ and Eclipse. Both of these **IDE**s are free to download and use. The links to download them are below: <br>
IntelliJ - [https://www.jetbrains.com/de-de/idea/download/](url) <br>
Eclipse - [https://www.eclipse.org/downloads/](url) <br>
A terminal or a command line is also needed to clone the repository available for this application. If you are using Windows, Command Prompt can be used for this purpose. If you are using Mac or Linux, you can open your Terminal. <br>


**Step 1 : Cloning repository**
=============================

Run this specific command below in your terminal or command prompt <br>
<strong>Git clone HTTP/SSH Key </strong> <br>
Do take note that you will have to replace HTTP/SSH Key, with the Key that you get from your **My Projects**. <br>
This command will then clone the entire repository to the downloads folder or a specified folder if you have specified it. <br>

**Step 2 : Setting up IDE**
===========================
Follow the steps as followed if you have not installed an **IDE**
- Download an **IDE** from the links [https://www.jetbrains.com/de-de/idea/download/](url) or [https://www.eclipse.org/downloads/](url) as mentioned above and install it.

If you have an **IDE** installed, follow these steps instead:
- Open an **IDE** that you have installed.
- Import the project that you have cloned previously.
- Choose a version of JDK if it has not been assigned automatically by your **IDE**.

**Step 3 : Importing JavaFX Library**
=====================================
> To run the application, you are required to have JavaFX as a User Library installed in your system.

Below this are steps onto how you can import the  JavaFX Library that you have downloaded previously. <br>

<h2> IntelliJ </h2>
- File >> Project Structure >> Libraries under project settings >> + icon  >> Java <Br>
Altenatively you can access the Project Structure by pressing <strong>CTRL+ALT+SHIFT+S</strong>. <br>
Following this you should have reached a dialog box with file chooser. You are now going to navigate to your JavaFX library folder. Choose the necessary modules required to run this application which should include <Strong>Time-Blocks</strong>, and then click OK which should close the dialog box. <br>

If you are using a version of Java thats 11 or higher, you need to add JavaFX to your VM. To do this, you will need to go to Edit Configurations which is at Run, and then select application which leads to Main, where you will see a VM options box where you will type --module-path "<strong>Path_File</strong>" --add-modules javafx.controls, javafx.fxml and then apply and close the dialog box. <br>
Do take note that Path_File is to be replaced with the path of your library for JavaFX. <br>
<h2> Eclipse </h2>


