package com.example.remotex;


public class startServer extends Thread {

    public  void run(){
		SetPassword frame1= new SetPassword();
	    	frame1.setSize(300,80);
	    	frame1.setLocation(500,300);
		frame1.setVisible(true);	 
	}
}
