package si.kflabs.mojpanj.data.domain

import java.time.Month

enum class BeeTaskMonth(
    val title: String,
) {
    JANUARY("Januar"),
    FEBRUARY("Februar"),
    MARCH("Marec"),
    APRIL("April"),
    MAY("Maj"),
    JUNE("Junij"),
    JULY("Julij"),
    AUGUST("Avgust"),
    SEPTEMBER("September"),
    OCTOBER("Oktober"),
    NOVEMBER("November"),
    DECEMBER("December");

    val tasks: List<BeeTask>
        get() {
            return when(this) {
                JANUARY -> listOf(
                    BeeTask("Pluženje snega", "Okoli čebelnjaka pospravimo sneg in omogočimo dostop do vrat."),
                    // itd.
                )
                FEBRUARY -> listOf(
                    BeeTask("Pluženje snega", "Okoli čebelnjaka pospravimo sneg in omogočimo dostop do vrat."),
                    // itd.
                )
                MARCH -> listOf(
                    BeeTask("Pluženje snega", "Okoli čebelnjaka pospravimo sneg in omogočimo dostop do vrat."),
                    // itd.
                )
                APRIL -> listOf(
                    BeeTask("Pluženje snega", "Okoli čebelnjaka pospravimo sneg in omogočimo dostop do vrat."),
                    // itd.
                )
                MAY -> listOf(
                    BeeTask("Pluženje snega", "Okoli čebelnjaka pospravimo sneg in omogočimo dostop do vrat."),
                    // itd.
                )
                JUNE -> listOf(
                    BeeTask("Pluženje snega", "Okoli čebelnjaka pospravimo sneg in omogočimo dostop do vrat."),
                    // itd.
                )
                JULY -> listOf(
                    BeeTask("Pluženje snega", "Okoli čebelnjaka pospravimo sneg in omogočimo dostop do vrat."),
                    // itd.
                )
                AUGUST -> listOf(
                    BeeTask("Pluženje snega", "Okoli čebelnjaka pospravimo sneg in omogočimo dostop do vrat."),
                    // itd.
                )
                SEPTEMBER -> listOf(
                    BeeTask("Pluženje snega", "Okoli čebelnjaka pospravimo sneg in omogočimo dostop do vrat."),
                    // itd.
                )
                OCTOBER -> listOf(
                    BeeTask("Pluženje snega", "Okoli čebelnjaka pospravimo sneg in omogočimo dostop do vrat."),
                    // itd.
                )
                NOVEMBER -> listOf(
                    BeeTask("Pluženje snega", "Okoli čebelnjaka pospravimo sneg in omogočimo dostop do vrat."),
                    // itd.
                )
                DECEMBER -> listOf(
                    BeeTask("Pluženje snega", "Okoli čebelnjaka pospravimo sneg in omogočimo dostop do vrat."),
                    // itd.
                )
            }
        }
}