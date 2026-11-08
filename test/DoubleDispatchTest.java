import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DoubleDispatchTest {

    private static class RecordingVisitor implements FileSystemVisitor {

        private final List<String> calls = new ArrayList<>();

        @Override
        public void visitFile(File file) {
            calls.add("visitFile:" + file.getName());
        }

        @Override
        public void visitDirectory(Directory directory) {
            calls.add("visitDirectory:" + directory.getName());
        }
    }

    @Test
    void fileCallsVisitFileOnVisitor() {
        RecordingVisitor visitor = new RecordingVisitor();
        FileSystemElement element = new File("a.txt", 1);

        element.accept(visitor);

        assertEquals(List.of("visitFile:a.txt"), visitor.calls);
    }

    @Test
    void directoryCallsVisitDirectoryOnVisitor() {
        RecordingVisitor visitor = new RecordingVisitor();
        FileSystemElement element = new Directory("docs");

        element.accept(visitor);

        assertEquals(List.of("visitDirectory:docs"), visitor.calls);
    }
}