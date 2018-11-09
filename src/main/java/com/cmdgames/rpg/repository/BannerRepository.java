package com.cmdgames.rpg.repository;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BannerRepository {


    public String getFileContent(String filePath) throws URISyntaxException, IOException {
        Path path = Paths.get(getClass().getClassLoader().getResource(filePath).toURI());
        Stream<String> lines = Files.lines(path);
        String data = lines.collect(Collectors.joining("\n"));
        lines.close();
        return data;
    }

}
