/**
 * 
 */
package learn.jaxb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
/**
 * @author Pallavi C
 * 
 */

@XmlRootElement(name = "Book")

// Optional -If you want you can define the order in which the fields are written
@XmlType(propOrder = { "author", "name", "publisher", "isbn" })

// To annotate the properties. If this annotation is not used, then @XmlElement 
// should be annotated to the getter methods
@XmlAccessorType(XmlAccessType.FIELD)

/*
 * to create the below xml - 
 * 
 *  <simple other="BAR">FOO</simple>
 *  
 *  1. Create a class and name the root element to be simple. It should have 2 properties - other, contents
 *  2. Annotate other to be @XmlAttribute
 *  3. Annotate contents to be @XmlValue
 */
public class Book {

	// To change the variable name
	@XmlElement(name = "title", required = true)
	private String name;
	private String author;
	
	// The "required" below is just for documentation purposes. It doesnt do validation.
	// Additionally, you could use the beforeMarshal and afterUnmarshal methods to validate inputs
	@XmlElement(name = "publisher", required = false)
	private String publisher;
	private String isbn;

	@XmlAttribute(name = "Attribute", required = true)
	private String attribute;
	
    public String getAttribute() {
        return attribute;
    }
    
    public void setAttribute(String attribute) {
        this.attribute = attribute;
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

}
