package cu.my.practice.kmp.core.model.character

data class CharacterDataModel(
    val id:Int,
    val name:String,
    val status:String,
    val location: LocationModel,
    //val data: DataModel,
    val image: String
)