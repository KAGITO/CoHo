package fyp.weitong.coho;

import java.io.Serializable;

public class Question implements Serializable{
	
	String id,title,content,user_id;


    public void setID(String id){
        this.id = id;
    }

    public String getID(){
        return this.id;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public String getTitle(){
        return this.title;
    }

    public void setContent(String content){
        this.content = content;
    }

    public String getContent(){
        return this.content;
    }

    public void setUser_id(String user_id){
        this.user_id = user_id;
    }

    public String getUser_id(){
        return this.user_id;
    }
    
    public Question() {

    }
    public Question(String id, String title, String content, String user_id) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.user_id = user_id;
    }




}
