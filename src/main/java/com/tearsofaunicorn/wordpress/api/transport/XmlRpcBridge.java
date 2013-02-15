package com.tearsofaunicorn.wordpress.api.transport;

import java.util.Map;

import org.apache.xmlrpc.XmlRpcException;
import org.apache.xmlrpc.client.XmlRpcClient;
import org.apache.xmlrpc.client.XmlRpcClientConfigImpl;

import com.tearsofaunicorn.wordpress.api.WordpressClientConfig;

public class XmlRpcBridge {

	private final static String TAXONOMY_CATEGORY = "category";
	private final static String TAXONOMY_TAG = "post_tag";

	private final WordpressClientConfig config;
	private XmlRpcClient client;

	public XmlRpcBridge(WordpressClientConfig config) {
		if (config == null) {
			throw new IllegalArgumentException("config must not be null");
		}

		this.config = config;
		initClient();
	}

	private void initClient() {
		this.client = new XmlRpcClient();

		XmlRpcClientConfigImpl xmlrpcConfig = new XmlRpcClientConfigImpl();
		xmlrpcConfig.setServerURL(this.config.getUrl());
		this.client.setConfig(xmlrpcConfig);
	}

	public String newPost(Map<String, Object> post) throws XmlRpcException {
		Object[] params = new Object[] { this.config.getBlogId(), this.config.getUserName(), this.config.getPassword(),
				post };
		return (String) this.client.execute("wp.newPost", params);
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> getPostTypes() throws XmlRpcException {
		Object[] params = new Object[] { this.config.getBlogId(), this.config.getUserName(), this.config.getPassword() };
		return (Map<String, Object>) this.client.execute("wp.getPostTypes", params);
	}

	public Object[] getCategories() throws XmlRpcException {
		return getTerms(XmlRpcBridge.TAXONOMY_CATEGORY);
	}

	public Object[] getTags() throws XmlRpcException {
		return getTerms(XmlRpcBridge.TAXONOMY_TAG);
	}

	private Object[] getTerms(String taxonomy) throws XmlRpcException {
		Object[] params = new Object[] { this.config.getBlogId(), this.config.getUserName(), this.config.getPassword(),
				taxonomy };
		return (Object[]) this.client.execute("wp.getTerms", params);
	}

}
