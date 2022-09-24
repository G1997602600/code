package com.ty.controller;

import java.util.Scanner;

import com.ty.dao.CartDAO;
import com.ty.dto.Cart;


public class GetController {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		CartDAO n = new CartDAO();
		System.out.println("Enter Id which need to be displayed");
		int id = sc.nextInt();
		Cart f = n.GetCart(id);
		System.out.println(f);
	}

}
