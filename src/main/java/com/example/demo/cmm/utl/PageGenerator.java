package com.example.demo.cmm.utl;
import static com.example.demo.cmm.utl.Util.*;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import com.example.demo.cmm.enm.Sql;
import com.example.demo.uss.service.StudentMapper;

import lombok.Data;

@Component("page") @Data @Lazy
public class PageGenerator {
	@Autowired StudentMapper studentMapper;
	private int rowCount, startRow, endRow,
				pageCount, pageSize, startPage, endPage, pageNum,
				blockCount, blockSize, prevBlock, nextBlock;
	
	public final int BLCOK_SIZE = 5;
	
	public int totalCount(String tableName) {
		var map = new HashMap<String, String>();
		map.put("COUNT", Sql.COUNT.toString()+tableName);
		return studentMapper.count(map);
	}
}
