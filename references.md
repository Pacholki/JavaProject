# Learning references

---
## Maven dependencies
#### How to add jar files to maven projects in vscode

[dependencies library](https://search.maven.org/?eh=)

[tutorial](https://www.youtube.com/watch?v=zlHXH6maOR0)

---
## UI libraries
- MaterialFX
- Spring Boot


---
## Use python code in Java programm
- jython
- jpype
- py4j

https://talvi.net/posts/a-brief-overview-of-python-java-bridges-in-2020.html

https://www.baeldung.com/java-working-with-python

#### jython example
```java
import org.python.core.PyObject;
import org.python.util.PythonInterpreter;

public class PythonIntegration {
    public static void main(String[] args) {
        // Initialize the PythonInterpreter
        PythonInterpreter pythonInterpreter = new PythonInterpreter();

        // Execute Python code
        pythonInterpreter.exec("def add(a, b): return a + b");

        // Call the Python function from Java
        PyObject addFunction = pythonInterpreter.get("add");
        PyObject result = addFunction.__call__(new PyObject[] {PyObject.fromJava(2), PyObject.fromJava(3)});

        // Print the result
        System.out.println("Result: " + result.toJava(int.class));
    }
}
```

#### jpype solution
```java
import jpype.JClass;
import jpype.JException;
import jpype.JpypeException;

public class Main {
    public static void main(String[] args) {
        try {
            // Start the Python interpreter
            jpype.startJVM();

            // Import the Python module
            JClass tools = JClass.forName("tools");

            // Set the parameters for the Python function
            String league = "ENG-Premier League";
            String season = "2021";
            String team = "Manchester City";

            // Call the Python function
            tools.invoke("get_team_games", league, season, team);

        } catch (JpypeException e) {
            e.printStackTrace();
        } finally {
            // Shutdown the Python interpreter
            jpype.shutdownJVM();
        }
    }
}
```

#### jython solution
```java
import jpype.JClass;
import jpype.JException;
import jpype.JpypeException;

public class Main {
    public static void main(String[] args) {
        try {
            // Start the Python interpreter
            jpype.startJVM();

            // Import the Python module
            JClass tools = JClass.forName("tools");

            // Set the parameters for the Python function
            String league = "ENG-Premier League";
            String season = "2021";
            String team = "Manchester City";

            // Call the Python function
            tools.invoke("get_team_games", league, season, team);

        } catch (JpypeException e) {
            e.printStackTrace();
        } finally {
            // Shutdown the Python interpreter
            jpype.shutdownJVM();
        }
    }
}
```
---
