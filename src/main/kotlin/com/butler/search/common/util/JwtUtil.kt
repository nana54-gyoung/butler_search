package com.butler.search.common.util

import io.jsonwebtoken.Jwts


class JwtUtil {
    companion object {
        private val SECRET_KEY =
            "eyJhbGciOiJIUzUxMiJ9eyJtZW1iZXJJbmZvIjp7Im1ibm8iOjIsInVzZXJJZCI6ImFiZDJldm9sIiwicGFzc3dvcmQiOiIxMjM0NTYiLCJuYW1lIjoi6rSA7JqwIiwicmVnTm8iOiI2ODExMDgtMTU4MjgxNiJ9fQRf9XsREiE0d9kIOUMYlWv1smL698JN5CXhDCUW2ebrYIcUtz"

        fun extractMbno(token: String): Int {
            return Jwts
                .parser()
                .setSigningKey(SECRET_KEY)
                .parseClaimsJws(token)
                .body
                .get("mbno").toString().toInt()
        }

        fun extractAuthorities(token: String): List<String> {
            val res = Jwts
                .parser()
                .setSigningKey(SECRET_KEY)
                .parseClaimsJws(token)
                .body
                .get("role").toString()
            return listOf(res)
        }

    }
}