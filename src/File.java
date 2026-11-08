public class File implements FileSystemElement {

    private final String name;
    private final long sizeBytes;

    public File(String name, long sizeBytes) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("File name must not be empty.");
        }
        if (sizeBytes < 0) {
            throw new IllegalArgumentException("File size must not be negative: " + sizeBytes);
        }
        this.name = name;
        this.sizeBytes = sizeBytes;
    }

    @Override
    public void accept(FileSystemVisitor visitor) {
        visitor.visitFile(this);
    }

    @Override
    public String getName() {
        return name;
    }

    public long getSizeBytes() {
        return sizeBytes;
    }
}