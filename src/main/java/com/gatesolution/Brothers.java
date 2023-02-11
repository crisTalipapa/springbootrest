package com.gatesolution;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.xml.bind.annotation.XmlRootElement;



@Entity
@Table(name="brothers")
public class Brothers {
   @Id
   @GeneratedValue(strategy=GenerationType.IDENTITY)
   private int id;
   
   @Column(name="name")
   private String name;
   
   @Column(name="email")
   private String email;
   
   @Column(name="password")
   private String password;
   
   @Column(name="online")
   private int online;
   
   @Column(name="position")
   private String position;
   
   @Column(name="location")
   private String location;
   
   @Column(name="img")
   private String img;
   
   @Column(name="likes")
   private int likes;
   
   @Column(name="dislikes")
   private int dislikes;
   
   public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

public int getOnline() {
	return online;
}

public void setOnline(int online) {
	this.online = online;
}

public String getPosition() {
	return position;
}

public void setPosition(String position) {
	this.position = position;
}

public String getLocation() {
	return location;
}

public void setLocation(String location) {
	this.location = location;
}

public String getImg() {
	return img;
}

public void setImg(String img) {
	this.img = img;
}

public int getDislikes() {
	return dislikes;
}

public void setDislikes(int dislikes) {
	this.dislikes = dislikes;
}

public String getComments() {
	return comments;
}

public void setComments(String comments) {
	this.comments = comments;
}
@Column(name="comments")
   private String comments;
   
 public Brothers() {
	 
 }
   

public Brothers(String name, String email, String password, int online, String position, String location,
		String img, int likes, int dislikes, String comments) {
	super();
	this.id = id;
	this.name = name;
	this.email = email;
	this.password = password;
	this.online = online;
	this.position = position;
	this.location = location;
	this.img = img;
	this.likes = likes;
	this.dislikes = dislikes;
	this.comments = comments;
}

public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public int getLikes() {
	return likes;
}
public void setLikes(int likes) {
	this.likes = likes;
}

   
   
	
	
	
	
}
