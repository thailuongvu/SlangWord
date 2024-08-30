# Slang Dictionary Application

This Java application is a simple slang dictionary that allows users to search for slang words, their meanings, and perform various operations like adding, editing, deleting, and resetting slang words. The application also includes a quiz feature and the ability to export the slang dictionary to a file.

## Features

- **Find Slang**: Search for a slang word and retrieve its definition.
- **Find Definition**: Search for a definition and retrieve the corresponding slang word(s).
- **History**: View the history of searched slang words.
- **Add Slang**: Add a new slang word with its definition.
- **Edit Slang**: Edit the definition of an existing slang word.
- **Delete Slang**: Delete a slang word from the dictionary.
- **Reset Dictionary**: Reset the slang dictionary to its original state.
- **Random Slang**: Display a random slang word with its definition.
- **Slang Quiz**: Take a quiz to match a random slang word with its correct definition.
- **Definition Quiz**: Take a quiz to match a definition with the correct slang word.
- **Export Dictionary**: Export the entire slang dictionary to a text file.

## Getting Started

### Prerequisites

- Java Development Kit (JDK)
- A text file named `slang.txt` containing slang words and their definitions in the format: `slang` `definition`.

### Setup

1. **Create the `slang.txt` file:**
   - Ensure that the `slang.txt` file is in the same directory as the `Dic.java` file.
   - The file should contain slang words and their definitions separated by a backtick (`\``). Multiple definitions should be separated by a pipe (`|`) or a comma (`,`).

2. **Compile and Run:**
   - Compile the Java file:
     ```bash
     javac Dic.java
     ```
   - Run the compiled Java program:
     ```bash
     java Dic
     ```

## Usage

### Menu Options

- **Find Slang:**
  - Input a slang word to retrieve its definition.
  
- **Find Definition:**
  - Input a definition to retrieve the corresponding slang word(s).

- **History:**
  - View the list of slang words searched so far.

- **Add Slang:**
  - Add a new slang word with a definition. If the slang word already exists, you can choose to override or duplicate the definition.

- **Edit Slang:**
  - Edit the definition of an existing slang word.

- **Delete Slang:**
  - Delete a slang word from the dictionary.

- **Reset Dictionary:**
  - Reset the slang dictionary to its original state (as loaded from the `slang.txt` file).

- **Random Slang:**
  - Display a random slang word along with its definition.

- **Slang Quiz:**
  - Take a quiz to guess the correct definition of a randomly chosen slang word.

- **Definition Quiz:**
  - Take a quiz to guess the correct slang word for a given definition.

- **Export Dictionary:**
  - Export the entire slang dictionary to a file named `output.txt`.

## File Structure

- `Dic.java`: The main class containing all the methods to perform the operations listed above.
- `slang.txt`: The input file containing slang words and their definitions.
- `output.txt`: The file where the exported dictionary will be saved.


## License

This project is open-source and available under the MIT License.
