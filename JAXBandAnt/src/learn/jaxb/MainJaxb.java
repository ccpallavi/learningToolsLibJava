/**
 * 
 */
package learn.jaxb;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.ArrayList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

/**
 * @author Pallavi C
 * 
 */
public class MainJaxb {

	private static final String BOOKSTORE_XML = "./bookstore-jaxb.xml";

	public static void main(String[] args) {

		ArrayList<Book> bookList = new ArrayList<Book>();
		StringWriter writer = new StringWriter();

		// create books
		Book book1 = new Book();
		book1.setIsbn("978-0060554736");
		book1.setName("The Game");
		book1.setAuthor("Neil Strauss");
		book1.setPublisher("Harpercollins");
		book1.setAttribute("attr1");
		bookList.add(book1);

		Book book2 = new Book();
		book2.setIsbn("978-3832180577");
		book2.setName("Feuchtgebiete");
		book2.setAuthor("Charlotte Roche");
		book2.setPublisher("Dumont Buchverlag");
		book2.setAttribute("attr2");
		bookList.add(book2);

		// create bookstore, assigning book
		BookStore bookstore = new BookStore();
		bookstore.setName("Fraport Bookstore");
		bookstore.setLocation("Frankfurt Airport");
		bookstore.setBookList(bookList);

		try {
			// create JAXB context and instantiate marshaller
			JAXBContext context = JAXBContext.newInstance(BookStore.class);
			Marshaller m = context.createMarshaller();
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
			m.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
	
			// Write to System.out
			m.marshal(bookstore, System.out);
	
			// Write to File
			m.marshal(bookstore, new File(BOOKSTORE_XML));			
		 
			// Write to object
			m.marshal(bookstore, writer);
			
			// get variables from our xml file, created before
			System.out.println();
			System.out.println("Unmarshal from our XML File: ");
			Unmarshaller um = context.createUnmarshaller();
			// unmarshal from file
			BookStore bookstore2 = (BookStore) um.unmarshal(new FileReader(BOOKSTORE_XML));
			ArrayList<Book> list = bookstore2.getBooksList();
			for (Book book : list) {
				System.out.println("Book: " + book.getName() + " from " + book.getAuthor());
			}
			
			System.out.println();
			System.out.println("Unmarshal from variable: ");
			System.out.println(writer.toString());

			bookstore2 = (BookStore) um.unmarshal(new StringReader(writer.toString()));
			list = bookstore2.getBooksList();
			for (Book book : list) {
				System.out.println("Book: " + book.getName() + " from " + book.getAuthor());
			}
		
		} catch(JAXBException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}