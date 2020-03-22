import java.util.Scanner

fun main(args: Array<String>) {
    val input = Scanner(System.`in`)
    val country1 = input.next()
    val country2 = input.next()
    println(Country.findByName(country1).currency == Country.findByName(country2).currency)
}

enum class Country(val countryName: String, val currency: Currency) {
    GERMANY("Germany", Currency.EURO),
    MALI("Mali", Currency.CFA_FRANC),
    DOMINICA("Dominica", Currency.EASTERN_CARIBBEAN_DOLLAR),
    CANADA("Canada", Currency.CANADIAN_DOLLAR),
    SPAIN("Spain", Currency.EURO),
    AUSTRALIA("Australia", Currency.AUSTRALIAN_DOLLAR),
    BRAZIL("Brazil", Currency.BRAZILIAN_REAL),
    SENEGAL("Senegal", Currency.CFA_FRANC),
    FRANCE("France", Currency.EURO),
    GRENADA("Grenada", Currency.EASTERN_CARIBBEAN_DOLLAR),
    KIRIBATI("Kiribati", Currency.AUSTRALIAN_DOLLAR),
    NULL("", Currency.NULL);

    companion object {
        fun findByName(countryName: String): Country {
            for (country in Country.values()) {
                if (countryName == country.countryName) return country
            }
            return NULL
        }
    }
}

enum class Currency {
    EURO,
    CFA_FRANC,
    EASTERN_CARIBBEAN_DOLLAR,
    CANADIAN_DOLLAR,
    AUSTRALIAN_DOLLAR,
    BRAZILIAN_REAL,
    NULL
}