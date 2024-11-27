import org.xml.sax.*;
import org.xml.sax.helpers.*;
import javax.xml.parsers.*;
import java.io.File;

public class SAX extends DefaultHandler {
    public static void main(String[] args) {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();

            saxParser.parse(new File("/Users/ulanagudkova/IdeaProjects/lab77/src/main/houses.xml"), new SAX());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        if (qName.equals("house")) {
            System.out.println("House ID: " + attributes.getValue("id"));
        } else if (!qName.equals("catalog")) {
            System.out.print(qName + ": ");
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        String content = new String(ch, start, length).trim();
        if (!content.isEmpty()) {
            System.out.println(content);
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        if (!qName.equals("catalog")) {
            System.out.println();
        }
    }
}
