import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ConcurrentVisitorsTest {

    @Test
    void independentVisitorsCanTraverseSameTreeInParallel() throws Exception {
        Directory sharedTree = SampleFileSystem.create();
        ExecutorService executor = Executors.newFixedThreadPool(2);
        try {
            Future<Long> sizeResult = executor.submit(() -> {
                SizeCalculatorVisitor visitor = new SizeCalculatorVisitor();
                sharedTree.accept(visitor);
                return visitor.getTotalSizeBytes();
            });
            Future<List<String>> searchResult = executor.submit(() -> {
                SearchVisitor visitor = new SearchVisitor(".java");
                sharedTree.accept(visitor);
                return visitor.getMatches();
            });

            assertEquals(92000L, (long) sizeResult.get());
            assertEquals(3, searchResult.get().size());
        } finally {
            executor.shutdown();
        }
    }
}