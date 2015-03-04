package se.groupone.ecommerce.model;

import java.util.Date;
import java.util.ArrayList;

public final class Order
{
	private final int id;
	private final String customerUsername;

	private Date dateCreated, dateShipped = null;
	private ArrayList<Integer> productIds = new ArrayList<>();

	@SuppressWarnings("unchecked")
	public Order(int id, String customerUsername, ArrayList<Integer> shoppingCartProductIds)
	{
		this.id = id;
		// Klonar shoppingcart, ej referens då shoppingcarten kommer tömmas.
		this.productIds = (ArrayList<Integer>) shoppingCartProductIds.clone();
		this.customerUsername = customerUsername;
		this.dateCreated = new Date(System.currentTimeMillis());
	}

	public int getId()
	{
		return id;
	}

	public void shipIt()
	{
		dateShipped = new Date(System.currentTimeMillis());
	}

	public boolean isShipped()
	{
		if (dateShipped != null)
		{
			return true;
		}
		return false;
	}

	public Date getDateShipped()
	{
		return dateShipped;
	}

	public String getUsername()
	{
		return customerUsername;
	}

	public Date getDateCreated()
	{
		return dateCreated;
	}

	public ArrayList<Integer> getProductIds()
	{
		return productIds;
	}

	@Override
	public String toString()
	{
		return "Order [userName=" + customerUsername
				+ ", dateCreated=" + dateCreated + ", dateShipped="
				+ dateShipped + ", products=" + productIds + "]";
	}

}