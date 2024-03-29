# Java Markdown to HTML Converter

## Description

This Java application is a simple yet powerful tool designed to convert Markdown files into HTML format. It provides an easy and efficient way to transform your Markdown documents into beautifully rendered HTML, making them suitable for web publishing or integration into HTML-based environments.

**Key Features:**

1. **Markdown to HTML Conversion:** The application seamlessly reads Markdown files, parsing their content and converting it into well-structured HTML.

2. **Configurable Options:** The converter offers configurable options to tailor the HTML output according to your preferences.

3. **Cross-Platform Compatibility:** Built using Java, this application is platform-independent, ensuring compatibility across various operating systems. Whether you are using Windows, macOS, or Linux, you can run the converter without any compatibility issues.

4. **Lightweight and Efficient:** The application is designed to be lightweight and efficient, ensuring fast and reliable Markdown to HTML conversion without unnecessary resource consumption.

**How to Use:**

1. **Input Markdown File:** Specify the path to the Markdown file you want to convert.

2. **Configure Options (Optional):** Customize HTML output file if needed.

3. **Run Conversion:** Initiate the conversion process with a simple click, and the application will generate the corresponding HTML file.

4. **View HTML Output:** Once the conversion is complete, open the generated HTML file in your preferred web browser to view the transformed content.

**Technical Details:**

- **Language:** Java
- **Compatibility:** Java Runtime Environment (JRE) 18 or higher

## Run instructions

Here's a general guide to help you get started:

1. **Clone the Repository:**
   Use a version control tool like Git to clone the repository to your local machine. Open a terminal or command prompt and run the following command:
   ```bash
   git clone <repository_url>
   ```

2. **Navigate to the Project Directory:**
   Change your working directory to the one where the Java application is located. Use the `cd` command:
   ```bash
   cd <project_directory>
   ```

3. **Build the Project (if needed):**
   You need maven build tool to build the project and run tests using:
   ```bash
   mvn clean package
   ```

4. **Run the Application:**
   Find an executable JAR file and run it using:
   ```bash
   java -jar target/<jar_file_name>.jar
   ```

5. **Provide Configurations:**
   You must provide `-in <path_to_input>` argument to specify input md file
   Also, if you want, you can specify `-out <path_to_out>` argument to save converted content into file. If you don't want that, applicaiton will out converted content to terminal.

## Run example

- To see the result in `out.html`
   ```bash
   java -jar target/markup-converter-1.0.jar -in /path/to/source.md -out /path/to/out.html
   ```

- To see the result in the terminal window
   ```bash
   java -jar target/markup-converter-1.0.jar -in /path/to/source.md
   ```

## Thoughts and conclusions about Unit tests

In the beginning, when I was just starting to get into Java development, I came to the stage of learning Unit tests. It looked strange to me and I immediately rejected the idea of TDD because it was stupid to write tests, I thought.

Now I'm developing a project with students to manage and book hotel rooms. This system is quite large, so tests are a must. Of course, I write tests and components there better and cleaner than for the lab.
Now I have come to the conclusion that tests should be as good as the program components (production code). So, to get new ideas and best practices, I read Clean Code R. Martin. This book is not about tests (except for a little bit), but about thinking. I really liked it, so I recommend it.

PS Some interesting practices you can see in the [ApplicationFactory_UnitTest](https://github.com/mibal-ua/markup-converter/blob/master/src/test/java/ua/mibal/application/component/ApplicationFactory_UnitTest.java) class
