package com.pacholki;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class LineupReader {
    public static void main(String[] args) throws IOException {

        String srcFile = "src/main/resources/match_lineup.json";

        ObjectMapper mapper = new ObjectMapper();
        Player[] players = mapper.readValue(new File(srcFile), Player[].class);
        Tools.display(players);
    }
}
