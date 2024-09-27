data class GetAllPokemonResponse(
    val count: Int,
    val next: String,
    val previous: Any,
    val results: List<BasicPokemonInfo>
)