package com.cmdgames.rpg.repository;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BannerRepository {
    
    public String getFileContent(String filePath) throws URISyntaxException, IOException {
        Scanner s = new Scanner(getClass().getClassLoader().getResourceAsStream(filePath)).useDelimiter("\\A");
        String result = s.hasNext() ? s.next() : "";
        return result;
    }

}
