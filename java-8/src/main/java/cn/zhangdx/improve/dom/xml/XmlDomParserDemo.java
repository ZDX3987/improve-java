package cn.zhangdx.improve.dom.xml;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

/**
 * @author ZDX
 * @date 2025/7/11 22:03
 */
public class XmlDomParserDemo {

    public static void main(String[] args) {
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.parse(new File("src/main/resources/mybatis-config.xml"));
            Element documentElement = document.getDocumentElement();
            System.out.println("节点名称：" + documentElement.getNodeName());
            NodeList childNodes = documentElement.getChildNodes();
            for (int i = 0; i < childNodes.getLength(); i++) {
                Node node = childNodes.item(i);
                printNode(node);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void printNode(Node node) {
        short nodeType = node.getNodeType();
        if (Node.ELEMENT_NODE == nodeType) {
            System.out.println("element节点名称：" + node.getNodeName());
            NamedNodeMap attributes = node.getAttributes();
            if (attributes.getLength() != 0) {
                for (int i = 0; i < attributes.getLength(); i++) {
                    Node attribute = attributes.item(i);
                    System.out.println("element属性名称：" + attribute.getNodeName() + " 属性值：" + attribute.getNodeValue());
                }
            }
            NodeList childNodes = node.getChildNodes();
            for (int i = 0; i < childNodes.getLength(); i++) {
                printNode(childNodes.item(i));
            }
        } else {
            System.out.println("节点名称：" + node.getNodeName());
        }
    }
}
