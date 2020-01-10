/**
 * 
 */
package com.microservices.itemservice.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microservices.itemservice.model.Item;

/**
 * @author 474984
 *
 */
public interface ItemRespository extends JpaRepository<Item, String> {

}
