package com.itopener.tools.zookeeper.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.curator.framework.CuratorFramework;
import org.apache.zookeeper.KeeperException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itopener.framework.ResultMap;
import com.itopener.tools.zookeeper.config.ToolsZookeeperConstants;
import com.itopener.tools.zookeeper.vo.ZookeeperInfo;

/**
 * @author fuwei.deng
 * @date 2017年12月5日 下午4:19:05
 * @version 1.0.0
 */
@RestController
@RequestMapping("zk")
public class ZookeeperController {
	
	private final Logger logger = LoggerFactory.getLogger(ZookeeperController.class);
	
	@Resource
	private HttpServletRequest request;
	
	@Resource
	private CuratorFramework curatorFramework;
	
	private static final String SLASH = "/";
	
	@GetMapping("index")
	public ResultMap index() {
		String namespace = (String) request.getSession().getAttribute(ToolsZookeeperConstants.SESSION_CURR_NAMESPACE_KEY);
		return ResultMap.buildSuccess().put("namespace", namespace);
	}
	
	@GetMapping("home")
	public ResultMap home() {
		return ResultMap.buildSuccess();
	}
	
	@PutMapping("namespace/{namespace}")
	public ResultMap namespace(@PathVariable String namespace) {
		request.getSession().setAttribute(ToolsZookeeperConstants.SESSION_CURR_NAMESPACE_KEY, namespace);
		return ResultMap.buildSuccess();
	}
	
	@DeleteMapping("namespace")
	public ResultMap clearNamespace() {
		request.getSession().removeAttribute(ToolsZookeeperConstants.SESSION_CURR_NAMESPACE_KEY);
		return ResultMap.buildSuccess();
	}
	
	private CuratorFramework getCuratorFramework() {
		return curatorFramework.usingNamespace(getNamespace());
	}
	
	private String getNamespace() {
		String namespace = (String) request.getSession().getAttribute(ToolsZookeeperConstants.SESSION_CURR_NAMESPACE_KEY);
		return namespace == null ? "" : namespace;
	}
	
	@GetMapping("nodes/root")
	public ResultMap nodes() {
		try {
			List<String> nodes = getCuratorFramework().getChildren().forPath(SLASH);
			return ResultMap.buildSuccess().put("nodes", nodes);
		} catch (Exception e) {
			logger.error("get root of [" + getNamespace() + "] occured exception", e);
			return ResultMap.buildFailed("获取根节点出现异常");
		}
	}
	
	@GetMapping("children/{node}")
	public ResultMap children(@PathVariable String node) {
		StringBuilder nodePath = new StringBuilder();
		String[] nodeArr = node.split(",");
		for(String item : nodeArr) {
			if(StringUtils.isEmpty(item)) {
				nodePath.append("");
			} else {
				nodePath.append(nodePath.length() > 0 ? SLASH : "").append(item);
			}
		}
		
		String nodeData = null;
		try {
			byte[] dataBytes = getCuratorFramework().getData().forPath(SLASH + nodePath.toString());
			if(dataBytes != null) {
				nodeData = new String(dataBytes);
			}
		} catch (KeeperException.NoNodeException e) {
			logger.info("no data of [" + node + "]");
		} catch (Exception e) {
			logger.error("get data of [" + node + "] occured exception", e);
		}
		
		List<String> nodes = null;
		try {
			nodes = getCuratorFramework().getChildren().forPath(SLASH + nodePath.toString());
		} catch (KeeperException.NoNodeException e) {
			logger.info("no children of [" + node + "]");
		} catch (Exception e) {
			logger.error("get children of [" + node + "] occured exception", e);
		}
		return ResultMap.buildSuccess().put("nodePath", SLASH + nodePath.toString()).put("nodes", nodes).put("nodeData", nodeData);
	}
	
	@PostMapping("node")
	public ResultMap save(String nodePath, String nodeData) {
		if(StringUtils.isEmpty(nodePath)) {
			return ResultMap.buildFailed("节点不能为空");
		}
		if(!nodePath.startsWith(SLASH)) {
			nodePath = SLASH + nodePath;
		}
		try {
			getCuratorFramework().createContainers(nodePath);
			getCuratorFramework().setData().forPath(nodePath, nodeData.getBytes());
		} catch (Exception e) {
			logger.error("save data occured exception", e);
			return ResultMap.buildFailed("保存数据出现异常");
		}
		return ResultMap.buildSuccess();
	}
	
	@PostMapping("node/delete")
	public ResultMap delete(String nodePath) {
		if(StringUtils.isEmpty(nodePath)) {
			return ResultMap.buildFailed("节点不能为空");
		}
		if(!nodePath.startsWith(SLASH)) {
			nodePath = SLASH + nodePath;
		}
		try {
			delete(nodePath, null);
		} catch (Exception e) {
			logger.error("delete node occured exception", e);
			return ResultMap.buildFailed("删除节点出现异常");
		}
		return ResultMap.buildSuccess();
	}
	
	/**
	 * @description 递归删除节点及其子节点
	 * @author fuwei.deng
	 * @date 2017年12月6日 下午5:44:40
	 * @version 1.0.0
	 * @param nodePath
	 * @param nodes
	 * @throws Exception
	 */
	private void delete(String nodePath, List<String> nodes) throws Exception {
		if(CollectionUtils.isEmpty(nodes)) {
			nodes = getCuratorFramework().getChildren().forPath(nodePath);
			if(CollectionUtils.isEmpty(nodes)) {
				return ;
			}
		}
		for(String item : nodes) {
			String nodePathTemp = nodePath + SLASH + item;
			List<String> children = getCuratorFramework().getChildren().forPath(nodePathTemp);
			if(CollectionUtils.isEmpty(children)) {
				getCuratorFramework().delete().forPath(nodePathTemp);
			} else {
				delete(nodePathTemp, children);
			}
		}
		getCuratorFramework().delete().forPath(nodePath);
	}
	
	@GetMapping("info")
	public ResultMap info() {
		ZookeeperInfo info = new ZookeeperInfo();
		info.setConnectionTimeoutMs(getCuratorFramework().getZookeeperClient().getConnectionTimeoutMs());
		info.setCurrentConnectionString(getCuratorFramework().getZookeeperClient().getCurrentConnectionString());
		info.setInstanceIndex(getCuratorFramework().getZookeeperClient().getInstanceIndex());
		return ResultMap.buildSuccess().put("info", info);
	}
}
