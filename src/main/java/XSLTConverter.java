import javax.xml.transform.*;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.File;

public class XSLTConverter {
    public static void main(String[] args) {
        try {
            TransformerFactory factory = TransformerFactory.newInstance();
            Source xslt = new StreamSource(new File("src/main/houses.xsl"));
            Transformer transformer = factory.newTransformer(xslt);

            Source xml = new StreamSource(new File("src/main/houses.xml"));
            transformer.transform(xml, new StreamResult(new File("output.html")));
            System.out.println("Transformation complete.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
