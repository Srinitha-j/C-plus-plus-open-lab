OpenLab Class — Lab Files
=========================

Short description
-----------------
This repository contains small lab assignments and demo files for the OpenLab class (third year, SEM 6). The files are simple C/C++/Java programs and HTML pages used for classroom exercises.

Contents
--------
- `employee management.html` — simple HTML UI for employee management (frontend demo).
- `Untitled-1.html` — miscellaneous/unsaved HTML example.
- `EmployeeSalaryManagement.java` — Java console program for managing employee salaries.
- `lab2.cpp` — C++ lab exercise #2.
- `lab3.cpp` — C++ lab exercise #3.
- `openlab1.cbp` and `openlab1.layout` — Code::Blocks project files for the `openlab1` project.

Prerequisites
-------------
- Java JDK (for `EmployeeSalaryManagement.java`) — `javac` and `java` on PATH.
- A C++ compiler (g++/clang++) for `lab2.cpp` and `lab3.cpp`.
- A web browser to open the HTML files.
- (Optional) Code::Blocks IDE to open the `.cbp` project (`openlab1.cbp`).

Build & Run
-----------

Java
- Compile:

  javac EmployeeSalaryManagement.java

- Run:

  java EmployeeSalaryManagement

C++ (g++)
- Build `lab2.cpp`:

  g++ -std=c++17 -O2 -o lab2 lab2.cpp

- Run:

  ./lab2

- Build `lab3.cpp`:

  g++ -std=c++17 -O2 -o lab3 lab3.cpp

- Run:

  ./lab3

HTML
- Open `employee management.html` or `Untitled-1.html` in your browser (double-click or drag into browser).

Code::Blocks
- Open `openlab1.cbp` with Code::Blocks to load the project and build from the IDE.

Notes
-----
- These files appear to be small lab or example programs; review each source file for input expectations before running.
- If any file requires additional libraries or a specific folder structure, update the README or ask and I'll add precise steps.

License
-------
No license specified.

Questions?
----------
Tell me if you want: run commands executed, tests added, or the README expanded with examples.
