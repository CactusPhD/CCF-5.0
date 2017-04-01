
package news;

/**
 *
 * @author jacobdbernard
 */
public class NewsItem {
    public String title;
    public String description;
    public String URL;
    
    public NewsItem(String title, String description, String URL){
        this.title = title;
        this.description = description;
        this.URL = URL;
    }
    
    public void setTitle(String title){
        this.title = title;
    }
    
    public void setDesc(String desc){
        this.description = desc;
    }
    
    public void setURL(String url){
        this.URL = url;
    }
}
