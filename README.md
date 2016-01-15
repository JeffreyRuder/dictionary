# EPIC DICTIONARY

#### January 15, 2016

#### By Jeffrey Ruder

## Description

This is a dictionary application that allows users to add words and definitions. It demonstrates using objects within objects in Java.

## Notable Features

* Does not use a database. Uses `java.util.TreeMap` to store key/value pairs of word strings and `Word` objects. The TreeMap implementation automatically sorts words alphabetically on the home page.
* Uses `java.time.LocalDate` to track creation time of each `Word` object.
* Each `Word` object can contain multiple `Dictionary` objects.
* An error message displays if user makes a get request for a word page and the word has not been added to the dictionary.

## Setup Instructions

* Clone or pull this repository.
* Ensure you have Gradle and Java installed.
* Navigate to the project directory and `gradle run`

## Technologies Used

Java, Spark, JUnit, FluentLenium, Velocity, Bootstrap

## License

MIT License. See LICENSE.md for details.

## Copyright

Copyright (c) 2016 Jeffrey Ruder
