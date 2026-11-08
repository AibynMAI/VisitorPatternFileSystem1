public final class SampleFileSystem {

    private SampleFileSystem() {
    }

    public static Directory create() {
        Directory model = new Directory("model");
        model.add(new File("User.java", 2500));

        Directory src = new Directory("src");
        src.add(new File("Main.java", 4200));
        src.add(new File("Utils.java", 1800));
        src.add(model);

        Directory docs = new Directory("docs");
        docs.add(new File("report.pdf", 50000));
        docs.add(new File("diagram.png", 30000));

        Directory project = new Directory("project");
        project.add(new File("README.md", 2000));
        project.add(new File("notes.txt", 1500));
        project.add(src);
        project.add(docs);
        return project;
    }
}