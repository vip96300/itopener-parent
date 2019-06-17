package com.itopener.tools.generator;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class AuthorityTest {

	
	@Test
	public void init(){
		try {
			Config config = new Config();
			config.setAuthor("fuwei.deng");
			config.setBasePackageModel("com.itopener.authority.model");
			config.setBasePackageMapper("com.itopener.authority.mapper");
			config.setBasePackageDao("com.itopener.authority.dao");
			config.setBasePackageCondition("com.itopener.authority.conditions");
//			config.setImplementsInterface("BaseCondition");
			config.setBaseDao("com.itopener.framework.base.BaseDao");
			config.setBasePath("D:\\workspace-neon\\itopener-authority\\authority-parent\\authority-model/src/main/java/");
			config.setDriver("com.mysql.jdbc.Driver");
			config.setUrl("jdbc:mysql://127.0.0.1:3306/authority?useUnicode=true&characterEncoding=utf8&autoReconnect=true");
			config.setPassword("root");
			config.setUser("root");
			config.setTables("t_app,t_menu,t_role,t_user,t_role_menu,t_user_role");
			config.setTablePrefix("t_");
//		Map<String, String> mapperInsertKeyProperty = new HashMap<>();
//		mapperInsertKeyProperty.put("st_activity", "id");
//		config.setMapperInsertKeyProperty(mapperInsertKeyProperty);
//			config.setKeyProperty("id");
			
//			config.setExtendsModel("BaseConditionModel");
			config.setImplementsInterface("Serializable");
			config.getImports().add("java.io.Serializable");
			config.setGenerateSerialVersionUID(true);
			
//			config.setConditionInterface("BaseCondition");
//			config.getConditionImports().add("com.itopener.framework.base.BaseCondition");
			
			config.setExcludeColumns(new HashSet<String>());
//			config.getExcludeColumns().add("id");
			
			config.setUpdateExcludeColumns(new HashMap<String, Set<String>>());
			
			config.setWhereRangeColumns(new HashMap<String, Set<String>>());
//		config.getWhereRangeColumns().put("sys_dictionary", new HashSet<String>());
//		config.getWhereRangeColumns().get("sys_dictionary").add("create_time");
			
			config.setLikeColumns(new HashMap<String, Set<String>>());
//		config.getLikeColumns().put("st_activity", new HashSet<String>());
//		config.getLikeColumns().get("st_activity").add("title");
			
//		config.setWhereColumns(new HashMap<String, Set<String>>());
//		config.getWhereColumns().put("sys_dictionary", new HashSet<String>());
//		config.getWhereColumns().get("sys_dictionary").add("id");
			
			config.getBaseWhereColumns().add("id");
			config.getBaseWhereColumns().add("user_id");
			
		config.getBaseInsertExcludeColumns().add("id");
			
		config.getBaseUpdateExcludeColumns().add("create_user_id");
		config.getBaseUpdateExcludeColumns().add("create_user");
		config.getBaseUpdateExcludeColumns().add("create_time");
			
//		config.getBaseDeleteSetColumns().add("update_time");
//		config.getBaseDeleteSetColumns().add("update_user");
			
//		config.setFlagColumnName("is_valid");
//		config.setFlagInValidValue("1");
//		config.setFlagValidValue("0");
			
			long start = System.currentTimeMillis();
			new Generator().generate(config);
			System.out.println("use time :" + (System.currentTimeMillis() - start));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
