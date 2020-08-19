//package xmldemo;
//
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.UnsupportedEncodingException;
//import java.util.Iterator;
//import java.util.List;
//
//import org.dom4j.Attribute;
//import org.dom4j.Document;
//import org.dom4j.DocumentException;
//import org.dom4j.DocumentHelper;
//import org.dom4j.Element;
//import org.dom4j.io.OutputFormat;
//import org.dom4j.io.SAXReader;
//import org.dom4j.io.XMLWriter;
//
//
//public class readXmlByDom4J {
//
//    private static void readXmlByDom4J() {
//        try {
//            // 1. 创建org.dom4j.io.SAXReader对象
//            SAXReader saxReader = new SAXReader();
//            InputStream ins = new FileInputStream("people.xml");
//            Document document =  saxReader.read(ins);
//            Element rootElement = document.getRootElement();
//            System.out.println("根节点的名称是："+rootElement.getName());
//
//            Iterator iterator = rootElement.elementIterator();
//            while (iterator.hasNext()) {
//                Element element = (Element) iterator.next();
//                // 获取所有属性名和属性值
//                List<Attribute>attributesList = element.attributes();
//                for (Attribute attribute : attributesList) {
//                    System.out.println("属性名："+attribute.getName()+"======属性值"+attribute.getValue());
//                }
//
//                // 遍历子节点
//                Iterator childIterator = element.elementIterator();
//                while (childIterator.hasNext()) {
//                    Element child = (Element) childIterator.next();
//                    System.out.println("属性名："+child.getName()+"======属性值"+child.getStringValue());
//                }
//
//            }
//        } catch (FileNotFoundException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        } catch (DocumentException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//    }
//}
