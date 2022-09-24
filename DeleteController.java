package com.ty.controller;

import java.util.Scanner;

import com.ty.dao.CartDAO;

public class DeleteController {
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	CartDAO n= new CartDAO();
	System.out.println("Enter Id which need to be Deleted ");
	int id = sc.nextInt();
	System.out.println(n.DeleteCart(id));
}
}
