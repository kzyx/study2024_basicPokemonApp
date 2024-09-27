data class GetPokemonByIdResponse(
    val height: Int,
    val held_items: List<Any?>,
    val id: Int,
    val name: String,
    val sprites: Sprites,
    val types: List<TypeWrapper>,
    val weight: Int
)