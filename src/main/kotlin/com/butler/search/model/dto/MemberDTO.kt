package com.butler.search.model.dto

import com.butler.search.common.converter.MemberRoleConverter
import com.butler.search.model.enums.MEMBER_ROLE
import jakarta.persistence.Convert
import java.time.LocalDateTime

data class MemberDTO(
    var mbno : Int? = null,
    @Convert(converter = MemberRoleConverter::class) var role : MEMBER_ROLE? = null,
    var id : String? = null,
    var tel : String? = null,
    var password : String? = null,
    var regdt : LocalDateTime? = LocalDateTime.now()
)
