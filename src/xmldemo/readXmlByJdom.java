//package xmldemo;
//
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.io.InputStream;
//import java.util.List;
//
//import org.jdom.Document;
//
//import org.jdom.Attribute;
//import org.jdom.Element;
//import org.jdom.JDOMException;
//import org.jdom.input.SAXBuilder;
//import org.jdom.output.XMLOutputter;
//
//
//public class readXmlByJdom {
//
//    private static void readXmlByJdom() {
//        try {
//            // 1. 创建org.jdom.input.SAXBuilder对象
//            SAXBuilder saxBuilder = new SAXBuilder();
//            // 2. 创建一个输入流, 用来加载xml文件
//            InputStream ins = new FileInputStream("people.xml");
//            org.jdom.Document document = saxBuilder.build(ins);
//
//            // 3. 获取根节点
//            Element rootElement = document.getRootElement();
//
//            // 4. 获取根节点下的子节点
//            List<Element> lists = rootElement.getChildren();
//            for (Element people : lists) {
//                // A.获取所有的属性
//                // System.out.println("====属性值："+people.getAttributeValue("id"));
//                List<Attribute> attributeList = people.getAttributes();
//                for (Attribute element : attributeList) {
//                    System.out.println("属性名："+element.getName()+"====属性值："+element.getValue());
//                }
//
//                // B. 遍历people节点下所有的节点名和节点值
//                List<Element> childList = people.getChildren();
//                for (Element object : childList) {
//                    System.out.println("节点名："+object.getName()+"========节点值："+object.getValue());
//                }
//            }
//
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (JDOMException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//}
