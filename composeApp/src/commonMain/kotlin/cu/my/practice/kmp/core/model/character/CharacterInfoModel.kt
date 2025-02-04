package cu.my.practice.kmp.core.model.character

data class CharacterInfoModel(
    val count: Int,
    val pages: Int = 42,
    val next: String? = null,
    val prev: String? = null
)