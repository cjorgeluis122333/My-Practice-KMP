package cu.my.practice.kmp.core.model.establishment


data class Review(
    val user: String,
    val message: String,
    val rating: Float,
    val date: String,
    val userValidate: Boolean = false,
    val serviceName: String?,
    val answers: List<Answer>,
) 