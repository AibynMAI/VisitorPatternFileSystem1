import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SearchVisitorTest {

    @Test
    void findsMatchingFilesAtEveryLevel() {
        SearchVisitor visitor = new SearchVisitor(".java");

        SampleFileSystem.create().accept(visitor);

        assertEquals(
                List.of("project/src/Main.java",
                        "project/src/Utils.java",
                        "project/src/model/User.java"),
                visitor.getMatches());
    }

    @Test
    void returnsEmptyListWhenNothingMatches() {
        SearchVisitor visitor = new SearchVisitor(".xyz");

        SampleFileSystem.create().accept(visitor);

        assertTrue(visitor.getMatches().isEmpty());
    }

    @Test
    void rejectsEmptyExtension() {
        assertThrows(IllegalArgumentException.class, () -> new SearchVisitor(""));
    }
}