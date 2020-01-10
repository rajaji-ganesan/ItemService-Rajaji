/**
 * 
 */
package com.microservices.itemservice.Controller;

import java.util.List;
import java.util.Optional;

import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.itemservice.model.Item;
import com.microservices.itemservice.service.ItemRespository;

/**
 * @author 474984
 *
 */

@RestController
@RequestMapping("/itemservice")
public class ItemController {
	
	Logger log = LoggerFactory.logger(ItemController.class);

	@Autowired
	ItemRespository itemRespository;
	
	/**
	 * @return
	 */
	@GetMapping("/items")
	public List<Item> getAllItemDetails(){
		log.info("Inside getAllItemDetails");
		return itemRespository.findAll();
	}
	
	/**
	 * @param itemId
	 * @return
	 */
	@GetMapping("/items/{itemName}")
	public Item getItemDetails(@PathVariable String itemName){
		log.info("Inside getItemDetails");
		Optional<Item> result = itemRespository.findById(itemName);
		if(result.isPresent()) {
			return result.get();
		} else  {
			return new Item();
		}
	}
	
	/**
	 * @param customer
	 * @return
	 */
	@PostMapping("/items/create")
	public Item createItem(@RequestBody Item items){
		log.info("Inside createItem");
		Item item = itemRespository.save(items);
		return item;
	}
	
	/**
	 * @param itemName
	 * @return
	 */
	@GetMapping("/items/{itemId}/delete")
	public String deleteItemDetails(@PathVariable String itemName){
		log.info("Inside deleteItemDetails");
		itemRespository.deleteById(itemName);
		return "Deleted Sucessfully";
	}

}
