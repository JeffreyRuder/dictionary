# EPIC DICTIONARY

#### January 15, 2016

#### By Jeffrey Ruder

## Description

This is a dictionary application that allows users to add words and definitions.

This kind of application could be implemented more effectively using a database. Epic Dictionary was written without one because the goal was to demonstrate using objects within objects in Java and writing routes to process GET and POST requests and responses.

## Demo

Available online at [Heroku](https://epic-dictionary.herokuapp.com/)

## Features

* Uses `java.util.TreeMap` to store key/value pairs of word strings and `Word` objects. The TreeMap implementation automatically sorts words alphabetically on the home page.
* Each `Word` object can contain multiple `Dictionary` objects.
* Users can add and remove definitions for each word and can add and remove words.
* Uses `java.time.LocalDate` to track creation time of each `Word` object.
* Uses regular expressions and `java.net.URLDecoder` to remove URL encoding strings from user input and handle spaces.
* An error message displays if user makes a request for a word page and the word has not been added to the dictionary.

## Setup Instructions

* Clone or pull this repository.
* Ensure you have Gradle and Java installed.
* Navigate to the project directory and `gradle run`

## Technologies Used

Java, Spark, JUnit, FluentLenium, Velocity, Bootstrap, Gradle

## License

MIT License. See LICENSE.md for details.

## Copyright

Copyright (c) 2016 Jeffrey Ruder
