# Multi-Lang Compiler

A modern multi-tab code editor and compiler app for Android built with Kotlin, Material3, and ViewBinding. This project allows users to write code in multiple languages (C, C++, Python) and compile/run them remotely using the [JDoodle API](https://www.jdoodle.com/compiler-api).

## Features

- **Modern UI:** Uses Material3 design with DayNight support for both light and dark modes.
- **Multi-Tab Editor:** Separate tabs for C, C++, and Python code editing.
- **Interactive Code Editor:** Enhanced code editor with TextInputLayout and monospaced fonts.
- **Remote Compilation:** Executes code remotely via the JDoodle API.
- **Loading Indicator:** Displays a progress spinner while code is compiling.
- **Output Display:** Real-time display of compilation output in a CardView.
- **Floating Action Button (FAB):** Quick access to compile & run code.

## Prerequisites

- **Android Studio:** Arctic Fox or later.
- **Android SDK:** API level 35 (or above).
- **JDoodle API Credentials:** Sign up at [JDoodle](https://www.jdoodle.com/compiler-api) and obtain your Client ID and Client Secret.
- **Internet Connection:** Required for remote code compilation.

## Download APK

Click below to download the latest version of the app:

[![Download APK](https://img.shields.io/badge/Download-APK-blue?style=for-the-badge&logo=android)](APK/app-debug.apk)

## Setup

1. **Clone the Repository:**

   ```bash
   git clone https://github.com/yourusername/multi-lang-compiler.git
   cd multi-lang-compiler
