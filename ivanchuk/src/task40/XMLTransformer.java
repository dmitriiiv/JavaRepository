package task40;

import javax.xml.transform.*;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class XMLTransformer {
    public void transform(String xslFile, String xmlFile, String htmlFile) {
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        try {
            StreamSource styleSource = new StreamSource(new FileInputStream(xslFile));
            Templates templates = transformerFactory.newTemplates(styleSource);
            Transformer transformer = templates.newTransformer();
            transformer.transform(new StreamSource(new File(xmlFile)),
                    new StreamResult(new FileOutputStream(new File(htmlFile))));
        } catch (FileNotFoundException | TransformerException e) {
            e.printStackTrace();
        }
    }
}
