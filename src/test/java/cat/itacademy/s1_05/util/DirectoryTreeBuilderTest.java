package cat.itacademy.s1_05.util;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

class DirectoryTreeBuilderTest {

    @TempDir
    Path tempDir;

    @Test
    void build_returnsNonEmptyString_forValidDirectory() {
        String result = DirectoryTreeBuilder.build(tempDir.toFile());
        assertNotNull(result);
        assertFalse(result.isBlank());
    }

    @Test
    void build_containsRootDirectoryName() {
        String result = DirectoryTreeBuilder.build(tempDir.toFile());
        assertTrue(result.contains(tempDir.toFile().getName()));
    }

    @Test
    void build_containsDirectoryLabel() throws IOException {
        Files.createDirectory(tempDir.resolve("subdir"));

        String result = DirectoryTreeBuilder.build(tempDir.toFile());
        assertTrue(result.contains("(D)"));
    }

    @Test
    void build_containsFileLabel() throws IOException {
        Files.createFile(tempDir.resolve("file.txt"));

        String result = DirectoryTreeBuilder.build(tempDir.toFile());
        assertTrue(result.contains("(F)"));
    }

    @Test
    void build_containsBothLabels_whenDirectoryHasFilesAndSubdirs() throws IOException {
        Files.createFile(tempDir.resolve("file.txt"));
        Files.createDirectory(tempDir.resolve("subdir"));

        String result = DirectoryTreeBuilder.build(tempDir.toFile());
        assertTrue(result.contains("(F)"));
        assertTrue(result.contains("(D)"));
    }

    @Test
    void build_returnsOnlyHeader_forEmptyDirectory() {
        String result = DirectoryTreeBuilder.build(tempDir.toFile());
        assertEquals(" ─" + tempDir.toFile().getName() + "\n", result);
    }

    @Test
    void build_returnsOnlyHeader_forNonExistentDirectory() {
        File nonExistent = new File(tempDir.toFile(), "does_not_exist");
        String result = DirectoryTreeBuilder.build(nonExistent);
        assertFalse(result.contains("(F)"));
        assertFalse(result.contains("(D)"));
        assertTrue(result.contains(nonExistent.getName()));
    }
}
