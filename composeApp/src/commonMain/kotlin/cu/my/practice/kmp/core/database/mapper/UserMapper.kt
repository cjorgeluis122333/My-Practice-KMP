package cu.my.practice.kmp.core.database.mapper

import cu.my.practice.kmp.core.database.entity.UserEntity
import cu.my.practice.kmp.core.model.user.User
import cu.my.practice.kmp.core.model.user.UserModel
import cu.my.practice.kmp.core.network.response.UserResponse

fun UserEntity.toModel() = UserModel(
    name = name,
    password = password
)

fun UserModel.toEntity() = UserEntity(
    name = name,
    password = password
)


fun UserResponse.toModel(): User = User(
    username = username,
    email = email,
    lastName = lastName
)


fun User.toNetwork(): UserResponse = UserResponse(
    username = username,
    email = email,
    lastName = lastName
)