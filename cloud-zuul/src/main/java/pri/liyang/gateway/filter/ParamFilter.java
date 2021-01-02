package pri.liyang.gateway.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class ParamFilter extends ZuulFilter {

    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext currentContext = RequestContext.getCurrentContext();
        HttpServletRequest request = currentContext.getRequest();
        String requestURI = request.getRequestURI();

        // 后台打印查看Zuul网关过滤器拦截到的请求信息
        System.out.println("Zuul Filter生效，当前请求URI为【" + requestURI + "】, 请求方法为【" + request.getMethod() + "】");

        // 对以下接口的参数进行校验，如果有错误，不往下执行，ZuulFilter直接返回错误提示信息
        if ("/consumer/consume/customError".equals(requestURI)) {
            String errorProbability = request.getParameter("errorProbability");
            boolean isParamValid = true;
            String errorMessage = "";

            if (errorProbability != null && !"".equals(errorProbability.trim())) {
                try {
                    errorProbability = errorProbability.trim();
                    Double probability = Double.parseDouble(errorProbability);
                    if (probability > 1 || probability < 0) {
                        isParamValid = false;
                        errorMessage = "From zuul filter: probability must between 0 and 1, your probability is " + errorProbability;
                    }
                } catch (NumberFormatException nfe) {
                    isParamValid = false;
                    errorMessage = "From zuul filter: cannot convert probability to double value, error message: " + nfe;
                } catch (Exception e) {
                    isParamValid = false;
                    errorMessage = "From zuul filter: exception occurred, error message: " + e;
                }

                if (!isParamValid) {
                    // 不会继续往下执行，不会去调用服务接口，网关服务直接响应给客户端
                    currentContext.setSendZuulResponse(false);
                    currentContext.setResponseBody(errorMessage);
                    currentContext.setResponseStatusCode(400);
                }
            } else {
                currentContext.setSendZuulResponse(false);
                currentContext.setResponseBody("From zuul filter: cannot get errorProbability parameter value, maybe your param key is wrong or missing! current obtained value: " + errorProbability);
                currentContext.setResponseStatusCode(400);
            }
        }

        return null;
    }

}
