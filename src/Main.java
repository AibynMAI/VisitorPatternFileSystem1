import java.util.List;

public class Main {

    public static void main(String[] args) {
        Directory root = SampleFileSystem.create();

        System.out.println("=== File System Visitor Demo ===");

        printTree(root);
        printTotalSize(root);
        printSearchResults(root, ".java");
        printSearchResults(root, ".txt");
    }

    private static void printTree(Directory root) {
        TreePrinterVisitor visitor = new TreePrinterVisitor();
        root.accept(visitor);

        System.out.println();
        System.out.println("--- Tree (TreePrinterVisitor) ---");
        System.out.print(visitor.getOutput());
    }

    private static void printTotalSize(Directory root) {
        SizeCalculatorVisitor visitor = new SizeCalculatorVisitor();
        root.accept(visitor);

        System.out.println();
        System.out.println("--- Total size (SizeCalculatorVisitor) ---");
        System.out.println("Total size: " + visitor.getTotalSizeBytes() + " bytes");
    }

    private static void printSearchResults(Directory root, String extension) {
        SearchVisitor visitor = new SearchVisitor(extension);
        root.accept(visitor);
        List<String> matches = visitor.getMatches();

        System.out.println();
        System.out.println("--- Search \"" + extension + "\" (SearchVisitor) ---");
        System.out.println("Found " + matches.size() + " file(s):");
        matches.forEach(path -> System.out.println("  " + path));
    }
}