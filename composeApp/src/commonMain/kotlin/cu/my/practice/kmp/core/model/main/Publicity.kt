package cu.my.practice.kmp.core.model.main


data class Publicity(
    val id: Int,
    val title: String = "",
    val photo: String? = null,
    val municipality: Int = 0,
    val scopeId: Int = 0,
    val stateId: Int = 0,
    val description: String? = null,
    val userId: String = "",
    val formatID: Int = 1,
    val priorityId: Int = 0,
    val priority: PriorityM = PriorityM(0, "", ""),
    val publicityScope: PublicityScope = PublicityScope(0, "", ""),
    val link: String? = null,
)
