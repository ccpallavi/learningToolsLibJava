/**
 * 
 */
package learn.jaxb;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * @author Pallavi C
 * 
 */
@XmlRootElement(name = "BookStore")
@XmlType(propOrder = { "name", "location", "bookList"}) 
public class BookStore {
	
	// XmLElementWrapper generates a wrapper element around XML representation
	@XmlElementWrapper(name = "BookList")
	@XmlElement(name = "books")
	private ArrayList<Book> bookList;
	
	private String name;
	private String location;

	public void setBookList(ArrayList<Book> bookList) {
		this.bookList = bookList;
	}

	public ArrayList<Book> getBooksList() {
		return bookList;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
}