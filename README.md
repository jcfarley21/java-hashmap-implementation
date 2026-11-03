# Custom HashMap Implementation in Java

## Overview

I built this project while studying Data Structures and Program Design. Rather than relying on Java's built-in HashMap, I wanted to challenge myself to build one from scratch and better understand how hashing, linked lists, and key-value storage work together.

My goal was to explore how HashMaps handle collisions, store data, and retrieve information efficiently.


## Features

- Insert key-value pairs using put()
- Retrieve values using get()
- Remove entries using remove()
- Check whether a key exists using containsKey()
- Return the number of stored entries using size()
- Check whether the HashMap is empty using isEmpty()
- Remove all entries using clear()
- Handle hash collisions using separate chaining
- Custom exception handling

## How It Works

### Hashing Algorithm

The HashMap uses a custom hashing function that calculates an
array index based on the characters in a String key.

The hash value determines which bucket stores the entry.

### Collision Handling

When multiple keys produce the same array index, the HashMap
uses separate chaining with a singly linked list.

Each entry contains:

- A key
- A value
- A reference to the next entry

This allows multiple entries to occupy the same bucket.

### Key-Value Storage

The HashMap stores entries in an array of linked lists.

When retrieving a value, the program calculates the key's
hash index and traverses the corresponding linked list
until it finds the matching key.

## Technologies Used

- Java
- IntelliJ IDEA
- Git
- GitHub

## Time Complexity

| Operation | Average Case | Worst Case |
|-----------|--------------|------------|
| Insert    | O(1)         | O(n)       |
| Search    | O(1)         | O(n)       |
| Delete    | O(1)         | O(n)       |

Average-case performance depends on how evenly keys are
distributed across buckets. The current implementation
does not automatically resize the underlying array.

## Future Improvements

- Implement dynamic resizing
- Introduce load factor monitoring
- Improve the hashing algorithm
- Add automated unit tests
- Explore generics for supporting different key and value types

## What I Learned

Building this HashMap helped me better understand how hashing algorithms work and how linked lists can be used to handle collisions. I wanted to understand what was happening behind the scenes instead of just using Java's built-in HashMap.

One of the most interesting parts of this project was seeing how the hashing algorithm affects where data gets stored and how efficiently it can be retrieved. It also got me thinking about different ways to organize and retrieve data more efficiently.

## Author

Developed as part of my ongoing computer science studies
and software engineering portfolio.
