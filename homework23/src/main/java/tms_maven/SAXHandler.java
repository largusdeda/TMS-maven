package tms_maven;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SAXHandler extends DefaultHandler {
    private SonnetData sonnetData;
    private StringBuilder currentValue;
    private boolean isLine = false;

    @Override
    public void startDocument() throws SAXException {
        sonnetData = new SonnetData();
        currentValue = new StringBuilder();
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        currentValue.setLength(0);
        if ("line".equals(qName))
            isLine = true;
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        currentValue.append(ch, start, length);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        String value = currentValue.toString().trim();

        switch (qName) {
            case "firstName":
                sonnetData.firstName = value;
                break;
            case "lastName":
                sonnetData.lastName = value;
                break;
            case "title":
                sonnetData.title = value;
                break;
            case "line":
                if (isLine && !value.isEmpty())
                    sonnetData.lines.add(value);

                isLine = false;
                break;
        }
    }

    SonnetData getSonnetData() {
        return sonnetData;
    }
}
