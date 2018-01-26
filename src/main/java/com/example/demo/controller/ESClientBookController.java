package com.example.demo.controller;

import com.example.demo.entity.ClientBookEntity;
import com.example.demo.service.ClientBookService;
import com.example.demo.utils.PageUtils;
import com.example.demo.utils.Query;
import com.example.demo.utils.R;
import org.apache.ibatis.annotations.Delete;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * 书籍控制器
 * 主要目的 实现elasticsearch的查询功能演练
 * Created by Alex on 2018/1/25.
 */
@RestController
@RequestMapping("/esbook")
public class ESClientBookController {
    @Autowired
    private ClientBookService clientBookService;
    /**
     * 注入es操作对象
     */
    @Autowired
    private TransportClient client;

    // TODO: 2018/1/26 http://127.0.0.1:9200/esbook/get/1
    @GetMapping(value = "/get/{id}")
    public R get(@PathVariable("id") Integer id) {

        GetResponse result = client.prepareGet("client", "book", id.toString()).get();
        if (!result.isExists()) {
            return R.ok("没有符合条件的数据哦");
        }
        return R.ok(result.getSource());
    }

    /**
     * 列表
     */
    @RequestMapping("/list")
//    @RequiresPermissions("clientbook:list")
    public R list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);

        List<ClientBookEntity> clientBookList = clientBookService.queryList(query);
        int total = clientBookService.queryTotal(query);

        PageUtils pageUtil = new PageUtils(clientBookList, total, query.getLimit(), query.getPage());

        return R.ok().put("page", pageUtil);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
//    @RequiresPermissions("clientbook:info")
    public R info(@PathVariable("id") Long id) {
        ClientBookEntity clientBook = clientBookService.queryObject(id);

        return R.ok().put("clientBook", clientBook);
    }

    /**
     * 保存
     *headers :Content-Type:application/json
     *
     *post 127.0.0.1:8080/esbook/save
     * {
     "name":"大话设计模式4",
     "author":"老司机",
     "typeworks":2,
     "typework":4,
     "workscount":10000,
     "store":22,
     "state":1
     }
     *
     *
     *
     */
    @PostMapping("/save")
//    @RequiresPermissions("clientbook:save")
    public R save(@RequestBody ClientBookEntity clientBook) {
        clientBookService.save(clientBook);
        return R.ok(clientBook.getId().toString());
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
//    @RequiresPermissions("clientbook:update")
    public R update(@RequestBody ClientBookEntity clientBook) {
        clientBookService.update(clientBook);
        return R.ok();
    }
    // TODO: 2018/1/26  delete 127.0.0.1:8080/esbook/delete?id=8
    /**RequestMapping =Get传参方式
     * 删除
     */
    @DeleteMapping("/delete")
//    @RequiresPermissions("clientbook:delete")
    public R delete(Long id) {
        clientBookService.delete(id);
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/deletes")
//    @RequiresPermissions("clientbook:delete")
    public R deletes(@RequestBody Long[] ids) {
        clientBookService.deleteBatch(ids);

        return R.ok();
    }


}
