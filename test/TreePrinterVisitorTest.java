import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class TreePrinterVisitorTest {

    @Test
    void startsWithRootDirectoryName() {
        TreePrinterVisitor visitor = new TreePrinterVisitor();

        SampleFileSystem.create().accept(visitor);

        assertTrue(visitor.getOutput().startsWith("project/"));
    }

    @Test
    void indentsNestedElementsByDepth() {
        TreePrinterVisitor visitor = new TreePrinterVisitor();

        SampleFileSystem.create().accept(visitor);

        assertTrue(visitor.getOutput().contains("      User.java (2500 bytes)"));
    }
}