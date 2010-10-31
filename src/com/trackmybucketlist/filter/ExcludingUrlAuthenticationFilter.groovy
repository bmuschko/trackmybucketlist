package com.trackmybucketlist.filter

import com.trackmybucketlist.util.WebAppUtils
import javax.servlet.http.HttpServletRequest
import javax.servlet.*

class ExcludingUrlAuthenticationFilter extends FilterChainProxy {
    private List<String> excludedUrls

    def void init(FilterConfig filterConfig) {
        excludedUrls = []
        excludedUrls << "/favicon.ico*"
        excludedUrls << "/js/*"
        excludedUrls << "/css/*"
        excludedUrls << "/images/*"
        excludedUrls << "/_ah/*" // Google's user authentication URLs

        setFilters([new AuthenticationFilter()])
        super.init(filterConfig)
    }

    def void destroy() {
        super.destroy()
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest)servletRequest
        String url = WebAppUtils.getPathWithinApplication(httpServletRequest)

        if(WebAppUtils.matchesUrls(excludedUrls, url)) {
            // Exclude filters
            filterChain.doFilter(servletRequest, servletResponse)
        }
        else {
            // Run the filter chain
            super.doFilter(servletRequest, servletResponse, filterChain)
        }
    }
}
