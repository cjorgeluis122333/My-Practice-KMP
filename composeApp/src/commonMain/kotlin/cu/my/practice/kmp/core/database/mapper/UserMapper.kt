package cu.my.practice.kmp.core.database.mapper

import cu.my.practice.kmp.core.database.entity.UserEntity
import cu.my.practice.kmp.core.model.user.UserModel

fun UserEntity.toModel() = UserModel(
    name = name,
    password = password
)

fun UserModel.toEntity() = UserEntity(
    name = name,
    password = password
)