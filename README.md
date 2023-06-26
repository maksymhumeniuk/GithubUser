Github browser with Android Architecture Components
===========================================================

This is a sample app that uses Android Architecture Components with Hilt.

Introduction
-------------

### Functionality

The app is composed of 2 screens.

#### UserScreenFragment

Accept a github user's id as input and display the specified user's avatar and name.
For each public repository owned by the user, the name and description are shown in a scrollable list

#### DetailScreenFragment

Upon selecting a repository, the user will be directed to a detailed screen showcasing specific information about the chosen
repo.
The top of the screen will feature the user's image and name, as well as the total number of forks across all of their repos.
If the total number of forks surpasses 5000, a star badge will appear.

#### Libraries

- Android Support Library
- Android Architecture Components
- Android Data Binding
- Hilt for dependency injection
- Retrofit for REST api communication
- Glide for image loading
