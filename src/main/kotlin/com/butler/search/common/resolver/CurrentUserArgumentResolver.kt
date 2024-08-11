package com.butler.search.common.resolver

import com.butler.search.common.annotation.CurrentUser
import com.butler.search.common.util.JwtUtil
import com.butler.search.model.dto.MemberDTO
import jakarta.servlet.http.HttpServletRequest
import org.springframework.core.MethodParameter
import org.springframework.stereotype.Component
import org.springframework.web.bind.support.WebDataBinderFactory
import org.springframework.web.context.request.NativeWebRequest
import org.springframework.web.method.support.HandlerMethodArgumentResolver
import org.springframework.web.method.support.ModelAndViewContainer

@Component
class CurrentUserArgumentResolver : HandlerMethodArgumentResolver {
    override fun supportsParameter(parameter: MethodParameter): Boolean {
        return parameter.hasParameterAnnotation(CurrentUser::class.java)
    }
    override fun resolveArgument(parameter: MethodParameter, mavContainer: ModelAndViewContainer?, webRequest: NativeWebRequest, binderFactory: WebDataBinderFactory?): Any? {
        val request = webRequest.getNativeRequest(HttpServletRequest::class.java)
        val token = request?.getHeader("Authorization")?.substring("Bearer ".length)
        if (token != null) {
            return MemberDTO(mbno = JwtUtil.extractMbno(token))
        }
        return null
    }
}