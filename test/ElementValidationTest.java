import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class ElementValidationTest {

    @Test
    void fileRejectsNegativeSize() {
        assertThrows(IllegalArgumentException.class, () -> new File("a.txt", -1));
    }

    @Test
    void fileRejectsBlankName() {
        assertThrows(IllegalArgumentException.class, () -> new File(" ", 10));
    }

    @Test
    void directoryRejectsNullChild() {
        Directory directory = new Directory("docs");

        assertThrows(IllegalArgumentException.class, () -> directory.add(null));
    }
}