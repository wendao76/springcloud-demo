package com.github.wendao76.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.exception.ZuulException;

/**
 * token过滤器
 * @author wendao76
 */
public class TokenFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return "PRE";
    }

    @Override
    public int filterOrder() {
        return -3;
    }

    @Override
    public boolean shouldFilter() {
        System.out.println("shouldFilter");
        return false;
    }

    @Override
    public Object run() throws ZuulException {
        return null;
    }
}
