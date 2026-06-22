package tms_maven;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static SonnetData parseWithSAX(File xmlFile) throws Exception{
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser saxParser = factory.newSAXParser();
        SAXHandler handler = new SAXHandler();

        saxParser.parse(xmlFile, handler);
        return handler.getSonnetData();
    }

    public static SonnetData parseWithDOM(File xmlFile) throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(xmlFile);

        SonnetData sonnetData = new SonnetData();

        NodeList firstNames = document.getElementsByTagName("firstName");
        if (firstNames.getLength() > 0)
            sonnetData.firstName = firstNames.item(0).getTextContent();

        NodeList lastNames = document.getElementsByTagName("lastName");
        if (lastNames.getLength() > 0)
            sonnetData.lastName = lastNames.item(0).getTextContent();

        NodeList titles = document.getElementsByTagName("title");
        if (titles.getLength() > 0)
            sonnetData.title = titles.item(0).getTextContent();

        NodeList lines = document.getElementsByTagName("line");
        for (int i = 0; i < lines.getLength(); i++) {
            String line = lines.item(i).getTextContent();
            if (line != null && !line.trim().isEmpty())
                sonnetData.lines.add(line);
        }

        return sonnetData;
    }

    public static void writeLinesToFile(SonnetData sonnetData, String outputDir) throws IOException {
        String fileName = sonnetData.getFileName();
        File outputFile = new File(outputDir, fileName);

        outputFile.getParentFile().mkdirs();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
            for (String line : sonnetData.lines) {
                writer.write(line);
                writer.newLine();
            }
        }

        System.out.println("Файл успешно создан: " + outputFile.getAbsolutePath());
    }

    static void main() {
        Scanner scanner = new Scanner(System.in);

        try (scanner) {
            File file = new File("./homework23/sonnet.xml");
            System.out.println("Выберите парсер:");
            System.out.println("1 - SAX");
            System.out.println("2 - DOM");
            int choice = scanner.nextInt();
            scanner.nextLine();
            SonnetData sonnetData = null;
            switch (choice) {
                case 1:
                    System.out.println("\nSAX parser");
                    sonnetData = parseWithSAX(file);
                    break;
                case 2:
                    System.out.println("\nDOM parser");
                    sonnetData = parseWithDOM(file);
                    break;
                default:
                    System.out.println("Некорректный ввод");
            }

            writeLinesToFile(sonnetData, "./homework23");
            System.out.println("\nСодержимое созданного файла:");
            for (String line : sonnetData.lines) {
                System.out.println(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
