import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SizeCalculatorVisitorTest {

    @Test
    void sumsFilesInAllNestedDirectories() {
        Directory root = SampleFileSystem.create();
        SizeCalculatorVisitor visitor = new SizeCalculatorVisitor();

        root.accept(visitor);

        assertEquals(92000, visitor.getTotalSizeBytes());
    }

    @Test
    void emptyDirectoryHasZeroSize() {
        Directory empty = new Directory("empty");
        SizeCalculatorVisitor visitor = new SizeCalculatorVisitor();

        empty.accept(visitor);

        assertEquals(0, visitor.getTotalSizeBytes());
    }

    @Test
    void singleFileReturnsItsOwnSize() {
        File file = new File("a.txt", 123);
        SizeCalculatorVisitor visitor = new SizeCalculatorVisitor();

        file.accept(visitor);

        assertEquals(123, visitor.getTotalSizeBytes());
    }
}