import java.util.ArrayList;
import java.util.List;

public class SearchVisitor implements FileSystemVisitor {

    private final String extension;
    private final List<String> currentPath = new ArrayList<>();
    private final List<String> matches = new ArrayList<>();

    public SearchVisitor(String extension) {
        if (extension == null || extension.isBlank()) {
            throw new IllegalArgumentException("Search extension must not be empty.");
        }
        this.extension = extension;
    }

    @Override
    public void visitFile(File file) {
        if (file.getName().endsWith(extension)) {
            matches.add(pathTo(file));
        }
    }

    @Override
    public void visitDirectory(Directory directory) {
        currentPath.add(directory.getName());
        directory.acceptChildren(this);
        currentPath.remove(currentPath.size() - 1);
    }

    public List<String> getMatches() {
        return List.copyOf(matches);
    }

    private String pathTo(File file) {
        if (currentPath.isEmpty()) {
            return file.getName();
        }
        return String.join("/", currentPath) + "/" + file.getName();
    }
}
