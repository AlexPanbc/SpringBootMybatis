package com.example.demo.service.impl;

import com.example.demo.dao.ClientBookDao;
import com.example.demo.entity.ClientBookEntity;
import com.example.demo.service.ClientBookService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.xcontent.XContentFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Transient;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;


@Service("clientBookService")
public class ClientBookServiceImpl implements ClientBookService {
    @Autowired
    private ClientBookDao clientBookDao;
    @Autowired
    private TransportClient client;
    String index = "client";
    String type = "book";

    @Override
    public ClientBookEntity queryObject(Long id) {
        return clientBookDao.queryObject(id);
    }

    @Override
    public List<ClientBookEntity> queryList(Map<String, Object> map) {
        return clientBookDao.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return clientBookDao.queryTotal(map);
    }

    @Transient
    @Override
    public void save(ClientBookEntity clientBook) {
        clientBook.setId(System.currentTimeMillis());
        clientBook.setCreatedate(new Date());
        clientBook.setUpdatedate(new Date());
        clientBookDao.save(clientBook);
        System.out.println(clientBook.getCreatedate());
        System.out.println(clientBook.getUpdatedate());
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            client.prepareIndex(index, type, clientBook.getId().toString()).setSource(objectMapper.writeValueAsString(clientBook)).execute().actionGet();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void update(ClientBookEntity clientBook) {
        clientBook.setUpdatedate(new Date());
        clientBookDao.update(clientBook);

    }

    @Transient
    @Override
    public void delete(Long id) {
        clientBookDao.delete(id);
        client.prepareDelete(index,type,id.toString()).get();
    }

    @Override
    public void deleteBatch(Long[] ids) {
        clientBookDao.deleteBatch(ids);
    }

}
