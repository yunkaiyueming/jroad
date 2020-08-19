package xmldemo;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SaxTest {

    public static void main(String[] args) {
        try {
            // 1. 获取SAXParserFactory实例
            SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
            // 2. 获取SAXParser实例
            SAXParser saxParser = saxParserFactory.newSAXParser();
            // 3. 加载xml实例
            saxParser.parse("/Users/ray/Documents/Java/jroad/src/xmldemo/demo.xml", new SelfHandler());

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static class SelfHandler extends DefaultHandler {

        /**
         * 遍历xml文件的开始标签
         */
        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes)
                throws SAXException {
            super.startElement(uri, localName, qName, attributes);
            if ("people".equals(qName)) {
                for (int i = 0; i < attributes.getLength(); i++) {
                    System.out.println("people 标签第" + (i + 1) + " 个属性名是:" + attributes.getQName(i) + "   属性值是： " + attributes.getValue(attributes.getQName(i)));
                }
            } else if (!"peoples".equals(qName) && !"people".equals(qName)) {
                System.out.print("节点名是： " + qName + "------");
            }
        }

        /**
         * 遍历xml文件的结束标签
         */
        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            super.endElement(uri, localName, qName);
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            super.characters(ch, start, length);
            String value = new String(ch, start, length);
            if (!"".equals(value.trim())) {
                System.out.println("节点值是： " + value);
            }
        }


        /**
         * 标识解析开始
         */
        @Override
        public void startDocument() throws SAXException {
            super.startDocument();
            System.out.println("开始sax解析.......");
        }

        /**
         * 标识解析结束
         */
        @Override
        public void endDocument() throws SAXException {
            super.endDocument();
            System.out.println("结束sax解析.......");
        }
    }

}

