package com.fod.model;

import java.util.LinkedHashMap;
import java.util.Map;
public class cart 
{
	Map<Integer, cartItem> items=new  LinkedHashMap<Integer, cartItem>();
	public void addItems(cartItem item) 
	{
		
		int itemsId=item.getItemid();		
	
		if(items.containsKey(itemsId))
		{
			cartItem existingItem=items.get(itemsId);
			existingItem.setQunatity(existingItem.getQunatity()+item.getQunatity());
		}
		else {
			items.put(itemsId, item);

		}
	}
	public void updateItem(int itemId,int quantity)
	{
		if(items.containsKey(itemId))
		{
			if(quantity<=0) {
				items.remove(itemId);
			}
			else {
				items.get(itemId).setQunatity(quantity);
			}
		}
	}
	public void removeItem(int itemId) {
		items.remove(itemId);
		
	}
	public void clear() {
		items.clear();
		
	}
	public Map<Integer, cartItem> getItems() {
		return items;
	}
}