package com.example.demo.service;


import com.example.demo.entity.ClientBookEntity;

import java.util.List;
import java.util.Map;

/**
 * 书籍
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2018-01-26 11:22:17
 */
public interface ClientBookService {
	
	ClientBookEntity queryObject(Long id);
	
	List<ClientBookEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(ClientBookEntity clientBook);
	
	void update(ClientBookEntity clientBook);
	
	void delete(Long id);
	
	void deleteBatch(Long[] ids);
}
