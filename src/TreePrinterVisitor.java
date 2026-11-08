public class TreePrinterVisitor implements FileSystemVisitor {

    private static final String INDENT = "  ";

    private final StringBuilder output = new StringBuilder();
    private int depth = 0;

    @Override
    public void visitFile(File file) {
        appendLine(file.getName() + " (" + file.getSizeBytes() + " bytes)");
    }

    @Override
    public void visitDirectory(Directory directory) {
        appendLine(directory.getName() + "/");
        depth++;
        directory.acceptChildren(this);
        depth--;
    }

    public String getOutput() {
        return output.toString();
    }

    private void appendLine(String text) {
        output.append(INDENT.repeat(depth)).append(text).append(System.lineSeparator());
    }
}