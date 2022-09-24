package com.ty.controller;

import java.util.Scanner;

import com.ty.dao.CartDAO;
import com.ty.dto.Cart;

public class UpdateController {
public static void main(String[] args) {
	Scanner sc= new Scanner(System.in);
	CartDAO a= new CartDAO();
	System.out.println("Enter your Id");
	int id = sc.nextInt();
	System.out.println("Enter your email");
	String email = sc.next();
	System.out.println("Enter your Username");
	String username = sc.next();
	System.out.println("Enter your Password ");
	String password = sc.next();
	System.out.println("Enter your adress ");
	String adress = sc.next();
	Cart l = new Cart();
	l.setId(id);
	l.setEmail(email);
	l.setPassword(password);
	l.setUsername(username);;
	l.setAdress(adress);
	System.out.println(a.UpdateCart(l));

}
}

