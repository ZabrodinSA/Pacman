package com.pacman.game;

import com.pacman.protobuf.Map;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MapLoader {
    private String pathFile;
    private static Map map;


    public MapLoader (String pathFile) {
        this.pathFile = pathFile;
    }

    public Map LoadMap () throws FileNotFoundException {
        File file = new File(pathFile);
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (!line.equals("")) {
                String[] elements = line.split(" ");
                if (elements.length > 1) {
                    String curLine = scanner.nextLine();
                    switch (elements[1]) {
                        case ("Size"):
                            int[] size = GetNumper(curLine);
                            Map.Builder mapBuilder = Map.newBuilder();
                            mapBuilder.setSizeX(size[0]);
                            mapBuilder.setSizeY(size[1]);
                            SetBlankMap(mapBuilder);
                            break;
                        case ("Walls"):
                            break;
                        default:
                            while (scanner.hasNext()) {
                                if (!curLine.equals("") && curLine.split(" ").length <= 1) {
                                    int[] position = GetNumper(curLine);
                                    AddWallInMap(position);
                                }
                                curLine = scanner.nextLine();
                            }
                            break;
                    }
                }
            }
        }
        scanner.close();
        return map;
    }

    private void AddWallInMap(int[] position) {
        int index = position[0] * map.getSizeY() + position[1];
        Map.Builder builder = Map.newBuilder(map);
        Map.Cell.Builder cellBuilder = Map.Cell.newBuilder();
        cellBuilder.setX(position[0]);
        cellBuilder.setY(position[1]);
        cellBuilder.setState(Map.CellState.WALL);
        builder.setCells(index, cellBuilder.build());
        map = builder.build();
    }

    private void SetBlankMap(Map.Builder builder) {
        for (int i = 0; i < builder.getSizeX(); i++) {
            for (int j =0; j < builder.getSizeY(); j++) {
                Map.Cell.Builder cellBuilder = Map.Cell.newBuilder();
                cellBuilder.setX(i);
                cellBuilder.setY(j);
                cellBuilder.setState(Map.CellState.POINT);
                builder.addCells(cellBuilder.build());
            }
        }
        map = builder.build();
    }

    private int[] GetNumper (String line) {
        int[] result = new int[2];
        String[] size = line.split(";");
        if (size.length != 2) {
            System.out.println("Неверная строка координат");
        }
        result[0] = Integer.parseInt(size[0]);
        result[1] = Integer.parseInt(size[1]);
        return result;
    }
}
