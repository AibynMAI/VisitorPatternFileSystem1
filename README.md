# Visitor Pattern — File System

Assignment #6  Software Design Patterns (Astana IT University).
 implementation of the **Visitor** behavioral design pattern.

## Idea
A small in-memory file system (`File` and `Directory`) is traversed by different
visitors. Each visitor adds a new operation without changing the element classes.
Double dispatch (`accept()` calls `visitX(this)`) replaces `instanceof` checks.

## Pattern roles
| Role | Class |
|---|---|
| Element interface | `FileSystemElement` |
| Concrete elements | `File`, `Directory` |
| Visitor interface | `FileSystemVisitor` |
| Concrete visitors | `SizeCalculatorVisitor`, `SearchVisitor`, `TreePrinterVisitor` |
| Object structure | `Directory` (a tree of files and directories) |
| Client | `Main` (uses `SampleFileSystem`) |

## Project structure
```
src/   elements, visitors, SampleFileSystem, Main
test/  JUnit 5 tests (visitors, double dispatch, validation, concurrency)
docs/  UML diagram
```

## How to run
1. Open the project in IntelliJ IDEA (JDK 17).
2. Run `Main`.
3. Run the tests: right click `test` -> Run 'All Tests'.

## How to add a new visitor
1. Create a class that implements `FileSystemVisitor`.
2. Pass it to `root.accept(visitor)`.

`File` and `Directory` do not change.

## Author
Aibyn Mukhametsharip, SE-2504