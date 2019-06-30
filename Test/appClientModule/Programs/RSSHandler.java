package Programs;
import java.util.ArrayList;
import java.util.List;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class RSSHandler extends DefaultHandler implements RSSLister<RssItem1> 
{
	private boolean isTitle;
	private boolean isLink;
	private boolean isDescription;
	private boolean isPubDate;
	private RssItem1 currentItem;
	private List<RssItem1> rssItemList;
	private StringBuilder linkBuilder = new StringBuilder();

	public RSSHandler(){
		rssItemList=new ArrayList<>();
	}
	
	public List<RssItem1> getRSSItemList(){
		return rssItemList;
	}
	// Called when an opening tag is reached, such as <item> or <title>
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		switch (qName) {
		case "item":
			currentItem = new RssItem1();
			break;
		case "title":
			isTitle = true;
			break;
		case "link":
			isLink = true;
			break;
		case "content:encoded":
			isDescription = true;
			break;
		case "pubDate":
			isPubDate = true;
			break;
		}
	}

	// Called when a closing tag is reached, such as </item> or </title>
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		switch (qName) {
		case "item":
			// End of an item so add the currentItem to the list of items.
			rssItemList.add(currentItem);
			currentItem = null;
			break;
		case "title":
			isTitle = false;
			break;
		case "link":
			isLink = false;
			break;
		case "content:encoded":
			isDescription = false;
			break;
		case "pubDate":
			isPubDate = false;
			break;
		}
	}

	// Goes through character by character when parsing what is inside of a tag.
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		String title = null;
		String link = null;
		String description = null;
		String pubDate = null;
		if (currentItem != null) {
			// If parsingTitle is true, then that means we are inside a <title>
			// tag so the text is the title of an item.
			if (isTitle) {
				title = new String(ch, start, length);
				currentItem.setTitle(title);
			}
			// If parsingLink is true, then that means we are inside a <link>
			// tag so the text is the link of an item.
			else if (isLink) {
				link = new String(ch, start, length);
				linkBuilder.append(link);
				currentItem.setLink(linkBuilder.toString());
			}
			// If parsingDescription is true, then that means we are inside a
			// <description> tag so the text is the description of an item.
			else if (isDescription) {
				description = new String(ch, start, length);
				currentItem.setDescription(description);
			}
			// If parsingPubDate is true, then that means we are inside a
			// <pubDate> tag so the text is the pubDate of an item.
			else if (isPubDate) {
				pubDate = new String(ch, start, length);
				currentItem.setPubDate(pubDate);
			}
		}	
	}         
}
