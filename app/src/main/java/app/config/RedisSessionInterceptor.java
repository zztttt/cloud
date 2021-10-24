package app.config;

import app.utils.msgutils.Msg;
import app.utils.msgutils.MsgCode;
import app.utils.msgutils.MsgUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Slf4j
@Component
public class RedisSessionInterceptor implements HandlerInterceptor {
    private final StringRedisTemplate redisTemplate;

    @Autowired
    public RedisSessionInterceptor(StringRedisTemplate redisTemplate){
        this.redisTemplate = redisTemplate;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception{
        log.info("preHandle. session id: {}", request.getSession().getId());
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");
        if(username != null){
            String loginSessionId = redisTemplate.opsForValue().get(String.format("username:%s", username));
            if(loginSessionId != null && loginSessionId.equals(session.getId())){
                // success
                return true;
            }else if(loginSessionId != null && !loginSessionId.equals(session.getId())){
                log.info("id mismatch, session invalidate: {}", session.getId());
            }
        }else{
            log.info("please login");
        }
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        Msg msg = MsgUtil.makeMsg(MsgCode.LOGIN_SESSION_EXPIRE);
        response.getWriter().print(JSON.toJSON(msg).toString());
        return false;
    }

    private void response401(HttpServletResponse response) throws Exception{

        Msg msg =  MsgUtil.makeMsg(MsgCode.LOGIN_USER_ERROR);
        String json = JSON.toJSON(msg).toString();
        response.getWriter().print(json);
    }

}
