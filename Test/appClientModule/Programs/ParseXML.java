package Programs;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class ParseXML
{   	
   //List<RssNews> rssItem;
	
    public <I, T extends DefaultHandler & RSSLister<I>> List<I> getItems(Class<T> handlerClass) throws Exception{
    	SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
		SAXParser saxParser = saxParserFactory.newSAXParser();
		T handler = null;
		handler=handlerClass.newInstance();
		
    	String rssUrl="https://www.gazabpost.com/rss/category/entertainment";
    	//InputStream in = new URL(rssUrl).openStream();
    	String x;
    	BufferedReader reader = new BufferedReader(new InputStreamReader(new URL(rssUrl).openStream(),"UTF-8"));
    	InputSource is = new InputSource(reader);
		is.setEncoding("UTF-8");
		
	  //System.out.println(is.getEncoding());
//    	while((x=reader.readLine())!=null){
//        	System.out.println(x);
//    	}
		
    	
		saxParser.parse(is, handler);
		return handler.getRSSItemList();
	}
   
   public static void main(String args[]) throws Exception{
	   
	   List<RssItem1> items = new ParseXML().getItems(RSSHandler.class);
	   System.out.println(items.get(0).getTitle());
	   
//	   String x="NA";
//	   String y=x.replace("{1}", "amol");
//	   System.out.println(y);
//	   A obja=new A();
//	   List<RssNews> rss=new ArrayList<>();
//	   rss.add(obja);
//	   new ParseXML().getRssNews();
//	   String url = "https://www.scoopwhoop.com/rss/category/life";
//       try{
//           SAXParser parser = SAXParserFactory.newInstance().newSAXParser();
//           RSSHandler handler = new RSSHandler();
//           parser.parse(url, handler);
//           System.out.println(handler.getRSSItemList().get(0).getDescription());
//           
//       }
//       catch (Exception e){
//           e.printStackTrace();
//       }       
   }
}

interface RSSLister<I> {
    List<I> getRSSItemList();
}


class RssItem1
{
	private String title;
	private String link;
	private String description;
	private String pubDate;
	
	public String getTitle(){
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}public String getPubDate() {
		return pubDate;
	}
	public void setPubDate(String pubDate) {
		this.pubDate = pubDate;
	}
	
}


class RssItem2
{
	private String title;
	private String link;
	private String description;
	private String pubDate;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPubDate() {
		return pubDate;
	}
	public void setPubDate(String pubDate) {
		this.pubDate = pubDate;
	}
	
}