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

public class readXmlByDom {

    private static void readXmlByDom() {
        try {
            // 1. 创建DocumentBuilderFactory对象
            DocumentBuilderFactory dFactory = DocumentBuilderFactory.newInstance();
            // 2. 创建DocumentBuilder对象
            DocumentBuilder dBuilder = dFactory.newDocumentBuilder();
            // 3. 通过DocumentBuilder的parse方法解析xml
            org.w3c.dom.Document doc = dBuilder.parse("/Users/ray/Documents/Java/jroad/src/xmldemo/demo.xml");
            // 4. 根据根节点名称获取所有的people节点
            org.w3c.dom.NodeList peopleList = doc.getElementsByTagName("people");
            // 5. 遍历所有的people节点
            for (int i = 0; i < peopleList.getLength(); i++) {
                System.out.println(peopleList.item(i).getNodeName());

                Node peopleNode = peopleList.item(i);
                // A. 获取所有的属性名称 和 对应的属性值
                org.w3c.dom.NamedNodeMap namedNodeMap = peopleNode.getAttributes();
                // B. 遍历people的所有属性
                for (int j = 0; j < namedNodeMap.getLength(); j++) {
                    System.out.println("属性 =" + namedNodeMap.item(j).getNodeName() + "   :值 = " + namedNodeMap.item(j).getNodeValue());
                }

                NodeList nodeList = peopleNode.getChildNodes();
                for (int k = 0; k < nodeList.getLength(); k++) {
                    Node node = nodeList.item(k);
                    if (node.getNodeType() == Node.ELEMENT_NODE) {
                        System.out.println("节点名：" + node.getNodeName() + "    节点值：" + node.getFirstChild().getNodeValue());
                        //System.out.println("节点名aa："+node.getNodeName()+ "    节点值："+node.getTextContent());
                    }
                }
            }
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        readXmlByDom.readXmlByDom();
    }
}
