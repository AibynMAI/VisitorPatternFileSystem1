public class SizeCalculatorVisitor implements FileSystemVisitor {

    private long totalSizeBytes = 0;

    @Override
    public void visitFile(File file) {
        totalSizeBytes += file.getSizeBytes();
    }

    @Override
    public void visitDirectory(Directory directory) {
        directory.acceptChildren(this);
    }

    public long getTotalSizeBytes() {
        return totalSizeBytes;
    }
}