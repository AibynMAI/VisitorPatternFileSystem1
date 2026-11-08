import java.util.ArrayList;
import java.util.List;

public class Directory implements FileSystemElement {

    private final String name;
    private final List<FileSystemElement> children = new ArrayList<>();

    public Directory(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Directory name must not be empty.");
        }
        this.name = name;
    }

    public void add(FileSystemElement element) {
        if (element == null) {
            throw new IllegalArgumentException(
                    "Cannot add a null element to directory '" + name + "'.");
        }
        children.add(element);
    }

    public void acceptChildren(FileSystemVisitor visitor) {
        for (FileSystemElement child : children) {
            child.accept(visitor);
        }
    }

    @Override
    public void accept(FileSystemVisitor visitor) {
        visitor.visitDirectory(this);
    }

    @Override
    public String getName() {
        return name;
    }
}