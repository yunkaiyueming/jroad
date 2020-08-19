package xmldemo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.StringWriter;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class writeXmlByDom {

    private static void writeXmlByDom() {
        try {
            DocumentBuilderFactory factory =  DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            Document document = builder.newDocument();
            //创建属性名、赋值
            Element root = document.createElement("peoples");

            //创建第一个根节点、赋值
            Element lan = document.createElement("people");
            lan.setAttribute("id", "1");
            Element name = document.createElement("name");
            name.setTextContent("张三");
            Element ide = document.createElement("age");
            ide.setTextContent("45");
            lan.appendChild(name);
            lan.appendChild(ide);
            //创建第二个根节点、赋值
            Element lan2 = document.createElement("lan");
            lan2.setAttribute("id", "2");
            Element name2 = document.createElement("name");
            name2.setTextContent("李四");
            Element ide2 = document.createElement("age");
            ide2.setTextContent("88");
            lan2.appendChild(name2);
            lan2.appendChild(ide2);

            //添加到属性中、
            root.appendChild(lan);
            root.appendChild(lan2);
            document.appendChild(root);

            //定义了用于处理转换指令，以及执行从源到结果的转换的
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty("encoding", "UTF-8");

            StringWriter writer = new StringWriter();
            transformer.transform(new DOMSource(document), new StreamResult(writer));
            //          System.out.println(writer.toString());

            transformer.transform(new DOMSource(document), new StreamResult(new File("/Users/ray/Documents/Java/jroad/src/xmldemo/write.xml")));
        } catch (ParserConfigurationException | TransformerException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
        writeXmlByDom.writeXmlByDom();
    }
}
