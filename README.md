# The Markup converter app

## Run instuctions

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
   You need maven build tool to build the project using:
   ```bash
   mvn clean install
   ```

4. **Run the Application:**
   Find an executable JAR file and run it using:
   ```bash
   java -jar <jar_file_name>.jar
   ```

5. **Provide Configurations:**
   You must provide `-in <path_to_input>` argument to specify input md file
   Also, if you want, you can specify `-out <path_to_out>` argument to save converted content into file. If you don't want that, applicaiton will out converted content to terminal.
