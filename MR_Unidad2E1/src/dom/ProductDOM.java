package dom;

import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;


import model.Product;


public class ProductDOM {
	private String pathFile = "C:\\Users\\Juan Bosco Carrillo\\eclipse-workspace\\MR_Unidad2E1\\src\\data\\products.xml";
	public void add(Product data) {
		try {
			Document document = DOMHelper.getDocument(pathFile);
			Element products = document.getDocumentElement();
			
			Element product = document.createElement("product");
			//CREAR ID TAGG
			
			Element id = document.createElement("id");
			id.appendChild(document.createTextNode(data.getId()));
			product.appendChild(id);
			// create name tag
			
			Element name = document.createElement("name");
			name.appendChild(document.createTextNode(data.getName()));
			product.appendChild(name);
			
			Element units = document.createElement("units");
			units.appendChild(document.createTextNode(String.valueOf(data.getUnitInStock())));
			product.appendChild(units);
			
			Element price = document.createElement("price");
			price.appendChild(document.createTextNode(String.valueOf(data.getUnitPrice())));
			product.appendChild(price);
			
			Element type = document.createElement("type");
			type.appendChild(document.createTextNode(data.getType()));
			product.appendChild(type);
			
			products.appendChild(product);
			
			// Write to file
			DOMHelper.saveXMLContent(document, pathFile);
	}catch(Exception e){
		
			System.out.println(e.getMessage());
			System.out.println("Error, cachando valores SpeciDOM");
		
	}
}

public void delete (String id ) {
	
	try {
		Document document = DOMHelper.getDocument(pathFile);
		NodeList nodelist = document.getElementsByTagName("product");
		for (int i =0; i< nodelist.getLength(); i++) {
			
			Element product = (Element)nodelist.item(i);
			if (product.getElementsByTagName("id").item(0).getTextContent().equals(id)) {
				product.getParentNode().removeChild(product);
			}
		}
		DOMHelper.saveXMLContent(document, pathFile);
		
	}catch (Exception e) {
		e.printStackTrace();
		System.out.println("Error, cachando valores SpecieDOM delete");
	}
}

public void update (Product data) {
	try {
		Document document = DOMHelper.getDocument(pathFile);
		NodeList nodelist = document.getElementsByTagName("product");
		for (int i =0; i< nodelist.getLength(); i++) {
			Element product = (Element)nodelist.item(i);
			if (product.getElementsByTagName("id").item(0).getTextContent().equals(data.getId())) {
				product.getElementsByTagName("name").item(0).setTextContent(data.getName());
				product.getElementsByTagName("units").item(0).setTextContent(String.valueOf(data.getUnitInStock()));
				product.getElementsByTagName("price").item(0).setTextContent(String.valueOf(data.getUnitPrice()));
				product.getElementsByTagName("type").item(0).setTextContent(data.getType());
				
				
			}
		}
		DOMHelper.saveXMLContent(document, pathFile);
		
	}catch(Exception e) {
		e.printStackTrace();
System.out.println("Error delete DOM");
	}
	
}

public Product findById(String id) {
	Product product = null;
	try {
		Document document = DOMHelper.getDocument(pathFile);
		NodeList nodelist = document.getElementsByTagName("product");
		for(int i=0; i<nodelist.getLength(); i++) {
			Element s = (Element)nodelist.item(i);
			if(s.getElementsByTagName("id").item(0).getTextContent().equals(id)) {
				product = new Product();
				product.setId(id);
				product.setName(s.getElementsByTagName("name").item(0).getTextContent());
				product.setUnitInStock(Integer.parseInt(s.getElementsByTagName("units").item(0).getTextContent()));
				product.setUnitPrice(Integer.parseInt(s.getElementsByTagName("price").item(0).getTextContent()));
				product.setType(s.getElementsByTagName("type").item(0).getTextContent());
			}
			
			
		}
		
		
	}catch (Exception e) {
		e.printStackTrace();
		System.out.println("Método finById DOM");
	}
	return product;
}

public  List<Product> getProduct(){
	
	List<Product> products = new ArrayList<Product>();
	Document document = DOMHelper.getDocument(pathFile);
	NodeList nodelist = document.getElementsByTagName("product");
	for (int i =0; i<nodelist.getLength(); i++) {
		
		Element s = (Element)nodelist.item(i);
		Product product = new Product();
		product.setId(s.getElementsByTagName("id").item(0).getTextContent());
		product.setName(s.getElementsByTagName("name").item(0).getTextContent());
		product.setUnitInStock(Integer.parseInt(s.getElementsByTagName("units").item(0).getTextContent()));
		product.setUnitPrice(Integer.parseInt(s.getElementsByTagName("price").item(0).getTextContent()));
		product.setType(s.getElementsByTagName("type").item(0).getTextContent());
		
		products.add(product);
		
	}
	return products;
	
}

		}
			

