package com.trackmybucketlist.filter

import javax.servlet.*

public class FilterChainProxy implements Filter
{
    private List<Filter> filters

    public void setFilters(List<Filter> filters) {
        this.filters = filters
    }

    public void init(FilterConfig filterConfig) throws ServletException {
        for(Filter filter : filters) {
            filter.init(filterConfig)
        }
    }

    public void destroy() {
        for(Filter filter : filters) {
            filter.destroy()
        }
    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        VirtualFilterChain virtualFilterChain = new VirtualFilterChain(filters, filterChain)
        virtualFilterChain.doFilter(servletRequest, servletResponse)
    }

    private class VirtualFilterChain implements FilterChain {
        private List<Filter> filters
        private FilterChain chain
        private int currentPosition = 0

        private VirtualFilterChain() {
        }

        public VirtualFilterChain(List<Filter> filters, FilterChain chain) {
            this.filters = filters
            this.chain = chain
        }

        public void doFilter(ServletRequest request, ServletResponse response) throws IOException, ServletException {
            if(currentPosition == filters.size()) {
                chain.doFilter(request, response)
            }
            else {
                currentPosition++
                filters.get(currentPosition - 1).doFilter(request, response, this)
            }
        }
    }
}

