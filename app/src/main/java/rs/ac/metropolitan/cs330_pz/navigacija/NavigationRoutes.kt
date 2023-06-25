package rs.ac.metropolitan.cs330_pz.navigacija

sealed class NavigationRoutes(val route: String) {
    object Home : NavigationRoutes("home")
    object PocetniScreen: NavigationRoutes("pocetna")
    object RegistrationScreen:NavigationRoutes("registracija")
    object ProizvodiScreen:NavigationRoutes("proizvodi")
    object KontaktScreen:NavigationRoutes("kontakt")
    object NarucivanjeScreen:NavigationRoutes("narucivanje")

    object PcelarListPage:NavigationRoutes("lista")

    object PcelarDetailScreen:NavigationRoutes(route="detail/{elementId}")
    fun createRoute(elementId: String) = "detail/$elementId"

}